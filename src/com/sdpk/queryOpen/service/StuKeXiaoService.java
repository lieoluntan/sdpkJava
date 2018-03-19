package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

public interface StuKeXiaoService {
	/**
	 * 
	 * @param uuid
	 * @return 学生当月排课集合
	 */
	ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch); 
/**
 * 
 * @param paikeSearch
 * @return  所有学生当月排课集合
 */
	ArrayList<PaikeRecordView> getAllPaike1(PaikeSearch paikeSearch); 
	/**
	 * 
	 * @param uuid
	 * @return 学生当月到今天的排课数
	 */
	int SumDayBefore(PaikeSearch paikeSearch);
	/**
	 * 
	 * @param uuid
	 * @return 所有学生当月到今天的排课数
	 */
	int SumDayBefore1(PaikeSearch paikeSearch);
}
