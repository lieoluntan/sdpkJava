package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
import com.sdpk.query.dao.QueryDao;
import com.sdpk.utility.DBUtility;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-29 上午10:31:16
 * 
 */
public class QueryDaoImpl implements QueryDao {
	private Connection connection;
	boolean dao = false;

	public QueryDaoImpl() {
		// connection = DBUtility.open();
		System.out.println("connection对象在QueryDaoImpl连接!");
	}

	@Override
	public ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch) {
		// TODO Auto-generated method stub
		
		String sd = "";// 月初
		String sf = "";
		;// 月末
		
		String d = paikeSearch.getMonthDay();
		String[] s = d.split("-");
		s[0] += "-";
		s[1] += "-";
		s[2] = "1";
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
					.executeQuery("select * from t_paike_all where empUuid='"+paikeSearch.getUuid()+"' and KeDateTime >='"+sd+"' and KeDateTime <='"+sf+"'");
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

		
		return empPaikeList;
	}

	@Override
	public int SumEmpPaike(PaikeSearch paikeSearch) {
		// TODO Auto-generated method stub

		String sd = "";// 月初
		String sf = "";
		;// 月末
		
		String d = paikeSearch.getMonthDay();
		String[] s = d.split("-");
		s[0] += "-";
		s[1] += "-";
		s[2] = "1";
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
					.executeQuery("select * from t_paike_all where empUuid='"+paikeSearch.getUuid()+"' and KeDateTime >='"+sd+"' and KeDateTime <='"+sf+"'");
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
	public int SumDayBefore(PaikeSearch paikeSearch) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String sd = "";// 月初
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(date);
		String[] s = d.split("-");
		s[0] += "-";
		s[1] += "-";
		
		
		s[2] = "1";
		for (String string : s) {
			sd += string;
		}
		
	

		ArrayList<PaikeRecordView> empPaikeList = new ArrayList<PaikeRecordView>();// 老师本月的所有排课集合
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_paike_all where empUuid='"+paikeSearch.getUuid()+"' and KeDateTime >='"+sd+"' and KeDateTime <='"+paikeSearch.getMonthDay()+"'");
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

}
