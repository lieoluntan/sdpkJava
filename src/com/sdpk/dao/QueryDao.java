package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2017-12-29 上午10:30:14
 *老师月课统计
 */
public interface QueryDao {
/**
 * 
 * @param uuid
 * @return 得到本月所有的排课
 */
	ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch); 
	
	int SumEmpPaike(PaikeSearch paikeSearch);
	
	int SumDayBefore(PaikeSearch paikeSearch);
	
}
