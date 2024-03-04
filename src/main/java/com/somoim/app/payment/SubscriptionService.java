package com.somoim.app.payment;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionDAO subscriptionDAO;
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	public SubsDTO getSubs(PaymentDTO paymentDTO)throws Exception {
		return subscriptionDAO.getSubs(paymentDTO);
	}
	
	public List<SubsDTO> getAll()throws Exception{
		return subscriptionDAO.getAll();
	}
	
	public int updateSVS(SubsDTO subsDTO)throws Exception {
		return subscriptionDAO.updateSVS(subsDTO);
	}
	
	public int setSubs(PaymentDTO paymentDTO)throws Exception {
		SubsDTO subsDTO = subscriptionDAO.getSubs(paymentDTO);
		if(subsDTO == null) {
			subscriptionDAO.setSubs(paymentDTO);
			subsDTO = subscriptionDAO.getSubs(paymentDTO);
		}
		subsDTO.setSvs(true);
		updateSVS(subsDTO);
		PaymentTypeDTO p = new PaymentTypeDTO();
		int pTypeNum = paymentDTO.getpTypeNum();
		p.setpTypeNum((long)pTypeNum);
		p = paymentDAO.getPaymentType(p);
		
		subsDTO = calcuDoneDate(p.getpTypePer(), subsDTO);
			
		return subscriptionDAO.upDonedate(subsDTO);
	}
	
	public SubsDTO calcuDoneDate(String pTypeNum, SubsDTO subsDTO) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(pTypeNum);
		String number = "";
		while(matcher.find()) {
			number = matcher.group();
		}
		int subsDoneDate = Integer.parseInt(number);
		Date startDate = null;
		if(subsDTO.getDoneDate()==null) {
			startDate = (Date)subsDTO.getStartDate(); 
		}else {
			startDate = (Date)subsDTO.getDoneDate();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		
		calendar.add(Calendar.MONTH, subsDoneDate);
		
		java.util.Date util = calendar.getTime();
		java.sql.Date sql = new java.sql.Date(util.getTime());
		
		subsDTO.setDoneDate(sql);
		
		return subsDTO;
	}
	
}
