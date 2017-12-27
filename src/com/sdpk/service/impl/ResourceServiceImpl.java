package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.ResourceDao;
import com.sdpk.dao.impl.ResourceDaoImpl;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Resource;
import com.sdpk.service.ResourceService;
import com.sdpk.utility.M_msg;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-26 上午11:31:58
 * 
 */
public class ResourceServiceImpl implements ResourceService {
	private ResourceDao resourceDao = new ResourceDaoImpl();
	public M_msg m_msg = new M_msg();

	@Override
	public String insert(Resource resource) {
		// TODO Auto-generated method stub
		ArrayList<Resource> list = resourceDao
				.getListbyName(resource.getName());
		if (!list.isEmpty() && list != null && list.size() != 0) {
			String msg = "已存在重复名字";
			m_msg.setAddMsg(msg);
			return msg;
		} else {
			resource.setUuid(null);

			resource.setUuid(UUID.randomUUID().toString());
			System.out.println("^^在ResourceServiceImpl收到数据 ："
					+ resource.toString() + "收到结束!");

			boolean daoFlag = resourceDao.insert(resource);
			if (daoFlag) {
				return resource.getUuid();
			} else {
				return "插入不成功,dao层执行有出错地方,请联系管理员";
			}

		}

	}

	@Override
	public String delete(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			boolean daoFlag = resourceDao.delete(uuid);

			if (daoFlag) {
				return uuid;
			} else {
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "ResourceServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}

	@Override
	public String update(Resource resource) {
		// TODO Auto-generated method stub
		String uuid = resource.getUuid();
		if (uuid != null && uuid != "") {

			boolean daoFlag = resourceDao.update(resource);

			if (daoFlag) {
				return uuid;
			} else {
				return "修改不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "ResourceServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}

	@Override
	public Resource getByUuid(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			// ClassRoom classRoom = classRoomDao.getByUuid(uuid);
			Resource resource = resourceDao.getByUuid(uuid);
			return resource;
		} else {
			System.out
					.println("ResourceServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
			// ClassRoom classRoomX= new ClassRoom();
			Resource resourceX = new Resource();
			return resourceX;
		}
	}

	@Override
	public ArrayList<Resource> getList() {
		// TODO Auto-generated method stub
		ArrayList<Resource> resourcelist = resourceDao.getList();

		return resourcelist;
	}

	@Override
	public ArrayList<Resource> getListbyName(String name) {
		// TODO Auto-generated method stub
		if (name != null && name != "") {

			return resourceDao.getListbyName(name);
		} else {
			System.out
					.println("ResourceServiceImpl getListbyName方法中的name为空，或格式不正确，请联系管理员");
		}
		return null;
	}

	@Override
	public M_msg getMsg() {
		// TODO Auto-generated method stub
		return m_msg;
	}

}
