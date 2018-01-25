package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;

/*
 * @author 刘鑫
 * @date 2018-1-25 13:02
 */
public interface MonthHeadService {
	//根据cliuuid和kedatetime查询月课
	public ArrayList<PaikeRecordView> queryMonthKeByClaUuid(String claUuid,String keDateTime);
}
