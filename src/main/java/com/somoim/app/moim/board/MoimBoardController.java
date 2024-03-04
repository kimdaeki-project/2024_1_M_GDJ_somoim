package com.somoim.app.moim.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.input.MessageDigestCalculatingInputStream.MessageDigestMaintainingObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.MoimDTO;
import com.somoim.app.util.Pager;

@Controller
@RequestMapping("/moim/main/board/*")
public class MoimBoardController {
	@Autowired
	private MoimBoardService moimBoardService;
	
	//list
	@GetMapping("list")
	public void list(MoimBoardDTO boardDTO, Pager pager ,Model model) throws Exception {
		List<Object> ar = moimBoardService.list(pager, boardDTO);
		
		model.addAttribute("moimDTO", boardDTO);
		model.addAttribute("list", ar);

	}
	
	//add
	@GetMapping("add")
	public void add(MoimDTO moimDTO, Model model) throws Exception {
		model.addAttribute("dto",moimDTO);
	}
	@PostMapping("add")
	public String add(MoimBoardDTO boardDTO, HttpSession session, MultipartFile[] file) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		if(memberDTO.getProfile() != null) {			
			boardDTO.setBoardProfile(memberDTO.getProfile().getFileName());
		}
		boardDTO.setBoardWriter(memberDTO.getNickName());
		//boardDTO.setBoardWriter(memberDTO.getUserName());
		boardDTO.setUserName(memberDTO.getUserName());
		
		int result = moimBoardService.add(boardDTO, file);
		
		String path = "redirect:./list?moimNum="+boardDTO.getMoimNum();
		return path;
		
		
	}
	
	//detail
	@GetMapping("detail")
	public void detail(MoimBoardDTO boardDTO, Model model) throws Exception {
		int result = moimBoardService.click(boardDTO);
		boardDTO = moimBoardService.detail(boardDTO);
		
		model.addAttribute("dto",boardDTO);
		
	}
	
	//update
	@GetMapping("update")
	public void update(MoimBoardDTO boardDTO, Model model) throws Exception{
		boardDTO = moimBoardService.detail(boardDTO);
		model.addAttribute("dto", boardDTO);
	}
	
	@PostMapping("update")
	public String update(MoimBoardDTO boardDTO, MultipartFile [] file, Model model) throws Exception{
		int result = moimBoardService.update(boardDTO, file);
		String msg = "다시 시도해주세요.";
		String path = "./update";
		if(result == 1) {
			msg = "수정 완료";
			path = "./list?moimNum="+boardDTO.getMoimNum();
		}
		model.addAttribute("msg",msg);
		model.addAttribute("path",path);
		
		return "moim/resultAlert";
	}	
	
	//delete
	@PostMapping("delete")
	public String delete(MoimBoardDTO boardDTO, Pager pager , Model model) throws Exception{
		int result=moimBoardService.delete(boardDTO);
		
		List<Object> ar = moimBoardService.list(pager, boardDTO);
		
		model.addAttribute("dto", boardDTO);
		model.addAttribute("list", ar);
		
		String path = "redirect:./list?moimNum="+boardDTO.getMoimNum();
		return path;
	}
}
