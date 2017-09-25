package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep阻塞
 * yield()，分配时间片用不完，主动yield回到runnable
 * 
 * @author wu.jielin
 *电子表
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
