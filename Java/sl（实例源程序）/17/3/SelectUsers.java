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
			Class.forName("com.mysql.jdbc.Driver"); 							// �������ݿ�����
			String url = "jdbc:mysql://localhost:3306/db_database17"; 				// �������ݿ�db_database17��URL
			String user = "root"; 											// ���ݿ��û���
			String password = "111"; 										// ���ݿ�����
			Connection conn = DriverManager.getConnection(url, user, password); 		// �������ݿ����ӣ�������Ӷ���conn
			Statement stmt=conn.createStatement();
			String sql="select * from tb_users";
			ResultSet rs=stmt.executeQuery(sql);
			int id,age;
			String username,pwd,sex;
			System.out.println("id\t�û���\t����\t�Ա�\t����");
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
