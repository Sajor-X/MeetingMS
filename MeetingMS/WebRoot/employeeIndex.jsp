<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<jsp:include page="employeeLeft.jsp" flush="true"/>
<head>
	<title>Meeting</title>
</head>

<body>
	<iframe name="mainFrame" height="900px" src="index2.html" style="margin-left: 250px; width: 1000px;"> </iframe>
</body>
</html>
