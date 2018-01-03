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
import com.sdpk.model.BackResult_TodPaike;
import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.query.service.MyTodPaikeService;
import com.sdpk.query.service.impl.MyTodPaikeServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

public class MyTodPaikeController extends HttpServlet {
	private MyTodPaikeService myTodPaikeService = new MyTodPaikeServiceImpl();
	BackResult_TodPaike backResult = new BackResult_TodPaike("信息值,默认",
			"请求值,默认", 0, null);
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
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request); // 固定，基本不改
			PaikeRecord PaikeRecord = new PaikeRecord();
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str); // 固定，基本不改
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				PaikeRecord = t_map2bean.MapToPaiKeRecord(map); // (根据实体类改)
			} else {
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
			}

			qqiuChoice(qqiu, PaikeRecord);
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

	private void qqiuChoice(String qqiu, PaikeRecord PaikeRecord) {
		// TODO Auto-generated method stub
		boolean test = false;

		test = qqiu.equals("list");

		if (test) {
			List<PaikeRecordView> myTodPaikeList = myTodPaikeService
					.getTodPaike(PaikeRecord);

			backResult.setMessage("信息值,成功");
			backResult.setQingqiu("我的今日课程");
			backResult.setSumTodayPaike(myTodPaikeList.size());
			backResult.setData((ArrayList) myTodPaikeList);

		}

	}

}
