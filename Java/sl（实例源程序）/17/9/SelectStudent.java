package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStudent {

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
			String sql="select * from tb_student where sclass='三年二班' ";
			Statement stmt = conn.createStatement(); // 创建一个Statment对象
			ResultSet rs= stmt.executeQuery(sql);
			System.out.println("\t三年二班的学生信息");
			System.out.println("学号\t姓名\t性别\t年龄");
			while(rs.next()){
				System.out.println(rs.getInt("id")+"\t"+rs.getString("sname")+"\t"+rs.getString("sex")+"\t"+rs.getInt("age"));
			}
			conn.close(); // 关闭数据库连接对象
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询数据失败！");
			e.printStackTrace();
		}
	}

}
