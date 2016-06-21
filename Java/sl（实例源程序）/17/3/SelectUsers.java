package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectUsers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 							// 加载数据库驱动
			String url = "jdbc:mysql://localhost:3306/db_database17"; 				// 声明数据库db_database17的URL
			String user = "root"; 											// 数据库用户名
			String password = "111"; 										// 数据库密码
			Connection conn = DriverManager.getConnection(url, user, password); 		// 建立数据库连接，获得连接对象conn
			Statement stmt=conn.createStatement();
			String sql="select * from tb_users";
			ResultSet rs=stmt.executeQuery(sql);
			int id,age;
			String username,pwd,sex;
			System.out.println("id\t用户名\t密码\t性别\t年龄");
			while(rs.next()){
				id=rs.getInt("id");
				username=rs.getString(2);
				pwd=rs.getString("password");
				sex=rs.getString(4);
				age=rs.getInt("age");
				System.out.println(id+"\t"+username+"\t"+pwd+"\t"+sex+"\t"+age);
				
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
