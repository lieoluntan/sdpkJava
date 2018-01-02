package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.And_ClassEmp;
import com.sdpk.query.dao.MyClaDao;
import com.sdpk.utility.DBUtility;

public class MyClaDaoImpl implements MyClaDao{

	  private Connection connection;
	  boolean daoFlag = false;
	
	  @Override
	public ArrayList<And_ClassEmp> getListByEmp(String empUuid) {
		// TODO Auto-generated method stub
		 ArrayList<And_ClassEmp> reList = new ArrayList<And_ClassEmp>();
		    Statement statement = null;//finally关闭jdbc与数据库连接  
		    ResultSet rs = null; //finally关闭jdbc与数据库连接
		    try {
		      connection = DBUtility.open();//打开数据库连接
		         statement = connection.createStatement();
		         rs = statement.executeQuery("select * from t_class_emp WHERE empUuid ="+"'"+empUuid+"'");
		        while (rs.next()) {
		          And_ClassEmp and_ClassEmp = new And_ClassEmp();
		          and_ClassEmp.setUuid(rs.getString("uuid"));
		          and_ClassEmp.setClassUuid(rs.getString("classUuid"));
		          and_ClassEmp.setEmpUuid(rs.getString("empUuid"));             
		          
		          reList.add(and_ClassEmp);
		        }
		        
		        return reList;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("And_ClassEmpDaoImpl的getListBycla查询失败");
		        And_ClassEmp and_ClassEmpX = new And_ClassEmp();
		        and_ClassEmpX.setUuid("And_ClassEmpDaoImpl的getList失败返回的uuid");
		        ArrayList<And_ClassEmp> and_ClassEmpXList = new ArrayList<And_ClassEmp>();
		        and_ClassEmpXList.add(and_ClassEmpX);
		        return and_ClassEmpXList;
		    }finally{
		      DBUtility.close(rs, statement, connection);   
		     }//finally关闭jdbc与数据库连接 
	}

	@Override
	public ArrayList<And_ClassEmp> getListBycla(String classUuid) {
		ArrayList<And_ClassEmp> reList = new ArrayList<And_ClassEmp>();
	    Statement statement = null;//finally关闭数据库连接  
	    ResultSet rs = null;//关闭数据库连接get和getlist会用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	         statement = connection.createStatement();
	         rs = statement.executeQuery("select * from t_class_emp WHERE classUuid ="+"'"+classUuid+"'");
	        while (rs.next()) {
	          And_ClassEmp and_ClassEmp = new And_ClassEmp();
	          and_ClassEmp.setUuid(rs.getString("uuid"));
	          and_ClassEmp.setClassUuid(rs.getString("classUuid"));
	          and_ClassEmp.setEmpUuid(rs.getString("empUuid"));             
	          reList.add(and_ClassEmp);
	        }
	        return reList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("And_ClassEmpDaoImpl的getListBycla查询失败");
	        And_ClassEmp and_ClassEmpX = new And_ClassEmp();
	        and_ClassEmpX.setUuid("And_ClassEmpDaoImpl的getList失败返回的uuid");
	        ArrayList<And_ClassEmp> and_ClassEmpXList = new ArrayList<And_ClassEmp>();
	        and_ClassEmpXList.add(and_ClassEmpX);
	        return and_ClassEmpXList;
	    }finally{   
	      DBUtility.close(rs, statement, connection);   
	     }//finally关闭jdbc与数据库连接  
	
	}

}
