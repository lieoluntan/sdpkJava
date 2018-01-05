package com.sdpk.query.nameQuery.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Contract;
import com.sdpk.model.Employee;
import com.sdpk.query.nameQuery.dao.NameReContrDao;
import com.sdpk.utility.DBUtility;
/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-5 下午5:24:14
 *   合同检验
 */
public class NameReContrDaoImpl implements NameReContrDao {
	private Connection connection;
	@Override
	public List<Contract> getStuByName(Contract contract) {
		// TODO Auto-generated method stub
		List<Contract> conList = new ArrayList<Contract>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_contract WHERE cNum ='"
							+ contract.getcNum() + "'");
			while (rs.next()) {
				Contract s = new Contract();
				s.setUuid(rs.getString("uuid"));
				conList.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return conList;
	}

}
