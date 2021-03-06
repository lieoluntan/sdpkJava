package com.sdpk.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.sdpk.model.And_ClassCourse;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.And_ClassStu;
import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Class_Contract;
import com.sdpk.model.ConPrice;
import com.sdpk.model.Contract;
import com.sdpk.model.Contrtext;
import com.sdpk.model.Course;
import com.sdpk.model.Course_Emp;
import com.sdpk.model.Department;
import com.sdpk.model.Employee;
import com.sdpk.model.LogGX;
import com.sdpk.model.Logdata;
import com.sdpk.model.PaikeRecord;
import com.sdpk.model.Record;
import com.sdpk.model.Student;
import com.sdpk.system.model.Resource;
import com.sdpk.system.model.Role;
import com.sdpk.system.model.RoleResource;
import com.sdpk.system.model.UserPK;
import com.sdpk.system.model.UserPK_Role;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午1:42:03 类说明
 */

public class T_DataMap2Bean {

	public Cla MapToCla(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String org = (String) map.get("org");
		String name = (String) map.get("name");
		String empUuid = (String) map.get("empUuid");
		String classDate = (String) map.get("classDate");
		String status = (String) map.get("status");
		String remark = (String) map.get("remark");
		String claNum = (String) map.get("claNum");
		String openAndclose = (String) map.get("openAndclose");// 改变开关状态才用到，新增和编辑没有值

		Cla cla = new Cla(uuid, org, name, empUuid, classDate, status, remark);
		cla.setClaNum(claNum);
		cla.setOpenAndclose(openAndclose);

		return cla;
	}// end method MapToEmp

  public Logdata MapToLogdata(Map<String, Object> map) {
		
		String uuid = (String) map.get("uuid");
		String userUuid = (String) map.get("userUuid");
		String userName = (String) map.get("userName");
		String tableName = (String) map.get("tableName");
		String tableNameChina = (String) map.get("tableNameChina");
		String dataUuid = (String) map.get("dataUuid");
		String dataName = (String) map.get("dataName");
		String userAction = (String) map.get("userAction");
		String updateTime = (String) map.get("updateTime");
		String dataGxChina = (String) map.get("dataGxChina");
		
		Logdata logQD = new Logdata(uuid, userUuid, userName, tableName, tableNameChina, dataUuid, dataName, userAction, updateTime, null, dataGxChina);
		
		return logQD;
	}
	
	public LogGX MapToLogGX(Map<String, Object> map) {
	    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
	    String userUuid = (String) map.get("userUuid");
	    String userName = (String) map.get("userName");
	    String tableName = (String) map.get("tableName");
	    String tableNameChina = (String) map.get("tableNameChina");
	    String dataUuid = (String) map.get("dataUuid");
	    String dataName = (String) map.get("dataName");
	    
	    String userAction = (String) map.get("userAction");
	    String updateTime = (String) map.get("updateTime");
	    String dataGxUuid = (String) map.get("dataGxUuid");
	    String dataGxChina = (String) map.get("dataGxChina");
	    
	    LogGX logstu = new LogGX(uuid, userUuid, userName, tableName, tableNameChina, dataUuid, dataName, userAction, updateTime,dataGxUuid,dataGxChina);
	    return logstu;
	  }
	
	public ClassRoom MapToClassRoom(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		String campus = (String) map.get("campus");
		String remark = (String) map.get("remark");
		String openAndclose = (String) map.get("openAndclose");// 改变开关状态才用到，新增和编辑没有值

		ClassRoom classRoom = new ClassRoom(uuid, name, campus, remark);
		classRoom.setOpenAndclose(openAndclose);
		return classRoom;
	}// end method MapToEmp
	
	public Department MapToDepartment(Map<String, Object> map){
		String name=(String) map.get("name");
		String remark=(String) map.get("remark");
		String createDate=(String) map.get("createDate");
		String modifyDate=(String) map.get("modifyDate");
		String createPeople=(String) map.get("createPeople");
		String modifyPeople=(String) map.get("modifyPeople");
		String openAndclose=(String) map.get("modifyPeople");
		String uuid=(String) map.get("uuid");
		//String uuid=UUID.randomUUID().toString();
		Department department=new Department(uuid,name,remark);
		return department;
		
	}

	public Role MapToRole(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		Role role = new Role(uuid, name, null, null, null, null, null, null);
		return role;
	}

