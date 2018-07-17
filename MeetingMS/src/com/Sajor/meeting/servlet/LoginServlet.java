package com.Sajor.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.Sajor.meeting.service.EmployeeService;
import com.Sajor.meeting.util.ConnectionFactory;
import com.Sajor.meeting.vo.*;

public class LoginServlet extends HttpServlet {
	ConnectionFactory dbhelper = new ConnectionFactory();

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		EmployeeService service=new EmployeeService();
		int flag=service.login(userName, userPassword);
		
		//根据业务逻辑方法不同返回值，跳转到不同页面，同时传递不同的提示信息属性
		if(flag==1){
			ServletContext ctxt=this.getServletContext();
			//获得会话对象
			HttpSession session=request.getSession();
			Employee loginedEmployee=service.getLoginedEmployee();
			//把登录成功的员工姓名保存到会话中
			session.setAttribute("employeename", loginedEmployee.getEmployeename());
			session.setAttribute("employeeid", loginedEmployee.getEmployeeid());
			
			//使用JSTL判断
			String role=loginedEmployee.getRole();
			request.setAttribute("role", role);
			request.getRequestDispatcher("adminIndex.jsp").forward(request, response);

			/*if(role.equals("1")){
				request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
			}
			if(role.equals("2")){
				request.getRequestDispatcher("employeeIndex.jsp").forward(request, response);
			}*/
		}else{
			if(flag==0){
				request.setAttribute("login_msg", "正在审核，请耐心等待。");
			}
			
			else if(flag==2){
				request.setAttribute("login_msg", "审核未通过，请核实后重新注册。");
			}
			
			else if(flag==3){
				request.setAttribute("login_msg", "用户名或密码错误，请重试。");
			}
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
