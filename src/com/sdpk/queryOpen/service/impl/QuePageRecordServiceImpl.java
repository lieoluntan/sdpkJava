package com.sdpk.queryOpen.service.impl;

import java.util.ArrayList;

import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.Record;
import com.sdpk.model.Student;
import com.sdpk.queryOpen.dao.QuePageRecordDao;
import com.sdpk.queryOpen.dao.impl.QuePageRecordDaoImpl;
import com.sdpk.queryOpen.service.QuePageRecordService;

public class QuePageRecordServiceImpl implements QuePageRecordService{
	
	 QuePageRecordDao quePageRecordDao = new QuePageRecordDaoImpl();
	 StudentDao stuDao = new StudentDaoImpl();
	@Override
	public ArrayList<Record> pageBystuUid(String stuUid, int currentPage,int maxResult) {
		// TODO Auto-generated method stub
	    if (stuUid != null && stuUid != "" && currentPage > 0
	            && maxResult > 0) {
	        ArrayList<Record> recordcList = quePageRecordDao.pageBystuUid(stuUid,currentPage, maxResult);
	        Student student = stuDao.getByUuid(stuUid);
	        String name = student.getName();
	        for (int i = 0; i < recordcList.size(); i++) {
	          recordcList.get(i).setStuName(name);
	        }
	        return recordcList;
	    } else {
	        ArrayList<Record> list = new ArrayList<Record>();
	        Record record = new Record();
	        record.setUuid("传入数据有问题,请检查");
	        list.add(record);
	        System.out
	                .println("QuePageRecordServiceImpl中的getPageByDitchUuid方法传入的数据有问题,请联系管理员");
	        return list;
	    }
	}



}
