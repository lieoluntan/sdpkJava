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
import com.sdpk.model.Contract;
import com.sdpk.model.Contrtext;
import com.sdpk.query.service.MyContrtextService;
import com.sdpk.query.service.impl.MyContrtextServiceImpl;
import com.sdpk.utility.M_msg;

/**
 * 
 * @author xpp
 * @date 2018-1-24上午11:51:55
 * @version 1.0
 */
public class MyContrtextController extends HttpServlet {
	private MyContrtextService ctextService = new MyContrtextServiceImpl();
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
		if (qqiu.equals("list")||qqiu.equals("test")||qqiu.equals("speedList")) {
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
		boolean list = false;
		boolean speedList = false;

		test = qqiu.equals("test");
		list = qqiu.equals("list");
		speedList = qqiu.equals("speedList");
		
		if (test) {
		      backResult.setMessage("信息值,测试成功");
		      backResult.setQingqiu("test新增");
		      ArrayList<String> resultList = new ArrayList<String>();
		      resultList.add("内容值,测试成功1");
		      resultList.add("内容值,测试成功2");
		      resultList.add("内容值,测试成功3");
		      backResult.setData(resultList);
		    }

		if (list) {
			List<Contrtext> ctextListt = ctextService.getHeadList(empUuid);
			backResult.setMessage("信息值,成功");
			backResult.setQingqiu("我的合同浏览");
			backResult.setData((ArrayList) ctextListt);
		}
		
		if (speedList) {
          List<Contrtext> ctextList = ctextService.getAllSpeedList();
          backResult.setMessage("信息值,成功");
          backResult.setQingqiu("我的合同浏览");
          backResult.setData((ArrayList) ctextList);
      }

	}//end method qqiuChoice

}//end class
