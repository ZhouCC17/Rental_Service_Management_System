package com.java5124.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.java5124.model.Project_Worker;



public class Project_WorkerDao extends BaseDao {
	public boolean addSelectedProject(Project_Worker pw){
		String sql = "insert into project_worker values(?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, pw.getPid());
			preparedStatement.setInt(2, pw.getWid());
			preparedStatement.setString(3, pw.getPname());
			preparedStatement.setString(4, pw.getWnameString());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updatePw(Project_Worker pw,int pid,int wid){
		String sql = "update project_worker set pid = ?,wid=?,pname=?,wname=? where pid=? and wid=?";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, pw.getPid());
			preparedStatement.setInt(2, pw.getWid());
			preparedStatement.setString(3, pw.getPname());
			preparedStatement.setString(4, pw.getWnameString());
			preparedStatement.setInt(5, pid);
			preparedStatement.setInt(6, wid);
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Project_Worker> getSelectedProjectList(Project_Worker pw){
		List<Project_Worker> retList = new ArrayList<Project_Worker>();
		StringBuffer sqlString = new StringBuffer("select * from project_worker");
		if(pw.getPid() != 0){
			sqlString.append(" and pid = "+pw.getPid());
		}
		if(pw.getWid() != 0){
			sqlString.append(" and wid ="+pw.getWid());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Project_Worker sc = new Project_Worker();
				sc.setPid(executeQuery.getInt("pid"));
				sc.setWid(executeQuery.getInt("wid"));
				sc.setPname(executeQuery.getString("pname"));
				sc.setWnameString(executeQuery.getString("wname"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean isSelected(Project_Worker pw){
		String sql = "select * from Project_Worker where pname=? and wname = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, pw.getPname());
			prst.setString(2, pw.getWnameString());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
//	public List<Student> getSelectedCourseStudentList(Course course){
//		List<Student> retList = new ArrayList<Student>();
//		StringBuffer sqlString = new StringBuffer("select sc.cno,s.* from sc_5124 sc , student_5124 s where sc.sno = s.sno and cno = ?");
//		try {
//			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
//			preparedStatement.setInt(1, course.getCno());
//			ResultSet executeQuery = preparedStatement.executeQuery();
//			while(executeQuery.next()){
//				Student s = new Student();
//				s.setSno(executeQuery.getInt("sno"));
//				s.setClno(executeQuery.getInt("clno"));
//				s.setSname(executeQuery.getString("sname"));
//				s.setSsex(executeQuery.getString("ssex"));
//				retList.add(s);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return retList;
//	}
	

	
	public boolean isAdd(Project_Worker selectedClass){
		String sql = "select * from  project_worker where pid=? and wid = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setInt(1, selectedClass.getPid());
			prst.setInt(2, selectedClass.getWid());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()&&executeQuery.getInt("grade")>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int pid,int wid){
		String sql = "delete from Project_Worker where pid=? and wid=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, pid);
			preparedStatement.setInt(2, wid);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
}
