package cn.lingnanedu.usermgrsys.common.exception;

public class DateException extends Exception {
	
	public DateException() {
		
	}
	
	
	/**
	 * 构造方法
	 * @param arg0
	 */
	public DateException(String arg0) {
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg0
	 */
	public DateException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg0
	 * @param arg1
	 */
	public  DateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
