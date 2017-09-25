package day09;
/**
 * ��ȡ��ǰִ�е��̣߳�Thread.currentThread()
 * @author wu.jielin
 *
 */
public class ThreadDemo3 {
	/**
	 * output:
	 * ����main:Thread[main,5,main]//�߳�������ָ�������߳����ȼ����߳���
	 * ����testCurrent:Thread[main,5,main]
     * ����run�ģ�Thread[Thread-0,5,main]//�Լ������ϵͳ�����ִ�Thread-0��ʼ
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("����main:"+Thread.currentThread());
		testCurrent();
		
		Thread t1=new Thread(new Runnable(){
			public void run(){
				System.out.println("����run�ģ�"+Thread.currentThread());
			}
		});
		t1.start();
	}
	
	public static void testCurrent(){
		System.out.println(
				"����testCurrent:"+Thread.currentThread()
				);
	}
}
