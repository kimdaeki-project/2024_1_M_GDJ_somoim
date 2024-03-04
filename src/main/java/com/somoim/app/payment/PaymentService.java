package com.somoim.app.payment;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.somoim.app.member.MemberDTO;

@Service
public class PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;
	
	@Autowired
	private SecretKey secretKey;
	
	@Autowired
	private ConvertBankCode convertBankCode;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	public List<Map<String, Object>> getPaymentList(MemberDTO memberDTO)throws Exception{
		return paymentDAO.getPaymentList(memberDTO);
	}
	
	public Map<String, Object> paymentReseponse(Map<String, Object> reqMap, OrdersDTO ordersDTO, ClientDTO clientDTO, MemberDTO memberDTO) throws Exception {
		ObjectMapper om = new ObjectMapper();
		ordersDTO = om.convertValue(reqMap.get("ordersDTO"),OrdersDTO.class);
		clientDTO = om.convertValue(reqMap.get("clientDTO"), ClientDTO.class);
		memberDTO = paymentDAO.getCustomerKey(memberDTO);
		ordersDTO.setCustomerKey(memberDTO.getCustomerKey());
		OrdersDTO newOrder = getOrders(ordersDTO);
		
		if(newOrder!=null) {
			ordersDTO = newOrder;
		}else {
			ordersDTO.creatOderId();
			ordersDTO.setOrderStatus(0);
			paymentDAO.setOrders(ordersDTO);
		}

		clientDTO = paymentDAO.getClientKey(clientDTO);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orders", ordersDTO);
		map.put("client", clientDTO);
		
		return map;
	}

	public List<PaymentTypeDTO> getPaymentTypeList() throws Exception{
		return paymentDAO.getPaymentTypeList();
	}

	public PaymentTypeDTO getPaymentType(PaymentTypeDTO pTypeDTO)throws Exception{
		return paymentDAO.getPaymentType(pTypeDTO);
	}
	
	public MemberDTO getCustomerKey(MemberDTO memberDTO)throws Exception {
		return paymentDAO.getCustomerKey(memberDTO); 
	}
	
	public ClientDTO getClientKey(ClientDTO clientDTO)throws Exception{
		return paymentDAO.getClientKey(clientDTO);
	}
	
	public int setOrders(OrdersDTO ordersDTO)throws Exception{
		ordersDTO.setOrderStatus(0);
		int result = paymentDAO.setOrders(ordersDTO);
		return result;
	}
	
	public OrdersDTO getOrders(OrdersDTO ordersDTO)throws Exception {
		return paymentDAO.getOrders(ordersDTO);
	}
	
	public int upOrders(OrdersDTO ordersDTO)throws Exception{
		return paymentDAO.upOrders(ordersDTO);
	}
	
	public OrdersDTO searchOrder(OrdersDTO ordersDTO)throws Exception{
		return paymentDAO.searchOrder(ordersDTO);
	}
	
	public int setPayment(PaymentDTO paymentDTO)throws Exception{
		return paymentDAO.setPayment(paymentDTO);
	}
	
	public PaymentDTO getPayment(PaymentDTO paymentDTO)throws Exception{
		return paymentDAO.getPayment(paymentDTO);
	}
	
	public PaymentDTO setPaymentDate(PaymentDTO paymentDTO, String dateString)throws Exception{
		if(dateString==null) {
			return paymentDTO;
		}
		System.out.println(dateString);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
		java.sql.Date sqlDate;
		if(dateString.contains(".")) {
			Date date = format2.parse(dateString);
			sqlDate = new java.sql.Date(date.getTime());
		}else {
			Date date = format1.parse(dateString);
			sqlDate = new java.sql.Date(date.getTime());
		}
		paymentDTO.setPaymentDay(sqlDate);
		System.out.println("setPaymentDate:"+paymentDTO);
		return paymentDTO;
	}
	
	public int upPayment(PaymentDTO paymentDTO)throws Exception{
		return paymentDAO.upPayment(paymentDTO);
	}
	
	public boolean webHookService(Map<String, Object> map, PaymentDTO paymentDTO, OrdersDTO order)throws Exception {
		order.setOrderId((String)map.get("orderId"));
		paymentDTO.setOrderId((String)map.get("orderId"));
		paymentDTO = paymentDAO.getPayment(paymentDTO);
		String secret = (String)map.get("secret");
		String depositKey = paymentDTO.getDepositKey(); 
		if(!secret.equals(depositKey)) {
			return false;
		}else {
			if(map.get("status").equals("CANCELED")) {
				order.setOrderStatus(2);
				paymentDAO.upOrders(order);
				return true;
			}
			
			order.setOrderStatus(1);
			paymentDAO.upOrders(order);
			
			String dateString = (String)map.get("createdAt");
			paymentDTO = setPaymentDate(paymentDTO, dateString);
			paymentDAO.upPayment(paymentDTO);
			subscriptionService.setSubs(paymentDTO);
			
			return true;
		}	
	}
	
	public Map<String, Object> paymentProcess(PaymentDTO paymentDTO)throws Exception {
		//토스 결제 시크릿키 로드 후 Basic 형식으로 변환
		String secret = secretKey.getSecretKey();
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encBytes = encoder.encode((secret+":").getBytes("UTF-8"));
		String encSecret = "Basic "+new String(encBytes, 0, encBytes.length);
	//토스 결제승인 API 호출
		URL address = new URL("https://api.tosspayments.com/v1/payments/confirm");
		HttpURLConnection connection = (HttpURLConnection)address.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", encSecret);
		connection.setRequestProperty("Content-type", "application/json");
		connection.setDoOutput(true);
	//파라미터값 JSON으로 작성해서 리퀘스트
		ObjectMapper objm = new ObjectMapper();
		String json=objm.writeValueAsString(paymentDTO);
		connection.getOutputStream().write(json.toString().getBytes("UTF-8"));
	//리스폰스 수신해서 리스폰스 수신값 및 호출결과 확인
		int code = connection.getResponseCode();
		boolean check = code == 200?true : false;
		
	//리스폰스가 true면 인풋스트림 false면 에러스트림 작성
		InputStream responseStream = check?connection.getInputStream():connection.getErrorStream();
		
		
	//리스폰스 결과 JSON으로 작성 후 HashMap으로 저장	
		Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
		Object obj = objm.readValue(reader, Object.class);
		String response = objm.writeValueAsString(obj);
		Map<String, Object> responseMap = objm.readValue(response, new TypeReference<HashMap<String, Object>>(){});
		Map<String, Object> resultMap = new HashMap<String, Object>();
	//결제 결과 저장할 ordersDTO DB에서 꺼내옴
		OrdersDTO ordersDTO = new OrdersDTO();
		ordersDTO.setOrderId(paymentDTO.getOrderId());
		ordersDTO = paymentDAO.searchOrder(ordersDTO);
		responseStream.close();
	//리스폰스 결과 체크하여 클라이언트에 리스폰스할 Map 작성
		if(check) {
			String dateString = (String)responseMap.get("approvedAt");
			resultMap.put("message","결제 승인 완료");
			if(dateString==null) {
				dateString = (String)responseMap.get("requestedAt");
				resultMap.put("message","입금 대기 상태입니다.");
				Map<String, Object> account = (Map<String, Object>)responseMap.get("virtualAccount");
				resultMap.put("accountNum", account.get("accountNumber"));
				String bank = (String)account.get("bankCode");
				bank = convertBankCode.getBankName(bank);
				resultMap.put("accountName", bank);
			}
			System.out.println(responseMap);
			paymentDTO = setPaymentDate(paymentDTO, dateString);				
			Integer amount = (Integer)responseMap.get("totalAmount");
			paymentDTO.setAmount(amount.longValue());
			paymentDTO.setCustomerKey(ordersDTO.getCustomerKey());
			paymentDTO.setpTypeNum(ordersDTO.getpTypeNum());
			paymentDTO.setDepositKey((String)responseMap.get("secret"));
			paymentDTO.setPayMethod((String)responseMap.get("method"));
			System.out.println(paymentDTO);
		//주문정보 결제완료로 수정
			ordersDTO.setOrderStatus(1);
			resultMap.put("orderName",responseMap.get("orderName"));
			resultMap.put("amount",paymentDTO.getAmount());
			resultMap.put("paymentDay", dateString);
			resultMap.put("DTO", paymentDTO);
			resultMap.put("result",true);
		//결과를 DB에 저장함
			paymentDAO.upOrders(ordersDTO);
			System.out.println("paymentProcess:"+paymentDTO);
			paymentDAO.setPayment(paymentDTO);
			return resultMap;
		}else {
			resultMap.put("message", responseMap.get("message"));
			resultMap.put("amount",paymentDTO.getAmount());
			resultMap.put("result",false);
		//이미 처리된 결제인지 결제 자체가 안된 것이지 판단하여 주문정보 수정
			if(responseMap.get("message").equals("이미 처리된 결제 입니다.")) {
				ordersDTO.setOrderStatus(1);
			}else {
				ordersDTO.setOrderStatus(2);
			}
			upOrders(ordersDTO);
			return resultMap;
		}
	}
}
