package com.sdpk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sdpk.model.BackResult;
import com.sdpk.model.LogGX;
import com.sdpk.service.LogGXService;
import com.sdpk.service.impl.LogGXServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

public class LogGXController extends HttpServlet{
	LogGXService lgxs = new LogGXServiceImpl();
	BackResult backResult = new BackResult("信息值：默认","请求值：默认",null);
	  public M_msg m_msg = new M_msg();
	  Logger logger = Logger.getLogger(LogGXController.class);
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {

		    this.doPost(request, response);
		  }// end doGet
		  
		  protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    // TODO doPost
		    response.setContentType("text/html;charset=utf-8");
		    request.setCharacterEncoding("utf-8");
		    PrintWriter out = response.getWriter();

		    // 1 获取url问号后面的Query 参数
		    String qqiu = request.getParameter("qqiu");

		    if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")
		        || qqiu.equals("getOne")|| qqiu.equals("on_off") || qqiu.equals("editstuID")  || qqiu.equals("getMaxStuID")) {
		      // 2 将前台json数据字符串转成实体对象
		      T_DataControl t_data = new T_DataControl();
		      String str = t_data.getRequestPayload(request);
		      LogGX logstu = new LogGX();
		      if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
		        Map<String, Object> map = t_data.JsonStrToMap(str);
		        T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
		        logstu = t_map2bean.MapToLogGX(map);
		      } else {
		        System.out.println("前台传入post请求体数据为空，请联系管理员！");
		      }

		      // 3 执行qqiu里面的增或删或改或查 的操作
		      qqiuChoice(qqiu, logstu);
		    } else if (qqiu.equals("list")) {
		      // TODO 待完成
		    	 ArrayList<LogGX> resultList = lgxs.getList();
		         backResult.setMessage("查询成功");
		         backResult.setQingqiu("list查询列表");
		         backResult.setData(resultList);

		    }else if (qqiu.equals("claTeaList")) {
		      // TODO 待完成

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

		  private void qqiuChoice(String qqiu, LogGX loggx) {
		    // TODO Auto-generated method stub
		    boolean test = false;
		    boolean deleteBatch = false;
		    boolean delete = false;
		    boolean list = false;
		    boolean getOne = false;
		    boolean on_off = false;
		    boolean editstuID=false;
		    boolean getMaxStuID=false;
		    test = qqiu.equals("test");
		    deleteBatch = qqiu.equals("deleteBatch");
		    delete = qqiu.equals("delete");
		    list = qqiu.equals("list");
		    getOne = qqiu.equals("getOne");
		    on_off = qqiu.equals("on_off");
		    editstuID=qqiu.equals("editstuID");
		    getMaxStuID=qqiu.equals("getMaxStuID");
		    if (test) {
		      logger.error("日志打印测试YXstudentController测试test方法,测试成功");      
		      backResult.setMessage("信息值,测试成功");
		      backResult.setQingqiu("test新增");
		      ArrayList<String> resultList = new ArrayList<String>();
		      resultList.add("内容值,测试成功1");
		      resultList.add("内容值,测试成功2");
		      resultList.add("内容值,测试成功3YXstudentController");
		      backResult.setData(resultList);
		    }
		    if (deleteBatch) {
		    	HttpServletRequest request1;
		    	String[] uuid = request1.getParameterValues("uuid");
		    	String result = lgxs.deleteBatch(uuid);
			    ArrayList<String> resultList = new ArrayList<String>();
			    resultList.add(result);
			    backResult.setMessage("信息值：成功");
			    backResult.setQingqiu("学员日志信息删除" + loggx.getUuid());
			    backResult.setData(resultList);
		    }
		    if (delete) {
		     String result = lgxs.delete(loggx);
		      ArrayList<String> resultList = new ArrayList<String>();
		      resultList.add(result);
		      backResult.setMessage("信息值：成功");
		      backResult.setQingqiu("学员日志信息删除" + loggx.getUuid());
		      backResult.setData(resultList);
		    }
		  }
}
