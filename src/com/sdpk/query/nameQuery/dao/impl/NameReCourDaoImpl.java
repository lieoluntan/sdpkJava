package com.sdpk.query.nameQuery.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Course;
import com.sdpk.model.Employee;
import com.sdpk.query.nameQuery.dao.NameReCourDao;
import com.sdpk.utility.DBUtility;

public class NameReCourDaoImpl implements NameReCourDao{
	private Connection connection;
	@Override
	public List<Course> getCourByName(Course cour) {
		// TODO Auto-generated method stub
		List<Course> courList = new ArrayList<Course>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_course WHERE name ='"
							+ cour.getName() + "'");
			while (rs.next()) {
				Course s = new Course();
				s.setUuid(rs.getString("uuid"));
				courList.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return courList;
	}

}
