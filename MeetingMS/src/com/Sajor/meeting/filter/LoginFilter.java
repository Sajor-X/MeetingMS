package com.Sajor.meeting.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.Sajor.meeting.service.EmployeeService;
import com.Sajor.meeting.vo.Employee;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();		//得到请求地址
		String file[] = uri.split("/");				//通过/分隔，这样，数组的最后一个值，就是页面，

			//跳过登陆注册修改密码，css文件，js文件，图片
			if(file[file.length-1].equals("ChangeServlet") || file[file.length-1].equals("RegistServlet") || file[file.length-1].equals("ViewAllDepartmentsServlet") || file[file.length-1].equals("LoginServlet") || file[file.length-1].equals("MeetingMS") || file[file.length-1].equals("register.jsp") || file[file.length-1].equals("login.jsp") || file[file.length-1].endsWith(".js") || file[file.length-1].endsWith(".css") || file[file.length-1].endsWith(".png") || file[file.length-1].endsWith(".jpg")){
				chain.doFilter(req, res);
			}
			else{
				if(session.getAttribute("employeeid")==null){

					//target问题，没法解决
					/*PrintWriter out = res.getWriter();
				    out.println("<html>"); 
				    out.println("");  
				    out.println("confirm(\"Plause Login!!!\");");
				    out.println("<meta contentType=\"text/html; charset=gb2312\" >");
				    out.println("<script type=\"text/javascript\">");  
				    out.println("window.open ('login.jsp','_top')");  
				    out.println("</script>");  
				    out.println("</html>");*/
				    
				    request.setAttribute("login_msg", "请先登录。");
				    request.getRequestDispatcher("loading.jsp").forward(req, res);
				}
				else{
					chain.doFilter(req, res);
				}
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
