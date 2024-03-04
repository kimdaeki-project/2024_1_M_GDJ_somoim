package com.somoim.app.moim.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MoimReplyDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.somoim.app.moim.board.ReplyDAO.";
	
	//add
	public int add(ReplyDTO replyDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", replyDTO);
	}	
	
	//list
	public Long getTotalCount(ReplyDTO replyDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", replyDTO);
	}

	public List<ReplyDTO> getList(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", map);
	}
	
	//delete
	public int delete(ReplyDTO replyDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", replyDTO);
	}
	
	//update
	public int update(ReplyDTO replyDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update", replyDTO);
	}
	
	//reply
	public ReplyDTO info(ReplyDTO replyDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"info", replyDTO);
	}
	public int replyUpdate(ReplyDTO replyDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"replyUpdate", replyDTO);
	}
	public int reply(ReplyDTO replyDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"reply", replyDTO);
	}

}
