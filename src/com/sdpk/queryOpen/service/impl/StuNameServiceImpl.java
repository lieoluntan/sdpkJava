package com.sdpk.queryOpen.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.model.Cla;
import com.sdpk.model.Student;
import com.sdpk.queryOpen.dao.StuNameDao;
import com.sdpk.queryOpen.dao.impl.StuNameDaoImpl;
import com.sdpk.queryOpen.service.StuNameService;
import com.sdpk.service.impl.ClaServiceImpl;
import com.sdpk.utility.M_msg;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public class StuNameServiceImpl implements StuNameService {
	 public M_msg m_msg = new M_msg();
	 Logger logger = Logger.getLogger(ClaServiceImpl.class);
	 private StuNameDao  snd = new StuNameDaoImpl();
	
	@Override
	public ArrayList<Student> getList() {
		// TODO Auto-generated method stub
		return snd.getList();
	}

	@Override
	public M_msg getMsg() {
		// TODO Auto-generated method stub
		return m_msg;
	}

}
