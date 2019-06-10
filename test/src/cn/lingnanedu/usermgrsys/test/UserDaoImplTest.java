package cn.lingnanedu.usermgrsys.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.lingnanedu.usermgrsys.business.dao.UserDaoImpl;
import cn.lingnanedu.usermgrsys.common.util.DBUtils;
import cn.lingnanedu.usermgrsys.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void test() {
		UserDaoImpl u = new UserDaoImpl(DBUtils.getConnection());
		UserVO user = u.login("aaa", "aaa");
		System.out.println(user.getUsername()+" "+user.getPassword() );
	}

}
