package com.sdpk.query.nameQuery.dao;

import java.util.List;

import com.sdpk.model.Student;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午3:39:07
 *
 */
public interface NameReStuDao {

	public List<Student> getStuByName(Student student);
	
	
}
