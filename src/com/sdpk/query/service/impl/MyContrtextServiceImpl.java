package com.sdpk.query.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.sdpk.query.dao.MyContrtextDao;
import com.sdpk.query.dao.impl.MyContrtextDaoImpl;
import com.sdpk.query.service.MyContrtextService;

/**
 * 
 * @author xpp
 * @date 2018-1-24上午11:51:55
 * @version 1.0
 */
public class MyContrtextServiceImpl implements MyContrtextService{
	
	private MyContrtextDao myContrtextDao = new MyContrtextDaoImpl();
	
	private ContrtextDao contrtextDao = new ContrtextDaoImpl();
	private ConPriceDao ConPriceDao = new ConPriceDaoImpl();
	private StudentDao studentDao = new StudentDaoImpl();

	//end method  主入口开始
	@Override
	public List<Contrtext> getHeadList(String empUuid) {
		// TODO Auto-generated method stub
		List<String> ClassIdList = myContrtextDao.getClaId(empUuid);
		// 去重复
		Set set = new HashSet();
		List<String> newClassIdList = new ArrayList<String>();// 新的资源集合，用来存放去重复后的资源id
		for (String cd : ClassIdList) {// foreach
			if (set.add(cd)) {
				newClassIdList.add(cd);
			}

		}// end forech 去重复完成
		List<String> ConIdList = this.getConId(newClassIdList);//调用本service层里面的方法使用this
		List<Contrtext> ConList = this.getConList(ConIdList);

		return ConList;
	}//end method  主入口结束
	
	
	public List<String> getConId(List<String> ClassIdList) {
		// TODO Auto-generated method stub
		List<String> ConIdList = new ArrayList<String>();// 存放所有的学员id
		for (String classId : ClassIdList) {

			List<String> Conid = myContrtextDao.getConId(classId);
			for (String s : Conid) {

				ConIdList.add(s);
			}

		}// end for
		Set set = new HashSet();
		List<String> newConIdList = new ArrayList<String>();// 新的资源集合，用来存放去重复后的资源id
		for (String cd : ConIdList) {// foreach
			if (set.add(cd)) {
				newConIdList.add(cd);
			}

		}// end forech 去重复完成

		return newConIdList;
	}//end method
	
	public List<Contrtext> getConList(List<String> ConIdList) {
		// TODO Auto-generated method stub
		List<Contrtext> ConList = new ArrayList<Contrtext>();
		for (String str : ConIdList) {
			Contrtext ctext = getByUuid(str);
			// System.out.println(student.getName());
			ConList.add(ctext);
		}

		return ConList;
	}//end method
	
	public Contrtext getByUuid(String uuid) {
		// TODO Auto-generated method stub
		Contrtext contrtext = contrtextDao.getOne(uuid);

		Student stu = studentDao.getByUuid(contrtext.getStuUuid());
		contrtext.setStuName(stu.getName());

		List<ConPrice> conPriceList = ConPriceDao.getByContrUuid(contrtext
				.getUuid());
		contrtext.setConPriceList(conPriceList);

		return contrtext;
	}//end method

	
	//--------------分割线，以上方法是查我的合同，以下方法是提升所有合同的速度查询方法（纯净合同列表，不带金额）-----------------------
	
	@Override
	  public List<Contrtext> getAllSpeedList() {
	    // TODO Auto-generated method stub
	  ArrayList<Contrtext> contractlist =  myContrtextDao.getAllSpeedList();

        return contractlist;
	  }//end method


  @Override
  public List<Contrtext> getnameTcnameList() {
    // TODO Auto-generated method stub
    ArrayList<Contrtext> contractlist =  myContrtextDao.getnameTcnameList();

    return contractlist;
  }//end method


  @Override
  public List<Contrtext> getHeadSpeedList(String empUuid) {
    // TODO Auto-generated method stub
    List<String> ClassIdList = myContrtextDao.getClaId(empUuid);
    // 去重复
    Set set = new HashSet();
    List<String> newClassIdList = new ArrayList<String>();// 新的资源集合，用来存放去重复后的资源id
    for (String cd : ClassIdList) {// foreach
        if (set.add(cd)) {
            newClassIdList.add(cd);
        }

    }// end forech 去重复完成
    List<String> ConIdList = this.getConId(newClassIdList);//调用本service层里面的方法使用this
    List<Contrtext> ConList = this.getConListSpeed(ConIdList);

    return ConList;
  }//end method
  
  //我的合同HeadSpeedList速度版，回调1
  public List<Contrtext> getConListSpeed(List<String> ConIdList) {
    // TODO Auto-generated method stub
    List<Contrtext> ConList = new ArrayList<Contrtext>();
    for (String str : ConIdList) {
        Contrtext ctext = getByUuidSpeed(str);
        // System.out.println(student.getName());
        ConList.add(ctext);
    }

    return ConList;
}//end method
  
   //我的合同HeadSpeedList速度版，回调2
  public Contrtext getByUuidSpeed(String uuid) {
    // TODO Auto-generated method stub
    Contrtext contrtext = contrtextDao.getOne(uuid);

    Student stu = studentDao.getByUuid(contrtext.getStuUuid());
    contrtext.setStuName(stu.getName());

    //速度版不需要查金额
//    List<ConPrice> conPriceList = ConPriceDao.getByContrUuid(contrtext
//            .getUuid());
//    contrtext.setConPriceList(conPriceList);

    return contrtext;
}//end method

}//end class 
