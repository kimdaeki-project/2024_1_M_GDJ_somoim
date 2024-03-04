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

				<!-- Main content -->
				<div class="col-lg-9 col-md-7 col-12 bg-white"
					style="border-radius: 10px">
					<div class="row">
						<div></div>
						<!-- 안에 내용 수정해서 사용하세요 -->
						<div class="col-12">
							<br>
						</div>
						<div class="col-12">
							<br>
						</div>
						<div class="col-12"></div>
						<div class="col-12 text-center">
							<h3>추천모임수정</h3>
						</div>
						<form method="POST" enctype="multipart/form-data" id="addform">
						<input type="hidden" name="placeNum" value="${admin.placeNum}" id="placeNum">
						<input type="hidden" name="userName" value="${member.userName}" id="userName">
						<div class="mb-3 text-start">
							<label for="title" class="form-label">모임제목</label> <input
								type="text" class="form-control" id="title"
								value="${admin.placeTitle}" name="placeTitle">
						</div>
						<div class="mb-3">
							<label for="address" class="form-label">모임주소</label> <input
								type="text" class="form-control" id="address"
								value="${admin.placeAddress}" name="placeAddress">
						</div>
						<div class="mb-3">
							<label for="Link" class="form-label">모임링크</label> <input
								type="text" class="form-control" id="Link"
								value="${admin.placeLink}" name="placeLink">
						</div>
						<div class="mb-3">
							<label for="ImageLink" class="form-label">모임이미지링크</label> <input
								type="text" class="form-control" id="ImageLink"
								value="${admin.placeImageLink}" name="placeImageLink">
						</div>
						
						
			<div class="col-auto d-flex justify-content-end mt-3 mb-3">
				<button class="btn btn-outline-dark" type="button" id="fileAdd" data-result="${result}">등록</button>
			</div>

					</div>
				</div>
				<!--  -->

				<!--  -->
			</div>
		</div>
		</form>
	</div>
	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<!-- ========================= JS improt ========================= -->
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="/resources/js/admin/placeAdd.js"></script>
		

</body>
</html>
