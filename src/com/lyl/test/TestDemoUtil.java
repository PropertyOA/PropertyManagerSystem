package com.lyl.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.lyl.utils.DatabaseUtil;

/**
 * 测试数据库连接
 * @author xiaomao
 *
 */
public class TestDemoUtil {

	/**
	 * 测试打开数据库
	 */
	@Test
	public void testConnectionDB() {
		Connection connection=null;
		try {
			connection = DatabaseUtil.openConnection();
			if(connection!=null) {
				System.out.println("打开数据库成功!");
			}
			DatabaseUtil.closeConnection(connection);
			System.out.println("关闭打开数据库成功!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
