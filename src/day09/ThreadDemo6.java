package day09;
/**
 * 守护线程==后台线程
 * 前台（普通）线程全部结束，进程结束，则守护线程强制结束/
 * 即进程中只剩守护线程时，守护线程强制结束，进程结束。
 * @author wu.jielin
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		//rose 扮演前台线程
		Thread rose =new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose:AAAAAAAA!");
				System.out.println("噗通");//前台线程结束
			}
		});
		
		Thread jack=new Thread(new Runnable(){
			public void run(){
				while(true){
					System.out.println("jack:you jump,i jump");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		rose.start();
		jack.setDaemon(true);
		jack.start();//调用main方法线程死掉
		//while(true);前台线程main永远不死
		//=while(true){}
	}
}
