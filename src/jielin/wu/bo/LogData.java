package jielin.wu.bo;

/**
 * LogData的每一个实例用于表示wtmpx的一条解析后的日志信息
 * 
 * @author wu.jielin
 *
 */
public class LogData {
	/**
	 * 日志在wtmpx文件中的长度，每一条都是372字节
	 */
	public static final int LOG_LENGTH=372;
	/**
	 * user起始位置
	 */
	public static final int USER_OFFSET=0;
	/**
	 * user的长度
	 */
	public static final int USER_LENGTH=32;
	/**
	 * pid开始位置（4字节）
	 */
	public  static final int PID_OFFSET=68;
	/**
	 * type起始位置
	 */
	public static final int TYPE_OFFSET=72;
	/**
	 * time起始位置
	 */
	public static final int TIME_OFFSET=80;
	/**
	 * ip起始位置
	 */
	public static final int HOST_OFFSET=114;
	public static final int HOST_LENGTH=258;
	/**
	 * 登入登出类型
	 */
	public static final short TYPE_LOGIN=7;
	public static final short TYPE_LOGOUT=8;
	// 登录名
	private String user;
	// 进程id
	private int pid;
	// 日志类型 （登入 登出）
	private short type;
	// 日志生成的时间（登入登出的时间）
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

	// 登陆用户的ip
	private String ip;
	/**
	 * 解析字符串来初始化本身
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
