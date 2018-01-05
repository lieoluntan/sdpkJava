package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
/**
 * 
 * @author 罗成峰
 * @date 2018-1-5下午1:58:22
 * @version 1.0
 */
public interface QueKeService {

	ArrayList<PaikeRecordView>getAllpaike(PaikeRecord paikeRecord);
}
