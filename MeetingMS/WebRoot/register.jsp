<%@ page language="java" import="java.util.*, com.Sajor.meeting.vo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Meeting register</title>
<link rel="stylesheet" href="css/register_style.css">
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="js/register_easyform.js"></script>
</head>

<body>

<br>
<div class="form-div">
    <form id="reg-form" action="RegistServlet" method="post">

        <table>
       	 	<tr>
                <td>姓名</td>
                <td><input name="employeeName" type="text" id="employeeName" easyform="length:1-16;real-time;char-chinese;" message="姓名必填" easytip="disappear:lost-focus;theme:blue;">
                </td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input name="userName" type="text" id="uid" easyform="length:4-16;char-normal;real-time;" message="用户名必须为4—16位的英文字母或数字" easytip="disappear:lost-focus;theme:blue;" ajax-message="用户名已存在!">
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input name="psw1" type="password" id="psw1" easyform="length:6-16;" message="密码必须为6—16位" easytip="disappear:lost-focus;theme:blue;"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input name="psw2" type="password" id="psw2" easyform="length:6-16;equal:#psw1;" message="两次密码输入要一致" easytip="disappear:lost-focus;theme:blue;"></td>
            </tr>
            <tr>
                <td>email</td>
                <td><input name="email" type="text" id="email" easyform="email;real-time;" message="Email格式要正确" easytip="disappear:lost-focus;theme:blue;" ajax-message="这个Email地址已经被注册过，请换一个吧!"></td>
            </tr>
            <tr>
                <td>电话</td>
                <td><input name="tel" type="text" id="tel" easyform="tel;length:11;" message="电话格式要正确" easytip="disappear:lost-focus;theme:blue;" ></td>
            </tr>    
            <tr>
            	<td>所在部门</td>
					<td><select name="deptId">
						<%String departmentid=request.getParameter("deptid") ;
							  if(departmentid==null){
							  	departmentid="";
							  }
							%>
						<%List<Department> departmentsList=(List<Department>)(request.getAttribute("departmentsList"));
						  for(Department department:departmentsList){
						 %>
								<option value="<%=department.getDepartmentid()%>" 
								<% if(department.getDepartmentid().equals(departmentid)){out.print("selected");}%>>	
								<%=department.getDepartmentname() %>
								</option>
	                      <%}%>
	                      </select>
	                </td>
            </tr>        
        </table>
        <%String register_msg=(String)request.getAttribute("register_msg"); %>
        <%if(register_msg!=null){ %>
        	<br><center><span><font color='red'> <%=register_msg %></font></span></center>
        <%} %>
		<div class="buttons">
			<input value="注 册" type="submit" style="margin-right:20px; margin-top:20px;">
			<input value="我有账号，我要登录" type="button" style="margin-right:45px; margin-top:20px;" onclick="window.location.href='login.jsp'">
        </div>
		
        <br class="clear">
    </form>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$('#reg-form').easyform();
});
</script>
</body>
</html>
