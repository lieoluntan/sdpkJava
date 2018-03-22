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

import com.sdpk.model.Contrtext;
import com.sdpk.service.ContrtextService;
import com.sdpk.service.impl.ContrtextServiceImpl;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:10:03
 * 
 */
public class ContrtextController extends HttpServlet {
	private ContrtextService contrtextService = new ContrtextServiceImpl();
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	Logger logger=Logger.getLogger(ContrtextController.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 1 获取url问号后面的Query 参数
		String qqiu = request.getParameter("qqiu");
		if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete")
				|| qqiu.equals("edit") || qqiu.equals("getOne")|| qqiu.equals("on_off")) {
			// 2 将前台json数据字符串转成实体对象
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);// 固定，不用改
			Contrtext contrtext = new Contrtext();
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);// 固定，不用改
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				contrtext = t_map2bean.MapToContrtext(map);

			} else {
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
			}

			// 3 执行qqiu里面的增或删或改或查 的操作
			qqiuChoice(qqiu, contrtext);
		} else if (qqiu.equals("list")) {
			// TODO 待完成
			ArrayList<Contrtext> resultList = contrtextService.getList();
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

	}// end method doPost 主入口

	private void qqiuChoice(String qqiu, Contrtext contrtext) {
		// TODO Auto-generated method stub
		boolean test = false;
		boolean add = false;
		boolean delete = false;
		boolean edit = false;
		boolean getOne = false;
		boolean on_off = false;

		test = qqiu.equals("test");
		add = qqiu.equals("add");
//		delete = qqiu.equals("delete");
		edit = qqiu.equals("edit");
		getOne = qqiu.equals("getOne");
		on_off = qqiu.equals("on_off");

		if (test) {
			logger.error("test,log4j日志测试成功,ContrtextController");
			backResult.setMessage("信息值,测试成功");
			backResult.setQingqiu("test新增");
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add("(合同)内容值,测试成功1");
			resultList.add("(合同)内容值,测试成功2");
			resultList.add("(合同)内容值,测试成功3");
			backResult.setData(resultList);
		}
		if (add) {
			
			String result = contrtextService.insert(contrtext,"测试用户uuid","测试用户name");
			System.out.println("插入的uuid是：" + result);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage(result=="yes"?"(已存在重复名字)"+contrtext.getcNum():"新增成功!");
		      backResult.setQingqiu(result=="yes"?"yes":"no");
			backResult.setData(resultList);
		}
		if (delete) {
			String result = contrtextService.delete(contrtext.getUuid());
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("delete删除" + contrtext.getUuid());
			backResult.setData(resultList);
		}
//		if (edit) {
//			
//			String result = contrtextService.update(contrtext);
//			ArrayList<String> resultList = new ArrayList<String>();
//			resultList.add(result);
//			backResult.setMessage(result=="yes"?"(已存在重复名字)"+contrtext.getcNum():"修改成功!");
//		      backResult.setQingqiu(result=="yes"?"yes":"no");
//			backResult.setData(resultList);
//		}
		if (edit) {
          
          String result = contrtextService.updateLimit(contrtext,"测试用户uuid","测试用户name");
          ArrayList<String> resultList = new ArrayList<String>();
          resultList.add(result);
          backResult.setMessage(result);
            backResult.setQingqiu("合同修改功能updateLimit");
          backResult.setData(resultList);
      }
		if (getOne) {
			Contrtext result = contrtextService.getByUuid(contrtext.getUuid());
			ArrayList<Contrtext> resultList = new ArrayList<Contrtext>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("getOne查询单条记录");
			backResult.setData(resultList);
		}
		if (on_off) {
	    	//判断openAndclose参数规范
	    	String oAc = contrtext.getOpenAndclose();
	    	String flagQqiu = "初始值";
	    	String result = "初始值";
	    	if(oAc.equals("open")||oAc.equals("close")){
	    		if(oAc.equals("open")){flagQqiu = "on";}
	    		if(oAc.equals("close")){flagQqiu = "off";}
	    		 result = contrtextService.getonoff(contrtext);
	    	}else { flagQqiu = "err"; result = "操作失败：开关参数不规范"+"("+oAc+")";}
	        
	        ArrayList<String> resultList = new ArrayList<String>();
	        resultList.add(result);
	        backResult.setMessage(result);
	        backResult.setQingqiu(flagQqiu);
	        backResult.setData(resultList);
	      }//end on_off

	}// end method qqiuChoice

}
