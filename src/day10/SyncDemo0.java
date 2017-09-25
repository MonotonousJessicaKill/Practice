package day10;
/**
 * 线程并发安全问题
 * @author wu.jielin
 *
 */
public class SyncDemo0 {
	public static int beans=20;
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable(){
			public void run(){
			int bean=0;
			while(true){
				bean=getBean();
				System.out.println("0-beans:"+bean);
			}
			}
		});
		Thread t2=new Thread(new Runnable(){
			public void run(){
			int bean=0;
			while(true){
				bean=getBean();
				System.out.println("1-beans:"+bean);
			}
			}
		});
		t1.start();
		t2.start();
	}
	//从桌上取豆子
	public synchronized static int getBean(){//加锁
		if(beans==0){
			throw new RuntimeException("没豆子了");
		}
		Thread.yield();
		return beans--;
	}
}
