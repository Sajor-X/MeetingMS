<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
 <h1>添加会议室</h1>
 <form method="post" action="AddMeetingRoomServlet">
	<div id="form" class="form-wrapper">
		<label class="text"> <span>门牌编号</span>
			<div class="input-wrapper">
				<input id="roomnumber" name="roomnum" type="text" placeholder="例如：201" maxlength="10" />
			</div> 
		</label> 
		
		<label class="text"> <span>会议室名称</span>
			<div class="input-wrapper">
				<input id="roomname"  name="roomname" type="text" placeholder="例如：第一会议室" maxlength="20"/>
			</div> 
		</label> 
		
		<label class="text"> <span>最多容纳人数</span>
			<div class="input-wrapper">
				<input id="roomcapacity" name="capacity" type="text" placeholder="填写一个正整数"/>
			</div> 
		</label> 
			
		<label class="text"> <span>是否可用</span>
		<div class="input-wrapper">
		<div class="toggle toggle--neon">
			<input type="checkbox" id="toggle--neon" class="toggle--checkbox" value="0" name="status" checked="checked">
			<label class="toggle--btn" for="toggle--neon" data-label-on="YES"  data-label-off="NO"></label>
		</div>
		</div>
		</label> 
		<label class="text"> <span>备注 </span>
			<div class="input-wrapper">
				<textarea id="description" name="description" maxlength="200" rows="5" cols="60" placeholder="200字以内的文字描述"></textarea>
			</div> 
		</label>

		<input type="submit" name="submit" value="Submit" /> 
		<input type="reset" name="reset" value="Reset" />
	</form>
		<div class="clear"></div>

	</div>


</body>

</html>
