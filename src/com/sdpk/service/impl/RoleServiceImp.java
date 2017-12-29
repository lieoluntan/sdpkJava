package com.sdpk.service.impl;

<<<<<<< HEAD
=======

>>>>>>> e2025669306163d0c4cd61e1b51dec17e4429f4b
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sdpk.dao.RoleDao;
import com.sdpk.dao.RoleResourceDao;
import com.sdpk.dao.impl.RoleDaoImpl;
import com.sdpk.dao.impl.RoleResourceDaoImpl;
<<<<<<< HEAD
=======


>>>>>>> e2025669306163d0c4cd61e1b51dec17e4429f4b
import com.sdpk.model.Role;
import com.sdpk.model.RoleResource;
import com.sdpk.service.RoleResourceService;
import com.sdpk.service.RoleService;
/**
 * 
 * @author 罗成峰
 * @date 2017-12-27上午11:07:07
 * @version 1.0
 */
public class RoleServiceImp implements RoleService{
	
	private RoleDao roledao = new RoleDaoImpl();
	private RoleResourceDao roleResourceDao = new RoleResourceDaoImpl();
	private RoleResourceService roleResourceService = new RoleResourceServiceImpl();
		
	@Override
	public String insert(Role role) {
		// TODO Auto-generated method stub
		role.setUuid(null);
		role.setUuid(UUID.randomUUID().toString());
		System.out.println("^^在RoleServiceImle收到数据:"+role.toString()+"收到结束!");
		boolean daoFlag = roledao.insert(role);
	    if(daoFlag)
	    {
	    	List<String> rsListNew = role.getRsList(); 
	    	for(String str:rsListNew){
	    		RoleResource roleResource = new RoleResource();
		    	roleResource.setRoleid(role.getUuid());
		    	roleResource.setResourceid(str);
		    	roleResourceService.insert(roleResource);
	    	}
	    	
	    return role.getUuid();
	    }else{
	      return "插入角色失败";
	    }
	}

	@Override
	public String delete(String uuid) {
		 // TODO Auto-generated method stub
	    if(uuid!=null&&uuid!="")
	    {
	      boolean dao = roledao.delete(uuid);
	      roleResourceDao.delete(uuid);
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
	public String update(Role role) {
		  boolean daoFlag = false;
		String uuid = role.getUuid();
		    if(uuid!=null&&uuid!="")
		    {
		    	if(role.getRsList()== null){
		    		daoFlag = roledao.update(role);
		    	}else{
		    		daoFlag = roledao.update(role);//对用户修改
		    		roledao.delete(role.getUuid());//删除角色资源表中记录
		    		roledao.insert(role);
		    	}
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
		      System.out.println("RoleServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
		      Role roleX= new Role();
		    return roleX;
		    }
	}

	@Override
	public ArrayList<Role> getList() {
		 ArrayList<Role> Rolelist = roledao.getList();
		 return Rolelist;
	}

	@Override
	public String insert_batch(ArrayList<Role> pr_List) {
		//步骤二，执行无冲突插入操作
	    int count = 0;
	    for (Role one : pr_List) {
	      try{
	    	one.setUuid(null);
	    	one.setUuid(UUID.randomUUID().toString());
	    	boolean daoFlag = roledao.insert(one);
	    	if(daoFlag){
	    		System.out.println(one.getName()+"插入成功");
	    		count++;
	    	}else{
	    		System.out.println(one.getName()+"已存在重复名字");
	    	}
	      }catch(Exception e){
	    	  System.out.println("insert_batch查询冲突有错误");
	      }
	   }
	    String recount = String.valueOf(count);
	    return recount;
	  }

	@Override
	public List<String> getRole(String uuid) {
		// TODO Auto-generated method stub
		return roledao.getRole(uuid);
	}
}
