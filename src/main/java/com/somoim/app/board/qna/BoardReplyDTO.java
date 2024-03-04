package com.somoim.app.board.qna;

import java.sql.Date;

import oracle.sql.DATE;

public class BoardReplyDTO {

	private Long boardReplyNum;
	private String userName;
	private Long boardNum;
	private String boardReplyText;
	private Date boardReplyDate;
	public Long getBoardReplyNum() {
		return boardReplyNum;
	}
	public void setBoardReplyNum(Long boardReplyNum) {
		this.boardReplyNum = boardReplyNum;
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
	public String getBoardReplyText() {
		return boardReplyText;
	}
	public void setBoardReplyText(String boardReplyText) {
		this.boardReplyText = boardReplyText;
	}
	public Date getBoardReplyDate() {
		return boardReplyDate;
	}
	public void setBoardReplyDate(Date boardReplyDate) {
		this.boardReplyDate = boardReplyDate;
	}
	@Override
	public String toString() {
		return "BoardReplyDTO [boardReplyNum=" + boardReplyNum + ", userName=" + userName + ", boardNum=" + boardNum
				+ ", boardReplyText=" + boardReplyText + ", boardReplyDate=" + boardReplyDate + "]";
	}
	
	
	
	
	
}
