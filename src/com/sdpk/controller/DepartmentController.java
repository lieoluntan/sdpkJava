package com.sdpk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdpk.model.BackResult;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Department;
import com.sdpk.service.DepartmentService;
import com.sdpk.service.impl.DepartmentServiceImpl;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/*
 * @author 刘鑫
 * @date 2018-1-8 13:08
 */
public class DepartmentController extends HttpServlet {
	DepartmentService dts = new DepartmentServiceImpl();
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 1 获取url问号后面的Query 参数
		String qqiu = request.getParameter("qqiu");

		if (qqiu.equals("add")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			Department department = new Department();
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				department = t_map2bean.MapToDepartment(map);
				System.out.println(department.getName()
						+ "========控制层=========" + department.getUuid());
				if (department.getName().equals(
						dts.serachDepartmentName(department))) {
					System.out.println("添加的部门名称已存在，请联系管理员！");
					backResult.setMessage("信息值：失败");
					backResult.setQingqiu("add新增");
					ArrayList<String> list = new ArrayList<String>();
					list.add(department.getUuid());
					backResult.setData(list);
				} else {
					dts.insertDepartment(department);
					backResult.setMessage("信息值：成功");
					backResult.setQingqiu("add新增");
					ArrayList<String> list = new ArrayList<String>();
					list.add(department.getUuid());
					backResult.setData(list);
				}

			} else {
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
				backResult.setMessage("信息值：失败");
				backResult.setQingqiu("前台传入post请求体数据为空，请联系管理员！");
			}

		} else if (qqiu.equals("delete")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();

				System.out.println("前台传来的uuid=================="
						+ (String) map.get("uuid"));
				dts.deleteDepartment((String) map.get("uuid"));
				backResult.setMessage("信息值：成功");
				backResult.setQingqiu("delete删除");
				ArrayList<String> list = new ArrayList<String>();
				list.add((String) map.get("uuid"));
				backResult.setData(list);
			}else{
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
				backResult.setMessage("信息值：失败");
				backResult.setQingqiu("前台传入post请求体数据为空，请联系管理员！");
			}
			
		} else if (qqiu.equals("edit")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				Department department = new Department();
				department = t_map2bean.MapToDepartment(map);
				department.setUuid((String) map.get("uuid"));
				System.out.println("前台传来的uuid=================="
						+ department.getUuid());
				dts.updateDepartment(department);
				backResult.setMessage("信息值：成功");
				backResult.setQingqiu("update修改");
				ArrayList<String> list = new ArrayList<String>();
				list.add(department.getUuid());
				backResult.setData(list);
			}else{
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
				backResult.setMessage("信息值：失败");
				backResult.setQingqiu("前台传入post请求体数据为空，请联系管理员！");
			}
			
		} else if (qqiu.equals("list")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				ArrayList<Department> list = dts.listDepartment();
				backResult.setMessage("信息值：成功");
				backResult.setQingqiu("list查询列表");
				backResult.setData(list);
			}else{
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
				backResult.setMessage("信息值：失败");
				backResult.setQingqiu("前台传入post请求体数据为空，请联系管理员！");
			}
			ArrayList<Department> list = dts.listDepartment();
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("list查询列表");
			backResult.setData(list);
		} else if (qqiu.equals("getOne")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			Map<String, Object> map = t_data.JsonStrToMap(str);
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				System.out.println("前台传来的uuid=================="
						+ (String) map.get("uuid"));
				Department department = dts.serachOneDepartment((String) map
						.get("uuid"));
				backResult.setMessage("信息值：成功");
				backResult.setQingqiu("getOne查询单条记录");
				ArrayList<Department> list = new ArrayList<Department>();
				list.add(department);
				backResult.setData(list);
			}else{
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
				backResult.setMessage("信息值：失败");
				backResult.setQingqiu("前台传入post请求体数据为空，请联系管理员！");
			}
			System.out.println("前台传来的uuid=================="
					+ (String) map.get("uuid"));
			Department department = dts.serachOneDepartment((String) map
					.get("uuid"));
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("getOne查询单条记录");
			ArrayList<Department> list = new ArrayList<Department>();
			list.add(department);
			backResult.setData(list);
		} else if (qqiu.equals("on_off")) {
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			Map<String, Object> map = t_data.JsonStrToMap(str);
			if (str != null && str != "" && str.length() != 0) {
				System.out.println("前台传来的uuid=================="
						+ (String) map.get("uuid"));
				if (map.get("openAndclose").equals("open")) {
					dts.updateOnOff((String) map.get("uuid"), "open");
					backResult.setMessage("操作成功：已打开");
					backResult.setQingqiu("on");
					backResult.setData(null);
				} else if (map.get("openAndclose").equals("close")) {
					dts.updateOnOff((String) map.get("uuid"), "close");
					backResult.setMessage("操作成功：已关闭");
					backResult.setQingqiu("off");
					backResult.setData(null);
				} else {
					backResult.setMessage("操作失败：开关参数不规范(close)，联系前端开发");
					backResult.setQingqiu("err");
					backResult.setData(null);
				}
			}else{
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
				backResult.setMessage("信息值：失败");
				backResult.setQingqiu("前台传入post请求体数据为空，请联系管理员！");
			}
			

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
}
