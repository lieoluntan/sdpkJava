package com.sdpk.queryOpen.service.impl;

import java.util.ArrayList;

import com.sdpk.model.Employee;
import com.sdpk.queryOpen.dao.TeacherNameDao;
import com.sdpk.queryOpen.dao.impl.TeacherNameDaoImpl;
import com.sdpk.queryOpen.service.TeacherNameService;

public class TeacherNameServiceImpl implements TeacherNameService{
	private TeacherNameDao tns= new TeacherNameDaoImpl();
	@Override
	public ArrayList<Employee> getList() {
		// TODO Auto-generated method stub
		return tns.getList();
	}

}
