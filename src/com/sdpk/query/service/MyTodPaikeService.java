package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-3 下午1:09:15
 *
 */
public interface MyTodPaikeService {
	
	/**
	 * 
	 * @param PaikeRecord
	 * @return  老师本日的所有课程
	 */
	ArrayList<PaikeRecordView> getTodPaike(PaikeRecord PaikeRecord); 
}
