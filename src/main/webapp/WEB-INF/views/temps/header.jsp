<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Preloader -->
<div class="preloader">
	<div class="preloader-inner">
		<div class="preloader-icon">
			<span></span> <span></span>
		</div>
	</div>
</div>
<header class="header navbar-area">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-12">
				<div class="nav-inner">
					<nav class="navbar navbar-expand-lg">
						<a class="navbar-brand" href="/"> <img
							src="/resources/assets/images/logo/logo.png" alt="Logo">
						</a>
						<button class="navbar-toggler mobile-menu-btn" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="toggler-icon"></span> <span class="toggler-icon"></span>
							<span class="toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse sub-menu-bar"
							id="navbarSupportedContent">
							<ul id="nav" class="navbar-nav ms-auto">
								<li class="nav-item"><a href="/">Home</a></li>
								<li class="nav-item"><a href="/category/main"
									aria-label="Toggle navigation">모임리스트</a></li>
								<li class="nav-item"><a href="/moim/add">모임만들기</a></li>
								<li class="nav-item"><a href="/notice/list">공지사항</a></li>
								<li class="nav-item"><a href="/qna/list">QNA</a></li>
								<li class="nav-item"><a href="/qna/fnq">FNQ</a></li>
							</ul>
						</div>
						<!-- navbar collapse -->
						<div class="login-button">
							<ul>
								<c:if test="${member eq null and appmember eq null}">
									<li><a href="/member/login"><i class="lni lni-enter"></i>
											로그인</a></li>
									<li><a href="/member/join"><i class="lni lni-user"></i>
											회원가입</a></li>
								</c:if>
								<c:if test="${member ne null or appmember ne null}">
									<c:if test="${member.roleDTO.roleNum eq 1}">
										<li><a href="/admin/memberlist"><i class="lni lni-user"></i> 관리자페이지</a></li>
									</c:if>
									<c:if test="${member.roleDTO.roleNum ne 1}">
										<li><a href="/mypage/main"><i class="lni lni-user"></i>
												마이페이지</a></li>
									</c:if>
									<c:if test="${member.loginNum == 1 }">
										<li><a href="/member/logout"><i class="lni lni-ban"></i>
												로그아웃</a></li>
									</c:if>
									<c:if test="${appmember.loginNum == 2}">
										<li><a
											href="https://kauth.kakao.com/oauth/logout?client_id=f596bc753587abe6cf4b789ef8f12223&logout_redirect_uri=http://localhost/member/logout
										"><i
												class="lni lni-ban"></i> 로그아웃</a></li>
									</c:if>
									<c:if test="${appmember.loginNum == 3}">
										<li><a href="/member/goologout"><i
												class="lni lni-ban"></i> 로그아웃</a></li>
									</c:if>
								</c:if>
							</ul>
						</div>
					</nav>
					<!-- navbar -->
				</div>
			</div>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</header>