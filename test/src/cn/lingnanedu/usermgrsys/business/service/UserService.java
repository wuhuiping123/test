package cn.lingnanedu.usermgrsys.business.service;

import cn.lingnanedu.usermgrsys.domain.UserVO;

public interface UserService {
	
	/**
	 * 用户登录
	 * @param name  用户信息
	 * @param Password  用户信息
	 * @return  用户信息
	 */
	public UserVO login(String name, String Password);

}
