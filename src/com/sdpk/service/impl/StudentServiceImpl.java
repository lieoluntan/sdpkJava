package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.Course;
import com.sdpk.model.Student;
import com.sdpk.query.nameQuery.dao.NameReStuDao;
import com.sdpk.query.nameQuery.dao.impl.NameReStuDaoImpl;
import com.sdpk.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao = new StudentDaoImpl();
	private NameReStuDao nameReStuDao = new NameReStuDaoImpl();

	@Override
	public String insert(Student stu) {
		//
		String flag = this.getStuByName1(stu);
		if (flag.equals("yes")) {

			return flag;

		} else {
			stu.setUuid(null);
			System.out.println("添加");
			stu.setUuid(UUID.randomUUID().toString());
			System.out.println("^^在StudentServiceImpl收到数据 ：" + stu.toString()
					+ "收到结束!");
			boolean daoFlag = studentDao.insert(stu);
			if (daoFlag) {
				return stu.getUuid();
			} else {
				return "插入不成功,dao层执行有出错地方,请联系管理员";
			}

		}

	}// end method insert

	@Override
	public String delete(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			boolean daoFlag = studentDao.delete(uuid);

			if (daoFlag) {
				return uuid;
			} else {
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			System.out
					.println("StudentServiceImpl delete方法中的uuid为空，或格式不正确，请联系管理员");
			return uuid;
		}

	}// end method delete

	@Override
	public String update(Student student) {
		// TODO Auto-generated method stub

		String flag = this.getStuByName1(student);
		if (flag.equals("yes")) {

			return flag;

		} else {
			String uuid = student.getUuid();
			if (uuid != null && uuid != "") {

				boolean daoFlag = studentDao.update(student);

				if (daoFlag) {
					return uuid;
				} else {
					return "修改不成功,dao层执行有出错地方,请联系管理员";
				}
			} else {
				System.out
						.println("StudentServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员");
				return uuid;
			}
		}

	}// end method update

	@Override
	public ArrayList<Student> getList() {
		// TODO Auto-generated method stub
		ArrayList<Student> studentlist = studentDao.getList();

		return studentlist;
	}// end method getListCourse

	@Override
	public Student getByUuid(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			Student student = studentDao.getByUuid(uuid);
			return student;
		} else {
			System.out
					.println("StudentServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
			Student studentX = new Student();
			return studentX;
		}
	}// end method getByUuid

	@Override
	public String getStuByName(Student student) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Student> stuList = nameReStuDao.getStuByName(student);
		for (Student student2 : stuList) {
			//编辑验证重名要过滤掉自己本身的名字
			String s2Uuid = student2.getUuid();
			boolean flagSelf = s2Uuid.equals(student.getUuid());
			boolean flagNotSelf = !flagSelf;
			if(flagNotSelf){//编辑验证重名要过滤
			
			System.out.println(student2.getUuid());
			if (student2.getUuid() != null) {
				flag = "（有重名）" + student.getName();

				return flag;
			 }
		  }//end if(flagNotSelf)
			

		}//end for
		flag = "修改成功（无重名）";

		return flag;
	}

	@Override
	public String getStuByName1(Student student) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Student> stuList = nameReStuDao.getStuByName(student);
		for (Student student2 : stuList) {
			//编辑验证重名要过滤掉自己本身的名字
			String s2Uuid = student2.getUuid();
			boolean flagSelf = s2Uuid.equals(student.getUuid());
			boolean flagNotSelf = !flagSelf;
			if(flagNotSelf){//编辑验证重名要过滤

			if (student2.getUuid() != null) {
				flag = "yes";

				return flag;
			 }
			}//end if(flagNotSelf)

		}
		flag = "no";

		return flag;
	}

	@Override
	public String getonoff(Student student) {
		// TODO Auto-generated method stub
		String uuid = student.getUuid();
		if(uuid!=null&&uuid!="")
	    {
		  String oAc = student.getOpenAndclose();
	      boolean daoFlag = studentDao.updateOnOff(uuid,oAc);
	      
	        if(daoFlag)
	        {
	        return "操作成功";
	        }else{
	          return "操作失败,dao层执行有出错地方,请联系管理员";
	        }
	    }else{
	      String msg="studentServiceImpl getonoff方法中的uuid为空，或格式不正确，请重新选择";
	      System.out.println(msg);
	      return msg;
	    }
	}//end method

}// end class StudentServiceImpl
