package com.sdpk.queryOpen.dao;
/**
 *树袋老师
 * @author 作者 罗浩
 * @version 创建时间：2018-03-23 
 * 类说明
 */
import java.util.ArrayList;
import java.util.List;

import com.sdpk.model.Record;


public interface RecordDao {
	//新增
	public boolean insert(Record record);

	// 删除
	public boolean delete(String uuid);

	// 根据ditchUuid删除
	public boolean deleteByDitchUuid(String ditchUuid);

	// 修改
	public boolean update(Record record);

	// 单个查询
	public Record getByUuid(String uuid);

	// 列表查询
	public ArrayList<Record> getList();

	// 根据ditchUuid查询
	public ArrayList<Record> getListstuUuid(String stuUuid);

	// 设置开关
	public boolean updateOnOff(String uuid, String oac);
	
	//根据ID查询
    Record findIdShow(String uuid);
}
