package day10;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳أ�1�������߳����� 2�������߳�
 * ����ʵ�ֲ��ԣ�
 * --Executors.newCachedThreadPool()����һ���ɸ�����Ҫ�����������̵߳ĳأ���֮ǰ������߳���֮���������
 * --Executors.newFixedThreadPool(int ����������һ���̶��߳��������̳߳أ��Թ�����޽������������Щ�߳�
 * --Executors.newScheduledThreadPool(int corePoolSize)�����ڸ����ӳٺ�����������߶���ִ��
 * --Executros.newSingleThreadExecutor()����һ��ʹ�õ�һworker�̵߳�Executor�����޽���з�ʽ����
 * @author wu.jielin
 *
 */
public class ThreadPoolDemo0 {
	public static void main(String[] args) {
		ExecutorService threadPool=Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++){
		Runnable runn=new Runnable(){
			public void run(){
			for(int i=0;i<5;i++){
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		};
		threadPool.execute(runn);
		}
	}
}
