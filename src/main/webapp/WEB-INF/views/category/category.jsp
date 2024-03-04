<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach items="${data}" var="data">
	<input type="hidden" name="address"value="${data.address}"/>
	<div class="col-6" mb-2>
		<div class="single-grid wow fadeInUp" data-wow-delay=".2s">
			<div class="image">
				<a href="../moim/main/home?moimNum=${data.moimNum}" class="thumbnail"><img
					src="../resources/upload/moim/${data.moimFileDTO.fileName}" alt="#" onerror="this.src='/resources/img/moim/basic.png';"></a>
				<div class="author">
					<div class="author-image">
					<!-- 프로필 이미지 -->
						<a href="javascript:void(0)"><img
							src="../resources/upload/member/${member.profile.fileName}" alt="#" onerror="this.src='/resources/img/moim/basic.png';"> <span>${data.moimHead}</span></a>
					</div>
				</div>
			</div>
			<div class="content">
				<div class="top-content">
					<a href="javascript:void(0)" class="tag">${data.moimCategory}</a>
					<h3 class="title">
						<a href="../moim/main/home?moimNum=${data.moimNum}">${data.moimName}</a>
					</h3>
					<ul class="info-list">
						<li><a href="javascript:void(0)"><i class="lni lni-map-marker"></i>${data.moimRegion}</a></li>						
					</ul>
				</div>
			</div>
		</div>

	</div>
</c:forEach>
<div class="mt-3">
	<ul
		class="list-group list-group-horizontal d-flex justify-content-center">
		<c:if test="${!pager.start}">
			<li class="page-item"><a class="page-link" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
			</a></li>
		</c:if>

		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a data-pageNum="${i}" class="page-link">${i}</a>
			</li>
		</c:forEach>

		<c:if test="${!pager.last}">
			<li class="page-item"><a class="page-link" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
			</a></li>
		</c:if>
	</ul>
</div>