var xmlHttp;

function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
}


function showEmployees() {
	createXMLHttpRequest();
	var deptid = document.getElementById("selDepartments").value;
	var url = "SelectEmployeesOfDeptServlet?departmentid=" + escape(deptid);//通过部门提取闲暇人员
	xmlHttp.open("GET", url, true);
	xmlHttp.onreadystatechange = callback;
	xmlHttp.send(null);
}

function callback() {
	clearEmployees();
	var selEmployees = document.getElementById("selEmployees");
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var elements = xmlHttp.responseXML.getElementsByTagName("option");
			for ( var i = 0; i < elements.length; i++) {
				var value = elements[i].getElementsByTagName("value")[0].firstChild.nodeValue;
				var text = elements[i].getElementsByTagName("text")[0].firstChild.nodeValue;
				selEmployees.options.add(new Option(text, value));
			}
		}
	}
}

function clearEmployees() {
	document.getElementById("selEmployees").options.length = 0;
}

function selectEmployees() {
	var selEmployees = document.getElementById("selEmployees");
	var selSelectedEmployees = document.getElementById("selSelectedEmployees");
	for ( var i = 0; i < selEmployees.options.length; i++) {
		if (selEmployees.options[i].selected) {
			var opt = new Option(selEmployees.options[i].text, selEmployees.options[i].value);
			opt.selected = true;
			selSelectedEmployees.options.add(opt);
			selEmployees.options.remove(i);
		}
	}
}

function deSelectEmployees() {
	var selEmployees = document.getElementById("selEmployees");
	var selSelectedEmployees = document.getElementById("selSelectedEmployees");
	for ( var i = 0; i < selSelectedEmployees.options.length; i++) {
		if (selSelectedEmployees.options[i].selected) {
			selEmployees.options.add(new Option(selSelectedEmployees.options[i].text, selSelectedEmployees.options[i].value));
			selSelectedEmployees.options.remove(i);
		}
	}
	setSelected();
}

function setSelected() {
	var selSelectedEmployees = document.getElementById("selSelectedEmployees");
	for ( var i = 0; i < selSelectedEmployees.options.length; i++) {
		selSelectedEmployees.options[i].selected = true;
	}
}

function refreshRooms() {
	createXMLHttpRequest();
	var participants = document.getElementById("numofparticipants").value;
	var starttime = document.getElementById("starttime").value;
	var endtime = document.getElementById("endtime").value;
	var url = "RefreshRoomsServlet?starttime=" + escape(starttime) + "&endtime=" + escape(endtime) + "&participants=" + escape(participants);//查看合适的会议室
	xmlHttp.open("GET", url, true);
	xmlHttp.onreadystatechange = refresh;
	xmlHttp.send(null);
}

function refresh() {
	clearMeetingRooms();
	var roomid = document.getElementById("roomid");
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var elements = xmlHttp.responseXML.getElementsByTagName("option");
			for ( var i = 0; i < elements.length; i++) {
				var value = elements[i].getElementsByTagName("value")[0].firstChild.nodeValue;
				var text = elements[i].getElementsByTagName("text")[0].firstChild.nodeValue;
				roomid.options.add(new Option(text, value), i + 1);
			}
		}
	}
}

function clearMeetingRooms() {
	document.getElementById("roomid").options.length = 1;
}
