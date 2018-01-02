package com.sdpk.query.dao;

import java.util.List;

import com.sdpk.model.Student;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-2 下午3:38:49
 *
 */
public interface MyStuDao {

	
	List<String> getClaId(String empUuid);
	
	List<String> getStuId(String classid);
	
	Student getStuList(String uuid);
	
}
