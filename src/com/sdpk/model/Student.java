package com.sdpk.model;

public class Student {

  private String uuid;
  private String createDate;
  private String modifyDate;
  private String createPeople;
  private String modifyPeople;

  private String name;
  private String studentID;
  private String school;
  private String grade;
  private String phone;
  private String date;
  private String parentName;
  private String parentPhone;
  private String address;
  private String remark;
  
  private String sex;
  private String org;
  private String parentRela;

  private String  parentName2;//家长姓名
  private String parentPhone2;//家长电话
  private String parentRela2;//家庭住址
  
  private String openAndclose;    //布尔值为true表示open打开，为false表示close关闭



  public String getParentName2() {
	return parentName2;
}

public void setParentName2(String parentName2) {
	this.parentName2 = parentName2;
}

public String getParentPhone2() {
	return parentPhone2;
}

public void setParentPhone2(String parentPhone2) {
	this.parentPhone2 = parentPhone2;
}



@Override
  public String toString() {
    return "学生 [uuid=" + uuid + ", name=" + name + ", studentID=" + studentID + ", school=" + school + ", grade="
        + grade + ", phone=" + phone + ", date=" + date + ", parentName=" + parentName
        + ", parentPhone=" + parentPhone + ", address=" + address + ", remark=" + remark +

        ",parentName2=" + parentName2 + ", parentPhone2=" + parentPhone2 + "  parentRela2=" + parentRela2 + "]";
  }
  
  public Student(){}

  public Student(String uuid, String name, String studentID, String school, String grade,
      String phone, String date, String parentName, String parentPhone, String address,
      String remark,String parentName2,String parentPhone2,String parentRela2) {
    super();
    this.uuid = uuid;
    this.name = name;
    this.studentID = studentID;
    this.school = school;
    this.grade = grade;
    this.phone = phone;
    this.date = date;
    this.parentName = parentName;
    this.parentPhone = parentPhone;
    this.address = address;
    this.remark = remark;
    this.parentName2 = parentName2;
    this.parentPhone2 = parentPhone2;
    this.parentRela2 = parentRela2;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStudentID() {
    return studentID;
  }

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public String getParentPhone() {
    return parentPhone;
  }

  public void setParentPhone(String parentPhone) {
    this.parentPhone = parentPhone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }
  
  
  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getOrg() {
    return org;
  }

  public void setOrg(String org) {
    this.org = org;
  }

  public String getParentRela() {
    return parentRela;
  }

  public void setParentRela(String parentRela) {
    this.parentRela = parentRela;
  }

public String getParentRela2() {
	return parentRela2;
}

public void setParentRela2(String parentRela2) {
	this.parentRela2 = parentRela2;
}

public String getOpenAndclose() {
	return openAndclose;
}

public void setOpenAndclose(String openAndclose) {
	this.openAndclose = openAndclose;
}

}// end class student