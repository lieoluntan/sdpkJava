package com.sdpk.queryOpen.service.impl;

import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;
import com.sdpk.query.dao.QueCountCtextDao;
import com.sdpk.query.dao.impl.QueCountCtextDaoImpl;
import com.sdpk.queryOpen.dao.CtextKeXiaoDao;
import com.sdpk.queryOpen.dao.impl.CtextKeXiaoDaoImpl;
import com.sdpk.queryOpen.service.CtextKeXiaoService;

public class CtextKeXiaoServiceImpl implements CtextKeXiaoService{
	
	
	@Override
	public ArrayList<QueCountCtext> queryCountCtext(String uuid) {
		// TODO Auto-generated method stub
		CtextKeXiaoDao qccd=new CtextKeXiaoDaoImpl();
		return qccd.queryCountCtext(uuid);
	}

	@Override
	public ArrayList<String> queryAllstuUuid() {
		// TODO Auto-generated method stub
		CtextKeXiaoDao qccd=new CtextKeXiaoDaoImpl();
		return qccd.queryAllstuUuid();
	}
}
