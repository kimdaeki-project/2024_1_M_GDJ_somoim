package com.somoim.app.board.qna;

import java.util.List;

import com.somoim.app.board.BoardDTO;
import com.somoim.app.board.BoardFileDTO;
// boardDTO 상속 받아서사용 (getters, setters, 테이블 명 동일) 
public class QnaDTO  extends BoardDTO{

	
	private List<BoardFileDTO> fileDTOs;

	public List<BoardFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<BoardFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	
	private Long boardSecret;

	public Long getBoardSecret() {
		return boardSecret;
	}

	public void setBoardSecret(Long boardSecret) {
		this.boardSecret = boardSecret;
	}
}
