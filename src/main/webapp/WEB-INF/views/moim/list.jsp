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
<!-- 내비게이터 import -->
<c:import url="../temps/header.jsp"></c:import>
<!-- summernote -->
<c:import url="../temps/summernote.jsp"></c:import>
</head>
<body>
	<div class="items-grid section" style="padding-top: 120px;">
		<div class="container mx-5">
			<div class="row">
				<!-- Sidebar -->
				<c:import url="../mypage/mypage_nav.jsp"></c:import>
				<div class="col-lg-1 col-md-1"></div>
				<!-- Main content -->
				<div class="col-lg-9 col-md-7 col-12 bg-white"
					style="border-radius: 10px">






					<div class="row">
						<!-- 안에 내용 수정해서 사용하세요 -->

						<!-- 정모채팅목록 -->
						<div class="col-lg-6 mt-4 mb-5">
							<ol class="list-group list-group-numbered">
								<button type="button" class="btn btn-light position-relative">
									<div class="ms-2 me-auto">
										<div class="fw-bold">Subheading</div>
										Content for list item
									</div>
									<span
										class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
										99+ <span class="visually-hidden">unread messages</span>
									</span>
								</button>
							</ol>
						</div>
						<div class="col-lg-6 mt-4 mb-5">
							<ol class="list-group list-group-numbered">
								<button type="button" class="btn btn-light position-relative">
									<div class="ms-2 me-auto">
										<div class="fw-bold">Subheading</div>
										Content for list item
									</div>
									<span
										class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
										99+ <span class="visually-hidden">unread messages</span>
									</span>
								</button>
							</ol>
						</div>



						<!-- 모임 리스트 -->
						<table class="table">
							<thead>
								<tr>
									<th scope="col">


										<div class="item-list-title">
											<div class="row align-items-center">
												<div class="col-lg-5 col-md-5 col-12">
													<p>Title</p>
												</div>
												<div class="col-lg-2 col-md-2 col-12">
													<p>Category</p>
												</div>
												<div class="col-lg-2 col-md-2 col-12">
													<p>Join Date</p>
												</div>
												<div class="col-lg-3 col-md-3 col-12 align-right">
													<p>Action</p>
												</div>
											</div>
										</div>

									</th>
								</tr>
							</thead>

							<tbody class="table-group-divider" id="listTbody">
								<c:forEach items="${list}" var="dto">
									<tr>
										<td>
											<div class="card-body">
												<div class="single-item-list">
													<div class="row align-items-center">
														<div class="col-lg-5 col-md-5 col-12">
															<div class="item-image mx-3">
																<div class="content">
																	<a type="text" class="btn btn-white position-relative">
																		<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-success">${dto.moimRegion}</span>
																	</a>
																</div>
																
																<c:if test="${empty dto.moimFileDTO.fileName}">
																	<a href="./main/home?moimNum=${dto.moimNum}">
																	<img src="/resources/img/moim/basic.png" style="width: 100px; height: 100px; border-radius: 50px;" alt="..." >
																	</a>
																</c:if> 
																<c:if test="${not empty dto.moimFileDTO.fileName}">
																	<a href="./main/home?moimNum=${dto.moimNum}">
																	<img src="/resources/upload/moim/${dto.moimFileDTO.fileName}" style="width: 100px; height: 100px; border-radius: 50px;" alt="...">
																	</a>
																</c:if>
																
																<!-- <div class="content"> -->
																<span class="content mx-5">
																	<h5 class="title">
																		<a href="./main/home?moimNum=${dto.moimNum}" id="moimName"
																			data-moim-num="${dto.moimNum}">${dto.moimName}</a>
																	</h5>
																	<span class="moimHead">${dto.moimHead}</span>
																</span>
																<!-- </div> -->
															</div>
														</div>


														<div class="col-lg-2 col-md-2 col-12">
															<p>${dto.moimCategory}</p>
														</div>


														<div class="col-lg-2 col-md-2 col-12">
															<p>${dto.moimMemberDTO.joinDate}</p>
														</div>


														<div class="col-lg-3 col-md-3 col-12 align-right">
															<ul class="action-btn">
																<c:if test="${dto.moimHead eq member.userName}">
																	<li>
																		<a href="#" data-moim-num="${dto.moimNum}">
																		<i class="lni lni-pencil update"></i></a>
																	</li>
																	<li>
																		<a href="javascript:void(0)" class="del" data-moim-num="${dto.moimNum}">
																		<i class="lni lni-trash del" ></i></a>
																	</li>
																</c:if>
																<li>
																	<a href="./main/home?moimNum=${dto.moimNum}" class="eye" data-moim-num="${dto.moimNum}">
																	<i class="lni lni-eye"></i></a>
																</li>
																
															</ul>
															
															<!-- value="${dto.moimNum}" -->
															<form id="${dto.moimNum}" class="update" action="./update" method="get">
							                                    <input type="hidden" name="moimNum" id="moimNumHidden" value="${dto.moimNum}">
							                                </form>
														</div>


													</div>
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>




















						<!-- 모임 개설 -->
						<div class="button text-center">
							<a href="./add" class="btn my-3" id="addBtn">모임 개설하기</a>
						</div>





					</div>
					<!-- Main content goes here -->
				</div>
			</div>
		</div>
	</div>


	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<!-- ========================= JS improt ========================= -->
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="/resources/js/moim/moimList.js"></script>
</body>

</html>