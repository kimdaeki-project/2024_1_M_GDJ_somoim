package com.somoim.app.moim.meet;

import java.util.ArrayList;
import java.util.List;

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

@Controller
@RequestMapping("/moim/main/*")
public class MeetController {
	
	@Autowired
	private MeetService meetService;
	
	//정모 list
	@GetMapping("together")
	public void together(MeetDTO meetDTO, Model model) throws Exception {
		
		List<MeetDTO> ar = meetService.getList(meetDTO);
		
		//참여멤버 수(A)
		List<Integer> memNum = new ArrayList<>();
		//참여멤버 아이디(B)
		List<List<String>> contain = new ArrayList<List<String>>();
		for(int i=0; i<ar.size();i++) {           
			//(A)
			MeetDTO meet = new MeetDTO();
			meet.setMeetNum(ar.get(i).getMeetNum());
			Integer result = meetService.memNum(meet);
			
			memNum.add(result);
			//(B)
			List<String> memId = meetService.contain(meet);
			
			contain.add(memId);
		}
		
//		System.out.println("???????^&*^&*"+contain.get(0));
//		System.out.println("???????^&*^&*"+contain.get(1));
//		System.out.println("???????^&*^&*"+contain.get(0).get(0));

		
		model.addAttribute("contain", contain);
		
		model.addAttribute("dto", meetDTO);
		model.addAttribute("memNum", memNum);
		model.addAttribute("list", ar);
	}
	
	//add
	@GetMapping("add")
	public void mainAdd(MoimDTO moimDTO, Model model) throws Exception {
		model.addAttribute("dto",moimDTO);
	}
	@PostMapping("add")
	public String mainAdd(MeetDTO meetDTO, MultipartFile file, HttpSession session) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		meetDTO.setMeetHead(memberDTO.getUserName());
		int result = meetService.add(meetDTO, file);
		
		String path = "redirect:./together?moimNum="+meetDTO.getMoimNum();
		return path;
	}
	
	//delete
	@PostMapping("delete")
	public String delete(MeetDTO meetDTO, Model model) throws Exception{
		
		int result = meetService.delete(meetDTO);
		
		//다시조회
		List<MeetDTO> ar = meetService.getList(meetDTO);
		
		model.addAttribute("list", ar);
		
		return "moim/main/ajaxList";
		
	}
	
	//join
	@GetMapping("join")
	public String join(MeetMemberDTO meetMemberDTO, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		meetMemberDTO.setUserName(memberDTO.getUserName());
		
		//System.out.println("1:");
		
		int result = meetService.join(meetMemberDTO);		
		
		String msg = "다시 시도해주세요.";
		String path = "./together?moimNum="+meetMemberDTO.getMoimNum();
		if(result == 1) {
			
			msg = "참여 완료";
			path = "./together?moimNum="+meetMemberDTO.getMoimNum();
		}
		model.addAttribute("msg",msg);
		model.addAttribute("path",path);
		
		return "moim/resultAlert";
	}
}
