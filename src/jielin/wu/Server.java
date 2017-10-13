package jielin.wu;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.*;
import java.net.*;
/**
 * �����Ӧ�ó���
 * @author wu.jielin
 *
 */
public class Server {
	//�����ڷ���˵�socket
	private ServerSocket server;
	//�̳߳����ڹ����߳�
	private ExecutorService threadPool;
	//�����յ��ͻ��˵���־
	private File serverLogFile;
	//����һ��˫������У����ڴ洢�����־
	private BlockingQueue<String> messageQueue;
	/**
	 * ��ʼ��������
	 */
	public Server() throws IOException{
		try {
			/**
			 * ����ServerSocketָ������˿�
			 */
			System.out.println("��ʼ�������");
			server=new ServerSocket(8088);
			//��ʼ���̳߳�
			threadPool=Executors.newFixedThreadPool(50);
			
			serverLogFile=new File("server-log.txt");
			messageQueue=new LinkedBlockingQueue<String>();
			
			System.out.println("��ʼ����������");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * ����˿�ʼ�����ķ���
	 */
	public void start(){
		try{
			/**
			 * ��д�ļ��߳�����(��Ҫ�����̳߳��У���Ϊ����Զ����ֹͣ)
			 */
			WriteLogThread thread= new WriteLogThread();
			thread.start();
			/**;8
			 * Socket accept()
			 * ServerSocket��accept���������ڼ���8088�˿ڡ���һ����������֪��һ���ͻ������ӣ�����÷���һֱ������
			 * ��һ���ͻ�����������᷵�ظÿͻ��˵�socket
			 */
			while(true){
			System.out.println("�ȴ��ͻ�������...");
			Socket socket=server.accept();
			/**
			 * ��һ���ͻ������Ӻ�����һ���̣߳�������socket
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
	 * ����������������빲����
	 * �����̰߳�ȫ�ļ��ϲ�Ӱ�����������,collectionsתΪ��ȫ��Ҳ���У�������Ҫ��Ϊ���ⷽ����(����ͬ�����ǻ���)
	 * ����ǰ��synchronized������this--->synchronized(this){}
	 * ͬ���뻥�⣺
	 * 	synchronized��һ������飬�����߳���ͬһ���ط���������ͬһ����Ϊͬ����
	 * 	���⣬�����߳��������ط�����ͬһ������
	 */
	public static void main(String[] args) {
		Server server;
		try {
			server=new Server();
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����˳�ʼ��ʧ��");
		}
		
	}
	/**
	 * ����˵�һ���̣߳�������ĳ���ͻ��˽��н�����ʹ���̵߳� Ŀ����Ϊ�������ͻ��˽��н���
	 * @author wu.jielin
	 *
	 */
	class ClientHandler implements Runnable{
		//��ǰ�̴߳���Ŀͻ��˵�Socket
		private Socket socket;
		
		
		/**
		 * ����ָ���ͻ��˵�Socket�����߳���
		 * @param socket
		 */;
		public ClientHandler(Socket socket){
			this.socket=socket;
			
		}
		@Override
		public void run() {
			/**
			 * ������try������Ŀ����Ϊ����finally��Ҳ�������õ�
			 */
			PrintWriter pw=null;
			try{
				/**
				 * Ϊ���÷������ͻ��˽�����;������Ҫͨ��socket��ȡ�����
				 */
				OutputStream out=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(out, "utf-8");
				pw=new PrintWriter(osw,true);
				
			
			/**
			 * ͨ���ո����ϵ�Socket��ȡ����������ȡ�ͻ��˷���������Ϣ
			 */
			InputStream in=socket.getInputStream();
			/**
			 * ���ֽ�����װ���ַ�����ָ�����뼯
			 */
			InputStreamReader isr=new InputStreamReader(in,"utf-8");
			/**
			 * ���ַ���ת��Ϊ�����ַ��������������Ϳ�������Ϊ��λ��ȡ�ַ�����
			 */
			BufferedReader br=new BufferedReader(isr);
			//��ȡ�ͻ��˷��͹�����һ���ַ���
			/**
			 * �Ͽ����Ӻ�linux��readLine��null��windows�ͻ�readLine���쳣IOException
			 */
			
			String message=null;
			while((message=br.readLine())!=null){
				/**
				 * ѭ����ȡ�ͻ��˷�������ÿһ�������־
				 * ��ȡ��һ�飬�ͽ�����־������Ϣ���У��ȴ���д���ļ�
				 */
				if("over".equals(message)) break;
				messageQueue.offer(message);
			}
			
			pw.println("ok");
			
			}catch(IOException e){
				pw.println("error");
				//e.printStackTrace()
			}catch(Exception e){
				System.out.println("��IOException");
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
	 * ���߳���server�н���һ��ʵ��������������Ϣ������ѭ��ȡ����־��д���ļ���
	 * ������û����־ʱ�����ߡ��ȴ��ͻ��˷����µ���־
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
