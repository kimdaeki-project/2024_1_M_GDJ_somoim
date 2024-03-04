package com.somoim.app.moim.board;


import java.sql.Date;
import java.util.List;

public class MoimBoardDTO {
	private Long boardNum;
	private String userName;
	private Long moimNum;
	private String boardTitle;
	private String boardText;
	private Date boardDate;
	private Long boardClick;
	private Long boardLike;
	private String boardWriter;
	private String boardProfile;
	
	private List<MoimBoardFileDTO> fileDTOs;



	public String getBoardProfile() {
		return boardProfile;
	}

	public void setBoardProfile(String boardProfile) {
		this.boardProfile = boardProfile;
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

	public Long getMoimNum() {
		return moimNum;
	}

	public void setMoimNum(Long moimNum) {
		this.moimNum = moimNum;
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

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public Long getBoardClick() {
		return boardClick;
	}

	public void setBoardClick(Long boardClick) {
		this.boardClick = boardClick;
	}

	public Long getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(Long boardLike) {
		this.boardLike = boardLike;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public List<MoimBoardFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<MoimBoardFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	
	
}
