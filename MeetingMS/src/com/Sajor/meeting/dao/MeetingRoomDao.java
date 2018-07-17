package com.Sajor.meeting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.Sajor.meeting.util.ConnectionFactory;
import com.Sajor.meeting.vo.Employee;
import com.Sajor.meeting.vo.MeetingRoom;

public class MeetingRoomDao {
	private ConnectionFactory dbhelper = new ConnectionFactory();

	// 添加一个会议室,status默认为0，表示未被占用。当为1时，表示被占用
	public void insert(MeetingRoom meetingroom) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into meetingroom (roomnum, roomname, capacity, status, description) values(?, ?, ?, ?, ?)";
		try {
			conn =  dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, meetingroom.getRoomnum());
			pstmt.setString(2, meetingroom.getRoomname());
			pstmt.setInt(3, meetingroom.getCapacity());
			pstmt.setString(4, meetingroom.getStatus());
			pstmt.setString(5, meetingroom.getDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
		}
	}

	public void delete(int rootmid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from meetingroom where roomid=?";
		try {
			conn =  dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rootmid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
		}
	}
	
	
	// 根据ID查询会议室
	public MeetingRoom selectByRoomid(int roomid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MeetingRoom meetingroom = null;
		String sql = "SELECT * FROM meetingroom WHERE roomid=" + roomid + "";
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if (rs.next() == true) {
				meetingroom = new MeetingRoom();
				meetingroom.setRoomid(Integer.parseInt(rs.getString("roomid")));
				meetingroom.setRoomnum(Integer.parseInt(rs.getString("roomnum")));
				meetingroom.setCapacity(Integer.parseInt(rs.getString("capacity")));
				meetingroom.setRoomname(rs.getString("roomname"));
				meetingroom.setStatus(rs.getString("status"));
				meetingroom.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		return meetingroom;
	}

	// 查询所有会议室
	public List<MeetingRoom> selectAllMeetingRooms() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		MeetingRoom meetingroom = null;
		String sql = "SELECT * FROM meetingroom";
		
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				meetingroom = new MeetingRoom();
				meetingroom.setRoomid(Integer.parseInt(rs.getString("roomid")));
				meetingroom.setRoomnum(Integer.parseInt(rs.getString("roomnum")));
				meetingroom.setCapacity(Integer.parseInt(rs.getString("capacity")));
				meetingroom.setRoomname(rs.getString("roomname"));
				meetingroom.setStatus(rs.getString("status"));
				meetingroom.setDescription(rs.getString("description"));
				list.add(meetingroom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		
		return list;
	}

	// 查询所有可以使用的会议室
	public List<MeetingRoom> selectMeetingRoomsByTimeAndParticipants(Timestamp starttime, Timestamp endtime, int participants) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		String start = starttime.toString();
		String end = endtime.toString();
		MeetingRoom meetingroom = null;
		
		//start 不在区间内；  end不在区间内；   start end 不包含区间；且此会议启用  （老师的代码有错误）
		String sql = "SELECT * FROM meetingroom WHERE  meetingroom.roomid NOT IN (SELECT roomid  FROM meeting" +
				" WHERE ((starttime<'" + start + "' and endtime >'" + start + "')"
				+ " or (starttime<'" + end + "' and endtime >'" + end + "')" 
				+ "or(starttime>='" + start + "' and endtime <='" + end + "')) and status='0')";
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				meetingroom = new MeetingRoom();
				meetingroom.setRoomid(Integer.parseInt(rs.getString("roomid")));
				meetingroom.setRoomnum(Integer.parseInt(rs.getString("roomnum")));
				meetingroom.setCapacity(Integer.parseInt(rs.getString("capacity")));
				meetingroom.setRoomname(rs.getString("roomname"));
				meetingroom.setStatus(rs.getString("status"));
				meetingroom.setDescription(rs.getString("description"));
				//判断会议室是否可用，且人数充足    （老师的代码没有判断会议室可容纳人数和会议室状态即是否可用）
				if(meetingroom.getStatus().equals("0") && meetingroom.getCapacity()>=participants){
					list.add(meetingroom);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
			dbhelper.closeResultSet(rs);
		}
		//System.out.println("MeetingRoom" + list.size());
		return list;
	}

	// 根据ID更新会议室
	public void updateMeetingroom(MeetingRoom meetingroom) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE meetingroom SET roomnum=?, roomname=?, capacity=?, status=?, description=? WHERE roomid=?";
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, meetingroom.getRoomnum());
			pstmt.setString(2, meetingroom.getRoomname());
			pstmt.setInt(3, meetingroom.getCapacity());
			pstmt.setString(4, meetingroom.getStatus());
			pstmt.setString(5, meetingroom.getDescription());
			pstmt.setInt(6, meetingroom.getRoomid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
		}
	}

	// 根据ID更新会议室状态（是否可用）
	public void updateMeetingroomStatus(int roomid, String status) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE meetingroom SET status=? WHERE roomid=?";
		try {
			conn = dbhelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, roomid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbhelper.closePreparedStatement(pstmt);
			dbhelper.closeConnection(conn);
		}
	}
}
