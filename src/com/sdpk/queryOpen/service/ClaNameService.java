package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.Cla;
import com.sdpk.utility.M_msg;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public interface ClaNameService {
	public ArrayList<Cla> getList();
	
	M_msg  getMsg();
}
