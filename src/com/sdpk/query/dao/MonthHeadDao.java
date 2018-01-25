package com.sdpk.query.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;

/*
 * 
 * @author 刘鑫
 * @date 2018-1-25 9：49
 */
public interface MonthHeadDao {
	//根据clauuid和kedatetime查询月课
	public ArrayList<PaikeRecordView> queryMonthKeByClaUuid(String claUuid,String keDateTime);
}
