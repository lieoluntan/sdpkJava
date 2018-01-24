package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Contract;
import com.sdpk.query.dao.MyContrtextDao;
import com.sdpk.utility.DBUtility;

/**
 * 
 * @author xpp
 * @date 2018-1-24上午11:51:55
 * @version 1.0
 */
public class MyContrtextDaoImpl implements MyContrtextDao{
	
	private Connection connection;
	boolean daoFlag = false;

	@Override
	public List<String> getClaId(String empUuid) {
		// TODO Auto-generated method stub
		List<String> ClassIdList = new ArrayList<String>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_class_emp WHERE empUuid ="
							+ "'" + empUuid + "'");
			while (rs.next()) {
				String classUuid = rs.getString("classUuid");
				ClassIdList.add(classUuid);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return ClassIdList;
	}//end method

	@Override
	public List<String> getConId(String classId) {
		// TODO Auto-generated method stub
		List<String> ConIdList = new ArrayList<String>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_class_contract WHERE classUuid ="
							+ "'" + classId + "'");
			while (rs.next()) {
				String contrUuid = rs.getString("contrUuid");
				ConIdList.add(contrUuid);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return ConIdList;
	}//end method

	

}//end class
