package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Contract;
import com.sdpk.model.Contrtext;
import com.sdpk.utility.M_msg;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:08:42
 * 
 */
public interface ContrtextService {

  String insert(Contrtext contrtext,String userUuid,String userName);

  ArrayList<Contrtext> getList();

  String delete(String uuid);

  // 原来的更新方法，没有做合同数量变化限制,暂时不用
  String update(Contrtext contrtext);

  // 新更新方法，有合同数量变化限制
  String updateLimit(Contrtext contrtext,String userUuid,String userName);

  Contrtext getByUuid(String uuid);

  public String getStuByName(Contrtext contract);

  public String getStuByName1(Contrtext contract);

  public String getonoff(Contrtext contrtext);

  public M_msg getMsg();
}
