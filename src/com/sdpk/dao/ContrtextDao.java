package com.sdpk.dao;

import java.util.List;

import com.sdpk.model.Contrtext;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:07:30
 *
 */
public interface ContrtextDao {

	public boolean insert(Contrtext contrtext);
	
	public boolean deleteByUuid(String uuid);
	
	public boolean update(Contrtext contrtext);
	
	public List<Contrtext> getList();
	
	public Contrtext getOne(String uuid);
	
	public Contrtext getByCnum(String cNum);
	
	
	
}
