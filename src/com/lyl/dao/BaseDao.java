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
