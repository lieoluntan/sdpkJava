package com.sdpk.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sdpk.model.BackResult;
import com.sdpk.model.Cla;
import com.sdpk.model.Contract;
import com.sdpk.model.Course;
import com.sdpk.model.Student;
import com.sdpk.service.StudentService;
import com.sdpk.service.impl.StudentServiceImpl;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public class StudentControl extends HttpServlet {

	StudentService studentService = new StudentServiceImpl();
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	Logger logger=Logger.getLogger(StudentControl.class);
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}// end doGet

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO doPost
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 1 获取url问号后面的Query 参数
		String qqiu = request.getParameter("qqiu");

		if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete")
				|| qqiu.equals("edit") || qqiu.equals("getOne")|| qqiu.equals("on_off")) {
			// 2 将前台json数据字符串转成实体对象
			T_DataControl t_data = new T_DataControl();
			String str = t_data.getRequestPayload(request);
			Student student = new Student();
			if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
				Map<String, Object> map = t_data.JsonStrToMap(str);
				T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
				student = t_map2bean.MapToStudent(map);
			} else {
				System.out.println("前台传入post请求体数据为空，请联系管理员！");
			}

			// 3 执行qqiu里面的增或删或改或查 的操作
			qqiuChoice(qqiu, student);
		} else if (qqiu.equals("list")) {
			// TODO 待完成
			ArrayList<Student> resultList = studentService.getList();
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

	private void qqiuChoice(String qqiu, Student student) {
		// TODO Auto-generated method stub
		boolean test = false;
		boolean add = false;
		boolean delete = false;
		boolean edit = false;
		boolean getOne = false;
		boolean on_off = false;

		test = qqiu.equals("test");
		add = qqiu.equals("add");
//		delete = qqiu.equals("delete");//删除权限暂不开放
		edit = qqiu.equals("edit");
		getOne = qqiu.equals("getOne");
		on_off = qqiu.equals("on_off");

		if (test) {
			logger.error("test,log4j日志测试成功,StudentControl");
			backResult.setMessage("信息值,测试成功");
			backResult.setQingqiu("test新增");
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add("内容值,测试成功1");
			resultList.add("内容值,测试成功2");
			resultList.add("内容值,测试成功3");
			backResult.setData(resultList);
		}
		if (add) {
			
			String flag = studentService.getStuByName(student);
			String result = studentService.insert(student);

			System.out.println("插入的uuid是：" + result);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			String flgmsg = "初始值";
			if(result.equals("yes")){flgmsg = flag;}else{flgmsg = "新增成功";}
			backResult.setMessage(flgmsg);
			backResult.setQingqiu(result=="yes"?"yes":"no");
			backResult.setData(resultList);
		}
		if (delete) {
			String result = studentService.delete(student.getUuid());
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("delete删除" + student.getUuid());
			backResult.setData(resultList);
		}
		if (edit) {
			String flag = studentService.getStuByName(student);
			String result = studentService.update(student);
			ArrayList<String> resultList = new ArrayList<String>();
			resultList.add(result);
			backResult.setMessage(flag);
			backResult.setQingqiu(result=="yes"?"yes":"no");
			backResult.setData(resultList);
		}
		if (getOne) {
			Student result = studentService.getByUuid(student.getUuid());
			ArrayList<Student> resultList = new ArrayList<Student>();
			resultList.add(result);
			backResult.setMessage("信息值：成功");
			backResult.setQingqiu("getOne查询列表");
			backResult.setData(resultList);
		}
		if (on_off) {
	    	//判断openAndclose参数规范
	    	String oAc = student.getOpenAndclose();
	    	String flagQqiu = "初始值";
	    	String result = "初始值";
	    	if(oAc.equals("open")||oAc.equals("close")){
	    		if(oAc.equals("open")){flagQqiu = "on";}
	    		if(oAc.equals("close")){flagQqiu = "off";}
	    		 result = studentService.getonoff(student);
	    	}else { flagQqiu = "err"; result = "操作失败：开关参数不规范"+"("+oAc+")";}
	        
	        ArrayList<String> resultList = new ArrayList<String>();
	        resultList.add(result);
	        backResult.setMessage(result);
	        backResult.setQingqiu(flagQqiu);
	        backResult.setData(resultList);
	      }//end on_off

	}// end method qqiuChoice

}// end aaControl