	public Employee MapToEmp(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");
		String name = (String) map.get("name");
		String empNum = (String) map.get("empNum");
		String phone = (String) map.get("phone");
		String depart = (String) map.get("depart");
		String job = (String) map.get("job");
		String permissionTempl = (String) map.get("permissionTempl");
		String remark = (String) map.get("remark");

		String claTeacher = (String) map.get("claTeacher");// 11月15新增字段
		String sex = (String) map.get("sex");
		String org = (String) map.get("org");
		String workDate = (String) map.get("workDate");
		String fullhalf = (String) map.get("fullhalf");
		String jobRemark = (String) map.get("jobRemark");
		String openAndclose = (String) map.get("openAndclose");// 改变开关状态才用到，新增和编辑没有值

		Employee emp = new Employee(uuid, name, empNum, phone, depart, job,
				permissionTempl, remark);
		emp.setClaTeacher(claTeacher);// 11月15新增字段
		emp.setSex(sex);
		emp.setOrg(org);
		emp.setWorkDate(workDate);
		emp.setFullhalf(fullhalf);
		emp.setJobRemark(jobRemark);
		emp.setOpenAndclose(openAndclose);

		return emp;
	}// end method MapToEmp

	public Course MapToCourse(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		String category = (String) map.get("category");
		String describe = (String) map.get("describe");
		String org = (String) map.get("org");
		String openAndclose = (String) map.get("openAndclose");// 改变开关状态才用到，新增和编辑没有值

		Course course = new Course(uuid, name, category, describe);
		course.setOrg(org);
		course.setOpenAndclose(openAndclose);

		return course;
	}// end method MapToEmp

	public Student MapToStudent(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		String studentID = (String) map.get("studentID");
		String school = (String) map.get("school");
		String grade = (String) map.get("grade");
		String phone = (String) map.get("phone");
		String date = (String) map.get("date");
		String parentName = (String) map.get("parentName");
		String parentPhone = (String) map.get("parentPhone");
		String address = (String) map.get("address");
		String remark = (String) map.get("remark");
		String sex = (String) map.get("sex");
		String org = (String) map.get("org");
		String parentRela = (String) map.get("parentRela");

		String parentName2 = (String)map.get("parentName2");//1.11新增家长名字字段
		String parentPhone2 = (String)map.get("parentPhone2");//1.11新增家长电话字段
		String parentRela2 = (String)map.get("parentRela2");//1.11新增家长备注字段
		
		String openAndclose = (String) map.get("openAndclose");// 改变开关状态才用到，新增和编辑没有值
		Student stu = new Student(uuid, name, studentID, school, grade, phone,
				date, parentName, parentPhone, address, remark,parentName2,parentPhone2,parentRela2);
		stu.setSex(sex);
		stu.setOrg(org);
		stu.setParentRela(parentRela);
		stu.setOpenAndclose(openAndclose);
		return stu;
	}// end method MapToStudent

	public Contract MapToContract(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String cNum = (String) map.get("cNum");
		String stuUuid = (String) map.get("stuUuid");
		String stuName = (String) map.get("stuName");
		String cDate = (String) map.get("cDate");
		String org = (String) map.get("org");
		String totalCount = (String) map.get("totalCount");
		String totalPrice = (String) map.get("totalPrice");

		String onePriceA = (String) map.get("onePriceA");
		String countA = (String) map.get("countA");
		String delPriceA = (String) map.get("delPriceA");
		String countGiveA = (String) map.get("countGiveA");
		String sumCountA = (String) map.get("sumCountA");
		String sumPriceA = (String) map.get("sumPriceA");

		String onePriceB = (String) map.get("onePriceB");
		String countB = (String) map.get("countB");
		String delPriceB = (String) map.get("delPriceB");
		String countGiveB = (String) map.get("countGiveB");
		String sumCountB = (String) map.get("sumCountB");
		String sumPriceB = (String) map.get("sumPriceB");

		Contract contract = new Contract(uuid, cNum, stuUuid, stuName, cDate,
				org, totalCount, totalPrice, onePriceA, countA, delPriceA,
				countGiveA, sumCountA, sumPriceA, onePriceB, countB, delPriceB,
				countGiveB, sumCountB, sumPriceB);
		return contract;
	}// end method MapToEmp

