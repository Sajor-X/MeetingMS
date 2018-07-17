<%@page import="com.Sajor.meeting.util.CounterListener"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta contentType="text/html; charset=gb2312" > 
		
		<title>Meeting</title>
		<link rel="stylesheet" href="css/left_style.css" media="screen" type="text/css" />
	
		
	</head>

	<body>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
		<div class="sidebar">
			<h1><i class="fa fa-bars push"></i>Meeting <span class="color">Menu</span></h1>
			
			<h1>用戶： <span class="color">${sessionScope.employeename}</span></h1>
			<ul>
				<li>
					<a href="index2.html" target="mainFrame"><i class="fa fa-dashboard push"></i>Dashboard<i class="fa fa-angle-right"></i></a><span class="hover"></span>
				</li>
				
				<li>
					<a href="#"><i class="fa fa-user push"></i>个人中心<i class="fa fa-angle-right"></i></a><span class="hover"></span>
					<ul class="sub-menu">
						<li>
							<a href="#">最新通知<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="ViewMyBookingServlet" target="mainFrame">我的预定<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="ViewMyMeetingsServlet" target="mainFrame">我的会议<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
					</ul>
				</li>
				
				<!-- JSTL判断是否为管理员  -->
				<c:if test='${requestScope.role.equals("1")}'>
				<li>
					<a href="#"><i class="fa fa-picture-o push"></i>人员管理<i class="fa fa-angle-right"></i></a><span class="hover"></span>
					<ul class="sub-menu">
						<li>
							<a href="ViewAllDepartmentsServlet?code=viewalldepartments" target="mainFrame">部门管理<i class="fa fa-angle-right"></i></a><span class="hover"></span>
						</li>
						<li>
							<a href="ViewAllEmployeesServlet?code=approve" target="mainFrame">注册审批<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="searchEmployees.jsp" target="mainFrame">搜索员工<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
					</ul>
				</li>
				</c:if>
				
				<li>
					<a href="#"><i class="fa fa-file push"></i>会议预定<i class="fa fa-angle-right"></i></a><span class="hover"></span>
					<ul class="sub-menu">
					<!-- JSTL判断是否为管理员  -->
					<c:if test='${requestScope.role.equals("1")}'>
						<li>
							<a href="addMeetingRoom.jsp" target="mainFrame">添加会议室<i class="fa fa-angle-right"></i></a><span class="hover"></span>
						</li>
					</c:if>
					
						<li>
							<a href="ViewAllMeetingRoomsServlet" target="mainFrame">查看会议室<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="BookMeetingServlet?code=prepare" target='mainFrame'>预定会议<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
					</ul>
				</li>
					
				<li>
					<a href="#"><i class="fa fa-cog push"></i>Settings<i class="fa fa-angle-right"></i></a><span class="hover"></span>
					<ul class="sub-menu">
						<li>
							<a href="#">修改密码<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="#">待开发<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="#">待开发<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="404.jsp" target="mainFrame">404演示<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
					</ul>
				</li>
				<li>
					<a href="login.jsp"><i class="fa fa-plane push"></i>退出<i class="fa fa-angle-right"></i></a><span class="hover"></span>
				</li>
			</ul>
			<h1>当前在线人数: <%=CounterListener.count %></h1>
		</div>
		<script src='js/left_jquery.js'></script>
		<script src="js/left_index.js"></script>
		
	</body>

</html>