package day12;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XMl
 * @author wu.jielin
 *
 */
public class XMLDemo1 {
	public static void main(String[] args) {
		try{
			/**
			 * 解析XML文件基本流程
			 * 1：创建SAXReader，用来读取XML
			 * 2：指定XML文件使得SAXReader读取并解析文档对象Document,这里解析已经完成，xml的信息都已被封装到了Document中
			 * 3：获取根元素
			 * 4：获取每一个元素，达到解析木的
			 */
			//1   org.dom4j.xxxx
			SAXReader reader=new SAXReader();
			//2
			/**
			 * 常用读取方法
			 * Document read(InputStream in)
			 * Document read(Reader reader)
			 * Document read(File file)
			 */
			Document doc=reader.read(new File("emp.xml"));
			
			//3
			/**
			 * Element element(String name)获取该元素下面名为name的子元素
			 */
			Element root=doc.getRootElement();//获取根元素
			Element e1=root.element("emp");//获取第一个名为emp的子元素
			List<Element> emps=root.elements("emp");//获取所有名为emp的子元素的list
			
			List<Element> allEmps=root.elements();//获取所有子元素
			/**
			 * 遍历根下的每一个子元素
			 * 创一个集合用于保存xml中每一个用户信息。先将信息取出，存入emp实例，再将emp实例放到集合中
			 */
			List<Emp> list=new ArrayList<Emp>();
			for (Element element : allEmps) {
				Emp emp=new Emp();
				
				/**
				 * 通过element获取属性
				 * attribute(int i)获取第i个属性值
				 * attribute(String name)获取名为name的属性值
				 */
				Attribute id=element.attribute("id");
				//getName()  getValue
				int idValue=Integer.parseInt(
						id.getValue()
						);
				emp.setId(idValue);
				
				//解析emp标签
				//获取name的值
				Element name=element.element("name");//获取名为name的子元素
				emp.setName(name.getText());//或者getTextTrim...存入emp实例
				
//				emp.setAge(Integer.parseInt(
//						element.element("age").getText())
//						);
				/**
				 * 不获取子节点，直接获取名为name的子节点的值
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
