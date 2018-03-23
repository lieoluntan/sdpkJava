package com.sdpk.queryOpen.dao;

import java.util.ArrayList;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

public interface TeaKeXiaoDao {
    ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch); 
	
	ArrayList<PaikeRecordView> getAllPaike1(PaikeSearch paikeSearch);
	
	int SumEmpPaike(PaikeSearch paikeSearch);
	
	int SumDayBefore(PaikeSearch paikeSearch);
	
	int SumDayBefore1(PaikeSearch paikeSearch);
}
