package com.sdpk.queryOpen.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.Student;
import com.sdpk.queryOpen.dao.StuNameDao;
import com.sdpk.utility.DBUtility;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public class StuNameDaoImpl implements StuNameDao{
	
	private Connection connection;
	boolean daoFlag = false;

	public StuNameDaoImpl() {
		// connection = DBUtility.getConnection();
		System.out.println("connection对象在StuNameDaoImpl连接!");
	}
	
	@Override
	public ArrayList<Student> getList() {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		connection = DBUtility.open();// 打开数据库连接
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_student where openAndclose='open'");
			while (rs.next()) {
				Student student = new Student();
				student.setUuid(rs.getString("uuid"));
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

				student.setParentName2(rs.getString("parentName2"));
				student.setParentPhone2(rs.getString("parentPhone2"));
				student.setParentRela2(rs.getString("parentRela2"));
				
				student.setOpenAndclose(rs.getString("openAndclose"));

				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("StuNameDaoImpl的getList查询失败");
			Student studentX = new Student();
			studentX.setUuid("StuNameDaoImpl的getList失败返回的uuid");
			ArrayList<Student> studentListX = new ArrayList<Student>();
			studentListX.add(studentX);
			return studentListX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return studentList;
	}

}
