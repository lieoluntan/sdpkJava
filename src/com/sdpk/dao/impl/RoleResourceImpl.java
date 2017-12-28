package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sdpk.dao.RoleResourceDao;
import com.sdpk.model.Resource;
import com.sdpk.model.RoleResource;
import com.sdpk.utility.DBUtility;
/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2017-12-27 上午11:08:06
 *
 */
public class RoleResourceImpl implements RoleResourceDao {
	private Connection connection;
	@Override
	public List<String> getRsbyRoleid(List<String> list) {
		// TODO Auto-generated method stub
		RoleResource roleresourceResult = new RoleResource();
for (String rid : list) {
	Statement statement = null;// finally关闭数据库连接
	ResultSet rs = null;// 关闭数据库连接get和getlist会用到
	try {
		connection = DBUtility.open();// 打开数据库连接
		statement = connection.createStatement();
		rs = statement.executeQuery("select * from t_role_resource WHERE rolrid ="
				+ "'" + rid + "'");
		while (rs.next()) {
			Resource resource = new Resource();
			resource.setUuid(rs.getString("uuid"));
			resource.setName(rs.getString("name"));

			//resourceResult = resource;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("ResourceDaoImpl的getByUuid查询失败");

//		Resource resourceX = new Resource();
//		resourceX.setUuid("ResourceDaoImpl失败返回的uuid");
//		return resourceX;
	} finally {
		DBUtility.close(rs, statement, connection);
	}// finally关闭jdbc与数据库连接

	
	
}
		
		return resourceResult;
	}

}
