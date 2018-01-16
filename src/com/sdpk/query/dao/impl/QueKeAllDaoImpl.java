package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.query.dao.QueKeAllDao;
import com.sdpk.utility.DBUtility;

/**
 * 
 * @author 谢平平
 * @date 2018-1-14上午11:51:55
 * @version 1.0
 */
public class QueKeAllDaoImpl implements QueKeAllDao{
	
	private Connection connection;
	boolean dao = false;
	
	
	
	
	public QueKeAllDaoImpl() {
		System.out.println("connection对象在QueKeAllDaoImpl连接!");
	}




	@Override
	public ArrayList<PaikeRecordView> getList() {
		// TODO Auto-generated method stub
		ArrayList<PaikeRecordView> paikeRecordList = new ArrayList<PaikeRecordView>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_paike_all");
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
				paikeRecordList.add(paikeRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("PaikeRecordDaoImpl的getList查询失败");
			PaikeRecordView paikeRecordX = new PaikeRecordView();
			paikeRecordX.setUuid("PaikeRecordDaoImpl的getList失败返回的uuid");
			ArrayList<PaikeRecordView> errListX = new ArrayList<PaikeRecordView>();
			errListX.add(paikeRecordX);
			return errListX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return paikeRecordList;
	}// end method getListByclaUuid

}//end class
