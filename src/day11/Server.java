package day11;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
	//�������пͻ�������������ļ���
	private List<PrintWriter> allOut;
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
			//��ʼ�����пͻ���������ļ���
			allOut =new ArrayList<PrintWriter>();
			
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
	public synchronized void addOut(PrintWriter pw){
		allOut.add(pw);
	}
	/**
	 * ��������������ӹ�������ɾ��
	 */
	public synchronized void removeOut(PrintWriter pw){
		allOut.remove(pw);
	}
	
	/**
	 * �������������,����������Ϣ�������пͻ���
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
		private String ip;
		private String nickName;
		/**
		 * ����ָ���ͻ��˵�Socket�����߳���
		 * @param socket
		 */;
		public ClientHandler(Socket socket){
			this.socket=socket;
			/**
			 * ��ȡ�ͻ��˵�ַ
			 */
			InetAddress address= socket.getInetAddress();
			//��ȡ�ͻ���ip
			this.ip=address.getHostAddress();
			//��ȡ�ͻ���Ӧ�ó���˿�
			int port=socket.getPort();
			System.out.println(ip+":"+port+"�뱾����������������");
//			sendMessage("["+ip+"]������");//֪ͨ�����û����û�������. ��Ϊʹ���ǳơ�
		}
		@Override
		public void run() {
			/**
			 * ������try������Ŀ����Ϊ����finally��Ҳ�������õ�
			 */
			PrintWriter pw=null;
			try{
				/**
				 * Ϊ���÷������ͻ��˽�����������Ҫͨ��socket��ȡ�����
				 */
				OutputStream out=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(out, "utf-8");
				pw=new PrintWriter(osw,true);
				
				//���ÿͻ��˵���������빲���ϣ��Ա�ÿͻ���Ҳ�ܽ��շ����ת������Ϣ��
				addOut(pw);
			
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
			//��ȡ�ĵ�һ���ַ������ǳ�
			nickName=br.readLine();
			//֪ͨ���пͻ��˱��ͻ���������
			sendMessage("\\\\\\"+nickName+"������");
			String message=null;
			while((message=br.readLine())!=null){
//				System.out.println("�ͻ���˵��"+message);
//				pw.println(message);
				/**
				 * ���ͻ��˷���һ����Ϣ��ת�������пͻ���
				 */
				sendMessage("["+nickName+"]˵"+message);
			}
			
			}catch(IOException e){
				//e.printStackTrace();�õ�IOException����Ϊ���ߴ�readline���ģ���������
			}catch(Exception e){
				System.out.println("��IOException");
			}
			finally{
				//���ÿͻ��˵�������ӹ�������ɾ��
				removeOut(pw);
				//�����ǰ��������
				System.out.println("��ǰ���������� "+allOut.size());
				sendMessage("["+nickName+"]�û�������");
				//�ر�socket�����õ������ᱻ�ر�
				try {
					socket.close();
				} catch (IOException e) {}
				
			}
			
		}
		
	}
}
