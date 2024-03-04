package com.somoim.app.board;

import java.util.List;
import java.util.Map;

import com.somoim.app.util.Pager;

//다른 게시판에서 상속받아 사용하기위해 interface 선언
public interface BoardDAO {

	//totalCount 매개변수 page로 넘겨줘야함
	public Long getTotalCount(Map<String, Object> map)throws Exception;

	//list 매개변수 page로 넘겨줘야함
	public List<BoardDTO> getList(Pager pager)throws Exception;

	//detail
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;

	//add
	public int setAdd(BoardDTO boardDTO)throws Exception;

	//update
	public int setUpdate(BoardDTO boardDTO)throws Exception;

	//delete
	public int setDelete(BoardDTO boardDTO)throws Exception;
}
