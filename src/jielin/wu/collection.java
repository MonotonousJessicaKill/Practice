package day01;

/**
 * ��������������ϰ�ĵ�ע�� �ĵ�ע�Ϳ���ж���࣬��������������
 * 
 * @author wu.jielin
 * @version 1.0
 * @see java.util.Date
 * @since jdk1.7
 */
public class DocDemo {

	public static final int CONST_FIELD = 1;

	/**
	 * main����������
	 * 
	 * @param args
	 *  
	 * @return
	 */
	public static void main(String[] args) {

	}
}
package day01;
/**
 * ��ʶString����
 * @author wu.jielin
 *
 */
public class StringDemo {
	public static void main(String[] args) {
		/**
		 * ��ִ��ʱ�ַ����½���ǰ���ȴӳ�������Ѱ�ң������и��ַ����㲻���½�
		 * ���⣬==�Ƚϵ���ֵ�����õ�ֵΪ��ַ��
		 */
		String str1="123Hello";
		String str2="123Hello";
		/**
		 * ������С����
		 * ��һ�����ʽ�������߶�������������ô��������оͻ���㡣�����������
		 * ���ʽ�е�λ�ã���ʡ����ʱ����
		 */
		String str3="123"+"Hello";
		//String str3="123Hello" �ֽ����е�����
		
		String str4=1+23+"Hello";
		String str5="1"+23+"Hello";
		String str6=1+'2'+"3"+"Hello";//����ǰ��==  '2'��assic���������
		String str7=new String("123Hello");//new��ǿ�Ʋ�����ֻ��ʹ���������Ż�ʹ��
		//�����������еĳ���
		
		int index1=str7.indexOf("");//0
		int index2=str7.indexOf('1');//0
		/**���0��0*/
		System.out.println(index1+","+index2);
	}
}
package day01;

public class StringDemo2 {
	/**
	 * ������
	 */
	public static void main(String[] args) {
		String str="�Ϻ�����ˮ���Ժ���";
		int len=str.length();
		for (int i = 0; i < len/2; i++) {
			if(str.charAt(i)!=str.charAt(len-1-i)){
				System.out.println("���ǻ���");
				return;
			}
		}
		System.out.println("�ǻ���");
	}
	
			

}
package day01;
/**
 * Ƶ���޸ĳ��õ�StringBulder,StringBuffer�ķ�����ȫ��ͬ
 * @author wu.jielin
 *
 */
public class StringBuilderDemo {
	public static void main(String[] args) {
		StringBuilder builder=new StringBuilder("Ŭ��ѧϰ��");
		
		//׷��
		builder.append("Ϊ�˸ı�����");
		System.out.println(builder);
		
		//ɾ��7 8
		builder.delete(7, 9);
		System.out.println(builder);
		
		//���뵽7��ԭ7λ���Ժ�˳��չ
		builder.insert(7, "�ı�");
		String str=builder.toString();
		System.out.println(str);
		
		//���ļ�������reverse
		String s="�Ϻ�����ˮ���Ժ���";
		StringBuilder strb=new StringBuilder(s);
		String s1=strb.reverse().toString();
		System.out.println(s.equals(s1));
	}

}
package day02;
/**
 * һ�仰������̬�������ӿ����ý����������
 * ����˼ά������һ������ʦ����һ���ˣ���̬��ʽ��������ܺ��棬֪����
 * Ϊ����ʦ���������ѧϰ���⣡
 * 
 * @author wu.jielin
 * 
 *�鷽�����þ��ǵ��ø����������͵ķ�����ִ������ķ�����
 */
public class Object1 {
	/**
	 * object��������Ƕ��󣬵���������ʵ���Ƕ�����
	 * һ���Ƕ��Ƕ�����ʵ����һ�ж��Ƕ���һ�ж���object
	 * һ�ж������й��ԣ���object�ж�������Ժ���Ϊ
	 * 
	 * toString()
	 * 
	 */
	public static void main(String[] args) {
		Object1  obj1=new Object1();
		System.out.println(
				//��д�ģ� this is Object1's override toString()
				obj1.toString());//����дday2.Object1@15db9742
	}
	public String toString(){
		return "this is Object1's override toString()";
	}
	
}
package day02;
/**
 * ���֤����֤
 * @author wu.jielin
 *
 */
public class Regular2 {
	/**
	 * 15λ����18λ���ȴ���ͬ�㿪ʼ
	 * \d{15}(\d{2}[0-9xX])?
	 * \d=[0-9]
	 * 
	 */
	public static void main(String[] args) {
		String regex="\\d{15}(\\d{2}[\\dxX])?";
		String id="182384928328485382";
		boolean match =id.matches(regex);
		System.out.println(match);
	}

}
package day02;

public class Object2 {
	/**
	 * println(Object obj)����Ĳ���������Ϊobject����toString()����
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder builder
			=new StringBuilder("lalala");
		System.out.println(builder);
		//lalala,Stringbuilder��д��toString() 
	
	/**
	 * == �Ƚ�ֵ�������ʹ��ֵ���ǵ�ַ,���Ƿ�Ϊͬһ����
	 * equals()�Ƚ�����(����)��������Ҫ����,object��equals�����ǵ���==
	 */
	System.out.println();
	}
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(obj==this){
			return true;
		}
		if(obj instanceof Object2){
			//�Ƚ��߼�
		}
		return false;
	}
}
package day02;

public class Regular4replaceAll {
	/**
	 * replaceAll�����ַ���������������ʽ�Ĳ����滻��
	 * ���ֵ
	 * 
	 */
	public static void main(String[] args) {
		String str="ghjk345t6yfghj56789";
		System.out.println(
				str.replaceAll("\\d+", "RR")//ghjkRRtRRyfghjRR
				);
		
		String message="wqnmlgb!����ô��ôsb!cnm!���djb";
		System.out.println(
				new Regular4replaceAll().hh(message));
				//��г!����ô��ô��г!��г!�����г
	}
	/**
	 * ��г����
	 */
	public String hh(String s){
		String regex
			="(wqnmlgb|cnm|dsb|rnmb|sb|db|djb)";
		return s.replaceAll(regex, "��г");
	}

}
package day02;
/**
 * ��װ�����intΪInteger��charΪCharacter������Ϊ������������ĸ��д
 * ��װ�඼��final��,���̳���Number������
 * @author wu.jielin
 *
 */
public class IntegerDemo {
	public static void main(String[] args) {
		/**
		 * �����//��Ҫ���ڲ����������
		 * �Զ���װ��Ҫע����ǣ���String���������ƣ�
		 * ��-127��128��Integer�Ѿ����ã�ֱ��ȡ�ã�
		 * ����Զ���װ��
		 * �����Χ��Integer�Ķ���ֻ��һ��
		 * �������Ǳ������ɵĻ����Ҫ��װ�ĵط��������˲���
		 */
	int a=2;
	//�ֶ���װ
	Integer i=new Integer(a);
	Integer i1=new Integer(2);
	Character ch=new Character('a');
	Boolean b=new Boolean(true);
	//�Զ���װ
	Integer i2=a;
	
	/**
	 * �����
	 */
	int a2=i.intValue();
	
	
	}
}
package day02;
/**
 * Number������ط���
 * @author wu.jielin
 *
 */
public class NumberDemo {
	public static void main(String[] args) {
		
	/**
	 * ����**Value�ɱ�����ͣ�һ��ֻתΪ������
	 */
	Double d= new Double(1.2);
	double dd=d.doubleValue();
	int i=d.intValue();
	short s=d.shortValue();
	byte b=d.byteValue();
	
	System.out.println(dd+" "+i+" "+s+" "+b);
	/**
	 * 1.2 1 1 1
	 */
	}
}
package day02;

