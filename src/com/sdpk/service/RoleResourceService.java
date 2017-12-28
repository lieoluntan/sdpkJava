package com.sdpk.service;

import java.util.List;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-27 上午11:15:47 角色资源业务
 */
public interface RoleResourceService {
/**
 * 
 * @param list 角色id的集合
 * @return list 存放资源id
 */
	List<String> getRsbyRoleid(List<String> list);
}
