package com.sdpk.query.dao;

import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;

/*
 * @author 刘鑫
 * @date 2018-01-25 18:13
 */
public interface QueCountCtextDao {
	public ArrayList<QueCountCtext> queryCountCtext(String uuid);
	
	public ArrayList<String> queryAllstuUuid();
}
