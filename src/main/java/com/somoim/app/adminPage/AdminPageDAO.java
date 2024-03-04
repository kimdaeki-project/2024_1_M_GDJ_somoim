package com.somoim.app.adminPage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.somoim.app.board.BoardFileDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.util.Pager;


@Repository
public class AdminPageDAO {

	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.somoim.app.adminPage.AdminPageDAO.";
	

	public List<MemberDTO> list(Pager pager) throws Exception{
		return sqlSession.selectList(namespace+"list", pager);
	}

	
	public Long getTotalCount (Pager pager)throws Exception{
		return sqlSession.selectOne(namespace+"getTotalCount", pager);
	}
	
	public int add (AdminPageDTO adminPageDTO)throws Exception{
		return sqlSession.insert(namespace+"add", adminPageDTO);
	}
	public List<AdminPageDTO> placeList (AdminPageDTO adminPageDTO)throws Exception{
		return sqlSession.selectList(namespace+"placeList",adminPageDTO);
	}
	
	public int update(AdminPageDTO adminPageDTO)throws Exception{
		return sqlSession.update(namespace+"update",adminPageDTO);
	}
	public List<AdminPageDTO> adminList (AdminPageDTO adminPageDTO)throws Exception{
		return sqlSession.selectList(namespace+"adminList",adminPageDTO);
	}
	public AdminPageDTO detail (AdminPageDTO adminPageDTO)throws Exception{
		return sqlSession.selectOne(namespace+"detail", adminPageDTO);
	}
	public int delete(AdminPageDTO adminPageDTO)throws Exception{
		return sqlSession.delete(namespace+"delete", adminPageDTO);
	}
	
//	// File
//	public int setFileAdd(BoardFileDTO boardFileDTO)throws Exception{
//		return sqlSession.insert(namespace+"setFileAdd", boardFileDTO);
//	} 
//	public List<BoardFileDTO> getFileList (AdminPageDTO adminPageDTO)throws Exception{
//		return sqlSession.selectList(namespace+"getFileList", adminPageDTO);
//	}
	
}
