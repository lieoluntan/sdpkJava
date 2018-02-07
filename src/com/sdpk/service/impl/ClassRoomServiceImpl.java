package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.sdpk.dao.ClassRoomDao;
import com.sdpk.dao.impl.ClassRoomDaoImpl;
import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;
import com.sdpk.query.nameQuery.dao.NameReCRoomDao;
import com.sdpk.query.nameQuery.dao.impl.NameReCRoomDaoImpl;
import com.sdpk.service.ClassRoomService;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-30 上午9:46:29 类说明
 */

public class ClassRoomServiceImpl implements ClassRoomService {
	private NameReCRoomDao nameReCRoomDao = new NameReCRoomDaoImpl();
	private ClassRoomDao classRoomDao = new ClassRoomDaoImpl();
	Logger logger = Logger.getLogger(ClassRoomServiceImpl.class);

	@Override
	public String insert(ClassRoom classRoom) {
		// TODO Auto-generated method stub
		String flag = this.getClaSSRoomByName1(classRoom);
		if (flag.equals("yes")) {
			return flag;
		} else {
			classRoom.setUuid(null);

			classRoom.setUuid(UUID.randomUUID().toString());
			System.out.println("^^在ClassRoomServiceImpl收到数据 ："
					+ classRoom.toString() + "收到结束!");
			boolean daoFlag = classRoomDao.insert(classRoom);
			if (daoFlag) {
				return classRoom.getUuid();
			} else {
				logger.error("插入不成功,dao层执行有出错地方,请联系管理员");
				return "插入不成功,dao层执行有出错地方,请联系管理员";
			}
		}
	}// end method insert

	@Override
	public String delete(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			boolean daoFlag = classRoomDao.delete(uuid);

			if (daoFlag) {
				return uuid;
			} else {
				logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "ClassRoomServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}

	}// end method delete

	@Override
	public String update(ClassRoom classRoom) {
		// TODO Auto-generated method stub
		String flag = this.getClaSSRoomByName1(classRoom);
		if (flag.equals("yes")) {
			return flag;
		} else {
			String uuid = classRoom.getUuid();
			if (uuid != null && uuid != "") {
				boolean daoFlag = classRoomDao.update(classRoom);
				if (daoFlag) {
					return uuid;
				} else {
					logger.error("修改不成功,dao层执行有出错地方,请联系管理员");
					return "修改不成功,dao层执行有出错地方,请联系管理员";
				}
			} else {
				String msg = "ClassRoomServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
				System.out.println(msg);
				return msg;
			}
		}// end method update
	}

	@Override
	public ClassRoom getByUuid(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			ClassRoom classRoom = classRoomDao.getByUuid(uuid);
			return classRoom;
		} else {
			System.out
					.println("ContractServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
			ClassRoom classRoomX = new ClassRoom();
			return classRoomX;
		}
	}// end method getByUuid

	@Override
	public ArrayList<ClassRoom> getList() {
		// TODO Auto-generated method stub
		ArrayList<ClassRoom> classRoomlist = classRoomDao.getList();

		return classRoomlist;
	}// end method getList()

	@Override
	public String getClassRoomByName(ClassRoom cR) {
		// TODO Auto-generated method stub
		String flag = "";

		List<ClassRoom> crList = nameReCRoomDao.getCRByName(cR);
		for (ClassRoom cR2 : crList) {

			if (cR2.getUuid() != null) {
				flag = "（有重名）" + cR.getName();

				return flag;
			}
		}
		flag = "（无重名）" + cR.getName();

		return flag;
	}

	@Override
	public String getClaSSRoomByName1(ClassRoom CR) {
		// TODO Auto-generated method stub
		String flag = "";

		List<ClassRoom> crList = nameReCRoomDao.getCRByName(CR);
		for (ClassRoom cr2 : crList) {
			// 编辑验证重名要过滤掉自己本身的名字
			String s2Uuid = cr2.getUuid();
			boolean flagSelf = s2Uuid.equals(CR.getUuid());
			boolean flagNotSelf = !flagSelf;
			if (flagNotSelf) {// 编辑验证重名要过滤

				if (cr2.getUuid() != null) {
					flag = "yes";

					return flag;
				}
			}// end if(flagNotSelf)
		}
		flag = "no";
		return flag;
	}// end method

	@Override
	public String getonoff(ClassRoom classRoom) {
		// TODO Auto-generated method stub
		String uuid = classRoom.getUuid();
		if (uuid != null && uuid != "") {
			String oAc = classRoom.getOpenAndclose();
			boolean daoFlag = classRoomDao.updateOnOff(uuid, oAc);

			if (daoFlag) {
				return "操作成功";
			} else {
				logger.error("操作失败,dao层执行有出错地方,请联系管理员");
				return "操作失败,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "ClassRoomServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}// end method

}// end class
