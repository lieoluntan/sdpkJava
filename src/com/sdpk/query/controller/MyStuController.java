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
import com.sdpk.model.Student;
import com.sdpk.query.service.MyStuService;
import com.sdpk.query.service.impl.MyStuServiceImpl;
import com.sdpk.utility.M_msg;

public class MyStuController extends HttpServlet {
	private MyStuService myStuService = new MyStuServiceImpl();
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
			List<Student> stuList=myStuService.getClaId(empUuid);
			
			backResult.setMessage("信息值,成功");
			backResult.setQingqiu("我的学员浏览");

			backResult.setData((ArrayList)stuList);
		}

	}
}
