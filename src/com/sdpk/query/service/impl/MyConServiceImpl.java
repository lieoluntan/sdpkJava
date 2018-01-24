package com.sdpk.query.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.Contract;
import com.sdpk.model.Student;
import com.sdpk.query.dao.MyConDao;
import com.sdpk.query.dao.impl.MyConDaoImpl;
import com.sdpk.query.service.MyConService;

public class MyConServiceImpl implements MyConService {
	private MyConDao myConDao = new MyConDaoImpl();
	private StudentDao studentDao = new StudentDaoImpl();

	@Override
	public List<Contract> getClaId(String empUuid) {
		// TODO Auto-generated method stub
		List<String> ClassIdList = myConDao.getClaId(empUuid);
		// 去重复
		Set set = new HashSet();
		List<String> newClassIdList = new ArrayList<String>();// 新的资源集合，用来存放去重复后的资源id
		for (String cd : ClassIdList) {// foreach
			if (set.add(cd)) {
				newClassIdList.add(cd);
			}

		}// end forech 去重复完成
		List<String> ConIdList = this.getConId(newClassIdList);
		List<Contract> ConList = this.getConList(ConIdList);
		for (Contract contract : ConList) {
			Student st = studentDao.getByUuid(contract.getStuUuid());
			contract.setStuName(st.getName());
		}

		return ConList;
	}

	@Override
	public List<String> getConId(List<String> ClsaaIdList) {
		// TODO Auto-generated method stub
		List<String> ConIdList = new ArrayList<String>();// 存放所有的学员id
		for (String classId : ClsaaIdList) {

			List<String> Conid = myConDao.getConId(classId);
			for (String s : Conid) {

				ConIdList.add(s);
			}

		}// end for
		Set set = new HashSet();
		List<String> newConIdList = new ArrayList<String>();// 新的资源集合，用来存放去重复后的资源id
		for (String cd : ConIdList) {// foreach
			if (set.add(cd)) {
				newConIdList.add(cd);
			}

		}// end forech 去重复完成

		return newConIdList;
	}

	@Override
	public List<Contract> getConList(List<String> ConIdList) {
		// TODO Auto-generated method stub
		List<Contract> ConList = new ArrayList<Contract>();
		for (String stuid : ConIdList) {
			Contract contract = myConDao.getConList(stuid);
			// System.out.println(student.getName());
			ConList.add(contract);
		}

		return ConList;
	}//end method

}
