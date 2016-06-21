package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper implements DBConfig {
    
    public static void main(String[] args) {
        try {
            Class.forName(DRIVER);// �������ݿ���������
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// ���Connection����
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement stat = null;
        try {
            stat = conn.createStatement();// ���Statement����
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "delete from tb_student where age = 20;";// ����Ҫִ�е�SQL���
        try {
            stat.executeUpdate(sql);// ִ��SQL���
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stat.close();// �ر�Statement
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();// �ر�Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}
