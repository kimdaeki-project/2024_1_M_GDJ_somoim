<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script src="https://js.tosspayments.com/v1/payment-widget"></script>
<style>
body {
	-webkit-text-size-adjust: none;
	display: flex;
	justify-content: center;
	align-items: center;
}

.btn:hover{
	background-color: #F2F2F2;
}

#exitBtn{
	cursor: pointer;
}




</style>
</head>

<body>
	<div class="container main-contents" style="width: 540px; margin: 0px; padding: 0px;">
		<div class="row mx-auto" style="background-color: white; width: 100%;">
			<div class="col-3 my-3 text-center">
				<image src="/resources/assets/images/logo/logo.png"
					style="width: 100%; height: 30px" />
			</div>
			<div class="col my-3 text-center">
				<h4 style="color: #737373">결제하기</h4>
			</div>
			<div class="col-3 my-3" style="padding-right: 27px;">
				<svg id="exitBtn" style="float: right" width="26" height="26" viewBox="0 0 24 24" fill="none"
					xmlns="http://www.w3.org/2000/svg">
					<path fill-rule="evenodd" clip-rule="evenodd"
						d="M4.36375 4.3637C4.01228 4.71517 4.01228 5.28502 4.36375 5.63649L18.3638 19.6365C18.7152 19.988 19.2851 19.988 19.6365 19.6365C19.988 19.285 19.988 18.7152 19.6365 18.3637L5.63654 4.3637C5.28507 4.01223 4.71522 4.01223 4.36375 4.3637Z"
						fill="#1E1E23"></path>
					<path fill-rule="evenodd" clip-rule="evenodd"
						d="M19.6365 4.3637C19.988 4.71517 19.988 5.28502 19.6365 5.63649L5.63649 19.6365C5.28502 19.988 4.71517 19.988 4.3637 19.6365C4.01223 19.285 4.01223 18.7152 4.3637 18.3637L18.3637 4.3637C18.7152 4.01223 19.285 4.01223 19.6365 4.3637Z"
						fill="#1E1E23"></path></svg>
			</div>
		</div>
		<div class="row mx-auto"
			style="background-color: #F7F7F7; padding: 8px; width: 97%; height: auto;">
			<div class="row mx-auto p-1"
				style="background-color: white; padding: 0px; margin-bottom: 3px;">
				<div class="col-10">
					<span style="font-weight: bolder;">결제상품</span>
				</div>
				<div class="col-2" style="text-align: right;">
					<svg data-bs-toggle="collapse" data-bs-target="#collapseDiv" aria-expanded="false" aria-controls="collapseDiv" xmlns="http://www.w3.org/2000/svg" width="16" height="9"
						viewBox="0 0 16 9" fill="none">
					<path d="M14.947 9 16 7.953 8 0 0 7.953 1.053 9 8 2.093 14.947 9z"
							fill="#A2A4A8"></path></svg>
				</div>
			</div>
			<div id="collapseDiv" class="row mx-auto p-1 collapse show"
				style="background-color: white; margin-bottom: 0px;">
				<div class="col-3">
					<img alt="" src="/resources/image/payment/product.png" style="width: 70px; height: 70px; margin: 5px">
				</div>
				<div class="col-9 d-flex flex-column justify-content-end">
					<ul class="mb-2">
						<li><span id="orderName">${type.pTypeName}</span></li>
						<li><span style="color: lightskyblue"> <c:set
									var="formattedPrice" value="${type.pTypePrice}" /> <fmt:formatNumber
									value="${formattedPrice}" pattern="#,###" />원
						</span></li>
						<li><span id="pTypeNum" data-ptype="${type.pTypeNum}" style="display: none;"></span></li>
					</ul>
				</div>
			</div>
			<div class="row mx-auto p-1 mb-2" style="background-color: #BDBDBD">
				<div class="col-3">
					<span style="color: black; margin-inline: 5px">상품금액</span>
				</div>
				<div class="col" style="text-align: right;">
					<span id="priceSpan" style="font-weight: bold"><fmt:formatNumber
							value="${formattedPrice}" pattern="#,###" />원</span>
				</div>
			</div>
			<div class="row mx-auto p-1 mb-2" style="background-color: white;">
				<div id="payment-method"></div>
				<div id="agreement"></div>
				<div style="text-align: right; margin-left: 5px; width: 54px; padding-top: 6px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px;">
					<input id="agreementCheck" type="checkbox" checked style="width: 24px; height: 24px; border-radius: 20%;"/>
				</div>
				<div class="col" style="padding: 6px;">
					<span style="color: black;">[필수] 정기결제로 진행되는 것에 동의 합니다.</span>
				</div>
			</div>
			<div style="background-color: white; padding: 0px;  margin-bottom: 10px;">
					<button id="payment" class="btn" style="width: 100%" type="button">결제하기</button>
			</div>
		</div>
	</div>

	<script src="/resources/assets/js/bootstrap.min.js"></script>
	<script src="/resources/assets/js/wow.min.js"></script>
	<script src="/resources/assets/js/tiny-slider.js"></script>
	<script src="/resources/assets/js/glightbox.min.js"></script>
	<script src="/resources//js/payment/paymentPopup.js"></script>
</body>

</html>