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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- CSS 임포트 -->
<c:import url="../temps/head_css.jsp"></c:import>
</head>

<body>
	<!-- 내비게이터 import -->
	<c:import url="../temps/header.jsp"></c:import>

	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<div class="d-grid gap-3 mb-2">
		<div class="p-5"></div>
		<div class="p-3 mx-auto">
			<h3>${board}</h3>
		</div>
	</div>
	<!--  -->
	<div class="container mb-4" name="categorySelect">
	</div>
	<!--  -->
	<div class="container">
<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        자주하는 질문 1
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <h5><strong>모임의 기본적인 가이드</strong></h5><br>모임 개설의 경우 구독권을 구매해야 개설 할 수 있으며 한달권 단위로 구매가 가능합니다. <br>
        구독을 하게 될 경우 가입가능한 모임이 늘어나게되며 기본1개에서 3개로 변경되게 됩니다. <br>
        구독개월수가 늘어날 경우 할인요금이 설정되며 1개월은 기본요금, 6개월은 30%할인, 1년은 40% 할인이 됩니다.
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
        자주하는 질문 2
      </button>
    </h2>
    <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <h5><strong>정모가 무엇인가요?</strong></h5><br>
        정모란 운영중인 모임에서 모임장이 내부에서 추가적인 모임을 만들게 되는데 <br>
        해당 모임이 "정모"이며 온라인 상에서 만나는 유저들과 오프라인에서 만날수 있는 모임을 뜻합니다.
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
        자주하는 질문 3
      </button>
    </h2>
    <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <h5><strong>모임장이 나가면 모임은 어떻게 되나요?</strong></h5><br>
        모임장이 모임을 나가게 되면 해당 모임은 운영 종료가 됩니다.
      </div>
    </div>
  </div>
    <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
        자주하는 질문 4
      </button>
    </h2>
    <div id="collapseFour" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <h5><strong>모임장이 나가면 모임은 어떻게 되나요?</strong></h5><br>
        정보통신망에서 불법촬영물등을 유통할 경우 전기통신사업법 시행령 제22조의 5제 1항에 따른 <br>
        삭제 , 접속차단 등 유통방지에 필요한 조치가 취해지며 성폭력처벌법 제 14조 청소년성처벌법 <br>
        제11조에 따라 형사처벌을 받을 수 있습니다.
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
        자주하는 질문 5
      </button>
    </h2>
    <div id="collapseFive" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <h5><strong>모임의 정보는 어떻게 수정할 수 있나요?</strong></h5><br>
        모임운영자만 수정을 할 수 있으며 "내모임리스트"에서 오른쪽에 수정버튼이 존재하는데 <br>
        해당 버튼을 클릭하여 수정화면으로 이동합니다.
      </div>
    </div>
  </div>
</div>
	 <c:if test="${not empty member}"> 
		<div class="mb-3 col-6"></div>
		<div class="col-auto d-flex justify-content-end mb-3">
			<a href="./add" class="btn btn-outline-dark">문의하기</a>
		</div>
	 </c:if> 
</div>
</div>
	


	<!-- ========================= JS improt ========================= -->
	<c:import url="../temps/footer.jsp"></c:import>

</body>
</html>
