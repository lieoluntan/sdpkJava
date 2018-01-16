package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;

/**
 * 
 * @author 谢平平
 * @date 2018-1-14上午11:51:55
 * @version 1.0
 */
public interface QueKeAllService {

	ArrayList<PaikeRecordView> getAllpaike(PaikeRecord paikeRecord);

}
