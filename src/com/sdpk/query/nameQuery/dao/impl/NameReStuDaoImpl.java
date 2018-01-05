package com.sdpk.query.nameQuery.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Student;
import com.sdpk.query.nameQuery.dao.NameReStuDao;
import com.sdpk.utility.DBUtility;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午3:45:37 学生名字重复校检
 * 
 */
public class NameReStuDaoImpl implements NameReStuDao {
	private Connection connection;
	boolean daoFlag = false;

	@Override
	public List<Student> getStuByName(Student student) {
		// TODO Auto-generated method stub
		List<Student> stuList = new ArrayList<Student>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_student WHERE name ='"+student.getName()+"'");
			while (rs.next()) {
				Student s = new Student();
				s.setUuid(rs.getString("uuid"));
				stuList.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return stuList;
	}

}
