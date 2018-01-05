package com.sdpk.query.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
/**
 * 
 * @author 罗成峰
 * @date 2018-1-5下午2:39:01
 * @version 1.0
 */
public interface QueKeDao {

	ArrayList<PaikeRecordView>getAllpaike(PaikeRecord paikeRecord);

}
