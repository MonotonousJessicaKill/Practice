package jielin.wu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jielin.wu.bo.LogData;

/**
 * 工具类，负责读写数据 把读写逻辑单独定义在该类的目的是为了重用这些逻辑
 * 
 * @author wu.jielin
 *
 */
public class IOUtil {
	/**
	 * 从给定的文件中读取第一行字符串并将其转换成一个long值返回
	 * 
	 * @param file
	 * @return
	 */
	public static long readLong(File file) {
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);

			String line = br.readLine();
			return Long.parseLong(line);

		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
			throw new RuntimeException(e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				// e.printStackTrace();关不掉就算了
			}
		}
	}

	/**
	 * 将给定的long值写入给定的文件
	 */
	public static void saveLong(long l, File file) throws IOException {
		PrintWriter pw = new PrintWriter(file);
		try {
			pw.println(l);
		} finally {
			if(pw!=null){
			pw.close();
			}
		}
	}

	/**
	 * 将集合中的对象的toString写入给定的文件
	 * 
	 * @param list
	 */
	public static void saveList(List list, File file) throws IOException {
		PrintWriter pw = new PrintWriter(file);
		try {
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				pw.println(object);
			}
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	/**
	 * 读取short值并返回
	 * 
	 * @param raf
	 * @return
	 * @throws IOException
	 */
	public static short readShort(RandomAccessFile raf) throws IOException {
		return raf.readShort();
	}

	/**
	 * 从给定的RandomAccessFile的当前位置连续读出给定字节数，并转换成字符串
	 * 
	 * @param raf
	 * @param length
	 * @return
	 */
	public static String readString(RandomAccessFile raf, int length) throws IOException {
		byte[] b = new byte[length];
		raf.read(b);
		return new String(b, "ISO8859-1").trim();
	}

	/**
	 * 读取int值并返回
	 * 
	 * @param raf
	 * @return
	 * @throws IOException
	 */
	public static int readInt(RandomAccessFile raf) throws IOException {
		return raf.readInt();
	}
	/**
	 * 从给定的文件中读取每一条日志并转为一个LogData对象存入list返回
	 */
	public static List<LogData> loadLogData(File file)throws IOException{
		BufferedReader br=null;
		try{
			br=new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file))
					);
			//String[] data;
			List<LogData> list=new ArrayList<LogData>();
			String log=null;
			while((log=br.readLine())!=null){
				//解析过程应该交给LogData原因是该字符串格式由其toString决定，所以自然解析也应交给其自己
				//data=log.split(",");
				list.add(new LogData(log));
			}
			return list;
		}finally{
			if(br!=null){
				br.close();
			}
		}
	}
	
}
