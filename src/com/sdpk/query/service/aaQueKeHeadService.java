package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;



/**
 * 
 * @author 罗成峰
 * @date 2018-1-9上午11:53:07
 * @version 1.0
 */
public interface aaQueKeHeadService {

	ArrayList<PaikeRecordView>getAllpaike(PaikeRecord paikeRecord);
	//根据empUuid查出cla_emp关联表里的所有ClaUuid
	
	public PaikeRecordView getByEmpUuid(String empUuid);
	
	//根据ClaUuid查出t_paike_all的数据
	
	public PaikeRecord getByClaUuid(String ClaUuid);
	
}
