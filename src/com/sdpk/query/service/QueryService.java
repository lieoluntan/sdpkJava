package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2017-12-29 上午10:31:37
 *老师月课浏览
 */
public interface QueryService {
	/**
	 * 
	 * @param uuid
	 * @return 老师当月排课集合
	 */
	ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch); 
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
}
