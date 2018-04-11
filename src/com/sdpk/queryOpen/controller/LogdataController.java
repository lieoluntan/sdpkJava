package com.sdpk.queryOpen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sdpk.controller.ClaControl;
import com.sdpk.model.BackResult;
import com.sdpk.model.Cla;
import com.sdpk.queryOpen.service.ClaNameService;
import com.sdpk.queryOpen.service.impl.ClaNameServiceImpl;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

public class LogdataController {
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	  Logger logger = Logger.getLogger(ClaControl.class);
	 // private ClaNameService cns = new ClaNameServiceImpl();
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {

		    this.doPost(request, response);
		  }// end doGet

		  protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    // TODO doPost
		    response.setContentType("text/html;charset=utf-8");
		    PrintWriter out = response.getWriter();

		    // 1 获取url问号后面的Query 参数
		    String qqiu = request.getParameter("qqiu");

		    if (qqiu.equals("test")) {
		      // 2 将前台json数据字符串转成实体对象
		      T_DataControl t_data = new T_DataControl();
		      String str = t_data.getRequestPayload(request);
		      Cla cla = new Cla();
		      if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
		        Map<String, Object> map = t_data.JsonStrToMap(str);
		        T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
		        cla = t_map2bean.MapToCla(map);
		      } else {
		        System.out.println("前台传入post请求体数据为空，请联系管理员！");
		      }

		      // 3 执行qqiu里面的增或删或改或查 的操作
		      qqiuChoice(qqiu, cla);
		    } else if (qqiu.equals("list")) {
		      // TODO 待完成
		      /*//ArrayList<Cla> resultList = cns.getList();
		      backResult.setMessage("信息值：成功");
		      backResult.setQingqiu("list查询列表");
		      backResult.setData(resultList);*/

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

		  }// end method doPost 主入口

		  private void qqiuChoice(String qqiu, Cla cla) {
		    // TODO Auto-generated method stub
		    boolean test = false;

		    test = qqiu.equals("test");

		    if (test) {
		      logger.error("test,log4j日志测试成功,ClaControl");
		      backResult.setMessage("信息值,测试成功");
		      backResult.setQingqiu("test新增");
		      ArrayList<String> resultList = new ArrayList<String>();
		      resultList.add("内容值,测试成功1");
		      resultList.add("内容值,测试成功2");
		      resultList.add("内容值,测试成功3");
		      backResult.setData(resultList);
		    }
		  }// end method qqiuChoice
}
