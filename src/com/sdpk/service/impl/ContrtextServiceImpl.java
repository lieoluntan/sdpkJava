package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sdpk.dao.ConPriceDao;
import com.sdpk.dao.ContrtextDao;
import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.ConPriceDaoImpl;
import com.sdpk.dao.impl.ContrtextDaoImpl;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.ConPrice;
import com.sdpk.model.Contract;
import com.sdpk.model.Contrtext;
import com.sdpk.model.Student;
import com.sdpk.query.nameQuery.dao.NameReContrDao;
import com.sdpk.query.nameQuery.dao.impl.NameReContrDaoImpl;
import com.sdpk.service.ContrtextService;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-8 下午7:09:07
 * 
 */
public class ContrtextServiceImpl implements ContrtextService {
	private ContrtextDao contrtextDao = new ContrtextDaoImpl();
	private ConPriceDao ConPriceDao = new ConPriceDaoImpl();
	private StudentDao studentDao = new StudentDaoImpl();
	private NameReContrDao nameReContrDao = new NameReContrDaoImpl();

	@Override
	public String insert(Contrtext contrtext) {
		String flag1 = this.getStuByName1(contrtext);
		if (flag1.equals("yes")) {

			return flag1;

		} else {

			Contrtext con = contrtextDao.getByCnum(contrtext.getcNum());
			if (con.getcNum() == null) {
				contrtext.setUuid(null);
				contrtext.setUuid(UUID.randomUUID().toString());
				for (ConPrice c : contrtext.getConPriceList()) {// 先添加价格
					c.setUuid(null);
					c.setUuid(UUID.randomUUID().toString());
					c.setContrUuid(contrtext.getUuid());
					ConPriceDao.insert(c);

				}
				boolean flag = contrtextDao.insert(contrtext);// 添加合同
				if (flag) {
					return contrtext.getUuid();

				} else {
					return "插入不成功,dao层执行有出错地方,请联系管理员";
				}

			} else {

				return "合同编号已存在！" + contrtext.getcNum();
			}
		}

		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Contrtext> getList() {
		// TODO Auto-generated method stub
		ArrayList<Contrtext> contractlist = (ArrayList<Contrtext>) contrtextDao
				.getList();
		for (Contrtext contrtext : contractlist) {// 查出stuName
			Student stu = studentDao.getByUuid(contrtext.getStuUuid());
			contrtext.setStuName(stu.getName());
		}
		for (Contrtext contrtext : contractlist) {// 查出conPriceList
			List<ConPrice> conPriceList = ConPriceDao.getByContrUuid(contrtext
					.getUuid());
			contrtext.setConPriceList(conPriceList);

		}

		return contractlist;
	}

	@Override
	public String delete(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			boolean daoFlag = contrtextDao.deleteByUuid(uuid);
			ConPriceDao.deleteByContrUuid(uuid);
			if (daoFlag) {
				return uuid;
			} else {
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "ContrtextServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
			System.out
					.println("ContrtextServiceImpl delete方法中的uuid为空，或格式不正确，请联系管理员");
			return msg;
		}

	}

	@Override
	public String update(Contrtext contrtext) {
		// TODO Auto-generated method stub
		String flag1 = this.getStuByName1(contrtext);
		if (flag1.equals("yes")) {

			return flag1;

		} else {
			String uuid = contrtext.getUuid();
			if (uuid != null && uuid != "") {
				boolean daoFlag = contrtextDao.update(contrtext);// 先修改合同

				ConPriceDao.deleteByContrUuid(contrtext.getUuid());// 根据合同id删除价格表中这个合同的所有价格

				for (ConPrice c : contrtext.getConPriceList()) {// 添加价格
					c.setUuid(null);
					c.setUuid(UUID.randomUUID().toString());
					c.setContrUuid(contrtext.getUuid());
					ConPriceDao.insert(c);

				}

				if (daoFlag) {
					return uuid;
				} else {
					return "修改不成功,dao层执行有出错地方,请联系管理员";
				}
			} else {
				String msg = "ContractServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
				System.out
						.println("ContractServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员");
				return msg;

			}
		}

	}

	@Override
	public Contrtext getByUuid(String uuid) {
		// TODO Auto-generated method stub
		Contrtext contrtext = contrtextDao.getOne(uuid);

		Student stu = studentDao.getByUuid(contrtext.getStuUuid());
		contrtext.setStuName(stu.getName());

		List<ConPrice> conPriceList = ConPriceDao.getByContrUuid(contrtext
				.getUuid());
		contrtext.setConPriceList(conPriceList);

		return contrtext;
	}

	@Override
	public String getStuByName(Contrtext contract) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Contrtext> conList = nameReContrDao.getStuByName(contract);
		for (Contrtext student2 : conList) {

			if (student2.getUuid() != null) {
				flag = "（有重名）" + contract.getcNum();

				return flag;
			}

		}
		flag = "（无重名）" + contract.getcNum();

		return flag;
	}

	@Override
	public String getStuByName1(Contrtext contract) {
		// TODO Auto-generated method stub
		String flag = "";

		List<Contrtext> conList = nameReContrDao.getStuByName(contract);
		for (Contrtext student2 : conList) {
			//编辑验证重名要过滤掉自己本身的名字
			String s2Uuid = student2.getUuid();
			boolean flagSelf = s2Uuid.equals(contract.getUuid());
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

}
