package cn.lingnanedu.usermgrsys.common.exception;

public class DaoException extends Exception {
	
	public DaoException(){
		
	}
	
	public DaoException (String arg0){
		super(arg0);
	}
	
	public DaoException (Throwable arg0){
		super(arg0);
	}
	
	public DaoException(String arg0, Throwable arg1){
		super(arg0,arg1);
	}

}




