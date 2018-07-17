<%@ page language="java" import="java.util.*, com.Sajor.meeting.vo.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Meeting</title>
  <link type="text/css" rel="stylesheet" href="css/button_style.css" />
  <link rel="stylesheet" href="css/index_reset.min.css">
  <link rel="stylesheet" href="css/approve_account_style.css">
  <script src='js/jquery-2.2.4.min.js'></script>
  <script src="js/approve_account.js"></script>
</head>

<body>
  <section>
  <!--for demo wrap-->
  <h1>我的预定</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
         <th>会议名称</th>
         <th>会议室名称</th>
         <th>会议开始时间</th>
         <th>会议结束时间</th>
         <th>会议预定时间</th>
         <th>预定者</th>
         <th>操作</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      
       <c:forEach var="item" items="${requestScope.map}">
       
                    <tr>
                        <td>${item.key.meetingname}</td>
                        <td>${item.value[1]}</td>
                        <td>${item.key.starttime}</td>
                        <td>${item.key.endtime}</td>
                        <td>${item.key.reservationtime}</td>
                        <td>${item.value[0]}</td>
                        <td>
                        	<div class="button_link">
                        	<!-- href="ViewMyMeetingDetailServlet?meetingid=${item.key.meetingid}" -->
                            <a class="clickbutton" >查看</a>
                            <span class="line line_top"></span>
							<span class="line line_right"></span>
							<span class="line line_bottom"></span>
							<span class="line line_left"></span>
							</div>
                        </td>
                    </tr>
     
      </c:forEach>
      
      </tbody>
    </table>
  </div>
</section>

<div class="made-with-love">
  Made with
  <i>♥</i> by
  <a target="_blank" >Sajor</a>
</div>

</body>
</html>
