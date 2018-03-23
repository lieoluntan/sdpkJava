package com.sdpk.queryOpen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.model.Student;
import com.sdpk.queryOpen.dao.StudentIDDao;
import com.sdpk.utility.DBUtility;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public class StudentIDDaoImpl implements StudentIDDao{
	
	private Connection connection;
	  boolean daoFlag = false;

	  public StudentIDDaoImpl() {
//	    connection = DBUtility.open();
	    System.out.println("connection对象在StudentIDDaoImpl连接!");
	  }
	
	@Override
	public int findMaxIdShow() {
		// TODO Auto-generated method stub
		ArrayList<Student> stuList = new ArrayList<Student>();
	    Statement statement = null;//finally关闭数据库连接  
	    ResultSet rs = null;//关闭数据库连接get和getlist会用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	         statement = connection.createStatement();
	         rs = statement.executeQuery("SELECT t_student.studentID  from t_student where studentID <> '无' ORDER BY studentID DESC LIMIT 0,1");
	        while (rs.next()) {
	        	Student student = new Student();
	        	student.setStudentID(rs.getString("studentID"));
	        	stuList.add(student);
	        }
	        
	        return Integer.parseInt(stuList.get(0).getStudentID());
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("getList查询失败");
	        Student stu = new Student();
	        stu.setUuid("StudentIDDaoImpl的findIdShow查询失败");
	        ArrayList<Student> XList = new ArrayList<Student>();
	        XList.add(stu);
	        return 0;
	    }catch (Exception e){
	        e.printStackTrace();
	        System.out.println("getList查询失败");
	        Student stu = new Student();
	        stu.setUuid("YXstudentDaoImpl的findIdShow查询失败");
	        ArrayList<Student> XList = new ArrayList<Student>();
	        XList.add(stu);
	        return 0;
	    }finally{   
	      DBUtility.close(rs, statement, connection);   
	     }//finally关闭jdbc与数据库连接
	}

	@Override
	public boolean updateStuId(String StuId,String uuid,String name) {
		// TODO Auto-generated method stub
		connection = DBUtility.open();// 打开数据库连接
		PreparedStatement preparedStatement = null; // 关闭数据库连接insert和update和delete用到
		try {
			preparedStatement = connection
					.prepareStatement("update t_student SET studentID=?,nameTyxname=?  WHERE uuid = ? ");
			// Parameters start with 1
			preparedStatement.setString(1, StuId);
			preparedStatement.setString(2, "STU"+StuId+name);
			preparedStatement.setString(3, uuid);
			preparedStatement.executeUpdate();

			System.out.println("^^在执行StudentIDDaoImpl中的修改update");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("^^在执行StudentIDDaoImpl中update,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}// finally关闭jdbc与数据库连接
	}// end method update

	@Override
	public Student findId(String id) {
		// TODO Auto-generated method stub
		Student stuResult = new Student();
	    Statement statement = null;//finally关闭数据库连接  
	    ResultSet rs = null;//关闭数据库连接get和getlist会用到
	    try {
	      connection = DBUtility.open();//打开数据库连接
	         statement = connection.createStatement();
	         rs = statement.executeQuery("select * from t_student where studentID="+id+"");
	        while (rs.next()) {
	          Student student = new Student();
	          student.setStudentID(rs.getString("studentID"));
	          stuResult=student;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("StudentIDDaoImpl的findId查询失败");
	        Student S = new Student();
	        S.setUuid("StudentIDDaoImpl的findId失败返回的uuid");
	        return S;
	    }finally{   
	      DBUtility.close(rs, statement, connection);   
	     }//finally关闭jdbc与数据库连接  

	    System.out.println("dao返回的student根据getbyuuid"+stuResult);
	    return stuResult;
	}

}
