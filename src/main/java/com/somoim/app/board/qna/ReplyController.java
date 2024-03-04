package com.somoim.app.board.qna;

import java.util.HashMap;
import java.util.List;
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

import com.somoim.app.board.BoardDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.util.Pager;




@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	
	@PostMapping("delete")
	@ResponseBody
	public Map<String, Object> setDelete(@RequestBody BoardReplyDTO replyDTO, Pager pager, Model model)throws Exception{
		System.out.println(replyDTO);
		replyService.setDelete(replyDTO);
	 	List<BoardReplyDTO> ar = replyService.getList(pager, replyDTO);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("datas", ar);
		map.put("pager", pager);
		
		return map;
	}
	
	@PostMapping("add")
	@ResponseBody
	public Map<String, Object> setReply(Pager pager,BoardReplyDTO replyDTO, HttpSession session, Model model)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		System.out.println(replyDTO.getBoardNum());
		int result = replyService.setReply(replyDTO);
		
		List<BoardReplyDTO> ar = replyService.getList(pager, replyDTO);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("datas", ar);
		map.put("pager", pager);
		
		
		return map;
		
	}
	
	@GetMapping("list")
	@ResponseBody
	public Map<String, Object> getList(Pager pager, BoardReplyDTO replyDTO, Model model)throws Exception {
		List<BoardReplyDTO> ar = replyService.getList(pager, replyDTO);
		model.addAttribute("replyDTO",replyDTO);
		Map<String, Object> map = new HashMap<String, Object>();
		
//		model.addAttribute("data", ar);
//		model.addAttribute("pager", pager);
		map.put("datas", ar);
		map.put("pager", pager);
		return map;
//		return "board/replyListResult";
	}
	
	@PostMapping("update")
	@ResponseBody
	public int setUpdate(BoardReplyDTO boardReplyDTO)throws Exception{
		int result = replyService.setUpdate(boardReplyDTO);
		return result;
	}
	
	
}
