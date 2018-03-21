package com.sdpk.queryOpen.dao;

import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;

public interface CtextKeXiaoDao {
public ArrayList<QueCountCtext> queryCountCtext(String uuid);
	
	public ArrayList<String> queryAllstuUuid();
}
