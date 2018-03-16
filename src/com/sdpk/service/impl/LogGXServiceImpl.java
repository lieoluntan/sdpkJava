package com.sdpk.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.sdpk.dao.LogGXDao;
import com.sdpk.dao.impl.LogGXDaoImpl;
import com.sdpk.model.LogGX;
import com.sdpk.service.LogGXService;
import com.sdpk.utility.M_msg;

public class LogGXServiceImpl implements LogGXService{
	
	public LogGXDao lgd = new LogGXDaoImpl();
	public M_msg m_msg = new M_msg();
	Logger logger = Logger.getLogger(LogGXServiceImpl.class);

	@Override
	public String delete(LogGX log) {
		// TODO Auto-generated method stub
		if (log.getUuid() != null && log.getUuid() != "") {
	        boolean daoFlag = lgd.delete(log.getUuid());

	        if (daoFlag) {
	            return log.getUuid();
	        } else {
	            logger.error("删除不成功,service层执行有出错地方,请联系管理员");
	            return "删除不成功,service层执行有出错地方,请联系管理员";
	        }
	    } else {
	        String msg = "LoggxServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
	        System.out.println(msg);
	        return msg;
	    }
	}

	@Override
	public ArrayList<LogGX> getList() {
		// TODO Auto-generated method stub
		ArrayList<LogGX> yxstuList = lgd.getList();
	    return yxstuList;
	}

	@Override
	public String deleteBatch(String[] uuid) {
		// TODO Auto-generated method stub
		if (uuid != null) {
			boolean daoFlag = false;
	        for (int i = 0; i < uuid.length; i++) {
	        	daoFlag =  lgd.delete(uuid[i]);
			}
	        if (daoFlag) {
	            return "true";
	        } else {
	            logger.error("删除不成功,service层执行有出错地方,请联系管理员");
	            return "删除不成功,service层执行有出错地方,请联系管理员";
	        }
	    } else {
	        String msg = "LoggxServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
	        System.out.println(msg);
	        return msg;
	    }
	}

	/*@Override
	public String add(LogGX log) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public M_msg getMsg() {
		// TODO Auto-generated method stub
		return m_msg;
	}
	
}
