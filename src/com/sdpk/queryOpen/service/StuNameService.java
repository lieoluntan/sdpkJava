package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.Cla;
import com.sdpk.model.Student;
import com.sdpk.utility.M_msg;

public interface StuNameService {
	public ArrayList<Student> getList();
	
	M_msg  getMsg();
}
