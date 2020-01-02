package com.lyl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * 数据库访问类
 * @author Administrator
 *
 */
public class BaseDao {

	//数据库连接驱动类
	private static String driver="com.mysql.jdbc.Driver";
	//数据库连接字符串
	private static String url="jdbc:mysql://localhost:3306/db_property";
	//用户名
	private static String userName="root";
	//密码
	private static String userPwd="123456";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,userName,userPwd);
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void closeConn(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 增、删、改共用方法
	 * @param conn 连接对象
	 * @param sql SQL语句
	 * @param obj 参数
	 * @return
	 */
	public static Integer excuteUpdate(Connection conn,String sql,Object...obj) {
		int result=0;
		PreparedStatement pstm=null;
		try {
			pstm=conn.prepareStatement(sql);
			if(obj!=null) {
				for (int i = 0; i < obj.length; i++) {
					pstm.setObject(i, obj[i]);
				}
			}
			result=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result=-1;
		}
		return result;
	}
	
}
