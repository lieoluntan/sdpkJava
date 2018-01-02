package com.sdpk.query.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sdpk.model.Cla;
import com.sdpk.query.dao.MyClaDao;
import com.sdpk.query.dao.impl.MyClaDaoImpl;
import com.sdpk.query.service.MyClaService;
/**
 * 
 * @author 罗成峰
 * @date 2018-1-2下午8:42:01
 * @version 1.0
 */
public class MyClaServiceImpl implements MyClaService{

	private MyClaDao myClaDao = new MyClaDaoImpl();
	@Override
	public List<Cla> getClaId(String ClaUuid) {
		// TODO Auto-generated method stub
		List<String> ClassidList = myClaDao.getempid(ClaUuid);
		
		Set set = new HashSet();
		List<String> newClaIdList = new ArrayList<String>();
		for (String cd : ClassidList) {
			if (set.add(cd)) {
				newClaIdList.add(cd);
			}
		}
		//List<String> claIdList = this.getClaid(newClaIdList);
		List<Cla> ClaList = this.getClaaList(newClaIdList);
		return ClaList;
	}
	@Override
	public List<String> getClaid(List<String> ClaIdList) {
		// TODO Auto-generated method stub
		List<String> claIdList = new ArrayList<String>();
		for (String classId : ClaIdList) {
			List<String> stuid = myClaDao.getClaId(classId);
			for (String s : stuid) {
				claIdList.add(s);
			}
		}
		Set set = new HashSet();
		List<String> newClaIdList = new ArrayList<String>();
		for (String cd : claIdList) {
			if (set.add(cd)) {
				newClaIdList.add(cd);
			}
		}
		 return newClaIdList;
	}
	@Override
	public List<Cla> getClaaList(List<String> ClaIdList) {
		// TODO Auto-generated method stub
		List<Cla> claList = new ArrayList<Cla>();
		for (String claid : ClaIdList) {
			Cla cla = myClaDao.getClaList(claid);
			// System.out.println(student.getName());
			claList.add(cla);
		}
		return claList;
	}
}
	

