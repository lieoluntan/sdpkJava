package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.StudentDao;
import com.sdpk.model.Course;
import com.sdpk.model.Student;
import com.sdpk.utility.DBUtility;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public class StudentDaoImpl implements StudentDao {

	private Connection connection;
	boolean daoFlag = false;

	public StudentDaoImpl() {
		// connection = DBUtility.getConnection();
		System.out.println("connection对象在StudentDaoImpl连接!");
	}

	@Override
	public boolean insert(Student stu) {
		System.out.println("进入");
System.out.println(stu.getName());
		connection = DBUtility.open();// 打开数据库连接
		PreparedStatement preparedStatement = null; // 关闭数据库连接insert和update和delete用到
		try {
			preparedStatement = connection
					.prepareStatement("insert into t_student(uuid,name,studentID,school,grade,phone,date,parentName,parentPhone,address,remark,sex,org,parentRela,parentName2,parentPhone2,parentRela2,openAndclose) "
							+ "	values (?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, stu.getUuid());
			preparedStatement.setString(2, stu.getName());
			preparedStatement.setString(3, stu.getStudentID());
			preparedStatement.setString(4, stu.getSchool());
			preparedStatement.setString(5, stu.getGrade());
			preparedStatement.setString(6, stu.getPhone());
			preparedStatement.setString(7, stu.getDate());
			preparedStatement.setString(8, stu.getParentName());
			preparedStatement.setString(9, stu.getParentPhone());
			preparedStatement.setString(10, stu.getAddress());
			preparedStatement.setString(11, stu.getRemark());

			preparedStatement.setString(12, stu.getSex());
			preparedStatement.setString(13, stu.getOrg());
			preparedStatement.setString(14, stu.getParentRela());
			preparedStatement.setString(15, stu.getParentName2());
			preparedStatement.setString(16, stu.getParentPhone2());
			preparedStatement.setString(17, stu.getParentRela2());
			preparedStatement.setString(18, "open");//新增统一为打开open
			preparedStatement.executeUpdate();

			System.out.println("^^在执行StudentDao中的insert添加");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {

			System.out.println("^^在执行StudentDao中insert,出现sql语法执行错误，请联系管理员!");
			e.printStackTrace();
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}// finally关闭jdbc与数据库连接
	}// end method insert

	@Override
	public boolean delete(String uuid) {
		// TODO Auto-generated method stub
		connection = DBUtility.open();// 打开数据库连接
		PreparedStatement PSdelete = null; // 关闭数据库连接insert和update和delete用到
		try {
			// Parameters start with 1
			PSdelete = connection
					.prepareStatement("DELETE FROM t_student WHERE uuid = ? ");
			PSdelete.setString(1, uuid);
			PSdelete.executeUpdate();

			System.out.println("^^在执行CourseDaoImpl中的删除delete");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("^^在执行StudentDao中delete,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, PSdelete, connection);
		}// finally关闭jdbc与数据库连接
	}// end method delete

	@Override
	public boolean update(Student student) {
		// TODO Auto-generated method stub
		connection = DBUtility.open();// 打开数据库连接
		PreparedStatement preparedStatement = null; // 关闭数据库连接insert和update和delete用到
		try {
			preparedStatement = connection
					.prepareStatement("UPDATE t_student SET name = ?, studentID = ?,school = ?, grade = ?, phone = ?, date = ?, parentName = ?, parentPhone = ?, address = ?, remark = ?,sex = ?,org = ?,parentRela = ?,parentName2 = ?,parentPhone2 = ? ,parentRela2 = ? WHERE uuid = ? ");
			// Parameters start with 1
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getStudentID());
			preparedStatement.setString(3, student.getSchool());
			preparedStatement.setString(4, student.getGrade());
			preparedStatement.setString(5, student.getPhone());
			preparedStatement.setString(6, student.getDate());
			preparedStatement.setString(7, student.getParentName());
			preparedStatement.setString(8, student.getParentPhone());
			preparedStatement.setString(9, student.getAddress());
			preparedStatement.setString(10, student.getRemark());

			preparedStatement.setString(11, student.getSex());
			preparedStatement.setString(12, student.getOrg());
			preparedStatement.setString(13, student.getParentRela());
			
			preparedStatement.setString(14, student.getParentName2());
			preparedStatement.setString(15, student.getParentPhone2());
			preparedStatement.setString(16, student.getParentRela2());
			
			preparedStatement.setString(17, student.getUuid());
			preparedStatement.executeUpdate();

			System.out.println("^^在执行CourseDaoImpl中的修改update");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("^^在执行StudentDao中update,出现sql语法执行错误，请联系管理员!");
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}// finally关闭jdbc与数据库连接
	}// end method update

	@Override
	public ArrayList<Student> getList() {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		connection = DBUtility.open();// 打开数据库连接
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT ts.*, te.`name` AS empName, (select max(recordDate) from t_record where stuUuid = ts.uuid) as recordDate FROM t_student ts left join t_class_stu tcs on ts.uuid = tcs.stuUuid left join t_class tc on tc.uuid = tcs.classUuid left join t_class_emp tce on tc.uuid = tce.classUuid left join t_employee te on te.uuid = tce.empUuid and te.claTeacher='true'");
			while (rs.next()) {
				Student student = new Student();
				student.setUuid(rs.getString("uuid"));
				student.setName(rs.getString("name"));
				student.setStudentID(rs.getString("studentID"));
				student.setSchool(rs.getString("school"));
				student.setGrade(rs.getString("grade"));
				student.setPhone(rs.getString("phone"));
				student.setDate(rs.getString("date"));
				student.setParentName(rs.getString("parentName"));
				student.setParentPhone(rs.getString("parentPhone"));
				student.setAddress(rs.getString("address"));
				student.setRemark(rs.getString("remark"));

				student.setSex(rs.getString("sex"));
				student.setOrg(rs.getString("org"));
				student.setParentRela(rs.getString("parentRela"));

				student.setParentName2(rs.getString("parentName2"));
				student.setParentPhone2(rs.getString("parentPhone2"));
				student.setParentRela2(rs.getString("parentRela2"));
				
				student.setRecordDate(rs.getString("recordDate"));
				student.setTempName(rs.getString("tempName"));
				
				student.setOpenAndclose(rs.getString("openAndclose"));

				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("StudentDaoImpl的getByUuid查询失败");
			Student studentX = new Student();
			studentX.setUuid("StudentDaoImpl的getList失败返回的uuid");
			ArrayList<Student> studentListX = new ArrayList<Student>();
			studentListX.add(studentX);
			return studentListX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return studentList;
	}// end method getListCourse

	@Override
	public Student getByUuid(String uuid) {
		// TODO Auto-generated method stub
		Student studentResult = new Student();
		connection = DBUtility.open();// 打开数据库连接
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_student WHERE uuid ="
					+ "'" + uuid + "'");
			while (rs.next()) {
				Student student = new Student();
				student.setUuid(rs.getString("uuid"));
				student.setName(rs.getString("name"));
				student.setStudentID(rs.getString("studentID"));
				student.setSchool(rs.getString("school"));
				student.setGrade(rs.getString("grade"));
				student.setPhone(rs.getString("phone"));
				student.setDate(rs.getString("date"));
				student.setParentName(rs.getString("parentName"));
				student.setParentPhone(rs.getString("parentPhone"));
				student.setAddress(rs.getString("address"));
				student.setRemark(rs.getString("remark"));

				student.setParentName2(rs.getString("parentName2"));
				student.setParentPhone2(rs.getString("parentPhone2"));
				student.setParentRela2(rs.getString("parentRela2"));

				studentResult = student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("StudentDaoImpl的getByUuid查询失败");
			Student studentX = new Student();
			studentX.setUuid("StudentDaoImpl失败返回的uuid");
			return studentX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return studentResult;
	}// end method getByUuid

	@Override
	public Student getStuByUuid(String uuid) {
		// TODO Auto-generated method stub
		Student studentResult = new Student();
		connection = DBUtility.open();// 打开数据库连接
		Statement statement = null;// finally关闭数据库连接
		ResultSet rs = null;// 关闭数据库连接get和getlist会用到
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery("select * from t_student WHERE uuid ="
					+ "'" + uuid + "'");
			while (rs.next()) {
				Student student = new Student();
				student.setUuid(rs.getString("uuid"));
				student.setName(rs.getString("name"));

				studentResult = student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("StudentDaoImpl的getByUuid查询失败");
			Student studentX = new Student();
			studentX.setUuid("StudentDaoImpl失败返回的uuid");
			return studentX;
		} finally {
			DBUtility.close(rs, statement, connection);
		}// finally关闭jdbc与数据库连接

		return studentResult;
	}

	@Override
	public boolean updateOnOff(String uuid, String oAc) {
		// TODO Auto-generated method stub
		 PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
		    try {
		      connection = DBUtility.open();//打开数据库连接
		       preparedStatement = connection
		          .prepareStatement("UPDATE t_student SET openAndclose = ?  WHERE uuid = ? ");
		      // Parameters start with 1
		      preparedStatement.setString(1, oAc);
		      preparedStatement.setString(2, uuid);
		      preparedStatement.executeUpdate();

		      System.out.println("^^在执行StudentDaoImpl中的修改update");
		      daoFlag = true;
		      return daoFlag;
		    } catch (SQLException e) {
		      e.printStackTrace();
		      System.out.println("^^在执行StudentDaoImpl中updateOnOff,出现sql语法执行错误，请联系管理员!");
		      daoFlag = false;
		      return daoFlag;
		    }finally{
		      ResultSet rs = null; 
		      DBUtility.close(rs, preparedStatement, connection);   
		     }//finally关闭jdbc与数据库连接 
	}//end method

}// end class StudentDaoImpl
