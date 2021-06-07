package com.java5124.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java5124.model.Schedule;
import com.java5124.util.StringUtil;
import com.sun.net.httpserver.Authenticator.Result;

public class ScheduleDao extends BaseDao {
	public boolean addSchedule(Schedule schedule){
		String sql = "insert into Schedule(sid,wid,scontent) values(?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, schedule.getSid());
			preparedStatement.setInt(2, schedule.getWid());
			preparedStatement.setString(3, schedule.getScontent());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Schedule> getScheduleList(Schedule schedule){
		List<Schedule> retList = new ArrayList<Schedule>();
		StringBuffer sqlString = new StringBuffer("select * from schedule");
		if(schedule.getSid()!=0) {
			sqlString.append(" where sid = "+schedule.getSid());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Schedule c = new Schedule();
				c.setSid(executeQuery.getInt("sid"));
				c.setWid(executeQuery.getInt("wid"));
				c.setScontent(executeQuery.getString("scontent"));
				retList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
//	public boolean delete(int id){
//		String sql = "delete from course_5124 where cno=?";
//		try {
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			preparedStatement.setInt(1, id);
//			if(preparedStatement.executeUpdate() > 0){
//				return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//	public boolean update(Course course){
//		String sql = "update course_5124 set cname=?,max_num=?,c_info=? where cno=?";
//		try {
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			preparedStatement.setString(1, course.getCname());
////			preparedStatement.setInt(2, course.getTno());
//			preparedStatement.setInt(2, course.getMax_student_num());
//			preparedStatement.setString(3, course.getC_info());
//			preparedStatement.setInt(4, course.getCno());
//			if(preparedStatement.executeUpdate() > 0){
//				return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//	public boolean selectedEnable(int course_id){
//		String sql = "select * from course_5124 where cno=?";
//		try {
//			PreparedStatement prst = con.prepareStatement(sql);
//			prst.setInt(1, course_id);
//			ResultSet executeQuery = prst.executeQuery();
//			if(executeQuery.next()){
//				int max_student_num = executeQuery.getInt("max_num");
//				int selected_num = executeQuery.getInt("selected_num");
//				if(selected_num >= max_student_num)return false;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return true;
//	}
//	public boolean updateSelectedNum(int course_id,int num){
//		String sql = "update course_5124 set selected_num = selected_num + ? where cno = ?";
//		if(num < 0){
//			sql = "update course_5124 set selected_num = selected_num - ? where cno = ?";
//		}
//		try {
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			preparedStatement.setInt(1, 1);
//			preparedStatement.setInt(2, course_id);
//			if(preparedStatement.executeUpdate() > 0){
//				return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//		return false;
//	}
//	public int nextCno() {
//		String sql = "select max(cno) from course_5124";
//		PreparedStatement preparedStatement;
//		int cno=1;
//		try {
//			preparedStatement = con.prepareStatement(sql);
//			ResultSet executeQuery = preparedStatement.executeQuery();
//			if(executeQuery.next()){
//			   cno = executeQuery.getInt(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return cno;
//	}
//	public Course searchCourse(int cno) {
//		// TODO Auto-generated method stub
//		String sqlString="select * from course_5124 where cno=?";
//		PreparedStatement preparedStatement;
//		try {
//			preparedStatement = con.prepareStatement(sqlString);
//			preparedStatement.setInt(1,cno);
//			ResultSet executeQuery = preparedStatement.executeQuery(); 
//			Course course =new Course();
//			while(executeQuery.next()) {
//				course.setCno(executeQuery.getInt("cno"));
//				course.setCname(executeQuery.getString("cname"));
//				course.setMax_student_num(executeQuery.getInt("max_num"));
//				course.setMax_student_num(executeQuery.getInt("selected_num"));
//				course.setC_info(executeQuery.getString("c_info"));
//				return course;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//	public int searchCno(String cname) {
//		// TODO Auto-generated method stub
//		String sqlString="select cno from course_5124 where cname=?";
//		PreparedStatement preparedStatement;
//		int cno=0;
//		try {
//			preparedStatement = con.prepareStatement(sqlString);
//			preparedStatement.setString(1,cname);
//			ResultSet executeQuery = preparedStatement.executeQuery(); 
//			while(executeQuery.next()) {
//			cno=executeQuery.getInt("cno");	
//			}
//			return cno;
//		} catch (SQLException e) {
//			// TODO: handle exception
//		}
//		return 0;
//	}

}
