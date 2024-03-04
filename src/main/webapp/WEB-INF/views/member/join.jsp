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
    <!-- start Registration section -->
    <section class="login registration section">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-12">
                    <div class="form-head">
                        <h4 class="title">Registration</h4>
                        <form id="frm" action="./join" method="post" enctype="multipart/form-data">
                            <div class="socila-login">
                                <ul>
                                    <li><a href="javascript:void(0)" class="facebook"><i class="lni lni-facebook-original"></i>Import
                                            From Facebook</a></li>
                                    <li><a href="javascript:void(0)" class="google"><i class="lni lni-google"></i>Import From Google
                                            Plus</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="alt-option">
                                <span>Or</span>
                            </div>
                            <div class="form-group">
                                <label for="userName">아이디</label>
                                <input name="userName" id="userName" type="text">
                                <button id="checkId" type="button">중복검사</button>
                            </div>
                            <div class="form-group">
                                <label for="password">비밀번호</label>
                                <input name="password" id="password" type="password">
                                <div id="passwordResult"></div>
                            </div>
                            <div class="form-group">
                                <label for="passwordCheck">비밀번호 확인</label>
                                <input id="passwordCheck" type="password">
                                <div id="passwordCheckResult"></div>
                            </div>
                            <div id="passwordCheckReulst"></div>
                            <div class="form-group">
                                <label for="nickName">별명</label>
                                <input name="nickName" id="nickName" type="text">
                            </div>
                            <div class="form-group">
                                <label for="name">이름</label>
                                <input name="name" id="name" type="text">
                            </div>
                            <div class="form-group">
                                <label for="userBirth">생년월일</label>
                                <select id="year">
                                    <option value="">-- 선택 --</option>
                                    <!-- 생년월일에서 연도를 선택하는 옵션들 -->
                                    <!-- 이 부분은 생략하고 필요한 범위의 연도 옵션을 추가하세요 -->
                                </select>
                                    <label for="year">년</label>
                            
                                <select id="month">
                                    <option value="">-- 선택 --</option>
                                    <!-- 생년월일에서 월을 선택하는 옵션들 -->
                                    <!-- 이 부분은 생략하고 1월부터 12월까지의 옵션을 추가하세요 -->
                                </select>
                                    <label for="month">월</label>
                            
                                <select id="day">
                                    <option value="">-- 선택 --</option>
                                    <!-- 생년월일에서 일을 선택하는 옵션들 -->
                                    <!-- 이 부분은 생략하고 필요한 범위의 일 옵션을 추가하세요 -->
                                </select>                            
                                    <label for="day">일</label>
                                <input name="userBirth" id="userBirth" type="hidden" maxlength="10">
                            </div>
                            <div class="form-group">
                                <!-- Button trigger modal -->
                                <button type="button" id="getLocation" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    주소 검색하기
                                </button>
                                <br><br>
                                <!-- Modal -->
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
                                
                                <div>
                                    <input name="address" placeholder="주소버튼 클릭!" type="text" id="adrs_in" readonly>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="phone">전화번호</label>
                                <input name="phone" id="phone" type="text">
                            </div>



                            <div class="form-group">
                                <label for="email">이메일</label>
                                <input type="text" placeholder="이메일" name="email" id="email" class="email">
                                <button type="button" id="email_auth_btn" class="email_auth_btn">인증번호 받기</button>
                            </div>
                            <div class="form-group">
                                <input type="text" placeholder="인증번호 입력" id="email_auth_key">
                                <button type="button" id="key_check">인증번호 확인</button>
                                <br>
                                <p style="display: none;" id="auth_check">인증확인!</p>
                            </div>

                            <div class="form-group">
                                <label for="attachs">사진첨부</label>
                                <input name="attachs" id="attachs" type="file">
                            </div>

                            <div class="form-group" hidden>                                
                                <input name="loginNum" id="attachs" value="1" type="text">
                            </div>


                            <div class="check-and-pass">
                                <div class="row align-items-center">
                                    <div class="col-12">
                                        <div class="form-check">
                                            <input type="checkbox" class="form-check-input width-auto"
                                                id="check1">
                                            <label for="check1"class="form-check-label">개인정보 이용동의</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="button">
                                <button type="submit" id="btn">Registration</button>
                            </div>
                            <p class="outer-link">Already have an account? <a href="/member/login"> Login Now</a>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    	<!-- ========================= JS improt ========================= -->
	<c:import url="../temps/footer.jsp"></c:import>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="../resources/js/member/joinCheck.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	
	
</body>
</html>