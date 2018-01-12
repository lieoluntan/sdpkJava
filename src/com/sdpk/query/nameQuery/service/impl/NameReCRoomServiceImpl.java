package com.sdpk.query.nameQuery.service.impl;

import java.util.List;

import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;
import com.sdpk.query.nameQuery.dao.NameReCRoomDao;
import com.sdpk.query.nameQuery.dao.impl.NameReCRoomDaoImpl;

import com.sdpk.query.nameQuery.service.NameReCRoomService;
/**
 * 
 * @author 罗成峰
 * @date 2018-1-11下午3:24:32
 * @version 1.0
 */
public class NameReCRoomServiceImpl implements NameReCRoomService{
	private NameReCRoomDao nameReCRoomDao=new NameReCRoomDaoImpl();
	@SuppressWarnings("unused")
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

			if (cr2.getUuid() != null) {
				flag = "yes";

				return flag;
			}
		}
		flag = "no";
		return flag;
	}

}
