package com.sdpk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdpk.model.BackResult;
import com.sdpk.service.ConPriceService;
import com.sdpk.service.impl.ConPriceServiceImpl;

public class ConPriceController extends HttpServlet {
	private ConPriceService conPriceService = new ConPriceServiceImpl();
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html;charset=utf-8");
		    PrintWriter out = response.getWriter();

		    // 1 获取url问号后面的Query 参数
		    String qqiu = request.getParameter("qqiu");
	}

}
