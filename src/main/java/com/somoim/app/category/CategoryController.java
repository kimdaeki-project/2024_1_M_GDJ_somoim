package com.somoim.app.category;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.somoim.app.board.BoardDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.MoimDTO;
import com.somoim.app.moim.MoimFileDTO;
import com.somoim.app.util.FileManager;
import com.somoim.app.util.Pager;

@Controller
@RequestMapping("/category/*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("main")
	public void getList() throws Exception {
	
	//return "category/main";	
	}
	
	
	@GetMapping("list")
	public void list (HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<MoimDTO> ar = categoryService.list(memberDTO);
		model.addAttribute("list", ar);
	}
	
	
	@GetMapping("categoryList")
	public String getListCategory (Pager pager, Model model, MoimDTO moimDTO, HttpSession session)throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		moimDTO.setAddress(memberDTO.getAddress());
		List<MoimDTO> ar = categoryService.getListCategory(pager, moimDTO, memberDTO);
		model.addAttribute("data", ar);
		model.addAttribute("pager",pager);
		return "category/category";
	}
	
	
	
}
