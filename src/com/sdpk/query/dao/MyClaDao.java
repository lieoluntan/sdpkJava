package com.sdpk.query.dao;

import java.util.ArrayList;

import com.sdpk.model.And_ClassEmp;

public interface MyClaDao {

	 public ArrayList<And_ClassEmp> getListByEmp(String empUuid);
	 
	 public ArrayList<And_ClassEmp> getListBycla(String classUuid);
}
