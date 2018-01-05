package com.sdpk.query.nameQuery.service;

import java.util.ArrayList;

import com.sdpk.model.Student;

/**
 * 
 * @author 罗成峰
 * @date 2018-1-5下午3:46:46
 * @version 1.0
 */
public interface NameReClaService {

	ArrayList<Student>getListbyName(String name);
}
