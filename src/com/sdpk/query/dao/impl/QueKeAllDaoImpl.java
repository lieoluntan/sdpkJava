package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.query.dao.QueKeAllDao;
import com.sdpk.utility.DBUtility;

/**
 * 
 * @author 谢平平
 * @date 2018-1-14上午11:51:55
 * @version 1.0
 */
public class QueKeAllDaoImpl implements QueKeAllDao{
	
	private Connection connection;
	boolean dao = false;
	
	
	
	
	public QueKeAllDaoImpl() {
		System.out.println("connection对象在QueKeAllDaoImpl连接!");
	}




	@Override
	public ArrayList<PaikeRecordView> getList() {
		// TODO Auto-generated method stub
		ArrayList<PaikeRecordView> paikeRecordList = new ArrayList<PaikeRecordView>();
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {
			connection = DBUtility.open();// 打开数据库连接
			statement = connection.createStatement();
			rs = statement
					.executeQuery("select * from t_paike_all");
			while (rs.next()) {
				PaikeRecordView paikeRecord = new PaikeRecordView();
				paikeRecord.setUuid(rs.getString("uuid"));
				paikeRecord.setClaUuid(rs.getString("claUuid"));
				paikeRecord.setCourseUuid(rs.getString("courseUuid"));
				paikeRecord.setEmpUuid(rs.getString("empUuid"));
				paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
				paikeRecord.setKeDateTime(rs.getString("keDateTime"));
				paikeRecord.setKeStartTime(rs.getString("keStartTime"));
				paikeRecord.setKeLongTime(rs.getString("keLongTime"));
				paikeRecord.setStatus(rs.getString("status"));
				paikeRecord.setWeekSome(rs.getString("weekSome"));
				paikeRecord.setPkType(rs.getString("pkType"));
				paikeRecord.setPkTypeName(rs.getString("pkTypeName"));
				paikeRecord.setClaName(rs.getString("claName"));
				paikeRecordList.add(paikeRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("PaikeRecordDaoImpl的getList查询失败");
			PaikeRecordView paikeRecordX = new PaikeRecordView();
			paikeRecordX.setUuid("PaikeRecordDaoImpl的getList失败返回的uuid");
			ArrayList<PaikeRecordView> errListX = new ArrayList<PaikeRecordView>();
			errListX.add(paikeRecordX);
			return errListX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return paikeRecordList;
	}// end method getListByclaUuid




  @Override
  public ArrayList<PaikeRecordView> getListSpeed() {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecordView> paikeRecordList = new ArrayList<PaikeRecordView>();
    Statement statement = null;// finally关闭数据库连接
    ResultSet rs = null;// 关闭数据库连接get和getlist会用到
    try {
        connection = DBUtility.open();// 打开数据库连接
        statement = connection.createStatement();
        rs = statement
                .executeQuery("SELECT t_class.name AS claNameBiao,t_paike_all.* FROM t_class,t_paike_all WHERE t_class.uuid = t_paike_all.claUuid;");
        while (rs.next()) {
            PaikeRecordView paikeRecord = new PaikeRecordView();
            paikeRecord.setUuid(rs.getString("uuid"));
            paikeRecord.setClaUuid(rs.getString("claUuid"));
            paikeRecord.setCourseUuid(rs.getString("courseUuid"));
            paikeRecord.setEmpUuid(rs.getString("empUuid"));
            paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
            paikeRecord.setKeDateTime(rs.getString("keDateTime"));
            paikeRecord.setKeStartTime(rs.getString("keStartTime"));
            paikeRecord.setKeLongTime(rs.getString("keLongTime"));
            paikeRecord.setStatus(rs.getString("status"));
            paikeRecord.setWeekSome(rs.getString("weekSome"));
            paikeRecord.setPkType(rs.getString("pkType"));
            paikeRecord.setPkTypeName(rs.getString("pkTypeName"));
            paikeRecord.setClaName(rs.getString("claNameBiao"));
            paikeRecord.setCourseName(rs.getString("courseName"));
            paikeRecord.setEmpName(rs.getString("empName"));
            paikeRecord.setCroomName(rs.getString("croomName"));
            
            paikeRecordList.add(paikeRecord);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("PaikeRecordDaoImpl的getList查询失败");
        PaikeRecordView paikeRecordX = new PaikeRecordView();
        paikeRecordX.setUuid("PaikeRecordDaoImpl的getList失败返回的uuid");
        ArrayList<PaikeRecordView> errListX = new ArrayList<PaikeRecordView>();
        errListX.add(paikeRecordX);
        return errListX;
    } finally {
        DBUtility.close(rs, statement, connection);
    }// finally关闭jdbc与数据库连接

    return paikeRecordList;
  }//end method
  
  
  //实时查询所有t_paike_all所有记录，关联5个基本表:排课表、班级表、课程表、授课老师表、教室表
  @Override
  public ArrayList<PaikeRecordView> getListSpeed5Biao() {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecordView> paikeRecordList = new ArrayList<PaikeRecordView>();
    Statement statement = null;// finally关闭数据库连接
    ResultSet rs = null;// 关闭数据库连接get和getlist会用到
    try {
        connection = DBUtility.open();// 打开数据库连接
        statement = connection.createStatement();
        rs = statement
                .executeQuery("SELECT t_class.name AS claNameBiao,t_paike_all.*,t_course.name AS courNameBiao,t_employee.name AS empNameBiao,t_classroom.name AS croomNameBiao FROM t_class,t_paike_all,t_course,t_employee,t_classroom WHERE t_class.uuid = t_paike_all.claUuid AND t_course.uuid=t_paike_all.courseUuid AND t_employee.uuid=t_paike_all.empUuid AND t_classroom.uuid=t_paike_all.classroomUuid;");
        while (rs.next()) {
            PaikeRecordView paikeRecord = new PaikeRecordView();
            paikeRecord.setUuid(rs.getString("uuid"));
            paikeRecord.setClaUuid(rs.getString("claUuid"));
            paikeRecord.setCourseUuid(rs.getString("courseUuid"));
            paikeRecord.setEmpUuid(rs.getString("empUuid"));
            paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
            paikeRecord.setKeDateTime(rs.getString("keDateTime"));
            paikeRecord.setKeStartTime(rs.getString("keStartTime"));
            paikeRecord.setKeLongTime(rs.getString("keLongTime"));
            paikeRecord.setStatus(rs.getString("status"));
            paikeRecord.setWeekSome(rs.getString("weekSome"));
            paikeRecord.setPkType(rs.getString("pkType"));
            paikeRecord.setPkTypeName(rs.getString("pkTypeName"));
            
            paikeRecord.setClaName(rs.getString("claNameBiao"));
            paikeRecord.setCourseName(rs.getString("courNameBiao"));
            paikeRecord.setEmpName(rs.getString("empNameBiao"));
            paikeRecord.setCroomName(rs.getString("croomNameBiao"));
            
            paikeRecordList.add(paikeRecord);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("PaikeRecordDaoImpl的getList查询失败");
        PaikeRecordView paikeRecordX = new PaikeRecordView();
        paikeRecordX.setUuid("PaikeRecordDaoImpl的getList失败返回的uuid");
        ArrayList<PaikeRecordView> errListX = new ArrayList<PaikeRecordView>();
        errListX.add(paikeRecordX);
        return errListX;
    } finally {
        DBUtility.close(rs, statement, connection);
    }// finally关闭jdbc与数据库连接

    return paikeRecordList;
  }//end method




  @Override
  public ArrayList<PaikeRecordView> getMonpaikeSpeed(String year, String month, String today) {
    // TODO Auto-generated method stub
    String sd = "";// 月初
    String sf = "";// 月末

    String d = year + "-" + month + "-" + "1";
    String[] s = d.split("-");
    s[0] += "-";
    s[1] += "-";
    s[2] = "01";
    for (String string : s) {
        sd += string;
    }
    s[2] = "31";
    for (String string : s) {
        sf += string;
    }

    ArrayList<PaikeRecordView> empPaikeList = new ArrayList<PaikeRecordView>();// 老师本月的所有排课集合
    Statement statement = null;// finally关闭数据库连接
    ResultSet rs = null;// 关闭数据库连接get和getlist会用到
    try {
        connection = DBUtility.open();// 打开数据库连接
        statement = connection.createStatement();
        rs = statement
                .executeQuery("SELECT t_class.name AS claNameBiao,t_paike_all.* FROM t_class,t_paike_all WHERE t_class.uuid = t_paike_all.claUuid and t_paike_all.KeDateTime >='"
                        + sd + "' and t_paike_all.KeDateTime <='" + sf + "'");
        while (rs.next()) {
            PaikeRecordView paikeRecord = new PaikeRecordView();

            paikeRecord.setUuid(rs.getString("uuid"));
            paikeRecord.setClaUuid(rs.getString("claUuid"));
            paikeRecord.setCourseUuid(rs.getString("courseUuid"));
            paikeRecord.setEmpUuid(rs.getString("empUuid"));
            paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
            paikeRecord.setKeDateTime(rs.getString("keDateTime"));
            paikeRecord.setKeStartTime(rs.getString("keStartTime"));
            paikeRecord.setKeLongTime(rs.getString("keLongTime"));
            paikeRecord.setStatus(rs.getString("status"));
            paikeRecord.setWeekSome(rs.getString("weekSome"));
            paikeRecord.setPkType(rs.getString("pkType"));
            paikeRecord.setPkTypeName(rs.getString("pkTypeName"));
            
            paikeRecord.setClaName(rs.getString("claNameBiao"));
            paikeRecord.setCourseName(rs.getString("courseName"));
            paikeRecord.setEmpName(rs.getString("empName"));
            paikeRecord.setCroomName(rs.getString("croomName"));
            
            empPaikeList.add(paikeRecord);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ResourceDaoImpl的getByUuid查询失败");

    } finally {
        DBUtility.close(rs, statement, connection);
    }// finally关闭jdbc与数据库连接

    return empPaikeList;
  }//end method

}//end class
