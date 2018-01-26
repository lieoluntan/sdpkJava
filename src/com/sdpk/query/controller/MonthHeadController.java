package com.sdpk.query.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdpk.model.BackResult;
import com.sdpk.model.BackResult_Query;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.query.service.MonthHeadService;
import com.sdpk.query.service.impl.MonthHeadServiceImpl;

/*
 * @author 刘鑫
 * @date 2018-1-25 13:07
 */
public class MonthHeadController extends HttpServlet{
	MonthHeadService mhs=new MonthHeadServiceImpl();
	BackResult backResult = new BackResult("信息值,默认 ", "请求值,默认", null);
	BackResult_Query brq=new BackResult_Query();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String qqiu = request.getParameter("qqiu");
		String claUuid=request.getParameter("empUuid");
		String keDateTime=request.getParameter("today");
		if(qqiu.equals("list")){
			ArrayList<PaikeRecordView> listPaike=mhs.queryMonthKeByClaUuid(claUuid, keDateTime);
			backResult.setMessage("信息值:成功");
			backResult.setQingqiu("list查询列表");
			backResult.setData(listPaike);
			brq.setMessage("信息值:成功");
			brq.setQingqiu("listKeDate查询列表班级排课记录");
			brq.setSumEmpPaike(listPaike.size());
			int before=0;
			int after=0;
			Date keDate=null;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 0; i < listPaike.size(); i++) {
				try {
					keDate=sdf.parse(listPaike.get(i).getKeDateTime());
					Date tday=sdf.parse(keDateTime);
					//System.out.println(tday+"==========日期");
					if(tday.getTime()>(keDate.getTime())){
						after=after+1;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			before=listPaike.size()-after;
			System.out.println(listPaike.size()+"==============list集合元素个数");
			System.out.println(before+"==============未上的课数");
			System.out.println(after+"==============已上的课数");
			brq.setSumDayBefore(after);
			brq.setSumDayAfter(before);
			brq.setData(listPaike);
		}else{
			System.out.println("qqiu请求参数  " + qqiu + "  不规范");
		}
		Gson gson = new Gson();
		// 4 执行完qqiuChoice里面操作后的全局返回值backResult对象,转成json格式
		String back = gson.toJson(brq);
		System.out.println("最后back值是：" + back);
		// 5 将json格式的back传给前台
		out.write(back);
		out.flush();
		out.close();
	}
}
