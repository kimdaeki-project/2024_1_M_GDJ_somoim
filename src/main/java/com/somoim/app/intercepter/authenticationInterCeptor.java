package com.somoim.app.intercepter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class authenticationInterCeptor extends HandlerInterceptorAdapter{

		@Override
		public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("member");
			if(obj != null) {
				return true;
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
