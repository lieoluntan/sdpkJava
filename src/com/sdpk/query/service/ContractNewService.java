package com.sdpk.query.service;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Contract;
import com.sdpk.model.Student;

/**
 * 
 * @author 罗成峰
 * @date 2018-1-4下午2:16:28
 * @version 1.0
 */
public interface ContractNewService {

	Contract getByUuid(String uuid);
	
	ArrayList<Contract> getList();
}
