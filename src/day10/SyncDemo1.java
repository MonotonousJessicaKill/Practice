package day10;
/**
 * ��Сͬ����Χ
 * syychronized(��){��Ҫͬ���Ĵ��� },
 * ������������Ķ��󣬵��Ƕ��̱߳��뿴������ͬһ������
 * @author wu.jielin
 *
 */
public class SyncDemo1 {
	public static Object obj=new Object();//��̬��ʼ����������������-��׼��ֵ����������������-null
	public static void main(String[] args) {
		Thread t0=new Thread(){
			public void run(){
				buy(getName());
			}
		};
		Thread t1=new Thread(){
			public void run(){
				buy(getName());
			}
		};
		t0.start();
		t1.start();
	}
	public static void buy(String name){
		System.out.println(name+"�������·�");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		synchronized(obj){
		System.out.println(name+"������,���·�");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){}
		}
		System.out.println(name+"�������");
	}
}
