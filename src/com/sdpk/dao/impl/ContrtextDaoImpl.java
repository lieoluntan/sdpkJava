package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.dao.ContrtextDao;
import com.sdpk.dao.StudentDao;

import com.sdpk.model.Contrtext;
import com.sdpk.model.Student;
import com.sdpk.utility.DBUtility;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:08:16
 * 
 */
public class ContrtextDaoImpl implements ContrtextDao {
	private Connection connection;
	boolean daoFlag = false;

	@Override
	public boolean insert(Contrtext contrtext) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null; // 关闭数据库连接insert和update和delete用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			StudentDao sdi=new StudentDaoImpl();
			Student stu=sdi.getByUuid(contrtext.getStuUuid());
			String stuName=stu.getName();
			preparedStatement = connection
					.prepareStatement("insert into t_contrtext(uuid,cNum,stuUuid,cDate,org,totalCount,totalPrice,sumLineUpA,sumLineDownB,openAndclose,remark,nameTcname) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, contrtext.getUuid());
			preparedStatement.setString(2, contrtext.getcNum());
			preparedStatement.setString(3, contrtext.getStuUuid());
			preparedStatement.setString(4, contrtext.getcDate());
			preparedStatement.setString(5, contrtext.getOrg());
			preparedStatement.setString(6, contrtext.getTotalCount());
			preparedStatement.setString(7, contrtext.getTotalPrice());
			preparedStatement.setInt(8, contrtext.getSumLineUpA());
			preparedStatement.setInt(9, contrtext.getSumLineDownB());
			preparedStatement.setString(10, "open");//新增统一为打开open
			preparedStatement.setString(11, contrtext.getRemark());
			preparedStatement.setString(12, stuName+contrtext.getcNum());
			preparedStatement.executeUpdate();

			System.out.println("^^在执行ContrtextDaoImpl中的添加insert");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			System.out
					.println("^^在执行ContrtextDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
			e.printStackTrace();
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}// finally关闭jdbc与数据库连接
	}

	@Override
	public boolean deleteByUuid(String uuid) {
		// TODO Auto-generated method stub
		PreparedStatement PSdelete = null; // 关闭数据库连接insert和update和delete用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			// Parameters start with 1
			PSdelete = connection
					.prepareStatement("DELETE FROM t_contrtext WHERE uuid = ? ");
			PSdelete.setString(1, uuid);
			PSdelete.executeUpdate();

			System.out.println("^^在执行ContrtextDaoImpl中的删除delete");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("^^在执行ContrtextDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, PSdelete, connection);
		}// finally关闭jdbc与数据库连接
	}

	@Override
	public boolean update(Contrtext contrtext) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null; // 关闭数据库连接insert和update和delete用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			StudentDao sdi=new StudentDaoImpl();
			Student stu=sdi.getByUuid(contrtext.getStuUuid());
			System.out.println(contrtext.getStuUuid()+"====================学生id");
			String stuName=stu.getName();
			System.out.println(stuName+"====================学生姓名");
			preparedStatement = connection
					.prepareStatement("UPDATE t_contrtext SET cNum = ?, stuUuid = ?,cDate = ?, org = ?, totalCount = ?, totalPrice = ?,sumLineUpA = ?,sumLineDownB = ?,remark = ? ,nameTcname = ? WHERE uuid = ? ");
			preparedStatement.setString(1, contrtext.getcNum());
			preparedStatement.setString(2, contrtext.getStuUuid());
			preparedStatement.setString(3, contrtext.getcDate());
			preparedStatement.setString(4, contrtext.getOrg());
			preparedStatement.setString(5, contrtext.getTotalCount());
			preparedStatement.setString(6, contrtext.getTotalPrice());
			preparedStatement.setLong(7, contrtext.getSumLineUpA());
			preparedStatement.setLong(8, contrtext.getSumLineDownB());
			preparedStatement.setString(9, contrtext.getRemark());
			preparedStatement.setString(10, stuName+contrtext.getcNum());
			preparedStatement.setString(11, contrtext.getUuid());
			preparedStatement.executeUpdate();

			System.out.println("^^在执行ContrtextDaoImpl中的修改update");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("^^在执行ContrtextDaoImpl中update,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}// finally关闭jdbc与数据库连接
	}

