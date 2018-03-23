package com.sdpk.queryOpen.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.Record;
import com.sdpk.queryOpen.dao.QuePageRecordDao;
import com.sdpk.utility.DBUtility;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public class QuePageRecordDaoImpl implements QuePageRecordDao{
	private Connection connection = null;
	
	public QuePageRecordDaoImpl() {
		System.out.println("connection在QuePageRecordDaoImpl中连接");
	}
	
	@Override
	public ArrayList pageBystuUid(String stuUid, int currentPage,int maxResult) {
		// TODO Auto-generated method stub
		ArrayList<Record> recordList = new ArrayList<Record>();
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtility.open();
		try {
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_record where stuUuid='"
							+ stuUid + "' order by recordDate desc LIMIT "
							+ (currentPage - 1) * maxResult + "," + maxResult
							+ "");
			while (rs.next()) {
				Record record = new Record();
				record.setUuid(rs.getString("uuid"));
				record.setStuUuid(rs.getString("stuUuid"));
				record.setRecordDate(rs.getString("recordDate"));
				record.setRemarkText(rs.getString("remarkText"));
				record.setCreatePeople(rs.getString("createPeople"));
				recordList.add(record);
			}
			return recordList;
		} catch (SQLException e) {
			e.printStackTrace();
			Record record = new Record();
			record.setStuUuid(stuUid);
			ArrayList<Record> listRecord = new ArrayList<Record>();
			listRecord.add(record);
			return listRecord;
		} finally {
			DBUtility.close(rs, statement, connection);
		}
	}

}
