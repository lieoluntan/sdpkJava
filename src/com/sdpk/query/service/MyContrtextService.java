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

	List<Contrtext> getHeadList(String empUuid);

  List<Contrtext> getAllSpeedList();

  List<Contrtext> getnameTcnameList();

}//end interface
