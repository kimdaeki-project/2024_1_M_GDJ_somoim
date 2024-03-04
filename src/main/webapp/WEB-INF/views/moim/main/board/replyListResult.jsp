<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${list}" var="dto">

	<c:if test="${dto.replyDepth eq '0' }">
	<div>
	</c:if>

	<c:if test="${dto.replyDepth ne '0' }">
	<div class=" ms-5">
	</c:if>
	
		<!-- action -->
		<div style="text-align: right;">
			<c:if test="${dto.userName eq member.userName}">
				<a href="javascript:void(0)" ><i class="lni lni-pencil" data-bs-toggle="modal" data-bs-target="#exampleModal${dto.replyNum}"></i></a>
				<!-- 수정 Modal -->
				<div class="modal fade" id="exampleModal${dto.replyNum}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">댓글 수정</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form method="post" id="replyUpdateForm">
								<textarea class="form-control" name="replyText" id="replyText${dto.replyNum}" rows="3">${dto.replyText}</textarea>
					
							</form>
						</div>
						<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="replyCloseButton${dto.replyNum}">Close</button>
						<button type="button" class="btn btn-primary up" data-reply-num="${dto.replyNum}">Update</button>
						</div>
					</div>
					</div>
				</div>
	
				<a href="javascript:void(0)" ><i class="lni lni-trash del" data-reply-num="${dto.replyNum}"></i></a>
			</c:if>

			<%-- <c:if test="${dto.replyDepth eq '0' }"> --%>
				<a href="javascript:void(0)"><i class="lni lni-reply re" data-bs-toggle="modal" data-bs-target="#reModal${dto.replyNum}" data-reply-num="${dto.replyNum}"></i></a>
				<!-- 답댓 Madal -->
				<div class="modal fade" id="reModal${dto.replyNum}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">답 댓글</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form method="post" id="reUpdateForm">
								<input type="hidden" name="boardNum" value="${dto.boardNum}">
								<textarea class="form-control" name="replyText" id="reText${dto.replyNum}" rows="3"></textarea>
					
							</form>
						</div>
						<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="reCloseButton${dto.replyNum}">Close</button>
						<button type="button" class="btn btn-primary replyup" data-reply-num="${dto.replyNum}">Update</button>
						</div>
					</div>
					</div>
				</div>
			<%-- </c:if> --%>
		</div>
		<!-- 댓글 -->
		<div class="author-profile">
			<c:if test="${not empty dto.replyProfile}">
				<img src="/resources/upload/member/${dto.replyProfile}" alt="2" style="width: 36px; height: 36px; border-radius: 100px;">
			</c:if>
			<c:if test="${empty dto.replyProfile}">
				<img src="/resources/img/profile/profile.jpg" alt="3" style="width: 36px; height: 36px; border-radius: 100px;">
			</c:if>
			<span class="mx-2">${dto.replyWriter}&ensp;·&ensp;${dto.replyDate}</span>
			
		</div>
		<div class="ms-5">
			
			<c:if test="${dto.replyDepth > '1' }">
			<span style="color: steelblue; font-weight: bolder;">@${dto.parent}&nbsp;</span>
			</c:if>
			${dto.replyText}
		</div>
	</div>
	<h3 class="comment-title my-4"></h3>


</c:forEach>

<div class="col-auto text-center">
	<button id="more" data-replyList-page="${pager.page}" data-replyList-totalPage="${pager.totalPage}" class="btn btn-light btn-sm">더보기 (${pager.page} / ${pager.totalPage})</button>				    	
</div>
