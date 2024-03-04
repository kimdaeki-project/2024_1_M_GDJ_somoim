package com.somoim.app.payment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.somoim.app.member.MemberDTO;

@Repository
public class PaymentDAO {

	@Autowired
	private SqlSession sqlSession;
	final String NAMESPACE = "com.somoim.app.payment.PaymentDAO.";

	public List<PaymentTypeDTO> getPaymentTypeList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getPaymentTypeList");
	}

	public PaymentTypeDTO getPaymentType(PaymentTypeDTO pTypeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getPaymentType", pTypeDTO);
	}
	
	public MemberDTO getCustomerKey(MemberDTO memberDTO)throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCustomerKey", memberDTO);
	}
	
	public ClientDTO getClientKey(ClientDTO clientDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getClientKey",clientDTO);
	}
	
	public int setOrders(OrdersDTO ordersDTO)throws Exception {
		return sqlSession.insert(NAMESPACE+"setOrders",ordersDTO);
	}
	
	public OrdersDTO getOrders(OrdersDTO ordersDTO)throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getOrders", ordersDTO);
	}
	
	public int upOrders(OrdersDTO ordersDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"upOrders", ordersDTO);
	}
	
	public OrdersDTO searchOrder(OrdersDTO ordersDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"searchOrder", ordersDTO);
	}
	
	public int setPayment(PaymentDTO paymentDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setPayment", paymentDTO);
	}
	
	public PaymentDTO getPayment(PaymentDTO paymentDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getPayment", paymentDTO);
	}
	
	public int upPayment(PaymentDTO paymentDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"upPayment", paymentDTO);
	}
	
	public List<Map<String, Object>> getPaymentList(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getPaymentList",memberDTO);
	}
}
