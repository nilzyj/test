package com.mingrisoft;

import java.sql.*;
public class Example {
	public static Connection getConn()  {
		 Connection conn = null;									 // �������ݿ�����
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/db_database17";	 // �������ݿ��URL
		        String user = "root";										 // ���ݿ��û�
		        String password = "111";									 // ���ݿ�����
		        conn = DriverManager.getConnection(url, user, password);		 // �������ݿ�����
		        return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return null;
		}			 // �������ݿ�������
       
       
}
	public void tableStructInfo() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = getConn();							 // ������ݿ����Ӷ���
            st = conn.createStatement();					 // ����Statement����
            String sql = "select * from tb_student";		 // ��ѯ��SQL���
            rs = st.executeQuery(sql);					 // ��ò�ѯ�����
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCounts = rsmd.getColumnCount();		 // ����ֶ�����
            for (int col = 1; col <= colCounts; col++) {
                // �����ṹ�е���������������
                System.out.println("������" + rsmd.getColumnName(col)
                        + "     \t�������ͣ�" + rsmd.getColumnTypeName(col));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();							 // �ر����ݿ�����
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	public static void main(String[] args) {
		Example example = new Example();
		example.tableStructInfo();
	}


}
