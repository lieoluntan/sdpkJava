package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.dao.RoleResourceDao;
import com.sdpk.dao.impl.RoleResourceImpl;
import com.sdpk.service.RoleResourceService;
/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2017-12-27 上午11:19:31
 *
 */
public class RoleResourceServiceImpl implements RoleResourceService {
	private RoleResourceDao roleResourceDao=new RoleResourceImpl();
	
	@Override
	public List<String> getRsbyRoleid(List<String> rolelist) {
		// TODO Auto-generated method stub
		//先判断集合为不为空
		if(!rolelist.isEmpty()&&rolelist.size()!=0&&rolelist!=null){
		
			roleResourceDao.getRsbyRoleid(rolelist);
				
				
			}
			
			
			
			
			
		
		
		return null;
	}

}
