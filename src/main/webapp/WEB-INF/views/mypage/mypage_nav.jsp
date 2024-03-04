<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<nav id="sidebar"
					class="col-lg-2 col-md-4 col-12 py-3 bg-white dashboard-sidebar"
					style="border-radius: 10px">
					<div class="user-image mb-3">
						<table class="mx-auto text-center" style="width: 90%">
							<tr>
								<td rowspan="2" style="text-align: left; width: 50%;"><img
									src="../resources/upload/member/${member.profile.fileName}" alt="#" class="m-1"
									style="width: 90%; height: 90%; border-radius: 10px"></td>
								<td>${member.nickName}</td>
							</tr>
							<tr>
								<td><span><a href="javascript:void(0)">${member.name}</a></span></td>
							</tr>
						</table>
					</div>
					<div class="dashboard-menu mx-auto text-left">
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link active"
								href="/mypage/main"><i class="lni lni-pencil-alt"></i>
									회원 정보 수정</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/moim/list"><i class="lni lni-bolt-alt"></i> 내
									모임리스트</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/chat"><i class="lni lni-envelope"></i> 1:1 채팅</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/qna/list"><i class="lni lni-circle-plus"></i>
									문의게시판</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/notice/list"><i class="lni lni-bookmark"></i>
									공지게시판</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/mypage/pay"><i class="lni lni-credit-cards"></i> 구독
									결제 하기</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/mypage/paymentList"><i class="lni lni-printer"></i> 결제내역 확인</a></li>		
						</ul>
						<div class="text-center">
							<c:if test="${member ne null}">
								<button type="button" class="btn btn-danger mt-5" onclick="location.href='/mypage/accountDel'" >회원탈퇴</button>
							</c:if>
							
							<c:if test="${appmember ne null}">
								<form action="./appDel" method="post" id="frm">
									<button type="button" class="btn btn-danger mt-5" id="appDel">회원탈퇴</button>

									<!-- Button trigger modal -->
									<div>
										<button type="button" id="letModal" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal" hidden></button>
									</div>
										<!-- Modal -->
										<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
										  <div class="modal-dialog">
											<div class="modal-content">
											  <div class="modal-header">
												<h1 class="modal-title fs-5" id="exampleModalLabel">somoim</h1>
												<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
											  </div>
											  <div class="modal-body">
												탈퇴하면 복구가 어렵습니다.<br>
												정말 탈퇴 하겠습니까?
											  </div>
											  <div class="modal-footer">
												<button type="submit" class="btn btn-primary" id="realDel">탈퇴</button>
												<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
											  </div>
											</div>
										  </div>
										</div>
								</form>
							</c:if>
						</div>
					</div>
				</nav>

				<script src="../resources/js/mypage/mypage_nav.js"></script>