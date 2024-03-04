package com.somoim.app.board;

import java.sql.Date;

public class BoardDTO {

private Long boardNum;
private String userName;
private String boardTitle;
private String boardText;
private String boardWriter;
private Date boardDate;
private Long boardCategory;
private Long boardSecret;
public Long getBoardSecret() {
	return boardSecret;
}
public void setBoardSecret(Long boardSecret) {
	this.boardSecret = boardSecret;
}
public Long getBoardCategory() {
	return boardCategory;
}
public void setBoardCategory(Long boardCategory) {
	this.boardCategory = boardCategory;
}
public Long getBoardNum() {
	return boardNum;
}
public void setBoardNum(Long boardNum) {
	this.boardNum = boardNum;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getBoardTitle() {
	return boardTitle;
}
public void setBoardTitle(String boardTitle) {
	this.boardTitle = boardTitle;
}
public String getBoardText() {
	return boardText;
}
public void setBoardText(String boardText) {
	this.boardText = boardText;
}
public String getBoardWriter() {
	return boardWriter;
}
public void setBoardWriter(String boardWriter) {
	this.boardWriter = boardWriter;
}
public Date getBoardDate() {
	return boardDate;
}
public void setBoardDate(Date boardDate) {
	this.boardDate = boardDate;
}




}
