package com.sdpk.queryOpen.dao;

import java.util.ArrayList;

import com.sdpk.model.Record;

/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public interface QuePageRecordDao {
	//分页查询
	public ArrayList<Record> pageBystuUid(String stuUid,int currentPage,int maxResult);
}
