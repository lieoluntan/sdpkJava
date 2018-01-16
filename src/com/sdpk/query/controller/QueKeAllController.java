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
import com.sdpk.query.service.QueKeAllService;
import com.sdpk.query.service.aaQueKeHeadService;
import com.sdpk.query.service.impl.QueKeAllServiceImpl;
import com.sdpk.query.service.impl.aaQueKeHeadServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/**
 * 
 * @author 谢平平
 * @date 2018-1-14上午11:51:55
 * @version 1.0
 */
public class QueKeAllController extends HttpServlet{
	
	QueKeAllService queKeAllService = new QueKeAllServiceImpl();
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

	}//end method 
	
	private void qqiuChoice(String qqiu, PaikeRecord paikeRecord) {
		// TODO Auto-generated method stub
		boolean list = false;

		list = qqiu.equals("list");

		if (list) {
			backResult.setMessage("信息值,全校周课查询成功");
			backResult.setQingqiu("全校周课list");
			ArrayList<PaikeRecordView> resultList = queKeAllService.getAllpaike(paikeRecord);

			backResult.setData(resultList);
		}
	}//end qqiuChoice

}//end class
