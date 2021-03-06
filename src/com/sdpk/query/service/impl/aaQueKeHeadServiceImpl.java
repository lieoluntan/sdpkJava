package com.sdpk.query.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sdpk.dao.And_ClassEmpDao;
import com.sdpk.dao.ClassRoomDao;
import com.sdpk.dao.CourseDao;
import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.And_ClassEmpDaoImpl;
import com.sdpk.dao.impl.ClassRoomDaoImpl;
import com.sdpk.dao.impl.CourseDaoImpl;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Course;
import com.sdpk.model.Employee;
import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordView;
import com.sdpk.model.Student;
import com.sdpk.query.dao.aaQueKeHeadDao;
import com.sdpk.query.dao.impl.aaQueKeHeadDaoImpl;
import com.sdpk.query.service.aaQueKeHeadService;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_EndTime;

/**
 * 
 * @author 罗成峰
 * @date 2018-1-9上午11:52:40
 * @version 1.0
 */
public class aaQueKeHeadServiceImpl implements aaQueKeHeadService{

	private aaQueKeHeadDao aaquekeheadDao = new  aaQueKeHeadDaoImpl();
	private ClassRoomDao classRoomDao = new ClassRoomDaoImpl();
	private CourseDao courseDao = new CourseDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private And_ClassEmpDao and_ClassEmpDao = new And_ClassEmpDaoImpl();
	private StudentDao studentDao = new StudentDaoImpl();
	
	public M_msg m_msg = new M_msg();
	
	public M_msg getMsg(){
		return m_msg;
	}

	@Override
	public PaikeRecordView getByEmpUuid(String empUuid) {
		// TODO Auto-generated method stub
		if(empUuid != null && empUuid!=""){
			PaikeRecordView paikeRecordView = aaquekeheadDao.getByEmpUuid(empUuid);
			
			return paikeRecordView;
		}else{
			System.out.println("aaQueKeHeadServiceImpl.getByEmpUuid()方法中empUuid为空,或格式不正确,请联系管理员");
			PaikeRecordView pkrd = new PaikeRecordView();
			return pkrd;
		}
}

	@Override
	public PaikeRecord getByClaUuid(String ClaUuid) {
		// TODO Auto-generated method stub
		if(ClaUuid !=null && ClaUuid!=""){
			PaikeRecord pr = aaquekeheadDao.getByClaUuid(ClaUuid);
			return pr;
		}else{
			System.out.println("aaQueKeHeadServiceImpl.getByClaUuid()方法中ClaUuid为空,或格式不正确,请联系管理员");
			PaikeRecord prd = new PaikeRecord();
			return prd;
		}
	}

	@Override
	public ArrayList<PaikeRecordView> getAllpaike(PaikeRecord paikeRecord) {
		// TODO Auto-generated method stub
		String headEmpUuid = paikeRecord.getEmpUuid();
		//1,根据班主任empuuid查出班主任关联的所有班级
		ArrayList<And_ClassEmp> claEmpList = and_ClassEmpDao.getListByEmp(headEmpUuid);
		//2,根据班级uuid查出班级的所有课表
		ArrayList<PaikeRecordView> allPaike = new ArrayList<PaikeRecordView>();
		for(And_ClassEmp one:claEmpList){
			ArrayList<PaikeRecordView> aClaPaike = aaquekeheadDao.getListByclaUuid(one.getClassUuid(), paikeRecord.getKeDateTime());
			for(PaikeRecordView keView: aClaPaike){
				allPaike.add(keView);
			}
			
		}
		//3,给所有课表附属对应班级名、老师名、学生名、班主任名
		
		ArrayList<PaikeRecordView> reAddNameList = new ArrayList<PaikeRecordView>();
		for (PaikeRecordView one : allPaike) {
			ClaStuTool ClaStuTool=new ClaStuTool();
			List<Student> stuList=ClaStuTool.getStuByCla(one.getClaUuid());//根据每个班级id查出班级下的所有学生
			one.setStuList(stuList);
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
			one.setHeadTeaUuid(claTeaUuid);
			one.setHeadTeaName(claTeaName);

		}// end 步骤
		return reAddNameList;
	}//end method  getAllpaike
}//end class

