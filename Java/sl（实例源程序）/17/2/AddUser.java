package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
			String sql = "insert into tb_users (username,password,sex,age) values(?,?,?,?)"; // ����һ��sql���
			PreparedStatement ps = conn.prepareStatement(sql); // ����һ��Statment����
			ps.setString(1, "����");							// Ϊsql����е�һ���ʺŸ�ֵ
			ps.setString(2, "aaa");						// Ϊsql����еڶ����ʺŸ�ֵ
			ps.setString(3, "��");						// Ϊsql����е������ʺŸ�ֵ
			ps.setInt(4, 23);						// Ϊsql����е��ĸ��ʺŸ�ֵ
			ps.executeUpdate(); // ִ��sql���
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
