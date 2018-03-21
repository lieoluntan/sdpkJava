package com.sdpk.queryOpen.service;

import com.sdpk.utility.M_msg;



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
