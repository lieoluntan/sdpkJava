package com.sdpk.query.dao;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Contract;
import com.sdpk.model.Contrtext;

public interface MyContrtextDao {

	List<String> getClaId(String empUuid);

	List<String> getConId(String classId);

	//--------------分割线，以上方法是查我的合同，以下方法是提升所有合同的速度查询方法
    ArrayList<Contrtext> getAllSpeedList();



}//end interface
