package com.sdpk.query.dao;

import java.util.List;

import com.sdpk.model.Contract;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-3 上午10:56:31
 * 
 */
public interface MyConDao {

	List<String> getClaId(String empUuid);

	List<String> getConId(String classid);

	Contract getConList(String uuid);
}
