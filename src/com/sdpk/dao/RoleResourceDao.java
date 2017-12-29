package com.sdpk.dao;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Resource;
import com.sdpk.model.RoleResource;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-27 上午11:02:07
 * 
 */
public interface RoleResourceDao {

	public String insert_batch(ArrayList<RoleResource> PR_List);

	List<String> getRsbyRoleid(List<String> list);

	public boolean insert(RoleResource roleResource);

	public boolean delete(String uuid);

	public boolean update(RoleResource roleResource);

	public RoleResource getByUuid(String uuid);

	public ArrayList<RoleResource> getList();

	public ArrayList<RoleResource> getListbyName(String roleid,
			String resourceid);
}