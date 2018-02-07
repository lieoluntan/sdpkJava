package com.sdpk.query.dao.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.query.dao.aaQueKeHeadDao;
import com.sdpk.utility.DBUtility;

/**
 * 
 * @author 罗成峰
 * @date 2018-1-9上午11:52:02
 * @version 1.0
 */
public class aaQueKeHeadDaoImpl implements aaQueKeHeadDao{

	private Connection connection;
	boolean dao = false;
	
	public aaQueKeHeadDaoImpl(){
		System.out.println("connection对象在aaQueKeHeadDaoImpl连接!");
	}

	@Override
	public PaikeRecordView getByEmpUuid(String empUuid) {
		// TODO Auto-generated method stub
		
		PaikeRecordView pkResult = new PaikeRecordView();
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = DBUtility.open();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_class_emp");
			while(rs.next()){
				PaikeRecordView pkRV = new PaikeRecordView();
				pkRV.setClaUuid(rs.getString("ClaUuid"));
				pkResult = pkRV;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("aaQueKeHeadDaoImpl的getByEmpUuid查询失败");
			PaikeRecordView paikeRecordView = new PaikeRecordView();
			paikeRecordView.setEmpUuid("aaQueKeHeadDaoImpl失败返回empUuid");
			return paikeRecordView;
		}finally{
			DBUtility.close(rs, statement, connection);
		}
		return pkResult;
	}

	@Override
	public PaikeRecord getByClaUuid(String ClaUuid) {
		// TODO Auto-generated method stub
		PaikeRecord prResult = new PaikeRecord();
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = DBUtility.open();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_paike_all WHERE ClaUuid ="+"'"+ClaUuid+"'");
			while(rs.next()){
				PaikeRecord pR = new PaikeRecord();
				pR.setClaUuid(rs.getString("ClaUuid"));
				prResult = pR;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("aaQueKeHeadDaoImpl的getByClaUuid查询失败");
			PaikeRecord paikeRecord = new PaikeRecord();
			paikeRecord.setClaUuid("aaQueKeHeadDaoImpl失败返回ClaUuid");
			return paikeRecord;
		}finally{
			DBUtility.close(rs, statement, connection);
		}
		return prResult;
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
				paikeRecord.setPkType(rs.getString("pkType"));
				paikeRecord.setPkTypeName(rs.getString("pkTypeName"));
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
	
	@Override
	public ArrayList<PaikeRecordView> getListByclaUuid(String claUuid,String KeDateTime) {
		// 班主任今日课,加了班级名（实时）
		ArrayList<PaikeRecordView> paikeRecordList = new ArrayList<PaikeRecordView>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
//			rs = statement
//					.executeQuery("select * from t_paike_all WHERE claUuid ="
//							+ "'" + claUuid + "'"+"and KeDateTime="+"'" + KeDateTime + "'");
			//优化，把select * from t_paike_all WHERE  替换  SELECT t_class.name AS claNameBiao,t_paike_all.* FROM t_class,t_paike_all WHERE t_class.uuid = t_paike_all.claUuid AND
			rs = statement
                .executeQuery("SELECT t_class.name AS claNameBiao,t_paike_all.* FROM t_class,t_paike_all WHERE t_class.uuid = t_paike_all.claUuid AND claUuid ="
                        + "'" + claUuid + "'"+"and KeDateTime="+"'" + KeDateTime + "'");
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
//				paikeRecord.setClaName(rs.getString("claName"));
				paikeRecord.setClaName(rs.getString("claNameBiao"));
			    
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

