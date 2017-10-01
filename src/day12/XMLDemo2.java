package day12;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.XMLWriter;
/**
 * 使用DOM4j写出一个xml文件
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
		 * 生成一个xml基本的步骤
		 * 1：创建文档对象Document
		 * 2：为Document添加跟节点
		 * 3：为根节点创建根节点
		 * 4：创建XMLWriter
		 * 5：为XMLWriter指定写目标
		 * 6：写出xml
		 */
		//1
		Document doc=DocumentHelper.createDocument();
		
		/**
		 * Document方法
		 * Element addElement(String name)
		 * 该方法用于向文档中添加给定名字的根元素。返回的Element实例就表示该根元素
		 * 需要注意的是该方法只能调用一次，调用第二次会抛出异常
		 */
		Element root=doc.addElement("list");
		//循环添加每一个员工信息
		for (Emp emp : list) {
			/**
			 * Element同样支持addElement(String name)
			 * 向当前标签中添加给定名字的子标签
			 */
			Element empEle=root.addElement("emp");
			//向empEle标签中添加子标签name
			Element name=empEle.addElement("name");
			name.setText(emp.getName());//addText()方法用于追加，set直接替换
			
			empEle.addElement("age").setText(emp.getId()+"");
			empEle.addElement("gender").setText(emp.getGender());
			empEle.addElement("salary").setText(emp.getSalary()+"");
			
			/**
			 * 为元素添加属性
			 * Element addAttribute(String name,String value)
			 * 返回仍然为该标签，这样做的目的是为了可以连续添加属性
			 * 类似StringBuilder.append().append()...
			 */
			empEle.addAttribute("id", emp.getId()+"");
		}
		//结构完善，写出xml
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
			System.out.println("xml写出时遇到io异常");
		}
		
	}
}
