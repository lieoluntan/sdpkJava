package com.sdpk.query.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sdpk.model.Student;
import com.sdpk.query.dao.MyStuDao;
import com.sdpk.query.dao.impl.MyStuDaoImpl;
import com.sdpk.query.service.MyStuService;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-2 下午3:40:03
 * 
 */
public class MyStuServiceImpl implements MyStuService {

	private MyStuDao myStuDao = new MyStuDaoImpl();

	@Override
	public List<Student> getClaId(String empUuid) {
		// TODO Auto-generated method stub
		// 先根据empUuid得到classid集合
		List<String> ClassIdList = myStuDao.getClaId(empUuid);
		// 去重复
		Set set = new HashSet();
		List<String> newClassIdList = new ArrayList<String>();// 新的资源集合，用来存放去重复后的资源id
		for (String cd : ClassIdList) {// foreach
			if (set.add(cd)) {
				newClassIdList.add(cd);
			}

		}// end forech 去重复完成
		List<String> stuIdList = this.getStuId(newClassIdList);
		List<Student> StuList = this.getStuList(stuIdList);

		return StuList;
	}

	@Override
	public List<String> getStuId(List<String> ClsaaIdList) {
		// TODO Auto-generated method stub
		// 根据班级id查询学员id
		System.out.println("进入");
		List<String> stuIdList = new ArrayList<String>();// 存放所有的学员id
		for (String classId : ClsaaIdList) {

			List<String> stuid = myStuDao.getStuId(classId);
			for (String s : stuid) {

				stuIdList.add(s);
			}

		}// end for
		Set set = new HashSet();
		List<String> newStuIdList = new ArrayList<String>();// 新的资源集合，用来存放去重复后的资源id
		for (String cd : stuIdList) {// foreach
			if (set.add(cd)) {
				newStuIdList.add(cd);
			}

		}// end forech 去重复完成

		
		return newStuIdList;

	}

	@Override
	public List<Student> getStuList(List<String> StuIdList) {
		// TODO Auto-generated method stub
		for (String string : StuIdList) {
			System.out.println(string);
		}
		List<Student> StuList = new ArrayList<Student>();
		for (String stuid : StuIdList) {
			Student student = myStuDao.getStuList(stuid);
			//System.out.println(student.getName());
			StuList.add(student);
		}

		return StuList;
	}

}
