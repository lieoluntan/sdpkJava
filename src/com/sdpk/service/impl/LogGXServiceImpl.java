package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.sdpk.dao.LogGXDao;
import com.sdpk.dao.impl.LogGXDaoImpl;
import com.sdpk.model.LogGX;
import com.sdpk.service.LogGXService;
import com.sdpk.utility.M_msg;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
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
	public String deleteBatch(List<String> uuid) {
		// TODO Auto-generated method stub
		if (uuid != null) {
			boolean daoFlag = false;
	        for (int i = 0; i < uuid.size(); i++) {
	        	daoFlag =  lgd.delete(uuid.get(i));
			}
	        if (daoFlag) {
	            return uuid.get(0);
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

	@Override
	public String insert(LogGX log) {
		// TODO Auto-generated method stub
		log.setUuid(UUID.randomUUID().toString());
		if (log.getUuid() != null && log.getUuid() != "") {
	        System.out.println("^^在LogGXServiceImpl收到数据 ：" + log.toString()
	                + "收到结束!");
	        boolean daoFlag = lgd.insert(log);
	        if (daoFlag) {
	            return log.getUuid();
	        } else {
	            logger.error("插入不成功,service层执行有出错地方,请联系管理员");
	            m_msg.setAddMsg("插入不成功,service层执行有出错地方,请联系管理员LogstuServiceImpl");
	            return "插入不成功,service层执行有出错地方,请联系管理员";
	        }
	    } else {
	        m_msg.setAddMsg("该意向学员不存在");
	        return "该意向学员不存在";
	    }
	}
	
}
