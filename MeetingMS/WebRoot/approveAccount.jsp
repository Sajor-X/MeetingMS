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
  <h1>注册审批</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>姓名</th>
          <th>账号名</th>
          <th>联系电话</th>
          <th>电子邮件</th>
          <th>操作</th>
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
          <td>${emp.username}</td>
          <td>${emp.phone}</td>
          <td>${emp.email}</td>
          <td>
             <input type="button" class="clickbutton" value="通过" onclick="window.location.href='ApproveServlet?employeeid=${emp.employeeid}&oper=yes'"/>
             <input type="button" class="clickbutton" value="不通过" onclick="window.location.href='ApproveServlet?employeeid=${emp.employeeid}&oper=no'"/>
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
