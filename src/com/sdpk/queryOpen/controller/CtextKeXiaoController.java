package com.sdpk.queryOpen.controller;

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
import com.sdpk.model.QueCountCtext;
import com.sdpk.query.service.QueCountCtextService;
import com.sdpk.query.service.impl.QueCountCtextServiceImpl;
import com.sdpk.queryOpen.service.CtextKeXiaoService;
import com.sdpk.queryOpen.service.impl.CtextKeXiaoServiceImpl;
import com.sdpk.utility.T_DataControl;

public class CtextKeXiaoController extends HttpServlet{
	CtextKeXiaoService qccs=new CtextKeXiaoServiceImpl();
	
	BackResult backResult = new BackResult("信息值,默认 ", "请求值,默认", null);
	
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
		//获取请求体参数
		T_DataControl t_data = new T_DataControl();
		String str = t_data.getRequestPayload(request);
		ArrayList<QueCountCtext> ctextList=new ArrayList<QueCountCtext>();
		ArrayList<ArrayList<QueCountCtext>> list=new ArrayList<ArrayList<QueCountCtext>>();
		
		
		//前台传来的uuid
		if(qqiu.equals("list") ){
			Map<String, Object> map = t_data.JsonStrToMap(str);
			ArrayList stuidList=(ArrayList) map.get("stuUuidList");
			
			
			if( stuidList!=null){
			for (int i = 0; i < stuidList.size(); i++) {
				System.out.println(stuidList.size()+"===================前台传来集合大小");
				System.out.println("前台传来的uuid=============="+stuidList.get(i));
				ctextList=qccs.queryCountCtext((String) stuidList.get(i));
				list.add(ctextList);
			  }
			
			}
			
			backResult.setMessage("信息值:成功");
			backResult.setQingqiu("list查询列表");
			backResult.setData(list);
		}
		else if(qqiu.equals("stuAll") ){
			
			ArrayList<String> allstuUuid = qccs.queryAllstuUuid();
			
			for (int i = 0; i < allstuUuid.size(); i++) {
				System.out.println(allstuUuid.size()+"===================前台传来集合大小");
				System.out.println("前台传来的uuid=============="+allstuUuid.get(i));
				ctextList=qccs.queryCountCtext((String) allstuUuid.get(i));
				list.add(ctextList);
			}
			
			backResult.setMessage("信息值:成功");
			backResult.setQingqiu("list查询列表");
			backResult.setData(list);
		}
		else{
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
}
