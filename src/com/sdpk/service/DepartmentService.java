package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Department;

/*
 * @author 刘鑫
 * @date 2018-1-28 11：52
 */
public interface DepartmentService {
String insert(Department department);
	
	String delete(String uuid);
	
	String update(Department department);
	
	Department getByUuid(String uuid);
	
	ArrayList<Department> getList();
	
	public String getDepartmentByName(Department dM);
	
	public String getDepaartmentByName1(Department dM);
	
	String getonoff(Department department);
}
