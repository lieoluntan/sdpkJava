package com.sdpk.utility;

import java.util.Map;

import com.sdpk.model.And_ClassCourse;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.And_ClassStu;
import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Class_Contract;
import com.sdpk.model.Contract;
import com.sdpk.model.Course;
import com.sdpk.model.Course_Emp;
import com.sdpk.model.Employee;
import com.sdpk.model.Student;
import com.sdpk.model.UserPK;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午1:42:03 类说明
 */

public class T_DataMap2Bean {

  public Cla MapToCla(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String org = (String) map.get("org");
    String name = (String) map.get("name");
    String empUuid = (String) map.get("empUuid");
    String classDate = (String) map.get("classDate");
    String status = (String) map.get("status");
    String remark = (String) map.get("remark");
    String claNum = (String) map.get("claNum");
    

    Cla cla = new Cla(uuid, org, name, empUuid, classDate, status, remark);
    cla.setClaNum(claNum);
    
    return cla;
  }// end method MapToEmp

  public ClassRoom MapToClassRoom(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String name = (String) map.get("name");
    String campus = (String) map.get("campus");
    String remark = (String) map.get("remark");

    ClassRoom classRoom = new ClassRoom(uuid, name, campus, remark);
    return classRoom;
  }// end method MapToEmp

  public Employee MapToEmp(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");
    String name = (String) map.get("name");
    String empNum = (String) map.get("empNum");
    String phone = (String) map.get("phone");
    String depart = (String) map.get("depart");
    String job = (String) map.get("job");
    String permissionTempl = (String) map.get("permissionTempl");
    String remark = (String) map.get("remark");
    
    String claTeacher = (String) map.get("claTeacher");//11月15新增字段
    String sex = (String) map.get("sex"); 
    String org = (String) map.get("org");
    String workDate = (String) map.get("workDate");
    String fullhalf = (String) map.get("fullhalf");
    String jobRemark = (String) map.get("jobRemark");
    
    Employee emp = new Employee(uuid, name, empNum, phone, depart, job, permissionTempl,
        remark);
    emp.setClaTeacher(claTeacher);//11月15新增字段
    emp.setSex(sex);
    emp.setOrg(org);
    emp.setWorkDate(workDate);
    emp.setFullhalf(fullhalf);
    emp.setJobRemark(jobRemark);
    
    return emp;
  }// end method MapToEmp

  public Course MapToCourse(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String name = (String) map.get("name");
    String category = (String) map.get("category");
    String describe = (String) map.get("describe");
    String org = (String) map.get("org");

    Course course = new Course(uuid, name, category, describe);
    course.setOrg(org);
    
    return course;
  }// end method MapToEmp

  public Student MapToStudent(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String name = (String) map.get("name");
    String studentID = (String) map.get("studentID");
    String school = (String) map.get("school");
    String grade = (String) map.get("grade");
    String phone = (String) map.get("phone");
    String date = (String) map.get("date");
    String parentName = (String) map.get("parentName");
    String parentPhone = (String) map.get("parentPhone");
    String address = (String) map.get("address");
    String remark = (String) map.get("remark");
    
    String sex = (String) map.get("sex");
    String org = (String) map.get("org");
    String parentRela = (String) map.get("parentRela");

    Student stu = new Student(uuid, name, studentID, school, grade, phone, date, parentName,
        parentPhone, address, remark);
    stu.setSex(sex);
    stu.setOrg(org);
    stu.setParentRela(parentRela);
    return stu;
  }// end method MapToStudent

  public Contract MapToContract(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String cNum = (String) map.get("cNum");
    String stuUuid = (String) map.get("stuUuid");
    String cDate = (String) map.get("cDate");
    String org = (String) map.get("org");
    String totalCount = (String) map.get("totalCount");
    String totalPrice = (String) map.get("totalPrice");

    String onePriceA = (String) map.get("onePriceA");
    String countA = (String) map.get("countA");
    String delPriceA = (String) map.get("delPriceA");
    String countGiveA = (String) map.get("countGiveA");
    String sumCountA = (String) map.get("sumCountA");
    String sumPriceA = (String) map.get("sumPriceA");

    String onePriceB = (String) map.get("onePriceB");
    String countB = (String) map.get("countB");
    String delPriceB = (String) map.get("delPriceB");
    String countGiveB = (String) map.get("countGiveB");
    String sumCountB = (String) map.get("sumCountB");
    String sumPriceB = (String) map.get("sumPriceB");

    Contract contract = new Contract(uuid, cNum, stuUuid, cDate, org, totalCount, totalPrice,
        onePriceA, countA, delPriceA, countGiveA, sumCountA, sumPriceA, onePriceB, countB,
        delPriceB, countGiveB, sumCountB, sumPriceB);
    return contract;
  }// end method MapToEmp
  
  public And_ClassEmp MapToAnd_ClassEmp(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String classUuid = (String) map.get("classUuid");
    String empUuid = (String) map.get("empUuid");

    And_ClassEmp and_ClassEmp = new And_ClassEmp(uuid,classUuid, empUuid);
    return and_ClassEmp;
  }// end method MapToAnd_ClassEmp

  public And_ClassStu MapToAnd_ClassStu(Map<String, Object> map) {
    
    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String classUuid = (String) map.get("classUuid");
    String stuUuid = (String) map.get("stuUuid");

    And_ClassStu and_ClassStu = new And_ClassStu(uuid,classUuid, stuUuid);
    return and_ClassStu;
  }// end method MapToAnd_ClassStu

  public And_ClassCourse MapToAnd_ClassCourse(Map<String, Object> map) {
    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String classUuid = (String) map.get("classUuid");
    String courseUuid = (String) map.get("courseUuid");

    And_ClassCourse and_ClassCourse = new And_ClassCourse(uuid,classUuid, courseUuid);
    return and_ClassCourse;
  }// end method MapToAnd_ClassCourse

  public Course_Emp MapToCourse_Emp(Map<String, Object> map) {
    // TODO Auto-generated method stub
    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String courseUuid = (String) map.get("courseUuid");
    String empUuid = (String) map.get("empUuid");

    Course_Emp course_Emp = new Course_Emp(uuid, courseUuid,empUuid);
    return course_Emp;
  }// end method MapToAnd_ClassCourse

  public Class_Contract MapToClass_Contract(Map<String, Object> map) {
    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String classUuid = (String) map.get("classUuid");
    String contrUuid = (String) map.get("contrUuid");

    Class_Contract class_Contract = new Class_Contract(uuid,classUuid, contrUuid);
    return class_Contract;
  }// end method 

  public UserPK MapToUserPK(Map<String, Object> map) {
    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String uLogUser = (String) map.get("uLogUser");
    String uPassWord = (String) map.get("uPassWord");
    String uName = (String) map.get("uName");
    
    UserPK userPK = new UserPK(uuid, uLogUser, uPassWord, uName);
    return userPK;
  }// end method MapToEmp

}// end class T_DataMap2Bean
