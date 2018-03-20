package com.sdpk.queryOpen.service;

import java.util.List;

public interface KeDelBatchService {
	 /**
	  * 批量删除paike
	  */
	 public String deleteBatch(List<String> uuidList);
}
