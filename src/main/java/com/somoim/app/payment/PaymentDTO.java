package com.somoim.app.payment;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDTO {

	private String orderId;
	private String paymentKey;
	private String customerKey;
	private String keyName;
	private Integer pTypeNum;
	private java.sql.Date paymentDay;
	private Long amount;
	private String depositKey;
	private String payMethod;
	
	@Override
	public String toString() {
		return "PaymentDTO [orderId=" + orderId + ", paymentKey=" + paymentKey + ", customerKey=" + customerKey
				+ ", keyName=" + keyName + ", pTypeNum=" + pTypeNum + ", paymentDay=" + paymentDay + ", amount="
				+ amount + ", depositKey=" + depositKey + "]";
	}
	public String getDepositKey() {
		return depositKey;
	}
	public void setDepositKey(String depositKey) {
		this.depositKey = depositKey;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public Integer getpTypeNum() {
		return pTypeNum;
	}
	public void setpTypeNum(Integer pTypeNum) {
		this.pTypeNum = pTypeNum;
	}
	public Date getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(java.sql.Date paymentDay) {
		this.paymentDay = paymentDay;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	
	
	
}
