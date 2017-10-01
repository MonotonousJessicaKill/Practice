package day11;
import java.net.*;

public class UdpServer {
	/**
	 * ��������������
	 */
	public void start(){
		try{
			/**
			 * ���հ��Ĳ���
			 * 1 ����socket��1�Σ�
			 * 2 ����һ�����ʴ�С�İ�
			 * 3 ͨ��socket�������ݵ�����
			 * 4 ���ȡ����
			 */
			DatagramSocket socket=new DatagramSocket(8088);
			byte[] data=new byte[100];
			DatagramPacket recvPacket= new DatagramPacket(data, data.length);
			//�������ݵ�����
			//ע�⣬�÷���Ϊ����������
			socket.receive(recvPacket);
			//���������
			byte[] d=recvPacket.getData();//��ʵ����data �� d=data
			//��Ч���ݳ���
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
