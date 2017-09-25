package day09;
/**
 * join可以使线程同步
 * 方法中定义的内部类是局部内部类，局部内部类要引用该方法的其他局部变量，该变量必须是final的。?我的实验没报错?--jdk8的特性实际也是final的
 * @author wu.jielin
 *
 */
public class ThreadDemo8 {
	//表示图片是否下载完毕
	public static boolean isFinished;
	public static void main(String[] args) {
		String str="lala";
		Thread download =new Thread(new Runnable(){//局部匿名内部类
			public void run(){
				System.out.println("down:开始下载图片");
				for(int i=0;i<100;i++){
					System.out.println("down:已完成"+i+"%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {}
				}
				isFinished=true;
			}
		});
		Thread show=new Thread(new Runnable(){
			public void run(){
				System.out.println("show:开始显示图片");
				try {
					download.join();//阻塞，知道download线程执行完（死了），再解除阻塞
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(str);
				if(!isFinished){
					throw new RuntimeException("图片显示失败");
				}
				System.out.println("show:显示图片");
			}
		});
		download.start();
		show.start();
	}
}
