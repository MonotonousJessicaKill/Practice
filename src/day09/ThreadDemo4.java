package day09;
/**
 * �߳�����API
 * @author wu.jielin
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		//��ȡ����main�����̵߳������Ϣ
		Thread t=Thread.currentThread();
		//��ȡ�߳�id
		long id=t.getId();
		System.out.println("id:"+id);//id:1
		//��ȡ�߳�����
		String name=t.getName();
		System.out.println("name:"+name);//name:main
		
		int priority=t.getPriority();
		System.out.println("���ȼ���"+priority);//���ȼ���5
		
		System.out.println("state:"+t.getState());
		System.out.println("alive?:"+t.isAlive());
		System.out.println("��̨����"+t.isDaemon());
		System.out.println("�Ƿ��ж�?:"+t.isInterrupted());
//		state:RUNNABLE
//		alive?:true
//		��̨����false
//		�Ƿ��ж�?:false
	}
}
