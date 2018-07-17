package com.Sajor.meeting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Sajor.meeting.util.ConnectionFactory;
import com.Sajor.meeting.vo.Department;
import com.Sajor.meeting.vo.Employee;

public class DepartmentDao {
	private ConnectionFactory dbhelper = new ConnectionFactory();

	//向表department中插入记录
	public void insert(String departmentname){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="insert into department (departmentname) values(?)";
		try {		
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departmentname);
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
		}	  
	}
	  
	//根据id删除一个部门
	public void delete(int departmentid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="delete from department where departmentid=?";
		try {	
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentid);
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
		}	  
	}
	
	//查询所有部门信息，返回到集合中
	public List<Department> selectAll() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "select * from department";
		List<Department> departmentsList = new ArrayList<Department>();
		Department department = null;
		try {
			conn = dbhelper.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				department = new Department();
				department.setDepartmentid(rs.getString("departmentid"));
				department.setDepartmentname(rs.getString("departmentname"));
				departmentsList.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbhelper.closeStatement(stmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return departmentsList;
	}
}
