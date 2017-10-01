package day11;
import java.util.*;
import java.io.*;
import java.net.*;
/**
 * �ͻ���Ӧ�ó���
 * @author wu.jielin
 *
 */
public class Client {
	//Socket,�������ӷ���˵�ServerSocket
	private Socket socket;
	/**
	 * ���췽������ʼ���ͻ���
	 */
	public Client() throws Exception{
		try {
			/**
			 * ����Socket����ʱ���ͻ᳢�Ը���ָ����ip�Ͷ˿����ӿͻ��ˣ�
			 * ���Զ��󴴽��ɹ���˵������������������
			 */
			System.out.println("�������ӷ����");
			socket=new Socket("192.168.16.107", 8088);//(ip,port)
			System.out.println("��������������");
		} catch (UnknownHostException e) {//�Ҳ�����ַ
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * �ͻ�����������
	 */
	public void start(){
		try{
			//���������������̣߳������շ������Ϣ
			Thread listener=new Thread(new GetserverInfoHandler());
			listener.start();
			/**
			 * ͨ��Socket��getOutputStream��ȡһ������������ڽ���Ϣ���͸�����ˡ�
			 */
			OutputStream out=socket.getOutputStream();
			/**
			 * ʹ���ַ���������ָ���ı��뼯���ַ���ת��Ϊ�ֽں���ͨ��out���͸��ͻ��ˡ�
			 */
			OutputStreamWriter osw=new OutputStreamWriter(out,"utf-8");
			/**
			 * ���ַ�����װ�ɻ����ַ������Ϳ�������Ϊ��λд���ַ����ˡ�
			 */
			PrintWriter pw=new PrintWriter(osw, true);
			Scanner scan=new Scanner(System.in);
			System.out.println("��ӭ����������!");
			while(true){
				System.out.println("���������ǳ�");
				String nickName=scan.nextLine();
				if(nickName.trim().length()>0){
					pw.println(nickName);
					break;
				}
				System.out.println("�ǳƲ���Ϊ��-����������");
			}
			
			while(true){
			pw.println(scan.nextLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		try {
			Client client;
			client=new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ͻ��˳�ʼ��ʧ��");
		}
	}
	
	class GetserverInfoHandler implements Runnable{

		@Override
		public void run() {
			try{
			BufferedReader br=new BufferedReader(
					new InputStreamReader(socket.getInputStream(), "utf-8")
					);
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println(info);
			}
			}catch(IOException e){
				//e.printStackTrace();�õ�readLine����IOException��������
			}
		}
		
	}
	
	
	
	
	
}
