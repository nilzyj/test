package com.mingrisoft;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertString {
    private Connection conn;
    // 获取数据库连接
    public Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/db_database17"; // 连接数据库URL
        String userName = "root"; // 连接数据库的用户名
        String passWord = "111"; // 连接数据库密码
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 获取数据库连接
            if (conn != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 返回Connection对象
    }
    public void insertUsers(String name ,String loves) {
        conn = getConn(); // 获取数据库连接
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into tb_student (sname,hobby) values(?,?)"); // 定义插入数据库的预处理语句         
            statement.setString(1,name);
            statement.setString(2,loves);           
            statement.executeUpdate(); // 执行预处理语句
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
