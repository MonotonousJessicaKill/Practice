package day12;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.XMLWriter;
/**
 * ʹ��DOM4jд��һ��xml�ļ�
 * @author wu.jielin
 *
 */
public class XMLDemo2 {
	public static void main(String[] args) {
		List<Emp> list=new ArrayList<Emp>();
		list.add(
				new Emp(1,"jack",33,"male",9000)
				);
		list.add(
				new Emp(2,"jason",30,"male",8000)
				);
		list.add(
				new Emp(3,"mary",33,"female",7000)
				);
		list.add(
				new Emp(4,"boss",40,"male",19000)
				);
		list.add(
				new Emp(5,"herry",23,"male",8300)
				);
		list.add(
				new Emp(6,"snow",27,"male",9200)
				);
		/**
		 * ����һ��xml�����Ĳ���
		 * 1�������ĵ�����Document
		 * 2��ΪDocument��Ӹ��ڵ�
		 * 3��Ϊ���ڵ㴴�����ڵ�
		 * 4������XMLWriter
		 * 5��ΪXMLWriterָ��дĿ��
		 * 6��д��xml
		 */
		//1
		Document doc=DocumentHelper.createDocument();
		
		/**
		 * Document����
		 * Element addElement(String name)
		 * �÷����������ĵ�����Ӹ������ֵĸ�Ԫ�ء����ص�Elementʵ���ͱ�ʾ�ø�Ԫ��
		 * ��Ҫע����Ǹ÷���ֻ�ܵ���һ�Σ����õڶ��λ��׳��쳣
		 */
		Element root=doc.addElement("list");
		//ѭ�����ÿһ��Ա����Ϣ
		for (Emp emp : list) {
			/**
			 * Elementͬ��֧��addElement(String name)
			 * ��ǰ��ǩ����Ӹ������ֵ��ӱ�ǩ
			 */
			Element empEle=root.addElement("emp");
			//��empEle��ǩ������ӱ�ǩname
			Element name=empEle.addElement("name");
			name.setText(emp.getName());//addText()��������׷�ӣ�setֱ���滻
			
			empEle.addElement("age").setText(emp.getId()+"");
			empEle.addElement("gender").setText(emp.getGender());
			empEle.addElement("salary").setText(emp.getSalary()+"");
			
			/**
			 * ΪԪ���������
			 * Element addAttribute(String name,String value)
			 * ������ȻΪ�ñ�ǩ����������Ŀ����Ϊ�˿��������������
			 * ����StringBuilder.append().append()...
			 */
			empEle.addAttribute("id", emp.getId()+"");
		}
		//�ṹ���ƣ�д��xml
		XMLWriter writer=new XMLWriter();
		
		try {
			writer.setOutputStream(new FileOutputStream("employer.xml"));
			writer.write(doc);
			writer.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("xmlд��ʱ����io�쳣");
		}
		
	}
}
