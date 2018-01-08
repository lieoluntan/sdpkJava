package com.sdpk.service;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.ConPrice;
import com.sdpk.model.Contract;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:12:55
 *
 */
public interface ConPriceService {
	 String insert(ConPrice conPrice);
	 
	 ArrayList<ConPrice> getList();
	 
	 String delete(String uuid);
	 
	 String update(ConPrice conPrice);
	 
	 ConPrice getByUuid(String uuid);
	 
	 ArrayList<ConPrice> getByContrUuid(String contrUuid);
}
