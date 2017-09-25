package day10;
/**
 * 缩小同步范围
 * syychronized(锁){需要同步的代码 },
 * 锁可以是任意的对象，但是多线程必须看到的是同一个对象
 * @author wu.jielin
 *
 */
public class SyncDemo1 {
	public static Object obj=new Object();//静态初始：基本类型域引用-标准初值。引用类型域引用-null
	public static void main(String[] args) {
		Thread t0=new Thread(){
			public void run(){
				buy(getName());
			}
		};
		Thread t1=new Thread(){
			public void run(){
				buy(getName());
			}
		};
		t0.start();
		t1.start();
	}
	public static void buy(String name){
		System.out.println(name+"正在挑衣服");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		synchronized(obj){
		System.out.println(name+"跳完了,试衣服");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){}
		}
		System.out.println(name+"试完结账");
	}
}
