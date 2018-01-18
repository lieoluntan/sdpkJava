package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.sdpk.model.Student;
import com.sdpk.query.dao.MyStuDao;
import com.sdpk.utility.DBUtility;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-2 下午3:39:21
 * 
 */
public class MyStuDaoImpl implements MyStuDao {

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
				String ClassId = rs.getString("classUuid");
				ClassIdList.add(ClassId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return ClassIdList;

	}

	@Override
	public List<String> getStuId(String classid) {
		// TODO Auto-generated method stub
		List<String> StuIdList = new ArrayList<String>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_class_stu WHERE classUuid ="
							+ "'" + classid + "'");
			while (rs.next()) {
				String StuId = rs.getString("stuUuid");
				StuIdList.add(StuId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return StuIdList;

	}

	@Override
	public Student getStuList(String uuid) {
		// TODO Auto-generated method stub

		Student student = new Student();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_student WHERE uuid ="
					+ "'" + uuid + "'");
			while (rs.next()) {
				student.setUuid(rs.getString("Uuid"));
				student.setName(rs.getString("name"));
				student.setStudentID(rs.getString("studentID"));
				student.setSchool(rs.getString("school"));
				student.setGrade(rs.getString("grade"));
				student.setPhone(rs.getString("phone"));
				student.setDate(rs.getString("date"));
				student.setParentName(rs.getString("parentName"));
				student.setParentPhone(rs.getString("parentPhone"));
				student.setAddress(rs.getString("address"));
				student.setRemark(rs.getString("remark"));
				student.setSex(rs.getString("sex"));
				student.setOrg(rs.getString("org"));
				student.setParentRela(rs.getString("parentRela"));
				student.setOpenAndclose(rs.getString("openAndclose"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return student;

	}

}
