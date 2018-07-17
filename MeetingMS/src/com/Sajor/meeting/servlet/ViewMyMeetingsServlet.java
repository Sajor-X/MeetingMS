package com.Sajor.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Sajor.meeting.dao.EmployeeDao;
import com.Sajor.meeting.service.MeetingRoomService;
import com.Sajor.meeting.service.MeetingService;
import com.Sajor.meeting.vo.Meeting;

public class ViewMyMeetingsServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		int employeeid=(Integer) session.getAttribute("employeeid");
		MeetingService service=new MeetingService();
		MeetingRoomService roomService=new MeetingRoomService();
		EmployeeDao empDao=new EmployeeDao();
		
		List<Meeting> meetingsList=service.viewMymeetingsInfo(employeeid);
		List<String[]>  nameList=new ArrayList<String[]>();
		
		
		for(Meeting m:meetingsList){
			String empName=empDao.selectById(m.getReservationistid()).getEmployeename();
			String roomName=roomService.viewOneMeetingRoom(m.getRoomid()).getRoomname();
			nameList.add(new String[]{empName,roomName});
		}
		
		Map<Meeting,String[]> map=new HashMap<Meeting,String[]>();
		
		for(int i=0;i<meetingsList.size();i++){
			map.put(meetingsList.get(i), nameList.get(i));
		}
		
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("myMeetings.jsp").forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
