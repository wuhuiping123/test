package cn.lingnanedu.usermgrsys.common.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import cn.lingnanedu.usermgrsys.common.exception.DateException;
import cn.lingnanedu.usermgrsys.common.exception.EmailException;


/**
 * 类型转换工具类
 * @author Administrator
 *
 */
public class TypeUtils {
	
	/**
	 * 字符串转换为日期
	 * @param str  指定的字符串
	 * @return  返回转换后的日期
	 */
	public static Date strToDate(String str) {
		Date date = null;
		//设置需格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用parse方法，将字符串解析成指定格式的日期格式
			date = sdf.parse(str);
		} catch (ParseException e) {
			// 把异常封装成自定义异常
			//e.printStackTrace();
			throw new DateException("字符串转换为日期出错！",e);
		}		
		//返回转换后的值
		return date;		
	}
	
	/**
	 * 日期转换字符串
	 * @param date  指定的日期
	 * @return  返回转换后的字符串
	 */
	public static String dateToStr(Date date) {
		String str = null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用format方法，将日期格式解析成字符串
			str = sdf.format(date);
		} catch (Exception e) {
			// 把异常封装成自定义异常
			//e.printStackTrace();
			throw new DateException("日期转换为字符串出错！",e);
		}
		//转换返回后的值
		return str;
	}
	
	/**
	 * 检查邮箱格式
	 * @param email  传入邮箱的参数
	 * @return  返回判断邮箱格式是否错误的布尔值
	 */
	public static boolean checkEmail(String email) {
		//String mail = email.replace("//^([a-zA-Z0-9_\\.\\-])+\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$//", "");
		
		try {
			String mail = email.replace("[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}", "");
			if(mail.length() == 0) {
				return true;
			} else {
				System.out.println("邮箱格式错误！");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new EmailException("日期转换为字符串出错！",e);
		}
		
	}
	
	/**
	 * 判断字符串是否为空
	 * @param str  传入字符串参数
	 * @return  返回判断字符串是否为空的布尔值
	 */
	public static boolean isEmpty(CharSequence str) {
		if(str == null || str.length() == 0) {
			System.out.println("字符串为空！");
			return true;			
		}
		else {
			System.out.println("字符串不为空！");
			return false;			
		}
	}

}
