package com.sdpk.query.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.dao.And_ClassStuDao;
import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.And_ClassStuDaoImpl;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.And_ClassStu;
import com.sdpk.model.Student;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-3 下午2:05:16 工具类，传入班级id，返回学生id和name对象的集合
 */
public class ClaStuTool {
	private And_ClassStuDao And_ClassStuDao = new And_ClassStuDaoImpl();
	private StudentDao StudentDao = new StudentDaoImpl();

	public List<Student> getStuByCla(String classid) {
		Student student = new Student();
		List<Student> stuList = new ArrayList<Student>();
		List<And_ClassStu> stuidList = And_ClassStuDao.getListBycla(classid);// 根据班级id查出来班级下的所有学生id
																				// and_ClassStu.getStuUuid()就是学生id
		for (And_ClassStu and_ClassStu : stuidList) {
			student = StudentDao.getStuByUuid(and_ClassStu.getStuUuid());
			stuList.add(student);

		}

		return stuList;
	}

}
