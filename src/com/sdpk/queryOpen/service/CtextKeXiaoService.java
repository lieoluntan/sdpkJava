package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;

public interface CtextKeXiaoService {
	//查询合同统计
		public ArrayList<QueCountCtext> queryCountCtext(String uuid);

		//查所有学生uuid
		public ArrayList<String> queryAllstuUuid();
}
