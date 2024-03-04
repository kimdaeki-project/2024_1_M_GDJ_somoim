package com.somoim.app.moim.member;


import java.sql.Date;

public class MoimMemberDTO {
	private String userName;
	private Long moimRoleNum;
	private Long moimNum;
	private Date joinDate;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getMoimRoleNum() {
		return moimRoleNum;
	}
	public void setMoimRoleNum(Long moimRoleNum) {
		this.moimRoleNum = moimRoleNum;
	}
	public Long getMoimNum() {
		return moimNum;
	}
	public void setMoimNum(Long moimNum) {
		this.moimNum = moimNum;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
	

}
