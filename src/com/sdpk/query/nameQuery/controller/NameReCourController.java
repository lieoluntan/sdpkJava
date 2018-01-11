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
import com.sdpk.model.Course;
import com.sdpk.query.nameQuery.service.NameReCourService;

import com.sdpk.query.nameQuery.service.impl.NameReCourServiceImpl;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;
/**
 * 
 * @author 罗成峰
 * @date 2018-1-11下午2:52:21
 * @version 1.0
 */
public class NameReCourController extends HttpServlet{
	private NameReCourService nameReCourService=new NameReCourServiceImpl();
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
			Course cour=new Course();
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				cour = t_map2bean.MapToCourse(map);
			} else {
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
			}

			// 3 执行qqiu里面的增或删或改或查 的操作
			qqiuChoice(qqiu, cour);

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

	private void qqiuChoice(String qqiu, Course cour) {
		// TODO Auto-generated method stub
		boolean test = false;

		test = qqiu.equals("query");

		if (test) {
			String flag = nameReCourService.getCourByName(cour);// 得到名字是否已存在
			String flag1 = nameReCourService.getCourByName1(cour);// 得到yes/no
			backResult.setMessage(flag);
			backResult.setQingqiu(flag1);
		}
	}
}
