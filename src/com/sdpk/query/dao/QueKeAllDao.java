package com.sdpk.query.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;

/**
 * 
 * @author 谢平平
 * @date 2018-1-14上午11:51:55
 * @version 1.0
 */
public interface QueKeAllDao {
	
	public ArrayList<PaikeRecordView> getList();

  public ArrayList<PaikeRecordView> getListSpeed();

  public ArrayList<PaikeRecordView> getMonpaikeSpeed(String year, String month, String today);

  //实时速度查询排课表所有记录
  ArrayList<PaikeRecordView> getListSpeed5Biao();

}
