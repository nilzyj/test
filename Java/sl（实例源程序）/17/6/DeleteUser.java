package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteUser {

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
			String sql="delete from tb_users where id=1"; // ����һ��sql���
			Statement stmt = conn.createStatement(); // ����һ��Statment����
			stmt.executeUpdate(sql); // ִ��sql���
			System.out.println("ɾ�����ݳɹ���");
			conn.close(); // �ر����ݿ����Ӷ���
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ɾ������ʧ�ܣ�");
			e.printStackTrace();
		}
	}

}
