package com.sdpk.model;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-29 下午2:29:07 用来接收老师月课查询时传过来的字段
 */
public class PaikeSearch {

	private String uuid;
	private String MonthDay;

	public PaikeSearch(String uuid, String monthDay) {
		super();
		this.uuid = uuid;
		MonthDay = monthDay;
	}

	public PaikeSearch() {
		super();
	}

	@Override
	public String toString() {
		return "PaikeSearch [uuid=" + uuid + ", MonthDay=" + MonthDay + "]";
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMonthDay() {
		return MonthDay;
	}

	public void setMonthDay(String monthDay) {
		MonthDay = monthDay;
	}

}
