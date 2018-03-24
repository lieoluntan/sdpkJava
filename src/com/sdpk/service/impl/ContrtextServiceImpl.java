package com.sdpk.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.sdpk.dao.ConPriceDao;
import com.sdpk.dao.ContrtextDao;
import com.sdpk.dao.LogGXDao;
import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.ConPriceDaoImpl;
import com.sdpk.dao.impl.ContrtextDaoImpl;
import com.sdpk.dao.impl.LogGXDaoImpl;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.Cla;
import com.sdpk.model.ConPrice;
import com.sdpk.model.Contract;
import com.sdpk.model.Contrtext;
import com.sdpk.model.LogGX;
import com.sdpk.model.QueCountCtext;
import com.sdpk.model.Student;
import com.sdpk.query.dao.QueCountCtextDao;
import com.sdpk.query.dao.impl.QueCountCtextDaoImpl;
import com.sdpk.query.nameQuery.dao.NameReContrDao;
import com.sdpk.query.nameQuery.dao.impl.NameReContrDaoImpl;
import com.sdpk.service.ContrtextService;
import com.sdpk.utility.M_msg;

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
	private QueCountCtextDao qccd=new QueCountCtextDaoImpl();
	private LogGXDao logGXDao = new LogGXDaoImpl();
	public M_msg m_msg = new M_msg();
	Logger logger = Logger.getLogger(ContrtextServiceImpl.class);
	
	  
	  @Override
	  public M_msg getMsg() {
	    // TODO Auto-generated method stub
	    return m_msg;
	  }

	@Override
	public String insert(Contrtext contrtext,String userUuid,String userName) {
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
				//返回前增加日志写入0320 start(批量排入课，用户uuid,用户名通过URL地址传入)
			        LogGX lg = new LogGX();
			        lg.setUuid(UUID.randomUUID().toString());
			        lg.setUserUuid(userUuid);
			        lg.setUserName(userName);
			        lg.setTableName("t_contrtext");
			        lg.setTableNameChina("合同表");
			        lg.setDataUuid(contrtext.getUuid());
			        Contrtext dbOne = contrtextDao.getOne(contrtext.getUuid());
			        lg.setDataName(dbOne.getNameTcname());
			        lg.setUserAction("新增");
			        List<ConPrice> conPriceList = contrtext.getConPriceList();
			        int count = conPriceList.size();
			        String str = "合同新增1条，金额新增(" + count +")条.";
			        lg.setDataGxChina(str);
			        Date date = new Date();
			        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        String da = sdf.format(date);
			        lg.setUpdateTime(da);
			        logGXDao.insert(lg);
			        
			        //返回前增加日志写入0320 end
					return contrtext.getUuid();

				} else {
					logger.error("插入不成功,dao层执行有出错地方,请联系管理员");
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
				logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
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
					logger.error("修改不成功,dao层执行有出错地方,请联系管理员");
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

	@Override
	public String getonoff(Contrtext contrtext) {
		// TODO Auto-generated method stub
		String uuid = contrtext.getUuid();
		if(uuid!=null&&uuid!="")
	    {
		  String oAc = contrtext.getOpenAndclose();
	      boolean daoFlag = contrtextDao.updateOnOff(uuid,oAc);
	      
	        if(daoFlag)
	        {
	        return "操作成功";
	        }else{
	        	logger.error("操作失败,dao层执行有出错地方,请联系管理员");
	          return "操作失败,dao层执行有出错地方,请联系管理员";
	        }
	    }else{
	      String msg="ClassRoomServiceImpl getonoff方法中的uuid为空，或格式不正确，请重新选择";
	      System.out.println(msg);
	      return msg;
	    }
	}//end method

  @Override
  public String updateLimit(Contrtext contrtext,String userUuid,String userName) {
    // 步骤一：验证重名
    List<Contrtext> conList = nameReContrDao.getStuByName(contrtext);
    for (Contrtext one : conList) {
        //编辑验证重名要过滤掉自己本身的名字
        String s2Uuid = one.getUuid();
        boolean flagSelf = s2Uuid.equals(contrtext.getUuid());
        boolean flagNotSelf = !flagSelf;
        if(flagNotSelf){//编辑验证重名要过滤
            if (one.getUuid() != null) {
              String msg = "不保存，数据库有相同合同编号--"+contrtext.getcNum();
              m_msg.setEditMsg(msg);
              return msg;
            }
      }//end if(flagNotSelf)

    }//end 步骤一 结束
    //步骤二：验证修改后的合同次数保证大于学生已消课（学生今天以前的课--不包括今天）
    //步骤二(1):获取学生已消课
    String stuUuid = contrtext.getStuUuid();
    ArrayList<QueCountCtext> queCountList = qccd.queryCountCtext(stuUuid);
    QueCountCtext qccNew = new QueCountCtext();
    for(QueCountCtext one : queCountList){
      qccNew = one;
    }
    String keDayBefore = qccNew.getKeDayBefore();
    int keDayBefore_int = Integer.valueOf(keDayBefore).intValue();
    //步骤二（2）：获取新的合同次数总和(将要修改的)
    //没修改前的:
    String keTotal = qccNew.getKeTotal();
    String nowEditTotal = contrtext.getTotalCount();
    Contrtext dbContrtext = contrtextDao.getOne(contrtext.getUuid());
    String dbTotal = dbContrtext.getTotalCount();
    if(keTotal==null){keTotal="0";}
    if(dbTotal==null){dbTotal="0";}
     int keTotal_int = Integer.valueOf(keTotal).intValue();//没修改前的
     int dbTotal_int = Integer.valueOf(dbTotal).intValue();//本次原合同次数
     int nowEditTotal_int = Integer.valueOf(nowEditTotal).intValue(); //本次原合同要修改次数
   //没修改前的-本次原合同次数+本次原合同要修改次数=新的合同次数总和(将要修改的)
     int readyKeTotal =  keTotal_int-dbTotal_int+nowEditTotal_int;
     //步骤(3)：比较新的合同次数总和(将要修改的)>学生已消课才执行Dao层update方法
     if(readyKeTotal<keDayBefore_int){  //!!!判断一：小于不能修改
       String msg = "不保存 : 总次数--"+readyKeTotal+"小于课消--"+keDayBefore_int+", 学生合同别名--"+dbContrtext.getNameTcname();
       m_msg.setEditMsg(msg);System.out.println(msg);
       return msg;
     }else if(readyKeTotal>=keDayBefore_int){ //!!!判断二：大于可以修改
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
             
           //返回前增加日志写入0320 start(批量排入课，用户uuid,用户名通过URL地址传入)
             LogGX lg = new LogGX();
             lg.setUuid(UUID.randomUUID().toString());
             lg.setUserUuid(userUuid);
             lg.setUserName(userName);
             lg.setTableName("t_contrtext");
             lg.setTableNameChina("合同表");
             lg.setDataUuid(contrtext.getUuid());
             
             Contrtext dbOne = contrtextDao.getOne(contrtext.getUuid());
             lg.setDataName(dbOne.getNameTcname());
             lg.setUserAction("编辑");
             List<ConPrice> conPriceList = contrtext.getConPriceList();
             int count = conPriceList.size();
             String str = "合同编辑1条，金额编辑(" + count +")条.";
             lg.setDataGxChina(str);
             Date date = new Date();
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String da = sdf.format(date);
             lg.setUpdateTime(da);
             logGXDao.insert(lg);
             
             //返回前增加日志写入0320 end
             
               return "修改成功";
           } else {
        	   logger.error("修改不成功,dao层执行有出错地方,请联系管理员");
               return "修改不成功,dao层执行有出错地方,请联系管理员";
           }
       } else {  
           String msg = "ContractServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
           System.out
                   .println("ContractServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员");
           return msg;

       }
       
     }else{ //!!!判断三：比较失败
       String msg = "readyKeTotal（学生将要修改总次数）和keDayBefore（课消总次数）比较失败";
       m_msg.setEditMsg(msg);
       return msg;
     }
     
//     return "操作成功";

  }//end method

}//end class
