package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.Student;

/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public interface StudentDao {

  public boolean insert(Student stu);

  public boolean delete(String uuid);

  public boolean update(Student student);

  public ArrayList<Student> getList();

  public Student getByUuid(String uuid);

  public Student getStuByUuid(String uuid);//只要学生的id和name

public boolean updateOnOff(String uuid, String oAc);
}
