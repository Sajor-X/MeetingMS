package com.Sajor.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sajor.meeting.service.MeetingRoomService;
import com.Sajor.meeting.vo.MeetingRoom;

public class AddMeetingRoomServlet extends HttpServlet {

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

		int roomnum=Integer.parseInt(request.getParameter("roomnum"));
		int capacity=Integer.parseInt(request.getParameter("capacity"));
		String description=request.getParameter("description");
		String roomname=request.getParameter("roomname");
		String status=request.getParameter("status");
		
		if(status==null){
			//如果没被选中则为空， 1表示不可使用
			status = "1";
		}
		MeetingRoomService service=new MeetingRoomService();
		service.addMeetingRoom(new MeetingRoom(roomnum,roomname,capacity,status,description));
		request.getRequestDispatcher("ViewAllMeetingRoomsServlet").forward(request, response);
	}

}
