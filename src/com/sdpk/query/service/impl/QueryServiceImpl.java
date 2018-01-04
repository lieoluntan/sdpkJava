package com.sdpk.query.service.impl;

import java.util.ArrayList;

import com.sdpk.dao.And_ClassEmpDao;
import com.sdpk.dao.ClassRoomDao;
import com.sdpk.dao.Class_ContractDao;
import com.sdpk.dao.ContractDao;
import com.sdpk.dao.CourseDao;
import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.impl.And_ClassEmpDaoImpl;
import com.sdpk.dao.impl.ClassRoomDaoImpl;
import com.sdpk.dao.impl.Class_ContractDaoImpl;
import com.sdpk.dao.impl.ContractDaoImpl;
import com.sdpk.dao.impl.CourseDaoImpl;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Course;
import com.sdpk.model.Employee;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.PaikeSearch;
import com.sdpk.query.dao.QueryDao;
import com.sdpk.query.dao.impl.QueryDaoImpl;
import com.sdpk.query.service.QueryService;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_EndTime;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-29 上午10:32:21
 * 
 */
public class QueryServiceImpl implements QueryService {
	private QueryDao queryDao = new QueryDaoImpl();
	private ClassRoomDao classRoomDao = new ClassRoomDaoImpl();
	private CourseDao courseDao = new CourseDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	private ContractDao contractDao = new ContractDaoImpl();
	private Class_ContractDao class_ContractDao = new Class_ContractDaoImpl();
	private And_ClassEmpDao and_ClassEmpDao = new And_ClassEmpDaoImpl();
	public M_msg m_msg = new M_msg();

	public M_msg getMsg() {
		// TODO Auto-generated method stub
		return m_msg;
	}

	@Override
	public ArrayList<PaikeRecordView> getAllPaike(PaikeSearch paikeSearch) {
		// TODO Auto-generated method stub
		ArrayList<PaikeRecordView> prvList = queryDao.getAllPaike(paikeSearch);
		// 步骤:记录课程名、员工名、教室名
		ArrayList<PaikeRecordView> reAddNameList = new ArrayList<PaikeRecordView>();
		for (PaikeRecordView one : prvList) {
			// 1、从基础表中找到课程名、员工名、教室名,保证基础表修改了名称，关联表也能知道
			String courUuid = one.getCourseUuid();
			String empUuid = one.getEmpUuid();
			String crUuid = one.getClassroomUuid();
			Course cour = courseDao.getByUuid(courUuid);
			Employee emp = employeeDao.getByUuid(empUuid);
			ClassRoom croom = classRoomDao.getByUuid(crUuid);

			String courName = cour.getName();
			String cageName = cour.getCategory();
			String empName = emp.getName();
			String croomName = croom.getName();

			one.setCourseName(courName);
			one.setEmpName(empName);
			one.setCroomName(croomName);
			one.setCategoryName(cageName);

			// 2、加入截止时间
			String keStartTime = one.getKeStartTime();
			String keLongTime = one.getKeLongTime();
			T_EndTime time = new T_EndTime();
			String keEndTime = time.getEndTime(keStartTime, keLongTime);
			one.setKeEndTime(keEndTime);

			reAddNameList.add(one);
		}// end 步骤
		// 步骤、加入班主任名
		for (PaikeRecordView one : reAddNameList) {
			// 1、加入班主任名
			String claUuid = one.getClaUuid();
			And_ClassEmp and_ClassEmp = and_ClassEmpDao.getBycla(claUuid);
			String claTeaUuid = and_ClassEmp.getEmpUuid();
			Employee claTea = employeeDao.getByUuid(claTeaUuid);
			String claTeaName = claTea.getName();
			one.setClaTeaUuid(claTeaUuid);
			one.setClaTeaName(claTeaName);

		}// end 步骤

		return reAddNameList;
	}

	@Override
	public int SumEmpPaike(PaikeSearch paikeSearch) {
		// TODO Auto-generated method stub
		return queryDao.SumEmpPaike(paikeSearch);
	}

	@Override
	public int SumDayBefore(PaikeSearch paikeSearch) {
		// TODO Auto-generated method stub
		return queryDao.SumDayBefore(paikeSearch);
	}

}
