package day09;
/**
 * �ػ��߳�==��̨�߳�
 * ǰ̨����ͨ���߳�ȫ�����������̽��������ػ��߳�ǿ�ƽ���/
 * ��������ֻʣ�ػ��߳�ʱ���ػ��߳�ǿ�ƽ��������̽�����
 * @author wu.jielin
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		//rose ����ǰ̨�߳�
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
				System.out.println("��ͨ");//ǰ̨�߳̽���
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
		jack.start();//����main�����߳�����
		//while(true);ǰ̨�߳�main��Զ����
		//=while(true){}
	}
}
