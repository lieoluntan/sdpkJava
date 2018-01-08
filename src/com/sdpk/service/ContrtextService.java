package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Contract;
import com.sdpk.model.Contrtext;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:08:42
 *
 */
public interface ContrtextService {

	  String insert(Contrtext contrtext);
	
	  ArrayList<Contrtext> getList();
	  
	  String delete(String uuid);
	  
	  String update(Contrtext contrtext);
	  
	  Contrtext getByUuid(String uuid);
}
