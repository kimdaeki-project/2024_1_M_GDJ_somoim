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
<!-- 카테고리 -->
<link rel=stylesheet href="https://unpkg.com/bootstrap-select@1.13.8/dist/css/bootstrap-select.css" />
</head>
<body>
	<div class="items-grid section">
		<div class="container mx-5">
			<div class="row">
				<!-- Sidebar -->
				<c:import url="../mypage/mypage_nav.jsp"></c:import>
				<div class="col-lg-1 col-md-1"></div>
				
				
				<!-- Main content -->
				<div class="col-lg-9 col-md-7 col-12 bg-white" style="border-radius: 10px">
					<div class="row">
						<!-- 안에 내용 수정해서 사용하세요 -->
						<div class="col-6"></div>
						
						<!-- 타이틀 -->
						<div class="col-12 mx-3 bg-white" style="border-radius: 10px; width: 99%">
							<div class="section-title" style="margin-bottom: 40px">
								<h2 class="wow fadeInUp" data-wow-delay=".4s"
									style="font-size: 22px; padding-bottom: 10px; margin-top: 20px; margin-bottom: 8px; height: 45px">모임
									수정</h2>
								<p class="wow fadeInUp" data-wow-delay=".6s" style="font-size: 12px;">수정할 내용을 입력해주세요.</p>
							</div>
						</div>

						<!-- 폼  -->  
						<form id="updateForm" action="./update" method="post" enctype="multipart/form-data">
			                <div class="col-12 mx-3 px-5 bg-white" style="border-radius: 10px; width: 99%">
			                
								<!-- 모임설정 -->
								<div class="mb-3">
									<label for="moimName" class="form-label">모임 이름(2~10자)</label>
									<input type="text" class="form-control" id="moimName" name="moimName" value="${dto.moimName}" placeholder="모임 이름" minlength = "2" maxlength = "10">
								</div>
								<div class="mb-3">
									<label for="moimText" class="form-label">모임 설명</label>
									<textarea class="form-control" id="moimText" name="moimText" rows="8" placeholder="모임에 대한 설명이나 목표를 적어주세요.">${dto.moimText}</textarea>
								</div>
								<div class="mb-3">
									<label for="exampleFormControlTextarea1" class="form-label">모임 대표 이미지</label>
									<div class="mb-3">
										<c:if test="${empty dto.moimFileDTO.fileName}">
											<img src="/resources/img/moim/basic.png" id="preview" style="width: 100px; height: 100px; border-radius: 50px;" alt="..." >
										</c:if>
										<c:if test="${not empty dto.moimFileDTO.fileName}">
											<img src="/resources/upload/moim/${dto.moimFileDTO.fileName}" id="preview" style="width: 100px; height: 100px; border-radius: 50px;" alt="...">
										</c:if>
									</div>
									<div class="input-group mb-3">
									  <!-- <input type="file" class="form-control" name="file" onchange="readImg(this);"> -->
									  <input class="form-control" type="file" id="formFileMultiple" onchange="readImg(this);" data-file-count="0" data-file-max="1" name="file" accept="image/jpg, image/jpeg, image/png, image/gif">
									</div>
								</div>
								<div class="mb-3">
									<label for="moimName" class="form-label">모임 정원(10~300명)</label>
									<input type="number" class="form-control" id="moimMemCount" name="moimMemCount" value="${dto.moimMemCount}" min="10" max="300">
								</div>
								
								<input type="hidden" name="moimNum" value="${dto.moimNum}">

								<!-- 제출 -->
								<div class="button text-center">
									<button class="btn my-3" id="submitBtn" type="submit">Update</button>
								</div>
	
							</div>
						</form>
						
						
						
						
						
						
						
						
						
						
						
						
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
	<script src="https://unpkg.com/bootstrap@4.3.1/dist/js/bootstrap.bundle.min.js" data-src="https://unpkg.com/bootstrap@4.3.1/dist/js/bootstrap.min.js" ></script>
	<script src="https://unpkg.com/bootstrap-select@1.13.8/dist/js/bootstrap-select.min.js"></script>
	<script src="/resources/js/moim/moimUpdate.js"></script>
</body>

</html>