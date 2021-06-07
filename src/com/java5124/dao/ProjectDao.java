package com.java5124.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java5124.model.Customer;
import com.java5124.model.Project;
import com.java5124.model.Worker;
import com.java5124.util.StringUtil;

public class ProjectDao extends BaseDao{
	public List<Project> getProjectList(Project project) {
		// TODO Auto-generated method stub
		List<Project> retList = new ArrayList<Project>();
		StringBuffer sqlString = new StringBuffer("select * from Project");
		if(project.getPid()!=0){
			sqlString.append(" where pid ="+project.getPid());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Project t = new Project();
				t.setPid(executeQuery.getInt("Pid"));
				t.setPcontent(executeQuery.getString("pcontent"));
				t.setPtime(executeQuery.getString("ptime"));
				t.setCid(executeQuery.getInt("cid"));
				t.setType(executeQuery.getString("type"));
				retList.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	public boolean addProject(Project project){
		String sql = "insert into project(pid,pcontent,ptime,cid,type) values(?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, project.getPid());
			preparedStatement.setString(2, project.getPcontent());
			preparedStatement.setString(3, project.getPtime());
			preparedStatement.setInt(4, project.getCid());
			preparedStatement.setString(5, project.getType());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
