package com.sdpk.queryOpen.dao;

import com.sdpk.model.Student;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
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
