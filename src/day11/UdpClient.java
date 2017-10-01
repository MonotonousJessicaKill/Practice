package day11;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
	/**
	 * 客户端启动方法
	 * @param args
	 */
	public void start(){
		try{
			/**
			 * 向服务端发送数据的步骤
			 * 1 创建好Socket（1次就好）
			 * 2 准备数据
			 * 3 创建数据包
			 * 4 将数据存入包中（3，4是一步完成的）
			 * 5 将数据包通过socket发送出去
			 */
			DatagramSocket socket=new DatagramSocket();
			String str="hello server";
			byte[] data=str.getBytes("utf-8");
			/**
			 * 打包：准备包裹，填写地址，装入数据
			 */
			InetAddress address=InetAddress.getByName("localhost");
			int port=8088;
			//创建发送包
			DatagramPacket sendPacket=new DatagramPacket(data,
					data.length,
					address,
					port
					);
			//发送包
			socket.send(sendPacket);
		}catch(Exception e){
			
		}
		
	}
	public static void main(String[] args) {
		UdpClient client=new UdpClient();
		client.start();
	}
}
