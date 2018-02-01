package com.sdpk.query.service;

import java.util.List;

import com.sdpk.model.Contrtext;

/**
 * 
 * @author xpp
 * @date 2018-1-24上午11:51:55
 * @version 1.0
 */
public interface MyContrtextService {

    //慢版获取我的合同列表
	List<Contrtext> getHeadList(String empUuid);

	//速度版获取所有管理合同列表
  List<Contrtext> getAllSpeedList();

  //获取合同别名，用于下拉框
  List<Contrtext> getnameTcnameList();

  //速度版获取我的合同列表
  List<Contrtext> getHeadSpeedList(String empUuid);

}//end interface
