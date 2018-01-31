package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Contract;
import com.sdpk.model.Contrtext;
import com.sdpk.query.dao.MyContrtextDao;
import com.sdpk.utility.DBUtility;

/**
 * 
 * @author xpp
 * @date 2018-1-24上午11:51:55
 * @version 1.0
 */
public class MyContrtextDaoImpl implements MyContrtextDao{
	
	private Connection connection;
	boolean daoFlag = false;

	@Override
	public List<String> getClaId(String empUuid) {
		// TODO Auto-generated method stub
		List<String> ClassIdList = new ArrayList<String>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_class_emp WHERE empUuid ="
							+ "'" + empUuid + "'");
			while (rs.next()) {
				String classUuid = rs.getString("classUuid");
				ClassIdList.add(classUuid);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return ClassIdList;
	}//end method

	@Override
	public List<String> getConId(String classId) {
		// TODO Auto-generated method stub
		List<String> ConIdList = new ArrayList<String>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_class_contract WHERE classUuid ="
							+ "'" + classId + "'");
			while (rs.next()) {
				String contrUuid = rs.getString("contrUuid");
				ConIdList.add(contrUuid);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ClassRoomDaoImpl的getByUuid查询失败");

		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return ConIdList;
	}//end method
	
	
	//--------------分割线，以上方法是查我的合同，以下方法是提升所有合同的速度查询方法

      @Override
      public ArrayList<Contrtext> getAllSpeedList() {
        // TODO Auto-generated method stub
        ArrayList<Contrtext> contractList = new ArrayList<Contrtext>();
        Statement statement = null;// finally关闭数据库连接
        ResultSet rs = null;// 关闭数据库连接get和getlist会用到
        try {
            connection = DBUtility.open();// 打开数据库连接
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT t_student.name AS stuName,t_contrtext.* FROM t_student,t_contrtext WHERE t_student.uuid = t_contrtext.stuUuid;");
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
                contract.setStuName(rs.getString("stuName"));
                
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
      }//end method

	

}//end class
