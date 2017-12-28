package com.sdpk.model;

import java.util.List;

/**
 *树袋老师
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-11-24 上午11:42:20
 * 类说明
 * @version 创建时间：2017-11-24 上午11:42:20 类说明
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
  
  public UserPK() {
    super();
  }
	private String uuid;
	private String createDate;
	private String modifyDate;
	private String createPeople;
	private String modifyPeople;

  public UserPK(String uuid, String uLogUser, String uPassWord, String uName) {
    super();
    this.uuid = uuid;
    this.uLogUser = uLogUser;
    this.uPassWord = uPassWord;
    this.uName = uName;
  }
	private String uLogUser;
	private String uPassWord;
	private String uName;
	private List<String> roleList;// 存放角色id

  @Override
  public String toString() {
    return "userPK 开始[uuid=" + uuid + ", uLogUser=" + uLogUser + ", uPassWord=" + uPassWord
        + ", uName=" + uName + "]结束";
  }
	public UserPK() {
		super();
	}

  public String getUuid() {
    return uuid;
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

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
	@Override
	public String toString() {
		return "UserPK [uuid=" + uuid + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", createPeople="
				+ createPeople + ", modifyPeople=" + modifyPeople
				+ ", uLogUser=" + uLogUser + ", uPassWord=" + uPassWord
				+ ", uName=" + uName + ", role=" + roleList + "]";
	}

  public String getCreateDate() {
    return createDate;
  }
	public String getUuid() {
		return uuid;
	}

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

  public String getModifyDate() {
    return modifyDate;
  }
	public String getCreateDate() {
		return createDate;
	}

  public void setModifyDate(String modifyDate) {
    this.modifyDate = modifyDate;
  }
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

  public String getCreatePeople() {
    return createPeople;
  }
	public String getModifyDate() {
		return modifyDate;
	}

  public void setCreatePeople(String createPeople) {
    this.createPeople = createPeople;
  }
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

  public String getModifyPeople() {
    return modifyPeople;
  }
	public String getCreatePeople() {
		return createPeople;
	}

  public void setModifyPeople(String modifyPeople) {
    this.modifyPeople = modifyPeople;
  }
	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}

  public String getuLogUser() {
    return uLogUser;
  }
	public String getModifyPeople() {
		return modifyPeople;
	}

  public void setuLogUser(String uLogUser) {
    this.uLogUser = uLogUser;
  }
	public void setModifyPeople(String modifyPeople) {
		this.modifyPeople = modifyPeople;
	}

  public String getuPassWord() {
    return uPassWord;
  }
	public String getuLogUser() {
		return uLogUser;
	}

  public void setuPassWord(String uPassWord) {
    this.uPassWord = uPassWord;
  }
	public void setuLogUser(String uLogUser) {
		this.uLogUser = uLogUser;
	}

  public String getuName() {
    return uName;
  }
	public String getuPassWord() {
		return uPassWord;
	}

  public void setuName(String uName) {
    this.uName = uName;
  }
  


	public void setuPassWord(String uPassWord) {
		this.uPassWord = uPassWord;
	}

	public String getuName() {
		return uName;
	}

}//end class 
	public void setuName(String uName) {
		this.uName = uName;
	}

	public List<String> getroleList() {
		return roleList;
	}

	public void setRole(List<String> roleList) {
		this.roleList = roleList;
	}

}// end class
