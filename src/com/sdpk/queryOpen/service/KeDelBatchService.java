package com.sdpk.queryOpen.service;

import java.util.List;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public interface KeDelBatchService {
	 /**
	  * 批量删除paike
	  */
	 public String deleteBatch(List<String> uuidList,String userUuid,String userName);
}
