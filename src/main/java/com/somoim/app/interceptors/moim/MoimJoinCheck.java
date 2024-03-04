package com.somoim.app.interceptors.moim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.somoim.app.board.BoardDTO;
import com.somoim.app.member.MemberDTO;
import com.somoim.app.moim.MoimController;
import com.somoim.app.moim.MoimDAO;
import com.somoim.app.moim.MoimDTO;

@Component
public class MoimJoinCheck extends HandlerInterceptorAdapter{
	@Autowired
	private MoimController moimController;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		String path = request.getRequestURI();
		path = path.substring(0, path.lastIndexOf("/"));
		
		//System.out.println("path : "+path);
		
		Long num = Long.parseLong(request.getParameter("moimNum"));
		
		MoimDTO moimDTO = new MoimDTO();
		moimDTO.setMoimNum(num);
		
		List<String> contain = new ArrayList<String>();
		
		if(path.equals("/moim/main")||path.equals("/moim/main/board")) {
			Map<String, Object> map = moimController.detail(moimDTO);
			contain = (List<String>) map.get("contain");
		}
		
		//System.out.println(contain);
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		//System.out.println("확인 : "+contain.contains(memberDTO.getUserName()));
		
		if(contain.contains(memberDTO.getUserName())) {
			return true;
		}else {
			request.setAttribute("path", "/moim/main/home?moimNum="+moimDTO.getMoimNum());
			request.setAttribute("msg", "모임회원만 가능합니다.");
			RequestDispatcher v = request.getRequestDispatcher("/WEB-INF/views/moim/resultAlert.jsp");
			v.forward(request, response);
			return false;
		}
	}
}
