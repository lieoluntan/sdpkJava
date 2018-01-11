package com.sdpk.query.nameQuery.service.impl;

import java.util.List;

import com.sdpk.model.Contract;
import com.sdpk.model.Contrtext;
import com.sdpk.query.nameQuery.dao.NameReContrDao;
import com.sdpk.query.nameQuery.dao.impl.NameReContrDaoImpl;
import com.sdpk.query.nameQuery.service.NameReContrService;
/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午5:25:44
 *
 */
public class NameReContrServiceImpl implements NameReContrService {
private NameReContrDao nameReContrDao=new NameReContrDaoImpl();
//@SuppressWarnings("unused")
//@Override
//public String getStuByName(Contrtext contract) {
//	// TODO Auto-generated method stub
//	String flag = "";
//
//	List<Contrtext> conList = nameReContrDao.getStuByName(contract);
//	for (Contrtext student2 : conList) {
//
//		if (student2.getUuid() != null) {
//			flag = "（有重名）" + contract.getcNum();
//
//			return flag;
//		}
//
//	}
//	flag = "（无重名）" + contract.getcNum();
//
//	return flag;
//}
//
//@Override
//public String getStuByName1(Contrtext contract) {
//	// TODO Auto-generated method stub
//	String flag = "";
//
//	List<Contrtext> conList = nameReContrDao.getStuByName(contract);
//	for (Contrtext student2 : conList) {
//
//		if (student2.getUuid() != null) {
//			flag = "yes";
//
//			return flag;
//		}
//
//	}
//	flag = "no";
//
//	return flag;
//}
//

@Override
public String getStuByName(Contrtext contract) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getStuByName1(Contrtext contract) {
	// TODO Auto-generated method stub
	return null;
}

	
}
