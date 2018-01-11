package com.sdpk.query.nameQuery.service.impl;

import java.util.List;

import com.sdpk.model.Cla;
import com.sdpk.model.Contract;
import com.sdpk.query.nameQuery.dao.NameReClaDao;
import com.sdpk.query.nameQuery.dao.impl.NameReClaDaoImpl;
import com.sdpk.query.nameQuery.service.NameReClaService;

public class NameReClaServiceImpl implements NameReClaService{
	private NameReClaDao nameReClaDao=new NameReClaDaoImpl();
	@SuppressWarnings("unused")
	@Override
	public String getClaByName(Cla cla) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Cla> claList = nameReClaDao.getClaByName(cla);
		for (Cla cla2 : claList) {

			if (cla2.getUuid() != null) {
				flag = "（有重名）" + cla.getName();

				return flag;
			}
		}
		flag = "（无重名）" + cla.getName();

		return flag;
	}

	@Override
	public String getClaByName1(Cla cla) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Cla> claList = nameReClaDao.getClaByName(cla);
		for (Cla cla2 : claList) {

			if (cla2.getUuid() != null) {
				flag = "yes";

				return flag;
			}
		}
		flag = "no";
		return flag;
	}
}
