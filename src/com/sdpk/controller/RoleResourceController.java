package com.sdpk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdpk.service.RoleResourceService;
import com.sdpk.service.impl.RoleResourceServiceImpl;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-27 上午11:46:24 角色资源控制器
 */
public class RoleResourceController extends HttpServlet {
	private RoleResourceService roleResourceService = new RoleResourceServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String qqiu = request.getParameter("qqiu");
		if (qqiu.equals("test"))
			
		{
			System.out.println("进入");
			List<Object> list = new ArrayList<Object>();
			list.add("测试1");
			list.add("测试2");

			PrintWriter out = response.getWriter();

			Gson gson = new Gson();

			String back = gson.toJson(list);
			System.out.println(back);
			out.write(back);
			out.flush();
			out.close();

		}

	}

}
