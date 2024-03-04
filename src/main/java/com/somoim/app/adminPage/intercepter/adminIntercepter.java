package com.somoim.app.adminPage.intercepter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.somoim.app.member.MemberDTO;
import com.somoim.app.member.MemberService;
import com.somoim.app.member.role.MemberRoleDTO;

@Component
public class adminIntercepter extends HandlerInterceptorAdapter{

	@Autowired
	private MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		if(memberDTO != null) {
			memberDTO = memberService.getMypage(memberDTO);
			MemberRoleDTO memberRoleDTO = memberDTO.getRoleDTO();
			if(memberRoleDTO.getRoleNum()==1) {
				return true;
			}else {
				request.setAttribute("msg", "관리자만 접근 가능");				
				request.setAttribute("path", "/");
				RequestDispatcher v = request.getRequestDispatcher("/WEB-INF/views/mypage/result.jsp");
				v.forward(request, response);
				return false;				
			}
		}else {
			System.out.println("로그인 한사람만 가능");
			
			request.setAttribute("msg", "로그인 한사람만 가능");				
			request.setAttribute("path", "../member/login");
			RequestDispatcher v = request.getRequestDispatcher("/WEB-INF/views/mypage/result.jsp");
			v.forward(request, response);
			
			return false;
		}
	}
}
