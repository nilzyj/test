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
			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
			String url = "jdbc:mysql://localhost:3306/db_database17"; // �������ݿ�db_database17��URL
			String user = "root"; // ���ݿ��û���
			String password = "111"; // ���ݿ�����
			Connection conn = DriverManager.getConnection(url, user, password); // �������ݿ����ӣ�������Ӷ���conn
			String sql = "insert into tb_users (username,password,sex,age) values('����','111','��','22')"; // ����һ��sql���
			Statement stmt = conn.createStatement(); // ����һ��Statment����
			stmt.executeUpdate(sql); // ִ��sql���
			conn.close(); // �ر����ݿ����Ӷ���
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
