package com.sdpk.query.service;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.And_ClassEmp;
import com.sdpk.utility.M_msg;

public interface MyClaService {
	
	 ArrayList<And_ClassEmp> getListBycla(String classUuid);
	
	 ArrayList<And_ClassEmp> getListByEmp(String empUuid);
}
