package com.sdpk.queryOpen.dao;

import java.util.ArrayList;

import com.sdpk.model.Logdata;
import com.sdpk.model.Student;

public interface LogdataDao {
	 public boolean delete(String uuid);
	 public ArrayList<Logdata> getList();
	 public boolean insert(Logdata log);
	 public boolean deleteBatch(String uuid);
}
