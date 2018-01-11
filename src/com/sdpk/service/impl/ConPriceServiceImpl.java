package com.sdpk.service.impl;

import java.util.ArrayList;

import com.sdpk.dao.ConPriceDao;
import com.sdpk.dao.impl.ConPriceDaoImpl;
import com.sdpk.model.ConPrice;
import com.sdpk.service.ConPriceService;
/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:13:11
 *
 */
public class ConPriceServiceImpl implements ConPriceService {
private ConPriceDao conPriceDao=new ConPriceDaoImpl();

@Override
public String insert(ConPrice conPrice) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<ConPrice> getList() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String delete(String uuid) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String update(ConPrice conPrice) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ConPrice getByUuid(String uuid) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<ConPrice> getByContrUuid(String contrUuid) {
	// TODO Auto-generated method stub
	return null;
}
	
	
}
