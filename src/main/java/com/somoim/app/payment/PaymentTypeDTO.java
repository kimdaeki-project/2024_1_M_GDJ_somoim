package com.somoim.app.payment;

public class PaymentTypeDTO {

	private Long pTypeNum;
	private String pTypeName;
	private Integer pTypePrice;
	private String pTypePer;

	public Long getpTypeNum() {
		return pTypeNum;
	}
	public void setpTypeNum(Long pTypeNum) {
		this.pTypeNum = pTypeNum;
	}
	public String getpTypeName() {
		return pTypeName;
	}
	public void setpTypeName(String pTypeName) {
		this.pTypeName = pTypeName;
	}
	public Integer getpTypePrice() {
		return pTypePrice;
	}
	public void setpTypePrice(Integer pTypePrice) {
		this.pTypePrice = pTypePrice;
	}
	public String getpTypePer() {
		return pTypePer;
	}
	public void setpTypePer(String pTypePer) {
		this.pTypePer = pTypePer;
	}

}
