package com.sdpk.model;

import java.util.ArrayList;

/**
 * 
 * 树袋老师
 * 
 * @author xuerenjie
 * @version 创建时间：2018-1-3 下午1:36:21 我的今日排课
 */
public class BackResult_TodPaike {
	String message;
	String qingqiu;
	int sumTodayPaike;

	ArrayList<?> data;

	public BackResult_TodPaike(String message, String qingqiu,
			int sumTodayPaike, ArrayList<?> data) {
		super();
		this.message = message;
		this.qingqiu = qingqiu;
		this.sumTodayPaike = sumTodayPaike;
		this.data = data;
	}

	@Override
	public String toString() {
		return "BackResult_TodPaike [message=" + message + ", qingqiu="
				+ qingqiu + ", sumTodayPaike=" + sumTodayPaike + ", data="
				+ data + "]";
	}

	public BackResult_TodPaike() {
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

	public int getSumTodayPaike() {
		return sumTodayPaike;
	}

	public void setSumTodayPaike(int sumTodayPaike) {
		this.sumTodayPaike = sumTodayPaike;
	}

	public ArrayList<?> getData() {
		return data;
	}

	public void setData(ArrayList<?> data) {
		this.data = data;
	}

}
