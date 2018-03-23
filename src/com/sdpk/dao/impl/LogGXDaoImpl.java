package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.LogGXDao;
import com.sdpk.model.LogGX;
import com.sdpk.utility.DBUtility;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public class LogGXDaoImpl implements LogGXDao{

	private Connection connection;
	  boolean daoFlag = false;
	  
	  public LogGXDaoImpl() {
//	    connection = DBUtility.open();
	    System.out.println("connection对象在LogGXDaoImpl连接!");
	  }
	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		PreparedStatement PSdelete = null; //关闭数据库连接insert和update和delete用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	      // Parameters start with 1
	       PSdelete = connection
	          .prepareStatement("DELETE FROM t_loggx WHERE uuid = ? ");
	      PSdelete.setString(1, uuid);
	      PSdelete.executeUpdate();

	      System.out.println("^^在执行LogGXDaoImpl中的删除delete");
	      daoFlag = true;
	      return daoFlag;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      System.out.println("^^在执行LogGXDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
	      daoFlag = false;
	      return daoFlag;
	    }finally{
	      ResultSet rs = null; 
	      DBUtility.close(rs, PSdelete, connection);   
	     }//finally关闭jdbc与数据库连接  
	}

	@Override
	public ArrayList<LogGX> getList() {
		// TODO Auto-generated method stub
		ArrayList<LogGX> logstu = new ArrayList<LogGX>();
	    Statement statement = null;//finally关闭数据库连接  
	    ResultSet rs = null;//关闭数据库连接get和getlist会用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	         statement = connection.createStatement();
	         rs = statement.executeQuery("SELECT * FROM t_loggx");
	        while (rs.next()) {
	        	LogGX logstu1 = new LogGX();
	        	logstu1.setUuid(rs.getString("uuid"));
	        	logstu1.setUserUuid(rs.getString("userUuid"));
	        	logstu1.setUserName(rs.getString("userName"));
	        	logstu1.setTableName(rs.getString("tableName"));
	        	logstu1.setTableNameChina(rs.getString("tableNameChina"));
	        	logstu1.setDataName(rs.getString("dataName"));
	        	logstu1.setDataUuid(rs.getString("dataUuid"));
	          
	        	logstu1.setUpdateTime(rs.getString("updateTime"));
	        	logstu1.setUserAction(rs.getString("userAction"));
	        	logstu1.setDataGxUuid(rs.getString("dataGxUuid"));
	        	logstu1.setDataGxChina(rs.getString("dataGxChina"));
	        	logstu.add(logstu1);
	        }
	        
	        return logstu;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("getList查询失败");
	        LogGX X = new LogGX();
	        X.setUuid("LoggxDaoImpl的getList失败返回的uuid");
	        ArrayList<LogGX> XList = new ArrayList<LogGX>();
	        XList.add(X);
	        return logstu;
	    }finally{   
	      DBUtility.close(rs, statement, connection);   
	     }//finally关闭jdbc与数据库连接
	}

	@Override
	public boolean insert(LogGX lgx) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	       preparedStatement = connection
	          .prepareStatement("insert into t_loggx(uuid,userUuid,userName,tableName,tableNameChina,dataUuid,dataName,userAction,updateTime,dataGxUuid,dataGxChina) values (?,?,?,?,?,?,?,?,?,?,?)");
	      // Parameters start with 1
	      preparedStatement.setString(1, lgx.getUuid());
	      preparedStatement.setString(2, lgx.getUserUuid());
	      preparedStatement.setString(3, lgx.getUserName());
	      preparedStatement.setString(4, lgx.getTableName());
	      preparedStatement.setString(5, lgx.getTableNameChina());
	      preparedStatement.setString(6, lgx.getDataUuid());
	      preparedStatement.setString(7, lgx.getDataName());
	      
	      preparedStatement.setString(8, lgx.getUserAction());
	      preparedStatement.setString(9, lgx.getUpdateTime());
	      preparedStatement.setString(10, lgx.getDataGxUuid());
	      preparedStatement.setString(11, lgx.getDataGxChina());
	      preparedStatement.executeUpdate();

	      System.out.println("^^在执行LoggxDaoImpl中的insert添加");
	      daoFlag = true;
	      return daoFlag;
	    } catch (SQLException e) {
	      System.out.println("^^在执行LoggxDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
	      e.printStackTrace();
	      daoFlag = false;
	      return daoFlag;
	    }finally{
	      ResultSet rs = null; 
	      DBUtility.close(rs, preparedStatement, connection);   
	     }//finally关闭jdbc与数据库连接  
	}

}
