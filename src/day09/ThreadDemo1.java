package day09;
/**
 * �ڶ��ִ����̵߳ķ�ʽ
 * �����߳���Runnable
 * @author wu.jielin
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Runnable run1=new MyRunnable1();
		Runnable run2=new MyRunnable2();
		//�߳��Լ���������ʲô������runnable����
		Thread t1=new Thread(run1);
		Thread t2=new Thread(run2);
		
		t1.start();
		t2.start();
	}
}
class MyRunnable1 implements Runnable{
	public void run(){
		for (int i = 0; i < 1000; i++) {
			System.out.println("����˭��");
		}
	}
}
class MyRunnable2 implements Runnable{
	public void run(){
		for (int i = 0; i < 1000; i++) {
			System.out.println("���ǲ�ˮ���");
		}
	}
}


