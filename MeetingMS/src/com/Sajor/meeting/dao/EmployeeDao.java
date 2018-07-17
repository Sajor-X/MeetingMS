package com.Sajor.meeting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.Sajor.meeting.util.ConnectionFactory;
import com.Sajor.meeting.vo.Employee;


public class EmployeeDao {
	private ConnectionFactory dbhelper = new ConnectionFactory();
	
	//通过用户名和密码查找
	public Employee selectByNamePwd(String username, String pwd) {
		Connection conn = null;
        ResultSet rs = null;
		Employee employee = null;
		PreparedStatement pstmt=null;
		try {
			conn =  dbhelper.getConnection();
			String sql = "select * from employee where username = '" + username + "' and  password = '" + pwd + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next() == true) {
				employee = new Employee();
				employee.setEmployeeid(rs.getInt("employeeid"));
				employee.setEmployeename(rs.getString("employeename"));
				employee.setUsername(rs.getString("username"));
				employee.setPhone(rs.getString("phone"));
				employee.setEmail(rs.getString("email"));
				employee.setStatus(rs.getString("status"));
				employee.setDepartmentid(rs.getInt("status"));
				employee.setPassword(rs.getString("password"));
				employee.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return employee;
	}

	//通过用户名查找
	public Employee selectByUsername(String username) {
		Connection conn = null;
        ResultSet rs = null;
		Employee employee = null;
		PreparedStatement pstmt=null;
		
		try {
			conn = dbhelper.getConnection();
			String sql = "select * from employee where username='" + username + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			if (rs.next() == true) {
				employee = new Employee();
				employee.setEmployeeid(rs.getInt("employeeid"));
				employee.setEmployeename(rs.getString("employeename"));
				employee.setUsername(rs.getString("username"));
				employee.setPhone(rs.getString("phone"));
				employee.setEmail(rs.getString("email"));
				employee.setStatus(rs.getString("status"));
				employee.setDepartmentid(rs.getInt("status"));
				employee.setPassword(rs.getString("password"));
				employee.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return employee;
	}
	
	//修改密码通过用户名和电话查找
	public Employee selectByUsernameAndTel(String username, String tel) {
		Connection conn = null;
        ResultSet rs = null;
		Employee employee = null;
		PreparedStatement pstmt=null;
		try {
			conn = dbhelper.getConnection();
			String sql = "select * from employee where username='" + username + "'and phone='" + tel + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			if (rs.next() == true) {
				employee = new Employee();
				employee.setEmployeeid(rs.getInt("employeeid"));
				employee.setEmployeename(rs.getString("employeename"));
				employee.setUsername(rs.getString("username"));
				employee.setPhone(rs.getString("phone"));
				employee.setEmail(rs.getString("email"));
				employee.setStatus(rs.getString("status"));
				employee.setDepartmentid(rs.getInt("status"));
				employee.setPassword(rs.getString("password"));
				employee.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return employee;
	}
	
	//员工注册
	public void insert(Employee employee) {
		Connection conn = null;
        ResultSet rs = null;
		PreparedStatement pstmt=null;
		String sql = "insert into employee" + "(employeename,username,password,phone,email,departmentid,status,role)" + " values(?,?,?,?,?,?,?,?)";
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getEmployeename());
			pstmt.setString(2, employee.getUsername());
			pstmt.setString(3, employee.getPassword());
			pstmt.setString(4, employee.getPhone());
			pstmt.setString(5, employee.getEmail());
			pstmt.setInt(6, employee.getDepartmentid());
			pstmt.setString(7, "0");
			pstmt.setString(8, "2");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
	}

	//通过用户名和电话更新密码
	public void updatePassword(Employee employee) {
		Connection conn = null;
        ResultSet rs = null;
		PreparedStatement pstmt=null;
		String sql = "update employee set password = ? where username=? and phone=?";
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getPassword());
			pstmt.setString(2, employee.getUsername());
			pstmt.setString(3, employee.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
	}

	//通过id查找
	public Employee selectById(int id){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Employee employee=null;	
		String sql="select * from employee where employeeid="+id;
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs =pstmt.executeQuery(sql);
			if(rs.next()==true){
				employee=new Employee();
				employee.setEmployeeid(rs.getInt("employeeid"));
				employee.setEmployeename(rs.getString("employeename"));
				employee.setUsername(rs.getString("username"));
				employee.setPhone(rs.getString("phone"));
				employee.setEmail(rs.getString("email"));
				employee.setStatus(rs.getString("status"));
				employee.setDepartmentid(rs.getInt("departmentid"));
				employee.setPassword(rs.getString("password"));
				employee.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return employee;
	 }

	//查询所有正在审核的员工信息
	public List<Employee> selectAllEmployee(){
		 Connection conn = null;
	     ResultSet rs = null;
	     PreparedStatement pstmt=null;
		 Employee employee=null;
		 List<Employee> employeeslist=new ArrayList<Employee>();
		 try {
			 conn = dbhelper.getConnection();
			 String sql="select * from employee where role='2' and status='0'";
			 pstmt = conn.prepareStatement(sql);
			 rs =pstmt.executeQuery(sql);
			 while(rs.next()){
				 employee=new Employee();
				 employee.setEmployeeid(rs.getInt("employeeid"));
				 employee.setEmployeename(rs.getString("employeename"));
				 employee.setUsername(rs.getString("username"));
				 employee.setPhone(rs.getString("phone"));
				 employee.setEmail(rs.getString("email"));
				 employee.setStatus(rs.getString("status"));
				 employee.setDepartmentid(rs.getInt("departmentid"));
				 employee.setPassword(rs.getString("password"));
				 employee.setRole(rs.getString("role"));
				 employeeslist.add(employee);
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }finally{
			 dbhelper.closePreparedStatement(pstmt);
			 dbhelper.closeConnection(conn);
			 dbhelper.closeResultSet(rs);
		 }
		 return employeeslist;
	 }
	 
	//根据部门查询所有员工
	public List<Employee> selectEmployeesByDept(int departmentid){
		Connection conn = null;
		ResultSet rs = null;
	    PreparedStatement pstmt=null;
		Employee employee=null;
		List<Employee> employeeslist=new ArrayList<Employee>();
		try {
			conn = dbhelper.getConnection();
			String sql="select * from employee where departmentid="+departmentid;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()){
				employee=new Employee();
				employee.setEmployeeid(rs.getInt("employeeid"));
				employee.setEmployeename(rs.getString("employeename"));
				employee.setUsername(rs.getString("username"));
				employee.setPhone(rs.getString("phone"));
				employee.setEmail(rs.getString("email"));
				employee.setStatus(rs.getString("status"));
				employee.setDepartmentid(rs.getInt("departmentid"));
				employee.setPassword(rs.getString("password"));
				employee.setRole(rs.getString("role"));
				employeeslist.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return employeeslist;
	 }

	//搜索员工   根据关键字查询所有字段
	public List<Employee> selectEmployeesByAll(String searchTxt){
		Connection conn = null;
		ResultSet rs = null;
	    PreparedStatement pstmt=null;
		Employee employee=null;
		List<Employee> employeeslist=new ArrayList<Employee>();
		String sql="SELECT * FROM employee WHERE employeename LIKE '%"+searchTxt+"%' OR username LIKE '%"+searchTxt+"%' OR phone LIKE '%"+searchTxt+"%' OR email LIKE '%"+searchTxt+"%'"; 
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()){
				employee=new Employee();
				employee.setEmployeeid(rs.getInt("employeeid"));
				employee.setEmployeename(rs.getString("employeename"));
				employee.setUsername(rs.getString("username"));
				employee.setPhone(rs.getString("phone"));
				employee.setEmail(rs.getString("email"));
				employee.setStatus(rs.getString("status"));
				employee.setDepartmentid(rs.getInt("departmentid"));
				employee.setPassword(rs.getString("password"));
				employee.setRole(rs.getString("role"));
				employeeslist.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return employeeslist;
	}
	
	//根据姓名、用户名、状态， 查询所有员工信息，返回到集合中。 
	public List<Employee> selectEmployeesByNameStatus(String employeename, String username, String status){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Employee employee=null;
		List<Employee> employeeslist=new ArrayList<Employee>();
		String sql=null;
		String usernamesql, employeenamesql, statussql;
		try {
			conn = dbhelper.getConnection();
			if(employeename==null||employeename.equals("")){
				employeenamesql="";
			}else{
				employeenamesql=" and employeename='"+employeename+"'";
			}

			if(username==null||username.equals("")){
				usernamesql="";
			}else{
				usernamesql=" and username='"+username+"'";
			}

			if(status==null||status.equals("")||status.equals("3")){
				statussql="";
			}else{
				statussql=" and status='"+status+"'";
			}
			
			sql="select * from Employee where role='2' "+usernamesql+employeenamesql+statussql;
			pstmt = conn.prepareStatement(sql);
			rs =pstmt.executeQuery(sql);
			while(rs.next()){
				employee=new Employee();
				employee.setEmployeeid(rs.getInt("employeeid"));
				employee.setEmployeename(rs.getString("employeename"));
				employee.setUsername(rs.getString("username"));
				employee.setPhone(rs.getString("phone"));
				employee.setEmail(rs.getString("email"));
				employee.setStatus(rs.getString("status"));
				employee.setDepartmentid(rs.getInt("departmentid"));
				employee.setPassword(rs.getString("password"));
				employee.setRole(rs.getString("role"));
				employeeslist.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		 return employeeslist;
	 }
	 
	//通过审批
	public void updateStatus(int employeeid, String status){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String sql="update employee set status='"+status+"'where employeeid="+employeeid;
		try {		
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}	  
	}
 
}
