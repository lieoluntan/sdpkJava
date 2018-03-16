package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-3-7 上午10:35:52
 * 类说明
 */

public class LogGX {
  
  private String uuid;//唯一主键
  private String userUuid;//用户uuid 
  private String userName;//用户名 
  private String tableName;//操作数据库表名
  private String tableNameChina;//操作数据库表中文名
  private String dataUuid;//操作数据uuid 
  private String dataName;//操作数据中文名
  private String userAction;//操作行为  (新增、编辑、删除)  中的一个
  private String updateTime;//操作时间
  
  private String dataGxUuid;//数据关联uuid   对应record中的uuid
  private String dataGxChina;//数据关联中文名  对应record中的跟踪备注
  
  public LogGX() {
    super();
  }

  public LogGX(String uuid, String userUuid, String userName, String tableName,
      String tableNameChina, String dataUuid, String dataName, String userAction,
      String updateTime, String dataGxUuid, String dataGxChina) {
    super();
    this.uuid = uuid;
    this.userUuid = userUuid;
    this.userName = userName;
    this.tableName = tableName;
    this.tableNameChina = tableNameChina;
    this.dataUuid = dataUuid;
    this.dataName = dataName;
    this.userAction = userAction;
    this.updateTime = updateTime;
    this.dataGxUuid = dataGxUuid;
    this.dataGxChina = dataGxChina;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getUserUuid() {
    return userUuid;
  }

  public void setUserUuid(String userUuid) {
    this.userUuid = userUuid;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getTableNameChina() {
    return tableNameChina;
  }

  public void setTableNameChina(String tableNameChina) {
    this.tableNameChina = tableNameChina;
  }

  public String getDataUuid() {
    return dataUuid;
  }

  public void setDataUuid(String dataUuid) {
    this.dataUuid = dataUuid;
  }

  public String getDataName() {
    return dataName;
  }

  public void setDataName(String dataName) {
    this.dataName = dataName;
  }

  public String getUserAction() {
    return userAction;
  }

  public void setUserAction(String userAction) {
    this.userAction = userAction;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public String getDataGxUuid() {
    return dataGxUuid;
  }

  public void setDataGxUuid(String dataGxUuid) {
    this.dataGxUuid = dataGxUuid;
  }

  public String getDataGxChina() {
    return dataGxChina;
  }

  public void setDataGxChina(String dataGxChina) {
    this.dataGxChina = dataGxChina;
  }
  
  

}//end class
