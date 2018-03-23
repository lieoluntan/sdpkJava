package com.sdpk.queryOpen.dao;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
public interface StuKeXiaoDao {
    List<String> getClaidByStuId(String uuid);//根据学生id查出他有哪些班级
	
	ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch); 
	
	int SumDayBefore(PaikeSearch paikeSearch);

	ArrayList<PaikeRecordView> getAllPaike1(PaikeSearch paikeSearch);

	int SumDayBefore1(PaikeSearch paikeSearch);
}
