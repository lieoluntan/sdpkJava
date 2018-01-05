package com.sdpk.query.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午12:57:24
 *
 */
public interface QueryKeMyDao {
	
	
	ArrayList<PaikeRecordView> getAllPaike(PaikeRecord paikeRecord1); 
}
