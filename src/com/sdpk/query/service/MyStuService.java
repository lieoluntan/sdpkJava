package com.sdpk.query.service;

import java.util.List;


import com.sdpk.model.Student;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-2 下午3:39:40
 *
 */
public interface MyStuService {
	/**
	 * 
	 * @param empUuid 
	 * @return 所有班级id的集合
	 *   根据empUuid在班级员工表中查出所有班级id
	 */
	List<Student> getClaId(String empUuid);
	/**
	 * 
	 * @param ClsaaIdList
	 * @return 所有学员的id集合
	 *   根据班级id查出所有的学员id
	 */
	List<String> getStuId(List<String> ClsaaIdList);
	/**
	 * 
	 * @param uuid
	 * @return  所有的学生集合
	 *    根据学生id查询学生
	 */
	List<Student> getStuList(List<String> StuIdList);
}