public class Regular1 {
	/**
	 * ������ʽֻ��ע��ʽ
	 */
	public static void main(String[] args) {
		/**
		 * �����ַ [a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.[a-zA-Z0-9]+)+
		 */
		// '\'��java��Ϊת���ַ�,.��java��û�����⺬�壬
		// \.��ʾת�嵫java����֧��ת�壬���Ա���
		// \\��ʾ�����ַ�\���Ӷ�
		//
		String regex = "[a-zA-Z0-9_\\.]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+";
		String mail="wu.jielin@oe.21.vianet.com";
		
		//�ַ���matches���������ַ����Ƿ����㴫������
		//����matches����ֻ֧��ȫƥ�䣬����ͷ��β��Ҳ��Ĭ�Ͽ�ͷ^��β$
		boolean match=mail.matches(regex);
		System.out.println(match);//true
	}
}
package day02;

public class Regular3split {
	/**
	 * split�������� ������������ʽ���ַ���Ϊ��
	 * ���ַ������γɵ��ַ���Ƭ����Ϊ�ַ������鷵��
	 */
	
	public static void main(String[] args) {
		String str="boss jack   marry      jackson";
		String[] array=str.split("\\s+");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}

}
package day02;

public class Regular0 {
	public static void main(String[] args) {
		//��һ�����ֵ�unicode��ֵ
		char c='\u4e00';
		//���һ�����ֵ�unicode��ֵ
		char c1='\u9fa5';
		/**
		 * ���������
		 */
		int count=0;
		for (char c2='\u4e00',i=0; c2 <='\u9fa5'; c2++,i++) {
			count++;
			if(i%50==0){
				System.out.println("\n");
			}
			System.out.print(c2);
		}
		System.out.println(count);//20902������
	}
}
package day03;
import java.util.Date;
/**
 * Date�ڲ�ά��һ���Ӽ�Ԫ��epoch����Ŀǰ�ĺ���ֵ��longֵ
 * ��Ԫ��UTC 1970��1��1�� 00��00��00
 * Date�ڲ��󲿷ַ����Ѿ���Calendarȡ��
 * ���סgetTime() & setTime() ����
 * @author wu.jielin
 */
public class DateDemo {
	public static void main(String[] args) {
	Date date=new Date();//Ĭ�ϵ�ǰϵͳʱ��
	System.out.println(date);//Fri Sep 08 13:28:51 CST 2017
	/**
	 * ��ȡDate�ڲ���longֵ
	 */
	long time=date.getTime();
	System.out.println(time);//1504848817659
	//����ʱ��
	/**
	 * ��������������longֵ��������ʱ��
	 */
	date.setTime(0);
	System.out.println(date);//Thu Jan 01 08:00:00 CST 1970
	System.out.println(new Date(new Date().getTime()
			+24*60*60*1000));//Sat Sep 09 13:46:46 CST 2017
	}
}
package day03;

import java.text.SimpleDateFormat;//text����
import java.util.*;

/**
 * ����һ������ĸ�ʽ�ǵ��Ѻ�ʱ���ַ�����date֮���໥ת��
 * ���췽������һ����ʽ����format���������Ѻ��ַ���
 * y��M��d��m��s��E����
 * a  AM��PM��ʶ
 * H Сʱ��24h�ƣ�
 * h Сʱ��12h�ƣ�
 * @author wu.jielin
 *yyyy-MM-dd HH:mm:ss
 */
public class SimpleDateFormatDemo0 {
	public static void main(String[] args) {
		Date date=new Date();//ϵͳʱ��
		System.out.println(date);//Ĭ���ַ���
		/**
		 * �����ʽ
		 */
		String dateFormat
			="yyyy-MM-dd HH:mm:ss a EEE";
		SimpleDateFormat sdf =new SimpleDateFormat(dateFormat);
		String str=sdf.format(date);
		System.out.println(str);//2017-09-08 14:18:19 ���� ������
		
	}

}
package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʹ��sdf�ַ���תΪDate
 * �ø�ʽȥ��ʼ��sdf����sdfȥparse�����ַ���
 * parse ΪSat Sep 09 14:00:00 CST 2017 
 * @author wu.jielin
 *
 */
public class SimpleDateFormatDemo1 {
	public static void main(String[] args) throws ParseException {
		String str="2017-09-09 14:00:00";
		String format="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		Date date=sdf.parse(str);
		System.out.println(date);
	}
}
package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * ��������ֵ
 * @author wu.jielin
 *
 */
public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		/**
		 * �������գ����������˶�����
		 */
		Date date =new Date();//ϵͳʱ��
		long now=date.getTime();
		Scanner scanner=new Scanner(System.in);
		String birthDay=scanner.nextLine();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long birth=sdf.parse(birthDay).getTime();
		int days=(int)((now-birth)/(24*60*60*1000));//���������Ż��˷�����
		System.out.println("����"+days+"��");
	}
	

}
package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * �����࣬ʹ�ù㷺����GregorianCalendar��
 * getInstance����Ĭ�ϻ�ȡ��ǰϵͳʱ���gregorian����ʱ��
 * @author wu.jielin
 *
 */
public class CalendarDemo0 {
	public static void main(String[] args) {
		//��ȡgregorian����ϵͳʱ��
		//��calendar��date
		Calendar calendar=Calendar.getInstance();
		Date date=calendar.getTime();//��Date����longֵ��ͬ�����ﷵ��Date
		System.out.println(date);//Fri Sep 08 14:55:27 CST 2017
		
	    //��dateתΪcalendar
		Date date1= new Date();
		/**
		 * ��Calendar��ʾDate����ʾ��ʱ��
		 */
		calendar.setTime(date1);
		
	}

}
package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * ʹ��Calendar����ʱ�䷽��
 * @author wu.jielin
 *
 */
public class CalendarDemo1 {
	public static void main(String[] args) {
		Calendar calendar =Calendar.getInstance();
		/**
		 * ��ʾ2017-08-08 15��00��03
		 * hour_of_day��24����HOUR��12����
		 */
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH,Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, 8);//Date��Day_Of_Month�ȼ�
		calendar.set(Calendar.HOUR_OF_DAY,15);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 3);
		Date date=calendar.getTime();
		System.out.println(date);//Tue Aug 08 15:00:03 CST 2017
	}
}
package day03;

import java.util.Calendar;

/**
 * ��ȡCalendar��ĳ��ʱ�������ֵ
 * int get(int field)���ݸ���ʱ�������ȡ��ֵ
 * Calendar.MONTH��Calendar.WEEK_OF_DAY����
 * MONTH Jan1 ...DEC11 ���get����intҪ+1
 * weekOfDay sunday1,Monday2...Saturday7 һ��get����intҪ-1
 * @author wu.jielin
 *
 */
public class CalendarDemo2 {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		//calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		int month = calendar.get(Calendar.MONTH)+1;
		int weekDay=calendar.get(Calendar.DAY_OF_WEEK)-1;
		System.out.println(month+"��");
		System.out.println("����"+(weekDay==0?7:weekDay));
		
	}
}
package day03;

import java.util.Calendar;

/**
 * ʹ��Calendar����ʱ��
 * void add(int field, int days)
 * һ���������DAY_OF_YEAR
 * @author wu.jielin
 *
 */
public class CalendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		//calendar.add(Calendar.DAY_OF_YEAR, 15);
		/**
		 * ����3���º�10�����ܵ���������һ��
		 * ע�⣬������һ��ʱ�������������ͳ�����һ��
		 */
		calendar.add(Calendar.MONTH, 3);
		calendar.add(Calendar.DAY_OF_YEAR, 10);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		System.out.println(calendar.getTime());
		
	}
}
package day03;

import java.util.Calendar;

/**
 * ��ȡ��ǰ�꣬�µ�����
 * @author wu.jielin
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		int days=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(days);//���¶�����30
		days=calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println(days);//���������365
	}
}
package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * ���� �������ڣ�����3��3��3������3����һ��
 * 1 ����Scanner
 * 2 ��ȡ�û���������
 * 3 ����SimpleDateFormat
 * 4 �ַ���-->Date
 * 5 Date-->Calendar
 * 6 ����ʱ��
 * 7 Calendar-->Date
 * 8 Date-->�ַ���
 * 9 ���
 * @author wu.jielin
 *
 */
