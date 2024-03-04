package com.somoim.app.board.notice;

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
public class NoticeDAO  implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;

	private final String namespace="com.somoim.app.board.notice.NoticeDAO.";

	@Override
	public Long getTotalCount(Map<String, Object>map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getTotalCount", map);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getList", pager);
	}


	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"setAdd", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return  sqlSession.delete(namespace+"setDelete", boardDTO);
	}

	public int setFileAdd(BoardFileDTO boardFileDTO)throws Exception{
		return sqlSession.insert(namespace+"setFileAdd", boardFileDTO);
	}


	public List<BoardFileDTO> getFileList(BoardDTO boardDTO)throws Exception{
		return sqlSession.selectList(namespace+"getFileList", boardDTO);
	}

	public List<BoardDTO> getListJson(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(namespace+"getListJson", map);
	}


}
