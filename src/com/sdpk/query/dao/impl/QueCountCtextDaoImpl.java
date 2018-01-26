package com.sdpk.query.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sdpk.model.QueCountCtext;
import com.sdpk.query.dao.QueCountCtextDao;
import com.sdpk.utility.DBUtility;
/*
 * @author 刘鑫
 * @date 2018-01-25 18:17
 */
public class QueCountCtextDaoImpl implements QueCountCtextDao {
	private Connection connection;
	boolean dao = false;

	public QueCountCtextDaoImpl(){
		System.out.println("connection对象在QueCountCtextDaoImpl连接!");
	}
	@Override
	public ArrayList<QueCountCtext> queryCountCtext(String uuid) {
		// TODO Auto-generated method stub
		ArrayList<QueCountCtext> ctextList=new ArrayList<QueCountCtext>();
		Statement statement1 = null;
		Statement statement2=null;
		Statement statement3=null;
		Statement statement4=null;
		
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		try{
			connection = DBUtility.open();
			QueCountCtext qcc=new QueCountCtext();
			int rowcount=0;
			String rowcountt="";
			int kesum=0;
			String kesumm="";
			int kebefore=0;
			String kebeforee="";
			int keafter=0;
			String keafterr="";
			//获取当前时间
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MMdd");
			
			statement1 = connection.createStatement();
			statement2=connection.createStatement();
			statement3=connection.createStatement();
			statement4=connection.createStatement();
			
			//根据单个学生id查询所对应的几个班级，几个班级所对应的几个合同
			rs1=statement1.executeQuery("select DISTINCT tcc.* from t_class_contract tcc,t_contrtext tc where tcc.classUuid in(select tcs.classUuid from t_class_stu tcs where tcs.stuUuid='"+uuid+"') and tc.openAndclose='open';");
			//根据学生id查询所对应的几个班级，几个班级所对应的几节课
			rs2=statement2.executeQuery("select tpa.* from t_paike_all tpa where tpa.claUuid in(select tcs.classUuid from t_class_stu tcs where tcs.stuUuid='"+uuid+"')");
			//根据学生id查询学生姓名和id
			rs3=statement3.executeQuery("select * from t_student where uuid='"+uuid+"';");
			//根据学生id查询合同表中学生对应总课数
			rs4=statement4.executeQuery("select sum(totalCount) from t_contrtext where stuUuid='"+uuid+"' and openAndclose='open';");
			
				while(rs1.next()){
					rowcount++;
					rowcountt=rowcount+"";
					//合同数量
					qcc.setcTextCount(rowcountt);
				}
			
				while(rs2.next()){
					//合同总课数
					kesum++;
					kesumm=kesum+"";
					qcc.setPaikeSum(kesumm);
					//已上过的课
					if(sdf.parse(rs2.getString("keDateTime")).before(date)){
						kebefore++;
						//System.out.println("上的课==="+kebefore);
						kebeforee=kebefore+"";
						qcc.setKeDayBefore(kebeforee);
						/*System.out.println("排课时间=========="+sdf.parse(rs2.getString("keDateTime")));
						System.out.println("当前时间=========="+date);
						System.out.println("已上课次数============"+kebefore);
						System.out.println("排课时间是否在当前时间之前============"+sdf.parse(rs2.getString("keDateTime")).before(date));*/
					}
					//没上过的课
					keafter=kesum-kebefore;
					keafterr=keafter+"";
					qcc.setKeDayAfter(keafterr);
					
					
				}
			
			//ctextList.add(qcc);
			while(rs3.next()){
				//学生名字
				qcc.setStuName(rs3.getString("name"));
				//学生id
				qcc.setStuUuid(rs3.getString("uuid"));
				
			}
			
				while(rs4.next()){
					qcc.setKeTotal(rs4.getString("sum(totalCount)"));
				}
				
			
			ctextList.add(qcc);
			System.out.println("合同数量==============="+qcc.getcTextCount());
			System.out.println("合同已排课==============="+qcc.getPaikeSum());
			System.out.println("已上过的课==============="+qcc.getKeDayBefore());
			System.out.println("没上过的课==============="+qcc.getKeDayAfter());
			System.out.println("学生名字==============="+qcc.getStuName());
			System.out.println("学生id==============="+qcc.getStuUuid());
			System.out.println("合同总课数==============="+qcc.getKeTotal());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("MonthHeadDaoImpl的queryMonthKeByClaUuid查询失败");
		}
		finally{
			DBUtility.close(rs1, statement1, connection);
			DBUtility.close(rs2, statement2, connection);
			DBUtility.close(rs3, statement3, connection);
			DBUtility.close(rs4, statement4, connection);
		}
		for (QueCountCtext queCountCtext : ctextList) {
			System.out.println(queCountCtext.getStuName()+"============"+queCountCtext.getStuUuid());
		}
		return ctextList;
	}

}
