package day10;
/**
 * �߳�Эͬ����
 * ������������wait notify,notifyAll 
 * ʹ�õ���������Щ������Ҫ�Ե�ǰ���������������Ķ�����ǵ���������
 * notifyֻ��������һ����notifyAll������С�
 * @author wu.jielin
 *
 */
public class ThreadDemoA {
	public static Object obj=new Object();
	public static void main(String[] args) {
		Thread download=new Thread(){
			public void run(){
				System.out.println("down:��ʼ����ͼƬ");
				for(int i=0;i<100;i++){
					System.out.println("down:�����"+i+"%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {}
				}
				synchronized(obj){
					obj.notify();
				}
				System.out.println("down:��ʼ���ظ���");
				for(int i=0;i<100;i++){
					System.out.println("down:�����"+i+"%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {}
				}
			}
		};
		
		Thread showPic=new Thread(){
			public void run(){
				System.out.println("show:�ȴ�ͼƬ����");
				synchronized(obj){
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("��ʼ��ʾͼƬ");
				System.out.println("show:��ʾͼƬ");
			}
		};
		download.start();
		showPic.start();
	}
}
