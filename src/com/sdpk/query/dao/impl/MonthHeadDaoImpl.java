package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.query.dao.MonthHeadDao;
import com.sdpk.utility.DBUtility;
/*
 * @author 刘鑫
 * @date 2018-1-25 10：35
 */
public class MonthHeadDaoImpl implements MonthHeadDao {
	private Connection connection;
	boolean dao = false;
	
	public MonthHeadDaoImpl(){
		System.out.println("connection对象在MonthHeadDaoImpl连接!");
	}
	@Override
	public ArrayList<PaikeRecordView> queryMonthKeByClaUuid(String claUuid,
			String keDateTime) {
		// TODO Auto-generated method stub
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<PaikeRecordView> paikeList=new ArrayList<PaikeRecordView>();
		try{
			connection = DBUtility.open();
			statement = connection.createStatement();
			String sd="";//月初
			String sf="";//月末
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			//把前台传的日期转换为date类型
			//System.out.println(keDateTime+"========传来的日期");
			Date newKeDateTime=sdf.parse(keDateTime);
			calendar.setTime(newKeDateTime);
			int year=calendar.get(Calendar.YEAR);
			int month=calendar.get(Calendar.MONTH)+1;
			//System.out.println(calendar.get(Calendar.MONTH));
			//System.out.println(month);
			String monthh="";
			if(month<10){
				monthh="0"+String.valueOf(month);
			}else{
				monthh=String.valueOf(month);
			}
			String yearr=String.valueOf(year);
			sd=yearr+"-"+monthh+"-01";//月初
			sf=yearr+"-"+monthh+"-31";//月末
			System.out.println(sd+"=========月初");
			System.out.println(sf+"=========月末");
//			rs = statement.executeQuery("select * from t_paike_all tpa where tpa.claUuid in (select tce.classUuid from t_class_emp tce where tce.empUuid='"+claUuid+"') and tpa.keDateTime<='"+sf+"' and tpa.keDateTime>='"+sd+"';");
			rs = statement.executeQuery("SELECT t_class.name AS claNameBiao,tpa.* FROM t_class,t_paike_all tpa WHERE t_class.uuid = tpa.claUuid AND tpa.claUuid in (select tce.classUuid from t_class_emp tce where tce.empUuid='"+claUuid+"') and tpa.keDateTime<='"+sf+"' and tpa.keDateTime>='"+sd+"';");
			//System.out.println("SELECT t_class.name AS claNameBiao,tpa.* FROM t_class,t_paike_all tpa WHERE t_class.uuid = tpa.claUuid AND tpa.claUuid in (select tce.classUuid from t_class_emp tce where tce.empUuid='"+claUuid+"') and tpa.keDateTime<='"+sf+"' and tpa.keDateTime>='"+sd+"';");
			
			while (rs.next()) {
				PaikeRecordView paikeRecordView=new PaikeRecordView();
					paikeRecordView.setClassroomUuid(rs.getString("classroomUuid"));
					paikeRecordView.setClaUuid(rs.getString("claUuid"));
					paikeRecordView.setCourseName(rs.getString("courseName"));
					paikeRecordView.setCourseUuid(rs.getString("courseUuid"));
					paikeRecordView.setCroomName(rs.getString("croomName"));
					paikeRecordView.setEmpName(rs.getString("empName"));
					paikeRecordView.setEmpUuid(rs.getString("empUuid"));
					paikeRecordView.setKeDateTime(rs.getString("keDateTime"));
					paikeRecordView.setKeLongTime(rs.getString("keLongTime"));
					paikeRecordView.setKeStartTime(rs.getString("keStartTime"));
					paikeRecordView.setPkType(rs.getString("pkType"));
					paikeRecordView.setStatus(rs.getString("status"));
					paikeRecordView.setWeekSome(rs.getString("weekSome"));
					paikeRecordView.setPkTypeName(rs.getString("pkTypeName"));
//					paikeRecordView.setClaName(rs.getString("claName"));
					paikeRecordView.setClaName(rs.getString("claNameBiao"));
					paikeList.add(paikeRecordView);
					//System.out.println(paikeList.size());
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("MonthHeadDaoImpl的queryMonthKeByClaUuid查询失败");
			
		}finally{
			DBUtility.close(rs, statement, connection);
		}
		return paikeList;
	}

}
