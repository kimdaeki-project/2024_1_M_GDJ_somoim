package com.somoim.app.moim.board;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.member.MemberDTO;
import com.somoim.app.util.Pager;

@Controller
@RequestMapping("/moim/main/reply/*")
public class MoimReplyController {
	@Autowired
	private MoimReplyService replyService;
	
	
	
	//add
	@PostMapping("add")
	public String add(Pager pager, ReplyDTO replyDTO, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		replyDTO.setReplyWriter(memberDTO.getNickName());
		
		if( memberDTO.getProfile() != null) {
			
			replyDTO.setReplyProfile(memberDTO.getProfile().getFileName());
		}
		int result = replyService.add(replyDTO);
		
		//조회
		List<ReplyDTO> ar = replyService.getList(replyDTO, pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "moim/main/board/replyListResult";
	}
	
	//list
	@GetMapping("list")
	public String getList(ReplyDTO replyDTO, Model model, Pager pager) throws Exception{
		List<ReplyDTO> ar = replyService.getList(replyDTO, pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "moim/main/board/replyListResult";
	}
	
	//delete
	@PostMapping("delete")
	public String delete(ReplyDTO replyDTO, Model model, Pager pager) throws Exception{
		int result = replyService.delete(replyDTO);
		//
		List<ReplyDTO> ar = replyService.getList(replyDTO, pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "moim/main/board/replyListResult";
	}
	
	//update
	@PostMapping("update")
	public String update(ReplyDTO replyDTO, Model model, Pager pager) throws Exception{
		int result = replyService.update(replyDTO);
		//
		List<ReplyDTO> ar = replyService.getList(replyDTO, pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "moim/main/board/replyListResult";
	}
	
	//reply
	@PostMapping("reply")
	public String reply(ReplyDTO replyDTO, Model model, Pager pager, HttpSession session) throws Exception{
		
		
		int result = replyService.info(replyDTO,session);
		
		//조회
		List<ReplyDTO> ar = replyService.getList(replyDTO, pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "moim/main/board/replyListResult";
	}
	
}
