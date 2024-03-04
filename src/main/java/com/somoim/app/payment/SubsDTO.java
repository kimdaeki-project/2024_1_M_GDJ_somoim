package com.somoim.app.payment;

import java.sql.Date;

public class SubsDTO {
	
	private Long subNum;
	private String paymentKey;
	private String customerKey;
	private Integer svs;
	private Date startDate;
	private Date doneDate;
	
	
	public Long getSubNum() {
		return subNum;
	}
	public void setSubNum(Long subNum) {
		this.subNum = subNum;
	}
	public String getPaymentKey() {
		return paymentKey;
	}
	public void setPaymentKey(String paymentKey) {
		this.paymentKey = paymentKey;
	}
	public String getCustomerKey() {
		return customerKey;
	}
	public void setCustomerKey(String customerKey) {
		this.customerKey = customerKey;
	}
	public boolean getSvs() {
		return this.svs==1;
	}
	public void setSvs(boolean svs) {
		this.svs = svs?1:0;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDoneDate() {
		return doneDate;
	}
	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}
	
	
	
}
