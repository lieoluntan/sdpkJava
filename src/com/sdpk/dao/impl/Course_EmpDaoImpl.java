package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.Course_EmpDao;
import com.sdpk.model.And_ClassCourse;
import com.sdpk.model.Course_Emp;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午6:00:02
 * 类说明
 */

public class Course_EmpDaoImpl implements Course_EmpDao{
  
  private Connection connection;
  boolean daoFlag = false;
  
  public Course_EmpDaoImpl() {
//    connection = DBUtility.open();
    System.out.println("connection对象在ClaDaoImpl连接!");
  }

  @Override
  public ArrayList<Course_Emp> getListBycourse(String courseUuid) {
    // TODO Auto-generated method stub
    ArrayList<Course_Emp> reList = new ArrayList<Course_Emp>();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_course_emp WHERE courseUuid ="+"'"+courseUuid+"'");
        while (rs.next()) {
          Course_Emp course_Emp = new Course_Emp();
          course_Emp.setUuid(rs.getString("uuid"));
          course_Emp.setCourseUuid(rs.getString("courseUuid")); 
          course_Emp.setEmpUuid(rs.getString("empUuid"));
          
          reList.add(course_Emp);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Course_EmpDaoImpl的getListBycla查询失败");
        Course_Emp errOne = new Course_Emp();
        errOne.setUuid("Course_EmpDaoImpl的getListBycla失败返回的uuid");
        ArrayList<Course_Emp> errList = new ArrayList<Course_Emp>();
        errList.add(errOne);
        return errList;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接

  }//emd method getListBycla

  @Override
  public boolean insert(Course_Emp course_Emp) {
    // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("insert into t_course_emp(uuid,courseUuid,courseName,empUuid,empName) values (?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, course_Emp.getUuid());
      preparedStatement.setString(2, course_Emp.getCourseUuid());
      preparedStatement.setString(3, course_Emp.getCourseName());
      preparedStatement.setString(4, course_Emp.getEmpUuid());
      preparedStatement.setString(5, course_Emp.getEmpName());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行course_EmpDaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行course_EmpDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接  
  }// edn method insert

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    PreparedStatement PSdelete = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
      // Parameters start with 1
       PSdelete = connection
          .prepareStatement("DELETE FROM t_course_emp WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行course_EmpDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行course_EmpDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method delete

  @Override
  public boolean deleteByCour(String courseUuid) {
    // TODO Auto-generated method stub
    PreparedStatement PSdelete = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
      // Parameters start with 1
       PSdelete = connection
          .prepareStatement("DELETE FROM t_course_emp WHERE courseUuid = ? ");
      PSdelete.setString(1, courseUuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行course_EmpDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行course_EmpDaoImpl中deleteByCour,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method delete

  @Override
  public ArrayList<Course_Emp> getListByEmp(String empUuid) {
    // TODO Auto-generated method stub
    ArrayList<Course_Emp> reList = new ArrayList<Course_Emp>();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_course_emp WHERE empUuid ="+"'"+empUuid+"'");
        while (rs.next()) {
          Course_Emp course_Emp = new Course_Emp();
          course_Emp.setUuid(rs.getString("uuid"));
          course_Emp.setCourseUuid(rs.getString("courseUuid")); 
          course_Emp.setEmpUuid(rs.getString("empUuid"));
          
          reList.add(course_Emp);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Course_EmpDaoImpl的getListBycla查询失败");
        Course_Emp errOne = new Course_Emp();
        errOne.setUuid("Course_EmpDaoImpl的getListBycla失败返回的uuid");
        ArrayList<Course_Emp> errList = new ArrayList<Course_Emp>();
        errList.add(errOne);
        return errList;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接  

  }//emd method getListBycla

}//end class
