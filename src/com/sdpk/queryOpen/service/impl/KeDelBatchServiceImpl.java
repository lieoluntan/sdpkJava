package com.sdpk.queryOpen.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.sdpk.queryOpen.dao.KeDelBatchDao;
import com.sdpk.queryOpen.dao.impl.KeDelBatchDaoImpl;
import com.sdpk.queryOpen.service.KeDelBatchService;
import com.sdpk.service.impl.LogGXServiceImpl;
import com.sdpk.utility.M_msg;

public class KeDelBatchServiceImpl implements KeDelBatchService{
	public KeDelBatchDao kdbDao=new KeDelBatchDaoImpl();
	Logger logger = Logger.getLogger(LogGXServiceImpl.class);
	public M_msg m_msg = new M_msg();

	@Override
	public String deleteBatch(List<String> uuidList) {
		// TODO Auto-generated method stub
		int i=0;
		boolean daoFlag=false;//false
		if (uuidList != null && uuidList.size() >0) {
			for(String uuid:uuidList){
				daoFlag=kdbDao.deleteBatch(uuid);
				i=i+1;
				if(daoFlag==false){
					break;
				}
			}
			if (daoFlag) {
				return "删除成功，批量删除了"+i+"条";
			} else {
				logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
				return "删除失败！";
			}
		} else {
			String msg = "KeDelBatchService deleteBatch方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}

}
