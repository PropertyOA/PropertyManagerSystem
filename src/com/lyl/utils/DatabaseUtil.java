package com.lyl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	
	static {
		init();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void init() {
		Properties params = new Properties();
		String configFile = "database.properties";
		InputStream is = DatabaseUtil.class.getClassLoader().getResourceAsStream(configFile);
		try {
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("username");
		password = params.getProperty("password");
	}
	
	/**
	 * 打开数据库连接
	 * @return 数据库连接
	 * @throws SQLException
	 */
	public static Connection openConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
	/**
	 * 关闭数据库连接
	 * @param connection 数据库连接
	 */
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
