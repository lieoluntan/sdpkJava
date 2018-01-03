package com.sdpk.query.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-3 下午1:06:49
 *
 */
public interface MyTodPaikeDao {
	
	
	ArrayList<PaikeRecordView> getMyPaike(PaikeRecord PaikeRecord);
}
