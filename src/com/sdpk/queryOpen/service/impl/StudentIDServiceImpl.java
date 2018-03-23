package com.sdpk.queryOpen.service.impl;


import org.apache.log4j.Logger;

import com.sdpk.model.Student;
import com.sdpk.queryOpen.dao.StudentIDDao;
import com.sdpk.queryOpen.dao.impl.StudentIDDaoImpl;
import com.sdpk.queryOpen.service.StudentIDService;
import com.sdpk.utility.M_msg;

/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public class StudentIDServiceImpl implements StudentIDService{
	private StudentIDDao stuIDDao = new StudentIDDaoImpl();
	public M_msg m_msg = new M_msg();
	Logger logger = Logger.getLogger(StudentIDServiceImpl.class);
	
	@Override
	public M_msg getMsg() {
	   // TODO Auto-generated method stub
	   return m_msg;
	}
	
	@Override
	public int findMaxIdShow() {
		// TODO Auto-generated method stub
		 int stuList = stuIDDao.findMaxIdShow();
		 m_msg.setAddMsg("查询成功了,最大学号为"+stuIDDao.findMaxIdShow()+"");
		 return stuList;
	}

	@Override
	public String updateStuId(String StuId, String uuid,String name) {
		// TODO Auto-generated method stub
		Student stu = stuIDDao.findId(StuId);
		  if(StuId.equals(stu.getStudentID())){
			  System.out.println("有重复学生ID，请重新添加，最大学号为"+stuIDDao.findMaxIdShow()+"");
			  logger.error("有重复学生ID，请重新添加，最大学号为"+stuIDDao.findMaxIdShow()+"");
		      m_msg.setEditMsg("有重复学生ID，请重新添加，最大学号为"+stuIDDao.findMaxIdShow()+"");
			 return "有重复学生ID，请重新添加，最大学号为"+stuIDDao.findMaxIdShow()+""; 
		  }
		  if (uuid != null && uuid != "") {
		        boolean daoFlag = stuIDDao.updateStuId(StuId, uuid,name);

		        if (daoFlag) {
		            return uuid;
		        } else {
		            logger.error("修改不成功,dao层执行有出错地方,请联系管理员");
		            m_msg.setAddMsg("修改不成功,dao层执行有出错地方,请联系管理员YXstudentServiceImpl");
		            return "修改不成功,dao层执行有出错地方,请联系管理员";
		        }
		    } else {
		        String msg = "YXstudentServiceImpl updateStuId方法中的uuid为空，或格式不正确，请重新选择";
		        System.out.println(msg);
		        return msg;
		    }
	}

}
