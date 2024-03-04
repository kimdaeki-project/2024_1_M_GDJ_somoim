package com.somoim.app.moim.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.somoim.app.moim.MoimDTO;
import com.somoim.app.util.Pager;

@Repository
public class MoimBoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.somoim.app.moim.board.BoardDAO.";
	
	//list
	public Long getTotalCount(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", map);
	}
	public List<Object> list(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list", map);
	}
	
	//add
	public int add(MoimBoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", boardDTO);
	}
	public int fileAdd(MoimBoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"fileAdd", boardFileDTO);
	}
	
	//detail
	public MoimBoardDTO detail(MoimBoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail", boardDTO);
	}
	
	//update
	public int update(MoimBoardDTO boardDTO) {
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}
	
	//delete
	public List<MoimBoardFileDTO> file(MoimBoardDTO boardDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"file", boardDTO);
	}
	public int delete(MoimBoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", boardDTO);
	}
	
	//click
	public int click(MoimBoardDTO boardDTO) {
		return sqlSession.update(NAMESPACE+"click", boardDTO);
	}
	

	
}
