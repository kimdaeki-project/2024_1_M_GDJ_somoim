package com.somoim.app.moim;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.member.MoimMemberDTO;
import com.somoim.app.payment.SubsDTO;

@Repository
public class MoimDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.somoim.app.moim.MoimDAO.";

	//list
	public List<MoimDTO> getList(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", memberDTO);
	}


	//add
		//모임 개설
	public int add(MoimDTO moimDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", moimDTO);
	}
		//모임이미지 저장
	public int fileAdd(MoimFileDTO moimFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"fileAdd", moimFileDTO);
	}
		//모임장 추가
	public int moimHeadAdd(MoimDTO moimDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"moimHeadAdd", moimDTO);
	}


	//delete
		//모임사진 삭제
	public MoimFileDTO file(MoimDTO moimDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"file", moimDTO);
	}
		//모임 삭제
	public int delete(MoimDTO moimDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", moimDTO);
	}


	//update
		//모임정보
	public MoimDTO getInfo(MoimDTO moimDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getInfo", moimDTO);
	}
	public int update(MoimDTO moimDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", moimDTO);
	}
	public int fileUpdate(MoimFileDTO moimFileDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"fileUpdate", moimFileDTO);
	}

	
	//memInfo
	public List<MoimMemberDTO> memInfo(MoimDTO moimDTO) {
		return sqlSession.selectList(NAMESPACE+"memInfo", moimDTO);
	}
	public Long memNum(MoimDTO moimDTO) {
		return sqlSession.selectOne(NAMESPACE+"memNum", moimDTO);
	}

	//join
	public int join(MoimMemberDTO moimMemberDTO) {
		return sqlSession.insert(NAMESPACE+"join", moimMemberDTO);
	}


	//kick
	public int kick(MoimMemberDTO moimMemberDTO) {
		return sqlSession.delete(NAMESPACE+"kick", moimMemberDTO);
	}

	//카테고리 별 숫자 카운트
	public List<Map<String, Object>> getCategoryCount ()throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCategoryCount");
	}
	
}
