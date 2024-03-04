package com.somoim.app.moim.meet;


public class MeetDTO {
	private Long meetNum;
	private Long moimNum;
	private String meetName;
	private String meetDate;
	private String meetPlace;
	private Long meetCost;
	private Long meetCount;
	private String meetX;
	private String meetY;
	private String meetHead;
	
	
	
	public String getMeetHead() {
		return meetHead;
	}
	public void setMeetHead(String meetHead) {
		this.meetHead = meetHead;
	}
	private MeetFileDTO meetFileDTO;
	
	
	public MeetFileDTO getMeetFileDTO() {
		return meetFileDTO;
	}
	public void setMeetFileDTO(MeetFileDTO meetFileDTO) {
		this.meetFileDTO = meetFileDTO;
	}
	public Long getMeetNum() {
		return meetNum;
	}
	public void setMeetNum(Long meetNum) {
		this.meetNum = meetNum;
	}
	public Long getMoimNum() {
		return moimNum;
	}
	public void setMoimNum(Long moimNum) {
		this.moimNum = moimNum;
	}
	public String getMeetName() {
		return meetName;
	}
	public void setMeetName(String meetName) {
		this.meetName = meetName;
	}

	public String getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(String meetDate) {
		this.meetDate = meetDate;
	}
	public String getMeetPlace() {
		return meetPlace;
	}
	public void setMeetPlace(String meetPlace) {
		this.meetPlace = meetPlace;
	}
	public Long getMeetCost() {
		return meetCost;
	}
	public void setMeetCost(Long meetCost) {
		this.meetCost = meetCost;
	}
	public Long getMeetCount() {
		return meetCount;
	}
	public void setMeetCount(Long meetCount) {
		this.meetCount = meetCount;
	}
	public String getMeetX() {
		return meetX;
	}
	public void setMeetX(String meetX) {
		this.meetX = meetX;
	}
	public String getMeetY() {
		return meetY;
	}
	public void setMeetY(String meetY) {
		this.meetY = meetY;
	}
//	@Override
//	public String toString() {
//		return "MeetDTO [meetNum=" + meetNum + ", moimNum=" + moimNum + ", meetName=" + meetName + ", meetDate="
//				+ meetDate + ", meetPlace=" + meetPlace + ", meetCost=" + meetCost + ", meetCount=" + meetCount
//				+ ", meetX=" + meetX + ", meetY=" + meetY + ", meetFileDTO=" + meetFileDTO + "]";
//	}
	
	
}
