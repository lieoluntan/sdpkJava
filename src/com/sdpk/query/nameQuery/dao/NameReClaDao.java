package com.sdpk.query.nameQuery.dao;

import java.util.List;

import com.sdpk.model.Cla;


/**
 * 
 * @author 罗成峰
 * @date 2018-1-5下午3:46:22
 * @version 1.0
 */
public interface NameReClaDao {
	public List<Cla> getClaByName(Cla cla);
}