	public Contrtext MapToContrtext(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String cNum = (String) map.get("cNum");
		String stuUuid = (String) map.get("stuUuid");
		String stuName = (String) map.get("stuName");
		String cDate = (String) map.get("cDate");
		String org = (String) map.get("org");
		String totalCount = (String) map.get("totalCount");
		String totalPrice = (String) map.get("totalPrice");
		String sumLineUpA = (String) map.get("sumLineUpA");
		String remark = (String) map.get("remark");//合同的备注字段
		String openAndclose = (String) map.get("openAndclose");// 改变开关状态才用到，新增和编辑没有值
		if(sumLineUpA==null){
			sumLineUpA="0";
		}
	
		String sumLineDownB = (String) map.get("sumLineDownB");
		if(sumLineDownB==null){
			sumLineDownB="0";
		}
		List<Map> conPriceList = (List) map.get("conPriceList");
		List<ConPrice> conList = new ArrayList<ConPrice>();//
		if (conPriceList == null) {// 删除时不需要conPriceList

		} else {

			for (Map map2 : conPriceList) {
				ConPrice conPrice = new ConPrice();
				conPrice.setOnePriceA((String) map2.get("onePriceA"));
				conPrice.setCountA((String) map2.get("countA"));
				conPrice.setDelPriceA((String) map2.get("delPriceA"));
				conPrice.setCountGiveA((String) map2.get("countGiveA"));
				conPrice.setSumCountA((String) map2.get("sumCountA"));
				conPrice.setSumPriceA((String) map2.get("sumPriceA"));
				conPrice.setPriceType((String) map2.get("priceType"));
				conList.add(conPrice);
			}
		}
		Contrtext contrtext = new Contrtext(uuid, cNum, stuUuid, cDate, org,
				totalCount, totalPrice, Integer.parseInt(sumLineUpA),
				Integer.parseInt(sumLineDownB), conList);
		contrtext.setOpenAndclose(openAndclose);
		contrtext.setRemark(remark);
		return contrtext;
	}// end method MapToEmp

	public And_ClassEmp MapToAnd_ClassEmp(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String classUuid = (String) map.get("classUuid");
		String empUuid = (String) map.get("empUuid");

		And_ClassEmp and_ClassEmp = new And_ClassEmp(uuid, classUuid, empUuid);
		return and_ClassEmp;
	}// end method MapToAnd_ClassEmp

	public And_ClassStu MapToAnd_ClassStu(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String classUuid = (String) map.get("classUuid");
		String stuUuid = (String) map.get("stuUuid");

		And_ClassStu and_ClassStu = new And_ClassStu(uuid, classUuid, stuUuid);
		return and_ClassStu;
	}// end method MapToAnd_ClassStu

	public And_ClassCourse MapToAnd_ClassCourse(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String classUuid = (String) map.get("classUuid");
		String courseUuid = (String) map.get("courseUuid");

		And_ClassCourse and_ClassCourse = new And_ClassCourse(uuid, classUuid,
				courseUuid);
		return and_ClassCourse;
	}// end method MapToAnd_ClassCourse

	public PaikeRecord MapToPaiKeRecord(Map<String, Object> map) {
		String keDateTime = (String) map.get("keDateTime");// 删除和修改的时候会有值，新增和查询的时候没有值
		String empUuid = (String) map.get("empUuid");

		PaikeRecord paiKeRecord = new PaikeRecord(null, null, null, empUuid,
				null, keDateTime, null, null, null);
		return paiKeRecord;
	}// end method MapToAnd_ClassCourse

	public Record MapToRecord(Map<String, Object> map){
		String uuid=(String) map.get("uuid");
		String createDate=(String) map.get("createDate");
		String modifyDate=(String) map.get("modifyDate");
		String createPeople=(String) map.get("createPeople");
		String modifyPeople=(String) map.get("modifyPeople");
		String ditchUuid=(String) map.get("ditchUuid");
		String ditchName=(String) map.get("ditchName");
		String recordDate=(String) map.get("recordDate");
		String remarkText=(String) map.get("remarkText");
		String userUuid=(String) map.get("userUuid");
		String userName=(String) map.get("userName");
		String stuUuid = (String) map.get("stuUuid");
		Record record=new Record( uuid,  ditchUuid,  recordDate,  remarkText);
		record.setUserUuid(userUuid);
		record.setUserName(userName);
		record.setStuUuid(stuUuid);
		//record.setDitchName(ditchName);
		return record;
	}
	
