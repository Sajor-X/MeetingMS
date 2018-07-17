package com.Sajor.meeting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.Sajor.meeting.util.ConnectionFactory;
import com.Sajor.meeting.vo.Meeting;

public class MeetingDao {
	private ConnectionFactory dbhelper = new ConnectionFactory();

	// 向表meeting中插入记录，其中status使用默认值0（表示为被取消）
	public int insert(Meeting meeting) {
		int meetingid = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into meeting (meetingname,roomid,reservationistid,numberofparticipants,starttime,endtime,reservationtime,canceledtime,description,status) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, meeting.getMeetingname());
			pstmt.setInt(2, meeting.getRoomid());
			pstmt.setInt(3, meeting.getReservationistid());
			pstmt.setInt(4, meeting.getNumberofparticipants());
			pstmt.setTimestamp(5, meeting.getStarttime());
			pstmt.setTimestamp(6, meeting.getEndtime());
			pstmt.setTimestamp(7, meeting.getReservationtime());
			pstmt.setTimestamp(8, meeting.getCanceledtime());
			pstmt.setString(9, meeting.getDescription());
			pstmt.setString(10, "0");

			pstmt.executeUpdate();

			rs = pstmt.executeQuery("select max(meetingid) from meeting");
			if (rs.next()) {
				meetingid = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return meetingid;
	}

	//取消会议   根据meetingid，更新会议的状态和删除的时间
	public void update(int meetingid, String status, Timestamp canceledtime) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update meeting set status=?,canceledtime=? where meetingid=" + meetingid;
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setTimestamp(2, canceledtime);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
		}
	}

	// 查询某员工预定的所有会议
	public List<Meeting> selectAllMeetingsByReserId(int reservationistid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Meeting> meetingslist = new ArrayList<Meeting>();
		Meeting meeting = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "select * from meeting where reservationistid=" + reservationistid;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				meeting = new Meeting();
				meeting.setMeetingid(rs.getInt("meetingid"));
				meeting.setMeetingname(rs.getString("meetingname"));
				meeting.setRoomid(rs.getInt("roomid"));
				meeting.setReservationistid(rs.getInt("reservationistid"));
				meeting.setNumberofparticipants(rs.getInt("numberofparticipants"));
				meeting.setStarttime(rs.getTimestamp("starttime"));
				meeting.setEndtime(rs.getTimestamp("endtime"));
				meeting.setReservationtime(rs.getTimestamp("reservationtime"));
				meeting.setCanceledtime(rs.getTimestamp("canceledtime"));
				meeting.setDescription(rs.getString("description"));
				meeting.setStatus(rs.getString("status"));
				meetingslist.add(meeting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return meetingslist;
	}

	// 通过meetingid查询会议
	public Meeting selectById(int meetingid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Meeting meeting = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "select * from meeting where meetingid=" + meetingid;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				meeting = new Meeting();
				meeting.setMeetingid(rs.getInt("meetingid"));
				meeting.setMeetingname(rs.getString("meetingname"));
				meeting.setRoomid(rs.getInt("roomid"));
				meeting.setReservationistid(rs.getInt("reservationistid"));
				meeting.setNumberofparticipants(rs.getInt("numberofparticipants"));
				meeting.setStarttime(rs.getTimestamp("starttime"));
				meeting.setEndtime(rs.getTimestamp("endtime"));
				meeting.setReservationtime(rs.getTimestamp("reservationtime"));
				meeting.setCanceledtime(rs.getTimestamp("canceledtime"));
				meeting.setDescription(rs.getString("description"));
				meeting.setStatus(rs.getString("status"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return meeting;
	}
}
