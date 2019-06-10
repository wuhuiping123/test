package cn.lingnanedu.usermgrsys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.lingnanedu.usermgrsys.common.exception.DaoException;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class DBUtils {
		
	
	/**
	 * 获取数据库连接
	 * @return  返回数据库连接对象的值
	 */
	public static Connection getConnection(){
		
		Connection conn=null;
		//Statement stmt=null;
		//ResultSet rs=null;
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcldb"; 
		String user="scott";
		String password="123456";
		// 加载驱动器
		try {
			//获取数据库连接对象
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user, password);
			System.out.println("数据库连接成功！");
			
		} catch (ClassNotFoundException e) {
			// 把异常封装成自定义异常
			throw new DaoException("获取connection时找不到类文件！",e);
			//e.printStackTrace();
			//System.out.println("获取connection时找不到类文件！");
		} catch (SQLException e) {
			// 把异常封装成自定义异常
			throw new DaoException("获取connection时SQL异常！",e);
			//e.printStackTrace();
			//System.out.println("获取connection时SQL异常！");
		}			
		return conn;		
	}
	
	/**
	 * 开启事务
	 * @param conn  传输数据库连接对象参数
	 */
	public static void beginTransaction(Connection conn){
		try {
			//将事务的自动提交模式设为假
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("事务开启失败！");
		}
	}
	
	/**
	 * 提交事务
	 * @param conn  传输数据库连接对象参数
	 */
	public static void commit(Connection conn) {
		try {
			//提交事务
			conn.commit();
			//将事务的自动提交模式设为真
			conn.setAutoCommit(true);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("事务提交失败！");
		}
	}
	
	/**
	 * 回滚事务
	 * @param conn  传输数据库连接对象参数
	 */
	public static void rollback(Connection conn) {
		try {
			//回滚事务
			conn.rollback();
			//将事务的自动提交模式设为真
			conn.setAutoCommit(true);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("事务回滚失败！");
		}		
	}
	
	/**
	 * 关闭数据库对象
	 * @param conn  传输数据库连接对象参数
	 */
	public static void closeConnection(Connection conn) {
		try {
			//如果数据库连接对象不为空，关闭该对象
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("关闭数据库对象失败！");
		}
	}
	
	/**
	 * 关闭声明对象
	 * @param rs  传输查询结果集对象参数
	 * @param stmt  传输声明对象参数
	 */
	public static void closeStatement(ResultSet rs, Statement stmt) {
		try {
			//如果查询结果集对象不为空，关闭该对象
			if (rs !=null) {
				rs.close();
			}
			//如果声明对象不为空，关闭该对象
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("关闭声明对象失败！");
		}
	}

}
