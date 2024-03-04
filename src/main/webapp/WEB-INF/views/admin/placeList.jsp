<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach items="${admin}" var="admin" begin="0" end="5">
	<div class="col-4" mb-2>
		<!-- Start Single Grid -->
		<div class="single-grid wow fadeInUp" data-wow-delay=".2s">
			<div class="image" style="text-align: center;">
				<a href="${admin.placeLink}" class="thumbnail"><img
					src="${admin.placeImageLink}" alt="#" width="300" height="250"
					style="object-fit: cover;" onerror="this.src='/resources/img/moim/basic.png';"></a>
			</div>

			<div class="content">
				<div class="top-content">
					<h3 class="title">
						<a href="${admin.placeLink}">${admin.placeTitle}</a>
					</h3>
					<ul class="info-list">
						<li><a href="javascript:void(0)"><i
								class="lni lni-map-marker"></i>${admin.placeAddress}</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- End Single Grid -->
	</div>
</c:forEach>