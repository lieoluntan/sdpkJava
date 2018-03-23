package com.sdpk.queryOpen.service.impl;

import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;
import com.sdpk.query.dao.QueCountCtextDao;
import com.sdpk.query.dao.impl.QueCountCtextDaoImpl;
import com.sdpk.queryOpen.dao.CtextKeXiaoDao;
import com.sdpk.queryOpen.dao.impl.CtextKeXiaoDaoImpl;
import com.sdpk.queryOpen.service.CtextKeXiaoService;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
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
