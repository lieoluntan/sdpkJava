package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-3 下午3:52:51
 *
 */
public interface QueryStuService {
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
