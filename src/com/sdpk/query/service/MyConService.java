package com.sdpk.query.service;

import java.util.List;

import com.sdpk.model.Contract;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-3 上午11:04:08
 *
 */
public interface MyConService {

	/**
	 * 
	 * @param empUuid 
	 * @return 所有班级id的集合
	 *   根据empUuid在班级员工表中查出所有班级id
	 */
	List<Contract> getClaId(String empUuid);
	/**
	 * 
	 * @param ClsaaIdList
	 * @return 所有学员的id集合
	 *   根据班级id查出所有的学员id
	 */
	List<String> getConId(List<String> ClsaaIdList);
	/**
	 * 
	 * @param uuid
	 * @return  所有的学生集合
	 *    根据学生id查询学生
	 */
	List<Contract> getConList(List<String> ConIdList);
}
