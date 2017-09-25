package day10;
/**
 * 线程协同工作
 * 依赖第三方的wait notify,notifyAll 
 * 使用第三方的这些方法需要对当前调用语句加锁，锁的对象就是第三方对象。
 * notify只会随机解除一个。notifyAll解除所有。
 * @author wu.jielin
 *
 */
public class ThreadDemoA {
	public static Object obj=new Object();
	public static void main(String[] args) {
		Thread download=new Thread(){
			public void run(){
				System.out.println("down:开始下载图片");
				for(int i=0;i<100;i++){
					System.out.println("down:已完成"+i+"%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {}
				}
				synchronized(obj){
					obj.notify();
				}
				System.out.println("down:开始下载附件");
				for(int i=0;i<100;i++){
					System.out.println("down:已完成"+i+"%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {}
				}
			}
		};
		
		Thread showPic=new Thread(){
			public void run(){
				System.out.println("show:等待图片下载");
				synchronized(obj){
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("开始显示图片");
				System.out.println("show:显示图片");
			}
		};
		download.start();
		showPic.start();
	}
}
