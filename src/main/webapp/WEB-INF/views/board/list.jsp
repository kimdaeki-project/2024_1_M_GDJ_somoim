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
</head>

<body>
	<!-- 내비게이터 import -->
	<c:import url="../temps/header.jsp"></c:import>

	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<div class="d-grid gap-3 mb-2">
		<div class="p-5"></div>
		<div class="p-3 mx-auto">
			<h3>${board}</h3>
		</div>
	</div>
	<!--  -->
	<div class="container mb-4" name="categorySelect">
		<ul
			class="nav nav-pills list-group-horizontal d-flex justify-content-center"
			name="categorySelect">
			<li class="nav-item px-2"><a
				class="nav-link active BOARDCATEGORY" href="#" data-category="all">전체</a></li>
			<li class="nav-item px-2" name="category0" id="category0"><a
				class="nav-link BOARDCATEGORY" href="#" data-category="category0">${category0}</a></li>
			<li class="nav-item px-2" name="category1" id="category1"><a
				class="nav-link BOARDCATEGORY" href="#" data-category="category1">${category1}</a></li>
			<li class="nav-item px-2" name="category2" id="category2"><a
				class="nav-link BOARDCATEGORY" href="#" data-category="category2">${category2}</a></li>
		</ul>
	</div>
	<!--  -->
	<div class="container">
		<form id="searchform">
			<div class="row row-cols-auto">
				<div class="col">
					<select class="form-select" name="searchFind" id="searchFind"
						aria-label="Default select example">
						<option value="searchFind1">제목</option>
						<option value="searchFind2">작성자</option>
						<option value="searchFind3">내용</option>
					</select>
				</div>
				<div class="col"></div>
				<div class="col"></div>
				<div class="col-auto ms-auto mt-2  d-flex">
					<!-- 수정 필요 검색 버튼이 오른쪽으로 가야함-->
					<div class="col-auto">
						<!-- search -->

						<label for="search" class="visually-hidden">Search</label> <input
							type="text" name="search" class="form-control" id="search">
					</div>
					<div class="col-auto">
						<button type="submit" class="btn btn-outline-dark" id="searchbtn">검색</button>
					</div>
		</form>
	</div>
	</div>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">작성날짜</th>
			</tr>
		</thead>
		<tbody id="noticeList" data-user="${member.userName}">



		</tbody>
	</table>
	<c:if test="${not empty member}">
		<div class="mb-3 col-6"></div>
		<c:if test="${board eq '공지게시판'}">
			<c:if test="${member.roleDTO.roleNum eq 1}">
				<div class="col-auto d-flex justify-content-end mb-3">
					<a href="./add" class="btn btn-outline-dark">글쓰기</a>
				</div>
			</c:if>
		</c:if>
		<c:if test="${board eq '문의게시판'}">
		<div class="mb-3 col-6"></div>
		<div class="col-auto d-flex justify-content-end mb-3">
					<a href="./add" class="btn btn-outline-dark">글쓰기</a>
				</div>
		</c:if>
	</c:if>
	</div>



	<!-- ========================= JS improt ========================= -->
	<script src="/resources/js/board/kategorie.js"></script>
	<c:import url="../temps/footer.jsp"></c:import>

</body>
</html>
