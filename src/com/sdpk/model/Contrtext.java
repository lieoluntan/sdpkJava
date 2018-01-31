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
	private String stuName;// 学生姓名

	private String cDate; // 交易时间
	private String org; // 校区组织
	private String totalCount; // 总上课次数
	private String totalPrice; // 总支付金额
	
	private int sumLineUpA; //线上课的次数，排课限制参照点
	private int sumLineDownB; //线下课的次数，排课限制参照点

	private List<ConPrice> conPriceList;
	
	private String openAndclose;    //布尔值为true表示open打开，为false表示close关闭
	
	private String remark; //备注
	
	private String nameTcname;//别名，学生名和编号


	public Contrtext(String uuid, String cNum, String stuUuid, String cDate,
			String org, String totalCount, String totalPrice, int sumLineUpA,
			int sumLineDownB, List<ConPrice> conPriceList) {
		super();
		this.uuid = uuid;
		this.cNum = cNum;
		this.stuUuid = stuUuid;
		this.cDate = cDate;
		this.org = org;
		this.totalCount = totalCount;
		this.totalPrice = totalPrice;
		this.sumLineUpA = sumLineUpA;
		this.sumLineDownB = sumLineDownB;
		this.conPriceList = conPriceList;
	}

	public Contrtext() {
		super();
	}

	

	@Override
	public String toString() {
		return "Contrtext 新合同[uuid=" + uuid + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", createPeople="
				+ createPeople + ", modifyPeople=" + modifyPeople + ", cNum="
				+ cNum + ", stuUuid=" + stuUuid + ", stuName=" + stuName
				+ ", cDate=" + cDate + ", org=" + org + ", totalCount="
				+ totalCount + ", totalPrice=" + totalPrice + ", sumLineUpA="
				+ sumLineUpA + ", sumLineDownB=" + sumLineDownB
				+ ", conPriceList=" + conPriceList + "]";
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getCreatePeople() {
		return createPeople;
	}

	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}

	public String getModifyPeople() {
		return modifyPeople;
	}

	public void setModifyPeople(String modifyPeople) {
		this.modifyPeople = modifyPeople;
	}

	public String getcNum() {
		return cNum;
	}

	public void setcNum(String cNum) {
		this.cNum = cNum;
	}

	public String getStuUuid() {
		return stuUuid;
	}

	public void setStuUuid(String stuUuid) {
		this.stuUuid = stuUuid;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ConPrice> getConPriceList() {
		return conPriceList;
	}

	public void setConPriceList(List<ConPrice> conPriceList) {
		this.conPriceList = conPriceList;
	}

	public int getSumLineUpA() {
		return sumLineUpA;
	}

	public void setSumLineUpA(int sumLineUpA) {
		this.sumLineUpA = sumLineUpA;
	}

	public int getSumLineDownB() {
		return sumLineDownB;
	}

	public void setSumLineDownB(int sumLineDownB) {
		this.sumLineDownB = sumLineDownB;
	}

	public String getOpenAndclose() {
		return openAndclose;
	}

	public void setOpenAndclose(String openAndclose) {
		this.openAndclose = openAndclose;
	}

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getNameTcname() {
    return nameTcname;
  }

  public void setNameTcname(String nameTcname) {
    this.nameTcname = nameTcname;
  }

}// end class
