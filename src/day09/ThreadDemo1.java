package day09;
/**
 * 第二种创建线程的方式
 * 定义线程体Runnable
 * @author wu.jielin
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Runnable run1=new MyRunnable1();
		Runnable run2=new MyRunnable2();
		//线程自己不决定干什么，传入runnable决定
		Thread t1=new Thread(run1);
		Thread t2=new Thread(run2);
		
		t1.start();
		t2.start();
	}
}
class MyRunnable1 implements Runnable{
	public void run(){
		for (int i = 0; i < 1000; i++) {
			System.out.println("你是谁啊");
		}
	}
}
class MyRunnable2 implements Runnable{
	public void run(){
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是查水表的");
		}
	}
}


