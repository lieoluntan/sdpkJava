package com.sdpk.queryOpen.dao;

import java.util.ArrayList;

import com.sdpk.model.Record;


public interface QuePageRecordDao {
	//分页查询
	public ArrayList<Record> pageBystuUid(String stuUid,int currentPage,int maxResult);
}
