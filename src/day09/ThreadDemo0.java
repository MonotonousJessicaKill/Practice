package day09;
/**
 * ��һ�ִ����̵߳ķ�ʽ �̳�Thread�࣬��дrun���� 
 * ���Ⱥ�˳������з�ʽ��Ϊͬ�����С� 
 * �������Ҹ��ҵĳ�Ϊ�첽��
 * start���߳������̵߳��ȣ�����runnable״̬���ȴ�cpu����ʱ��Ƭ��(���̲�ȷ��)��
 * �����䵽ʱ��Ƭ�ξ͵���run����running״̬��run���ý����߳̽������ձ����ա���run����ִ��
 * �����и��߳���������ͣͣ/
 * @author wu.jielin
 * 
 */
public class ThreadDemo0 {
	public static void main(String[] args) {
		Thread t1=new MyThread1();
		Thread t2=new Mythread2();
		//����run��������ͬ��
		//start���߳������̵߳���
		t1.start();
		t2.start();
	}
}
/**
 * Thread��һ��ʵ���ֻ࣬Ҫ�̳о����ã�����run�������Լ��Ķ���
 * @author wu.jielin
 *
 */
class MyThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("����˭��");
		}
	}
}
class Mythread2 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("���ǲ�ˮ���");
		}
	}
}