	public Course_Emp MapToCourse_Emp(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String courseUuid = (String) map.get("courseUuid");
		String empUuid = (String) map.get("empUuid");

		Course_Emp course_Emp = new Course_Emp(uuid, courseUuid, empUuid);
		return course_Emp;
	}// end method MapToAnd_ClassCourse

	public Class_Contract MapToClass_Contract(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String classUuid = (String) map.get("classUuid");
		String contrUuid = (String) map.get("contrUuid");

		Class_Contract class_Contract = new Class_Contract(uuid, classUuid,
				contrUuid);
		return class_Contract;
	}// end method

	public UserPK MapToUserPK(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String uLogUser = (String) map.get("uLogUser");
		String uPassWord = (String) map.get("uPassWord");
		String uName = (String) map.get("uName");
		String empUuid = (String) map.get("empUuid");
		List<String> roleList = (List<String>) map.get("roleList");
		UserPK userPK = new UserPK(uuid, uLogUser, uPassWord, uName, roleList,
				empUuid);
		return userPK;
	}// end method MapToEmp

	public Role MapToUserRole(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		String modifyDate = (String) map.get("modifyDate");
		String createPeople = (String) map.get("createPeople");
		String modifyPeople = (String) map.get("modifyDate");
		String createDate = (String) map.get("createDate");
		String remark = (String) map.get("remark");
		List<String> rsList = (List<String>) map.get("rsList");
		Role role = new Role(uuid, name, modifyDate, createPeople,
				modifyPeople, createDate, remark, rsList);
		return role;
	}

	public Cla MapToCla1(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String org = (String) map.get("org");
		String name = (String) map.get("name");
		String empUuid = (String) map.get("empUuid");
		String classDate = (String) map.get("classDate");
		String status = (String) map.get("status");
		String remark = (String) map.get("remark");
		String claNum = (String) map.get("claNum");

		Cla cla = new Cla(uuid, org, name, empUuid, classDate, status, remark);
		cla.setClaNum(claNum);

		return cla;
	}// end method MapToEmp

	public ClassRoom MapToClassRoom1(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		String campus = (String) map.get("campus");
		String remark = (String) map.get("remark");

		ClassRoom classRoom = new ClassRoom(uuid, name, campus, remark);
		return classRoom;
	}// end method MapToEmp

	public Resource MapToResource(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		// String campus = (String) map.get("campus");
		// String remark = (String) map.get("remark");

		// ClassRoom classRoom = new ClassRoom(uuid, name, campus, remark);

		Resource resource = new Resource(uuid, name, null, null, null, null,
				null);
		return resource;
	}// end method MapToEmp

	public RoleResource MapToRoleResource(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String roleid = (String) map.get("roleid");
		String resourceid = (String) map.get("resourceid");

		RoleResource resource = new RoleResource(uuid, roleid, resourceid);
		return resource;
	}

	public Employee MapToEmp1(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");
		String name = (String) map.get("name");
		String empNum = (String) map.get("empNum");
		String phone = (String) map.get("phone");
		String depart = (String) map.get("depart");
		String job = (String) map.get("job");
		String permissionTempl = (String) map.get("permissionTempl");
		String remark = (String) map.get("remark");

		String claTeacher = (String) map.get("claTeacher");// 11月15新增字段
		String sex = (String) map.get("sex");
		String org = (String) map.get("org");
		String workDate = (String) map.get("workDate");
		String fullhalf = (String) map.get("fullhalf");
		String jobRemark = (String) map.get("jobRemark");

		Employee emp = new Employee(uuid, name, empNum, phone, depart, job,
				permissionTempl, remark);
		emp.setClaTeacher(claTeacher);// 11月15新增字段
		emp.setSex(sex);
		emp.setOrg(org);
		emp.setWorkDate(workDate);
		emp.setFullhalf(fullhalf);
		emp.setJobRemark(jobRemark);

		return emp;
	}// end method MapToEmp

	public Course MapToCourse1(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		String category = (String) map.get("category");
		String describe = (String) map.get("describe");
		String org = (String) map.get("org");

		Course course = new Course(uuid, name, category, describe);
		course.setOrg(org);

		return course;
	}// end method MapToEmp

