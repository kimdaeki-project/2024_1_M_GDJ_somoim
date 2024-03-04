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
	<section class="findPw section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-12">
					<div class="form-head">
						<h4 class="title">비밀번호 찾기</h4>
							<form id="frm" action="./findPw" method="post">
							    <div class="form-group">
							        <label for="userName">Username</label>
							        <input type="text" placeholder="아이디" name="userName" id="userName">
							    </div>
	                            <div class="form-group">
	                                <label for="email">이메일</label>
	                                <input type="text" placeholder="이메일" name="email" id="email" class="email">
	                                <button type="button" id="checkId" class="email_auth_btn">인증번호 받기</button>
	                            </div>
	                            <div class="form-group">
	                                <input type="text" placeholder="인증번호 입력" id="email_auth_key">
	                                <button type="button" id="key_check">인증번호 확인</button>
	                                <br>
	                                <p style="display: none;" id="auth_check">일치합니다</p>
	                            </div>

								<table id="findpwd" style="display: none;">
									<tr>
										<td class="table dark">변경 할 비밀번호</td>
										<td><input type="password" name="password" id="password"></td>
									</tr>
									<tr>
										<td class="table dark">변경 할 비밀번호확인</td>
										<td><input type="password" id="passwordCheck"></td>
									</tr>
								</table>
								<div>
									<button type="button" id="chg_pwd" style="display: none;">변경하기</button>
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
	<script src="../resources/js/member/findPw.js"></script>
	
	
</body>

</html>