package day12;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��DOM����XMl
 * @author wu.jielin
 *
 */
public class XMLDemo1 {
	public static void main(String[] args) {
		try{
			/**
			 * ����XML�ļ���������
			 * 1������SAXReader��������ȡXML
			 * 2��ָ��XML�ļ�ʹ��SAXReader��ȡ�������ĵ�����Document,��������Ѿ���ɣ�xml����Ϣ���ѱ���װ����Document��
			 * 3����ȡ��Ԫ��
			 * 4����ȡÿһ��Ԫ�أ��ﵽ����ľ��
			 */
			//1   org.dom4j.xxxx
			SAXReader reader=new SAXReader();
			//2
			/**
			 * ���ö�ȡ����
			 * Document read(InputStream in)
			 * Document read(Reader reader)
			 * Document read(File file)
			 */
			Document doc=reader.read(new File("emp.xml"));
			
			//3
			/**
			 * Element element(String name)��ȡ��Ԫ��������Ϊname����Ԫ��
			 */
			Element root=doc.getRootElement();//��ȡ��Ԫ��
			Element e1=root.element("emp");//��ȡ��һ����Ϊemp����Ԫ��
			List<Element> emps=root.elements("emp");//��ȡ������Ϊemp����Ԫ�ص�list
			
			List<Element> allEmps=root.elements();//��ȡ������Ԫ��
			/**
			 * �������µ�ÿһ����Ԫ��
			 * ��һ���������ڱ���xml��ÿһ���û���Ϣ���Ƚ���Ϣȡ��������empʵ�����ٽ�empʵ���ŵ�������
			 */
			List<Emp> list=new ArrayList<Emp>();
			for (Element element : allEmps) {
				Emp emp=new Emp();
				
				/**
				 * ͨ��element��ȡ����
				 * attribute(int i)��ȡ��i������ֵ
				 * attribute(String name)��ȡ��Ϊname������ֵ
				 */
				Attribute id=element.attribute("id");
				//getName()  getValue
				int idValue=Integer.parseInt(
						id.getValue()
						);
				emp.setId(idValue);
				
				//����emp��ǩ
				//��ȡname��ֵ
				Element name=element.element("name");//��ȡ��Ϊname����Ԫ��
				emp.setName(name.getText());//����getTextTrim...����empʵ��
				
//				emp.setAge(Integer.parseInt(
//						element.element("age").getText())
//						);
				/**
				 * ����ȡ�ӽڵ㣬ֱ�ӻ�ȡ��Ϊname���ӽڵ��ֵ
				 * String elementText(String name)
				 */
				String age=element.elementTextTrim("age");
				emp.setAge(Integer.parseInt(age));
				
				
				emp.setGender(element.elementText("gender"));
				emp.setSalary(Integer.parseInt(
						element.elementText("salary")
						));
				list.add(emp);
			}
			System.out.println(list);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
