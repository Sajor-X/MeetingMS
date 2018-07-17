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
  <link rel="stylesheet" href="css/departments_style.css" media="screen" type="text/css" />
</head>

<body>
  <div class="panel"> 
  <div class="wrap">
  <form action="AddDeleteDepartmentServlet" method="post" id="AddDeleteDepartmentServlet">
    <input type="text" name="departmentname" placeholder="添加部门"/>
    <input type="hidden" name="code" value="add">
  	<button type="submit" onclick="document.getElementById('AddDeleteDepartmentServlet').submit();">添加</button>
    </form>
  </div>
  </div>

 <section>
  <!--for demo wrap-->
  <h1>部门管理</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>部门编号</th>
          <th>部门名称</th>
          <th>操作</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      
      <c:forEach var="dept" items="${requestScope.departmentsList}">
        <tr>
          <td>${dept.departmentid}</td>
          <td>${dept.departmentname}</td>
          <td>
          
          	<div class="button_link">
	          	<a class="clickbutton" href="AddDeleteDepartmentServlet?code=delete&departmentid=${dept.departmentid}" style="text-decoration:blink;">删除
	          	<span class="line line_top"></span>
				<span class="line line_right"></span>
				<span class="line line_bottom"></span>
				<span class="line line_left"></span>
				</a>
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
  <a target="_blank">Sajor</a>
</div>
  <script src='js/jquery-2.2.4.min.js'></script>
  <script  src="js/approve_account.js"></script>
</body>
</html>
