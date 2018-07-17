<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- divÊµÏÖ  -->
<!--<html>
	 <head>
		<meta charset="UTF-8">
		<title></title>
		 <script src="js/jquery-2.2.4.min.js"></script> 
		<script type="text/javascript">
			$(function(){ 
				$("div#fream_left").load("admin_left.html"); 
			}) 
			$(function(){ 
				$("div#fream_right").load("a.html"); 
			}) 
		</script>
	</head>
	<body>
	<div id='fream_left' style="width: 250px; border: 0px solid #0FF; color: blue; ">
	</div>
	
	<div id='fream_right' style="height: 100%; border:0px solid #F00; color: blue; margin-left: 260px;">
	</div>
	
	</body>
</html>-->


<html>
<jsp:include page="adminLeft.jsp" flush="true"/>
<head>
<title>Meeting</title>
</head>

<body>
	<iframe name="mainFrame" src="index2.html" style="margin-left:250px; width: 85%; height: 100%"> </iframe>
</body>
</html>
