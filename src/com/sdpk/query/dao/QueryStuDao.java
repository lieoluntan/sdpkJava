package com.sdpk.query.dao;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;

/**
 * 
 *树袋老师
 * @author xuerenjie
 * @version 创建时间：2018-1-3 下午3:51:45
 *
 */
public interface QueryStuDao {
	
	List<String> getClaidByStuId(String uuid);//根据学生id查出他有哪些班级
	
	ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch); 
	
	
	
	int SumDayBefore(PaikeSearch paikeSearch);

}
