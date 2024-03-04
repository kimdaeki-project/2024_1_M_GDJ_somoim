package com.somoim.app.board.qna;

import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.board.BoardDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.member.role.MemberRoleDTO;
import com.somoim.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardKind")
	public Integer getKind() {
		return 0;
	}
	@ModelAttribute("active")
	public String active() {
		return "";
	}
	@ModelAttribute("board")
	public String getBoard() {
		return "문의게시판";
	}
	@ModelAttribute("category0")
	public String getcategory0() {
		return "결제";
	}
	@ModelAttribute("category1")
	public String getcategory1() {
		return "오류";
	}

	@ModelAttribute("category2")
	public String getcategory2() {
		return "이용방법";
	}
	
	
	//============================================================================
	//add
	@GetMapping("add")
	public String setAdd() throws Exception{
		return "board/add";
	}
	
	@PostMapping("add")
	public String setAdd (BoardDTO boardDTO, MultipartFile [] attachs, HttpSession session)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		boardDTO.setBoardWriter(memberDTO.getUserName());
		int result = qnaService.setAdd(boardDTO, attachs);
		
		return "redirect:./list";
	}
	
	@GetMapping("list")
	public String getList() throws Exception{
		return "board/list";
	}
	
	@GetMapping("noticeList")
	public String getListqna(Pager pager, QnaDTO boardDTO, Model model, HttpSession session)throws Exception{
		List<QnaDTO> ar = qnaService.getListQna(pager, boardDTO);
		model.addAttribute("data", ar);
		model.addAttribute("pager", pager);
		return "board/noticeList";
	}
	
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("detail", boardDTO);
		return "board/detail";
	}
	
	@PostMapping("update")
	public String setUpdate(BoardDTO boardDTO, MultipartFile [] attachs)throws Exception{
		int result = qnaService.setUpdate(boardDTO, attachs);
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String setUpdate(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO= qnaService.getDetail(boardDTO);
		model.addAttribute("DTO", boardDTO);
		return "board/update";
	}
	
	
	@PostMapping("delete")
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setDelete(boardDTO);
		return "redirect:./list";
	}
	
	@GetMapping("fnq")
	public String fnq(Model model)throws Exception{
		model.addAttribute("board", "자주하는질문");	
		return "board/fnq";
	}
	
	
	
}