public class CalendarDemo5 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner=new Scanner(System.in);
		System.out.println(""
				+ "���������ڣ���ʽyyyy-MM-dd");
		String dateStr=scanner.nextLine();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(dateStr);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 3);
		calendar.add(Calendar.MONTH, 3);
		calendar.add(Calendar.DAY_OF_YEAR, 3);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		date=calendar.getTime();
		System.out.println(sdf.format(date));
	}
}
package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * ���㱣����
 * 
 * @author wu.jielin
 *
 */
public class Test {
	/**
	 * output 
	 * Pls input �������� 2017-9-9 
	 * ���뱣�������� 60 
	 * 2017-11-08
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pls input ��������");
		String str = scanner.nextLine();
		System.out.println("���뱣��������");
		int day = Integer.parseInt(scanner.nextLine());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse(str);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		String expiredDate = sdf.format(calendar.getTime());
		System.out.println(expiredDate);
	}

}
String------------>Date------------->Calendar
	  sdf.parse()       calendar.setTime()
----------------->calendar------------->Date--------->String
����calendar.add()       calendar.getTime()  sdf.format()                
package day04;
/**
 * Contains()�ǻ���equals�ģ�
 * Set��List���ظ����Ҳ�ǻ���equals��
 * collection�ӿڹ涨��������size(),isEmpty(),clear()
 * @author wu.jielin
 *
 */
public class CellectionDemo0 {
	
	
	public static void main(String[] args) {
		Integer in1= new Integer(1);
		Integer in2=new Integer(1);
		System.out.println(in1.equals(in2));//integer��equals��д��
		System.out.println(in1==in2);
		Integer in3=1;
		Integer in4=1;
		System.out.println(in3==in4);//true
		
	}

}
package day04;
import java.util.*;
/**
 * ���ϵ�����������
 * ����ժҪ��addAdll(),containsAll()
 * @author wu.jielin
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection conn1=new ArrayList();
		conn1.add("java");
		conn1.add(".net");
		conn1.add("c#");
		conn1.add("php");
		System.out.println(conn1);
		Collection conn2=new ArrayList();
		conn2.add("andriod");
		conn2.add("ios");
		System.out.println(conn2);//collection��toString()��д��
		/**
		 * boolean addAll(Collection c),�����֮�󼯺����������˱仯���򷵻�true
		 */
		conn1.addAll(conn2);
		System.out.println(conn1);
        //[java, .net, c#, php]  [andriod, ios]  [java, .net, c#, php, andriod, ios]
		
		Collection conn3=new ArrayList();
		conn3.add("java");
		conn3.add("ios");
		conn3.add("c++");
		/**
		 * containsAll()����ÿһ���������ŷ���true��ͬcontainsһ������equals�Ƚ�
		 */
		System.out.println(conn1.containsAll(conn3));//false
		

		
	}
}
package day04;

import java.util.*;

/**
 * ɾ��Ԫ��,remove()��������equals�ȽϷ���ɾ��Ԫ�أ�
 * ����removeֻɾ����һ��������equalsΪtrue��Ԫ��
 * @author wu.jielin
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection conn=new ArrayList();
		conn.add("java");
		conn.remove("java");
		System.out.println(conn);//[]
	}
}
package day04;
import java.util.*;
/**
 * foreach,ֻ���������������ܴ��洫ͳѭ��
 * ��ʵ���ڱ���������ʱ����תΪ����������class�ļ�
 * ���Ҳ�����ڱ���������ȥ�޸�Ԫ��
 * @author wu.jielin
 *
 */
public class ForeachDemo {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		for(Object obj:c){//ѭ��������Ԫ�ظ�������
			String str=(String)obj;
			System.out.println(str);
			if("#".equals(str)){
				System.out.println("���������в����޸�");
			}
			
		}
		
		
	}
}
package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ȡ����Ԫ�أ�������,��������.��һ���ӿڣ�ͳһ�ķ�ʽ��������
 * ��������  �ʡ�ȡ��ɾ��ɾ�����Ǳ�Ҫ�ģ�
 * �ʣ�boolean hasNext()
 * @author wu.jielin
 *
 */
public class IteratorDemo {
	public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		c.add("a");
		c.add("b");
		Iterator it=c.iterator();
		while(it.hasNext()){
			Object obj=it.next();
			String str=(String)it.next();
			System.out.println(str);
		}
		/**
		 * ������Ҫ���ڱ��������в�����ͨ�����ϵķ����ı伯��Ԫ��
		 * ʹ��equalsʱ����ʹ��������.equals�����ָ���쳣
		 */
		c.clear();
		System.out.println(c);
		c.add(null);
		c.add(null);
		c.add("nullString");
		Iterator i=c.iterator();
		while(i.hasNext()){
			Object o=i.next();
			if(o==null){
				//c.remove(o);
				i.remove();//ɾ����������Ԫ��
			}
		}
		System.out.println(c);
	}
}
package day04;
import java.util.*;
/**
 * �����еķ����������弯����Ԫ�ص����ͣ����м��϶�֧�ַ���
 * ��ʹ����δ���÷��ͣ�������������ȷ����Ҳ�ܱ���
 * @author wu.jielin
 *
 */
public class TypeDemo {
	public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		c.add("one");
		c.add("two");
		/*for (String string : c) {//ȡ��������String��
			System.out.println(string);
		}*/
		Iterator<String> it=c.iterator();
		while(it.hasNext()){
			String str=it.next();
			System.out.println(str);
		}
	}

}
package day04;

import java.util.*;

/**
 * List���ϣ�ͨ�������򼯣��ص��ǿ��Ը����±����Ԫ��.List�ķ��� T get(int index)
 * T set(int index,T t)��t���õ�index�ϣ�����ֵΪԭλ���ϵ�Ԫ��
 * @author wu.jielin
 *
 */
public class ListDemo0 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");

		String str = list.get(3);
		System.out.println(str);// four
		for (int i = 0; i < list.size(); i++) {

			String str1 = list.get(i);
			if ("two".equals(str1)) {
				String old=list.set(i, "hhh");
			}
		}
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}

	}
}
package day04;
import java.util.*;
/**
 * List������������ɾ��
 * void add(int index,T t),��t���õ�index�ϣ�ԭλ�ü��Ժ������ƶ�
 * Ϊ�������
 * @author wu.jielin
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		list.add(0, "zero");
		System.out.println(list);
		//[one, two, three, four]
		//[zero, one, two, three, four]
		/**
		 * E remove(int index)��indexλ���ϵ�Ԫ��ɾ��������ֵΪ�ղ�ɾ����Ԫ��
		 */
		System.out.println(list.remove(0));//���ر�ɾ����zero

	}
}
package day04;

import java.util.*;

/**
 * ��ȡ�Ӽ�
 * sublist���õ���listһ�����ڴ棬��˸ı�sublistҲ��ı�ԭ��list
 * @author wu.jielin
 *
 */
public class ListDemo2 {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);
		List sublist=list.subList(3, 8);
		System.out.println(sublist);//[3,4,5,6,7]
		
	}
}
package day04;

import java.util.*;

/**
 * �������ת����List�����ǲ���ת����Set��ԭ��set���ܷ��ظ�Ԫ��
 * תΪ��list��ֻ���ġ���Ҫnew ArrayList<String>(Collection list) ���ɲ�����
 * @author wu.jielin
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array ={"one","two","three"};
		List<String> list=Arrays.asList(array);
		//list.add("four");//����
		
		List<String> list1= new ArrayList<String>();
		list.addAll(list);
		
		List<String> list2=new ArrayList<String>(list);
	}
}
package day04;

public class Cell implements Comparable<Cell> {
	private int x;
	private int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	/**
	 * �Ƚϴ�С�����ز���ע�����ֵ��ֻ��עȡֵ��Χ��
	 * ����ֵ<0����ǰ����ȸ����Ķ���С
	 * =0 ���
	 * ����ֵ>0����ǰ����ȸ����Ķ����
	 */
	public int compareTo(Cell o) {
	return this.x<o.x?-1:
		this.x==o.x?0:1;
	//return this.x-o.x;
	}

}
package day04;
import java.util.*;
/**
 * �Զ���Ƚ������Ĭ�����ĵȰ���unicode��Ƚϵ�û������ıȽ�
 * �����Ѿ�ʵ���˵ıȽϹ�������
 * @author wu.jielin
 *
 */
