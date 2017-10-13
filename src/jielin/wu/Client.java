package jielin.wu;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jielin.wu.bo.LogData;
import jielin.wu.bo.LogRec;
import jielin.wu.util.IOUtil;

/**
 * 客户端应用程序。作用是定期读取系统日志文件wpmpx文件，收集每个用户的登入 登出日志。将匹配成对的日志信息发送给服务器。
 * 
 * @author wu.jielin
 *
 */
public class Client {
	// wtmpx文件
	private File logFile;
	// 保存每次解析后的日志文件
	private File textLogFile;
	// 保存每次解析日志文件后的位置（书签）的文件
	private File lastPositionFile;
	// 每次从wtmpx中解析日志的条数
	private int batch;
	// 保存每次匹配成功后的所有日志
	private File logRecFile;
	// 包尺寸没有匹配成功的所有日志
	private File loginFile;

	/**
	 * 构造方法
	 */
	public Client() {
		try {
			this.batch = 10;
			logFile = new File("wtmpx");
			lastPositionFile = new File("last-position.txt");
			textLogFile = new File("log.txt");
			logRecFile = new File("logrec.txt");
			loginFile = new File("login.txt");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 检查是否有新数据读取，并返回读取的开始位置（-1没有有新数据）
	 * 
	 * @return
	 */
	public long hasLogs() {
		try {
			long lastposition = 0;
			/**
			 * 两种情况 1 没有找到last-position.txt文件，说明还没有读过 2 有，就从该文件记录位置读取
			 */
			if (lastPositionFile.exists()) {
				// 添加读写类
				lastposition = IOUtil.readLong(lastPositionFile);
			}
			/**
			 * wtmpx的总大小减去这次准备开始读取的位置，应当大于一条日志的大小
			 */
			if (logFile.length() - lastposition < 372) {
				lastposition = -1;
			}

			return lastposition;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 判断当前RandomaccessFile读取的位置是否在wtmpx文件中还有内容可读
	 * 
	 * @return
	 */
	public boolean hasLogsByStep(RandomAccessFile raf) throws IOException {
		if (logFile.length() - raf.getFilePointer() >= 372) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 第一大步，从wtmpx文件中读取batch条日志，并解析成batch行字符串， 每行字符串表示一条日志。然后写入log.txt文件中
	 * 
	 * @return true 成功 false 解析失败
	 */
	public boolean readNextLogs() {
		/**
		 * 解析步骤： 1 判断其是否存在 2 判断是否还有新数据可读 3 从上一次读取的位置开始继续读取 4
		 * 循环batch次读取batch个372字节，并转换为batch个日志 5 将解析后的batch个日志写入log.txt
		 */
		if (!logFile.exists()) {
			return false;
		}

		// 2
		long lastposition = hasLogs();
		if (lastposition < 0) {
			return false;
		}
		/**
		 * 
		 * 为了避免重复执行第一步，导致原来第一步已经解析的日志文件被废弃。
		 * 我们先判断，若第一步执行完毕后生成的log.txt文件存在就不再执行第一步了。 该文件会在第二部执行完毕后删除
		 */
		if (textLogFile.exists())
			return true;

		try {
			// 创建RandomAccessFile来读取日志文件
			RandomAccessFile raf = new RandomAccessFile(logFile, "r");// read-only
			// 移动游标到指定位置。开始读取,note:seek depends on the beginning of the file
			raf.seek(lastposition);
			/**
			 * 创建集合保存解析后的日志
			 */
			List<LogData> logs = new ArrayList<LogData>();

			// 循环batch次，解析batch条日志
			for (int i = 0; i < batch; i++) {
				// 判断是否还有日志可以读
				if (!hasLogsByStep(raf)) {
					break;
				}
				// 读取用户名
				String user = IOUtil.readString(raf, LogData.USER_LENGTH);
				System.out.println("***");
				// 读取pid
				raf.seek(lastposition + LogData.PID_OFFSET);
				int pid = IOUtil.readInt(raf);

				// 读取type
				raf.seek(lastposition + LogData.TYPE_OFFSET);
				short type = IOUtil.readShort(raf);

				// 读取time
				raf.seek(lastposition + LogData.TIME_OFFSET);
				int time = IOUtil.readInt(raf);

				// 读取ip
				raf.seek(lastposition + LogData.HOST_OFFSET);
				String ip = IOUtil.readString(raf, LogData.HOST_LENGTH);

				// 将lastposition设置为当前游标的位置
				lastposition = raf.getFilePointer();

				/**
				 * 将解析出来的数据存入一个LogData对象中，再将该对象存入集合中
				 */
				LogData log = new LogData(user, pid, type, time, ip);
				logs.add(log);
			}
			// 测试
			// System.out.println("共解析了"+logs.size()+"条日志");
			// for (Iterator iterator = logs.iterator(); iterator.hasNext(); ) {
			// LogData logData = (LogData) iterator.next();
			// System.out.println(logData);
			// }
			/**
			 * 将解析后的日志写入log.txt文件中
			 */
			IOUtil.saveList(logs, textLogFile);
			/**
			 * 将这次解析后RandomAccessFile的游标位置进行记录，以便下次读取
			 */
			IOUtil.saveLong(lastposition, lastPositionFile);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 第二大步：匹配日志 1：读取log.txt文件。将第一步解析出的日志读取出来，并转换为若干LogData对象， 存入list集合中，等待配对
	 * 2：读取login.txt文件，将上一次没有配对成功的登入日志读取出来并转换为若干LogData对象， 也存入list中，等待这次配对
	 * 3：循环list将登入和登出日志分别存入到两个map中，value都是【user，pid，ip】这样格式的字符串
	 * 4：循环登出的map并通过key寻找登入map中的登入日志，达到配对目的， 将配对的日志转换为一个LogRec对象存入list集合中
	 * 5：将所有配对成功的日志写入文件logrec.txt,将所有没配对成功的日志写入文件login.txt
	 * 
	 * @return
	 */
	public boolean matchLogs() {
		/**
		 * 必要判断
		 */
		// 1 检查log.txt是否存在
		if (!textLogFile.exists()) {
			return false;
		}
		// 2
		/**
		 * 当第二步执行完毕，会生成两个文件，logrec.txt和login.txt
		 * 若第三步在执行时出现错误我们若从新执行第二步。会将上次第二部已经配对的日志覆盖。
		 * 表判断，若logrec文件存在，第二步就不再执行.第三步执行完毕后将其删除
		 */
		if (logRecFile.exists())
			return true;

		/**
		 * 业务逻辑
		 */
		try {
			// 1
			List<LogData> list = IOUtil.loadLogData(textLogFile);
			// 2
			if (loginFile.exists()) {
				list.addAll(IOUtil.loadLogData(loginFile));
			}
			// 3
			Map<String, LogData> loginMap = new HashMap<String, LogData>();
			Map<String, LogData> logoutMap = new HashMap<String, LogData>();
			for (Iterator<LogData> it = list.iterator(); it.hasNext();) {
				LogData log = it.next();
				if (log.getType() == LogData.TYPE_LOGIN) {
					putLogToMap(log, loginMap);
				} else {
					putLogToMap(log, logoutMap);
				}
			}
			// 4
			List<LogRec> logRecList = new ArrayList<LogRec>();
			Set<Entry<String, LogData>> set = logoutMap.entrySet();
			for (Entry<String, LogData> entry : set) {
				String key = entry.getKey();

				LogData login = loginMap.remove(key);

				if (login != null) {
					// 转为对象
					LogRec logrec = new LogRec(login, entry.getValue());
					logRecList.add(logrec);
				}
			}
			// 配对工作结束
			// 5
			IOUtil.saveList(logRecList, logRecFile);

			// 6
			Collection<LogData> c = loginMap.values();
			IOUtil.saveList(new ArrayList(c), loginFile);

			// 7
			textLogFile.delete();

			return true;
		} catch (Exception e) {
			// 如果报错了，又已经有了rec文件，则其无效需要删除,以便从新执行第二步
			if (logRecFile.exists())
				logRecFile.delete();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 将给定LogData存入map(private 方法不被内部调用会警告)
	 * 
	 * @param log
	 * @param map
	 */
	private void putLogToMap(LogData log, Map<String, LogData> map) {
		map.put(log.getUser() + "," + log.getPid() + "," + log.getIp(), log);
	}

	/**
	 * 第三步：将配对的日志发送给服务端 1 创建socket连接服务器 2 通过socket获取输出流，并包装为缓冲输出流。字符集定义为utf-8 3
	 * 创建缓冲字符输入流用于读取logrec.txt（读取配对日志） 4 从logrec.txt读取每一行日志信息并发送至客户端 5
	 * 通过socket获取输入流包装为缓冲输入流，用于读取客户端响应。 6
	 * 读取服务端的响应，若是ok则说明服务端成功接受了我们发送的日志。那么就将logrec.txt删除。
	 * 第三部执行完毕，若不是ok则发送没有成功，则该方法应返回false，应当重新尝试执行第三步。
	 * 
	 * @return
	 */
	public boolean sendLoToServer() {
		/**
		 * 必要判断
		 */
		if (!logRecFile.exists()) {
			return false;
		}

		/**
		 * 业务逻辑
		 */
		Socket socket=null;
		BufferedReader br=null;
		try {
			socket = new Socket("localhost", 8088);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			FileInputStream fis = new FileInputStream(logRecFile);
			br = new BufferedReader(new InputStreamReader(fis));// 不该转字符集
			/**
			 * 循环读取并通过socket写出
			 */
			String line = null;
			while ((line = br.readLine()) != null) {
				pw.println(line);
			}
			
			//结束标志
			pw.println("over");
			pw.flush();// 不要求及时性。因此最后flush就好
			br.close();// 还有流在读文件是删不掉的

			/**
			 * 读取服务端响应并判定事都发送成功
			 */
			InputStream in = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "utf-8"));
			String response = br.readLine();
			if ("ok".equals(response)) {// 避免空指针问题
				logRecFile.delete();
				return true;
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket!=null){
				try {
					socket.close();//关掉socket，尤其获取的流都会被关闭
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

	/**
	 * 开始方法
	 */
	public void start() {
		/**
		 * 循环以下三个步骤 1 从文件中一次解析batch条日志 2 将解析后的日志和上次没有匹配的日志一起匹配成对 3
		 * 将匹配成对的日志发送至客户端
		 */
		while(true){
		// 1
		readNextLogs();

		// 2
		matchLogs();

		// 3
		sendLoToServer();
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}

}
