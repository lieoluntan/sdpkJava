package com.sdpk.model;

import java.util.List;

public class Contrtext {
	
	private String uuid;
	  private String createDate;
	  private String modifyDate;
	  private String createPeople;
	  private String modifyPeople;

	  private String cNum; // 合同编号
	  private String stuUuid; // 学生uuid
	  private String stuName;//学生姓名


	  private String cDate; // 交易时间
	  private String org; // 校区组织
	  private String totalCount; // 总上课次数
	  private String totalPrice; // 总支付金额
	  
	  private List<ConPrice>  conPriceList;
	  

}//end class
