package day11;
import java.net.*;

public class UdpServer {
	/**
	 * 服务区启动方法
	 */
	public void start(){
		try{
			/**
			 * 接收包的步骤
			 * 1 创建socket（1次）
			 * 2 创建一个合适大小的包
			 * 3 通过socket接收数据到包中
			 * 4 拆包取数据
			 */
			DatagramSocket socket=new DatagramSocket(8088);
			byte[] data=new byte[100];
			DatagramPacket recvPacket= new DatagramPacket(data, data.length);
			//接收数据到包中
			//注意，该方法为阻塞方法。
			socket.receive(recvPacket);
			//拆包拿数据
			byte[] d=recvPacket.getData();//其实就是data 即 d=data
			//有效数据长度
			int dlen=recvPacket.getLength();
			String message=new String(d, 0, dlen, "utf-8");
			System.out.println(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		UdpServer server=new UdpServer();
		server.start();
	}
}
