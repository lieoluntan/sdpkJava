package com.sdpk.queryOpen.service;

import com.sdpk.utility.M_msg;


/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public interface StudentIDService {
	
	 M_msg getMsg();
	/**
     * 查询学号最大信息
	 */
	 public int findMaxIdShow();
	 
	 /**
	  * 单独修改studentID
	  */
	 public String updateStuId(String StuId,String uuid,String name); 
}
