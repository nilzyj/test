package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper implements DBConfig {
    
    public static void main(String[] args) {
        try {
            Class.forName(DRIVER);// 加载数据库驱动程序
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 获得Connection对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement stat = null;
        try {
            stat = conn.createStatement();// 获得Statement对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "delete from tb_student where age = 20;";// 创建要执行的SQL语句
        try {
            stat.executeUpdate(sql);// 执行SQL语句
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stat.close();// 关闭Statement
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();// 关闭Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}
