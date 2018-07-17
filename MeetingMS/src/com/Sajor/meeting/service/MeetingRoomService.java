package com.Sajor.meeting.service;

import java.util.List;

import com.Sajor.meeting.dao.MeetingRoomDao;
import com.Sajor.meeting.vo.MeetingRoom;

public class MeetingRoomService {

	private MeetingRoomDao dao=new MeetingRoomDao();
	
	//查看所有会议室
	public List<MeetingRoom> viewAllMeetingRooms(){
		return dao.selectAllMeetingRooms();
	}
	
	//通过id显示一个会议室
	public MeetingRoom viewOneMeetingRoom(int roomid){
		return dao.selectByRoomid(roomid);
	}
	
	//添加会议室
	public void addMeetingRoom(MeetingRoom meetingroom){
		dao.insert(meetingroom);
	}
	
	//修改会议室
	public void updateMeetingRoom(MeetingRoom meetingroom){
		dao.updateMeetingroom(meetingroom);
	}
	
	//删除会议室
	public void deleteMeetingRoom(int roomid){
		dao.delete(roomid);
	}
}
