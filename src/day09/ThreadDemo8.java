package day09;
/**
 * join����ʹ�߳�ͬ��
 * �����ж�����ڲ����Ǿֲ��ڲ��࣬�ֲ��ڲ���Ҫ���ø÷����������ֲ��������ñ���������final�ġ�?�ҵ�ʵ��û����?--jdk8������ʵ��Ҳ��final��
 * @author wu.jielin
 *
 */
public class ThreadDemo8 {
	//��ʾͼƬ�Ƿ��������
	public static boolean isFinished;
	public static void main(String[] args) {
		String str="lala";
		Thread download =new Thread(new Runnable(){//�ֲ������ڲ���
			public void run(){
				System.out.println("down:��ʼ����ͼƬ");
				for(int i=0;i<100;i++){
					System.out.println("down:�����"+i+"%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {}
				}
				isFinished=true;
			}
		});
		Thread show=new Thread(new Runnable(){
			public void run(){
				System.out.println("show:��ʼ��ʾͼƬ");
				try {
					download.join();//������֪��download�߳�ִ���꣨���ˣ����ٽ������
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(str);
				if(!isFinished){
					throw new RuntimeException("ͼƬ��ʾʧ��");
				}
				System.out.println("show:��ʾͼƬ");
			}
		});
		download.start();
		show.start();
	}
}
