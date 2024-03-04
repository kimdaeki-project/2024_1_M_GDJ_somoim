package com.somoim.app.payment;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.somoim.app.member.MemberDTO;

@Controller
@RequestMapping("/pay/*")
public class PaymentController {
	

	@Autowired
	private PaymentService paymentService;	
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@PostMapping("webhook")
	@ResponseBody
	public boolean webHook(@RequestBody Map<String, Object> map, PaymentDTO paymentDTO, OrdersDTO order)throws Exception {
		return paymentService.webHookService(map, paymentDTO, order);
	}
	
	@GetMapping("paypopup")
	public String setPaymentType(PaymentTypeDTO pTypeDTO, Model model)throws Exception {
		PaymentTypeDTO paymentTypeDTO = paymentService.getPaymentType(pTypeDTO);
		model.addAttribute("type",paymentTypeDTO);
		return "./payment/paymentpopup";
	}
	
	@PostMapping("payment")
	@ResponseBody
	public Map<String, Object> payment(@RequestBody Map<String, Object> reqMap, OrdersDTO ordersDTO, ClientDTO clientDTO, HttpSession session)throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		return paymentService.paymentReseponse(reqMap, ordersDTO, clientDTO, memberDTO);		
	}

	@GetMapping("success")
	public String paySuccess() throws Exception {
		return "./payment/success";
	}
	
	@GetMapping("fail")
	public String payFail()throws Exception{
		return "./payment/fail";
	}
	
	@PostMapping("confirm")
	@ResponseBody
	public Map<String, Object> payConfirm(@RequestBody PaymentDTO paymentDTO)throws Exception{
		Map<String, Object> map = paymentService.paymentProcess(paymentDTO);
		if((boolean)(map.get("result"))&&map.get("accountName")==null) {
			paymentDTO = (PaymentDTO)map.get("DTO");
			subscriptionService.setSubs(paymentDTO);
		}
		map.remove("DTO");
		return map;
	}
	
}

