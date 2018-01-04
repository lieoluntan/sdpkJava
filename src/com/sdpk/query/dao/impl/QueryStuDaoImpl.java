package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
import com.sdpk.query.dao.QueryStuDao;
import com.sdpk.utility.DBUtility;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-3 下午3:52:28
 * 
 */
public class QueryStuDaoImpl implements QueryStuDao {
	private Connection connection;
	boolean dao = false;

	public QueryStuDaoImpl() {
		// connection = DBUtility.open();
		System.out.println("connection对象在QueryStuDaoImpl连接!");
	}

	@Override
	public ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch) {
		// TODO Auto-generated method stub

		String sd = "";// 月初
		String sf = "";
		;// 月末

		String year = paikeSearch.getYear();
		String month = paikeSearch.getMonth();
		String d = year + "-" + month + "-" + "1";

		String[] s = d.split("-");
		s[0] += "-";
		s[1] += "-";
		s[2] = "01";
		for (String string : s) {
			sd += string;
		}

		s[2] = "31";
		for (String string : s) {
			sf += string;
		}

		ArrayList<PaikeRecordView> stuPaikeList = new ArrayList<PaikeRecordView>();// 学生本月的所有排课集合
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_paike_all where claUuid='"
							+ paikeSearch.getClaUuid() + "' and KeDateTime >='"
							+ sd + "' and KeDateTime <='" + sf + "'");
			while (rs.next()) {
				PaikeRecordView paikeRecord = new PaikeRecordView();
				paikeRecord.setUuid(rs.getString("uuid"));
				paikeRecord.setClaUuid(rs.getString("claUuid"));
				paikeRecord.setCourseUuid(rs.getString("courseUuid"));
				paikeRecord.setEmpUuid(rs.getString("empUuid"));
				paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
				paikeRecord.setKeDateTime(rs.getString("keDateTime"));
				paikeRecord.setKeStartTime(rs.getString("keStartTime"));
				paikeRecord.setKeLongTime(rs.getString("keLongTime"));
				paikeRecord.setStatus(rs.getString("status"));
				paikeRecord.setWeekSome(rs.getString("weekSome"));

				stuPaikeList.add(paikeRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ResourceDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return stuPaikeList;
	}

	@Override
	public int SumDayBefore(PaikeSearch paikeSearch) {
		// TODO Auto-generated method stub

		String sd = "";// 月初
		String sf = "";
		String year = paikeSearch.getYear();
		String month = paikeSearch.getMonth();
		String d = year + "-" + month + "-" + "1";
		String[] s = d.split("-");
		s[0] += "-";
		s[1] += "-";
		s[2] = "01";
		for (String string : s) {
			sd += string;
		}

		s[2] = "31";
		for (String string : s) {
			sf += string;
		}

		ArrayList<PaikeRecordView> empPaikeList = new ArrayList<PaikeRecordView>();// 老师本月的所有排课集合
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_paike_all where claUuid='"
							+ paikeSearch.getClaUuid() + "' and KeDateTime >='"
							+ sd + "' and KeDateTime <='" + sf
							+ "' and KeDateTime <= '" + paikeSearch.getToday()
							+ "'");
			while (rs.next()) {
				PaikeRecordView paikeRecord = new PaikeRecordView();

				paikeRecord.setUuid(rs.getString("uuid"));
				paikeRecord.setClaUuid(rs.getString("claUuid"));
				paikeRecord.setCourseUuid(rs.getString("courseUuid"));
				paikeRecord.setEmpUuid(rs.getString("empUuid"));
				paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
				paikeRecord.setKeDateTime(rs.getString("keDateTime"));
				paikeRecord.setKeStartTime(rs.getString("keStartTime"));
				paikeRecord.setKeLongTime(rs.getString("keLongTime"));
				paikeRecord.setStatus(rs.getString("status"));
				paikeRecord.setWeekSome(rs.getString("weekSome"));

				empPaikeList.add(paikeRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ResourceDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return empPaikeList.size();
	}

	@Override
	public List<String> getClaidByStuId(String uuid) {
		// TODO Auto-generated method stub

		List<String> claIdList = new ArrayList<String>();// 存放学生的班级id
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_class_stu where stuUuid='"
							+ uuid + "'");
			while (rs.next()) {
				String Claid = rs.getString("classUuid");

				claIdList.add(Claid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("QueryStuDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return claIdList;
	}

}