public class CollectionSortDemo2 {
	public static void main(String[] args) {
		List<String	> list=new ArrayList<String>();
		list.add("����");
		list.add("������");
		list.add("����hhhh");
		list.add("С");
		list.add("����΢");
		System.out.println(list);//[����, ������, ����hhhh, С, ����΢] Ĭ�ϸ���unicode�Ƚ�
		Collections.sort(list, new MyComparator());
		System.out.println(list);//[С, ����, ������, ����΢, ����hhhh] �Զ�������ַ������Ƚ�
	}
}
/**
 * �Զ���Ƚ���
 * ʵ��Comparator<T>�ӿڣ�����compare����
 * @author wu.jielin
 *
 */
class MyComparator implements Comparator<String> {
	public int compare(String s1,String s2) {
		return s1.length()-s2.length();
	}

}
package day04;

import java.util.*;

/**
 * ��������
 * Collections�๤�ߵ�ʹ��,Collections.sort(List<T> list)
 * @author wu.jielin
 *
 */
public class CollectionSortDemo0 {
	public static void main(String[] args) {
		List<Integer> c=new ArrayList<Integer>();
		Random rand=new Random(47);
		for(int i=0;i<10;i++){
			c.add(rand.nextInt(100));
		}
		System.out.println(c);
		Collections.sort(c);
		System.out.println(c);
	}
}
package day04;
import java.util.*;
/**
 * Collection--->toArray() //c.toArray(new String[c.size]);
 *  Arrays.asList(T... a),����ֻ��תΪList
 * @author wu.jielin
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		
//		Object[] array=c.toArray();  ������
		//new String[size] ����size���С��collection��size�����Լ����������С
		String[] array=c.toArray(new String[c.size()]);
		for (String string : array) {
			System.out.print(string);
		}
		
		
	}
}
package day04;
import java.util.*;
/**
 * ʹ��Collections��sort��������ҪԪ��ʵ��Comparable�ӿ�
 * String��comparableTo()�����Ѿ���д
 * @author wu.jielin
 *
 */
public class CollectionSortDemo1 {
	public static void main(String[] args) {
		List<Cell> list=new ArrayList<Cell>();
		list.add(new Cell(1,2));
		list.add(new Cell(2,4));
		list.add(new Cell(3,2));
		list.add(new Cell(0,2));
		list.add(new Cell(3,8));
		Collections.sort(list);
		System.out.println(list);
		
		List<String> list1=new ArrayList<String>();
		list1.add("Tom");
		list1.add("Jack");
		list1.add("Mary");
		list1.add("Jason");
		Collections.sort(list1);
		System.out.println(list1);
		list1.add("��#null");
		System.out.println(list1);//[Jack, Jason, Mary, Tom, ��#null]
	}
}



package day04;
import java.util.*;
/**
 * ����Ҫʹ��һ���̳л���ʵ�ֽӿڵĶ�����ֻ��һ�Σ�ʹ�������ڲ������ʽ���������ڻ�
 * ��:Conllections.sort(list,new Comparator<T>(){});
 * @author wu.jielin
 *
 */
public class CollecionsSortTest {
	public static void main(String[] args) {
		List<Emp> emps=new ArrayList<Emp>();
		emps.add(new Emp("Terry",26,6000,'��'));
		emps.add(new Emp("Aleen",23,9000,'Ů'));
		emps.add(new Emp("Smith",45,9830,'��'));
		emps.add(new Emp("Ketty",23,1244,'Ů'));
		
		Collections.sort(emps, 
				new Comparator<Emp>(){
			public int compare(Emp emp1,Emp emp2){
				return emp1.name.compareTo(emp2.name);
			}
		});
		System.out.println(emps);
	}
}

class Emp{
	public String name;
	public int age;
	public char gender;
	public int salary;
	public Emp(String name,int age,int salary,char gender){
		this.name=name;
		this.age=age;
		this.salary=salary;
		this.gender=gender;
	}
	
	public String toString(){
		return "name:"+this.name+", gender:"+this.gender+", age:"+this.age+", salary:"+this.salary;
	}
}
package day05;
import java.util.*;
/**
 * �ӿ�java.util.Queue���У�����һ�����ݣ�FIFO.
 * ���÷���offer,poll,peek
 * ����������һ���Ե�
 * @author wu.jielin
 */
