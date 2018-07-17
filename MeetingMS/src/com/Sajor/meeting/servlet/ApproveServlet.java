package com.Sajor.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sajor.meeting.dao.EmployeeDao;

 

public class ApproveServlet extends HttpServlet {

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

		int employeeid=Integer.parseInt(request.getParameter("employeeid"));
		String oper =request.getParameter("oper");
		//判断 yes表示通过，no表示不通过，close表示关闭账号
		if(oper != null){
			EmployeeDao dao=new EmployeeDao();
			if(oper.equals("yes")){
				dao.updateStatus(employeeid,"1");
				request.getRequestDispatcher("ViewAllEmployeesServlet?code=approve").forward(request, response);
			}
			else if(oper.equals("no")){
				dao.updateStatus(employeeid,"2");
				request.getRequestDispatcher("ViewAllEmployeesServlet?code=approve").forward(request, response);
			}
			else if(oper.equals("close")){
				dao.updateStatus(employeeid,"2");
				request.getRequestDispatcher("SearchEmployeesServlet").forward(request, response);
			}	
		}
	}
}
