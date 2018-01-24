package com.sdpk.system.service.impl;

import com.sdpk.system.dao.UserPKpassDao;
import com.sdpk.system.dao.impl.UserPKpassDaoImpl;
import com.sdpk.system.model.UserPK;
import com.sdpk.system.service.UserPKpassService;
/*
 * 
 * @author 刘鑫
 * @date  ‎2018‎年‎1‎月‎24‎日‎ ‎17‎:‎08‎:‎38
 */
public class UserPKpassServiceImpl implements UserPKpassService {
	UserPKpassDao upd=new UserPKpassDaoImpl();
	
	@Override
	public boolean updatePassword(UserPK userPK) {
		// TODO Auto-generated method stub
		
		return upd.updateUserPassword(userPK);
	}

}