public class QueueDemo {
	/**
	 * boolean offer���,��Ԫ���������β����ӳɹ�����true
	 * ��Զֻ�ܻ�ȡ����Ԫ�أ�ʹ��T poll���ӷ���,��ȡ��ö��в��ٰ�����Ԫ��
	 * T peek��ȡ���ף���remove��Ԫ��
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> queue=new LinkedList<String>();
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		System.out.println(queue);
		String str=queue.poll();
		System.out.println(str);//A
		System.out.println(queue);//[B,C,D]
		String str1=queue.peek();
		System.out.println(str1+"\n"+queue);
		//��������
		while(queue.size()>0){
			String string=queue.poll();
			System.out.println(string);
		}
		System.out.println(queue);//[]
		
	}
}
package day05;
/**
 * ��Ҫ����дequals����ʱ��дhashCode������
 * ��д����
 * ��equals�Ƚ�Ϊtrue��hashCodeֵ������ͬ����֮���Ǳ���ĵ�ҲӦ�������⡣����Ӱ��HashMap���ܡ�
 * hashCode�����ڵ�ǰ��������û�з����ı��ǰ���¶�ε���Ӧ��������ͬ������,��Ϊ�ȶ�ֵ�����ݷ����ı䣬hashCode���Ըı�.
 * source�и�equals��hashCode��ѡ����Ҫ�Ǽ���equals�ľ�ѡ�ļ�������
 * @author wu.jielin
 *
 */
public class HashCodeDemo {
	private int x;
	private int y;
	public HashCodeDemo(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashCodeDemo other = (HashCodeDemo) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
package day05;

import java.util.*;

/**
 * �ӿ�Map,�������еı��ÿһ�����ݰ���������Ϣkey--value ����key��Map�в������ظ����ظ�ֵ����equals����true
 * ���÷���put,get,containsKey,remove
 * �������ó�ʼ������Ĭ��16
 * 
 * @author wu.jielin
 *
 */
public class MapDemo0 {
	/**
	 * V put(K k, V v) ��key�����ڣ���������ݡ���key�Ѵ������滻�������ر��滻������ get���������ڵ�key����null
	 * HashMap,�ȵ���key��hashCode������key��hashCode���õ�һ��������Ȼ��key-value��������ڼ�λ����˾�������hashCodeֵ�ȽϺ�equals�ȽϽ����ͬ��
	 * ����hashMap�ڲ�����ÿһλ�����һ��LinkedList
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("����", 80);
		map.put("��ѧ", 90);
		map.put("Ӣ��", 93);
		map.put("����", 92);
		map.put("��ѧ", 90);
		System.out.println(map.put("����", 83));// null
		System.out.println(map);// {����=92, ����=83, ��ѧ=90, ��ѧ=90, ����=80, Ӣ��=93}
		System.out.println(map.put("����", 99));// 80
		System.out.println(map);// {����=92, ����=83, ��ѧ=90, ��ѧ=90, ����=99, Ӣ��=93}

		int chinese = map.get("����");
		System.out.println(chinese);// 99
		Integer dance = map.get("�赸");// int
										// dance=map.get("�赸")�ᱨ���������Ὣ���Ϊnull.intValue()
		System.out.println(dance);// null

		if (map.containsKey("����")) {
			System.out.println("��������");
			int value = map.remove("����");// ���ر�ɾ����value��û���������򷵻�null
			System.out.println(value);
		}
		System.out.println(map);// {����=92, ����=83, ��ѧ=90, ��ѧ=90, Ӣ��=93}
	}
}
package day05;
import java.util.*;
/**
 * ջ��FILO������һ�������׷��
 * ���÷�������ջpush;��ջpop,peek
 * ջ�ı���Ҳ��һ���Եģ�
 * @author wu.jielin
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack=new LinkedList<String>();//Dequeʵ����Queue
		/**
		 * void push(T t)��ջ
		 * T pop();ȥ��ջ��Ԫ�أ�ȡ�����Ԫ�ر�stack removed
		 */
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		System.out.println(stack);
		
		String str=stack.pop();
		System.out.println(str);//D
		
		String string=stack.peek();
		System.out.println(string);//C
		System.out.println(stack);//[C,B,A]
		
		while(stack.size()>0){
			String s=stack.pop();
			System.out.println(s);
		}
		System.out.println(stack);//[]
	}
}
package day05;
import java.util.*;
import java.util.Map.Entry;
/**
 * ����map�����ַ�ʽ��
 * 1�� ����keySet�������е�key 2��ʹ��entrySet�������еļ�ֵ�� 3��ʹ��values�������е�value�������ã�
 * note:Entry=key-value
 * values���ص���һ������
 * @author wu.jielin
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("����", 80);
		map.put("��ѧ", 90);
		map.put("Ӣ��", 93);
		map.put("����", 92);
		map.put("��ѧ", 90);
		//ʹ��Set<T> keySet�������е�key,�����ü��Ͼ͵��ڱ��������е�key��
		Set<String> keys=map.keySet();
		for (String string : keys) {
			System.out.println("key:"+string);
		}
		//ʹ��entrySet����key-value��Set<Entry<K k,V v>> entrySet()
		Set<Entry<String,Integer>> set=map.entrySet();
		for (Entry<String, Integer> entry : set) {
			String s=entry.getKey();
			int v=entry.getValue();
			System.out.println("key:"+s+"-value:"+v);
		}
		//ʹ��values������������value,value�ǿ��Դ��ظ��ģ�����set�ᶪ����
		Collection<Integer> values=map.values();
		for (Integer integer : values) {
			System.out.println(integer);
		}
	}

}
package day05;
import java.util.*;
/**
 * hashCode��Map������Ӱ��
 * ʹ��HashMap��Ӧ��ע�⣬��Ϊkey�Ķ���1 ���ȵ�key�������д��equals��������ô��дhashCode�����������㡣2 ��Ϊkey�Ķ���������HashMap�����Ӱ��hashcodeֵ
 * �����ݲ�Ҫ�����仯��������Ҳ�����key--value
 * ���ͣ����ֲ�����get��������hashcodeʹ���ٱȽ�equals��
 * @author wu.jielin
 *
 */
public class HashCodeDemoTest {
	public static void main(String[] args) {
		Map<HashCodeDemo,Integer> map=new HashMap<HashCodeDemo, Integer>();
		HashCodeDemo h1=new HashCodeDemo(1,2);
		map.put(h1,1);
		map.put(new HashCodeDemo(2,3),2);
		map.put(new HashCodeDemo(3,4),3);
		map.put(new HashCodeDemo(2,2),14);
		map.put(new HashCodeDemo(1,4),23);
		map.put(new HashCodeDemo(1,5),32);
		h1.setX(10);
		map.put(h1, 11);//������ͬ�Ķ�����Ϊ������key
		System.out.println(map);
		System.out.println(map.get(h1));//11
//		h1.setX(1);
//		System.out.println(map.get(h1));//1
		Set<HashCodeDemo> set=map.keySet();
		System.out.println(set);
	}
}
TreeSet�������
LinkedHashMap�������

CPU----�ڴ�---Ӳ��
��ʦ---���---�ⷿ
package day05;
import java.io.*;
/**
 * java.io.File,�����ļ�����Ŀ¼���󣬻�ȡ���ܱ���Ϣ
 * get...
 * exists�ж��ļ���Ŀ¼�Ƿ���ʵ
 * long length()��ȡ�ļ�ռ�����ֽ�
 * lastModified, isFile
 * @author wu.jielin
 *
 */
public class FileDemo0 {
	public static void main(String[] args) {
		File file=new File("."+File.separator+"demo.txt");
		//��ȡ�ļ���Ŀ¼��
		String name=file.getName();
		System.out.println(name);
		//��ʵ�Բ���
		boolean isExist=file.exists();
		System.out.println(isExist);//true
		//��ȡ��С
		long length=file.length();
		System.out.println(length);//16
		
		boolean read=file.canRead();//�ɶ���
		file.canWrite();
		file.canExecute();
		
		long time=file.lastModified();//����޸�ʱ��
		//�ж��Ƿ����ļ�
		boolean isfile=file.isFile();
		System.out.println("���ļ���"+isfile);//���ļ�:true
	}
}
package day05;
import java.util.*;
/**
 * ͳ���ַ���
 * @author wu.jielin
 *
 */
public class MapTest {
	public static void main(String[] args) {
		String string="good good study, day day up university";
		Map<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		for(int i=0;i<string.length();i++){
			Character ch=string.charAt(i);
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+1);
			}else{
				map.put(ch, 1);
			}
		}
		System.out.println(map);
				
	}

}
package day05;
/**
 * 20�д������£���1�ۼӣ�ÿ�ۼ�һ�����һ�ν������5050������
 * ����ʹ��for if while�ȹؼ��֡�
 * @author wu.jielin
 *
 */
public class hhh {
	static int sum,i=0;
	public static boolean add(int i){
		sum+=i;
		System.out.println(sum);
		i++;
		return sum==5050?true:add(i);
	}
	public static void main(String[] args) {
		add(i);
		System.out.println(sum);
	}
}
package day05;

import java.io.*;

/**
 * FIle[] listFiles(),���س���·�������顣������Ŀ¼�����򷵻�nul���߱�io��
 * ����ȡ������Ϣ
 * @author wu.jielin
 *
 */
public class FileDemo2 {
	public static void main(String[] args) {
		//�鿴��ǰ��Ŀ��Ŀ¼�µ���������
		File dir=new File(".");
		if(dir.isDirectory()){
			//��ȡ�ļ����ַ�������
			String[] fs=dir.list();
			for (String string : fs) {
				System.out.println(string);
			}
			
			//��ȡ����·��File����
			File[] files=dir.listFiles();
			for (File file : files) {
				String name=file.getName();
				long length=file.length();//Ŀ¼û�г���
				System.out.println("name:"+name+" length:"+length);
			}
		}
		
	}
}
package day05;

import java.io.File;
import java.io.FileFilter;

/**
 * listFiles֧���ļ���������FileFilter�ӿڡ�
 * ʵ�ָýӿڵķ���boolean accept(FIle f)
 * �������������������ǰĿ¼�����������������
 * @author wu.jielin
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		File dir=new File("C:\\Users\\wu.jielin"
				+File.separator+"Desktop"+File.separator+"a");
		if(dir.isDirectory()){
			File[] subs=dir.listFiles(new MyFilter());
			for (File file : subs) {
				System.out.println(file.getName());
			}
		}
	}
}
/**
 * ������
 * @author wu.jielin
 *
 */
class MyFilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		String name=pathname.getName();
		return name.endsWith(".txt");
	}
	
}
package day05;

import java.io.*;

/**
 * ʹ��File�����ļ���Ŀ¼
 * note:Ҫ�����༶Ŀ¼�������ڣ��µ��ļ���
 * ��Ҫ�ȴ����༶Ŀ¼(mkdirs)��createNewFile
 * 
 * @author wu.jielin
 *
 */
public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		// �ڵ�ǰ��Ŀ¼�´����ļ�
		File file = new File("love.txt");
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("�����ļ��ɹ�");
		}
		// ɾ��
		if (file.exists()) {
			file.delete();
			System.out.println("deleted");
		}
		// ����Ŀ¼
		File dir = new File("demo");
		if (!dir.exists()) {
			dir.mkdir();
			System.out.println("demo directery creaed");
		}
		// �ж��Ƿ�Ŀ¼
		boolean isDir = dir.isDirectory();
		// ɾ��Ŀ¼
		if (dir.exists()) {
			dir.delete();
			System.out.println("Ŀ¼deleted");
		}
		//�༶����
		File newFile=new File("a/b/c/d.txt");
		newFile.mkdirs();
		if(newFile.exists()){
			System.out.println("a/b/c/d.txt ����");
		}
		//ɾ��
		newFile.delete();
		if(!newFile.exists()){
			System.out.println("a/b/c/d.txt dleeted");
		}
	}
}
package day05;

