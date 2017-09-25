package day09;
/**
 * 线程其他API
 * @author wu.jielin
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		//获取调用main方法线程的相关信息
		Thread t=Thread.currentThread();
		//获取线程id
		long id=t.getId();
		System.out.println("id:"+id);//id:1
		//获取线程名字
		String name=t.getName();
		System.out.println("name:"+name);//name:main
		
		int priority=t.getPriority();
		System.out.println("优先级："+priority);//优先级：5
		
		System.out.println("state:"+t.getState());
		System.out.println("alive?:"+t.isAlive());
		System.out.println("后台？："+t.isDaemon());
		System.out.println("是否被中断?:"+t.isInterrupted());
//		state:RUNNABLE
//		alive?:true
//		后台？：false
//		是否被中断?:false
	}
}
