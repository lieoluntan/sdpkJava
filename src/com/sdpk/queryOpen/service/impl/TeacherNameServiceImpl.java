package com.sdpk.queryOpen.service.impl;

import java.util.ArrayList;

import com.sdpk.model.Employee;
import com.sdpk.queryOpen.dao.TeacherNameDao;
import com.sdpk.queryOpen.dao.impl.TeacherNameDaoImpl;
import com.sdpk.queryOpen.service.TeacherNameService;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public class TeacherNameServiceImpl implements TeacherNameService{
	private TeacherNameDao tns= new TeacherNameDaoImpl();
	@Override
	public ArrayList<Employee> getList() {
		// TODO Auto-generated method stub
		return tns.getList();
	}

}
