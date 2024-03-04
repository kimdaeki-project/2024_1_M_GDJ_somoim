package com.somoim.app.moim.board;

import java.sql.Timestamp;

public class ReplyDTO {
	private Long replyNum;
	private String userName;
	private Long boardNum;
	private String replyText;
	private Timestamp replyDate;
	private String replyWriter;
	private Long replyRef;
	private Long replyStep;
	private String replyProfile;
	private String parent;
	
	
	
	public String getReplyProfile() {
		return replyProfile;
	}
	public void setReplyProfile(String replyProfile) {
		this.replyProfile = replyProfile;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public Long getReplyRef() {
		return replyRef;
	}
	public void setReplyRef(Long replyRef) {
		this.replyRef = replyRef;
	}
	public Long getReplyStep() {
		return replyStep;
	}
	public void setReplyStep(Long replyStep) {
		this.replyStep = replyStep;
	}
	public Long getReplyDepth() {
		return replyDepth;
	}
	public void setReplyDepth(Long replyDepth) {
		this.replyDepth = replyDepth;
	}
	private Long replyDepth;
	
	public Long getReplyNum() {
		return replyNum;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public void setReplyNum(Long replyNum) {
		this.replyNum = replyNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public Timestamp getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}
	
	
	
}
