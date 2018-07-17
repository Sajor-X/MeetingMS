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

import com.Sajor.meeting.service.MeetingService;
import com.Sajor.meeting.vo.Meeting;
import com.Sajor.meeting.vo.MeetingRoom;
import com.Sajor.meeting.service.MeetingRoomService;

public class ViewMyBookingServlet extends HttpServlet {

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
		int reservationistid=(Integer) session.getAttribute("employeeid");

		MeetingService service=new MeetingService();
		MeetingRoomService roomService=new MeetingRoomService();
		
		List<Meeting> meetingsList=service.viewMyBookingInfo(reservationistid);
		List<String>  roomsNameList=new ArrayList<String>();
		
		for(Meeting m:meetingsList){
			//bug修复   已删除会议室特殊处理
			MeetingRoom meetingroom = roomService.viewOneMeetingRoom(m.getRoomid());
			if(meetingroom == null) {
				roomsNameList.add("（此会议室已删除）");
			}
			else{
				roomsNameList.add(meetingroom.getRoomname());
			}
		}
		
		Map<Meeting,String> map=new HashMap<Meeting,String>();
		
		for(int i=0;i<meetingsList.size();i++){
			map.put(meetingsList.get(i), roomsNameList.get(i));
		}
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("myBookings.jsp").forward(request, response);
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
