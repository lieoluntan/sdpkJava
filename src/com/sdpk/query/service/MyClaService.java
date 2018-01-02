package com.sdpk.query.service;


import java.util.List;


import com.sdpk.model.Cla;
import com.sdpk.model.Student;




public interface MyClaService {
	
	List<Cla> getClaId(String ClaUuid);
	
	List<String> getClaid(List<String> ClaIdList);
	
	List<Cla> getClaaList(List<String> ClaIdList);
	
}
