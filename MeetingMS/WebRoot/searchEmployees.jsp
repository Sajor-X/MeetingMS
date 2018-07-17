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

  <link rel="stylesheet" href="css/searchEmployee_normalize.css">
  <link rel="stylesheet" href="css/searchEmployee_style.css" media="screen" type="text/css" />
  <script src='js/jquery-2.2.4.min.js'></script>
  <script  src="js/approve_account.js"></script>
  
</head>

<body>


  <section class="webdesigntuts-workshop">
	<form action="SearchEmployeesServlet" method="post" id="SearchEmployeesServlet">		    
		<input type="text" name="searchTxt" placeholder="搜索员工">		    	
		<button type="submit" onclick="document.getElementById('SearchEmployeesServlet').submit();">Search</button>
	</form>
</section>

 <section>
  <!--for demo wrap-->
  <h1>搜索员工</h1>
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
			<c:if test="${emp.status eq '2' }">
			<td>
			<div class="button_link">
				账号已关闭
					<span class="line line_top"></span>
					<span class="line line_right"></span>
					<span class="line line_bottom"></span>
					<span class="line line_left"></span>

			</div>
			</td>
			</c:if>
			<c:if test="${emp.status ne '2' }">
				<td>
					<div class="button_link">
					<a href="ApproveServlet?employeeid=${emp.employeeid}&oper=close" style="text-decoration:none;">
					关闭账号
					<span class="line line_top"></span>
					<span class="line line_right"></span>
					<span class="line line_bottom"></span>
					<span class="line line_left"></span>
					</a>
					</div>
				</td>
			</c:if>
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
 
</body>
</html>
