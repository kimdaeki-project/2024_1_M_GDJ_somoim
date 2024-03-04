package com.somoim.app.mypage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MypageDAO {


	@Autowired
	private SqlSession sqlSession;
	final String NAMESPACE = "com.somoim.app.mypage.MypageDAO.";
}
