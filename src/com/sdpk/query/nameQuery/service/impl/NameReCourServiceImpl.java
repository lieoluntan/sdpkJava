package com.sdpk.query.nameQuery.service.impl;

import java.util.List;

import com.sdpk.model.Course;
import com.sdpk.query.nameQuery.dao.NameReCourDao;
import com.sdpk.query.nameQuery.dao.impl.NameReCourDaoImpl;
import com.sdpk.query.nameQuery.service.NameReCourService;

public class NameReCourServiceImpl implements NameReCourService{
	private NameReCourDao nameReCourDao=new NameReCourDaoImpl();
	@SuppressWarnings("unused")
	@Override
	public String getCourByName(Course cour) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Course> courList = nameReCourDao.getCourByName(cour);
		for (Course cour2 : courList) {

			if (cour2.getUuid() != null) {
				flag = "（有重名）" + cour.getName();

				return flag;
			}

		}
		flag = "（无重名）" + cour.getName();

		return flag;
	}

	@Override
	public String getCourByName1(Course cour) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Course> courList = nameReCourDao.getCourByName(cour);
		for (Course cour2 : courList) {

			if (cour2.getUuid() != null) {
				flag = "yes";

				return flag;
			}
		}
		flag = "no";
		return flag;
	}

}
