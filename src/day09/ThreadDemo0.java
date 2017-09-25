package day09;
/**
 * 第一种创建线程的方式 继承Thread类，重写run方法 
 * 有先后顺序的运行方式成为同步运行。 
 * 你干你的我干我的成为异步。
 * start把线程纳入线程调度，进入runnable状态，等待cpu分配时间片段(长短不确定)。
 * 当分配到时间片段就调用run进入running状态；run调用结束线程结束最终被回收。在run方法执行
 * 过程中该线程属于走走停停/
 * @author wu.jielin
 * 
 */
public class ThreadDemo0 {
	public static void main(String[] args) {
		Thread t1=new MyThread1();
		Thread t2=new Mythread2();
		//调用run方法会变成同步
		//start吧线程纳入线程调度
		t1.start();
		t2.start();
	}
}
/**
 * Thread是一个实现类，只要继承就能用，但是run来定义自己的东西
 * @author wu.jielin
 *
 */
class MyThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("你是谁啊");
		}
	}
}
class Mythread2 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是查水表的");
		}
	}
}