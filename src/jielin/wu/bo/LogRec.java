package jielin.wu.bo;
/**
 * ��������һ��ƥ��ɶԵ���־
 * @author wu.jielin
 *
 */
public class LogRec {
	private LogData login;
	private LogData logout;
	public LogRec(LogData login,LogData logout){
		this.login=login;
		this.logout=logout;
	}
	@Override
	public String toString() {
		return login + "|"+ logout;
	}
	public LogData getLogin() {
		return login;
	}
	public void setLogin(LogData login) {
		this.login = login;
	}
	public LogData getLogout() {
		return logout;
	}
	public void setLogout(LogData logout) {
		this.logout = logout;
	}

}
