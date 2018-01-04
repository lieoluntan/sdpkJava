package com.sdpk.query.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.sdpk.model.BackResult;
import com.sdpk.model.Contract;

import com.sdpk.query.service.ContractNewService;
import com.sdpk.query.service.impl.ContractNewServiceImpl;


public class ContractNewController extends HttpServlet{
	ContractNewService contractNewService = new ContractNewServiceImpl();
	
	BackResult backResult = new BackResult("信息值,默认 ", "请求值,默认", null);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String qqiu = request.getParameter("qqiu");
		if (qqiu.equals("list")) {
			ArrayList<Contract> contractList = contractNewService.getList();
			backResult.setMessage("信息值:成功");
			backResult.setQingqiu("list查询列表");
			backResult.setData(contractList);
		}else{
			System.out.println("qqiu请求参数  " + qqiu + "  不规范");
		}
		Gson gson = new Gson();
		// 4 执行完qqiuChoice里面操作后的全局返回值backResult对象,转成json格式
		String back = gson.toJson(backResult);
		System.out.println("最后back值是：" + back);
		// 5 将json格式的back传给前台
		out.write(back);
		out.flush();
		out.close();

	}
	

	private void qqiuChoice(String qqiu) {
		// TODO Auto-generated method stub
		boolean test = false;

		test = qqiu.equals("list");

		if (test) {
		List<Contract> contractList = contractNewService.getList();
			backResult.setMessage("信息值,成功");
			backResult.setQingqiu("我的班级浏览");
			backResult.setData((ArrayList) contractList);
		}
	}
}
