<%@ page language="java" import="java.util.*, com.Sajor.meeting.vo.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src='js/jquery-2.2.4.min.js'></script>
<script src='js/addMeetingRoom_prefixfree.min.js'></script>
<script src='js/addMeetingRoom_js.js'></script>
  <link type="text/css" rel="stylesheet" href="css/button_style.css" />
<link rel="stylesheet" type="text/css" href="css/addMeetingRoom_style.css">
<link rel="stylesheet" href="css/searchEmployee_normalize.css">


</head>

<body>
 <h1>修改会议预定</h1>

	<div id="form" class="form-wrapper">
		<label class="text"> <span>会议名称</span>
			<div class="input-wrapper">
				${requestScope.meeting.meetingname}
			</div> 
		</label> 

		<label class="text"> <span>预计参加人数</span>
			<div class="input-wrapper">
				${requestScope.meeting.numberofparticipants}
			</div> 
		</label> 
		
		<label class="text"> <span>预计开始时间</span>
			<div class="input-wrapper">
				${requestScope.meeting.starttime}
			</div> 
		</label> 
		
		<label class="text"> <span>预计结束时间</span>
			<div class="input-wrapper">
				${requestScope.meeting.endtime}
			</div> 
		</label> 
			
		<label class="text"> <span>会议说明</span>
			<div class="input-wrapper">
				${requestScope.meeting.description}
			</div> 
		</label> 
	</div>
	
<link rel="stylesheet" href="css/approve_account_style.css">
<script src="js/approve_account.js"></script>
<section>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
         <th>姓名</th>
         <th>联系电话</th>
         <th>电子邮件</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
	      <c:forEach var="emp" items="${requestScope.employeesList}">
	        <tr>
	          <td>${emp.employeename}</td>
	          <td>${emp.phone}</td>
	          <td>${emp.email}</td>
	        </tr>
	      </c:forEach>
      </tbody>
    </table>
  </div>
</section>

<center>
 	  	<div class="button_link" >
	          	<a class="clickbutton" href="CancelMeetingServlet?meetingid=${requestScope.meeting.meetingid }" style="text-decoration:blink;">取消会议
	          	<span class="line line_top"></span>
				<span class="line line_right"></span>
				<span class="line line_bottom"></span>
				<span class="line line_left"></span>
				</a>
		</div>
		<div class="button_link">
	          	<a class="clickbutton" onclick="window.history.back();" style="text-decoration:blink;">返回
	          	<span class="line line_top"></span>
				<span class="line line_right"></span>
				<span class="line line_bottom"></span>
				<span class="line line_left"></span>
				</a>
		</div>
<center>



</body>

</html>
