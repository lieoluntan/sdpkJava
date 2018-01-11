package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.query.dao.MyTodPaikeDao;
import com.sdpk.utility.DBUtility;
/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-3 下午1:08:40
 *
 */
public class MyTodPaikeDaoImpl implements MyTodPaikeDao {
	private Connection connection;
	boolean dao = false;

	public MyTodPaikeDaoImpl() {
		// connection = DBUtility.open();
		System.out.println("connection对象在MyTodPaikeDaoImpl连接!");
	}

	@Override
	public ArrayList<PaikeRecordView> getMyPaike(PaikeRecord PaikeRecord) {
		// TODO Auto-generated method stub
		ArrayList<PaikeRecordView> empPaikeList = new ArrayList<PaikeRecordView>();// 老师本月的所有排课集合
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_paike_all where empUuid='"+PaikeRecord.getEmpUuid()+"' and KeDateTime ='"+PaikeRecord.getKeDateTime()+"' ");
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

}
