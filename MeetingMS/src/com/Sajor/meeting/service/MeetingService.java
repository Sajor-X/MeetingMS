package com.Sajor.meeting.service;

import java.sql.Timestamp;
import java.util.List;

import com.Sajor.meeting.dao.MeetingDao;
import com.Sajor.meeting.dao.MeetingParticipantsDao;
import com.Sajor.meeting.vo.Meeting;

public class MeetingService {
	private MeetingDao meetingDao=new MeetingDao();
	private MeetingParticipantsDao parDao=new MeetingParticipantsDao();
	
	//预定会议
	public void bookMeeting(Meeting meeting, List<Integer> employeeidList){
		int meetingid=meetingDao.insert(meeting);
		for(Integer employeeid:employeeidList){
			parDao.insert(meetingid, employeeid);
		}
	}
	
	//取消会议
	public void cancelMeeting(int meetingid){
		meetingDao.update(meetingid, "1", new Timestamp(System.currentTimeMillis()));
	}
	
	//显示我预定的会议
	public List<Meeting> viewMyBookingInfo(int reservationistid){
		return meetingDao.selectAllMeetingsByReserId(reservationistid);
	}
	
	//显示我的会议
	public List<Meeting> viewMymeetingsInfo(int participantsid){
		return parDao.selectAllMeetingsByParId(participantsid);
	}
}
