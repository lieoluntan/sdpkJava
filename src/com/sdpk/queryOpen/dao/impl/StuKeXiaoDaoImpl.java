package com.sdpk.queryOpen.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
import com.sdpk.queryOpen.dao.StuKeXiaoDao;
import com.sdpk.utility.DBUtility;

public class StuKeXiaoDaoImpl implements StuKeXiaoDao{
	private Connection connection;
	boolean dao = false;

	public StuKeXiaoDaoImpl() {
		// connection = DBUtility.open();
		System.out.println("connection对象在StuKeXiaoDaoImpl连接!");
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
				paikeRecord.setPkType(rs.getString("pkType"));
				paikeRecord.setPkTypeName(rs.getString("pkTypeName"));
				paikeRecord.setClaName(rs.getString("claName"));
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
				paikeRecord.setPkType(rs.getString("pkType"));
				paikeRecord.setPkTypeName(rs.getString("pkTypeName"));
				paikeRecord.setClaName(rs.getString("claName"));
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
					.executeQuery("select tc.* from t_class_stu as tc,t_class  as ts where tc.classUuid=ts.uuid and ts.openAndclose='open' and tc.stuUuid='"
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
	}//end method
	
	@Override
	public ArrayList<PaikeRecordView> getAllPaike1(PaikeSearch paikeSearch) {
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

		ArrayList<PaikeRecordView> stuPaikeList = new ArrayList<PaikeRecordView>();// 老师本月的所有排课集合
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select tp.* from t_paike_all as tp,t_class as tc where tp.claUuid=tc.uuid and tc.openAndclose='open' and KeDateTime >='"
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
				paikeRecord.setPkType(rs.getString("pkType"));
				paikeRecord.setPkTypeName(rs.getString("pkTypeName"));
				paikeRecord.setClaName(rs.getString("claName"));
				stuPaikeList.add(paikeRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ResourceDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return stuPaikeList;
	}//end method
	
	@Override
	public int SumDayBefore1(PaikeSearch paikeSearch) {
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
					.executeQuery("select * from t_paike_all where  KeDateTime >='"
							+ sd
							+ "' and KeDateTime <='"
							+ sf
							+ "' and KeDateTime <= '"
							+ paikeSearch.getToday()
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
				paikeRecord.setClaName(rs.getString("claName"));
				empPaikeList.add(paikeRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ResourceDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return empPaikeList.size();
	}//end method

}
