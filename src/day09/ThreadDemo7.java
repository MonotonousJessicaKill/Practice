package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep����
 * yield()������ʱ��Ƭ�ò��꣬����yield�ص�runnable
 * 
 * @author wu.jielin
 *���ӱ�
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		while(true){
			System.out.println(sdf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