import java.io.File;

/**
 * �����༶Ŀ¼�µ��ļ�
 * @author wu.jielin
 *
 */
public class FileDemo4 {
	public static void main(String[] args) throws Exception {
		File file=new File("D:"+File.separator+"a"+
				File.separator+"/c/demo.txt");
		File parent=file.getParentFile();
		if(!parent.exists()){
			parent.mkdirs();
			file.createNewFile();
		}
	}

}
package day05;
import java.io.*;
/**
 * ɾ��Ŀ¼
 * ֻ�п�Ŀ¼���ܱ�ɾ��
 * @author wu.jielin
 *
 */
public class DeleteDir {
	public static void main(String[] args) {
		File file=new File("D:"+File.separator+"cs file - copy");
		System.out.println(file.toString()+"  "+file.exists());
		//file.delete();//û���ղ��һ�������Ŀ¼
		deleteDir(file);
		System.out.println(file.exists());
		
	}
	
	public static void deleteDir(File dir){
		if(dir.isDirectory()){
			for (File file : dir.listFiles()) {
				deleteDir(file);
			};
		}
		dir.delete();
	}
}
package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		String path="D:/a/c/demo.txt";
		RandomAccessFile raf=new RandomAccessFile(path, "rw");
		/**
		 * �Ͱ�λ��Ч��ֻ�����Ͱ�λһ���ֽ�
		 * ����-1������EOF(�ļ�ĩβ)
		 */
		int i=raf.read();
		System.out.println(i);
		raf.close();
	}

}
package day06;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ���Է���������д�ļ����ݡ�
 * ����ָ�뵱ǰλ�ö�д,�������ڵ�ǰָ��λ�ý��ж�д
 * RandomAccessFile raf=new RandomAccessFile(File file,String mode)  |
 * RandomAccessFile raf=new RandomAccessFile(String path,String mode)
 * �����ڵĻ��ᴴ�����ļ�
 * ����void write(int n)д��n�ĵͰ�λ,ֻдһ���ֽ�
 * @author wu.jielin
 *
 */
public class RandomAccessFileDemo0 {
	public static void main(String[] args) throws IOException {
		String path="D:/a/c/demo.txt";
		RandomAccessFile raf=new RandomAccessFile(path, "rw");
		//Integer n=15;
		//һ���ֽ����255. 128 64 32 16 8 4 2 1 
		System.out.println(Integer.toBinaryString(0xff));//11111111
		//����д
		raf.write(97);
		raf.close();
	}
}
����������ַ�����ȡ��������
����---ASCII�� һ���ֽڱ�ʾһ���ַ�
��չ---GBK�������
	   GB2312֧�ַ���
���������ʻ�---�ο�Unicode����(һ���Ӽ�)������UTF-8
		      utf-8�����������ֽڣ�Ӣ��һ�ֽ�
note��javaֻ֧��unicode����char�����ֽڣ�
		String str="�Ұ���"
		Bytes[] buff=str.getBytes("UTF-8")
	//  �÷����ҵ�ÿ���ַ���utf-8���ҵ�ÿ���ַ��ĵı��룬���������ֽڶ�������
package day06;

import java.io.*;

/**
 * ����д��һ���ֽ�;
 * String��getBytes����ϵͳĬ���ַ���ת��Ϊ��Ӧ���ֽ�
 * 
 * @author wu.jielin
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile rafw=
				new RandomAccessFile("C:/Users/wu.jielin/Pictures/1.txt","rw");
		String str="�Ұ�������С��";
		byte[] buff=str.getBytes("utf-8");
		rafw.write(buff);
		rafw.close();
	}
}
package day06;
import java.io.*;
import java.util.Arrays;
/**
 * ��ȡһ���ֽ����������
 * int read(byte[] buf)
 * ���Դ��ļ��ж�ȡbuf����length���ֽڲ��Ӹ������һ��λ�ô����ʵ�ʶ�ȡ���ֽڡ�
 * ����ʵ�ʶ�ȡ�����ֽ���
 * @author wu.jielin
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile rafr=new RandomAccessFile("C:/Users/wu.jielin/Pictures/1.txt", "r");
		byte[] buf=new byte[50];
		int len=rafr.read(buf);
		rafr.close();
		System.out.println(len);
		System.out.println(Arrays.toString(buf));
		/**
		 * ���ֽڵ��ַ���
		 */
		String str=new String(buf, "utf-8");
		System.out.println(str.trim());//�Ұ�������С��
	}
}
package day06;
import java.io.*;
/**
 * �ļ�ʹ�û������鿽��
 * note��ѭ�������ڴ��ѭ������
 * @author wu.jielin
 *
 */
public class RandomAccessFileDemo5 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile rafr=new RandomAccessFile(
				"C:/Users/wu.jielin/Pictures/90fba609e42716fb3d8e0a.jpg", "r");
		RandomAccessFile rafw=new RandomAccessFile(
				"C:/Users/wu.jielin/Pictures/lala.jpg", "rw");
		byte[] buff=new byte[100];
		int i;
		while((i=rafr.read(buff))!=-1){
			//�������һ��ֻ����i����ȴд����i-1λ�ú������һ�ζ����ı�д��
			//��0��i���͹���
			rafw.write(buff,0,i);
		}
		rafr.close();
		rafw.close();
	}
}
package day06;
import java.io.*;
/**
 * ���ļ���д�������������
 * @author wu.jielin
 *
 */
public class RandomAccessFileDemo6 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			=new  RandomAccessFile("1.txt", "rw");
		int max=Integer.MAX_VALUE;
		System.out.println(max);
		//01111111 1111111 1111111 1111111
		/*
		raf.write(max>>>24);
		raf.write(max>>>16);
		raf.write(max>>>8);
		raf.write(max);
		*/
		raf.writeInt(max);
		
		raf.close();
		
		
//		System.out.println(i);
	}
}
package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Temp {
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/wu.jielin/Pictures/90fba609e42716fb3d8e0A.jpg");
		if (file.exists()) {
			System.out.println("CaseNotSensitive");
		}
		//���Զ�ȡintֵ
		RandomAccessFile raf = new RandomAccessFile("1.txt", "rw");
		int max=raf.readInt();
		System.out.println(max);
	}
}
package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��һ���ֽ�дһ���ֽڡ�
 * Ч�ʲ������߶�дЧ�ʣ�����Ҫ���ӻ��棬���������ڶ�д����ʱ���ٶ�д������
 * @author wu.jielin
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile rafr=new RandomAccessFile(//File name CaseNotSensitive
					"C:/Users/wu.jielin/Pictures/90fba609e42716fb3d8e0a.jpg", "r");
		RandomAccessFile rafw=new RandomAccessFile(
				"C:/Users/wu.jielin/Pictures/copy.jpg", "rw");
		int i;
		while(-1!=(i=rafr.read())){
			rafw.write(i);
		}
		rafr.close();
		rafw.close();
		
	}

}
randomAccessFile
��ָ��һ���ֽڿ�����Ĭ��ָ���0�ֽ�
package day06;
import java.io.*;
/**
 * RAF���ǻ��ڵ�ǰָ����ָ���λ�þ��ж�д����������һ�ζ�дһ���ֽڲ�����ƶ�
 * ������ļ���ĳ���ط���ȡ�ֽ���Ҫ�Ƚ�ָ���ƶ��������ְ
 * void seek��long position����
 * int skipBytes(int n)��������n���ֽڣ�����ֵΪʵ���������ֽ���
 * ֻ�����Ҫ��ǰ����seek
 * @author wu.jielin
 *
 */
