<%@ page language="java" import="java.util.*, com.Sajor.meeting.vo.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Meeting</title>
  
  <link rel="stylesheet" href="css/index_reset.min.css">
  <link rel="stylesheet" href="css/approve_account_style.css">
  <script src='js/jquery-2.2.4.min.js'></script>
  <script src="js/approve_account.js"></script>
</head>

<body>
  <section>
  <!--for demo wrap-->
  <h1>查看会议室</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>门牌编号</th>
          <th>会议室名称</th>
          <th>容纳人数</th>
          <th>当前状态</th>
          <th>操作</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      
      <c:forEach var="room" items='${requestScope.meetingroomsList}'>
        <tr>
          <td>${room.roomnum}</td>
          <td>${room.roomname}</td>
          <td>${room.capacity }</td>
          <c:if test='${room.status.equals("0")}'>
             <td>可用</td>
          </c:if>
          <c:if test='${room.status.equals("1")}'>
             <td>不可用</td>
          </c:if>
          <td> 
          	<a class="clickbutton" href="ViewOneMeetingRoomServlet?roomid=${room.roomid}">查看详情</a> 
          	<a class="clickbutton" href="AddDeleteMeetingRoomServlet?code=delete&roomid=${room.roomid}">删除会议室</a> 
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
