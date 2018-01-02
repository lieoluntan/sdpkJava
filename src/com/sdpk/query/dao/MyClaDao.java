package com.sdpk.query.dao;


import java.util.List;

import com.sdpk.model.Cla;
import com.sdpk.model.Employee;
import com.sdpk.model.Student;

public interface MyClaDao {

	List<String> getempid(String ClaUuid);
	
	List<String> getClaId(String classid);
	
	Cla getClaList(String uuid);
}
