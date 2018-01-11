package com.sdpk.query.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;

/**
 * 
 * @author 罗成峰
 * @date 2018-1-9上午11:52:31
 * @version 1.0
 */
public interface aaQueKeHeadDao {
	
	ArrayList<PaikeRecordView>getAllpaike(PaikeRecord paikeRecord);
	
	public PaikeRecordView getByEmpUuid(String empUuid);
	
	public PaikeRecord getByClaUuid(String ClaUuid);
}
