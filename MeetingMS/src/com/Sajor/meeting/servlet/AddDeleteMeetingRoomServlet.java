package com.Sajor.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sajor.meeting.service.DepartmentService;
import com.Sajor.meeting.service.MeetingRoomService;
import com.Sajor.meeting.vo.MeetingRoom;

public class AddDeleteMeetingRoomServlet extends HttpServlet {

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
		String code=request.getParameter("code");
		//判断code是增加还是删除会议室
		if(code != null){
			MeetingRoomService service=new MeetingRoomService();
			if(code.equals("add")){
				//从页面提取会议室信息
				int roomnum=Integer.parseInt(request.getParameter("roomnum"));
				int capacity=Integer.parseInt(request.getParameter("capacity"));
				String roomname=request.getParameter("roomname");
				String status=request.getParameter("status");
				String description=request.getParameter("description");
				
				service.addMeetingRoom(new MeetingRoom(roomnum,roomname,capacity,status,description));
			}
			
			else if(code.equals("delete")){
				service.deleteMeetingRoom(Integer.parseInt(request.getParameter("roomid")));
			}
			request.getRequestDispatcher("ViewAllMeetingRoomsServlet").forward(request, response);
		}
	}
}
