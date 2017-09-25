package day10;
import java.util.*;
/**
 * 将集合或者Map转为线程安全的
 * @author wu.jielin
 *
 */
public class SyncAPIDemo {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		list=Collections.synchronizedList(list);
		
		
		Set<String> set=new HashSet<String>();
		set.add("d");
		set.add("d");
		set.add("d");
		
		set=Collections.synchronizedSet(set);
		
		
		Map<String,String> map=new HashMap<String,String>();
		
		map=Collections.synchronizedMap(map);
	}
}
