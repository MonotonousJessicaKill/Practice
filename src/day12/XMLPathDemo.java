package day12;
import java.io.File;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
/**
 * 快速获取某个节点
 * 斜杠/表示路径分隔符
 * . 当前级  ..上一级
 *   /list选取根节点list，这是绝对路径
 *   /list/a选取跟标签list下的所有a 绝对路径
 *   list/a 取list下的a 相对路径
 *   //a选取所有的a元素，不管a在哪儿。
 *   //@lang 选取所有的lang属性 不管在哪儿
 *   谓语条件
 *   /list/a[1] 表示选取根标签下的第一个a元素
 *   /list/a[last()] 最后一个
 *   /list/a[positon()<3] 前两个
 *   
 *   //title[@lang] 选取所有含有lang属性的title元素
 *   //title[@lang='cn'] 选取所有含有并且lang的值是cn的title元素
 *   
 *   /bookstore/book[price] 选取跟bookstore下的book节点，要求含有price
 *   /bookstore/book[price>35.00] 选取book节点，含有price并且大于35
 *   /bookstore/book[price]/title 在book层做筛选
 *   /bookstore/book/price[.>35.00]
 *   *表示任意节点
 *   @*任意属性
 *   node()任意节点
 *   //title[@*] 获取只要有属性的title
 * @author wu.jielin
 *
 */
public class XMLPathDemo {
	public static void main(String[] args) {
		try{
			//读取xml
			SAXReader reader=new SAXReader();
			
			Document doc=reader.read(new File("employer.xml"));
			/**
			 * List selectNodes(String xPath)
			 */
			//selectNodes不导入jaxen会报 NoClassFoundException    JaxenException
			List list=doc.selectNodes("/list/emp[salary=19000]");
			for (Object object : list) {
				Element e=(Element)object;
				//System.out.println(e.elementText("name"));//boss
				System.out.println(e);
			}
			//org.dom4j.tree.DefaultElement@2b05039f 
			//[Element: <emp attributes: [org.dom4j.tree.DefaultAttribute@61e717c2 [Attribute: name id value "4"]]/>]

			
			
		}catch(Exception e){
			System.out.println("异常！");
			e.printStackTrace();
		}
	}
}
