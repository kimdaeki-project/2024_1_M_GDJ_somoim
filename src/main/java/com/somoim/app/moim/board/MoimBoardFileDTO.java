package com.somoim.app.moim.board;

import com.somoim.app.files.FileDTO;

public class MoimBoardFileDTO extends FileDTO{
	private Long boardNum;

	public Long getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
}
