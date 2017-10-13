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
 * �����࣬�����д���� �Ѷ�д�߼����������ڸ����Ŀ����Ϊ��������Щ�߼�
 * 
 * @author wu.jielin
 *
 */
public class IOUtil {
	/**
	 * �Ӹ������ļ��ж�ȡ��һ���ַ���������ת����һ��longֵ����
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
				// e.printStackTrace();�ز���������
			}
		}
	}

	/**
	 * ��������longֵд��������ļ�
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
	 * �������еĶ����toStringд��������ļ�
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
	 * ��ȡshortֵ������
	 * 
	 * @param raf
	 * @return
	 * @throws IOException
	 */
	public static short readShort(RandomAccessFile raf) throws IOException {
		return raf.readShort();
	}

	/**
	 * �Ӹ�����RandomAccessFile�ĵ�ǰλ���������������ֽ�������ת�����ַ���
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
	 * ��ȡintֵ������
	 * 
	 * @param raf
	 * @return
	 * @throws IOException
	 */
	public static int readInt(RandomAccessFile raf) throws IOException {
		return raf.readInt();
	}
	/**
	 * �Ӹ������ļ��ж�ȡÿһ����־��תΪһ��LogData�������list����
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
				//��������Ӧ�ý���LogDataԭ���Ǹ��ַ�����ʽ����toString������������Ȼ����ҲӦ�������Լ�
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
