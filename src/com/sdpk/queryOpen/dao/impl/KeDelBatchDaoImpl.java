package com.sdpk.queryOpen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sdpk.queryOpen.dao.KeDelBatchDao;
import com.sdpk.utility.DBUtility;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public class KeDelBatchDaoImpl implements KeDelBatchDao{
	private Connection connection;
	boolean daoFlag = false;
	
	 public KeDelBatchDaoImpl() {
//	    connection = DBUtility.open();
		    System.out.println("connection对象在KeDelBatchDaoImpl连接!");
		  }
	@Override
	public boolean deleteBatch(String uuid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
				connection = DBUtility.open();//打开数据库连接
		        try {
					preparedStatement = connection
					  .prepareStatement("DELETE FROM t_paike_all WHERE uuid = ? ");
					preparedStatement.setString(1, uuid);
					preparedStatement.executeUpdate();
					System.out.println("^^在执行KeDelBatchDaoImpl中的删除deleteBatch");
					System.out.println("!!!"+preparedStatement);
				      daoFlag = true;
				      return daoFlag;
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("^^在执行KeDelBatchDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
				    daoFlag = false;
				    return daoFlag;
				}finally{
			      ResultSet rs = null; 
			      DBUtility.close(rs, preparedStatement, connection);   
			     }//finally关闭jdbc与数据库连接  
	}

	

}