public class RandomAccessFileDemo7 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("d:/a.txt", "rw");//û�л��½�
		long p=raf.getFilePointer();
		System.out.println(p);//0
		raf.write(97);//дһ���ֽ�
		System.out.println(raf.getFilePointer());//1
		raf.writeInt(97);
		System.out.println(raf.getFilePointer());//5,�ļ�5���ֽڣ�ָ��ָ�������ֽ�
		//ͨ��raf��һ���ֽ�
		System.out.println(raf.read());//-1,����û�е������ֽ���
		
		//�ƶ�ָ��λ��
		raf.seek(0);
		System.out.println(raf.read());//97
		
		//λ��1��skip2Byte ,ָ����ĸ��ֽڣ�read����ȡ���ĸ��ֽ�
		raf.skipBytes(3);
		System.out.println(raf.read());//97
	}

}
package day07;
/**
 * 
 * �������Ƿ����ض��ط���������
 * �ڵ���--�ͼ���--->������������ȷ,�����Դ������
 * ������--�߼�����������--->���������ڣ�ͨ������������һ������Ϊ�˼򻯲�����
 * �������Ĺ��췽��������Ҫ������һ����������һ���������������Ķ�ΰ�װ����Ϊ��������
 * 
 * InputStream & OutputStream �ǳ����ࡣ�������ֽ����ĸ���
 * ���е�read������write������RAF�л�����ͬ
 * @author wu.jielin
 *
 */
public class InputAndOutputStream {

}
package day07;
import java.io.*;
/**
 * FileInputStream�ڵ��������ڴ��ļ���ȡ�ֽڵ���
 * @author wu.jielin
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("d:/a.txt");
		int i=fis.read();//��ȡ��һ���ֽ�
		
		byte[] buf=new byte[22];
		//ʵ�ʶ�ȡ�ֽ���
		int len=fis.read(buf);//�ӵڶ����ֽڿ�ʼ��ȡ
		fis.close();
		String str=new String(buf, "utf-8");
		System.out.println(i);//97
		System.out.println(str);//����ѧ��һ����[]
		System.out.println(len);//21
	}
}
package day07;
import java.io.*;
/**
 * FileOutputStream,�ڵ������������ļ�д���ֽڵ���
 * ʹ��FOS��ע�����û���ļ����½����������ļ�ֱ��write��������֮ǰ���ݣ���д�롢��RAF��������RAF�Ǹ��ǡ�
 * ׷��д���������ع��췽��FileOutputStream(String path, true) true����׷��
 * @author wu.jielin
 *
 */
public class FOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("d:/a");//û�л��½�
		//дһ���ֽ�
		fos.write(97);
		//�ӵڶ���λ��дһ���ֽ�����
		String str="����ѧ��һ����";
		byte[] buff=str.getBytes("UTF-8");
		fos.write(buff);
		fos.close();
	}
}
package day07;
import java.io.*;
/**
 * ʹ��fis��fos���и���
 * fis.read(buff),fos.write(buff,0,len)
 * @author wu.jielin
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("D:/j2e_x86.zip");
		
		
		FileOutputStream fos=new FileOutputStream("D:/copy.zip");
		byte[] buff=new byte[10240];
		int len=-1;
		
		while((len=fis.read(buff))!=-1){
			fos.write(buff,0,len);
		}
		fis.close();
		fos.close();
	}
}
package day07;
import java.io.*;
/**
 * �����������ע������
 * ǿ��д��flush����Ϊ�������bos�Ļ����С��bos.write(buff)�������á�
 * ���缴ʱͨ�š�
 * ���⣬close�������ȵ�flush��
 * @author wu.jielin
 *
 */

public class BosDemo {
	public static void main(String[] args) throws IOException {
		String str="kajfkjalsjfklasjf";
		FileOutputStream fos=new FileOutputStream("D:/aaaaaaaa.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		byte[] buf=str.getBytes("utf-8");
		bos.write(buf);
		
		bos.flush();
		bos.close();
	}
}
package day07;
import java.util.*;
import java.io.*;
/**
 * 1.��һ���ض����ݽṹת����һ���ֽ�---���л�
 * 2.���ֽ�д��Ӳ��---�־û�
 *ArrayListʵ�������л��ӿڡ��ӿ�List��û��ʵ�֣����л�ʱ����������
 * @author wu.jielin
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException {
		List<String>  list=new ArrayList<String>();
		list.add("wo");
		list.add("ai");
		list.add("ni");
		
		FileOutputStream fos=new FileOutputStream("d:/lala.obj");
		//д���Ķ������ʵ����serializable�ӿ�
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		//�Ȱ�listתΪ�ֽڣ�Ȼ��д��
		oos.writeObject(list);
		oos.close();
		
	}
}
package day07;
import java.io.*;
/**
 * BufferedInputSteam��Bos��һ��߼���/��������
 * �����������������
 * @author wu.jielin
 *
 */
public class BufferedInputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("D:/copy.zip");
		FileOutputStream fos=new FileOutputStream("D:/BufCopy.zip");
		
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		
		int d=-1;
		//ÿ�β�����ֻ����һ���ֽڣ�bif/bos�ڲ�ά�����л�������
		//���Լ�д��������ԭ�����õ���һ��������bis��bos���ӹ�����һ���ֽ�һ���ֽڵĽ��ӡ��˷�ʱ��
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		//ֻ�������߼���
		bis.close();
		bos.close();
	}
}
package day07;
import java.io.*;
import java.util.*;
/**
 * OIS�����ǽ��ֽ�תΪ����.�������л�
 * transient�ؼ��ֻ������Բ������л��������л���ʱ���õ�Ĭ��ֵ��
 * invaildClassException-----serialCersionUID=**�����л�ʱ�༴ʹ���ˣ��汾�Ų���Ҳ����ʵ�ַ����л���
 * �����Ի��ΪĬ��ֵ
 * ��û�У����ܷ����л���
 * @author wu.jielin
 *
 */
public class OISDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis=new FileInputStream("D:/lala.obj");
		ObjectInputStream ois=new ObjectInputStream(fis);
		List obj=(List)ois.readObject();
		System.out.println(obj);//[wo,ai,ni]
		ois.close();
	}
}
package day07;
import java.io.*;
/**
 * OutputStreamWriter�ַ�����������ַ�Ϊ��λд�����ݣ�
 * �ַ���ֻ�����ַ�����
 * @author wu.jielin
 *
 */
public class OSWDemo {
	public static void main(String[] args) throws IOException {
		/**
		 * ���ļ���д���ı����ݣ�д�ַ�����
		 * 1.FileOutputStream��fileд����
		 * 2.д�����ı����ݣ���
		 */
		FileOutputStream fos=new FileOutputStream("D:/coco.txt");
		fos.write("��Һã��Ұ�����".getBytes("utf-8"));
		fos.write("fghjk".getBytes("utf-8"));
		/**
		 * ֱ����������ָ������
		 */
		OutputStreamWriter osw=new OutputStreamWriter(fos, "utf-8");
		osw.write("\n���Ƕ��Ǻ��˵�");
		osw.close();
	}
}
package day07;
import java.io.*;
/**
 * InputStreamReader�ַ����������ڶ�ȡ�ַ����ݵ���
 * @author wu.jielin
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("d:/coco.txt");
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		int d=-1;
		while((d=isr.read())!=-1){
			System.out.print((char)d);
		}
		isr.close();
	}
}
package day07;
import java.io.*;
/**
 * �ַ��������ļ�
 * @author wu.jielin
 *
 */
public class CopyDomoCharStream {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("d:/wujielin.txt");
		FileOutputStream fos=new FileOutputStream("d:/wujielinaa.txt");
		
