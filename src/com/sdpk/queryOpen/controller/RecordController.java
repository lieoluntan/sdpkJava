package com.sdpk.queryOpen.controller;

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
import com.sdpk.model.Record;
import com.sdpk.queryOpen.service.RecordService;
import com.sdpk.queryOpen.service.impl.RecordServiceImpl;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

public class RecordController extends HttpServlet{
	private static final long serialVersionUID = -1060747765670586355L;
	RecordService recordService = new RecordServiceImpl();
	//DitchService ditchService = new DitchServiceImpl();
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	Logger logger = Logger.getLogger(RecordController.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String qqiu = request.getParameter("qqiu");
		if (qqiu.equals("add") || qqiu.equals("delete")
				|| qqiu.equals("deleteByYxstuUid") || qqiu.equals("edit")
				|| qqiu.equals("getOne") || qqiu.equals("listByYxstuUid")
				|| qqiu.equals("on_off")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			Record record = new Record();
			if (str != null && str != "" && str.length() != 0) {
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				record = t_map2bean.MapToRecord(map);
				record.setOpenAndclose((String)map.get("openAndclose"));
			} else {
				System.out.println("前台传入数据为空，请联前台传入post请求体数系管理员！");
			}
			qqiuchocie(qqiu, record);
		} else if (qqiu.equals("list")) {
			ArrayList<Record> resultList = recordService.getList();
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("list查询列表");
			backResult.setData(resultList);
		} else if(qqiu.equals("test")){
			  logger.error("日志打印测试RecordController测试test方法,测试成功");      
		      backResult.setMessage("信息值,测试成功");
		      backResult.setQingqiu("test新增");
		      ArrayList<String> resultList = new ArrayList<String>();
		      resultList.add("内容值,测试成功1");
		      resultList.add("内容值,测试成功2");
		      resultList.add("内容值,测试成功3YXstudentController");
		      backResult.setData(resultList);
		}else {
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

	private void qqiuchocie(String qqiu, Record record) {
		boolean add = false;
		boolean delete = false;
		boolean deleteByYxstuUid = false;
		boolean edit = false;
		boolean getOne = false;
		boolean listByYxstuUid = false;
		boolean on_off=false;

		add = qqiu.equals("add");
		delete = qqiu.equals("delete");
		deleteByYxstuUid = qqiu.equals("deleteByYxstuUid");
		edit = qqiu.equals("edit");
		getOne = qqiu.equals("getOne");
		listByYxstuUid = qqiu.equals("listByYxstuUid");
		on_off=qqiu.equals("on_off");

		if (add) {
			String result = recordService.insert(record);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage(result == "该渠道不存在" ? "新增失败" : "新增成功");
			backResult.setQingqiu(result == "该渠道不存在" ? "no" : "yes");
			backResult.setData(resultList);
		}
		if (delete) {
			String result = recordService.delete(record);
			System.out.println("删除功能传进来的uuid================="
					+ record.getUuid());
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("delete删除" + record.getUuid());
			backResult.setData(resultList);
		}
		if (deleteByYxstuUid) {
			String result = recordService.deleteByDitchUuid(record);
			System.out.println("删除功能传进来的ditchUuid================="
					+ record.getStuUuid());
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("delete删除" + record.getStuUuid());
			backResult.setData(resultList);
		}
		if (edit) {
			String result = recordService.update(record);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage(result == "yes" ? "(修改失败)" : "修改成功");
			backResult.setQingqiu("yes");
			backResult.setData(resultList);
		}
		if (getOne) {
			Record result = recordService.getByUuid(record.getUuid());
			//Ditch ditch = ditchService.getByUuid(result.getDitchUuid());
			//result.setDitchName(record.getName());
			ArrayList<Object> resultList = new ArrayList<Object>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("getOne查询单条记录");
			backResult.setData(resultList);
		}
		if (listByYxstuUid) {
			ArrayList<Record> resultList = recordService
					.getListByDitchUuid(record.getStuUuid());
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("list查询列表");
			backResult.setData(resultList);
		}
		if(on_off){
			String oAc = record.getOpenAndclose() + "";
			String flagQqiu = "初始值";
			String result = "初始值";
			if (oAc.equals("open") || oAc.equals("close")) {
				if (oAc.equals("open")) {
					flagQqiu = "on";
				}
				if (oAc.equals("close")) {
					flagQqiu = "off";
				}
				result = recordService.getonoff(record);
			} else {
				flagQqiu = "err";
				logger.error("操作失败：开关参数不规范" + "(" + oAc + "),联系前端开发");
				result = "操作失败：开关参数不规范" + "(" + oAc + "),联系前端开发";
			}
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage(result);
			backResult.setQingqiu(flagQqiu);
			backResult.setData(resultList);
		}
	}
}