	public Student MapToStudent1(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		String studentID = (String) map.get("studentID");
		String school = (String) map.get("school");
		String grade = (String) map.get("grade");
		String phone = (String) map.get("phone");
		String date = (String) map.get("date");
		String parentName = (String) map.get("parentName");
		String parentPhone = (String) map.get("parentPhone");
		String address = (String) map.get("address");
		String remark = (String) map.get("remark");

		String sex = (String) map.get("sex");
		String org = (String) map.get("org");
		String parentRela = (String) map.get("parentRela");
		

		String parentName2 = (String)map.get("parentName2");//1.11新增家长名字字段
		String parentPhone2 = (String)map.get("parentPhone2");//1.11新增家长电话字段
		String parentRela2 = (String)map.get("parentRela2");//1.11新增家长备注字段
		Student stu = new Student(uuid, name, studentID, school, grade, phone,
				date, parentName, parentPhone, address, remark,parentName2,parentPhone2,parentRela2);
		stu.setSex(sex);
		stu.setOrg(org);
		stu.setParentRela(parentRela);
		return stu;
	}// end method MapToStudent

	public Contract MapToContract1(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String cNum = (String) map.get("cNum");
		String stuUuid = (String) map.get("stuUuid");
		String stuName = (String) map.get("stuName");
		String cDate = (String) map.get("cDate");
		String org = (String) map.get("org");
		String totalCount = (String) map.get("totalCount");
		String totalPrice = (String) map.get("totalPrice");

		String onePriceA = (String) map.get("onePriceA");
		String countA = (String) map.get("countA");
		String delPriceA = (String) map.get("delPriceA");
		String countGiveA = (String) map.get("countGiveA");
		String sumCountA = (String) map.get("sumCountA");
		String sumPriceA = (String) map.get("sumPriceA");

		String onePriceB = (String) map.get("onePriceB");
		String countB = (String) map.get("countB");
		String delPriceB = (String) map.get("delPriceB");
		String countGiveB = (String) map.get("countGiveB");
		String sumCountB = (String) map.get("sumCountB");
		String sumPriceB = (String) map.get("sumPriceB");

		Contract contract = new Contract(uuid, cNum, stuUuid, stuName, cDate,
				org, totalCount, totalPrice, onePriceA, countA, delPriceA,
				countGiveA, sumCountA, sumPriceA, onePriceB, countB, delPriceB,
				countGiveB, sumCountB, sumPriceB);
		return contract;
	}// end method MapToEmp

	public And_ClassEmp MapToAnd_ClassEmp1(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String classUuid = (String) map.get("classUuid");
		String empUuid = (String) map.get("empUuid");

		And_ClassEmp and_ClassEmp = new And_ClassEmp(uuid, classUuid, empUuid);
		return and_ClassEmp;
	}// end method MapToAnd_ClassEmp

	public And_ClassStu MapToAnd_ClassStu1(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String classUuid = (String) map.get("classUuid");
		String stuUuid = (String) map.get("stuUuid");

		And_ClassStu and_ClassStu = new And_ClassStu(uuid, classUuid, stuUuid);
		return and_ClassStu;
	}// end method MapToAnd_ClassStu

	public And_ClassCourse MapToAnd_ClassCourse1(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String classUuid = (String) map.get("classUuid");
		String courseUuid = (String) map.get("courseUuid");

		And_ClassCourse and_ClassCourse = new And_ClassCourse(uuid, classUuid,
				courseUuid);
		return and_ClassCourse;
	}// end method MapToAnd_ClassCourse

	public Course_Emp MapToCourse_Emp1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String courseUuid = (String) map.get("courseUuid");
		String empUuid = (String) map.get("empUuid");

		Course_Emp course_Emp = new Course_Emp(uuid, courseUuid, empUuid);
		return course_Emp;
	}// end method MapToAnd_ClassCourse

	public Class_Contract MapToClass_Contract1(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String classUuid = (String) map.get("classUuid");
		String contrUuid = (String) map.get("contrUuid");

		Class_Contract class_Contract = new Class_Contract(uuid, classUuid,
				contrUuid);
		return class_Contract;
	}// end method

	public UserPK_Role MapToUserPK_Role(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String userPkid = (String) map.get("userPkid");
		String roleid = (String) map.get("roleid");

		UserPK_Role userPK_role = new UserPK_Role(uuid, userPkid, roleid);
		return userPK_role;
	}// end method

}// end class T_DataMap2Bean
