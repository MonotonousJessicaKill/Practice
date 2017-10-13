package jielin.wu;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
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
	//保存收到客户端的日志
	private File serverLogFile;
	//创建一个双缓冲队列，用于存储配对日志
	private BlockingQueue<String> messageQueue;
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
			
			serverLogFile=new File("server-log.txt");
			messageQueue=new LinkedBlockingQueue<String>();
			
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
			 * 将写文件线程启动(不要放在线程池中，因为其永远不会停止)
			 */
			WriteLogThread thread= new WriteLogThread();
			thread.start();
			/**;8
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
		
		
		/**
		 * 根据指定客户端的Socket创建线程体
		 * @param socket
		 */;
		public ClientHandler(Socket socket){
			this.socket=socket;
			
		}
		@Override
		public void run() {
			/**
			 * 定义在try语句外的目的是为了在finally中也可以引用到
			 */
			PrintWriter pw=null;
			try{
				/**
				 * 为了让服务端与客户端交互，;我们需要通过socket获取输出流
				 */
				OutputStream out=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(out, "utf-8");
				pw=new PrintWriter(osw,true);
				
			
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
			
			String message=null;
			while((message=br.readLine())!=null){
				/**
				 * 循环读取客户端发送来的每一组配对日志
				 * 读取到一组，就将该日志存入消息队列，等待被写入文件
				 */
				if("over".equals(message)) break;
				messageQueue.offer(message);
			}
			
			pw.println("ok");
			
			}catch(IOException e){
				pw.println("error");
				//e.printStackTrace()
			}catch(Exception e){
				System.out.println("非IOException");
				pw.println("error");
			}
			finally{
				try {
					socket.close();
				} catch (IOException e) {}
				
			}
			
		}
		
	}
	/**
	 * 该线程在server中仅有一个实例，作用是在消息队列中循环取出日志并写入文件。
	 * 队列中没有日志时就休眠。等待客户端发送新的日志
	 * @author wu.jielin
	 *
	 */
	class WriteLogThread extends Thread{
		public void run(){
			try{
				PrintWriter pw=new PrintWriter(serverLogFile);
				while(true){
					if(messageQueue.size()>0){
						String log=messageQueue.poll();
						pw.println(log);
					}else{
						pw.flush();
						Thread.sleep(5000);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
