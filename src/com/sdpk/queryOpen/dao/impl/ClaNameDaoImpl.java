package com.sdpk.queryOpen.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.Cla;
import com.sdpk.queryOpen.dao.ClaNameDao;
import com.sdpk.utility.DBUtility;

public class ClaNameDaoImpl implements ClaNameDao{
	private Connection connection;
	boolean daoFlag = false;

	public ClaNameDaoImpl() {
		// connection = DBUtility.getConnection();
		System.out.println("connection对象在ClaNameDaoImpl连接!");
	}
	@Override
	public ArrayList<Cla> getList() {
		// TODO Auto-generated method stub
		ArrayList<Cla> claList = new ArrayList<Cla>();
	    Statement statement = null;//finally关闭数据库连接  
	    ResultSet rs = null;//关闭数据库连接get和getlist会用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	         statement = connection.createStatement();
	         rs = statement.executeQuery("select * from t_class where openAndclose='open'");
	        while (rs.next()) {
	          Cla cla = new Cla();
	          cla.setUuid(rs.getString("uuid"));
	          cla.setName(rs.getString("name"));
	          cla.setEmpUuid(rs.getString("empUuid"));             
	          cla.setClassDate(rs.getString("classDate"));
	          cla.setStatus(rs.getString("status"));
	          cla.setRemark(rs.getString("remark"));
	          cla.setOrg(rs.getString("org"));
	          cla.setClaNum(rs.getString("claNum"));
	          cla.setOpenAndclose(rs.getString("openAndclose"));
	          
	          claList.add(cla);
	        }
	        
	        return claList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("ClaNameDaoImpl的getList查询失败");
	        Cla claX = new Cla();
	        claX.setUuid("ClaNameDaoImpl的getList失败返回的uuid");
	        ArrayList<Cla> claListX = new ArrayList<Cla>();
	        claListX.add(claX);
	        return claListX;
	    }finally{   
	      DBUtility.close(rs, statement, connection);   
	     }//finally关闭jdbc与数据库连接
	}

}
