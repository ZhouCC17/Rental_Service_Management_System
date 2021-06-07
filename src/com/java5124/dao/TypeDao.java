package com.java5124.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java5124.model.Type;
import com.java5124.util.StringUtil;

public class TypeDao extends BaseDao{

		public List<Type> getTypeList(Type type){
			List<Type> retList = new ArrayList<Type>();
			String sqlString = "select * from Type";
			if(!StringUtil.isEmpty(type.getType())){
				sqlString += " where type like '%"+type.getType()+"%'";
			}
			try {
				PreparedStatement preparedStatement = con.prepareStatement(sqlString);
				ResultSet executeQuery = preparedStatement.executeQuery();
				while(executeQuery.next()){
					Type sc = new Type();
					sc.setTid(executeQuery.getInt("tid"));
					sc.setType(executeQuery.getString("type"));
					retList.add(sc);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return retList;
		}
//		public boolean delete(int id){
//			String sql = "delete from class_5124 where clno=?";
//			try {
//				PreparedStatement preparedStatement = con.prepareStatement(sql);
//				preparedStatement.setInt(1, id);
//				if(preparedStatement.executeUpdate() > 0){
//					return true;
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return false;
//		}
//		public boolean update(StudentClass sc){
//			String sql = "update class_5124 set clname=?, c_info=? where clno=?";
//			try {
//				PreparedStatement preparedStatement = con.prepareStatement(sql);
//				preparedStatement.setString(1, sc.getClname());
//				preparedStatement.setString(2, sc.getC_info());
//				preparedStatement.setInt(3, sc.getClno());
//				if(preparedStatement.executeUpdate() > 0){
//					return true;
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return false;
//		}
//	}


}
