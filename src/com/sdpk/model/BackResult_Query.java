package com.sdpk.model;

import java.util.ArrayList;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2017-12-29 下午1:49:02 针对查询
 */
public class BackResult_Query {
	String message;
	String qingqiu;
	int SumEmpPaike;//月份总课数
	int SumDayBefore;//今天以前的课
	int SumDayAfter;//今天及今天以后的课
	int MonthSumHour;//月总课时
	int EndSumHour;//月已课时
	int LastSumHour;//月末课时
	
	  public int getMonthSumHour() {
		return MonthSumHour;
	}

	public void setMonthSumHour(int monthSumHour) {
		MonthSumHour = monthSumHour;
	}

	public int getEndSumHour() {
		return EndSumHour;
	}

	public void setEndSumHour(int endSumHour) {
		EndSumHour = endSumHour;
	}

	public int getLastSumHour() {
		return LastSumHour;
	}

	public void setLastSumHour(int lastSumHour) {
		LastSumHour = lastSumHour;
	}

	ArrayList<?> data;

	@Override
	public String toString() {
		return "BackResult_Query [message=" + message + ", qingqiu=" + qingqiu
				+ ", SumEmpPaike=" + SumEmpPaike + ", SumDayBefore="
				+ SumDayBefore + ", SumDayAfter=" + SumDayAfter + ", data="
				+ data + "]";
	}

	public BackResult_Query(String message, String qingqiu, int sumEmpPaike,
			int sumDayBefore, int sumDayAfter, ArrayList<?> data) {
		super();
		this.message = message;
		this.qingqiu = qingqiu;
		SumEmpPaike = sumEmpPaike;
		SumDayBefore = sumDayBefore;
		SumDayAfter = sumDayAfter;
		this.data = data;
	}

	public BackResult_Query() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getQingqiu() {
		return qingqiu;
	}

	public void setQingqiu(String qingqiu) {
		this.qingqiu = qingqiu;
	}

	public int getSumEmpPaike() {
		return SumEmpPaike;
	}

	public void setSumEmpPaike(int sumEmpPaike) {
		SumEmpPaike = sumEmpPaike;
	}

	public int getSumDayBefore() {
		return SumDayBefore;
	}

	public void setSumDayBefore(int sumDayBefore) {
		SumDayBefore = sumDayBefore;
	}

	public int getSumDayAfter() {
		return SumDayAfter;
	}

	public void setSumDayAfter(int sumDayAfter) {
		SumDayAfter = sumDayAfter;
	}

	public ArrayList<?> getData() {
		return data;
	}

	public void setData(ArrayList<?> data) {
		this.data = data;
	}



	

}