	@Override
	public List<Contrtext> getList() {
		// TODO Auto-generated method stub
		ArrayList<Contrtext> contractList = new ArrayList<Contrtext>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_contrtext");
			while (rs.next()) {
				Contrtext contract = new Contrtext();
				contract.setUuid(rs.getString("uuid"));
				contract.setcNum(rs.getString("cNum"));
				contract.setStuUuid(rs.getString("stuUuid"));
				contract.setcDate(rs.getString("cDate"));
				contract.setOrg(rs.getString("org"));
				contract.setTotalCount(rs.getString("totalCount"));
				contract.setTotalPrice(rs.getString("totalPrice"));
				contract.setSumLineUpA(rs.getInt("sumLineUpA"));
				contract.setSumLineDownB(rs.getInt("sumLineDownB"));
				contract.setOpenAndclose(rs.getString("openAndclose"));
				contract.setRemark(rs.getString("remark"));
				contract.setNameTcname(rs.getString("nameTcname"));
				contractList.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ContrtextDaoImpl的getList查询失败");
			Contrtext contractX = new Contrtext();
			contractX.setUuid("ContrtextDaoImpl的getList失败返回的uuid");
			ArrayList<Contrtext> contractListX = new ArrayList<Contrtext>();
			contractListX.add(contractX);
			return contractListX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return contractList;
	}

	@Override
	public Contrtext getOne(String uuid) {
		// TODO Auto-generated method stub
		Contrtext contractResult = new Contrtext();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_contrtext WHERE uuid ="
							+ "'" + uuid + "'");
			while (rs.next()) {
				Contrtext contract = new Contrtext();
				contract.setUuid(rs.getString("uuid"));
				contract.setcNum(rs.getString("cNum"));
				contract.setStuUuid(rs.getString("stuUuid"));
				contract.setcDate(rs.getString("cDate"));
				contract.setOrg(rs.getString("org"));
				contract.setTotalCount(rs.getString("totalCount"));
				contract.setTotalPrice(rs.getString("totalPrice"));
				contract.setSumLineUpA(rs.getInt("sumLineUpA"));
				contract.setSumLineDownB(rs.getInt("sumLineDownB"));
				contract.setOpenAndclose(rs.getString("openAndclose"));
				contract.setRemark(rs.getString("remark"));
				contract.setNameTcname(rs.getString("nameTcname"));
				contractResult = contract;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ContrtextDaoImpl的getByUuid查询失败");
			Contrtext contractX = new Contrtext();
			contractX.setUuid("ContrtextDaoImpl失败返回的uuid");
			return contractX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return contractResult;
	}

	@Override
	public Contrtext getByCnum(String cNum) {
		// TODO Auto-gContrtext contractResult = new Contrtext();
		Contrtext contractResult = new Contrtext();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_contrtext WHERE cNum ="
							+ "'" + cNum + "'");
			while (rs.next()) {
				Contrtext contract = new Contrtext();
				contract.setUuid(rs.getString("uuid"));
				contract.setcNum(rs.getString("cNum"));
				contract.setStuUuid(rs.getString("stuUuid"));
				contract.setcDate(rs.getString("cDate"));
				contract.setOrg(rs.getString("org"));
				contract.setTotalCount(rs.getString("totalCount"));
				contract.setTotalPrice(rs.getString("totalPrice"));
				contract.setSumLineUpA(rs.getInt("sumLineUpA"));
				contract.setSumLineDownB(rs.getInt("sumLineDownB"));
				contractResult = contract;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ContrtextDaoImpl的getByUuid查询失败");
			Contrtext contractX = new Contrtext();
			contractX.setUuid("ContrtextDaoImpl失败返回的uuid");
			return contractX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return contractResult;
	}

	@Override
	public boolean updateOnOff(String uuid, String oAc) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	       preparedStatement = connection
	          .prepareStatement("UPDATE t_contrtext SET openAndclose = ?  WHERE uuid = ? ");
	      // Parameters start with 1
	      preparedStatement.setString(1, oAc);
	      preparedStatement.setString(2, uuid);
	      preparedStatement.executeUpdate();

	      System.out.println("^^在执行ClassDaoImpl中的修改update");
	      daoFlag = true;
	      return daoFlag;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      System.out.println("^^在执行ClassDaoImpl中updateOnOff,出现sql语法执行错误，请联系管理员!");
	      daoFlag = false;
	      return daoFlag;
	    }finally{
	      ResultSet rs = null; 
	      DBUtility.close(rs, preparedStatement, connection);   
	     }//finally关闭jdbc与数据库连接 
	}//end method

}//end class
