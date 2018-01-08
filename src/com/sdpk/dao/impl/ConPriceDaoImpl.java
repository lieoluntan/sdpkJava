package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.dao.ConPriceDao;
import com.sdpk.model.ConPrice;

import com.sdpk.utility.DBUtility;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:12:24
 * 
 */
public class ConPriceDaoImpl implements ConPriceDao {
	private Connection connection;
	boolean daoFlag = false;

	@Override
	public boolean insert(ConPrice conPrice) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null; // 关闭数据库连接insert和update和delete用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			preparedStatement = connection
					.prepareStatement("insert into t_conprice(uuid,contrUuid,onePriceA,countA,delPriceA,countGiveA,sumCountA,sumPriceA,priceType) values (?,?,?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, conPrice.getUuid());
			preparedStatement.setString(2, conPrice.getContrUuid());
			preparedStatement.setString(3, conPrice.getOnePriceA());
			preparedStatement.setString(4, conPrice.getCountA());
			preparedStatement.setString(5, conPrice.getDelPriceA());
			preparedStatement.setString(6, conPrice.getCountGiveA());
			preparedStatement.setString(7, conPrice.getSumCountA());
			preparedStatement.setString(8, conPrice.getSumPriceA());
			preparedStatement.setString(9, conPrice.getPriceType());

			preparedStatement.executeUpdate();

			System.out.println("^^在执行ConPriceDaoImpl中的添加insert");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			System.out
					.println("^^在执行ConPriceDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
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
					.prepareStatement("DELETE FROM t_conprice WHERE uuid = ? ");
			PSdelete.setString(1, uuid);
			PSdelete.executeUpdate();

			System.out.println("^^在执行ConPriceDaoImpl中的删除delete");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("^^在执行ConPriceDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, PSdelete, connection);
		}// finally关闭jdbc与数据库连接
	}

	@Override
	public boolean deleteByContrUuid(String contrUuid) {
		// TODO Auto-generated method stub
		PreparedStatement PSdelete = null; // 关闭数据库连接insert和update和delete用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			// Parameters start with 1
			PSdelete = connection
					.prepareStatement("DELETE FROM t_conprice WHERE contrUuid = ? ");
			PSdelete.setString(1, contrUuid);
			PSdelete.executeUpdate();

			System.out.println("^^在执行ConPriceDaoImpl中的删除delete");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("^^在执行ConPriceDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, PSdelete, connection);
		}// finally关闭jdbc与数据库连接
	}

	@Override
	public boolean update(ConPrice conPrice) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null; // 关闭数据库连接insert和update和delete用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			preparedStatement = connection
					.prepareStatement("UPDATE t_contprice SET contrUuid = ?, onePriceA = ?, countA = ?, delPriceA = ?, countGiveA = ?, sumCountA = ?,sumPriceA = ? ,priceType = ? WHERE uuid = ? ");
			preparedStatement.setString(1, conPrice.getContrUuid());
			preparedStatement.setString(2, conPrice.getOnePriceA());
			preparedStatement.setString(3, conPrice.getCountA());
			preparedStatement.setString(4, conPrice.getDelPriceA());
			preparedStatement.setString(5, conPrice.getCountGiveA());
			preparedStatement.setString(6, conPrice.getSumCountA());
			preparedStatement.setString(7, conPrice.getSumPriceA());
			preparedStatement.setString(8, conPrice.getPriceType());
			preparedStatement.setString(9, conPrice.getUuid());
			preparedStatement.executeUpdate();

			System.out.println("^^在执行ConPriceDaoImpl中的修改update");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("^^在执行ConPriceDaoImpl中update,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}// finally关闭jdbc与数据库连接
	}

	@Override
	public List<ConPrice> getList() {
		// TODO Auto-generated method stub
		ArrayList<ConPrice> contractList = new ArrayList<ConPrice>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_conprice");
			while (rs.next()) {
				ConPrice contract = new ConPrice();
				contract.setUuid(rs.getString("uuid"));
				contract.setContrUuid(rs.getString("contrUuid"));
				contract.setOnePriceA(rs.getString("onePriceA"));
				contract.setCountA(rs.getString("countA"));
				contract.setDelPriceA(rs.getString("delPriceA"));
				contract.setCountGiveA(rs.getString("countGiveA"));
				contract.setSumCountA(rs.getString("sumCountA"));
				contract.setSumPriceA(rs.getString("sumPriceA"));
				contract.setPriceType(rs.getString("priceType"));

				contractList.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ConPriceDaoImpl的getList查询失败");
			ConPrice contractX = new ConPrice();
			contractX.setUuid("ConPriceDaoImpl的getList失败返回的uuid");
			ArrayList<ConPrice> contractListX = new ArrayList<ConPrice>();
			contractListX.add(contractX);
			return contractListX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return contractList;
	}

	@Override
	public List<ConPrice> getByContrUuid(String contrUuid) {
		// TODO Auto-generated method stub
		ArrayList<ConPrice> contractList = new ArrayList<ConPrice>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_conprice where contrUuid='"+contrUuid+"'");
			while (rs.next()) {
				ConPrice contract = new ConPrice();
				contract.setUuid(rs.getString("uuid"));
				contract.setContrUuid(rs.getString("contrUuid"));
				contract.setOnePriceA(rs.getString("onePriceA"));
				contract.setCountA(rs.getString("countA"));
				contract.setDelPriceA(rs.getString("delPriceA"));
				contract.setCountGiveA(rs.getString("countGiveA"));
				contract.setSumCountA(rs.getString("sumCountA"));
				contract.setSumPriceA(rs.getString("sumPriceA"));
				contract.setPriceType(rs.getString("priceType"));

				contractList.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ConPriceDaoImpl的getList查询失败");
			ConPrice contractX = new ConPrice();
			contractX.setUuid("ConPriceDaoImpl的getList失败返回的uuid");
			ArrayList<ConPrice> contractListX = new ArrayList<ConPrice>();
			contractListX.add(contractX);
			return contractListX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return contractList;
	}

	@Override
	public ConPrice getOne(String uuid) {
		// TODO Auto-generated method stub
		ConPrice contract = new ConPrice();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_conprice where uuid='"+uuid+"'");
			while (rs.next()) {
				
				contract.setUuid(rs.getString("uuid"));
				contract.setContrUuid(rs.getString("contrUuid"));
				contract.setOnePriceA(rs.getString("onePriceA"));
				contract.setCountA(rs.getString("countA"));
				contract.setDelPriceA(rs.getString("delPriceA"));
				contract.setCountGiveA(rs.getString("countGiveA"));
				contract.setSumCountA(rs.getString("sumCountA"));
				contract.setSumPriceA(rs.getString("sumPriceA"));
				contract.setPriceType(rs.getString("priceType"));

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ConPriceDaoImpl的getList查询失败");
		
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return contract;
	}

}
