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

	<div class="container">
		<form method="POST" enctype="multipart/form-data">

			<div class="mb-2">
				<label for="CATEGORY" name="boardCategory" class="form-label">Category</label>
				<select class="form-select" aria-label="Default select example"
					name="boardCategory" style="width: 200px;">
					<option value="0">공지</option>
					<option value="1">패치</option>
					<option value="2">기타</option>
				</select>
			</div>
			<div class="mb-2">
					<input type="hidden" name="boardNum" value="${DTO.boardNum}"
						id="boardNum"> <input type="hidden"
						value="${member.userName}" id="userName" name="userName">
						<input type="hidden" name="boardWriter" value="${DTO.boardWriter}"
						id="boardWriter">
						<input type="hidden" name="boardSecret" value="${DTO.boardSecret}"
						id="boardSecret">
						
						boardSecret
					<div class="mb-3 text-start">
						<label for="title" class="form-label">Title</label> <input
							type="text" class="form-control" id="title"
							value="${DTO.boardTitle}" name="boardTitle">
					</div>
				</div>
				<div class="mb-3">
					<label for="boardText" class="form-label">Contents</label>
					<textarea class="form-control" id="boardText" rows="3"
						name="boardText">${DTO.boardText}</textarea>
				</div>
<input class="form-control" type="file" id="formFileMultiple"
				multiple data-file-count="0" data-file-max="5" name="attachs"
				accept="image/jpg, image/jpeg, image/png, image/gif">
			<div class="col-auto d-flex justify-content-end mt-3 mb-3">
				<button class="btn btn-outline-dark" id="fileAdd">등록</button>
			</div>
			</div>
	</div>
	</form>



	<!-- ========================= JS improt ========================= -->
	<script src="/resources/js/board/boardUpdate.js"></script>
	<c:import url="../temps/footer.jsp"></c:import>
</body>
</html>
