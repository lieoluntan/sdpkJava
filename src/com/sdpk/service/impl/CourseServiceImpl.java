package com.sdpk.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sdpk.dao.CourseDao;
import com.sdpk.dao.Course_EmpDao;
import com.sdpk.dao.impl.CourseDaoImpl;
import com.sdpk.dao.impl.Course_EmpDaoImpl;
import com.sdpk.model.Course;
import com.sdpk.query.nameQuery.dao.NameReCourDao;
import com.sdpk.query.nameQuery.dao.impl.NameReCourDaoImpl;
import com.sdpk.service.CourseService;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-15 下午3:51:46
 * 类说明
 */

public class CourseServiceImpl implements CourseService{
  private NameReCourDao nameReCourDao=new NameReCourDaoImpl();
  private CourseDao courseDao= new CourseDaoImpl();
  private Course_EmpDao course_EmpDao=new Course_EmpDaoImpl();
  @Override
  public String insert(Course course) {
    // TODO Auto-generated method stub
    String flag = this.getCourByName1(course);
    if(flag.equals("yes")){
    	return flag;
    }else{
    	
    
	course.setUuid(null);

    course.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在CourseDaoImpl收到数据 ："+course.toString()+"收到结束!");
    boolean daoFlag = courseDao.insert(course);
    if(daoFlag)
    {
    return course.getUuid();
    }else{
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    	}
    }
 }//end method insert

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = courseDao.delete(uuid);
      course_EmpDao.deleteByCour(uuid);
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,CourseDaoImpl层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="CourseDaoImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String update(Course course) {
    // TODO Auto-generated method stub
	  String flag = this.getCourByName1(course);
	    if(flag.equals("yes")){
	    	return flag;
	    }else{
	 String uuid = course.getUuid();
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = courseDao.update(course);
      
      if(daoFlag)
      {
      return uuid;
      }else{
        return "修改不成功,dao层执行有出错地方,请联系管理员";
      }
    }else{
      String msg="CourseServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员";
      System.out.println(msg);
      return msg;
    	}
	}
 }//end method update

  @Override
  public ArrayList<Course> getListCourse() {
    // TODO Auto-generated method stub
    
    ArrayList<Course> courselist = courseDao.getListCourse();
    
    return courselist;
  }//end method getListCourse

  @Override
  public Course getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      Course course = courseDao.getByUuid(uuid);
    return course;
    }else{
      System.out.println("CourseServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      Course courseX= new Course();
    return courseX;
    }
  }//end method getByUuid

	@Override
	public String getCourByName(Course cour) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Course> courList = nameReCourDao.getCourByName(cour);
		for (Course cour2 : courList) {

			if (cour2.getUuid() != null) {
				flag = "（有重名）" + cour.getName();

				return flag;
			}

		}
		flag = "（无重名）" + cour.getName();

		return flag;
	}

	@Override
	public String getCourByName1(Course cour) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Course> courList = nameReCourDao.getCourByName(cour);
		for (Course cour2 : courList) {
			//编辑验证重名要过滤掉自己本身的名字
			String s2Uuid = cour2.getUuid();
			boolean flagSelf = s2Uuid.equals(cour.getUuid());
			boolean flagNotSelf = !flagSelf;
			if(flagNotSelf){//编辑验证重名要过滤

			if (cour2.getUuid() != null) {
				flag = "yes";

				return flag;
			}
		 }//end if(flagNotSelf)
		}
		flag = "no";
		return flag;
	}

	@Override
	public String getonoff(Course course) {
		// TODO Auto-generated method stub
		String uuid = course.getUuid();
		if(uuid!=null&&uuid!="")
	    {
		  String oAc = course.getOpenAndclose();
	      boolean daoFlag = courseDao.updateOnOff(uuid,oAc);
	      
	        if(daoFlag)
	        {
	        return "操作成功";
	        }else{
	          return "操作失败,dao层执行有出错地方,请联系管理员";
	        }
	    }else{
	      String msg="ClassRoomServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
	      System.out.println(msg);
	      return msg;
	    }
	}//end method


}//end class CourseServiceImpl
