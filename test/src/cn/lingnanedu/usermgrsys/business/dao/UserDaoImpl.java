package cn.lingnanedu.usermgrsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import cn.lingnanedu.usermgrsys.common.exception.DaoException;
import cn.lingnanedu.usermgrsys.common.util.DBUtils;
import cn.lingnanedu.usermgrsys.domain.UserVO;

public class UserDaoImpl implements UserDao {

	/**
	 * 数据库连接
	 */
	private Connection conn ;
	
	/**
	 * 构造方法
	 * @param conn  数据库连接
	 */
	public UserDaoImpl(Connection conn) {
		//给属性赋初始化值
		this.conn = conn;
	}
	
	public boolean addUser(UserVO user) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public UserVO login(String _name, String _password) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement pstat = null;
		UserVO user = null;
		try {
			pstat = conn.prepareStatement
					("select * from T_user where username=? and password=? and status=1");
			pstat.setString(1, _name);
			pstat.setString(2, _password);
			rs = pstat.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setID(rs.getInt("ID"));
				user.setUserID(rs.getString("userID"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("mail"));
				user.setBirthdate(rs.getDate("birthdate"));
				user.setPower(rs.getString("power"));
				user.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// 把异常封装成自定义异常
			throw new DaoException("登录时查询数据出错！",e);
		} finally {
			DBUtils.closeStatement(rs, pstat);
		}
		
		return user;
	}

}
