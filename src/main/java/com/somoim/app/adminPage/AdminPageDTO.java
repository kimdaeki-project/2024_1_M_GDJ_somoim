package com.somoim.app.adminPage;

import java.util.List;

import com.somoim.app.board.BoardFileDTO;

public class AdminPageDTO {

	
	private Long placeNum;
	private String userName;
	private String placeTitle;
	private String placeAddress;
	private String placeLink;
	private String placeImageLink;
	
	
	public String getPlaceImageLink() {
		return placeImageLink;
	}
	public void setPlaceImageLink(String placeImageLink) {
		this.placeImageLink = placeImageLink;
	}
	public Long getPlaceNum() {
		return placeNum;
	}
	public void setPlaceNum(Long placeNum) {
		this.placeNum = placeNum;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPlaceTitle() {
		return placeTitle;
	}
	public void setPlaceTitle(String placeTitle) {
		this.placeTitle = placeTitle;
	}
	public String getPlaceAddress() {
		return placeAddress;
	}
	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}
	public String getPlaceLink() {
		return placeLink;
	}
	public void setPlaceLink(String placeLink) {
		this.placeLink = placeLink;
	}
	
	

	
	
}
