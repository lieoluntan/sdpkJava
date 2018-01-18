package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sdpk.dao.And_ClassCourseDao;
import com.sdpk.dao.And_ClassEmpDao;
import com.sdpk.dao.And_ClassStuDao;
import com.sdpk.dao.ClaDao;
import com.sdpk.dao.Class_ContractDao;
import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.impl.And_ClassCourseDaoImpl;
import com.sdpk.dao.impl.And_ClassEmpDaoImpl;
import com.sdpk.dao.impl.And_ClassStuDaoImpl;
import com.sdpk.dao.impl.ClaDaoImpl;
import com.sdpk.dao.impl.Class_ContractDaoImpl;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.Cla;
import com.sdpk.model.Employee;
import com.sdpk.query.nameQuery.dao.NameReClaDao;
import com.sdpk.query.nameQuery.dao.impl.NameReClaDaoImpl;
import com.sdpk.service.ClaService;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午2:28:21
 * 类说明
 */

public class ClaServiceImpl implements ClaService{
  
  private ClaDao claDao= new ClaDaoImpl();
  private And_ClassEmpDao and_ClassEmpDao = new And_ClassEmpDaoImpl();
  private And_ClassStuDao and_ClassStuDao = new And_ClassStuDaoImpl();
  private And_ClassCourseDao and_ClassCourseDao = new And_ClassCourseDaoImpl();
  private Class_ContractDao class_ContractDao = new Class_ContractDaoImpl();
  private NameReClaDao nameReClaDao=new NameReClaDaoImpl();
  public M_msg m_msg = new M_msg();
  private EmployeeDao employeeDao = new EmployeeDaoImpl();
  
  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }

  @Override
  public String insert(Cla cla) {
    // TODO Auto-generated method stub
	  String flag = this.getClaByName1(cla);
	  if(flag.equals("yes")){
		  return flag;
	  }else{
		  
	  
	  cla.setUuid(null);

    cla.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在StudentServiceImpl收到数据 ："+cla.toString()+"收到结束!");
    boolean daoFlag = claDao.insert(cla);
    if(daoFlag)
    {
    return cla.getUuid();
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
      boolean daoFlag = claDao.delete(uuid);
      and_ClassStuDao.deleteBycla(uuid);
      and_ClassEmpDao.deleteBycla(uuid);
      and_ClassCourseDao.deleteBycla(uuid);
      class_ContractDao.deleteBycla(uuid);
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="ClaServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String update(Cla cla) {
    // TODO Auto-generated method stub
	  String flag = this.getClaByName1(cla);
	  if(flag.equals("yes")){
		  return flag;
	  }else{
	  
	
	 String uuid = cla.getUuid();
    if(uuid!=null&&uuid!="")
    {
      
        boolean daoFlag = claDao.update(cla);
        
        if(daoFlag)
        {
        return uuid;
        }else{
          return "修改不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="ClaServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
         }
	  }
}//end method update

  @Override
  public Cla getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      Cla cla = claDao.getByUuid(uuid);
      And_ClassEmp and_ClassEmp = and_ClassEmpDao.getBycla(uuid);
      Employee emp = employeeDao.getByUuid(and_ClassEmp.getEmpUuid());
      String claTeaName = emp.getName();
      if (claTeaName != null && claTeaName != "" && claTeaName.length() != 0) {
        cla.setEmpName(claTeaName);
      }else{
        String msg = "没有查到班主任名称，检查关联班级和班主任";
        m_msg.setGetOneMsg(msg);
      }
      
      
    return cla;
    }else{
      System.out.println("ClaServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      Cla claX= new Cla();
    return claX;
    }
  }//end method getByUuid

  @Override
  public ArrayList<Cla> getList() {
    // TODO Auto-generated method stub
    ArrayList<Cla> clalist = claDao.getList();

    return clalist;
  }//end method getList()

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
			//编辑验证重名要过滤掉自己本身的名字
			String s2Uuid = cla2.getUuid();
			boolean flagSelf = s2Uuid.equals(cla.getUuid());
			boolean flagNotSelf = !flagSelf;
			if(flagNotSelf){//编辑验证重名要过滤

			if (cla2.getUuid() != null) {
				flag = "yes";

				return flag;
			}
		  }//end if(flagNotSelf)
		}
		flag = "no";
		return flag;
	}

	@Override
	public String getonoff(Cla cla) {
		// TODO Auto-generated method stub
		String uuid = cla.getUuid();
		if(uuid!=null&&uuid!="")
	    {
		  String oAc = cla.getOpenAndclose();
	      boolean daoFlag = claDao.updateOnOff(uuid,oAc);
	      
	        if(daoFlag)
	        {
	        return "操作成功";
	        }else{
	          return "操作失败,dao层执行有出错地方,请联系管理员";
	        }
	    }else{
	      String msg="ClassRoomServiceImpl getonoff方法中的uuid为空，或格式不正确，请重新选择";
	      System.out.println(msg);
	      return msg;
	    }
	}//end method
}//end class ClaServiceImpl
