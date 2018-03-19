package com.sdpk.queryOpen.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.Employee;
import com.sdpk.queryOpen.dao.TeacherNameDao;
import com.sdpk.utility.DBUtility;

public class TeacherNameDaoImpl implements TeacherNameDao{
	
	private Connection connection;
	boolean daoFlag = false;

	public TeacherNameDaoImpl() {
		// connection = DBUtility.getConnection();
		System.out.println("connection对象在TeacherNameDaoImpl连接!");
	}
	
	@Override
	public ArrayList<Employee> getList() {
		// TODO Auto-generated method stub
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
	    Statement statement = null;//finally关闭数据库连接  
	    ResultSet rs = null;//关闭数据库连接get和getlist会用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	         statement = connection.createStatement();
	         rs = statement.executeQuery("select * from t_employee where openAndclose='open'");
	        while (rs.next()) {
	          Employee employee = new Employee();
	          employee.setUuid(rs.getString("uuid"));
	          employee.setName(rs.getString("name"));
	          employee.setEmpNum(rs.getString("empNum"));             
	          employee.setPhone(rs.getString("phone"));
	          employee.setDepart(rs.getString("depart"));
	          employee.setJob(rs.getString("job"));
	          employee.setRemark(rs.getString("remark"));
	          
	          employee.setClaTeacher(rs.getString("claTeacher"));
	          employee.setSex(rs.getString("sex"));
	          employee.setOrg(rs.getString("org"));
	          employee.setWorkDate(rs.getString("workDate"));
	          employee.setFullhalf(rs.getString("fullhalf"));
	          employee.setJobRemark(rs.getString("jobRemark"));
	          employee.setOpenAndclose(rs.getString("openAndclose"));
	          
	          employeeList.add(employee);
	        }
	        
	        return employeeList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("TeacherNameDaoImpl的getList查询失败");
	        Employee employeeX = new Employee();
	        employeeX.setUuid("TeacherNameDaoImpl的getList失败返回的uuid");
	        ArrayList<Employee> employeeListX = new ArrayList<Employee>();
	        employeeListX.add(employeeX);
	        return employeeListX;
	    }finally{   
	      DBUtility.close(rs, statement, connection);   
	     }//finally关闭jdbc与数据库连接

	    
	}

}
