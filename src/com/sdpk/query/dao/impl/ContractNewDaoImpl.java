package com.sdpk.query.dao.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.StudentDao;
import com.sdpk.model.Contract;

import com.sdpk.query.dao.ContractNewDao;

import com.sdpk.utility.DBUtility;


public class ContractNewDaoImpl implements ContractNewDao{


	private Connection connection;
	boolean daoFlag = false;
	@Override
	public Contract getByUuid(String uuid) {
		
		Contract contractResult = new Contract();
		    Statement statement = null;//finally关闭数据库连接  
		    ResultSet rs = null;//关闭数据库连接get和getlist会用到
		    try {
		      connection = DBUtility.open();//打开数据库连接
		         statement = connection.createStatement();
		         rs = statement.executeQuery("select * from t_contract WHERE uuid ="+"'"+uuid+"'");
		        while (rs.next()) {
		          Contract contract = new Contract();
		          contract.setUuid(rs.getString("uuid"));
		          contract.setcNum(rs.getString("cNum"));
		          contract.setStuUuid(rs.getString("stuUuid"));   
		          contract.setStuName(rs.getString("stuName"));
		          contract.setcDate(rs.getString("cDate"));
		          contract.setOrg(rs.getString("org"));
		          contract.setTotalCount(rs.getString("totalCount"));
		          contract.setTotalPrice(rs.getString("totalPrice"));
		          
		          contract.setOnePriceA(rs.getString("onePriceA"));
		          contract.setCountA(rs.getString("countA"));
		          contract.setDelPriceA(rs.getString("delPriceA"));
		          contract.setCountGiveA(rs.getString("countGiveA"));
		          contract.setSumCountA(rs.getString("sumCountA"));
		          contract.setSumPriceA(rs.getString("sumPriceA"));
		          
		          contract.setOnePriceB(rs.getString("onePriceB"));
		          contract.setCountB(rs.getString("countB"));
		          contract.setDelPriceB(rs.getString("delPriceB"));
		          contract.setCountGiveB(rs.getString("countGiveB"));
		          contract.setSumCountB(rs.getString("sumCountB"));
		          contract.setSumPriceB(rs.getString("sumPriceB"));
		          
		          contractResult=contract;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("ContractDaoImpl的getByUuid查询失败");
		        Contract contractX = new Contract();
		        contractX.setUuid("ContractDaoImpl失败返回的uuid");
		        return contractX;
		    }finally{   
		      DBUtility.close(rs, statement, connection);   
		     }//finally关闭jdbc与数据库连接  

		    return contractResult;
		  }
	
	
	@Override
	public ArrayList<Contract> getList() {
		// TODO Auto-generated method stub
		
		ArrayList<Contract> contractList = new ArrayList<Contract>();
	    Statement statement = null;//finally关闭数据库连接  
	    ResultSet rs = null;//关闭数据库连接get和getlist会用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	         statement = connection.createStatement();
	         rs = statement.executeQuery("select * from t_contract");
	        while (rs.next()) {
	          Contract contract = new Contract();
	          contract.setUuid(rs.getString("uuid"));
	          contract.setcNum(rs.getString("cNum"));
	          contract.setStuUuid(rs.getString("stuUuid"));  
	          contract.setcDate(rs.getString("cDate"));
	          contract.setOrg(rs.getString("org"));
	          contract.setTotalCount(rs.getString("totalCount"));
	          contract.setTotalPrice(rs.getString("totalPrice"));
	          
	          contract.setOnePriceA(rs.getString("onePriceA"));
	          contract.setCountA(rs.getString("countA"));
	          contract.setDelPriceA(rs.getString("delPriceA"));
	          contract.setCountGiveA(rs.getString("countGiveA"));
	          contract.setSumCountA(rs.getString("sumCountA"));
	          contract.setSumPriceA(rs.getString("sumPriceA"));
	          
	          contract.setOnePriceB(rs.getString("onePriceB"));
	          contract.setCountB(rs.getString("countB"));
	          contract.setDelPriceB(rs.getString("delPriceB"));
	          contract.setCountGiveB(rs.getString("countGiveB"));
	          contract.setSumCountB(rs.getString("sumCountB"));
	          contract.setSumPriceB(rs.getString("sumPriceB"));
	          
	          contractList.add(contract);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("ContractDaoImpl的getList查询失败");
	        Contract contractX = new Contract();
	        contractX.setUuid("ContractDaoImpl的getList失败返回的uuid");
	        ArrayList<Contract> contractListX = new ArrayList<Contract>();
	        contractListX.add(contractX);
	        return contractListX;
	    }finally{   
	      DBUtility.close(rs, statement, connection);   
	     }
		return contractList;
	}
}
