package com.somoim.app.board.notice;



import java.util.List;

import com.somoim.app.board.BoardDTO;
//boardDTO 상속 받아서사용 (getters, setters, 테이블 명 동일)
import com.somoim.app.board.BoardFileDTO;
public class NoticeDTO  extends BoardDTO{




	private List<BoardFileDTO> fileDTOs;

	public List<BoardFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<BoardFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}

}
