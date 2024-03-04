<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

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
 <!-- start login section -->
    <section class="login section">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-12">
                    <div class="form-head">
                        <h4 class="title">Login</h4>
                        <form action="./login" method="post">
                            <div class="form-group">
                                <label for="userName">Username</label>
                                <input name="userName" value="user1" id="userName" type="text">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input name="password" value="user1" id="password" type="password">
                            </div>
                            <div class="check-and-pass">
                                <div class="row align-items-center">
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-check">
                                            <input type="checkbox" class="form-check-input width-auto"
                                                id="exampleCheck1">
                                            <label class="form-check-label">Remember me</label>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <a href="findPw" class="lost-pass">Lost your password?</a>
                                    </div>
                                </div>
                            </div>
                            <div class="button">
                                <button type="submit" class="btn">Login Now</button>
                            </div>
                            <div class="alt-option">
                                <span>Or</span>
                            </div>
                            <div class="socila-login">
                                <ul>
                                    <li><a href="javascript:void(0)" class="facebook"><i class="lni lni-facebook-original"></i>Login With
                                            Facebook</a></li>
                                    <li>
										<div id="g_id_onload" data-client_id="412327098082-jo918jh8s5gmuiifhgsimmn6m4cgcif6.apps.googleusercontent.com"
                                        data-callback="handleCredentialResponse">
                                        </div>

										<div class="g_id_signin" data-type="standard" data size="large"
										  data-theme="outline" data-text="sign_in_with" data-shape="rectangular" data-logo_alignment="left">
										</div>

                                        <a id="kakao-login-btn" href="https://kauth.kakao.com/oauth/authorize?client_id=${kakaoApiKey}&redirect_uri=${redirectUri}&response_type=code">
                                            <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
                                              alt="카카오 로그인 버튼" />
                                          </a>
                         
                                        </li>
                                </ul>
                            </div>
                            <p class="outer-link">Don't have an account? <a href="./join">회원가입</a>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- end login section -->


	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>
    <script src="../resources/js/member/google.js"></script>
    <script src="https://accounts.google.com/gsi/client" async defer></script>
	
    
	<!-- ========================= JS improt ========================= -->
	<c:import url="../temps/footer.jsp"></c:import>
</body>

</html>