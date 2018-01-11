package com.sdpk.dao;

import java.util.List;

import com.sdpk.model.ConPrice;
import com.sdpk.model.Contrtext;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:11:53
 *  合同价格
 */
public interface ConPriceDao {

	public boolean insert(ConPrice conPrice);
	
	public boolean deleteByUuid(String uuid);
	
	public boolean deleteByContrUuid(String contrUuid);
	
	public boolean update(ConPrice conPrice);
	
	public List<ConPrice> getList();
	
	public List<ConPrice> getByContrUuid(String contrUuid);
	
	public ConPrice getOne(String uuid);
	
}
