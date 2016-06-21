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
			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
			String url = "jdbc:mysql://localhost:3306/db_database17"; // �������ݿ�db_database17��URL
			String user = "root"; // ���ݿ��û���
			String password = "111"; // ���ݿ�����
			Connection conn = DriverManager.getConnection(url, user, password); // �������ݿ����ӣ�������Ӷ���conn
			String sql="update tb_users set password=? where sex=?"; // ����һ��sql���
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "admin");
			ps.setString(2, "��");
			int count = ps.executeUpdate(); // ִ��sql���
			System.out.println("�ɹ��޸� "+count+" �����ݣ�");
			conn.close(); // �ر����ݿ����Ӷ���
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�޸�����ʧ�ܣ�");
			e.printStackTrace();
		}
	}

}
