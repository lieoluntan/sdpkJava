package com.sdpk.queryOpen.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.sdpk.dao.ClaDao;
import com.sdpk.dao.LogGXDao;
import com.sdpk.dao.PaikeRecordDao;
import com.sdpk.dao.impl.ClaDaoImpl;
import com.sdpk.dao.impl.LogGXDaoImpl;
import com.sdpk.dao.impl.PaikeRecordDaoImpl;
import com.sdpk.model.Cla;
import com.sdpk.model.LogGX;
import com.sdpk.model.PaikeRecord;
import com.sdpk.queryOpen.dao.KeDelBatchDao;
import com.sdpk.queryOpen.dao.impl.KeDelBatchDaoImpl;
import com.sdpk.queryOpen.service.KeDelBatchService;
import com.sdpk.service.impl.LogGXServiceImpl;
import com.sdpk.utility.M_msg;
/**
 * 树袋老师
 * @author 作者毕书富
 * @version 创建时间 2018-03-23 上午11.30
 * 类说明
 */
public class KeDelBatchServiceImpl implements KeDelBatchService{
	public KeDelBatchDao kdbDao=new KeDelBatchDaoImpl();
	Logger logger = Logger.getLogger(LogGXServiceImpl.class);
	public M_msg m_msg = new M_msg();
	private PaikeRecordDao paikeRecordDao = new PaikeRecordDaoImpl();
	private ClaDao claDao= new ClaDaoImpl();
	private LogGXDao logGXDao = new LogGXDaoImpl();

	@Override
	public String deleteBatch(List<String> uuidList,String userUuid,String userName) {
		// TODO Auto-generated method stub
	    //获取删除排课的班级(给日志使用)  start
	     String paikeUuid = "初始值";
	     for(String one:uuidList){
	       paikeUuid = one;
	       break;
	     }
	     PaikeRecord pr = new PaikeRecord();
	     pr = paikeRecordDao.getByUuid(paikeUuid);
	     
	    //获取删除排课的班级  end
		int i=0;
		boolean daoFlag=false;//false
		if (uuidList != null && uuidList.size() >0) {
			for(String uuid:uuidList){
				daoFlag=kdbDao.deleteBatch(uuid);
				i=i+1;
				if(daoFlag==false){
					break;
				}
			   }//end for
			
			if (i>0) {
			//返回前增加日志写入0320 start(批量删除课，用户uuid,用户名通过URL地址传入)
		        LogGX lg = new LogGX();
		        lg.setUuid(UUID.randomUUID().toString());
		        lg.setUserUuid(userUuid);
		        lg.setUserName(userName);
		        lg.setTableName("t_paike_all");
		        lg.setTableNameChina("排课表");
		        lg.setDataUuid("无uuid");
		        Cla cla = new Cla();
		        cla = claDao.getByUuid(pr.getClaUuid());
		        lg.setDataName(cla.getName());
		        lg.setUserAction("批量删除");
		        String str = "删除了(" + i +")次课";
		        lg.setDataGxChina(str);
		        Date date = new Date();
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String da = sdf.format(date);
		        lg.setUpdateTime(da);
		        logGXDao.insert(lg);
		        
		        //返回前增加日志写入0320 end  
			  
				return "删除成功，批量删除了"+i+"条";
			} else {
				logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
				return "删除失败！删除了0条数据";
			}
		} else {
			String msg = "KeDelBatchService deleteBatch方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}

}
