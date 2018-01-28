package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.DepartmentDao;
import com.sdpk.model.Department;
import com.sdpk.utility.DBUtility;

/*
 * @author 刘鑫
 * @date 2018-1-28 
 */
public class DepartmentDaoImpl implements DepartmentDao {

	private Connection connection;

	public DepartmentDaoImpl() {
		System.out.println("connection对象在DepartmentDaoImpl连接!");
	}

	@Override
	public boolean insertDepartment(Department department) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;

		connection = DBUtility.open();
		try {
			preparedStatement = connection
					.prepareStatement("insert into t_department(uuid,name,remark,openAndclose,createDate,modifyDate,createPeople,modifyPeople) values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, department.getUuid());
			preparedStatement.setString(2, department.getName());
			preparedStatement.setString(3, department.getRemark());
			preparedStatement.setString(4, "open");
			preparedStatement.setString(5, department.getCreateDate());
			preparedStatement.setString(6, department.getModifyDate());
			preparedStatement.setString(7, department.getCreatePeople());
			preparedStatement.setString(8, department.getModifyPeople());
			preparedStatement.executeUpdate();
			System.out.println("^^在执行DepartmentDaoImpl中的添加insert");
			System.out.println(department.getName() + "================="
					+ department.getUuid());
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("^^在执行DepartmentDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
			e.printStackTrace();
			return false;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}

	}

	@Override
	public String serachDepartmentName(Department department) {
		Statement statement = null;
		ResultSet rs = null;
		String name = null;
		try {
			connection = DBUtility.open();
			statement = connection.createStatement();

			rs = statement
					.executeQuery("select name from t_department where name='"
							+ department.getName() + "'");
			while (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DepartmentDaoImpl的serachDepartmentName查询失败");
		} finally {
			DBUtility.close(rs, statement, connection);
		}
		return name;
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDepartment(String uuid) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		connection = DBUtility.open();
		try {
			ps = connection
					.prepareStatement("delete from t_department where uuid='"
							+ uuid + "'");
			ps.executeUpdate();
			System.out.println("^^在执行DepartmentDaoImpl中的删除deleteDepartment");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("^^在执行DepartmentDaoImpl中deleteDepartment,出现sql语法执行错误，请联系管理员!");
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, ps, connection);
		}
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		connection = DBUtility.open();
		try {
			ps = connection
					.prepareStatement("update t_department set name=? , remark=? where uuid=?");
			ps.setString(1, department.getName());
			ps.setString(2, department.getRemark());
			ps.setString(3, department.getUuid());
			ps.executeUpdate();
			System.out.println("^^在执行DepartmentDaoImpl中的修改updateDepartment");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("^^在执行DepartmentDaoImpl中update,出现sql语法执行错误，请联系管理员!");
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, ps, connection);
		}
	}

	@Override
	public ArrayList<Department> listDepartment() {
		// TODO Auto-generated method stub
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtility.open();

		ArrayList<Department> list = new ArrayList<Department>();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_department");
			while (rs.next()) {
				Department department = new Department();
				department.setName(rs.getString("name"));
				department.setUuid(rs.getString("uuid"));
				department.setRemark(rs.getString("remark"));
				list.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("^^在执行DepartmentDaoImpl中listDepartment,出现sql语法执行错误，请联系管理员!");
		} finally {
			DBUtility.close(rs, statement, connection);
		}
		return list;
	}

	@Override
	public Department serachOneDepartment(String uuid) {
		// TODO Auto-generated method stub
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtility.open();
		Department department = new Department();
		try {
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_department where uuid='"
							+ uuid + "'");
			while (rs.next()) {
				department.setUuid(uuid);
				department.setName(rs.getString("name"));
				department.setRemark(rs.getString("remark"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("^^在执行DepartmentDaoImpl中serachOneDepartment,出现sql语法执行错误，请联系管理员!");
		} finally {
			DBUtility.close(rs, statement, connection);
		}

		return department;
	}

	@Override
	public void updateOnOff(String uuid, String oac) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		connection = DBUtility.open();
		try {
			ps = connection
					.prepareStatement("update t_department set openAndclose='"
							+ oac + "' where uuid='" + uuid + "'");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("^^在执行DepartmentDaoImpl中updateOnOff,出现sql语法执行错误，请联系管理员!");
		}finally{
			DBUtility.close(rs, ps, connection);
		}
	}
}
