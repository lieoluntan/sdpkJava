package com.sdpk.query.dao.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.sdpk.model.Cla;
import com.sdpk.model.Employee;
import com.sdpk.model.Student;
import com.sdpk.query.dao.MyClaDao;
import com.sdpk.utility.DBUtility;


public class MyClaDaoImpl implements MyClaDao{

	private Connection connection;
	boolean daoFlag = false;
	
	@Override
	public List<String> getempid(String ClaUuid) {
		// TODO Auto-generated method stub
		List<String> ClassIdList = new ArrayList<String>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_class_emp WHERE empUuid ="
							+ "'" + ClaUuid + "'");
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
	public Cla getClaList(String uuid) {
		Cla cla = new Cla();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_Class WHERE uuid ="
					+ "'" + uuid + "'");
			while (rs.next()) {
				cla.setUuid(rs.getString("Uuid"));
				cla.setName(rs.getString("name"));
				cla.setEmpUuid(rs.getString("empUuid"));
				cla.setClassDate(rs.getString("classDate"));
				cla.setStatus(rs.getString("status"));
				cla.setRemark(rs.getString("remark"));
				cla.setOrg(rs.getString("org"));
				cla.setClaNum(rs.getString("claNum"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return cla;

	}

	@Override
	public List<String> getClaId(String classid) {
		// TODO Auto-generated method stub
		return null;
	}
}

