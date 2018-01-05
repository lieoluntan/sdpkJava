package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午12:58:28
 *
 */
public interface QueryKeMyService {
	/**
	 * 
	 * @param paikeRecord1
	 * @return PaikeRecordView集合
	 *  根据enpUuid和keDateTime查出我的今日课程
	 */
	ArrayList<PaikeRecordView> getAllPaike(PaikeRecord paikeRecord1); 
}
