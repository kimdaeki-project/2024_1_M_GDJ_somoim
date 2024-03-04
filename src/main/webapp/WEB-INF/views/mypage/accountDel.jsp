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
</head>

<body>
	<!-- 내비게이터 import -->
	<c:import url="../temps/header.jsp"></c:import>

	<section class="login section">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-12">
                    <div class="form-head">
                        <h4 class="title">회원탈퇴</h4>
                        <form id="frm" action="./accountDel" method="post">							
                            <div class="form-group">
                                <label for="userName">Username</label>
                                <input name="userName" value="${member.userName}" id="userName" type="text" readonly>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input name="password" id="password" type="password">
                            </div>
							<!-- Button trigger modal -->
							<div>
								<button id="accountDel" type="button" class="btn btn-primary">탈퇴하기</button>
							</div>

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
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<!-- ========================= JS improt ========================= -->
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="../resources/js/member/accountDel.js"></script>
</body>

</html>