<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Somoim</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- CSS 임포트 -->
<c:import url="../../temps/head_css.jsp"></c:import>
<!-- 내비게이터 import -->
<c:import url="../../temps/header.jsp"></c:import>
</head>
<body>
	<!-- empty경우 -->
	<c:if test="${empty dto}">
		<div class="breadcrumbs" style="background-color: white;">
			<!-- <div class="container"> -->
				<!-- <div class="row align-items-center"> -->
					



					<div class="d-table">
						<div class="d-table-cell">
						  <div class="container">
							<div class="error-content">
							  <h1>^0^)/♥</h1>
							  <h2>존재하지 않는 모임입니다.</h2>
							  <p>다시 시도 해주세요.</p>
							  <div class="button">
								<a href="/" class="btn">Go To Home</a>
							  </div>
							</div>
						  </div>
						</div>
					  </div>


				<!-- </div>
			</div> -->
		</div>

		
	</c:if>
	
	<c:if test="${not empty dto}">
	
	<!-- 모임 홈 헤더 -->
	<div class="breadcrumbs">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6 col-md-6 col-12">
					<div class="breadcrumbs-content">
						<h1 class="page-title">${dto.moimName}</h1>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-12">
					<ul class="nav justify-content-end">
						<li class="nav-item"><a class="nav-link" href="./home?moimNum=${dto.moimNum}"
							style="color: white; font-weight: bold;">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="./board/list?moimNum=${dto.moimNum}"
							style="color: white">게시판</a></li>
						<li class="nav-item"><a class="nav-link" href="./together?moimNum=${dto.moimNum}"
							style="color: white">정모</a></li>
						<li class="nav-item"><a class="nav-link" href="/chat"
							style="color: white">채팅</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 가입(비멤버만) -->
		<c:if test="${not fn:contains(contain, member.userName)}">
			<div class="button me-5 mt-3" style="text-align: right;">
			<a class="btn" id="joinBtn" data-mem-count="${memNum}" data-moim-count="${dto.moimMemCount}"
			data-moim-num="${dto.moimNum}">가입하기</a>
			<%-- <p>${ar.userName} : ${member.userName}</p> --%>
			</div>

		</c:if>
		<c:if test="${fn:contains(contain, member.userName)}">
			<input type="hidden" id="joinBtn">
		</c:if>
		
		
	
	
	<div class="items-details section">
		<div class="container mx-5">


			<!-- 모임 사진 -->
			<div class="post-thumbnils">
				<c:if test="${empty dto.moimFileDTO.fileName}">
					<img src="/resources/img/moim/basic.png" style="width: 70%; height: 500px;" alt="모임 대표 사진" >
				</c:if> 
				<c:if test="${not empty dto.moimFileDTO.fileName}">
					<img src="/resources/upload/moim/${dto.moimFileDTO.fileName}" style="width: 70%; height: 500px;" alt="모임 대표 사진">
				</c:if>
			
			</div>
			
			<!-- 본문 -->
			<div class="post-details">
				<div class="detail-inner">
					
					<!-- 모임설명 -->
					<div>${dto.moimText}</div>
					
					<!-- 정보 -->
					<blockquote>
						<div class="icon">
							<i class="lni lni-quotation"></i>
						</div>
						
						<h3 class="post-title" style="color: white;">Welcome</h3>
						<p>모임장 : ${dto.moimHead}</p>
					</blockquote>
					<h5>꼭 읽어주세요.</h5>                             
					<ul class="list">
						<li><i class="lni lni-chevron-right"></i> 서로에 대한 예절을 지켜주세요. (비매너, 공격적 언행 금지) </li>
						<li><i class="lni lni-chevron-right"></i> 운영 목적과 관련된 글만 올려 주세요. (광고 글, 불법정보 공유, 정치 글 금지)</li>
						<li><i class="lni lni-chevron-right"></i> 위반 시 불이익이 있을 수 있습니다.</li>
					</ul>
					
					<!-- 참여멤버 -->
					<div class="post-comments mt-2" id="listBody">
						<h3>참여멤버( ${memNum} / ${dto.moimMemCount} )</h3>

						<c:forEach items="${memInfo}" var="ar">
							<h3 class="comment-title my-4"></h3>
							
							<div class="single-list">
                                <div class="row align-items-center">
                                	<div class="col-lg-1 col-md-1 col-12">
                                		<p><i class="lni lni-chevron-right"></i></p>
                                	</div>
                                    <div class="col-lg-5 col-md-5 col-12">
                                        <p>ID  :   ${ar.userName} &ensp;
                                            <span>
                                            	<c:if test="${ar.moimRoleNum eq '1'}">
												<i class="lni lni-diamond-alt" style="color: rgb(88,48,224);"></i>
												</c:if>
												<c:if test="${ar.moimRoleNum ne '1'}">
												<i class="lni lni-user" style="color: rgb(88,48,224);"></i>
												</c:if>
											</span>
                                        </p>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-12">
                                        <p>${ar.joinDate}</p>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-12 align-right">
                                    	<c:if test="${member.userName eq dto.moimHead}">
                                    		<c:if test="${ar.moimRoleNum ne '1'}">
				                            <button type="button" class="btn btn-outline-danger kick" data-moim-num="${dto.moimNum}" data-user-name="${ar.userName}">Kick out</button>
				                            </c:if>
                                    	</c:if>
                                    </div>
                                </div>
                            </div>
							
							
						</c:forEach>
					</div>
					
					
					
					
					
				</div>

			</div>

		</div>
	</div>
	</c:if>
	

	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<!-- ========================= JS improt ========================= -->
	<c:import url="../../temps/footer.jsp"></c:import>
	<script src="/resources/js/moim/home.js"></script>
	
</body>

</html>