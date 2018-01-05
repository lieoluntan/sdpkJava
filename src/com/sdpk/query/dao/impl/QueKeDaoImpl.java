package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
import com.sdpk.query.dao.QueKeDao;
import com.sdpk.utility.DBUtility;
/**
 * 
 * @author 罗成峰
 * @date 2018-1-5下午2:38:51
 * @version 1.0
 */
public class QueKeDaoImpl implements QueKeDao{
	private Connection connection;
	boolean dao = false;
	
	public QueKeDaoImpl() {
		// connection = DBUtility.open();
		System.out.println("connection对象在QueKeDaoImpl连接!");
	}
	@Override
	public ArrayList<PaikeRecordView> getAllpaike(PaikeRecord paikeRecord) {
		// TODO Auto-generated method stub
		ArrayList<PaikeRecordView> empPaikeList = new ArrayList<PaikeRecordView>();// 老师本月的所有排课集合
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_paike_all where KeDateTime ='"
							+ paikeRecord.getKeDateTime() + "'");
			while (rs.next()) {
				PaikeRecordView PaikeRecord = new PaikeRecordView();

				PaikeRecord.setUuid(rs.getString("uuid"));
				PaikeRecord.setClaUuid(rs.getString("claUuid"));
				PaikeRecord.setCourseUuid(rs.getString("courseUuid"));
				PaikeRecord.setEmpUuid(rs.getString("empUuid"));
				PaikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
				PaikeRecord.setKeDateTime(rs.getString("keDateTime"));
				PaikeRecord.setKeStartTime(rs.getString("keStartTime"));
				PaikeRecord.setKeLongTime(rs.getString("keLongTime"));
				PaikeRecord.setStatus(rs.getString("status"));
				PaikeRecord.setWeekSome(rs.getString("weekSome"));

				empPaikeList.add(PaikeRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ResourceDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return empPaikeList;
	}

}
