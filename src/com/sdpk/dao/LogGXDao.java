package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.LogGX;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public interface LogGXDao {
	/**
	 * 日志删除
	 * @param uuid
	 * @return
	 */
	boolean delete(String uuid);
	/**
	 * 日志查询
	 * @return
	 */
	ArrayList<LogGX> getList();
	/**
	 * 日志新增
	 */
	boolean insert(LogGX log);
}
