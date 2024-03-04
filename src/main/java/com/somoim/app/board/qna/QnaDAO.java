package com.somoim.app.board.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.somoim.app.board.BoardDAO;
import com.somoim.app.board.BoardDTO;
import com.somoim.app.board.BoardFileDTO;
import com.somoim.app.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{


	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.somoim.app.board.qna.QnaDAO.";
	
	@Override
	public Long getTotalCount(Map<String, Object>map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getTotalCount", map);
	}

	// List
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(namespace+"getList",pager);
	}
	// List
	public List<QnaDTO> getListqna(Map<String, Object>map)throws Exception{
		return sqlSession.selectList(namespace+"getListqna", map);
	}
	
	
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(namespace+"getDetail",boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(namespace+"setAdd", boardDTO);
	}
	
	public int setFileAdd(BoardFileDTO boardFileDTO)throws Exception{
		return sqlSession.insert(namespace+"setFileAdd", boardFileDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"setUpdate",boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"setDelete",boardDTO);
	}

	public List<BoardFileDTO> getFileList(BoardDTO boardDTO)throws Exception{
		return sqlSession.selectList(namespace+"getFileList", boardDTO);
	}
	}


