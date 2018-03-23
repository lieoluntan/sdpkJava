package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.Record;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public interface RecordService {
String insert(Record record);
	
	String delete(Record uuid);
	
	String deleteByDitchUuid(Record record);
	
	String update(Record record);
	
	Record getByUuid(String uuid);
	
	ArrayList<Record> getList();
	
	ArrayList<Record> getListByDitchUuid(String stuUuid);
	
	String getonoff(Record record);
}
