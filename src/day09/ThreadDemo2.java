package day09;
/**
 * 匿名内部类创建线程
 * @author wu.jielin
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		//1
		Thread t1=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("你是谁");
				}
			}
		};
		//2
		Thread t2=new Thread(new Runnable(){
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("我是查水表的");
				}
			}
		});
		
	}
}
