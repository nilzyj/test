package com.mingrisoft;

import java.sql.*;
public class Example {
	public static Connection getConn()  {
		 Connection conn = null;									 // 定义数据库连接
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/db_database17";	 // 声明数据库的URL
		        String user = "root";										 // 数据库用户
		        String password = "111";									 // 数据库密码
		        conn = DriverManager.getConnection(url, user, password);		 // 建立数据库连接
		        return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return null;
		}			 // 加载数据库驱动类
       
       
}
	public void tableStructInfo() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = getConn();							 // 获得数据库连接对象
            st = conn.createStatement();					 // 创建Statement对象
            String sql = "select * from tb_student";		 // 查询的SQL语句
            rs = st.executeQuery(sql);					 // 获得查询结果集
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCounts = rsmd.getColumnCount();		 // 获得字段总数
            for (int col = 1; col <= colCounts; col++) {
                // 输出表结构中的列名和数据类型
                System.out.println("列名：" + rsmd.getColumnName(col)
                        + "     \t数据类型：" + rsmd.getColumnTypeName(col));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();							 // 关闭数据库连接
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
