package com.sdpk.query.dao;

import java.util.ArrayList;



import com.sdpk.model.Contract;

/**
 * 
 * @author 罗成峰
 * @date 2018-1-4下午2:18:22
 * @version 1.0
 */
public interface ContractNewDao {

	public Contract getByUuid (String uuid);
	
	public ArrayList<Contract>getList();
	
	
}
