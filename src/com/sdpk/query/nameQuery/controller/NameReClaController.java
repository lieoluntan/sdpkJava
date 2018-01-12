package com.sdpk.query.nameQuery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdpk.model.BackResult;
import com.sdpk.model.Cla;
import com.sdpk.model.Contract;
import com.sdpk.query.nameQuery.service.NameReClaService;
import com.sdpk.query.nameQuery.service.NameReContrService;
import com.sdpk.query.nameQuery.service.impl.NameReClaServiceImpl;
import com.sdpk.query.nameQuery.service.impl.NameReContrServiceImpl;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/**
 * 
 * @author 罗成峰
 * @date 2018-1-5下午3:46:34
 * @version 1.0
 */
public class NameReClaController extends HttpServlet{
	private NameReClaService nameReClaService=new NameReClaServiceImpl();
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String qqiu = request.getParameter("qqiu");
		if (qqiu.equals("query")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			Cla cla=new Cla();
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				cla = t_map2bean.MapToCla(map);
			} else {
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
			}

			// 3 执行qqiu里面的增或删或改或查 的操作
			qqiuChoice(qqiu, cla);

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

	private void qqiuChoice(String qqiu, Cla cla) {
		// TODO Auto-generated method stub
		boolean test = false;

		test = qqiu.equals("query");

		if (test) {
			String flag = nameReClaService.getClaByName(cla);// 得到名字是否已存在
			String flag1 = nameReClaService.getClaByName1(cla);// 得到yes/no
			backResult.setMessage(flag);
			backResult.setQingqiu(flag1);

		}
	}
}
