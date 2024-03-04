package com.somoim.app.payment;

import java.sql.Date;
import java.util.UUID;

public class OrdersDTO {

	private String orderId;
	private String customerKey;
	private Date oderDate;
	private Integer orderStatus;
	private Integer amount;
	private Integer pTypeNum;	


	@Override
	public String toString() {
		return "OrdersDTO [orderId=" + orderId + ", customerKey=" + customerKey + ", oderDate=" + oderDate
				+ ", orderStatus=" + orderStatus + ", amount=" + amount + ", pTypeNum=" + pTypeNum + "]";
	}

	public void creatOderId() {
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString();
		String[] arr = uuidString.split("-");
		this.orderId = arr[0]+"-"+arr[2]+"-"+arr[3]; 
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerKey() {
		return customerKey;
	}
	public void setCustomerKey(String customerKey) {
		this.customerKey = customerKey;
	}
	public Date getOderDate() {
		return oderDate;
	}
	public void setOderDate(Date oderDate) {
		this.oderDate = oderDate;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer oderStatus) {
		this.orderStatus = oderStatus;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getpTypeNum() {
		return pTypeNum;
	}
	public void setpTypeNum(Integer pTypeNum) {
		this.pTypeNum = pTypeNum;
	}

}