		InputStreamReader isr=new InputStreamReader(fis);
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		int d=-1;
		while((d=isr.read())!=-1){
			osw.write(d);
		}
		isr.close();
		osw.close();
	}
}
package day07;
import java.io.*;
/**
 * PrintWriter�����ַ�������������Զ���ˢ�¡���������Ϊ��λд���ַ���
 * ��Ϊ�߼��������췽���ڲ��Լ������˵ͼ���.
 * �Զ���ˢ���ص㣺
 * ��Ҫ��ʱ�ԵĻ�(�����Զ���ˢ�£�PW pw=new PW("shenghuo",true);true����ÿһ��syso���Զ�һ��autoflush��������д������������д��Ч�ʡ�
 * ��Ȼ��֤������ļ�ʱ�ԡ�
 * @author wu.jielin
 *
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		PrintWriter pw=new PrintWriter("d:/pwpw.txt");
		//ʹ��ϵͳĬ�ϵı���������ļ�
		pw.print("���ĸɻ�");
		pw.print("lala");
		pw.close();
		
		//Ҫ�ı��뼯�Ļ�
		PrintWriter pw1=new PrintWriter(
				new OutputStreamWriter(
						new FileOutputStream("d:/kk.txt"),"utf-8"));
		pw1.print("�������ֽ�������writer�����ñ��뼯��Ȼ����װprintwriter��ʾ��");
		pw1.close();//close�����Զ���ˢ��
	}
}
package day07;
import java.io.*;
/**
 * BUfferedReader�����ַ�������������һ��Ϊ��λ��ȡ�ַ�����
 * BR(Reader reader)  
 * String s=br.readLine();
 *�������з������������з�֮ǰ���ַ������㡣����Ϊnull������ļ�ĩβ��
 * @author wu.jielin
 *
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("d:/pwpw.txt");
		BufferedReader br=new BufferedReader(
				new InputStreamReader(fis,"utf-8")
				);
		String string=null;
		while((string=br.readLine())!=null){
			System.out.println(string);
		}
		br.close();
	}
}
package day08;
/**
 * Throwable������Error��Exception
 * ����һ��ֻ��exception������ error��ϵͳ�����ǲ�����ġ�
 * @author wu.jielin
 *
 */
public class Doc {

}
package day08;
/**
 * try catch
 * main ��jvm���ģ����û�д����㱨exception�׸�����main��jvm��jvm����ʽ����kill
 * һ��exception���֣�����catchִ����catch����ִ��trycatch֮�������ˡ�����ִ�к����try���ˡ�
 * @author wu.jielin
 *
 */
public class ExceptionDemo01 {
	
	public static void main(String[] args) {
		System.out.println("start...");
		try{
		String string="a";
		System.out.println(string.length());//��catch�Ļ�����
		System.out.println(Integer.parseInt(string));
		//jvm newһ��nullpointerexception
		//��������catch���ҵ����ʵĲ���Ϊ��������catch.
		//�Ҳ����Ļ����׸������������׸������ߡ�
		
		char ch=string.charAt(0);
		}catch(NullPointerException e){//catch(��ע���쳣����)
			System.out.println("һ����ָ��");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("StringIndexOutofBoundsException");
		}catch(NumberFormatException e){
			System.out.println("NumberFormatException");
		}catch(Exception e){//��������쳣��������������������һ����Զִ�в���
			System.out.println("����ȷ����");
		}
		System.out.println("end...");//�����˳�
	}
}
package day08;

/**
 * ����try���Ƿ񱨴�finally�鶼Ҫִ��
 * 
 * @author wu.jielin
 *
 */
public class FinallyDemo {
	public static void main(String[] args) {
		try {
			System.out.println("�������ݿ�");
			System.out.println("���ӳɹ�");
			System.out.println("��ѯ����");
			System.out.println("���ݲ���");
			String s = "a";
			int i = Integer.parseInt(s);
			System.out.println("���ݴ������");
			System.out.println("���ݱ��������ݿ�");
		} catch (Exception e) {
			System.out.println("�����˴���");
		} finally {
			System.out.println("�Ͽ�����");// ����Ҫ���Ĳ���
		}
		System.out.println("�������");
	}
}
package day08;

/**
 * return��finally�� catch�����󽫷���ֵ��ֵΪ1��Ȼ��finally������ֵ��ֵ��Ϊ��3. ���1,2,3-->3,3,3
 * ���finally��һ�㲻дreturn����������return����ʧЧ
 */
public class Excercise {
	public static void main(String[] args) {
		System.out.println(test(null) + "," + test("") + "," + test("0"));
	}

	public static int test(String str) {

		try {
			return str.charAt(0) - '0';
		} catch (NullPointerException e) {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}
}
package day08;
/**
 * ͨ������·��������throwһ���쳣�������Ǳ��봦��
 * 1.Ϊ���throw���try catch��
 * 2.�ڷ��������������쳣���׳�����֪ͨ�����ߴ�����쳣
 * 3.�����ߴ�����ѭ��������
 * @author wu.jielin
 *
 */
public class ExceptionDemo02 {
	private static int age;
	public static void setAge(int x) throws NullPointerException{
		if(x<0||x>100){//��ָ���쳣����runtimeException���ǷǼ���쳣
			throw new NullPointerException("�������������");
		}
		age=x;
	}
	//main������setAge���׳��쳣����main���봦���쳣
	public static void main(String[] args){
		setAge(200);
	}
}
package day08;
/**
 * 1.��ǰ���������쳣�����Ǵ�������쳣�����β��õ�ǰ�����ܡ�Ӧ��throws
 * 2.�����������﷨Ҫ�󣬵��ǲ�����ҵ���߼�������Ҳ��������throwһ���쳣
 * 
 * ͨ����������������throw��һ���쳣ʵ������������봦����쳣������ʽ
 * 1.Ϊ���throw���try catch
 * 2.������ǰthrows�����쳣�����÷�����
 * 3.���������ߴ���ʽͬ�����ַ�ʽ��
 * ��Ҫ��main����throws Exception/
 * ����쳣�����������ж����Ƿ񱻴�����������벻ͨ����
 * �Ǽ���쳣��Ҳ������ʱ�쳣����ָ�룬�±��������ڳ���Ƶ��̫�ߣ�
 * Ӧ�ó���Ա�Լ������Ͳ���ǿ��Ҫ�󣬱��������ж����Ƿ񱻴�����˵����̫ƶ��û���ˡ�
 * RuntimeException: IllegalArgumentException,NullPointerException,ArrayIndexOutOfBoundsException,ClassCastException,NumberFormatException��/
 * ��д�������throws�ķ���:���Բ����������׳������쳣�������׳������쳣�����ǲ��������쳣��Χ��������ģ����߸����쳣�ĸ��ࡣ
 * ���catch����Ҳ��throw
 * @author wu.jielin
 *
 */
public class ThrowDemo {
	private static int age;
	public static void setAge (int s) throws Exception{
		if(s<0||s>100){//�����RuntimeException�Ͳ��ᱨ��
			throw new Exception("�������������");
		}
		age=s;
	}
	public static void main(String[] args) {
		try {
			setAge(200);
		} catch (Exception e) {
			System.out.println(e.toString());//java.lang.Exception: �������������
            e.printStackTrace();//��λλ��
		}
	}
}
package day08;
/**
 * Exception����
 * 	void printStackTrace();
 * 	String getMessage()����printStackTrace�е�һ�仰���������Ķ���
 * 	Throwable getCause()��ȡ���ͳһ���쳣��װ������������쳣������Ѿ��Ǳ����쳣�ˣ�����null
 * @author wu.jielin
 *
 */
public class ExceptionMethodDemo {
	public static void main(String[] args) {
		System.out.println("start...");
		try{
			String str="a";
			System.out.println(str.length());
			System.out.println(Integer.parseInt(str));
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("error...");
			System.out.println(e.getCause());//null
		}
		System.out.println("end...");
	}
}
package day08;
/**
 * ��ȡ��ʵ�쳣
 * @author wu.jielin
 *
 */
public class ExceptionMethodDemo1 {
	public static void main(String[] args) {
		try {
			doSome();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());//java.lang.NullPointerException
		}
	}
	
	public static void doSome() throws Exception{
		try{
			String s=null;
			System.out.println(s.length());
		}catch(NullPointerException e){
			throw new Exception(e);
		}
	}
}
package day08;
/**
 * �Զ�������쳣
 * ���а汾��д�ã����¶���ֱ�����ɹ��������С�
 * @author wu.jielin
 *
 */
public class IllegalAgeException extends Exception{
	private static final long
						serialversionUID=1L;

	public IllegalAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
