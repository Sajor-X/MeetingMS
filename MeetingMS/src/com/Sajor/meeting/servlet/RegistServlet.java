package com.Sajor.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sajor.meeting.dao.DepartmentDao;
import com.Sajor.meeting.service.EmployeeService;
import com.Sajor.meeting.vo.Department;
import com.Sajor.meeting.vo.Employee;

public class RegistServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegistServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String employeename=request.getParameter("employeeName");
		String username=request.getParameter("userName");
		String password=request.getParameter("psw1");
		int deptid=Integer.parseInt(request.getParameter("deptId"));
		String phone=request.getParameter("tel");
		String email=request.getParameter("email");
		Employee employee=new Employee(employeename,username,password,deptid,email,phone,"0","2");
		EmployeeService service=new EmployeeService();
		int flag=service.regist(employee);
		
		if(flag==1){
			request.setAttribute("login_msg", "注册成功，正在审核。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("register_msg", "用户名已存在，请重新注册。");
			DepartmentDao dao=new DepartmentDao();		
			List<Department> departmentsList=dao.selectAll();
			request.setAttribute("departmentsList", departmentsList);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
