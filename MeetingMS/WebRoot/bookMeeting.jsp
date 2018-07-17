<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<script src='js/jquery-2.2.4.min.js'></script>
	<script src='js/addMeetingRoom_prefixfree.min.js'></script>
	<script src='js/addMeetingRoom_js.js'></script>
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<script language="javascript" type="text/javascript" src="js/bookMeeting_js.js"></script>
	<link rel="stylesheet" type="text/css" href="css/index_reset.min.css">
	<link rel="stylesheet" type="text/css" href="css/addMeetingRoom_style.css">
	<link rel="stylesheet" href="css/searchEmployee_normalize.css">

</head>

<body>
 <h1>预定会议</h1>
 <form method="post" action="BookMeetingServlet">
	<div id="form" class="form-wrapper">
	
		<label class="text"> <span>会议名称</span>
			<div class="input-wrapper">
				<input id="meetingname"  name="meetingname" type="text" maxlength="20" />
			</div> 
		</label> 
		
		<label class="text"> <span>预计参加人数</span>
			<div class="input-wrapper">
				<input id="numofparticipants" name="numofparticipants" type="text" maxlength="20"/>
			</div> 
		</label> 
		
		<label class="text"> <span>预计开始时间</span>
			<div class="input-wrapper">
				<input class="Wdate" type="text" id="starttime" name="starttime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
			</div> 
		</label> 
		<label class="text"> <span>预计结束时间</span>
			<div class="input-wrapper">
				<input class="Wdate" type="text" id="endtime" name="endtime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
			</div> 
		</label> 
		
		<label class="text"> <span>选择会议室</span>
			<div class="input-wrapper">
				<select id="roomid" name="roomid" onfocus="refreshRooms()">
						<option>请选择会议室</option>
								<c:forEach var="room" items="${requestScope.roomsList}">
									<option value="${room.roomid}">${room.roomname}</option>
								</c:forEach>
				</select>
			</div> 
		</label> 
		<label class="text"> <span>会议说明 </span>
			<div class="input-wrapper">
				<textarea id="description" name="description" maxlength="200" rows="5" cols="60" placeholder="200字以内的文字描述"></textarea>
			</div> 
		</label>
		<label class="text"> <span>选择参会人员</span>
			<div class="input-wrapper">
				<div id="divfrom">
					<select id="selDepartments" onchange="showEmployees()">
							<option>请选择部门</option>
							<c:forEach var="dept" items="${requestScope.deptsList}">
								<option value="${dept.departmentid}">${dept.departmentname}</option>
							</c:forEach>
					</select> 
					<select id="selEmployees"  multiple="multiple"></select>
				</div>
				<div id="divoperator">
				
					<input type="button" class="clickbutton" value="&gt;" onclick="selectEmployees()" /> 
					<input type="button" class="clickbutton" value="&lt;" onclick="deSelectEmployees()" />
				</div>
				<div id="divto">
					<select id="selSelectedEmployees"  name="selSelectedEmployees" multiple="multiple" ></select>
				</div>
			</div> 
		</label> 

		<input type="hidden" name="code" value="book">
		<input type="submit" name="submit" value="Submit" /> 
		<input type="reset" name="reset" value="Reset" />
	</form>
		<div class="clear"></div>

	</div>


</body>

</html>
