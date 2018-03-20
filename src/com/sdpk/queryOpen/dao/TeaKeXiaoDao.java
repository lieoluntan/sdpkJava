package com.sdpk.queryOpen.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

public interface TeaKeXiaoDao {
    ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch); 
	
	ArrayList<PaikeRecordView> getAllPaike1(PaikeSearch paikeSearch);
	
	int SumEmpPaike(PaikeSearch paikeSearch);
	
	int SumDayBefore(PaikeSearch paikeSearch);
	
	int SumDayBefore1(PaikeSearch paikeSearch);
}
