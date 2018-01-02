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
import com.sdpk.model.BackResult_Query;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
import com.sdpk.query.service.QueryService;
import com.sdpk.query.service.impl.QueryServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-29 上午10:53:11 老师月课浏览控制器
 */
public class QueryController extends HttpServlet {
	QueryService queryService = new QueryServiceImpl();
	BackResult_Query backResult = new BackResult_Query("信息值,默认", "请求值,默认", 0,
			0, 0, null);
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
		PaikeSearch paikeSearch = new PaikeSearch();
		if (qqiu.equals("list")) {
			String empUuid = request.getParameter("empUuid");
			String MonthDay = request.getParameter("MonthDay");
			System.out.println(empUuid);
			System.out.println(MonthDay);
			paikeSearch.setUuid(empUuid);
			paikeSearch.setMonthDay(MonthDay);

			qqiuChoice(qqiu, paikeSearch);
			
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

	private void qqiuChoice(String qqiu, PaikeSearch paikeSearch) {
		// TODO Auto-generated method stub
		boolean test = false;

		test = qqiu.equals("list");

		if (test) {
			backResult.setMessage("信息值,成功");
			backResult.setQingqiu("list老师月课浏览");

			ArrayList newResultList = new ArrayList();
			ArrayList SumPaikeList = new ArrayList();

			ArrayList<PaikeRecordView> resultList = queryService
					.getAllPaike(paikeSearch);// 老师在本月的所有排课
			int SumEmpPaike = queryService.SumEmpPaike(paikeSearch);// 老师在本月的所有排课数量
			int SumDayBefore = queryService.SumDayBefore(paikeSearch);// 老师在本月到今天的所有排课总量
			int SumDayAfter = SumEmpPaike - SumDayBefore;// 老师这个月剩下的排课总量
			backResult.setSumEmpPaike(SumEmpPaike);
			backResult.setSumDayBefore(SumDayBefore);
			backResult.setSumDayAfter(SumDayAfter);
			newResultList.add(resultList);
			backResult.setData(newResultList);
		}

	}
}
