package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;
import com.sdpk.query.dao.QueCountCtextDao;
import com.sdpk.utility.DBUtility;
/*
 * @author 刘鑫
 * @date 2018-01-25 18:17
 */
public class QueCountCtextDaoImpl implements QueCountCtextDao {
	private Connection connection;
	boolean dao = false;

	public QueCountCtextDaoImpl(){
		System.out.println("connection对象在QueCountCtextDaoImpl连接!");
	}
	@Override
	public ArrayList<?> queryCountCtext(String uuid) {
		// TODO Auto-generated method stub
		Statement statement1 = null;
		Statement statement2=null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try{
			connection = DBUtility.open();
			QueCountCtext qcc=new QueCountCtext();
			
			statement1 = connection.createStatement();
			statement2=connection.createStatement();
			
			//根据学生id查询所对应的几个班级，几个班级所对应的几节课
			rs2=statement2.executeQuery("select tpa.* from t_paike_all tpa where tpa.claUuid in(select tcs.classUuid from t_class_stu tcs where tcs.stuUuid='"+uuid+"')");
			//根据单个学生id查询所对应的几个班级，几个班级所对应的几个合同
			rs1=statement1.executeQuery("select tcc.* from t_class_contract tcc where tcc.classUuid in(select tcs.classUuid from t_class_stu tcs where tcs.stuUuid='"+uuid+"');");
			while(rs1.next()){
				
			}
			while(rs2.next()){
				qcc.setStuName(rs2.getString("stuName"));
				qcc.setStuUuid(rs2.getString("stuUuid"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("MonthHeadDaoImpl的queryMonthKeByClaUuid查询失败");
		}
		finally{
			DBUtility.close(rs1, statement1, connection);
		}
		return null;
	}

}
