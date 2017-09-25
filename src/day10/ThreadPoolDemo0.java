package day10;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：1，限制线程数量 2，重用线程
 * 几种实现策略：
 * --Executors.newCachedThreadPool()创建一个可根据需要数量创建新线程的池，但之前构造的线程在之后可以重用
 * --Executors.newFixedThreadPool(int 数量）创建一个固定线程数量的线程池，以共享的无界队列来运行这些线程
 * --Executors.newScheduledThreadPool(int corePoolSize)可以在给定延迟后运行命令，或者定期执行
 * --Executros.newSingleThreadExecutor()创建一个使用单一worker线程的Executor，以无界队列方式运行
 * @author wu.jielin
 *
 */
public class ThreadPoolDemo0 {
	public static void main(String[] args) {
		ExecutorService threadPool=Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++){
		Runnable runn=new Runnable(){
			public void run(){
			for(int i=0;i<5;i++){
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		};
		threadPool.execute(runn);
		}
	}
}
