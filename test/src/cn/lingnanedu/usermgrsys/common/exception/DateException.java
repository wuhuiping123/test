package cn.lingnanedu.usermgrsys.common.exception;

public class DateException extends RuntimeException {
	
	public DateException(){
		
	}
	
	public DateException(String arg0) {
		super(arg0);
	}
	
	public DateException(Throwable arg0) {
		super(arg0);
	}
	
	public  DateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
