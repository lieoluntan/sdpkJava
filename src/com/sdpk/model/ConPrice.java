package com.sdpk.model;

public class ConPrice {

	private String uuid;
	private String createDate;
	private String modifyDate;
	private String createPeople;
	private String modifyPeople;

	private String contrUuid; // 合同uuid
	private String onePriceA; // 课程单价A
	private String countA; // 课程数量A
	private String delPriceA; // 优惠金额A
	private String countGiveA; // 送课次数A
	private String sumCountA; // 价格A上课次数
	private String sumPriceA; // 价格A支付金额
	private String priceType;// 价格类型：LineUpA  线上   LineDownB  线下

	public ConPrice(String uuid, String contrUuid, String onePriceA,
			String countA, String delPriceA, String countGiveA,
			String sumCountA, String sumPriceA, String priceType) {
		super();
		this.uuid = uuid;
		this.contrUuid = contrUuid;
		this.onePriceA = onePriceA;
		this.countA = countA;
		this.delPriceA = delPriceA;
		this.countGiveA = countGiveA;
		this.sumCountA = sumCountA;
		this.sumPriceA = sumPriceA;
		this.priceType = priceType;
	}

	public ConPrice() {
		super();
	}

	@Override
	public String toString() {
		return "ConPrice [uuid=" + uuid + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", createPeople="
				+ createPeople + ", modifyPeople=" + modifyPeople
				+ ", contrUuid=" + contrUuid + ", onePriceA=" + onePriceA
				+ ", countA=" + countA + ", delPriceA=" + delPriceA
				+ ", countGiveA=" + countGiveA + ", sumCountA=" + sumCountA
				+ ", sumPriceA=" + sumPriceA + ", priceType=" + priceType + "]";
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

	public String getContrUuid() {
		return contrUuid;
	}

	public void setContrUuid(String contrUuid) {
		this.contrUuid = contrUuid;
	}

	public String getOnePriceA() {
		return onePriceA;
	}

	public void setOnePriceA(String onePriceA) {
		this.onePriceA = onePriceA;
	}

	public String getCountA() {
		return countA;
	}

	public void setCountA(String countA) {
		this.countA = countA;
	}

	public String getDelPriceA() {
		return delPriceA;
	}

	public void setDelPriceA(String delPriceA) {
		this.delPriceA = delPriceA;
	}

	public String getCountGiveA() {
		return countGiveA;
	}

	public void setCountGiveA(String countGiveA) {
		this.countGiveA = countGiveA;
	}

	public String getSumCountA() {
		return sumCountA;
	}

	public void setSumCountA(String sumCountA) {
		this.sumCountA = sumCountA;
	}

	public String getSumPriceA() {
		return sumPriceA;
	}

	public void setSumPriceA(String sumPriceA) {
		this.sumPriceA = sumPriceA;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

}// end class
