package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.model.Students;

public class DbTools {
	Connection conn;
	public Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/db_database17";
			String user="root";
			String password="111";
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
