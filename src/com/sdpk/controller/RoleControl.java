package com.sdpk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdpk.model.BackResult;
import com.sdpk.model.Role;
import com.sdpk.service.RoleService;
import com.sdpk.service.impl.RoleServiceImp;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/**
 * 
 * @author 罗成峰
 * @date 2017-12-26上午10:44:01
 * @version 1.0
 */
public class RoleControl extends HttpServlet{

	private Connection connection;
	  RoleService roleService = new RoleServiceImp();
	  BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	  
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    this.doPost(request, response);
	  }
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();

	    String qqiu = request.getParameter("qqiu");

	    if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")
	        || qqiu.equals("getOne")) {
	    
	      T_DataControl t_data = new T_DataControl();
	      String str = t_data.getRequestPayload(request);
	      Role role = new Role();
	      if (str != null && str != "" && str.length() != 0) {
	        Map<String, Object> map = t_data.JsonStrToMap(str);
	        T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
	     role= t_map2bean.MapToRome(map);
	      } else {
	        System.out.println("前台传入post请求体数据为空，请联系管理员！");
	      }

	     
	      qqiuChoice(qqiu, role);
	    } else if (qqiu.equals("list")) {
	     
	      ArrayList<Role> resultList =  roleService.getList();
	      backResult.setMessage("信息值：成功");
	      backResult.setQingqiu("list查询列表");
	      backResult.setData(resultList);

	    } else {
	      System.out.println("qqiu请求参数  " + qqiu + "  不规范");
	    }

	    Gson gson = new Gson();
	    String back = gson.toJson(backResult);
	    System.out.println("最后back值是：" + back);
	    out.write(back);
	    out.flush();
	    out.close();
}
	  
	  private void qqiuChoice(String qqiu, Role role) {
	    boolean test = false;
	    boolean add = false;
	    boolean delete = false;
	    boolean edit = false;
	    boolean getOne = false;
	    
	    test = qqiu.equals("test");
	    add = qqiu.equals("add");
	    delete = qqiu.equals("delete");
	    edit = qqiu.equals("edit");
	    getOne = qqiu.equals("getOne");

	    if (test) {
	      backResult.setMessage("信息值,测试成功");
	      backResult.setQingqiu("test新增");
	      ArrayList<String> resultList = new ArrayList<String>();
	      resultList.add("内容值,测试成功1");
	      resultList.add("内容值,测试成功2");
	      resultList.add("内容值,测试成功3");
	      backResult.setData(resultList);
	    }
	    if (add) {
	      String result = roleService.insert(role);
	      ArrayList<String> resultList = new ArrayList<String>();
	      resultList.add(result);
	      backResult.setMessage("信息值：成功");
	      backResult.setQingqiu("add新增");
	      backResult.setData(resultList);
	    }
	    if (delete) {
	      String result = roleService.delete(role.getUuid());
	      ArrayList<String> resultList = new ArrayList<String>();
	      resultList.add(result);
	      backResult.setMessage("信息值：成功");
	      backResult.setQingqiu("delete删除" + role.getUuid());
	      backResult.setData(resultList);
	    }
	    if (edit) {
	      String result = roleService.update(role);
	      ArrayList<String> resultList = new ArrayList<String>();
	      resultList.add(result);
	      backResult.setMessage("信息值：成功");
	      backResult.setQingqiu("edit修改");
	      backResult.setData(resultList);
	    }
	    if(getOne){
	      Role result = roleService.getByUuid(role.getUuid());
	      ArrayList<Role> resultList = new ArrayList<Role>();
	      resultList.add(result);
	      backResult.setMessage("信息值：成功");
	      backResult.setQingqiu("getOne查询单条记录");
	      backResult.setData(resultList);
	    }
	 }
}

