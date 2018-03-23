package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public interface CtextKeXiaoService {
	//查询合同统计
		public ArrayList<QueCountCtext> queryCountCtext(String uuid);

		//查所有学生uuid
		public ArrayList<String> queryAllstuUuid();
}
