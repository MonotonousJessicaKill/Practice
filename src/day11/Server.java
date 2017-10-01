package day11;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;
import java.net.*;
/**
 * 服务端应用程序
 * @author wu.jielin
 *
 */
public class Server {
	//运行在服务端的socket
	private ServerSocket server;
	//线程池用于管理线程
	private ExecutorService threadPool;
	//保存所有客户端所有输出流的集合
	private List<PrintWriter> allOut;
	/**
	 * 初始化服务器
	 */
	public Server() throws IOException{
		try {
			/**
			 * 创建ServerSocket指定服务端口
			 */
			System.out.println("初始化服务端");
			server=new ServerSocket(8088);
			//初始化线程池
			threadPool=Executors.newFixedThreadPool(50);
			//初始化所有客户端输出流的集合
			allOut =new ArrayList<PrintWriter>();
			
			System.out.println("初始化服务端完成");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 服务端开始工作的方法
	 */
	public void start(){
		try{
			/**
			 * Socket accept()
			 * ServerSocket的accept方法，用于监听8088端口。是一个阻塞方法知道一个客户端连接，否则该方法一直阻塞。
			 * 若一个客户端连接了则会返回该客户端的socket
			 */
			while(true){
			System.out.println("等待客户端连接...");
			Socket socket=server.accept();
			/**
			 * 当一个客户端连接后启动一个线程，传入其socket
			 */
			Runnable handler=new ClientHandler(socket);
//			Thread t=new Thread(handler);
//			t.start();
			threadPool.execute(handler);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 将给定的输出流存入共享集合
	 * 由于线程安全的集合不影响迭代器操作,collections转为安全的也不行；所以需要作为互斥方法。(既是同步又是互斥)
	 * 方法前的synchronized锁的是this--->synchronized(this){}
	 * 同步与互斥：
	 * 	synchronized锁一个代码块，两个线程在同一个地方看到的是同一个锁为同步。
	 * 	互斥，两个线程在两个地方看到同一个锁。
	 */
	public synchronized void addOut(PrintWriter pw){
		allOut.add(pw);
	}
	/**
	 * 将给定的输出流从共享集合中删除
	 */
	public synchronized void removeOut(PrintWriter pw){
		allOut.remove(pw);
	}
	
	/**
	 * 遍历共享输出流,将给定的消息发给所有客户端
	 */
	public synchronized void sendMessage(String message){
		for (PrintWriter printWriter : allOut) {
			printWriter.println(message);
		}
	}
	public static void main(String[] args) {
		Server server;
		try {
			server=new Server();
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("服务端初始化失败");
		}
		
	}
	/**
	 * 服务端的一个线程，用于与某个客户端进行交互，使用线程的 目的是为了与多个客户端进行交互
	 * @author wu.jielin
	 *
	 */
	class ClientHandler implements Runnable{
		//当前线程处理的客户端的Socket
		private Socket socket;
		private String ip;
		private String nickName;
		/**
		 * 根据指定客户端的Socket创建线程体
		 * @param socket
		 */;
		public ClientHandler(Socket socket){
			this.socket=socket;
			/**
			 * 获取客户端地址
			 */
			InetAddress address= socket.getInetAddress();
			//获取客户端ip
			this.ip=address.getHostAddress();
			//获取客户端应用程序端口
			int port=socket.getPort();
			System.out.println(ip+":"+port+"与本服务器建立了连接");
//			sendMessage("["+ip+"]上线了");//通知其他用户该用户上线了. 改为使用昵称。
		}
		@Override
		public void run() {
			/**
			 * 定义在try语句外的目的是为了在finally中也可以引用到
			 */
			PrintWriter pw=null;
			try{
				/**
				 * 为了让服务端与客户端交互，我们需要通过socket获取输出流
				 */
				OutputStream out=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(out, "utf-8");
				pw=new PrintWriter(osw,true);
				
				//将该客户端的输出流存入共享集合，以便该客户端也能接收服务端转发的消息。
				addOut(pw);
			
			/**
			 * 通过刚刚连上的Socket获取输入流，读取客户端发过来的信息
			 */
			InputStream in=socket.getInputStream();
			/**
			 * 将字节流包装成字符流，指定编码集
			 */
			InputStreamReader isr=new InputStreamReader(in,"utf-8");
			/**
			 * 将字符流转换为缓冲字符输入流，这样就可以以行为单位读取字符串了
			 */
			BufferedReader br=new BufferedReader(isr);
			//读取客户端发送过来的一行字符串
			/**
			 * 断开连接后，linux会readLine到null。windows就会readLine抛异常IOException
			 */
			//读取的第一个字符串是昵称
			nickName=br.readLine();
			//通知所有客户端本客户端上线了
			sendMessage("\\\\\\"+nickName+"上线了");
			String message=null;
			while((message=br.readLine())!=null){
//				System.out.println("客户端说："+message);
//				pw.println(message);
				/**
				 * 当客户端发送一条消息，转发给所有客户端
				 */
				sendMessage("["+nickName+"]说"+message);
			}
			
			}catch(IOException e){
				//e.printStackTrace();拿到IOException（因为下线从readline来的，不做处理）
			}catch(Exception e){
				System.out.println("非IOException");
			}
			finally{
				//将该客户端的输出流从共享集合中删除
				removeOut(pw);
				//输出当前在线人数
				System.out.println("当前在线人数： "+allOut.size());
				sendMessage("["+nickName+"]用户下线了");
				//关闭socket，其获得的流都会被关闭
				try {
					socket.close();
				} catch (IOException e) {}
				
			}
			
		}
		
	}
}
