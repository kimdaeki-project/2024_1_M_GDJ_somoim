package com.somoim.app.category;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.somoim.app.board.BoardDTO;
import com.somoim.app.board.BoardFileDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.MoimDTO;
import com.somoim.app.moim.MoimFileDTO;
import com.somoim.app.util.Pager;

import oracle.net.aso.m;

@Repository
public class CategoryDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.somoim.app.category.CategoryDAO.";
	

	//동기식list
		public List<MoimDTO> list(MemberDTO memberDTO) throws Exception {
			return sqlSession.selectList(namespace+"list", memberDTO);
		}
	//비동기List
		public List<MoimDTO> getListCategory(Map<String, Object>map) throws Exception{
			return sqlSession.selectList(namespace+"getListCategory", map);
		}
		
		public Long getTotalCount(Map<String, Object>map)throws Exception{
			return sqlSession.selectOne(namespace+"getTotalCount",map);
		}
		
		
		public List<MoimFileDTO> getFileList(MoimDTO moimDTO)throws Exception{
			return sqlSession.selectList(namespace+"getFileList", moimDTO);
		}
		
	
}
