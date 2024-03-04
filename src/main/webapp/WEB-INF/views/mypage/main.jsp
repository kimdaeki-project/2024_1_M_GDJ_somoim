<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Somoim</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- CSS 임포트 -->
<c:import url="../temps/head_css.jsp"></c:import>
<!-- 내비게이터 import -->
<c:import url="../temps/header.jsp"></c:import>
</head>
<body>
	<div class="items-grid section" style="padding-top: 120px;">
		<div class="container mx-5">
			<div class="row">
				<!-- Sidebar -->
				<c:import url="./mypage_nav.jsp"></c:import>
				<div class="col-lg-1 col-md-1"></div>
				<!-- Main content -->
				<div class="col-lg-9 col-md-7 col-12 bg-white"
					style="border-radius: 10px">
					<div class="row">
						<h2 class="mb-4">Profile Settings</h2>
						
						<form id="frm" action="./update" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
						<table class="table table-hover" id="del_td">
							<tr>
								<td colspan="5">
									<c:if test="${empty member.profile}">
										<img class="rounded float-left"
											src="/resources/img/profile/profile.jpg" alt="..." style="width: 80px; height: 80px;">
											
									</c:if> 
									<c:if test="${not empty member.profile.fileName}">
										<img class="rounded float-left"
											src="../resources/upload/member/${member.profile.fileName}" alt="..." style="width: 80px; height: 80px;">
											
									</c:if>
								</td>
							</tr>
							<tr id="show_profile" style="display: none;">
								<td>프로필 사진 변경</td>
								<td><input class="profile" name="attachs" type="file"></td>
							</tr>
							<tr>
								<td class="table dark">닉네임</td>
								<td class="del">${member.nickName}${appmember.nickName}
								</td>								
								<td><input type="hidden" name="nickName" value="${member.nickName}${appmember.nickName}" class="show"></td>
							</tr>

							<tr>
								<td class="table dark">이름</td>
								<td>
									${member.name}${appmember.name}
								</td>								
							</tr>

							<tr>
								<td class="table dark">주소</td>
								<td class="del">${member.address}${appmember.address}</td>
								<td><input type="hidden" id="adrs_in" name="address" value="${member.address}${appmember.address}" class="show"></td>
								<td><button type="button" id="getLocation" style="display: none;" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    주소 검색하기
                                </button>
                                 <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>                                            
                                        <div class="modal-body">
                                                <label for="area">지역 : </label>
                                                <select id="area" onchange="changeList()">    
                                                    <option value="0">선택하기</option>
                                                </select>
                                        </div>                                            
                                        <div>
                                            <label for="area_detail">세부지역 : </label>
                                            <select id="area_detail">
                                                <option value="0">선택하기</option>
                                            </select>
                                        </div>
                                        <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="btn_close">Close</button>
                                        <button type="button" class="btn btn-primary" id="btn_area">Save changes</button>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                                </td>
							</tr>

							<tr>
								<td class="table dark">전화번호</td>
								<td class="del">${member.phone}${appmember.phone}</td>
								<td><input type="hidden" name="phone" value="${member.phone}${appmember.phone}" class="show"></td>
							</tr>

							<tr>
								<td class="table dark">이메일</td>
								<td class="del">${member.email}${appmember.email}</td>
								<td><input type="hidden" name="email" value="${member.email}${appmember.email}" class="show"></td>
							</tr>

						</table>
					</form>
					<span>
						<button id="btn1" class="btn btn-hover">수정하기</button>
						<button id="btn2" hidden class="btn btn-hover">수정완료</button>
					</span>
					<br><br><br><br>
					<c:if test="${appmember eq null}">
						<h2>비밀번호 변경</h2>
						<form id="frm2" action="./password" method="post">
							<table class="table table-hover" id="del_td">
								<tr>
									<td class="table dark">현재 비밀번호</td>
									<td><input type="password" id = "p_pwd"></td>
								</tr>

								<tr hidden>									
									<td id="p_pwdCheck">${member.password}</td>
								</tr>

								<tr>
									<td class="table dark">변경 할 비밀번호</td>
									<td><input type="password" name="password" id = "password"></td>
								</tr>
								<tr>
									<td class="table dark">변경 할 비밀번호확인</td>
									<td><input type="password" id = "passwordCheck"></td>
								</tr>
								
							</table>
						</form>
						<button id="btn3">비밀번호 수정</button>
					</c:if>
				</div>
			
					
					
					
					
					

					<!-- Main content goes here -->
				</div>
				
			</div>
		</div>
	</div>
	<div>
	</div>

	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<!-- ========================= JS improt ========================= -->
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="../resources/js/mypage/main.js"></script>
</body>

</html>