package com.somoim.app.adminPage;

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

import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.MoimDTO;
import com.somoim.app.util.Pager;

@Controller
@RequestMapping("/admin/*")
public class AdminPageController {

	@Autowired
	private AdminPageService adminPageService;
	
	
	@GetMapping("memberlist")
	public void list (MemberDTO memberDTO, Model model, Pager pager) throws Exception{
		List<MemberDTO> ar = adminPageService.list(pager);
		model.addAttribute("list",ar);
		model.addAttribute("pager",pager);
	}
	
	@GetMapping("add")
	public String add ()throws Exception{
		return "admin/add";
	}
	
	@PostMapping("add")
	public String add (AdminPageDTO adminPageDTO, HttpSession session, Model model)throws Exception{
		
		System.out.println("============================");
		System.out.println(adminPageDTO.getPlaceTitle());
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		adminPageDTO.setUserName(memberDTO.getUserName());
		int result = adminPageService.add(adminPageDTO);
		model.addAttribute("result", result);
		return "admin/add";
	}
	
	@GetMapping("placeList")
	public String placeList(AdminPageDTO adminPageDTO, Model model)throws Exception{
		List<AdminPageDTO> ar = adminPageService.placeList(adminPageDTO);
		Map<Integer, Object> index = new HashMap<>();
		List<AdminPageDTO> resultList = new ArrayList<AdminPageDTO>();
		for(int i = 0; i < ar.size(); i++) {
			int random =(int) (Math.random()*ar.size());
			if(index.containsKey(random)) {
				i--;
				continue;
			}
			
			index.put(random, 1);
			resultList.add(ar.get(random));
		}
		model.addAttribute("admin",resultList);
		
		return "admin/placeList";
	}
	
	@PostMapping("update")
	public String update(AdminPageDTO adminPageDTO)throws Exception{
		int result = adminPageService.update(adminPageDTO);
		return "redirect:./adminList";
	}	
	@GetMapping("update")
	public String update (AdminPageDTO adminPageDTO,Model model)throws Exception{
		adminPageDTO = adminPageService.detail(adminPageDTO);
		model.addAttribute("admin", adminPageDTO);
		return "admin/update";
	}
	
		
	
	@GetMapping("adminList")
	public String adminList(AdminPageDTO adminPageDTO, Model model)throws Exception{
		List<AdminPageDTO> ar = adminPageService.placeList(adminPageDTO);
		model.addAttribute("admin",ar);
		
		return "admin/adminList";
	}
	
	@PostMapping("delete")
	public String delete(AdminPageDTO adminPageDTO)throws Exception{
		int result = adminPageService.delete(adminPageDTO);
		return "redirect:./adminList";
	}
	
}
