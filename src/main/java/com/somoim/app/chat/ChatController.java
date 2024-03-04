package com.somoim.app.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.somoim.app.member.MemberDTO;
import com.somoim.app.member.MemberService;
import com.somoim.app.moim.MoimDTO;

@Controller
//@RequestMapping("/chat/*")
public class ChatController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private ChatMessageService chatMessageService;

	@GetMapping("/chat")
	public ModelAndView chat(HttpSession session,ChatMessageDTO chatMessageDTO, MemberDTO memberDTO, ModelAndView mv) throws Exception{
		if(session.getAttribute("member") == null) {
			mv.addObject("msg","로그인 해주세요.");
			mv.addObject("path", "/member/login");
			mv.setViewName("/chat/resultLogin");
			return mv;
		}
		
		memberDTO = (MemberDTO)session.getAttribute("member");
		MemberDTO dto = memberService.getLogin(memberDTO);
		
		mv.addObject("roomNum",session.getAttribute("roomNum"));
		List<MoimDTO> moimChatInfo = chatMessageService.moimChatInfo(dto);
		mv.addObject("moimInfo", moimChatInfo);
		
		mv.addObject("user",dto);
		mv.setViewName("/chat/chating");
		return mv;
	}
	
	@GetMapping("/chat/room")
	@ResponseBody
	public Map<String, Object> chatRecord(HttpSession session, ChatMessageDTO chatMessageDTO, Model model) {
		session.setAttribute("roomNum", chatMessageDTO.getChatRoomNum());
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		chatMessageDTO.setUserName(member.getUserName());
		List<ChatMessageDTO> chatHistory = chatMessageService.chatHistory(chatMessageDTO);
		List<MemberDTO> chatUser = chatMessageService.chatUserList(chatMessageDTO);
		
		// -> jsp
		model.addAttribute("roomNum", chatMessageDTO.getChatRoomNum());
		model.addAttribute("chatHistory", chatHistory);
		model.addAttribute("chatUser", chatUser);
		// -> js
		Map<String, Object> map = new HashMap<>();
		map.put("record", chatHistory);
		map.put("roomNum", chatMessageDTO.getChatRoomNum());
		map.put("chatUser", chatUser);
		return map;
	}
	
	@GetMapping("/chat/roomList")
	@ResponseBody
	public Map<String, Object> chatRommList(){
		Map<String, Object> map = new HashMap<>();
		
		return map;
	}
}

