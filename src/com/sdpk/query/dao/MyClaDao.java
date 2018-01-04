package com.sdpk.query.dao;


import java.util.List;

import com.sdpk.model.Cla;

/**
 * 
 * @author 罗成峰
 * @date 2018-1-2下午8:41:15
 * @version 1.0
 */
public interface MyClaDao {

	List<String> getempid(String ClaUuid);
	
	List<String> getClaId(String classid);
	
	Cla getClaList(String uuid);
}
