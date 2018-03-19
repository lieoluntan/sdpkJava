package com.sdpk.queryOpen.service;

import java.util.ArrayList;

import com.sdpk.model.Cla;
import com.sdpk.utility.M_msg;

public interface ClaNameService {
	public ArrayList<Cla> getList();
	
	M_msg  getMsg();
}
