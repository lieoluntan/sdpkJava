package com.sdpk.system.model;

import java.util.List;

/**
 * 树袋老师 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-11-24 上午11:42:20 类说明
 * @version 创建时间：2017-11-24 上午11:42:20 类说明
 * 薛人杰+加入了roleList字段用来存放用户下面对应的角色集合
 */

public class UserPK {

	private String uuid;
	private String createDate;
	private String modifyDate;
	private String createPeople;
	private String modifyPeople;

	private String uLogUser;
	private String uPassWord;
	private String uName;
	private List<String> roleList;// 存放角色id

	public UserPK() {
		
	}

	public UserPK(String uuid, String uLogUser, String uPassWord, String uName,
			List<String> roleList) {
		super();
		this.uuid = uuid;
		this.uLogUser = uLogUser;
		this.uPassWord = uPassWord;
		this.uName = uName;
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "UserPK [uuid=" + uuid + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", createPeople="
				+ createPeople + ", modifyPeople=" + modifyPeople
				+ ", uLogUser=" + uLogUser + ", uPassWord=" + uPassWord
				+ ", uName=" + uName + ", role=" + roleList + "]";
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

	public String getuLogUser() {
		return uLogUser;
	}

	public void setuLogUser(String uLogUser) {
		this.uLogUser = uLogUser;
	}

	public String getuPassWord() {
		return uPassWord;
	}

	public void setuPassWord(String uPassWord) {
		this.uPassWord = uPassWord;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

}// end class