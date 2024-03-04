package com.somoim.app.moim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.chat.ChatMessageDTO;
import com.somoim.app.chat.ChatMessageService;
import com.somoim.app.chat.moim.MoimChatDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.member.MoimMemberDTO;
import com.somoim.app.payment.PaymentDTO;
import com.somoim.app.payment.PaymentService;
import com.somoim.app.payment.SubsDTO;
import com.somoim.app.payment.SubscriptionService;

@Controller
@RequestMapping("/moim/*")
public class MoimController {
	@Autowired
	private MoimService moimService;
	@Autowired
	private ChatMessageService chatMessageService; 
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private SubscriptionService subscriptionService;

	//모임 리스트
	@GetMapping("list")
	public void getList(HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		List<MoimDTO> ar = moimService.getList(memberDTO);
		model.addAttribute("list", ar);
	}

	//모임 개설
	@GetMapping("add")
	public String add(HttpSession session, Model model)throws Exception  {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = paymentService.getCustomerKey(memberDTO);
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setCustomerKey(memberDTO.getCustomerKey());
		SubsDTO subsDTO = subscriptionService.getSubs(paymentDTO);
		boolean result = subsDTO==null?false:subsDTO.getSvs();
		if(result) {
			return "moim/add";
		}else {
			model.addAttribute("msg","구독권을 결제해야 모임개설 가능");
			model.addAttribute("path","../mypage/pay");
			return "moim/resultAlert";
		}
	}
	@PostMapping("add")
	public String add(MoimDTO moimDTO, MultipartFile file, HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		moimDTO.setMoimHead(memberDTO.getUserName());


		moimService.add(moimDTO, file, memberDTO);

		return "redirect:./list";

	}

	//delete
	@PostMapping("delete")
	public String delete(MoimDTO moimDTO, HttpSession session, Model model) throws Exception {

		int result = moimService.delete(moimDTO);

		//다시 조회
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		List<MoimDTO> ar = moimService.getList(memberDTO);
		model.addAttribute("list", ar);

		return "moim/ajaxList";

	}

	//update 모임수정
	@GetMapping("update")
	public void update(MoimDTO moimDTO, Model model) throws Exception {
		moimDTO = moimService.getInfo(moimDTO);
		model.addAttribute("dto", moimDTO);
	}
	@PostMapping("update")
	public String update(MoimDTO moimDTO, MultipartFile file) throws Exception {
		int result = moimService.update(moimDTO, file);
		
		return "redirect:./list";
		
	}
	
	
	//-----------------------------------------------MAIN-------------------------------------------------------
	
	
	//home
	@GetMapping("main/home")
	public Map<String, Object> detail(MoimDTO moimDTO) throws Exception {
		//모임정보
		moimDTO = moimService.getInfo(moimDTO);
		
		//회원정보
		List<MoimMemberDTO> ar = moimService.memInfo(moimDTO);
		Long memNum = moimService.memNum(moimDTO);
		
		
		//System.out.println("확인:"+ ar.get(0).getUserName());
		//System.out.println("확인2:"+ ar.size());
		List<String> contain = new ArrayList<>();
		
		for(int i=0; i<ar.size();i++) {
			contain.add(ar.get(i).getUserName());
		}
		
		//System.out.println("111:"+ contain.get(0));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("dto", moimDTO);
		map.put("contain", contain);
		map.put("memInfo", ar);
		map.put("memNum", memNum);


		return map;

	}
	
	//join
	@GetMapping("main/home/join")
	public String join(MoimMemberDTO moimMemberDTO, HttpSession session,Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		moimMemberDTO.setUserName(memberDTO.getUserName());
		
		//System.out.println("1:"+moimMemberDTO.getMoimNum());
		//System.out.println("2:"+moimMemberDTO.getUserName());
		
		int result = moimService.join(moimMemberDTO);		
		
		String msg = "다시 시도해주세요.";
		String path = "../home?moimNum="+moimMemberDTO.getMoimNum();
		if(result == 1) {
			ChatMessageDTO cdto = new ChatMessageDTO();
			MoimChatDTO c = chatMessageService.getMoimRoom(moimMemberDTO);
			cdto.setChatText(memberDTO.getNickName()+"이 들어왔습니다");
			cdto.setUserName(memberDTO.getUserName());
			cdto.setChatRoomNum(c.getChatRoomNum());
			chatMessageService.addChat(cdto);

			msg = "가입 완료";
			path = "../home?moimNum="+moimMemberDTO.getMoimNum();
		}
		model.addAttribute("msg",msg);
		model.addAttribute("path",path);
		//model.addAttribute("dto", moimDTO);
		
		return "moim/resultAlert";
	}
	
	//kick
	@PostMapping("main/home/kick")
	public void kick(MoimMemberDTO moimMemberDTO, Model model) throws Exception{
		int result = moimService.kick(moimMemberDTO);
		
	}
	
	

	
}
