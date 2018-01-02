package com.sdpk.query.service;


import java.util.List;


import com.sdpk.model.Cla;
import com.sdpk.model.Student;
/**
 * 
 * @author 罗成峰
 * @date 2018-1-2下午8:41:53
 * @version 1.0
 */
public interface MyClaService {
	
	List<Cla> getClaId(String ClaUuid);
	
	List<String> getClaid(List<String> ClaIdList);
	
	List<Cla> getClaaList(List<String> ClaIdList);
	
}
