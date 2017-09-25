package day09;
/**
 * 线程优先级 1-10
 * 理论上优先级分配时间片段的频率更高
 * @author wu.jielin
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		Thread max=new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("max");
				}
			}
		});
		max.setPriority(Thread.MAX_PRIORITY);
		Thread min=new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
			}
		});
		min.setPriority(Thread.MIN_PRIORITY);
		max.start();
		min.start();
	}
}
