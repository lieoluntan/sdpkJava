package com.sdpk.service;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.LogGX;
import com.sdpk.utility.M_msg;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public interface LogGXService {
	/**
	 * 日志新增
	 */
	public String insert(LogGX log);
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
	 public String deleteBatch(List<String> uuid);
//	 /**
//	  * 日志新增
//	  * @return
//	  */
//	 public String add(LogGX log);
	 
	 M_msg getMsg();
}
