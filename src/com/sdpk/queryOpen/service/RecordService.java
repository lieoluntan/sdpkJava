package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.Record;

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
