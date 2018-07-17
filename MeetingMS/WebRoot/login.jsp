<%@ page language="java" import="java.util.*, com.Sajor.meeting.vo.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<script src="js/jquery-2.2.4.min.js"></script>
		<script src="js/login.js"> </script>
		
		<link rel="stylesheet" href="css/login.css" />
		<meta charset="utf-8" />
		<title>会议</title>
	</head>

	<body >
		<div class="form">
			<div id="landing">登录</div>
			<div id="registered">修改密码</div>
			<div class="fix"></div>
			<div id="landing-content">
				<div id="photo"><img src="img/logo.png" /></div>
				<form action="LoginServlet" method="post" >
					<div class="inp"><input type="text" name = "userName" placeholder="用户名" /></div>
					<div class="inp"><input type="password" name = "userPassword" placeholder="密码" /></div>
					<input type="submit" class="login" value="登陆">
				</form>
				<div id="bottom"><span id="registeredtxt" ><a href='ViewAllDepartmentsServlet?code=regist' >立即注册</a></span><span id="forgotpassword">忘记密码</span></div>
                <%String login_msg=(String)request.getAttribute("login_msg"); %>
                	<%if(login_msg!=null){ %>
                	<br>
                	<center> <span><font color='red'> <%=login_msg %></font></span></center>
                    <%} %>
			</div>
			
			<div id="registered-content">
				<form action="ChangeServlet" method="post">
					<div class="inp"><input type="text" name="change_userName" placeholder="用户名" /></div>
					<div class="inp"><input type="tel" name="change_phone" placeholder="联系电话" /></div>
					<div class="inp"><input type="password" name="change_password" placeholder="密码" /></div>
					<div class="inp"><input type="password" name="change_rpassword" placeholder="确认密码" /></div>
					<input type = "submit" class="login" value="立即修改">
				</form>
				
                	<br>
                	<center><span><font color='red' id="change_msg"> 
                	<%String change_msg=(String)request.getAttribute("change_msg"); %>
                	<%if(change_msg!=null){ %>          <%=change_msg %>            <%} %>
                	</font></span>
                	</center>
			</div>
		</div>
		
		
		<div style="text-align:center;">

</div>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header" style="height: 1080px;">
					<canvas id="demo-canvas" width="1920" height="1080"></canvas>
				</div>
			</div>
		</div>
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/login_demo.js"></script>

	</body>
</html>