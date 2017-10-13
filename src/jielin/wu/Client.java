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
 * �ͻ���Ӧ�ó��������Ƕ��ڶ�ȡϵͳ��־�ļ�wpmpx�ļ����ռ�ÿ���û��ĵ��� �ǳ���־����ƥ��ɶԵ���־��Ϣ���͸���������
 * 
 * @author wu.jielin
 *
 */
public class Client {
	// wtmpx�ļ�
	private File logFile;
	// ����ÿ�ν��������־�ļ�
	private File textLogFile;
	// ����ÿ�ν�����־�ļ����λ�ã���ǩ�����ļ�
	private File lastPositionFile;
	// ÿ�δ�wtmpx�н�����־������
	private int batch;
	// ����ÿ��ƥ��ɹ����������־
	private File logRecFile;
	// ���ߴ�û��ƥ��ɹ���������־
	private File loginFile;

	/**
	 * ���췽��
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
	 * ����Ƿ��������ݶ�ȡ�������ض�ȡ�Ŀ�ʼλ�ã�-1û���������ݣ�
	 * 
	 * @return
	 */
	public long hasLogs() {
		try {
			long lastposition = 0;
			/**
			 * ������� 1 û���ҵ�last-position.txt�ļ���˵����û�ж��� 2 �У��ʹӸ��ļ���¼λ�ö�ȡ
			 */
			if (lastPositionFile.exists()) {
				// ��Ӷ�д��
				lastposition = IOUtil.readLong(lastPositionFile);
			}
			/**
			 * wtmpx���ܴ�С��ȥ���׼����ʼ��ȡ��λ�ã�Ӧ������һ����־�Ĵ�С
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
	 * �жϵ�ǰRandomaccessFile��ȡ��λ���Ƿ���wtmpx�ļ��л������ݿɶ�
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
	 * ��һ�󲽣���wtmpx�ļ��ж�ȡbatch����־����������batch���ַ����� ÿ���ַ�����ʾһ����־��Ȼ��д��log.txt�ļ���
	 * 
	 * @return true �ɹ� false ����ʧ��
	 */
	public boolean readNextLogs() {
		/**
		 * �������裺 1 �ж����Ƿ���� 2 �ж��Ƿ��������ݿɶ� 3 ����һ�ζ�ȡ��λ�ÿ�ʼ������ȡ 4
		 * ѭ��batch�ζ�ȡbatch��372�ֽڣ���ת��Ϊbatch����־ 5 ���������batch����־д��log.txt
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
		 * Ϊ�˱����ظ�ִ�е�һ��������ԭ����һ���Ѿ���������־�ļ���������
		 * �������жϣ�����һ��ִ����Ϻ����ɵ�log.txt�ļ����ھͲ���ִ�е�һ���ˡ� ���ļ����ڵڶ���ִ����Ϻ�ɾ��
		 */
		if (textLogFile.exists())
			return true;

		try {
			// ����RandomAccessFile����ȡ��־�ļ�
			RandomAccessFile raf = new RandomAccessFile(logFile, "r");// read-only
			// �ƶ��α굽ָ��λ�á���ʼ��ȡ,note:seek depends on the beginning of the file
			raf.seek(lastposition);
			/**
			 * �������ϱ�����������־
			 */
			List<LogData> logs = new ArrayList<LogData>();

			// ѭ��batch�Σ�����batch����־
			for (int i = 0; i < batch; i++) {
				// �ж��Ƿ�����־���Զ�
				if (!hasLogsByStep(raf)) {
					break;
				}
				// ��ȡ�û���
				String user = IOUtil.readString(raf, LogData.USER_LENGTH);
				System.out.println("***");
				// ��ȡpid
				raf.seek(lastposition + LogData.PID_OFFSET);
				int pid = IOUtil.readInt(raf);

				// ��ȡtype
				raf.seek(lastposition + LogData.TYPE_OFFSET);
				short type = IOUtil.readShort(raf);

				// ��ȡtime
				raf.seek(lastposition + LogData.TIME_OFFSET);
				int time = IOUtil.readInt(raf);

				// ��ȡip
				raf.seek(lastposition + LogData.HOST_OFFSET);
				String ip = IOUtil.readString(raf, LogData.HOST_LENGTH);

				// ��lastposition����Ϊ��ǰ�α��λ��
				lastposition = raf.getFilePointer();

				/**
				 * ���������������ݴ���һ��LogData�����У��ٽ��ö�����뼯����
				 */
				LogData log = new LogData(user, pid, type, time, ip);
				logs.add(log);
			}
			// ����
			// System.out.println("��������"+logs.size()+"����־");
			// for (Iterator iterator = logs.iterator(); iterator.hasNext(); ) {
			// LogData logData = (LogData) iterator.next();
			// System.out.println(logData);
			// }
			/**
			 * �����������־д��log.txt�ļ���
			 */
			IOUtil.saveList(logs, textLogFile);
			/**
			 * ����ν�����RandomAccessFile���α�λ�ý��м�¼���Ա��´ζ�ȡ
			 */
			IOUtil.saveLong(lastposition, lastPositionFile);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * �ڶ��󲽣�ƥ����־ 1����ȡlog.txt�ļ�������һ������������־��ȡ��������ת��Ϊ����LogData���� ����list�����У��ȴ����
	 * 2����ȡlogin.txt�ļ�������һ��û����Գɹ��ĵ�����־��ȡ������ת��Ϊ����LogData���� Ҳ����list�У��ȴ�������
	 * 3��ѭ��list������͵ǳ���־�ֱ���뵽����map�У�value���ǡ�user��pid��ip��������ʽ���ַ���
	 * 4��ѭ���ǳ���map��ͨ��keyѰ�ҵ���map�еĵ�����־���ﵽ���Ŀ�ģ� ����Ե���־ת��Ϊһ��LogRec�������list������
	 * 5����������Գɹ�����־д���ļ�logrec.txt,������û��Գɹ�����־д���ļ�login.txt
	 * 
	 * @return
	 */
	public boolean matchLogs() {
		/**
		 * ��Ҫ�ж�
		 */
		// 1 ���log.txt�Ƿ����
		if (!textLogFile.exists()) {
			return false;
		}
		// 2
		/**
		 * ���ڶ���ִ����ϣ������������ļ���logrec.txt��login.txt
		 * ����������ִ��ʱ���ִ�������������ִ�еڶ������Ὣ�ϴεڶ����Ѿ���Ե���־���ǡ�
		 * ���жϣ���logrec�ļ����ڣ��ڶ����Ͳ���ִ��.������ִ����Ϻ���ɾ��
		 */
		if (logRecFile.exists())
			return true;

		/**
		 * ҵ���߼�
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
					// תΪ����
					LogRec logrec = new LogRec(login, entry.getValue());
					logRecList.add(logrec);
				}
			}
			// ��Թ�������
			// 5
			IOUtil.saveList(logRecList, logRecFile);

			// 6
			Collection<LogData> c = loginMap.values();
			IOUtil.saveList(new ArrayList(c), loginFile);

			// 7
			textLogFile.delete();

			return true;
		} catch (Exception e) {
			// ��������ˣ����Ѿ�����rec�ļ���������Ч��Ҫɾ��,�Ա����ִ�еڶ���
			if (logRecFile.exists())
				logRecFile.delete();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ������LogData����map(private ���������ڲ����ûᾯ��)
	 * 
	 * @param log
	 * @param map
	 */
	private void putLogToMap(LogData log, Map<String, LogData> map) {
		map.put(log.getUser() + "," + log.getPid() + "," + log.getIp(), log);
	}

	/**
	 * ������������Ե���־���͸������ 1 ����socket���ӷ����� 2 ͨ��socket��ȡ�����������װΪ������������ַ�������Ϊutf-8 3
	 * ���������ַ����������ڶ�ȡlogrec.txt����ȡ�����־�� 4 ��logrec.txt��ȡÿһ����־��Ϣ���������ͻ��� 5
	 * ͨ��socket��ȡ��������װΪ���������������ڶ�ȡ�ͻ�����Ӧ�� 6
	 * ��ȡ����˵���Ӧ������ok��˵������˳ɹ����������Ƿ��͵���־����ô�ͽ�logrec.txtɾ����
	 * ������ִ����ϣ�������ok����û�гɹ�����÷���Ӧ����false��Ӧ�����³���ִ�е�������
	 * 
	 * @return
	 */
	public boolean sendLoToServer() {
		/**
		 * ��Ҫ�ж�
		 */
		if (!logRecFile.exists()) {
			return false;
		}

		/**
		 * ҵ���߼�
		 */
		Socket socket=null;
		BufferedReader br=null;
		try {
			socket = new Socket("localhost", 8088);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			FileInputStream fis = new FileInputStream(logRecFile);
			br = new BufferedReader(new InputStreamReader(fis));// ����ת�ַ���
			/**
			 * ѭ����ȡ��ͨ��socketд��
			 */
			String line = null;
			while ((line = br.readLine()) != null) {
				pw.println(line);
			}
			
			//������־
			pw.println("over");
			pw.flush();// ��Ҫ��ʱ�ԡ�������flush�ͺ�
			br.close();// �������ڶ��ļ���ɾ������

			/**
			 * ��ȡ�������Ӧ���ж��¶����ͳɹ�
			 */
			InputStream in = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "utf-8"));
			String response = br.readLine();
			if ("ok".equals(response)) {// �����ָ������
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
					socket.close();//�ص�socket�������ȡ�������ᱻ�ر�
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

	/**
	 * ��ʼ����
	 */
	public void start() {
		/**
		 * ѭ�������������� 1 ���ļ���һ�ν���batch����־ 2 �����������־���ϴ�û��ƥ�����־һ��ƥ��ɶ� 3
		 * ��ƥ��ɶԵ���־�������ͻ���
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
