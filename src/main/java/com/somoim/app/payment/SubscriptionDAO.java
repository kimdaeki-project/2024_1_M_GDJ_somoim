package com.somoim.app.payment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SubscriptionDAO {

	
	@Autowired
	private SqlSession sqlSession;
	final String NAMESPACE = "com.somoim.app.payment.SubscriptionDAO.";
	
	public int setSubs (PaymentDTO paymentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setSubs",paymentDTO);
	}
	
	public SubsDTO getSubs(PaymentDTO paymentDTO)throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSubs",paymentDTO);
	}
	
	public int upDonedate(SubsDTO subsDTO)throws Exception {
		return sqlSession.update(NAMESPACE+"upDonedate",subsDTO);
	}
	
	public List<SubsDTO> getAll()throws Exception{
		return sqlSession.selectList(NAMESPACE+"getAll");
	}
	
	public int updateSVS(SubsDTO subsDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"updateSVS",subsDTO);
	}
	
}
