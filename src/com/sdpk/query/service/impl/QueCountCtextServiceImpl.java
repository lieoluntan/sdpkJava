package com.sdpk.query.service.impl;

import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;
import com.sdpk.query.dao.QueCountCtextDao;
import com.sdpk.query.dao.impl.QueCountCtextDaoImpl;
import com.sdpk.query.service.QueCountCtextService;

public class QueCountCtextServiceImpl implements QueCountCtextService {

	@Override
	public ArrayList<QueCountCtext> queryCountCtext(String uuid) {
		// TODO Auto-generated method stub
		QueCountCtextDao qccd=new QueCountCtextDaoImpl();
		return qccd.queryCountCtext(uuid);
	}

}
