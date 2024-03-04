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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- CSS 임포트 -->
<c:import url="../temps/head_css.jsp"></c:import>
<!-- 내비게이터 import -->
</head>
<body>
	<div class="items-grid section">
		<div class="container">
			<div class="row">

				<div class="col-lg-1 col-md-1"></div>
				<!-- Main content -->
				<div class="row">
					<div></div>
					<!-- 안에 내용 수정해서 사용하세요 --

						<!--All User List  -->
					<div class="col-2 mb-2 mt-1"></div>

					<div class="col-auto ms-auto mt-2  d-flex">
						<!-- 수정 필요 검색 버튼이 오른쪽으로 가야함-->
						<div class="col-auto">
							<!-- search -->


						</div>
						<div class="col-auto"></div>
					</div>
					<div>
						<table class="table"
							style='width: 100%; table-layout: fixed; word-break: break-all; height: auto'>
							<tr class="something">
								<th>관리</th>
								<th>제목</th>
								<th>주소</th>
								<th>링크</th>
								<th>이미지링크</th>
							</tr>
							<c:forEach items="${admin}" var="admin">
								<tr>
									<td><a class="updateLink" href="#"
										data-place-num="${admin.placeNum}"> <i
											class="lni lni-pencil update"></i>
									</a> <a href="#" class="del" data-place-num="${admin.placeNum}">
											<i class="lni lni-trash del"></i>
									</a></td>
									<td>${admin.placeTitle}</td>
									<td>${admin.placeAddress}</td>
									<td>${admin.placeLink}</td>
									<td><img src="${admin.placeImageLink}" width="200" height="150" onerror="this.src='/resources/img/moim/basic.png';"/></td>
								</tr>
							</c:forEach>
						</table>

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
	<script src="/resources/js/admin/detail.js"></script>

</body>
</html>
