package com.sdpk.model;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-29 下午2:29:07 用来接收老师月课查询时传过来的字段
 */
public class PaikeSearch {

	private String uuid;//老师id
	private String MonthDay;
	private String stuUuid;//学生id
	private String year;
	private String month;
	private String today;
	private String claUuid;
	public PaikeSearch(String uuid, String monthDay, String stuUuid,
			String year, String month, String today) {
		super();
		this.uuid = uuid;
		MonthDay = monthDay;
		this.stuUuid = stuUuid;
		this.year = year;
		this.month = month;
		this.today = today;
	}
	public PaikeSearch() {
		super();
	}
	@Override
	public String toString() {
		return "PaikeSearch [uuid=" + uuid + ", MonthDay=" + MonthDay
				+ ", stuUuid=" + stuUuid + ", year=" + year + ", month="
				+ month + ", today=" + today + "]";
	}
	
	
	public String getClaUuid() {
		return claUuid;
	}
	public void setClaUuid(String claUuid) {
		this.claUuid = claUuid;
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
	public String getStuUuid() {
		return stuUuid;
	}
	public void setStuUuid(String stuUuid) {
		this.stuUuid = stuUuid;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	
	

}
