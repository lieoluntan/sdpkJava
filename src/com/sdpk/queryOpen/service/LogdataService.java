package com.sdpk.queryOpen.service;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Logdata;


public interface LogdataService {
	ArrayList<Logdata> getList();

	String delete(String uuid);
	
	public String deleteBatch(List<String> uuidList);
	
	String insert(Logdata log);
}
