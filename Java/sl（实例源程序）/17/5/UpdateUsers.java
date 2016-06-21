package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUsers {

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
			String sql="update tb_users set password=? where sex=?"; // 生成一条sql语句
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "admin");
			ps.setString(2, "男");
			int count = ps.executeUpdate(); // 执行sql语句
			System.out.println("成功修改 "+count+" 条数据！");
			conn.close(); // 关闭数据库连接对象
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("修改数据失败！");
			e.printStackTrace();
		}
	}

}
