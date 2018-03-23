package com.sdpk.queryOpen.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.sdpk.model.Cla;
import com.sdpk.queryOpen.dao.ClaNameDao;
import com.sdpk.queryOpen.dao.impl.ClaNameDaoImpl;
import com.sdpk.queryOpen.service.ClaNameService;
import com.sdpk.service.impl.ClaServiceImpl;
import com.sdpk.utility.M_msg;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public class ClaNameServiceImpl implements ClaNameService{

	 public M_msg m_msg = new M_msg();
	 Logger logger = Logger.getLogger(ClaServiceImpl.class);
	 private ClaNameDao cnd = new ClaNameDaoImpl();
	
	@Override
	public ArrayList<Cla> getList() {
		// TODO Auto-generated method stub
		return cnd.getList();
	}

	@Override
	public M_msg getMsg() {
		// TODO Auto-generated method stub
		return m_msg;
	}

}
