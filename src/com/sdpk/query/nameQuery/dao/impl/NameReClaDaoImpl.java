package com.sdpk.query.nameQuery.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Cla;
import com.sdpk.query.nameQuery.dao.NameReClaDao;
import com.sdpk.utility.DBUtility;
/**
 * 
 * @author 罗成峰
 * @date 2018-1-5下午3:46:28
 * @version 1.0
 */
public class NameReClaDaoImpl implements NameReClaDao{
	private Connection connection;
	@Override
	public List<Cla> getClaByName(Cla cla) {
		// TODO Auto-generated method stub
		List<Cla> claList = new ArrayList<Cla>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_class WHERE name ='"
							+ cla.getName() + "'");
			while (rs.next()) {
				Cla s = new Cla();
				s.setUuid(rs.getString("uuid"));
				claList.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return claList;
	}
}
