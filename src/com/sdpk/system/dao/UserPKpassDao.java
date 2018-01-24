package com.sdpk.system.dao;

import com.sdpk.system.model.UserPK;

/**
 * 
 * @author 刘鑫
 * @date ‎2018‎年‎1‎月‎24‎日‎ ‎16‎:‎19‎:‎15
 *  
 */

public interface UserPKpassDao {
	//根据用户名修改用户密码
	public boolean updateUserPassword(UserPK userPk);
}
