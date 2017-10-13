package jielin.wu.bo;

/**
 * LogData��ÿһ��ʵ�����ڱ�ʾwtmpx��һ�����������־��Ϣ
 * 
 * @author wu.jielin
 *
 */
public class LogData {
	/**
	 * ��־��wtmpx�ļ��еĳ��ȣ�ÿһ������372�ֽ�
	 */
	public static final int LOG_LENGTH=372;
	/**
	 * user��ʼλ��
	 */
	public static final int USER_OFFSET=0;
	/**
	 * user�ĳ���
	 */
	public static final int USER_LENGTH=32;
	/**
	 * pid��ʼλ�ã�4�ֽڣ�
	 */
	public  static final int PID_OFFSET=68;
	/**
	 * type��ʼλ��
	 */
	public static final int TYPE_OFFSET=72;
	/**
	 * time��ʼλ��
	 */
	public static final int TIME_OFFSET=80;
	/**
	 * ip��ʼλ��
	 */
	public static final int HOST_OFFSET=114;
	public static final int HOST_LENGTH=258;
	/**
	 * ����ǳ�����
	 */
	public static final short TYPE_LOGIN=7;
	public static final short TYPE_LOGOUT=8;
	// ��¼��
	private String user;
	// ����id
	private int pid;
	// ��־���� ������ �ǳ���
	private short type;
	// ��־���ɵ�ʱ�䣨����ǳ���ʱ�䣩
	private int time;

	@Override
	public String toString() {
		return user + "," + pid + "," + type + "," + time + "," + ip;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	// ��½�û���ip
	private String ip;
	/**
	 * �����ַ�������ʼ������
	 * @param data
	 */
	public LogData(String data){
		String[] array=data.split(",");
		for (int i = 0; i < array.length; i++) {
			this.user=array[0];
			this.pid=Integer.parseInt(array[1]);
			this.type=Short.parseShort(array[2]);
			this.time=Integer.parseInt(array[3]);
			this.ip=array[4];
		}
	}

	public LogData(String user, int pid, short type, int time, String ip) {
		super();
		this.user = user;
		this.pid = pid;
		this.type = type;
		this.time = time;
		this.ip = ip;
	}

}
