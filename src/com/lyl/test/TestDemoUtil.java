package com.lyl.test;

import java.sql.Connection;

import org.junit.Test;

import com.lyl.dao.BaseDao;

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
		Connection connection=BaseDao.getConn();
		if(connection!=null) {
			System.out.println("打开数据库成功!");
		}
		BaseDao.closeConn(connection);
		System.out.println("关闭打开数据库成功!");
	}
}
