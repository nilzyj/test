package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DbTools;
import com.model.Students;

public class StuDao {
	
	public int addusers(Students stu){	// 添加学生信息
		int i=0;
		DbTools db=new DbTools();
		Connection conn=db.getConn();
		try {
			String sql="insert into tb_student (sname,sex,age,hobby,sclass)values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, stu.getSname());
			ps.setString(2, stu.getSex());
			ps.setInt(3, stu.getAge());
			ps.setString(4, stu.getHobby());
			ps.setString(5, stu.getSclass());
			i=ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public int updateusers(Students stu,int id){	// 修改学生信息
		int i=0;
		DbTools db=new DbTools();
		Connection conn=db.getConn();
		try {
			String sql="update tb_student set sname=?,sex=?,age=?,hobby=?,sclass=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, stu.getSname());
			ps.setString(2, stu.getSex());
			ps.setInt(3, stu.getAge());
			ps.setString(4, stu.getHobby());
			ps.setString(5, stu.getSclass());
			ps.setInt(6, id);
			i=ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public List selectAll(){				// 查询所有学生信息
		String sql="select * from tb_student";
		DbTools db=new DbTools();
		Connection conn=db.getConn();
		ResultSet rs=null;
		List<Students> ls=new ArrayList<Students>();
		try {
			Statement st=conn.createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next()){
				Students stu=new Students();
				stu.setId(rs.getInt("id"));
				stu.setSname(rs.getString("sname"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				stu.setHobby(rs.getString("hobby"));
				stu.setSclass(rs.getString("sclass"));
				ls.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	public Students getOne(int id){		// 查询一个学生信息
		Students stu=new Students();
		String sql="select * from tb_student where id="+id;
		DbTools db=new DbTools();
		Connection conn=db.getConn();
		ResultSet rs=null;
		try {
			Statement st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				stu.setSname(rs.getString("sname"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				stu.setHobby(rs.getString("hobby"));
				stu.setSclass(rs.getString("sclass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}
	
	public void deleteStu(int id){		// 删除一个学生信息
		String sql="delete from tb_student where id="+id;
		DbTools db=new DbTools();
		Connection conn=db.getConn();
		ResultSet rs=null;
		try {
			Statement st=conn.createStatement();
			st.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
