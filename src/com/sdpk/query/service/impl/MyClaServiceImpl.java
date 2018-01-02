package com.sdpk.query.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sdpk.dao.And_ClassEmpDao;
import com.sdpk.dao.ClaDao;
import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.impl.And_ClassEmpDaoImpl;
import com.sdpk.dao.impl.ClaDaoImpl;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.Cla;
import com.sdpk.model.Employee;
import com.sdpk.query.dao.MyClaDao;
import com.sdpk.query.dao.impl.MyClaDaoImpl;
import com.sdpk.query.service.MyClaService;
import com.sdpk.utility.DBUtility;
import com.sdpk.utility.M_msg;

public class MyClaServiceImpl implements MyClaService{
	private And_ClassEmpDao and_ClassEmpDao = new And_ClassEmpDaoImpl();
	private ClaDao claDao = new ClaDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private Connection connection;
	private MyClaDao myclaDao = new MyClaDaoImpl();
	public M_msg m_msg = new M_msg();
	
	@Override
	public ArrayList<And_ClassEmp> getListBycla(String classUuid) {
		// TODO Auto-generated method stub
		ArrayList<And_ClassEmp> list = and_ClassEmpDao.getListBycla(classUuid);
	    ArrayList<And_ClassEmp> reList =new ArrayList<And_ClassEmp>();
	    for(And_ClassEmp one : list){
	      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
	      String cUuid = one.getClassUuid();
	      String eUuid = one.getEmpUuid();
	      Cla cla = claDao.getByUuid(cUuid);
	      Employee emp = employeeDao.getByUuid(eUuid);
	      String cName = cla.getName();
	      String eName = emp.getName();
	      
	      And_ClassEmp copyOne = new And_ClassEmp();
	      copyOne.setClassUuid(cUuid);
	      copyOne.setClassName(cName);
	      copyOne.setEmpUuid(eUuid);
	      copyOne.setEmpName(eName);

	      String oldUuid =  one.getUuid();
	      copyOne.setUuid(oldUuid);
	      reList.add(copyOne);
	    }
	      return reList;
	}
	@Override
	public ArrayList<And_ClassEmp> getListByEmp(String empUuid) {
		 ArrayList<And_ClassEmp> list = and_ClassEmpDao.getListByEmp(empUuid);
		    ArrayList<And_ClassEmp> reList =new ArrayList<And_ClassEmp>();
		    for(And_ClassEmp one : list){
		      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
		      String cUuid = one.getClassUuid();
		      String eUuid = one.getEmpUuid();
		      Cla cla = claDao.getByUuid(cUuid);
		      Employee emp = employeeDao.getByUuid(eUuid);
		      String cName = cla.getName();
		      String eName = emp.getName();
		      
		      And_ClassEmp copyOne = new And_ClassEmp();
		      copyOne.setClassUuid(cUuid);
		      copyOne.setClassName(cName);
		      copyOne.setEmpUuid(eUuid);
		      copyOne.setEmpName(eName);

		      String oldUuid =  one.getUuid();
		      copyOne.setUuid(oldUuid);
		      reList.add(copyOne);
		    }
		    return reList;
	}
}
