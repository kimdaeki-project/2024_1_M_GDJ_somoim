package com.somoim.app.member;

import com.somoim.app.files.FileDTO;

public class ProfileDTO extends FileDTO {

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
