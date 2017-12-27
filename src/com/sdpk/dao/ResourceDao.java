package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.ClassRoom;
import com.sdpk.model.Resource;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-26 上午10:53:50
 * 
 */
public interface ResourceDao {
	/**
	 * 
	 * @param resource
	 * @return
	 */
	public boolean insert(Resource resource);

	public boolean delete(String uuid);

	public boolean update(Resource resource);

	public Resource getByUuid(String uuid);

	public ArrayList<Resource> getList();
	//根据name查询信息，如果有信息，说明name存在；
	public ArrayList<Resource> getListbyName(String name);


}
