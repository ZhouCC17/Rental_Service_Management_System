package com.java5124.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.java5124.util.DbUtil;

public class BaseDao {
	public  Connection con = new DbUtil().getCon();
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
