<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="utf-8">
			<title>chat</title>
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
			<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
			<link rel="stylesheet" href="/resources/assets/css/chat.css">
			<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
			<c:import url="../temps/head_css.jsp"></c:import>
		</head>

		<body>
			<c:import url="../temps/header.jsp"></c:import>
			<span class="my-5"></span>
			<div class="container">
				<div class="row clearfix">
					<div class="col-lg-12">
						<div class="card chat-app">
							<div id="plist" class="people-list">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fa fa-search"></i></span>
									</div>
									<input id="searchChat" type="text" class="form-control" placeholder="Search...">
								</div>
								<!-- 채팅방 목록 -->
								<ul class="list-unstyled chat-list mt-2 mb-0" style="overflow-y: auto; height: 530px">
									<c:forEach var="item" items="${moimInfo}">
										<!-- data-chatRoom="${item.chatRoomDTO.chatRoomNum}" -->
										<li id="chatRoomNum" data-roomNum="${item.chatRoomDTO.chatRoomNum}" class="clearfix">
											<!-- ${item.moimFileDTO.fileName} -->
											<c:if test="${empty item.moimFileDTO.fileName}">
												<img src="../resources/img/profile/profile.jpg" style="width: 50px; height: 50px;">
											</c:if>
											<c:if test="${not empty item.moimFileDTO.fileName}">
												<img src="/resources/upload/moim/${item.moimFileDTO.fileName}" style="width: 50px; height: 50px;">
											</c:if>
											<div class="about">
												<h6 class="pt-1">${item.moimName}</h6>
												<%-- <c:forEach var="img" items="${chatMsg}">
													<span>${img.chatText}</span>
												</c:forEach> --%>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="chat">
								<div class="chat-header clearfix">
									<div class="row">
										<div class="col-lg-6">
											<div class="chat-about">
												<a href="javascript:void(0);" data-toggle="modal"
													data-target="#view_info">
													${chatHistory}
													<c:forEach var="item" items="${chatHistory}">
														<span>${item.memberDTO}</span>													
													</c:forEach>
													<c:if test="${not empty user.profile.fileName}">
														<img src="/resources/upload/member/${user.profile.fileName}">
													</c:if>
													<c:if test="${empty user.profile.fileName}">
														<img src="/resources/img/profile/profile.jpg">
													</c:if>
												</a>
												<h6 class="m-b-0">${user.nickName}</h6>
											</div>
										</div>
										<!-- 사진 추가 아이콘 -->
										<div class="col-lg-6 hidden-sm text-right" id="userList">
											<a href="javascript:void(0);" class="btn btn-outline-primary">
												<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
													<path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5.784 6A2.24 2.24 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.3 6.3 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1zM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5"/>
											  	</svg>
											</a>
										</div>
									</div>
								</div>
								
								<!-- 채팅기록 -->
								<!-- style="visibility: hidden;" -->
								<div class="chat-history" id="chat-history" style="overflow-y: scroll; height: 450px;" style="visibility: hidden;">
									<ul class="m-b-0" id="chat_record">
										<!--
										<div>
											<span class="d-flex justify-content-center p-1 bg-secondary text-white rounded-pill">000000000</span>
										</div> 
										-->
										<li>
											<input type="hidden" id="userNick" value="${user.nickName}">
											<input type="hidden" id="userCh" value="${user.userName}">
											<input type="hidden" id="roomCh" value="${roomNum}">
										</li>
										
									</ul>
								</div>

								<!-- 채팅입력 -->
								<!-- style="visibility: hidden;" -->
								<div id="chat-message" class="chat-message clearfix" style="visibility: hidden;">
									<div class="input-group mb-0">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="fa fa-send"></i></span>
										</div>
										<input type="text" name="message" id="sendMsg" class="form-control"
											placeholder="Enter text here...">
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<!--  style="block" -->
			 <div id="userModal" class="modal" tabindex="-1">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">채팅방 참여유저</h5>
			        <button type="button" id="closeBtn" data-userListNum="${chatHistory.chatRoomNum}" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <ul id="userListUl">
				        <c:forEach items="${chatUser}" var="user">
				        	<li>${user.nickName}</li>
			        	</c:forEach>
			        </ul>
			      </div>
			    </div>
			  </div>
			</div>

			<c:import url="../temps/footer.jsp"></c:import>
			<script src="/resources/js/chat.js"></script>
			<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
		</body>

		</html>