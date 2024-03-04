<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Somoim</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- CSS 임포트 -->
<c:import url="../temps/head_css.jsp"></c:import>
<!-- 내비게이터 import -->
<c:import url="../temps/header.jsp"></c:import>
</head>
<body>
	<div class="items-grid section">
		<div class="container mx-5">
			<div class="row">
				<!-- Sidebar -->
				<nav id="sidebar"
					class="col-lg-2 col-md-4 col-12 py-3 bg-white sidebar"
					style="border-radius: 10px">
					<div class="user-image mb-3">
						<table class="mx-auto text-center" style="width: 90%">
							<tr>
								<td rowspan="3" style="text-align: left"><img
									src="/resources/assets/images/Yuree.jpg" alt="#" class="m-1"
									style="width: 85%; height: 90%; border-radius: 10px;" /></td>
								<td rowspan="2" colspan="2">Steve Aldridge</td>
							</tr>
							<tr></tr>
							<tr>
								<td colspan="2"><span><a href="javascript:void(0)">@username</a></span>
								</td>
							</tr>
						</table>
					</div>
					<div class="dashboard-menu mx-auto text-left">
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link active"
								href="/mypage/main"><i class="lni lni-pencil-alt"></i> 회원 정보
									수정</a></li>
							<li class="nav-item"><a class="nav-link" href="/moim/list"><i
									class="lni lni-bolt-alt"></i> 내 모임리스트</a></li>
							<li class="nav-item"><a class="nav-link"
								href="favourite-items.html"><i class="lni lni-heart"></i> 찜
									모임 리스트</a></li>
							<li class="nav-item"><a class="nav-link"
								href="messages.html"><i class="lni lni-envelope"></i> 1:1 채팅</a></li>
							<li class="nav-item"><a class="nav-link" href="/qna/list"><i
									class="lni lni-circle-plus"></i> 문의확인</a></li>
							<li class="nav-item"><a class="nav-link" href="/notice/add"><i
									class="lni lni-bookmark"></i> 공지글쓰기</a></li>
							<li class="nav-item"><a class="nav-link" href="/mypage/pay"><i
									class="lni lni-trash"></i> 구독 결제 화면</a></li>
							<li class="nav-item" id="moimadd"><a href="#"
								class="nav-link">추천모임만들기</a></li>
							<li class="nav-item" id="moimList"><a href="#"
								class="nav-link">추천모임전체리스트</a></li>
						</ul>
					</div>
				</nav>
				<div class="col-lg-1 col-md-1"></div>
				<!-- Main content -->
				<div class="col-lg-9 col-md-7 col-12 bg-white"
					style="border-radius: 10px">
					<div class="row">
						<div></div>
						<!-- 안에 내용 수정해서 사용하세요 -->
						<div class="col-12 text-center">
							<h3>관리자 페이지</h3>
						</div>


						<!--All User List  -->
						<div class="col-2 mb-2 mt-1">
							<form>
								<select class="form-select" name="searchFind" id="searchFind"
									aria-label="Default select example">
									<option value="searchFind1">이름</option>
									<option value="searchFind2">휴대폰</option>
									<option value="searchFind3">이메일</option>
								</select>
						</div>

						<div class="col-auto ms-auto mt-2  d-flex">
							<!-- 수정 필요 검색 버튼이 오른쪽으로 가야함-->
							<div class="col-auto">
								<!-- search -->

								<label for="search" class="visually-hidden">Search</label> <input
									type="text" name="search" class="form-control" id="search">
							</div>
							<div class="col-auto">
								<button type="submit" class="btn btn-outline-dark"
									id="searchbtn">검색</button>
							</div>
						</div>
						</form>
						<div>
							<table class="table">
								<tr class="something">
									<th>이름</th>
									<th>닉네임</th>
									<th>주소</th>
									<th>휴대폰번호</th>
									<th>이메일</th>
									<th>권한</th>
								</tr>
								<c:forEach items="${list}" var="data">
									<tr>
										<td>${data.name}</td>
										<td>${data.nickName}</td>
										<td>${data.address}</td>
										<td>${data.phone}</td>
										<td>${data.email}</td>
										<td><c:choose>
												<c:when test="${data.roleDTO.roleNum eq 1}">
												관리자
											</c:when>
												<c:when test="${data.roleDTO.roleNum eq 2}">
												일반회원
											</c:when>
											</c:choose></td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<!--  -->
						<div class="col-12">
							<div id="pages">
								<div>
									<ul
										class="list-group list-group-horizontal d-flex justify-content-center">
										<c:if test="${!pager.start}">
											<li class="page-item"><a class="page-link"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>
										</c:if>

										<c:forEach begin="${pager.startNum}" end="${pager.lastNum}"
											var="i">
											<li class="page-item"><a data-pageNum="${i}"
												class="page-link">${i}</a></li>
										</c:forEach>

										<c:if test="${!pager.last}">
											<li class="page-item"><a class="page-link"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
										</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- Main content goes here -->
				</div>
			</div>
			<!--  -->

			<!--  -->
		</div>
	</div>

	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<!-- ========================= JS improt ========================= -->
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="/resources/js/admin/adminPage.js"></script>
	<script src="/resources/js/admin/adminlist.js"></script>
</body>
</html>
