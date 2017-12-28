package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.UserPK_Role;
/**
 * 
 * @author 罗成峰
 * @date 2017-12-27下午1:41:41
 * 
 */
public interface UserPK_RoleDao {
	/**
	 * 
	 * @param userPkid
	 * @return
	 */
	ArrayList<UserPK_Role>getListByuse(String userPkid);
	/**
	 * 
	 * @param userPK_Role
	 * @return
	 */
	boolean insert(UserPK_Role userPK_Role);
	/**
	 * 
	 * @param uuid
	 * @return
	 */
	boolean delete(String uuid);
	/**
	 * 
	 * @param userPkid
	 * @return
	 */
	boolean deleteByuse(String userPkid);
	/**
	 * 
	 * @param roleid
	 * @return
	 */
	ArrayList<UserPK_Role>getListByRole(String roleid);
}
