package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
			String url = "jdbc:mysql://localhost:3306/db_database17"; // 声明数据库db_database17的URL
			String user = "root"; // 数据库用户名
			String password = "111"; // 数据库密码
			Connection conn = DriverManager.getConnection(url, user, password); // 建立数据库连接，获得连接对象conn
			String sql = "insert into tb_users (username,password,sex,age) values('张三','111','男','22')"; // 生成一条sql语句
			Statement stmt = conn.createStatement(); // 创建一个Statment对象
			stmt.executeUpdate(sql); // 执行sql语句
			conn.close(); // 关闭数据库连接对象
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
