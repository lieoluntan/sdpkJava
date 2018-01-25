package com.sdpk.query.service.impl;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.query.dao.MonthHeadDao;
import com.sdpk.query.dao.impl.MonthHeadDaoImpl;
import com.sdpk.query.service.MonthHeadService;
/*
 * @author 刘鑫
 * @date 2018-1-25 13:04
 */
public class MonthHeadServiceImpl implements MonthHeadService {

	@Override
	public ArrayList<PaikeRecordView> queryMonthKeByClaUuid(String claUuid,String keDateTime) {
		// TODO Auto-generated method stub
		MonthHeadDao mhd=new MonthHeadDaoImpl();
		return mhd.queryMonthKeByClaUuid(claUuid, keDateTime);
	}

}
