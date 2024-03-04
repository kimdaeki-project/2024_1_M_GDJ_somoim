package com.somoim.app.member;

import java.util.UUID;

import com.somoim.app.member.role.MemberRoleDTO;

public class MemberDTO {

	private String userName;
	private String password;
	private String nickName;
	private String name;
	private String userBirth;
	private String address;
	private String phone;
	private String email;
	private String customerKey;
	private Long loginNum;
	private MemberRoleDTO roleDTO;
	
	
	private ProfileDTO profile;
	



	public String creatCustomerKey() {
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString();
		String[] arr = uuidString.split("-");
		return arr[0]+"-"+arr[1];
	}
	
	
	public String getCustomerKey() {
		return customerKey;
	}
	public void setCustomerKey(String customerKey) {	
		this.customerKey = customerKey;
	}

	public MemberRoleDTO getRoleDTO() {
		return roleDTO;
	}
	public void setRoleDTO(MemberRoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public ProfileDTO getProfile() {
		return profile;
	}
	public void setProfile(ProfileDTO profile) {
		this.profile = profile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(Long loginNum) {
		this.loginNum = loginNum;
	}


	@Override
	public String toString() {
		return "MemberDTO [userName=" + userName + ", password=" + password + ", nickName=" + nickName + ", name="
				+ name + ", userBirth=" + userBirth + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", customerKey=" + customerKey + ", loginNum=" + loginNum + ", profile=" + profile + ", roleDTO="
				+ roleDTO + "]";
	}
	
	

}
