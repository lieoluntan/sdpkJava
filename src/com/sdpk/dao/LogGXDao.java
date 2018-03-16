package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.LogGX;

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
