package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.Cla;
import com.sdpk.model.Student;
import com.sdpk.utility.M_msg;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public interface StuNameService {
	public ArrayList<Student> getList();
	
	M_msg  getMsg();
}
