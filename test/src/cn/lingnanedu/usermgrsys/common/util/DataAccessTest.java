package cn.lingnanedu.usermgrsys.common.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DataAccessTest {

	@Test
	public void testGetConnection() {
		Connection conn=DBUtils.getConnection();
		System.out.println(conn);
		
	}

}
