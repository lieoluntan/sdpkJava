package com.sdpk.model;
/**
 * 
 * @author 罗成峰
 * @date 2017-12-27上午11:06:46
 * @version 1.0
 */
public class Role {

	private String uuid;
	private String name;
	private String createDate;
	private String modifyDate;
	private String createPeople;
	private String modifyPeople;
	
	private boolean empConflict;
	private boolean croomConflict;
	public Role(){
		
		
	}
	 public Role(String uuid,String name) {
		    this.uuid = uuid;
		    this.name = name;
		  }
	 public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
    public boolean isEmpConflict() {
		    return empConflict;
		  }

   public void setEmpConflict(boolean empConflict) {
		    this.empConflict = empConflict;
		  }
   public boolean isCroomConflict() {
	    return croomConflict;
	  }

  public void setCroomConflict(boolean croomConflict) {
	    this.croomConflict = croomConflict;
	  }
	
}
