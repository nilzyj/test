package com.mingrisoft;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertString {
    private Connection conn;
    // ��ȡ���ݿ�����
    public Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/db_database17"; // �������ݿ�URL
        String userName = "root"; // �������ݿ���û���
        String passWord = "111"; // �������ݿ�����
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // ��ȡ���ݿ�����
            if (conn != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // ����Connection����
    }
    public void insertUsers(String name ,String loves) {
        conn = getConn(); // ��ȡ���ݿ�����
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into tb_student (sname,hobby) values(?,?)"); // ����������ݿ��Ԥ�������         
            statement.setString(1,name);
            statement.setString(2,loves);           
            statement.executeUpdate(); // ִ��Ԥ�������
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
