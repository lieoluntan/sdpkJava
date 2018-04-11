package com.sdpk.queryOpen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.sdpk.model.Logdata;
import com.sdpk.queryOpen.dao.LogdataDao;
import com.sdpk.queryOpen.dao.impl.LogdataDaoImpl;
import com.sdpk.queryOpen.service.LogdataService;

public class LogdataServiceImpl implements LogdataService{

	private LogdataDao logQDDao = new LogdataDaoImpl();
	Logger logger = Logger.getLogger(LogdataServiceImpl.class);
	
	@Override
	public ArrayList<Logdata> getList() {
		ArrayList<Logdata> logQDList = logQDDao.getList();
		return logQDList;
	}// end method getList()

	@Override
	public String delete(String uuid) {
		if (uuid != null && uuid != "") {
			boolean daoFlag = logQDDao.delete(uuid);
			if (daoFlag) {
				return uuid;
			} else {
				logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "EmployeeServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}// end method delete

	@Override
	public String deleteBatch(List<String> uuidList) {
		// TODO Auto-generated method stub
		int i=0;
		boolean daoFlag=true;
		if (uuidList != null && uuidList.size() >0) {
			for(String uuid:uuidList){
				daoFlag=logQDDao.deleteBatch(uuid);
				i=i+1;
				if(daoFlag==false){
					break;
				}
			}
			if (i>0) {
				return "删除成功，批量删除了"+i+"条";
			} else {
				logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
				return "删除失败！";
			}
		} else {
			String msg = "LogQDService deleteBatch方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}

	@Override
	public String insert(Logdata log) {
		// TODO Auto-generated method stub
		log.setUuid(UUID.randomUUID().toString());
		boolean daoFlag = logQDDao.insert(log);
		if (daoFlag) {
			return log.getUuid();
		} else {
			logger.error("新增不成功,dao层执行有出错地方,请联系管理员");
			return "新增不成功,dao层执行有出错地方,请联系管理员";
		}
	}

}
