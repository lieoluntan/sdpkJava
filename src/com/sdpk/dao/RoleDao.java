package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.Role;

/**
 * 
 * @author 罗成峰
 * @date 2017-12-26上午11:08:54
 * @version 1.0
 */
public interface RoleDao {

	public boolean insert(Role Role);
	
	public boolean delete(String uuid);
	
	public boolean update(Role Role);
	
	public Role getByUuid (String uuid);
	
	public ArrayList<Role>getList();
}
