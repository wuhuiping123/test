package cn.lingnanedu.usermgrsys.business.dao;

import cn.lingnanedu.usermgrsys.common.dao.BaseDao;


public interface UserDao extends BaseDao{
	/**
	 * 注册用户/添加用户
	 * @param user  用户信息
	 * @return  成功返回true，失败返回false
	 */
	public boolean addUser(UserVO user);
	
	/**
	 * 用户登录
	 * @param name  用户信息
	 * @param Password  用户信息
	 * @return  用户信息
	 */
	public UserVO login(String name, String Password);

}
