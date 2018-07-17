<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.Sajor.meeting.util.CounterListener"%>
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
			<h1><%=CounterListener.count %></h1>
			<ul>
				<li>
					<a href="#"><i class="fa fa-dashboard push"></i>Dashboard<i class="fa fa-angle-right"></i></a><span class="hover"></span>
				</li>
				
				<li>
					<a href="#"><i class="fa fa-user push"></i>个人中心<i class="fa fa-angle-right"></i></a><span class="hover"></span>
					<ul class="sub-menu">
						<li>
							<a href="#">最新通知<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="#">我的预定<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
							<li>
							<a href="#">我的会议<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
					</ul>
				</li>
				
				<li>
					<a href="#"><i class="fa fa-file push"></i>会议预定<i class="fa fa-angle-right"></i></a><span class="hover"></span>
					<ul class="sub-menu">
						<li>
							<a href="#">查看会议室<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="#">预定会议<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
					</ul>
				</li>
					
				<li>
					<a href="#"><i class="fa fa-cog push"></i>Settings<i class="fa fa-angle-right"></i></a><span class="hover"></span>
					<ul class="sub-menu">
						<li>
							<a href="#">Dashboard Settings<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="#">Profile Settings<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="#">Manage Menu<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
						<li>
							<a href="#">User Profiles<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
					</ul>
				</li>
				<li>
					<a href="#"><i class="fa fa-plane push"></i>Contact<i class="fa fa-angle-right"></i></a><span class="hover"></span>
				</li>
			</ul>
		</div>
		<script src='js/left_jquery.js'></script>
		<script src="js/left_index.js"></script>
		
	</body>

</html>