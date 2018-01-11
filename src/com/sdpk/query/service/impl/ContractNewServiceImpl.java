package com.sdpk.query.service.impl;
import java.util.ArrayList;
import java.util.List;
import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.Contract;
import com.sdpk.model.Student;
import com.sdpk.query.dao.ContractNewDao;
import com.sdpk.query.dao.impl.ContractNewDaoImpl;
import com.sdpk.query.service.ContractNewService;

public class ContractNewServiceImpl implements ContractNewService{

	private ContractNewDao contractnewdao = new ContractNewDaoImpl();
	private StudentDao studentdao = new StudentDaoImpl();
	@Override
	public Contract getByUuid(String uuid) {
		 if(uuid!=null&&uuid!="")
		    {
			 Contract  con = contractnewdao.getByUuid(uuid);
		    
		      return con;
		    }else{
		      System.out.println("RoleServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
		      Contract contract= new Contract();
		    return contract;
		    }
	}
	@Override
	public ArrayList<Contract> getList() {
		// TODO Auto-generated method stub
		ArrayList<Contract> contractlist = contractnewdao.getList();
		for (Contract contract : contractlist) {
			Student stu = studentdao.getByUuid(contract.getStuUuid());
			contract.setStuName(stu.getName());
		}
		return contractlist;
	}
}
