package com.sdpk.query.nameQuery.dao;

import java.util.List;

import com.sdpk.model.Contract;
import com.sdpk.model.Employee;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午5:22:39
 *
 */
public interface NameReContrDao {
	public List<Contract> getStuByName(Contract contract);
}
