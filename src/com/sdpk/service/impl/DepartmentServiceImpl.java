package com.sdpk.service.impl;

import java.util.ArrayList;

import com.sdpk.dao.DepartmentDao;
import com.sdpk.dao.impl.DepartmentDaoImpl;
import com.sdpk.model.Department;
import com.sdpk.service.DepartmentService;
/*
 * @author 刘鑫
 * @date 2018-1-28 11：54
 */
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao=new DepartmentDaoImpl();
	@Override
	public boolean insertDepartment(Department department) {
		
		return departmentDao.insertDepartment(department);
		// TODO Auto-generated method stub
		
	}
	@Override
	public String serachDepartmentName(Department department) {
		// TODO Auto-generated method stub
		return departmentDao.serachDepartmentName(department);
	}
	@Override
	public void deleteDepartment(String uuid) {
		// TODO Auto-generated method stub
		departmentDao.deleteDepartment(uuid);
	}
	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.updateDepartment(department);
	}
	@Override
	public ArrayList<Department> listDepartment() {
		// TODO Auto-generated method stub
		return departmentDao.listDepartment();
	}
	@Override
	public Department serachOneDepartment(String uuid) {
		// TODO Auto-generated method stub
		return departmentDao.serachOneDepartment(uuid);
	}
	@Override
	public void updateOnOff(String uuid, String oac) {
		// TODO Auto-generated method stub
		departmentDao.updateOnOff(uuid, oac);
	}

}
