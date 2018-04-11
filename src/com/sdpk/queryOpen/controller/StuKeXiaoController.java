package com.sdpk.queryOpen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdpk.model.BackResult_Query;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
import com.sdpk.query.service.QueryStuService;
import com.sdpk.query.service.impl.QueryStuServiceImpl;
import com.sdpk.queryOpen.service.StuKeXiaoService;
import com.sdpk.queryOpen.service.impl.StuKeXiaoServiceImpl;
import com.sdpk.utility.M_msg;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public class StuKeXiaoController extends HttpServlet{
	StuKeXiaoService queryStuService = new StuKeXiaoServiceImpl();
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
			String stuUuid = request.getParameter("stuUuid");
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String today = request.getParameter("today");

			paikeSearch.setStuUuid(stuUuid);
			paikeSearch.setYear(year);
			paikeSearch.setMonth(month);
			paikeSearch.setToday(today);

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
		boolean stuUuid=paikeSearch.getStuUuid().equals("allGet");
		test = qqiu.equals("list");

		if (test&&!stuUuid) {
			backResult.setMessage("信息值,成功");
			backResult.setQingqiu("学生月课查询");

			ArrayList newResultList = new ArrayList();

			ArrayList<PaikeRecordView> resultList = queryStuService
					.getAllPaike(paikeSearch);// 老师在本月的所有排课
			int sumMonth = 0;
			int keLong = 0;
			for (int i = 0; i < resultList.size(); i++) {
				keLong = Integer.parseInt(resultList.get(i).getKeLongTime());
				sumMonth += keLong;
			}
			int SumEmpPaike = resultList.size();// 老师在本月的所有排课数量
			int SumDayBefore = queryStuService.SumDayBefore(paikeSearch).size();// 老师在本月到今天的所有排课总量
			int EndMonth = 0;
			int EndLong = 0;
			int size =  queryStuService.SumDayBefore(paikeSearch).size();
			for (int i = 0; i <size  ; i++) {
				EndLong = Integer.parseInt(queryStuService.SumDayBefore(paikeSearch).get(i).getKeLongTime());
				EndMonth += EndLong;
			}
			int SumDayAfter = SumEmpPaike - SumDayBefore;// 老师这个月剩下的排课总量
			int LastMonth = 0;
			int LastLong= 0;
			int size1 = queryStuService.SumDayBeforeDan(paikeSearch).size();
			for (int i = 0; i < size1; i++) {
				LastLong = Integer.parseInt(queryStuService.SumDayBeforeDan(paikeSearch).get(i).getKeLongTime());
				LastMonth += LastLong;
			}
			float sumM = (float)sumMonth/60;
			int   scale  =   2;//设置位数  
			int   roundingMode  =  4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.  
			BigDecimal   bd  =   new  BigDecimal((double)sumM);  
			bd   =  bd.setScale(scale,roundingMode);
			sumM   =  bd.floatValue(); 
			float sumM1 = (float)EndMonth/60;
			int   scale1 =   2;//设置位数  
			int   roundingMode1  =  4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.  
			BigDecimal   bd1  =   new  BigDecimal((double)sumM1);  
			bd1  =  bd1.setScale(scale1,roundingMode1);
			sumM1  =  bd1.floatValue();
			float sumM2 = (float)LastMonth/60;
			int   scale2  =   2;//设置位数  
			int   roundingMode2  =  4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.  
			BigDecimal   bd2  =   new  BigDecimal((double)sumM2);  
			bd2   =  bd2.setScale(scale2,roundingMode2);
			sumM2   =  bd2.floatValue();
			backResult.setMonthSumHourFloat(sumM);
			backResult.setEndSumHourFloat(sumM1);
			backResult.setLastSumHourFloat(sumM2);
			backResult.setMonthSumHour(sumMonth);
			backResult.setSumEmpPaike(SumEmpPaike);
			backResult.setSumDayBefore(SumDayBefore);
			backResult.setSumDayAfter(SumDayAfter);
			backResult.setEndSumHour(EndMonth);
			backResult.setLastSumHour(LastMonth);
			newResultList.add(resultList);
			backResult.setData(newResultList);
		}
		if (test&&stuUuid) {
			System.out.println("进入");
			backResult.setMessage("信息值,成功");
			backResult.setQingqiu("所有学生月课查询");

			ArrayList newResultList = new ArrayList();

			ArrayList<PaikeRecordView> resultList = queryStuService
					.getAllPaike1(paikeSearch);// 老师在本月的所有排课
			int sumMonth = 0;
			int keLong = 0;
			for (int i = 0; i < resultList.size(); i++) {
				keLong = Integer.parseInt(resultList.get(i).getKeLongTime());
				sumMonth += keLong;
			}
			int SumEmpPaike = resultList.size();// 老师在本月的所有排课数量
			int SumDayBefore = queryStuService.SumDayBefore1(paikeSearch).size();// 老师在本月到今天的所有排课总量
			int EndMonth = 0;
			int EndLong = 0;
			for (int i = 0; i <  queryStuService.SumDayBefore1(paikeSearch).size(); i++) {
				EndLong = Integer.parseInt(queryStuService.SumDayBefore1(paikeSearch).get(i).getKeLongTime());
				EndMonth += EndLong;
			}
			int LastMonth = 0;
			int LastLong= 0;
			for (int i = 0; i < queryStuService.SumDayBefore2(paikeSearch).size(); i++) {
				LastLong = Integer.parseInt(queryStuService.SumDayBefore2(paikeSearch).get(i).getKeLongTime());
				LastMonth += LastLong;
			}
			int SumDayAfter = SumEmpPaike - SumDayBefore;// 老师这个月剩下的排课总量
			float sumM = (float)sumMonth/60;
			int   scale  =   2;//设置位数  
			int   roundingMode  =  4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.  
			BigDecimal   bd  =   new  BigDecimal((double)sumM);  
			bd   =  bd.setScale(scale,roundingMode);
			sumM   =  bd.floatValue(); 
			float sumM1 = (float)EndMonth/60;
			int   scale1 =   2;//设置位数  
			int   roundingMode1  =  4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.  
			BigDecimal   bd1  =   new  BigDecimal((double)sumM1);  
			bd1  =  bd1.setScale(scale1,roundingMode1);
			sumM1  =  bd1.floatValue();
			float sumM2 = (float)LastMonth/60;
			int   scale2  =   2;//设置位数  
			int   roundingMode2  =  4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.  
			BigDecimal   bd2  =   new  BigDecimal((double)sumM2);  
			bd2   =  bd2.setScale(scale2,roundingMode2);
			sumM2   =  bd2.floatValue();
			backResult.setMonthSumHourFloat(sumM);
			backResult.setEndSumHourFloat(sumM1);
			backResult.setLastSumHourFloat(sumM2);
			backResult.setMonthSumHour(sumMonth);
			backResult.setSumEmpPaike(SumEmpPaike);
			backResult.setSumDayBefore(SumDayBefore);
			backResult.setSumDayAfter(SumDayAfter);
			backResult.setEndSumHour(EndMonth);
			backResult.setLastSumHour(LastMonth);
			newResultList.add(resultList);
			backResult.setData(newResultList);
		}
	}
}
