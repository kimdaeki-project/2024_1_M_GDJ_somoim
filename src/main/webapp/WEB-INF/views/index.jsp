<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Somoim</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- CSS 임포트 -->
<c:import url="./temps/head_css.jsp"></c:import>
</head>

<body>
	<!--[if lte IE 9]>
      <p class="browserupgrade">
        You are using an <strong>outdated</strong> browser. Please
        <a href="https://browsehappy.com/">upgrade your browser</a> to improve
        your experience and security.
      </p>
    <![endif]-->
		<!-- 내비게이터 import -->
		<c:import url="./temps/header.jsp"></c:import>
	<section class="hero-area overlay">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 offset-lg-1 col-md-12 col-12">
					<div class="hero-text text-center">
						<!-- Start Hero Text -->
						<div class="section-heading">
							<h2 class="wow fadeInUp" data-wow-delay=".3s">소모임 서비스에 오신걸
								환영 합니다!</h2>
							<p class="wow fadeInUp" data-wow-delay=".5s">우리동네 친구만들기! <br>혼자 외롭게 떨어져 지내는 타지 생활에 힘이 되는 친구를 만들어 보세요!</p>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Start Categories Area -->
	<section class="categories">
		<div class="container">
			<div class="cat-inner">
				<div class="row">
					<div class="col-12 p-0">
						<div class="category-slider">
							<!-- Start Single Category -->
							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/car.svg" alt="#">
								</div>
								<h3>문화/공연/음악</h3>
								<h5 class="total">
									${category['문화/공연/음악'] == null ? 0 : category['문화/공연/음악']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
<!-- 							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/laptop.svg"
										alt="#">
								</div>
								<h3>전체</h3>
								<h5 class="total">22</h5>
							</a> -->
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/matrimony.svg"
										alt="#">
								</div>
								<h3>사교/인맥</h3>
								<h5 class="total">
									${category['사교/인맥'] == null ? 0 : category['사교/인맥']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/furniture.svg"
										alt="#">
								</div>
								<h3>공예/만들기</h3>
								<h5 class="total">
									${category['공예/만들기'] == null ? 0 : category['공예/만들기']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/jobs.svg" alt="#">
								</div>
								<h3>업종/직무</h3>
								<h5 class="total">
									${category['업종/직무'] == null ? 0 : category['업종/직무']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/real-estate.svg"
										alt="#">
								</div>
								<h3>자유주제</h3>
								<h5 class="total">
									${category['자유주제'] == null ? 0 : category['자유주제']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/laptop.svg"
										alt="#">
								</div>
								<h3>외국/언어</h3>
								<h5 class="total">
									${category['외국/언어'] == null ? 0 : category['외국/언어']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/hospital.svg"
										alt="#">
								</div>
								<h3>봉사활동</h3>
								<h5 class="total">
									${category['봉사활동'] == null ? 0 : category['봉사활동']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/tshirt.svg"
										alt="#">
								</div>
								<h3>운동/스포츠</h3>
								<h5 class="total">
									${category['운동/스포츠'] == null ? 0 : category['운동/스포츠']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category/main" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/education.svg"
										alt="#">
								</div>
								<h3>인문학</h3>
								<h5 class="total">
									${category['인문학'] == null ? 0 : category['인문학']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category.html" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/controller.svg"
										alt="#">
								</div>
								<h3>게임/오락</h3>
								<h5 class="total">
									${category['게임/오락'] == null ? 0 : category['게임/오락']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category.html" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/travel.svg"
										alt="#">
								</div>
								<h3>아웃도어/여행</h3>
								<h5 class="total">
									${category['아웃도어/여행'] == null ? 0 : category['아웃도어/여행']}
								</h5>
							</a>
							<!-- End Single Category -->
							<!-- Start Single Category -->
							<a href="category.html" class="single-cat">
								<div class="icon">
									<img src="/resources/assets/images/categories/watch.svg"
										alt="#">
								</div>
								<h3>요리/제조</h3>
								<h5 class="total">
									${category['요리/제조'] == null ? 0 : category['요리/제조']}
								</h5>
							</a>
							<!-- End Single Category -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /End Categories Area -->

	<!-- Start Items Grid Area -->
	<section class="items-grid section custom-padding">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-title">
						<h2 class="wow fadeInUp" data-wow-delay=".4s">추천 모임 리스트</h2>
						<p class="wow fadeInUp" data-wow-delay=".6s">
							활동인원이 많은 모임과 최근에 개설된 모임을 참고하여<br> 모임에 가입해 보세요
						</p>
					</div>
				</div>
			</div>
			<div class="single-head">
				<div class="row">
				<!-- List Start-->
					<div id="placeList" class="col-12 row">
					
					</div>
				<!-- List End  -->	
					</div>
				</div>
			</div>
	</section>

	<!-- ========================= scroll-top ========================= -->
	<a href="#" class="scroll-top btn-hover"> <i
		class="lni lni-chevron-up"></i>
	</a>

	<!-- ========================= JS improt ========================= -->
	<c:import url="./temps/footer.jsp"></c:import>
	<script src="/resources/js/admin/List.js"></script>
	<script type="text/javascript">
		//========= Category Slider 
		tns({
			container : '.category-slider',
			items : 3,
			slideBy : 'page',
			autoplay : false,
			mouseDrag : true,
			gutter : 0,
			nav : false,
			controls : true,
			controlsText : [ '<i class="lni lni-chevron-left"></i>',
					'<i class="lni lni-chevron-right"></i>' ],
			responsive : {
				0 : {
					items : 1,
				},
				540 : {
					items : 2,
				},
				768 : {
					items : 4,
				},
				992 : {
					items : 5,
				},
				1170 : {
					items : 6,
				}
			}
		});
	</script>
</body>

</html>
