<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dao.ShopboardDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ShopboardDAO dao = new ShopboardDAO();
	request.setAttribute("list", dao.selectFamousview());
%>
<html lang="utf-8">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<!-- Custom fonts for this theme -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Theme CSS -->
<link href="css/freelancer.min.css" rel="stylesheet">

<style type="text/css">
.uu {
	position: relative;
	width: 300px;
	height: 300px;
}

.uu img {
	position: absolute;
	left: 50%;
	top: 50%;
	height: 100%;
	width: auto;
	-webkit-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}

.uu .portrait {
	width: 100%;
	height: auto;
}

.uu .auto {
	height: auto;
}
</style>


<script>

function page_move(s_page, oriNoNo){
    var f = document.paging; //폼 name
    f.page.value = s_page; //POST방식으로 넘기고 싶은 값
    f.oriNo.value = oriNoNo;
    f.action="../shop/ShopboardDatail.ho"; //이동할 페이지
    f.method="post";//POST방식
    f.submit();
}
</script>
</head>

<!-- Masthead -->
<header class="masthead bg-primary text-white text-center">
	<div class="container d-flex align-items-center flex-column">

		<!-- Masthead Avatar Image -->
		<img class="masthead-avatar mb-5" src="../img/shop_1.png" alt="">

		<!-- Masthead Heading -->
		<h1 class="masthead-heading text-uppercase mb-0">평화나라 중고장터</h1>

		<!-- Icon Divider -->
		<div class="divider-custom divider-light">
			<div class="divider-custom-line"></div>
			<div class="divider-custom-icon">
				<i class="fas fa-star"></i>
			</div>
			<div class="divider-custom-line"></div>
		</div>

		<!-- Masthead Subheading -->
		<p class="masthead-subheading font-weight-light mb-0">우리 동네 중고 직거래
			마켓</p>

	</div>
</header>

<form name="paging">
<input type="hidden" value="" name ="page">
<input type="hidden" value="" name ="oriNo">
</form>

<!-- Portfolio Section -->
<section class="page-section portfolio" id="portfolio">
	<div class="container">

		<!-- Portfolio Section Heading -->
		<h2
			class="page-section-heading text-center text-uppercase text-secondary mb-0">평화나라
			인기매물</h2>

		<!-- Icon Divider -->
		<div class="divider-custom">
			<div class="divider-custom-line"></div>
			<div class="divider-custom-icon">
				<i class="fas fa-star"></i>
			</div>
			<div class="divider-custom-line"></div>
		</div>

		<!-- Portfolio Grid Items -->
		<div class="row">
			<!-- Portfolio Item 1 -->

			<div class="col-md-4 col-lg-3">
				<c:forEach var="temp" items="${list}" begin="0" end="0">
					<c:set var="oriNoNo" value="${temp.pb_no}" />
					<a class="portfolio-item mx-auto"
						href="javascript:page_move(1, ${ oriNoNo })">
						<div class="portfolio-item mx-auto">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="uu" src="${temp.pb_img}" alt="">
							<h4 class="card-title">${temp.pb_title}</h4>
							<div class="card-region-name"> ${temp.m_addsi}${temp.m_addgun}
								${temp.m_addetc}</div>
							<div class="card-price blank-price">${temp.pb_price}원</div>
							<div class="card-counts">
								<span> 관심 ${temp.lc_cnt} </span> ∙ <span>
									댓글${temp.pb_replycnt} </span> ∙ <span> 조회${temp.pb_hit} </span>
							</div>
						</div>
					</a>
				</c:forEach>
			</div>


				

		</div>
		<!-- /.row -->
	</div>
	</div>
</section>


<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
<div class="scroll-to-top d-lg-none position-fixed ">
	<a class="js-scroll-trigger d-block text-center text-white rounded"
		href="#page-top"> <i class="fa fa-chevron-up"></i>
	</a>
</div>



<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="js/jqBootstrapValidation.js"></script>
<script src="js/contact_me.js"></script>

<!-- Custom scripts for this template -->
<script src="js/freelancer.min.js"></script>

</body>

</html>
