package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

public interface TeaKeXiaoService {
	/**
	 * 
	 * @param uuid
	 * @return 老师当月排课集合
	 */
	ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch); 
	/**
	 * 
	 * @param paikeSearch
	 * @return  所有老师当月排课
	 */
	ArrayList<PaikeRecordView> getAllPaike1(PaikeSearch paikeSearch); 
	/**
	 * 
	 * @param uuid
	 * @return 老师当月排课的总数
	 */
	int SumEmpPaike(PaikeSearch paikeSearch);
	/**
	 * 
	 * @param uuid
	 * @return 老师当月到今天的排课数
	 */
	int SumDayBefore(PaikeSearch paikeSearch);
	/**
	 * 
	 * @param paikeSearch
	 * @return  所有老师当月到今天的排课数
	 */
	int SumDayBefore1(PaikeSearch paikeSearch);
}
