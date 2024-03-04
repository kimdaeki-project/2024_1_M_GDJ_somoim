package com.somoim.app.member;


import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;






@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private KakaoAPI kakaoAPI;
	@Autowired
	private JavaMailSenderImpl mailSenderImpl;
	

	
	@PostMapping("checkId")
	public String checkId(MemberDTO memberDTO,Model model)throws Exception{
		
		
		int result = memberService.checkId(memberDTO);
		if(result>0) {
			result = 1;
		}else {
			result = 0;
		}
		
		model.addAttribute("result", result);
		
		return "member/idCheck";
	}
	
	//사용자 정보로 비밀번호 찾기
	@GetMapping("findPw")
	public void findPw()throws Exception{}
	
	@PostMapping("findPw")
	public String findPw(HttpSession session,MemberDTO memberDTO)throws Exception{
		
		System.out.println(memberDTO.getUserName()); 
		System.out.println(memberDTO.getEmail());
		memberService.setPasswordUpdate(memberDTO);
		
		
		return "member/login";
	}
	
	//소모임 앱아이디 중복검사
	@GetMapping("idCheck")
	public String getIdCheck(MemberDTO memberDTO,Model model)throws Exception{
		int result = 0;

		memberDTO = memberService.getMypage(memberDTO);
		if(memberDTO == null) {
			result = 1;
		}

		model.addAttribute("result",result);
		
		return "member/idCheck";
		
	}
	@GetMapping("findCheck")
	public String findPw(MemberDTO memberDTO,Model model)throws Exception{
		int result = memberService.checkPw(memberDTO);

		if(result>0) {
			result=1;
		}else {
			result=0;
		}
		
		model.addAttribute("result", result);
		
		return "member/idCheck";
	}
	

	
	//회원가입 이메일 인증
		@PostMapping("/emailAuth")
		@ResponseBody
		public String mailCheck(String email) {
			
			Random random = new Random();
			int checkNum = random.nextInt(888888)+111111;
			
			String setFrom = "qjatj802@naver.com";
			String toMail = email;
			String title = "회원가입 이증 이메일 입니다";
			String content =
					"홈페이지를 방문해주셔서 감사합니다"+
					"<br><br>"+
					"인증번호는"+checkNum+"입니다"+
					"<br>"+
					"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
			try {			
				MimeMessage message = mailSenderImpl.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true,"utf-8");
				helper.setFrom(setFrom);
				helper.setTo(toMail);
				helper.setSubject(title);
				helper.setText(content, true);
				mailSenderImpl.send(message);	
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return Integer.toString(checkNum);
		}	  	

	
	//구글 아이디 정보 가져오기	
	@PostMapping("submitApp")
	@ResponseBody
	public String submitJoinApp(MemberDTO memberDTO,HttpSession session)throws Exception{
		
		MemberDTO dto = memberService.submitJoinApp(memberDTO);
        
		if(dto==null) {
			session.setAttribute("appmember",memberDTO);
			return "success";
		}else {
			session.setAttribute("appmember",dto);
			return "goHome";
		}
	}
	
	
	


	//소모임 앱회원가입
	@GetMapping("join")
	public void setJoin(MemberDTO memberDTO)throws Exception{

	}

	@PostMapping("join")
	public String setJoin(MemberDTO memberDTO,MultipartFile attachs,Model model)throws Exception{
		int result = memberService.setjoin(memberDTO, attachs);

		String msg = "가입 실패";
		String path = "./join";

		if(result>0) {
			msg = "가입 성공";
			path = "../";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("path", path);

		return "member/result";
	}
	
	//카카오 회원가입 및 로그인
	
	 @GetMapping("joinApp")
	    public String kakaoLogin(@RequestParam String code,MemberDTO memberDTO,HttpSession session,Model model) throws Exception{
	        // 1. 인가 코드 받기 (@RequestParam String code)
		 	
	        // 2. 토큰 받기
	        String accessToken = kakaoAPI.getAccessToken(code);
	        session.setAttribute("accessToken", accessToken);
	        // 3. 사용자 정보 받기
	        Map<String, Object> userInfo = kakaoAPI.getUserInfo(accessToken);

	        String getUserName = (String)userInfo.get("email");
	        String nickname = (String)userInfo.get("nickname");
	        memberDTO.setUserName(getUserName);
	        memberDTO.setNickName(nickname);
	     
	        MemberDTO dto = memberService.submitJoinApp(memberDTO);
			if(dto==null) {				
				model.addAttribute("tempmem", memberDTO);
				return "member/joinKakao";
			}else {
				
				session.setAttribute("appmember",dto);
				System.out.println(dto.getAddress());
				System.out.println(dto.getLoginNum());
				return "redirect:../";
			}
	    }
	 
		//앱 회원가입
		@PostMapping("joinApp")
		public String setJoinApp(MemberDTO memberDTO,MultipartFile attachs,Model model,HttpSession session)throws Exception{
			
			int result = memberService.setjoin(memberDTO, attachs);
			String msg = "가입불가";
			String path = "./joinApp";
			
			if(result>0) {
				msg = "가입성공";
				path = "../";
			}
			
			
			model.addAttribute("msg", msg);
			model.addAttribute("path", path);
			
			
			return "member/result";
		}
	 
	//somoim 앱로그인
	@GetMapping("login")
	public String getLogin(Model model)throws Exception{
		model.addAttribute("kakaoApiKey", kakaoAPI.getKakaoApiKey());
		model.addAttribute("redirectUri", kakaoAPI.getKakaoRedirectUri());


        return "member/login";
	}
	
	@PostMapping("login")
	public String getLogin(MemberDTO memberDTO,HttpSession session,Model model)throws Exception{
		memberDTO= memberService.getLogin(memberDTO);
		String msg = "아이디 또는 비밀번호 확인";
		String path = "/member/login";
		if(memberDTO==null) {
			model.addAttribute("msg", msg);
			model.addAttribute("path", path);
			return "member/result";
		}else if(memberDTO.getLoginNum()==2) {
			msg = "app가입자는 app으로 로그인";
			model.addAttribute("msg", msg);
			model.addAttribute("path", path);
			return "member/result";
		}
		session.setAttribute("member", memberDTO);
		return "redirect:../";
	}
	@GetMapping("logout")
	public String getLogout(HttpSession session,Model model)throws Exception{
		

		session.setAttribute("appmember", null);
		session.setAttribute("member",null);
		
		return "redirect:../";
	}
    @GetMapping("goologout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 구글 로그아웃
        // 구글에서 로그아웃하는 로직을 추가해야 합니다. 구글의 로그아웃 엔드포인트를 호출하거나 구글 API를 사용하여 로그아웃합니다.

        // 2. 로컬 세션 만료
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 만료
        }
        String googleLogoutUrl = "https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:80/";
        response.sendRedirect(googleLogoutUrl);
        
        
    }

}
