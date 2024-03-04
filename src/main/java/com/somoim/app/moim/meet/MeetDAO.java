package com.somoim.app.moim.meet;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class MeetDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.somoim.app.moim.meet.MeetDAO.";
	
	//list
	public List<MeetDTO> getList(MeetDTO meetDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", meetDTO);
	}
		//참여인원
	public List<Integer> partiNum(List<MeetDTO> ar) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"partiNum", ar);
	}
	
	//add
		//정모 개설
	public int add(MeetDTO meetDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", meetDTO);
	}
		//정모이미지 저장
	public int fileAdd(MeetFileDTO meetFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"fileAdd", meetFileDTO);
	}
	
	//delete
		//정모 사진 삭제
	public MeetFileDTO file(MeetDTO meetDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"file", meetDTO);
	}
		//정모 삭제
	public int delete(MeetDTO meetDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", meetDTO);
	}
	
	//모인멤
	public Integer memNum(MeetDTO meet) {
		return sqlSession.selectOne(NAMESPACE+"memNum", meet);
	}
	
	//join
	public int join(MeetMemberDTO meetMemberDTO) {
		return sqlSession.insert(NAMESPACE+"join", meetMemberDTO);
	}
	
	//contain
	public List<String> contain(MeetDTO meet) {
		return sqlSession.selectList(NAMESPACE+"contain", meet);
	}
	
	
	
}
