package day11;
import java.util.*;
import java.io.*;
import java.net.*;
/**
 * 客户端应用程序
 * @author wu.jielin
 *
 */
public class Client {
	//Socket,用于连接服务端的ServerSocket
	private Socket socket;
	/**
	 * 构造方法，初始化客户端
	 */
	public Client() throws Exception{
		try {
			/**
			 * 创建Socket对象时，就会尝试根据指定的ip和端口连接客户端，
			 * 所以对象创建成功则说明与服务端连接正常。
			 */
			System.out.println("正在连接服务端");
			socket=new Socket("192.168.16.107", 8088);//(ip,port)
			System.out.println("与服务端连接正常");
		} catch (UnknownHostException e) {//找不到地址
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 客户端启动方法
	 */
	public void start(){
		try{
			//创建并启动监听线程，来接收服务端消息
			Thread listener=new Thread(new GetserverInfoHandler());
			listener.start();
			/**
			 * 通过Socket个getOutputStream获取一条输出流，用于将信息发送给服务端。
			 */
			OutputStream out=socket.getOutputStream();
			/**
			 * 使用字符流来根据指定的编码集将字符串转换为字节后，再通过out发送给客户端。
			 */
			OutputStreamWriter osw=new OutputStreamWriter(out,"utf-8");
			/**
			 * 将字符流包装成缓冲字符流，就可以以行为单位写出字符串了。
			 */
			PrintWriter pw=new PrintWriter(osw, true);
			Scanner scan=new Scanner(System.in);
			System.out.println("欢迎来到聊天室!");
			while(true){
				System.out.println("请先输入昵称");
				String nickName=scan.nextLine();
				if(nickName.trim().length()>0){
					pw.println(nickName);
					break;
				}
				System.out.println("昵称不可为空-请重新输入");
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
			System.out.println("客户端初始化失败");
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
				//e.printStackTrace();拿到readLine报的IOException不做处理
			}
		}
		
	}
	
	
	
	
	
}
