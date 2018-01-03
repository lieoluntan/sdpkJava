package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Contract;
import com.sdpk.model.Student;
import com.sdpk.query.dao.MyConDao;
import com.sdpk.utility.DBUtility;

public class MyConDaoImpl implements MyConDao {

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
	public List<String> getConId(String classid) {
		// TODO Auto-generated method stub
		List<String> ConIdList = new ArrayList<String>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_class_contract WHERE classUuid ="
							+ "'" + classid + "'");
			while (rs.next()) {
				String ConId = rs.getString("contrUuid");
				ConIdList.add(ConId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return ConIdList;
	}

	@Override
	public Contract getConList(String uuid) {
		// TODO Auto-generated method stub
		Contract contract = new Contract();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_contract WHERE uuid ="
					+ "'" + uuid + "'");
			while (rs.next()) {

				
				contract.setUuid(rs.getString("uuid"));
				contract.setcNum(rs.getString("cNum"));
				contract.setStuUuid(rs.getString("stuUuid"));
				contract.setcDate(rs.getString("cDate"));

				contract.setOrg(rs.getString("org"));
				contract.setTotalCount(rs.getString("totalCount"));
				contract.setTotalPrice(rs.getString("totalPrice"));
				contract.setDelPriceA(rs.getString("onePriceA"));

				contract.setCountA(rs.getString("countA"));
				contract.setDelPriceA(rs.getString("delPriceA"));
				contract.setCountGiveA(rs.getString("countGiveA"));
				contract.setSumCountA(rs.getString("sumCountA"));

				contract.setSumPriceA(rs.getString("sumPriceA"));
				contract.setOnePriceB(rs.getString("onePriceB"));
				contract.setCountB(rs.getString("countB"));
				contract.setDelPriceB(rs.getString("delPriceB"));

				contract.setCountGiveB(rs.getString("countGiveB"));
				contract.setSumCountB(rs.getString("sumCountB"));
				contract.setSumPriceB(rs.getString("sumPriceB"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return contract;
	}

}
