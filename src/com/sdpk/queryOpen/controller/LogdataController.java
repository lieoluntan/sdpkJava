package com.sdpk.queryOpen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sdpk.controller.ClaControl;
import com.sdpk.model.BackResult;
import com.sdpk.model.Cla;
import com.sdpk.model.Logdata;
import com.sdpk.queryOpen.service.ClaNameService;
import com.sdpk.queryOpen.service.LogdataService;
import com.sdpk.queryOpen.service.impl.ClaNameServiceImpl;
import com.sdpk.queryOpen.service.impl.LogdataServiceImpl;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

public class LogdataController extends HttpServlet{
	private static final long serialVersionUID = 2987524879460790191L;
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	LogdataService logQDService = new LogdataServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 1 获取url问号后面的Query 参数
	    String qqiu = request.getParameter("qqiu");
		    
	    if (qqiu.equals("test")  || qqiu.equals("delete") || qqiu.equals("add") || qqiu.equals("deleteBatch")) {
          // 2 将前台json数据字符串转成实体对象
          T_DataControl t_data = new T_DataControl();
          String str = t_data.getRequestPayload(request);
          Logdata logQD = new Logdata();
          List<String> uuidList =new ArrayList();
          if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
            Map<String, Object> map = t_data.JsonStrToMap(str);
            T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
            Map<String, Object> map2 = t_data.JsonStrToMap(str);
            uuidList = (List<String>) map2.get("uuidList");
            logQD = t_map2bean.MapToLogdata(map);
          } else {
            System.out.println("前台传入post请求体数据为空，请联系管理员！");
          }

          // 3 执行qqiu里面的增或删或改或查 的操作
          qqiuChoice(qqiu, logQD,uuidList);
        } else if (qqiu.equals("list")) {
          // TODO 待完成
          ArrayList<Logdata> resultList = logQDService.getList();
          backResult.setMessage("信息值：成功");
          backResult.setQingqiu("list查询列表");
          backResult.setData(resultList);

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
	
	private void qqiuChoice(String qqiu, Logdata logQD,List<String> uuidList) {
	    // TODO Auto-generated method stub
	    boolean test = false;
	    boolean delete = false;
	    boolean deleteBatch =false;
	    boolean add = false;

	    test = qqiu.equals("test");
	    delete = qqiu.equals("delete");
	    deleteBatch = qqiu.equals("deleteBatch");
	    add=qqiu.equals("add");
	    if (test) {
	            Logger logger = Logger.getLogger(LogdataController.class);
//	      BasicConfigurator.configure();
	      logger.error("日志打印A不报错误了1111111自定义的log4j了2222");
	      logger.error("日志打印测试B");      backResult.setMessage("信息值,测试成功");
	      backResult.setQingqiu("test新增");
	      ArrayList<String> resultList = new ArrayList<String>();
	      resultList.add("内容值,测试成功1");
	      resultList.add("内容值,测试成功2");
	      resultList.add("内容值,测试成功3");
	      backResult.setData(resultList);
	    }
	    if (delete) {
	      String result = logQDService.delete(logQD.getUuid());
	      ArrayList<String> resultList = new ArrayList<String>();
	      resultList.add(result);
	      backResult.setMessage("信息值：成功");
	      backResult.setQingqiu("delete删除" + logQD.getUuid());
	      backResult.setData(resultList);
	    }
	    if (deleteBatch) {
			String result = logQDService.deleteBatch(uuidList);
			System.out.println("删除功能传进来的uuid================="
					+ result);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage( result);
			backResult.setQingqiu("delete删除"+ result);
			backResult.setData(resultList);
		}
	    if (add) {
			String result = logQDService.insert(logQD);
			System.out.println("删除功能传进来的uuid================="
					+ result);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage( result);
			backResult.setQingqiu("delete删除"+ result);
			backResult.setData(resultList);
		}

	  }// end method qqiuChoice
}
