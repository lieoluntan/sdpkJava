package com.sdpk.queryOpen.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.sdpk.dao.LogGXDao;
import com.sdpk.dao.impl.LogGXDaoImpl;
import com.sdpk.model.Record;
import com.sdpk.queryOpen.dao.RecordDao;
import com.sdpk.queryOpen.dao.impl.RecordDaoImpl;
import com.sdpk.queryOpen.service.RecordService;

public class RecordServiceImpl implements RecordService{
	private LogGXDao lgg = new LogGXDaoImpl();
	private RecordDao recordDao = new RecordDaoImpl();
	//DitchDao ditchDao = new DitchDaoImpl();
	Logger logger = Logger.getLogger(RecordServiceImpl.class);
	@Override
	public String insert(Record record) {
		// TODO Auto-generated method stub
		//Ditch ditch = ditchDao.getByUuid(record.getDitchUuid());
		if (record.getUuid() != null || record.getUuid() != "") {
			record.setUuid(UUID.randomUUID().toString());
			System.out.println("^^在RecordServiceImpl收到数据 ：" + record.toString()
					+ "收到结束!");
			boolean daoFlag = recordDao.insert(record);
			/*LogGX lg = new LogGX();
	        lg.setUuid(UUID.randomUUID().toString());
	        lg.setUserUuid(record.getUserUuid());
	        lg.setUserName(record.getUserName());
	        lg.setTableName("t_record");
	        lg.setTableNameChina("跟踪记录表");
	        lg.setDataUuid(record.getDitchUuid());
	        lg.setDataName(ditch.getName());
	        lg.setUserAction("新增");
	        Date date = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String da = sdf.format(date);
	        lg.setUpdateTime(da);
	        lg.setDataGxUuid(record.getUuid());
	        lg.setDataGxChina(record.getRemarkText());
	        lgg.insert(lg);*/
			if (daoFlag) {
				Date dateModify = new Date();
	            SimpleDateFormat sdfModify = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            String daModify = sdfModify.format(dateModify);
	        	/*recordDao.updateModifyDate(daModify,record.getDitchUuid());*/
				return record.getUuid();
			} else {
				logger.error("插入不成功,dao层执行有出错地方,请联系管理员");
				return "插入不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			return "该渠道不存在";
		}

	}

	@Override
	public String delete(Record re) {
		// TODO Auto-generated method stub
		if (re.getUuid() != null && re.getUuid() != "") {
			/*LogGX lg = new LogGX();
	        lg.setUuid(UUID.randomUUID().toString());
	        lg.setUserUuid(re.getUserUuid());
	        lg.setUserName(re.getUserName());
	        lg.setTableName("t_record");
	        lg.setTableNameChina("跟踪记录表");
	        List<Record> rec=recordDao.findIdShow(re.getUuid());
	        lg.setDataUuid(rec.get(0).getDitchUuid());
	        Ditch yx = ditchDao.getByUuid(rec.get(0).getDitchUuid());
	        lg.setDataName(yx.getName());
	        lg.setUserAction("删除");
	        Date date = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String da = sdf.format(date);
	        lg.setUpdateTime(da);
	        lg.setDataGxUuid(rec.get(0).getUuid());
	        lg.setDataGxChina(rec.get(0).getRemarkText());
	        lgg.insert(lg);*/
			boolean daoFlag = recordDao.delete(re.getUuid());
			if (daoFlag) {
				return re.getUuid();
			} else {
				logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "RecordServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}

	}

	@Override
	public String deleteByDitchUuid(Record record) {
		// TODO Auto-generated method stub
		if (record.getStuUuid() != null && record.getStuUuid()  != "") {
			/*LogGX lg = new LogGX();
	        lg.setUuid(UUID.randomUUID().toString());
	        lg.setUserUuid(record.getUserUuid());
	        lg.setUserName(record.getUserName());
	        lg.setTableName("t_record");
	        lg.setTableNameChina("跟踪记录表");
	        List<Record> rec=recordDao.findIdShow(record.getDitchUuid());
	        lg.setDataUuid(rec.get(0).getDitchUuid());
	        Ditch yx = ditchDao.getByUuid(rec.get(0).getDitchUuid());
	        lg.setDataName(yx.getName());
	        lg.setUserAction("删除");
	        Date date = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String da = sdf.format(date);
	        lg.setUpdateTime(da);
	        lg.setDataGxUuid(rec.get(0).getUuid());
	        lg.setDataGxChina(rec.get(0).getRemarkText());
	        lgg.insert(lg);*/
			boolean daoFlag = recordDao.deleteByDitchUuid(record.getStuUuid());
			if (daoFlag) {
				return record.getStuUuid();
			} else {
				logger.error("删除不成功,dao层执行有出错地方,请联系管理员");
				return "删除不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "RecordServiceImpl deleteByDitchUuid方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}

	@Override
	public String update(Record record) {
		// TODO Auto-generated method stub

		String uuid = record.getUuid();
		if (uuid != null && uuid != "") {
			boolean daoFlag = recordDao.update(record);
			/*LogGX lg = new LogGX();
	        lg.setUuid(UUID.randomUUID().toString());
	        lg.setUserUuid(record.getUserUuid());
	        lg.setUserName(record.getUserName());
	        lg.setTableName("t_record");
	        lg.setTableNameChina("跟踪记录表");
	        List<Record> rec=recordDao.findIdShow(record.getUuid());
	        lg.setDataUuid(rec.get(0).getDitchUuid());
	        Ditch yx = ditchDao.getByUuid(rec.get(0).getDitchUuid());
	        lg.setDataName(yx.getName());
	        lg.setUserAction("编辑");
	        Date date = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String da = sdf.format(date);
	        lg.setUpdateTime(da);
	        lg.setDataGxUuid(record.getUuid());
	        lg.setDataGxChina(record.getRemarkText());
	        lgg.insert(lg);*/
			if (daoFlag) {
				return uuid;
			} else {
				logger.error("修改不成功,dao层执行有出错地方,请联系管理员");
				return "修改不成功,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "DitchServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}

	@Override
	public Record getByUuid(String uuid) {
		// TODO Auto-generated method stub
		if (uuid != null && uuid != "") {
			return recordDao.getByUuid(uuid);
		} else {
			System.out
					.println("RecordServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
			return new Record();
		}
	}

	@Override
	public ArrayList<Record> getList() {
		// TODO Auto-generated method stub

		ArrayList<Record> recList = recordDao.getList();
		/*for (int i = 0; i < recList.size(); i++) {
//			System.out.println("ditchUuid================"
//					+ recList.get(i).getDitchUuid());
			Ditch ditch = ditchDao.getByUuid(recList.get(i).getDitchUuid());
			//System.out.println("ditchName==============" + ditch.getName());
			recList.get(i).setDitchName(ditch.getName());
		}*/
		return recList;
	}

	@Override
	public ArrayList<Record> getListByDitchUuid(String stuUuid) {
		// TODO Auto-generated method stub
		if (stuUuid != null && stuUuid != "") {
			ArrayList<Record> recList =recordDao.getListstuUuid(stuUuid);
			/*for (int i = 0; i < recList.size(); i++) {
				Ditch ditch = ditchDao.getByUuid(recList.get(i).getDitchUuid());
				recList.get(i).setDitchName(ditch.getName());
			}*/
			return recList;
		} else {
			System.out
					.println("RecordServiceImpl getListByDitchUuid方法中的ditchUuid为空，或格式不正确，请联系管理员");
			return new ArrayList<Record>();
		}
	}

	/* 
	 * @param
	 * @return
	 */
	@Override
	public String getonoff(Record record) {
		// TODO Auto-generated method stub
		String uuid = record.getUuid();
		if (uuid != null && uuid != "") {
			String oac = record.getOpenAndclose();
			boolean daoFlag = recordDao.updateOnOff(uuid, oac);
			if (daoFlag) {
				return "操作成功";
			} else {
				logger.error("操作不成功,dao层执行有出错地方,请联系管理员");
				return "操作失败,dao层执行有出错地方,请联系管理员";
			}
		} else {
			String msg = "RecordServiceImpl getonoff方法中的uuid为空，或格式不正确，请重新选择";
			System.out.println(msg);
			return msg;
		}
	}
}
