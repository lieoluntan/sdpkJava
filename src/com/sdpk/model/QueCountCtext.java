package com.sdpk.model;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-01-25 下午3:18:36
 * 类说明
 */
public class QueCountCtext {
	
	private String stuUuid;//学生uuid主键
	private String stuName;//学生名字
	private String cTextCount;//关联合同数量
	private String keTotal;//合同总课数
	private String keDayBefore;//已消课（今天以前已上过的课）
	private String keDayAfter;//合同可上课数---等于合同已排课数减已消课数---paikeSum减keDayBefore
	private String paikeSum;//合同已排课数
	private String cMoreThan;//合同剩余次数---等于合同总课数减已消课数---keTotal减keDayBefore
	
	
	
	
	public QueCountCtext() {
		this.cTextCount="0";this.keTotal="0";this.keDayBefore="0";this.keDayAfter="0";this.paikeSum="0";
	}




	public QueCountCtext(String stuUuid, String stuName, String cTextCount,
			String keTotal, String keDayBefore, String keDayAfter,
			String paikeSum) {
		super();
		this.stuUuid = stuUuid;
		this.stuName = stuName;
		this.cTextCount = cTextCount;
		this.keTotal = keTotal;
		this.keDayBefore = keDayBefore;
		this.keDayAfter = keDayAfter;
		this.paikeSum = paikeSum;
	}




	@Override
	public String toString() {
		return "QueCountCtext 查询合同课消统计[stuUuid=" + stuUuid + ", stuName=" + stuName
				+ ", cTextCount=" + cTextCount + ", keTotal=" + keTotal
				+ ", keDayBefore=" + keDayBefore + ", keDayAfter=" + keDayAfter
				+ ", paikeSum=" + paikeSum + "]";
	}




	public String getStuUuid() {
		return stuUuid;
	}




	public void setStuUuid(String stuUuid) {
		this.stuUuid = stuUuid;
	}




	public String getStuName() {
		return stuName;
	}




	public void setStuName(String stuName) {
		this.stuName = stuName;
	}




	public String getcTextCount() {
		return cTextCount;
	}




	public void setcTextCount(String cTextCount) {
		this.cTextCount = cTextCount;
	}




	public String getKeTotal() {
		return keTotal;
	}




	public void setKeTotal(String keTotal) {
		this.keTotal = keTotal;
	}




	public String getKeDayBefore() {
		return keDayBefore;
	}




	public void setKeDayBefore(String keDayBefore) {
		this.keDayBefore = keDayBefore;
	}




	public String getKeDayAfter() {
		return keDayAfter;
	}




	public void setKeDayAfter(String keDayAfter) {
		this.keDayAfter = keDayAfter;
	}




	public String getPaikeSum() {
		return paikeSum;
	}




	public void setPaikeSum(String paikeSum) {
		this.paikeSum = paikeSum;
	}




  public String getcMoreThan() {
    return cMoreThan;
  }




  public void setcMoreThan(String cMoreThan) {
    this.cMoreThan = cMoreThan;
  }
	
	
	
	
	
	
	
	

}//end class
