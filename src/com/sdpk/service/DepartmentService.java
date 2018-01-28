package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Department;

/*
 * @author 刘鑫
 * @date 2018-1-28 11：52
 */
public interface DepartmentService {
	//新增部门
	public boolean insertDepartment(Department department);
	
	public String serachDepartmentName(Department department);
	
	public void deleteDepartment(String uuid);
	
	public void updateDepartment(Department department);
	
	public ArrayList<Department> listDepartment();
	
	public Department serachOneDepartment(String uuid);
	
	public void updateOnOff(String uuid, String oac);
}
