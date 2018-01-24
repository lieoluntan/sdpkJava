package com.sdpk.query.dao;

import java.util.List;

import com.sdpk.model.Contract;

public interface MyContrtextDao {

	List<String> getClaId(String empUuid);

	List<String> getConId(String classId);



}//end interface
