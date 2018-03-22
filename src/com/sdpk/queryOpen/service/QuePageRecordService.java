package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.Record;


public interface QuePageRecordService {
	/**
	 * 跟踪记录分页查询
	 */
	public ArrayList<Record> pageBystuUid(String stuUid,int currentPage,int maxResult);
}
