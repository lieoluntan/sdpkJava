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
import com.sdpk.controller.LogGXController;
import com.sdpk.model.BackResult;
import com.sdpk.model.LogGX;
import com.sdpk.queryOpen.service.KeDelBatchService;
import com.sdpk.queryOpen.service.impl.KeDelBatchServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

public class KeDelBatchController extends HttpServlet {

	KeDelBatchService kdbs = new KeDelBatchServiceImpl();
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

		    if (qqiu.equals("test") || qqiu.equals("deleteBatch")) {
		      // 2 将前台json数据字符串转成实体对象
		      T_DataControl t_data = new T_DataControl();
		      String str = t_data.getRequestPayload(request);
		      List<String> uuidList =new ArrayList();
		      if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
		        T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
		        Map<String, Object> map2 = t_data.JsonStrToMap(str);
	            uuidList = (List<String>) map2.get("uuidList");
		      } else {
		        System.out.println("前台传入post请求体数据为空，请联系管理员！");
		      }

		      // 3 执行qqiu里面的增或删或改或查 的操作
		      qqiuChoice(qqiu, uuidList);
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

		  private void qqiuChoice(String qqiu, List<String> uuidList) {
		    // TODO Auto-generated method stub
			boolean test = false;
		    boolean deleteBatch =false;
		    test = qqiu.equals("test");
		    deleteBatch = qqiu.equals("deleteBatch");
		    
		    if (test) {
			      logger.error("日志打印测试YXstudentController测试test方法,测试成功");      
			      backResult.setMessage("信息值,测试成功");
			      backResult.setQingqiu("默认");
			      ArrayList<String> resultList = new ArrayList<String>();
			      resultList.add("内容值,测试成功1");
			      resultList.add("内容值,测试成功2");
			      backResult.setData(resultList);
			    }
		    if (deleteBatch) {
				String result = kdbs.deleteBatch(uuidList);
				System.out.println("删除功能传进来的uuid================="
						+ result);
				ArrayList<String> resultList = new ArrayList<String>();
				resultList.add(result);
				backResult.setMessage( result);
				backResult.setQingqiu("delete删除"+ result);
				backResult.setData(resultList);
			}
		  }//end method 

}
