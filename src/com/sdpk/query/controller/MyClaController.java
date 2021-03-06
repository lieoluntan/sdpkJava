package com.sdpk.query.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdpk.model.BackResult;
import com.sdpk.model.Cla;
import com.sdpk.query.service.MyClaService;
import com.sdpk.query.service.impl.MyClaServiceImpl;
import com.sdpk.utility.M_msg;


/**
 * 
 * @author 罗成峰
 * @date 2018-1-2下午8:41:03
 * @version 1.0
 */
public class MyClaController extends HttpServlet{
	
	private MyClaService myClaService = new MyClaServiceImpl();
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	public M_msg m_msg = new M_msg();

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
			String empUuid = request.getParameter("empUuid");

			qqiuChoice(qqiu, empUuid);

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

	private void qqiuChoice(String qqiu, String empUuid) {
		// TODO Auto-generated method stub
		boolean test = false;

		test = qqiu.equals("list");

		if (test) {
		List<Cla> claList = myClaService.getClaId(empUuid);
			backResult.setMessage("信息值,成功");
			backResult.setQingqiu("我的班级浏览");
			backResult.setData((ArrayList) claList);
		}
	}
}
