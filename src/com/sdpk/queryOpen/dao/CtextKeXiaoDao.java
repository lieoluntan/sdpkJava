package com.sdpk.queryOpen.dao;

import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public interface CtextKeXiaoDao {
public ArrayList<QueCountCtext> queryCountCtext(String uuid);
	
	public ArrayList<String> queryAllstuUuid();
}
