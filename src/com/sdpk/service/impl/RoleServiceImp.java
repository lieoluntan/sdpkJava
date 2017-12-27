package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.RoleDao;
import com.sdpk.dao.impl.RoleDaoImpl;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Role;
import com.sdpk.service.RoleService;
/**
 * 
 * @author 罗成峰
 * @date 2017-12-27上午11:07:07
 * @version 1.0
 */
public class RoleServiceImp implements RoleService{
	
	private RoleDao roledao = new RoleDaoImpl();
		
	@Override
	public String insert(Role Role) {
		// TODO Auto-generated method stub
		Role.setUuid(null);
		Role.setUuid(UUID.randomUUID().toString());
		System.out.println("^^在RoleServiceImle收到数据:"+Role.toString()+"收到结束!");
		boolean daoFlag = roledao.insert(Role);
	    if(daoFlag)
	    {
	    return Role.getUuid();
	    }else{
	      return "插入不成功,dao层执行有出错地方,请联系管理员";
	    }
	}

	@Override
	public String delete(String uuid) {
		 // TODO Auto-generated method stub
	    if(uuid!=null&&uuid!="")
	    {
	      boolean dao = roledao.delete(uuid);
	      
	        if(dao)
	        {
	        return uuid;
	        }else{
	          return "删除不成功,dao层执行有出错地方,请联系管理员";
	        }
	    }else{
	      String msg="RoleServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
	      System.out.println(msg);
	      return msg;
	    }
	}

	@Override
	public String update(Role Role) {
		  String uuid = Role.getUuid();
		    if(uuid!=null&&uuid!="")
		    {
		    	boolean daoFlag = roledao.update(Role);
		        if(daoFlag)
		        {
		        return uuid;
		        }else{
		          return "修改不成功,dao层执行有出错地方,请联系管理员";
		        }
		    }else{
		      String msg="RoleServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
		      System.out.println(msg);
		      return msg;
		    }
	}

	@Override
	public Role getByUuid(String uuid) {
		  if(uuid!=null&&uuid!="")
		    {
		      Role role = roledao.getByUuid(uuid);
		    return role;
		    }else{
		      System.out.println("ContractServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
		      Role roleX= new Role();
		    return roleX;
		    }
	}

	@Override
	public ArrayList<Role> getList() {
		 ArrayList<Role> Rolelist = roledao.getList();
		 return Rolelist;
	}
}
