package com.sdpk.query.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdpk.model.BackResult;
import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.query.service.QueKeService;
import com.sdpk.query.service.QueryKeMyService;
import com.sdpk.query.service.impl.QueKeServiceImpl;
import com.sdpk.query.service.impl.QueryKeMyServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

public class QueKeController extends HttpServlet{

	private QueKeService quekeService = new QueKeServiceImpl();
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

		// 1 获取url问号后面的Query 参数
		String qqiu = request.getParameter("qqiu");
		if (qqiu.equals("list")) {
			// 2 将前台json数据字符串转成实体对象
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			PaikeRecord paikeRecord = new PaikeRecord();
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				paikeRecord = t_map2bean.MapToPaiKeRecord(map);
			} else {
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
			}

			// 3 执行qqiu里面的增或删或改或查 的操作
			qqiuChoice(qqiu, paikeRecord);
		} else {
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

	private void qqiuChoice(String qqiu, PaikeRecord paikeRecord) {
		// TODO Auto-generated method stub
		boolean list = false;

		list = qqiu.equals("list");

		if (list) {
			backResult.setMessage("信息值,测试成功");
			backResult.setQingqiu("我的今日课程");
			ArrayList<PaikeRecordView> resultList = quekeService.getAllpaike(paikeRecord);

			backResult.setData(resultList);
		}

	}
}
