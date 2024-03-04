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
<c:import url="../../../temps/head_css.jsp"></c:import>
<!-- 내비게이터 import -->
<c:import url="../../../temps/header.jsp"></c:import>
<!-- summernote -->
<c:import url="../../../temps/summernote.jsp"></c:import>
</head>
<body>
	<!-- 모임 홈 헤더 -->
	<div class="breadcrumbs">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6 col-md-6 col-12">
					<div class="breadcrumbs-content">
						<h1 class="page-title"></h1>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-12">
					<ul class="nav justify-content-end">
						<li class="nav-item"><a class="nav-link" href="../home?moimNum=${dto.moimNum}"
							style="color: white">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="./list?moimNum=${dto.moimNum}"
							style="color: white; font-weight: bold;">게시판</a></li>
						<li class="nav-item"><a class="nav-link" href="../together?moimNum=${dto.moimNum}"
							style="color: white">정모</a></li>
						<li class="nav-item"><a class="nav-link" href="/chat"
							style="color: white">채팅</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 본문 -->
	<div class="items-details section pt-2">
		<div class="col-12 mx-3 bg-white" style="border-radius: 10px; width: 99%">
			<div class="section-title" style="margin-bottom: 40px">
				<h2 class="wow fadeInUp" data-wow-delay=".4s"
					style="font-size: 22px; padding-bottom: 10px; margin-top: 20px; margin-bottom: 8px; height: 45px">게시판 글쓰기</h2>
				
			</div>
		</div>
						
						
		<div class="comment-form">
            <h3 class="comment-reply-title"><span style="font-weight: bold;">Writing</span></h3>
            
            <form action="./add" method="POST" enctype="multipart/form-data">
                <div class="row">
					<input type="hidden" name="moimNum" value="${dto.moimNum}">
                    <div class="mb-3">
						<input type="text" class="form-control" id="boardTitle" name="boardTitle" maxlength = "30" placeholder="제목을 입력해 주세요.">
					</div>
					<div class="mb-3">
						<textarea class="form-control" id="boardText" name="boardText" rows="8" placeholder="내용을 입력하세요."></textarea>
					</div>
					<div class="mb-3">
						<label for="exampleFormControlTextarea1" class="form-label">파일 첨부</label>
						<div class="input-group mb-3">
						  <input type="file" class="form-control" name="file">
						  <input type="file" class="form-control" name="file">
						  <input type="file" class="form-control" name="file">
						</div>
					</div>
							
								
                    <div class="col-12">
                        <div class="button text-center">
                            <button type="submit" class="btn" id="submit">등록</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
			
	</div>


	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<!-- ========================= JS improt ========================= -->
	<c:import url="../../../temps/footer.jsp"></c:import>
	<script src="https://unpkg.com/bootstrap@4.3.1/dist/js/bootstrap.bundle.min.js" data-src="https://unpkg.com/bootstrap@4.3.1/dist/js/bootstrap.min.js" ></script>
	<script src="https://unpkg.com/bootstrap-select@1.13.8/dist/js/bootstrap-select.min.js"></script>
	<script src="/resources/js/moim/moimboardAdd.js"></script>
</body>

</html>