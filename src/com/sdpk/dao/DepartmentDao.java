package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.Department;

/*
 * @author 刘鑫
 * @date 2018-1-28 11：23
 */
public interface DepartmentDao {
	//新增部门
	public boolean insertDepartment(Department department);
	//验证部门名称是否存在
	public String serachDepartmentName(Department department);
	//删除部门
	public void deleteDepartment(String uuid);
	//修改部门信息
	public void updateDepartment(Department department);
	//查询所有部门
	public ArrayList<Department> listDepartment();
	//查询单个部门
	public Department serachOneDepartment(String uuid);
	//部门开关
	public void updateOnOff(String uuid,String oac);
}
