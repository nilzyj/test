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
			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
			String url = "jdbc:mysql://localhost:3306/db_database17"; // �������ݿ�db_database17��URL
			String user = "root"; // ���ݿ��û���
			String password = "111"; // ���ݿ�����
			Connection conn = DriverManager.getConnection(url, user, password); // �������ݿ����ӣ�������Ӷ���conn
			String sql="select * from tb_student where sclass='�������' ";
			Statement stmt = conn.createStatement(); // ����һ��Statment����
			ResultSet rs= stmt.executeQuery(sql);
			System.out.println("\t��������ѧ����Ϣ");
			System.out.println("ѧ��\t����\t�Ա�\t����");
			while(rs.next()){
				System.out.println(rs.getInt("id")+"\t"+rs.getString("sname")+"\t"+rs.getString("sex")+"\t"+rs.getInt("age"));
			}
			conn.close(); // �ر����ݿ����Ӷ���
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��ѯ����ʧ�ܣ�");
			e.printStackTrace();
		}
	}

}
