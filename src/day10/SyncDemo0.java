package day10;
/**
 * �̲߳�����ȫ����
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
	//������ȡ����
	public synchronized static int getBean(){//����
		if(beans==0){
			throw new RuntimeException("û������");
		}
		Thread.yield();
		return beans--;
	}
}
