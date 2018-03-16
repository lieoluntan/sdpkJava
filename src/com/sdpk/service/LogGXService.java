package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.LogGX;
import com.sdpk.utility.M_msg;

public interface LogGXService {
	/**
	 * 删除
	 */
	 public String delete(LogGX log);
	 /**
	  * 查询
	  */
	 public ArrayList<LogGX> getList();
	 /**
	  * 批量删除
	  * @return
	  */
	 public String deleteBatch(String[] uuid);
//	 /**
//	  * 日志新增
//	  * @return
//	  */
//	 public String add(LogGX log);
	 
	 M_msg getMsg();
}
