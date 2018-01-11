package com.sdpk.query.nameQuery.dao;

import java.util.List;

import com.sdpk.model.Cla;
import com.sdpk.model.Course;
/**
 * 
 * @author 罗成峰
 * @date 2018-1-11下午2:42:52
 * @version 1.0
 */
public interface NameReCourDao {

	public List<Course> getCourByName(Course cour);
}
