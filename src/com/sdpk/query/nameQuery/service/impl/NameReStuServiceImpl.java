package com.sdpk.query.nameQuery.service.impl;

import java.util.List;

import com.sdpk.model.Student;
import com.sdpk.query.nameQuery.dao.NameReStuDao;
import com.sdpk.query.nameQuery.dao.impl.NameReStuDaoImpl;
import com.sdpk.query.nameQuery.service.NameReStuService;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午3:47:57
 * 
 */
public class NameReStuServiceImpl implements NameReStuService {
	private NameReStuDao nameReStuDao = new NameReStuDaoImpl();

	@SuppressWarnings("unused")
	@Override
	public String getStuByName(Student student) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Student> stuList = nameReStuDao.getStuByName(student);
		for (Student student2 : stuList) {

			if (student2.getUuid() != null) {
				flag = "（有重名）" + student.getName();

				return flag;
			}

		}
		flag = "（无重名）" + student.getName();

		return flag;
	}

	@Override
	public String getStuByName1(Student student) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Student> stuList = nameReStuDao.getStuByName(student);
		for (Student student2 : stuList) {

			if (student2.getUuid() != null) {
				flag = "yes";

				return flag;
			}

		}
		flag = "no";

		return flag;
	}

}
