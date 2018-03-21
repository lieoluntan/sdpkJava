package com.sdpk.queryOpen.dao;

import com.sdpk.model.Student;

public interface StudentIDDao {
	/**
	 * 查询学号最大信息
	 */
	 public int findMaxIdShow();
	 
	 /**
	   * 查询StudentID是否重复
	   */
	  public Student findId(String id);
	 
	 /**
	  * 修改学号
	  */
	 public boolean updateStuId(String StuId,String uuid,String name); 
}
