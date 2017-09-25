package day09;
/**
 * 获取当前执行的线程：Thread.currentThread()
 * @author wu.jielin
 *
 */
public class ThreadDemo3 {
	/**
	 * output:
	 * 调用main:Thread[main,5,main]//线程名（可指定），线程优先级，线程组
	 * 调用testCurrent:Thread[main,5,main]
     * 调用run的：Thread[Thread-0,5,main]//自己定义的系统给名字从Thread-0开始
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("调用main:"+Thread.currentThread());
		testCurrent();
		
		Thread t1=new Thread(new Runnable(){
			public void run(){
				System.out.println("调用run的："+Thread.currentThread());
			}
		});
		t1.start();
	}
	
	public static void testCurrent(){
		System.out.println(
				"调用testCurrent:"+Thread.currentThread()
				);
	}
}
