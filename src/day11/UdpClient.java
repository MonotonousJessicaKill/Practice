package day11;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
	/**
	 * �ͻ�����������
	 * @param args
	 */
	public void start(){
		try{
			/**
			 * �����˷������ݵĲ���
			 * 1 ������Socket��1�ξͺã�
			 * 2 ׼������
			 * 3 �������ݰ�
			 * 4 �����ݴ�����У�3��4��һ����ɵģ�
			 * 5 �����ݰ�ͨ��socket���ͳ�ȥ
			 */
			DatagramSocket socket=new DatagramSocket();
			String str="hello server";
			byte[] data=str.getBytes("utf-8");
			/**
			 * �����׼����������д��ַ��װ������
			 */
			InetAddress address=InetAddress.getByName("localhost");
			int port=8088;
			//�������Ͱ�
			DatagramPacket sendPacket=new DatagramPacket(data,
					data.length,
					address,
					port
					);
			//���Ͱ�
			socket.send(sendPacket);
		}catch(Exception e){
			
		}
		
	}
	public static void main(String[] args) {
		UdpClient client=new UdpClient();
		client.start();
	}
}
