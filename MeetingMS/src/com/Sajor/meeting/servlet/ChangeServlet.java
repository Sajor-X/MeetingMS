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

public class ChangeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ChangeServlet() {
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
		String username=request.getParameter("change_userName");
		String phone=request.getParameter("change_phone");
		String password=request.getParameter("change_password");
		String rpassword=request.getParameter("change_rpassword");
		//判断为空
		if(username.equals("") || phone.equals("") || password.equals("") || rpassword.equals("")){
			request.setAttribute("change_msg", "修改失败，请在输入框中输入。");
		}
		else{
			//重载最后一个没用
			Employee employee=new Employee(username, password, phone, "change");
			EmployeeService service=new EmployeeService();
			//判断两次密码是否一致
			if(password.equals(rpassword)){
				int flag=service.change(employee);
				//判断是否找到此用户
				if(flag==1){
					request.setAttribute("change_msg", "修改成功，正在审核。");
				}
				else{
					request.setAttribute("change_msg", "修改失败，请仔细检查填写信息");
				}
			}
			else{
				request.setAttribute("change_msg", "修改失败，请仔细检查两次密码");
			}
		}
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
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
