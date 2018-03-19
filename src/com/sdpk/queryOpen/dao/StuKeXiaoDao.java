package com.sdpk.queryOpen.dao;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

public interface StuKeXiaoDao {
    List<String> getClaidByStuId(String uuid);//根据学生id查出他有哪些班级
	
	ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch); 
	
	int SumDayBefore(PaikeSearch paikeSearch);

	ArrayList<PaikeRecordView> getAllPaike1(PaikeSearch paikeSearch);

	int SumDayBefore1(PaikeSearch paikeSearch);
}
