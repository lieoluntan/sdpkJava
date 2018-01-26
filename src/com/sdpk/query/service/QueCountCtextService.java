package com.sdpk.query.service;

import java.util.ArrayList;

import com.sdpk.model.QueCountCtext;

/*
 * @author 刘鑫
 * @date 2018-01-26 11:16
 */
public interface QueCountCtextService {
	//查询合同统计
	public ArrayList<QueCountCtext> queryCountCtext(String uuid);
}
