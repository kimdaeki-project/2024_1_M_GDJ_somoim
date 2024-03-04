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
						<li class="nav-item"><a class="nav-link" href="../home?moimNum=${moimDTO.moimNum}"
							style="color: white">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="./list?moimNum=${moimDTO.moimNum}"
							style="color: white; font-weight: bold;">게시판</a></li>
						<li class="nav-item"><a class="nav-link" href="../together?moimNum=${moimDTO.moimNum}"
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
            <!-- 가림 -->
            <div class="category-grid-topbar">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6 col-12">
                        <nav>
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <button class="nav-link active" id="nav-grid-tab" data-bs-toggle="tab" data-bs-target="#nav-grid" type="button" role="tab" aria-controls="nav-grid" aria-selected="true"><i class="lni lni-list"></i></button>
                                <!-- <button class="nav-link" id="nav-list-tab" data-bs-toggle="tab" data-bs-target="#nav-list" type="button" role="tab" aria-controls="nav-list" aria-selected="false"><i class="lni lni-bookmark"></i>&nbsp;공지</button> -->
                            </div>
                        </nav>
                    </div>
                </div>
            </div>

            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-grid" role="tabpanel" aria-labelledby="nav-grid-tab">
                	<!-- 서치 -->
                    <div class="mt-5">
						<form class="row g-3" action="./list">
						  <div class="col-auto">
							  <select name="searchFind" class="form-select" aria-label="Default select example">
								  <option class="a" value="searchFind1">제목</option>
								  <option class="a" value="searchFind2">내용</option>
								  <option class="a" value="searchFind3">작성자</option>
								  <option class="a" value="searchFind4">제목+내용+작성자</option>
							</select>
						  </div>		
						
						  <div class="col-auto">
						    <label for="search" class="visually-hidden">Search</label>
						    <input type="text" name="search" class="form-control" id="search">
						  </div>
						  <div class="col-auto">
						    <button type="submit" class="btn mb-3" style="background-color: rgb(88,48,224); color:white;"><i class="lni lni-search-alt theme-color"></i></button>
						  </div>
						  <input type="hidden" name="moimNum" value="${moimDTO.moimNum}">
						</form>
					</div>
                    
                    <!-- 자유게시판 -->
					<table class="table">
						<thead class="text-center">
						  <tr>
							<th scope="col">No.</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회</th>
							<!-- <th scope="col">좋아요</th> -->
						  </tr>
						</thead>
						<tbody class="table-group-divider" id="listTbody">
							<!-- 서치 결과 없을 때 -->
							<c:if test="${list.size()==0}">
								<tr>
									<td colspan="4">결과 없습니다</td>
								<tr>
							</c:if>
							
							<c:forEach items="${list}" var="dto">
								<tr>
									<th class="col-md-1 text-center" scope="row">${dto.boardNum}</th>
									<td class="col-md-5 ps-5 "><a href="./detail?moimNum=${dto.moimNum}&boardNum=${dto.boardNum}">${dto.boardTitle}</td>
									<td class="col-md-2 text-center">${dto.boardWriter}</td>
									<td class="col-md-3 text-center">${dto.boardDate}</td>
									<td class="col-md-1 text-center">${dto.boardClick}</td>
									<%-- <td class="col-md-1 text-center"> ${dto.boardLike}</td> --%>
								  </tr>
							</c:forEach>

						</tbody>
					  </table>


					<!-- 글쓰기 -->
                    <div class="row">
	                    <div class="button">
							<a href="./add?moimNum=${moimDTO.moimNum}" class="btn my-3" id="addBtn">글쓰기</a>
						</div>
                    </div>
                    
                    <!-- 페이징 -->
                    <div class="row">
                        <div class="col-12">
                            <!-- Pagination -->
                            <div class="pagination left text-center">
                                <ul class="pagination-list">
									<c:if test="${!pager.start}">
										<li><a href="./list?page=${pager.startNum-1}&search=${pager.search}&searchFind=${pager.searchFind}&moimNum=${moimDTO.moimNum}"><i class="lni lni-chevron-left"></i></a></li>
									</c:if>
									<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                                    	<li ><a href="./list?page=${i}&search=${pager.search}&searchFind=${pager.searchFind}&moimNum=${moimDTO.moimNum}">${i}</a></li>
									</c:forEach>
									<c:if test="${!pager.last}">
                                    	<li><a href="./list?page=${pager.lastNum+1}&search=${pager.search}&searchFind=${pager.searchFind}&moimNum=${moimDTO.moimNum}"><i class="lni lni-chevron-right"></i></a></li>
									</c:if>
                                </ul>
                            </div>
                            <!--/ End Pagination -->
                        </div>
                    </div>


				</div>
                
                
            </div>
			
	</div>



	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<!-- ========================= JS improt ========================= -->
	<c:import url="../../../temps/footer.jsp"></c:import>
</body>

</html>