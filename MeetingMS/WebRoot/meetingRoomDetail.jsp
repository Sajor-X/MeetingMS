<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<link rel="stylesheet" type="text/css" href="css/index_reset.min.css">
<link rel="stylesheet" type="text/css" href="css/addMeetingRoom_style.css">

<link rel="stylesheet" href="css/searchEmployee_normalize.css">

</head>

<body>
 <h1>修改会议室</h1>
 <form method="post" action="UpdateMeetingRoomServlet">
  <input type="hidden" name="roomid" value='${requestScope.meetingRoom.roomid}'>
	<div id="form" class="form-wrapper">
		<label class="text"> <span>门牌编号</span>
			<div class="input-wrapper">
			
				<input id="roomnumber" name="roomnum" type="text" maxlength="10" value="${requestScope.meetingRoom.roomnum}"/>
			</div> 
		</label> 
		
		<label class="text"> <span>会议室名称</span>
			<div class="input-wrapper">
				<input id="roomname"  name="roomname" type="text" maxlength="20" value="${requestScope.meetingRoom.roomname}"/>
			</div> 
		</label> 
		
		<label class="text"> <span>最多容纳人数</span>
			<div class="input-wrapper">
				<input id="roomcapacity" name="capacity" type="text" value="${requestScope.meetingRoom.capacity}"/>
			</div> 
		</label> 
			
		<label class="text"> <span>是否可用</span>
		<div class="input-wrapper">
		<div class="toggle toggle--neon">
		<c:if test="${requestScope.meetingRoom.status eq 0 }">
			<input type="checkbox" id="toggle--neon" class="toggle--checkbox" value="0" name="status" checked="true">
		</c:if>
		<c:if test="${requestScope.meetingRoom.status eq 1 }">
			<input type="checkbox" id="toggle--neon" class="toggle--checkbox" value="1" name="status" >
		</c:if>
			<label class="toggle--btn" for="toggle--neon" data-label-on="YES"  data-label-off="NO"></label>
		</div>
		</div>
		</label> 
		<label class="text"> <span>备注 </span>
			<div class="input-wrapper">
				<textarea id="description" name="description" maxlength="200" rows="5" cols="60" >${requestScope.meetingRoom.description}</textarea>
			</div> 
		</label>



		<input type="submit" name="submit" value="Submit" /> 
		<input type="reset" name="reset" value="Reset" />
	</form>
		<div class="clear"></div>

	</div>


</body>

</html>
</html>
