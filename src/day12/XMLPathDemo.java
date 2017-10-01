package day12;
import java.io.File;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
/**
 * ���ٻ�ȡĳ���ڵ�
 * б��/��ʾ·���ָ���
 * . ��ǰ��  ..��һ��
 *   /listѡȡ���ڵ�list�����Ǿ���·��
 *   /list/aѡȡ����ǩlist�µ�����a ����·��
 *   list/a ȡlist�µ�a ���·��
 *   //aѡȡ���е�aԪ�أ�����a���Ķ���
 *   //@lang ѡȡ���е�lang���� �������Ķ�
 *   ν������
 *   /list/a[1] ��ʾѡȡ����ǩ�µĵ�һ��aԪ��
 *   /list/a[last()] ���һ��
 *   /list/a[positon()<3] ǰ����
 *   
 *   //title[@lang] ѡȡ���к���lang���Ե�titleԪ��
 *   //title[@lang='cn'] ѡȡ���к��в���lang��ֵ��cn��titleԪ��
 *   
 *   /bookstore/book[price] ѡȡ��bookstore�µ�book�ڵ㣬Ҫ����price
 *   /bookstore/book[price>35.00] ѡȡbook�ڵ㣬����price���Ҵ���35
 *   /bookstore/book[price]/title ��book����ɸѡ
 *   /bookstore/book/price[.>35.00]
 *   *��ʾ����ڵ�
 *   @*��������
 *   node()����ڵ�
 *   //title[@*] ��ȡֻҪ�����Ե�title
 * @author wu.jielin
 *
 */
public class XMLPathDemo {
	public static void main(String[] args) {
		try{
			//��ȡxml
			SAXReader reader=new SAXReader();
			
			Document doc=reader.read(new File("employer.xml"));
			/**
			 * List selectNodes(String xPath)
			 */
			//selectNodes������jaxen�ᱨ NoClassFoundException    JaxenException
			List list=doc.selectNodes("/list/emp[salary=19000]");
			for (Object object : list) {
				Element e=(Element)object;
				//System.out.println(e.elementText("name"));//boss
				System.out.println(e);
			}
			//org.dom4j.tree.DefaultElement@2b05039f 
			//[Element: <emp attributes: [org.dom4j.tree.DefaultAttribute@61e717c2 [Attribute: name id value "4"]]/>]

			
			
		}catch(Exception e){
			System.out.println("�쳣��");
			e.printStackTrace();
		}
	}
}
