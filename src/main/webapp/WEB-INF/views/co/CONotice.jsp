<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>



<head>
<meta charset="UTF-8">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Atelier | Service</title>


<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">
<!-- Css Styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main/css/themify-icons.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main/css/nice-select.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main/css/style.css"
	type="text/css">
<link
	href="${pageContext.request.contextPath}/resources/main/css/CONtice.css"
	rel="stylesheet">
</head>

<style>
body {
	padding-top: 20px;
}

nav>.nav.nav-tabs {
	border: none;
	color: #fff;
	background: #272e38;
	border-radius: 0;
}

nav>div a.nav-item.nav-link, nav>div a.nav-item.nav-link.active {
	border: none;
	padding: 18px 25px;
	color: #fff;
	background: #272e38;
	border-radius: 0;
}

.tab-content {
	background: #fdfdfd;
	line-height: 25px;
	border: 1px solid #ddd;
	border-top: 5px solid #e74c3c;
	border-bottom: 5px solid #e74c3c;
	padding: 30px 25px;
}

nav>div a.nav-item.nav-link:hover, nav>div a.nav-item.nav-link:focus {
	border: none;
	background: #e74c3c;
	color: #fff;
	border-radius: 0;
	transition: background 0.20s linear;
}

.red {
	color: red;
}

</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12 " style="margin-bottom: 100px;">
				<nav>
					<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
						<a class="nav-item nav-link active" id="nav-home-tab"
							data-toggle="tab" href="#nav-home" role="tab"
							aria-controls="nav-home" aria-selected="true">????????????
						</a>					
						<a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
							href="#nav-profile" role="tab" aria-controls="nav-profile"
							aria-selected="false">??????
						</a>							
						<a class="nav-item nav-link" id="nav-FAQ-tab" data-toggle="tab"
							href="#nav-FAQ" role="tab" aria-controls="nav-FAQ"
							aria-selected="false">FAQ
						</a>
						<a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab"
							href="#nav-contact" role="tab" aria-controls="nav-contact"
							aria-selected="false">Contact Us
						</a>
						<a class="nav-item nav-link" id="nav-about-tab" data-toggle="tab"
							href="#nav-about" role="tab" aria-controls="nav-about"
							aria-selected="false">????????? ??????
						</a>
					</div>
				</nav>

				<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
					<!-- ???????????? -->
					<div class="tab-pane fade show active" id="nav-home"
						role="tabpanel" aria-labelledby="nav-home-tab">
						<br>
						<div class="table-responsive">
							<table class="align-middle table table-borderless table-striped table-hover">
								<thead>
									<tr>
										<!-- <th>??????</th> -->
										<th class="text-center" style="width: 160px;">????????????</th>
										<th class="text-center" style="width: 450px;">??????</th>
										<th class="text-center">?????????</th>
										<th class="text-center">?????????</th>
										<th class="text-center">????????????</th>
									</tr>
								</thead>
								<tbody id="nList" name="nList">
									<c:forEach var="bnotice" items="${noticeList}">
										<tr>
											<td class="text-center text-muted">${bnotice.nt_num}</td>
												<td>
												<div class="widget-content p-0" style="text-align: center;">
													<div class="widget-content-wrapper">
														<div class="widget-content-left flex2">
															<div class="widget-heading">${bnotice.nt_title}</div>
														</div>
													</div>
												</div>
											</td>
											<td class="text-center">${bnotice.nt_id}</td>
											<td class="text-center">${bnotice.nt_count}</td>
											<td class="text-center">
												<a href="CONoticeContents?Noticenum=${bnotice.nt_num}"
													onclick="window.open(this.href, '_blank', 'width=700px,height=600px,toolbars=no,scrollbars=yes');return false;">
													<button type="button" id="PopoverCustomT-1"
														class="btn btn-primary btn-sm"
														style="background-color:#e74c3c; border-color:#e74c3c;">
														????????????
													</button>
												</a>
											</td>
										</tr>
									</c:forEach>								
								</tbody>
							</table>
							<p style="text-align:center; margin-top: 30px;">${paging}</p>
						</div>
					</div>

					<!-- ?????? -->
					<div class="tab-pane fade" id="nav-profile" role="tabpanel"
						aria-labelledby="nav-profile-tab"><br>
						<textarea class="col-md-12" style="resize: none; height: 650px;">
Google??? ?????? ?????? ???????????????.

Google ?????? ??? ?????????(???????????????)??? ????????? ????????? ???????????????. ???????????? 1600 Amphitheatre Parkway, Mountain View, CA 94043, United States??? ????????? Google LLC(???Google???)?????? ???????????????.

???????????? ?????????????????? ????????? ??? ????????? ???????????? ????????? ??? ????????? ?????? ?????? ??????????????? ????????????.

Google ???????????? ?????? ??????????????? ?????? ???????????? ?????? ?????? ????????????(?????? ?????? ??????)??? ????????? ??? ????????????. ??????????????? ?????? ???????????? ????????? ????????????, ????????? ?????? ???????????? ???????????? ?????? ??? ??????????????? ????????? Google ??? ????????? ????????? ?????????.

Google ????????? ??????
????????? ????????? ????????? ???????????? ?????? ????????? ???????????? ?????????.

Google ???????????? ????????? ???????????? ????????????. ?????? ?????? ???????????? ??????????????? Google??? ???????????? ??????????????? ??? ???????????? ????????? ?????? ????????? ???????????? ???????????? ???????????? ????????? ?????????. ????????? ?????? ?????? ??? ????????? ?????? ?????? ??? ?????? ??? ?????? ????????? ???????????? ??????????????? Google ???????????? ????????? ??? ????????????. ????????? Google ???????????? ????????? ???????????? ????????? Google??? ???????????? ????????? ???????????? ?????? ??????, Google ????????? ????????? ?????? ?????? ?????? ????????? ??? ????????????.

Google ???????????? ??????????????? ?????? Google ????????? ?????? ??????????????? ???????????? ?????????????????? ???????????? ?????? ?????? ????????????. ????????? ?????????????????? ????????? ????????? ?????? ????????? ?????? ???????????? ????????? ????????????, Google ???????????? ???????????? ????????? ??? ????????????. ??? ????????? ???????????? Google ???????????? ????????? ???????????? ????????? ????????? ????????? ???????????? ????????????. Google ???????????? ?????? Google ???????????? ?????? ????????? ????????? ?????? ????????? ??????????????? ???????????? ???????????? ????????????.

Google ???????????? Google??? ???????????? ?????? ?????? ???????????? ????????? ??? ????????????. ???????????? ???????????? ????????? ?????? ???????????? ??? ??????, ?????? ?????? ??? ????????? ??????????????? ?????? ??????, ????????? ???????????? ???????????? ????????? ?????? Google??? ???????????? ????????? ????????????, ????????? ????????? ???????????? ???????????? ?????????. ???????????? ???????????????(?????? ??????, ????????? ?????? ?????? ??????????????? ???????????? ?????????), ????????? ????????? ???????????????(?????? ??????, ????????????), ?????? ??? ???????????? ?????? ????????? ???????????? ??????????????? ?????? ??????????????? ????????? ????????? ???????????????(?????? ??????, ??????, ????????? ?????? ???????????? ??????) ??????????????? ???????????? ??????, Google??? ????????? ???????????? ?????? ?????? ????????? ??????????????? ????????? ??? ????????????. ???????????? ????????? ???????????? ??????????????? ????????? ????????????, ???????????? ????????? ???????????? ???????????? ????????????. Google??? ????????? ?????? ????????? ???????????????, ?????? ?????????, ???3???, Google ??? ??? ???????????? ????????? ????????? ??? ????????? ??????????????? ???????????? ??????(?????? ??????, ???????????? ?????? ?????? ?????? ??????????????? ????????? ???????????? ??????, ????????? ???????????? ??????, ??? ???????????? ????????? ????????? ?????? ???)??? ????????????, ???????????? ?????? ????????? ????????? ????????? ????????????.

????????? ????????? ???????????? Google??? ???????????? ????????? ??????, ?????? ????????? ??? ?????? ????????? ????????? ??? ????????????. ????????? ????????? ????????? ????????? ??? ????????????.

?????? Google ???????????? ?????????????????? ????????? ??? ????????????. ????????? ?????? ?????? ?????? ?????? ????????? ??????????????? ?????? ???????????? ???????????? ??????????????? ??? ?????????.

????????? Google ??????
????????? Google ???????????? ???????????? ???????????? Google ????????? ????????? ??? ????????????. ????????? Google ????????? ?????? ?????? ?????? ??????, ????????? ?????? ??????????????? ?????? ???????????? ???????????? Google ????????? ????????? ?????? ????????????. ???????????? ????????? Google ????????? ???????????? ?????? ??????, ????????? ?????? ?????? ??????????????? ????????? ??? ????????? ???????????? ????????? ????????? ?????????????????? ????????? ????????? ??? ????????????.

Google ????????? ??????????????? ??????????????? ???????????? ??????????????????. ????????? Google ???????????? ?????? Google ????????? ?????? ??????????????? ????????? ?????? ????????? ????????????. ?????? ???????????????????????? Google ?????? ??????????????? ??????????????? ????????????. ????????? ??????????????? Google ????????? ???????????? ???????????? ????????? ?????? ?????? ?????? ?????? ???????????? ??????????????? ????????????.

???????????? ?????? ??? ????????? ??????
Google ??????????????????????????? ????????? Google ???????????? ????????? ??? Google??? ??????????????? ????????? ???????????? ?????????????????? ?????? ???????????????.

Google??? ?????? ????????? ???????????? ????????????(US Digital Millennium Copyright Act)??? ????????? ????????? ?????? ?????????????????? ???????????? ????????? ????????????, ?????? ???????????? ????????? ???????????????.

Google??? ??????????????? ?????????????????? ????????? ?????? ????????? ????????? ??? ????????? ????????? ???????????????. ????????? ????????? ???????????? ???????????? ????????? ???????????? Google??? ??????????????? ?????? ??????, Google ????????? ???????????? ????????? ?????? ?????? ??? ????????? ?????? ????????? ?????? Google ?????? ?????? ?????? ????????? ???????????? ??? ????????????.

Google ???????????? ????????? ????????? ?????????
????????? ?????? Google ??????????????? ???????????? ?????????, ??????, ??????, ??????, ????????? ??? ????????? ?????? ?????? ????????? ????????? ?????????????????? ????????? ???????????????. ???, ????????? ????????? ????????? ???????????? ???????????????.

????????? ???????????? Google ???????????? ?????? ?????? ?????? ?????????, ??????, ??????, ?????? ?????? ???????????? ?????? ????????? Google(??? Google??? ?????????)??? ????????? ???????????? ??????, ??????, ??????, ??????, ????????? ?????????(????????? ???????????? Google ???????????? ??? ??? ??????????????? Google??? ???????????? ?????????, ?????????, ?????? ??????????????? ?????? ???????????? ???) ??????, ??????, ??????, ??????????????? ??????, ??????????????? ?????? ??? ????????? ??? ?????? ??? ???????????? ??????????????? ???????????? ?????????. ??? ?????????????????? ????????? ???????????? ????????? Google ???????????? ??????, ?????? ??? ???????????? ????????? ???????????? ???????????? ?????? ???????????? ???????????? ???????????????. ??????, ????????? ??? ???????????? ????????? ???????????? ?????? Google??? ?????? ????????? ???????????? ?????? ?????? ????????? ????????????. ????????? ????????? ???????????? ?????? ????????? ??? ?????? ?????? ??? ????????? ?????? ??? ??????????????? ????????????. Google ????????? ????????? ?????? ????????? ?????? ???????????? ?????? ???????????? ????????? ????????? ???????????? ??????????????? ???????????? ????????? ????????????. ????????? ?????? ?????????????????? ????????? ?????? ????????? ???????????? ??????????????? ?????? ???????????? ????????? ????????? ??? ????????????. ????????? Google ???????????? ????????? ???????????? ?????? Google??? ??????????????? ???????????? ?????? ????????? ????????? ???????????? ?????????.

Google??? ????????? ???????????? ???????????? ???????????? ???????????? ???????????? ?????? ????????????, ?????? ?????? ??????, ???????????? ????????? ?????? ????????? ?????? ??? ?????? ?????? ?????? ???????????????. ?????? ????????? ???????????? ???????????? ??????, ?????????, ?????? ????????? ??? ???????????? ????????? ???????????????. ????????? ????????? ?????? ?????????????????? ?????? ??????????????? ???????????? ????????????.

????????? Google ????????? ???????????? ?????? Google ???????????? ??????????????? ???Play????????? ?????? ???????????? ?????? ??????????????? ?????? ????????? ????????? ????????? ????????? ?????? ?????? ???????????????. Google??? ???????????? ?????? ?????? ????????? ?????? ??? ????????? ????????? ????????? ?????? ????????????.

Google??? ???????????? ?????? ??? ???????????? ????????? ?????? ??? ??? ????????? ????????? ????????? ??????, Google ???????????????????????? ?????? ?????? ???????????? ?????? ??????????????? ??????????????? ????????????. ????????? Google ???????????? ?????? ???????????? ????????? ???????????? ?????? Google??? ????????? ?????? ?????? ?????? ????????? ???????????? ????????? ????????? ??? ????????????.

Google ???????????? ????????? ?????????????????? ?????????
???????????? ???????????? ????????? ?????????????????? ??????????????? ???????????? ??????, ?????????????????? ?????? ????????? ???????????? ????????? ???????????? ?????? ???????????? ?????????????????? ???????????? ??????????????? ??? ????????????. ?????? ?????????????????? ?????? ???????????? ????????? ???????????? ?????? ????????? ?????? ????????????.

Google??? ???????????? ???????????? ????????? ???????????? ?????????????????? ????????? ??? ????????? ??????????????? ??? ??????????????? ????????????????????? ??????????????? ?????? ??????????????? ???????????????. ??? ??????????????? ??? ????????? ?????? ????????? Google??? ????????? ?????? ???????????? ???????????? ????????? ?????? ??? ????????? ?????? ?????? ??????????????? ???????????????. ????????? ????????? ?????? ?????? ????????? ??????????????? Google??? ??????????????? ?????? ????????? ????????????, Google ????????? ?????? ?????? ????????? ?????????????????? ????????? ??????, ??????, ??????, ?????? ?????? ????????? ??? ?????????, ?????????????????? ?????????????????? ?????? ????????? ????????? ????????? ??? ????????????.

Google?????? ?????? ?????? ?????????????????? ?????? ????????? ????????? ????????????. Google ??????????????? ???????????? ?????? ?????????????????? ???????????? ???????????? ?????? ?????? ??????????????? ?????? ????????? ??? ????????????. ?????? ?????? ?????????????????? ??????????????? ??? ????????? ?????? ????????? ???????????? ????????? ?????? ??? ????????????.

Google ???????????? ?????? ??? ??????
Google??? ???????????? ??????????????? ?????? ??? ???????????? ????????????. Google??? ????????? ?????? ?????? ????????? ??? ?????????, ???????????? ?????? ??????????????? ????????? ????????? ??? ????????????.

Google????????? ?????? ???????????? ????????????, ????????? ???????????? Google ????????? ????????? ????????? ??? ????????????. Google ?????? ????????? ????????? ??????????????? Google ???????????? ?????? ????????? ????????? ??????????????? ?????? ??? ????????????. ?????? ??????, Google??? ???????????? ????????? ????????????, ???????????? ????????? ????????? ??? ????????????. ??????, ????????? ???????????????, Google??? ????????? ?????? ???????????? ???????????? ????????? ???????????? ?????? ????????? ??? ??? ????????????.

????????? ???????????? ?????? ????????????, ????????? ???????????? ?????? ?????????????????? ?????? ?????? ?????? ??????????????? Google??? ?????? ????????????. Google??? ???????????? ???????????????, ????????? ????????? ????????? ????????? ????????? ????????? ????????? ????????? ???????????? ???????????? ????????? ?????? ????????? ???????????????. ??????, (i) ???????????? ?????? ??????????????? ???????????? ?????????(?????? ??????, ?????? ????????? ?????? ???????????? ???????????? ??????), (ii) ??????????????? ????????? ?????? ???????????? ????????? ????????? ???????????? ?????? ?????? (iii) ?????? ???????????? ??????????????? ????????? ?????? ????????? ??? ????????????.

?????? ????????? ?????? ????????? ????????????????????? ??? ???????????? ????????? ?????? ?????? ????????? ?????? ????????? ??????????????? ????????????.

Google??? ?????? ??? ??????
Google??? ??????????????? ???????????? ????????? ????????? ???????????? ????????? ????????? ???????????? ????????????, ????????? ???????????? ????????? ?????? ????????????. ???, ???????????? ????????? ????????? ??? ?????? ??? ?????? ????????? ????????????.

??? ?????? ?????? ??????????????? ???????????? ?????? ??? Google, ?????? Google??? ???????????? ???????????? ???????????? ???????????? ????????? ???????????? ????????? ?????? ????????????. ?????? ??????, Google??? ???????????? ?????? ?????????, ???????????? ?????? ??????, ???????????? ?????????, ??????????????? ?????? ????????? ????????? ????????? ????????? ????????? ????????? ????????? ?????? ????????????. Google??? ???????????? ????????? ???????????? ???????????????.

?????? ??????????????? ???????????? ?????????, ?????????????????? ????????? ??? ??????????????? ?????? ????????? ????????? ?????? ?????? ????????? ???????????????. Google??? ????????? ???????????? ?????? ????????? ?????? ????????? ???????????????.

Google ???????????? ?????? ??????
????????? ???????????? ??????, Google, Google??? ????????? ??? ???????????? ????????????, ????????????, ????????????, ????????? ??????, ?????? ??????, ?????? ??????, ????????? ??????, ????????? ??????, ?????? ????????? ????????? ?????? ???????????? ????????????.

????????? ???????????? ?????? ?????????, ????????? ????????? ???????????? ??? ????????? ?????? ????????? ?????? Google, Google??? ????????? ??? ???????????? ??? ????????? ????????? ????????? ????????? ?????? Google??? ????????? ??????(?????? Google??? ????????? ?????? ???????????? ???????????? ?????? ???????????? ???)?????? ???????????????.

?????? ???????????? Google, Google??? ????????? ??? ???????????? ??????????????? ?????? ???????????? ???????????? ????????? ?????? ???????????? ????????????.

?????? ??????????????? ???????????? ?????????????????? ?????? ????????? ??????????????? ?????? Google??? ?????? ????????????. ???????????? ???????????? ???????????? ?????? ?????? ???????????? ??? ???????????? ??????????????? ?????? ????????? ????????? ?????? ????????? ??? ?????? ?????? ????????? ????????? ????????? ??? ????????????.

????????? Google ????????? ??????
????????? ???????????? Google ???????????? ???????????? ?????? ?????? ????????? ???????????????. ????????? ?????? ?????? ?????? ?????? ???????????? ?????? ??????????????? ?????? ????????? ?????? ??????, ?????? ?????? ??????????????? Google??? Google??? ?????????, ??????, ????????? ??? ????????? ???????????? ???????????? ?????? ???????????? ?????? ????????? ??????, ??????, ??????, ??????, ??????, ?????? ?????? ??? ????????? ????????? ????????? ?????? ????????? ???????????????.

??? ????????? ?????????
Google??? ???????????? ??????????????? ??????????????? ??????, ??????, ?????? ?????? ????????? ??? ???????????? ???????????? ???????????? ??????????????? ????????? ??? ????????????. Google??? ????????? ????????? ????????? ????????? ?????? ????????? ????????? ????????????. ?????? ????????? ????????? ?????? ??? 30??? ????????? ???????????????. ???, ??????????????? ????????? ?????? ???????????? ????????? ?????? ?????? ????????? ????????? ???????????? ???????????? ????????? ?????? ????????? ?????? ????????? ??? ????????????. ???????????? ?????? ????????? ????????? ???????????? ?????? ?????? ?????? ???????????? ????????? ???????????? ?????????.

??? ????????? ??????????????? ???????????? ??????, ???????????? ????????? ????????? ??????????????? ???????????????.

??? ????????? Google??? ???????????? ????????? ????????????, ????????? ???3?????? ???????????? ??????????????? ????????????.

????????? ??? ????????? ???????????? ?????? ??????, ????????? ?????? ????????? ????????? ???????????? ?????? ????????? ????????? ?????? ??????(?????? ????????? ????????? ??? ???)??? ???????????? ???????????? ????????????.

?????? ????????? ?????? ???????????? ????????? ???????????? ??????, ?????? ?????? ????????? ????????? ????????? ????????????.

?????? ????????? ??????????????? ?????? ?????? ????????? ??????????????? ????????? ???????????? ????????????. ??????????????? ????????? ????????? ????????? ????????? ???????????? ?????? ??????, ?????? ????????? ????????? ??? ????????? ????????? ????????? ????????? ??? ????????????. ????????? ?????? ??????, ????????? ??? ?????? ?????? ???????????? ???????????? ???????????? ????????? ?????? ?????? ?????????????????? ????????? ????????????, ?????????????????? ??????????????? ????????? ??????????????? ?????? ???????????????. ???????????????, ?????? ????????? ???????????? ?????? ?????????????????? ??????????????? ????????? ????????? ?????? ???????????? ???????????? ????????? ???????????? ?????? ???????????? ??? ????????? ????????? ????????? ?????? ?????? ???????????? ???????????? ????????? ??? ????????????. ????????? ?????? ??????, ??? ?????? ?????? ???????????? ???????????? ???????????? ?????? ????????? ??????????????? ?????? ?????????????????? ??????????????? ???????????? ?????? ?????? ??? ???????????? ??????????????? ????????? Google??? ????????? ????????? ?????? ????????? ?????? ?????? ???????????????.

Google??? ???????????? ????????? ????????? ?????? ???????????? ??????????????? ????????????.
               			</textarea>
					</div>					

					<!-- FAQ -->	
						<div class="tab-pane fade" id="nav-FAQ" role="tabpanel"
							aria-labelledby="nav-FAQ-tab" align="center">
							<form id="CONoticeFAQFrm" name="CONoticeFAQFrm">
								<div class="row">
									<div class="col-md-12" style="padding-top: 1.5rem;">
										<div id="accordion" class="accordion-wrapper mb-12">
											<div class="table-responsive">
												<table class="align-middle table table-borderless table-striped table-hover">
													<thead>
														<tr>
															<th class="text-center" style="width: 160px;">????????????</th>
															<th class="text-center" style="width: 450px;">??????</th>
															<th class="text-center">?????????</th>
															<th class="text-center">?????????</th>
															<th class="text-center">????????????</th>
														</tr>
													</thead>
													<tbody id="faqList" name="faqList">
														<c:forEach var="FAQ" items="${faqListBoard}">
															<tr>
																<td class="text-center text-muted">${FAQ.ft_num}</td>
																	<td>
																	<div class="widget-content p-0" style="text-align: center;">
																		<div class="widget-content-wrapper">
																			<div class="widget-content-left flex2">
																				<div class="widget-heading">${FAQ.ft_title}</div>
																			</div>
																		</div>
																	</div>
																</td>
																<td class="text-center">${FAQ.ft_id}</td>
																<td class="text-center">${FAQ.ft_date}</td>
																<td class="text-center">
																	<a href="COFAQContents?ft_num=${FAQ.ft_num}"
																		onclick="window.open(this.href, '_blank', 'width=800px,height=600px,toolbars=no,scrollbars=yes');return false;">
																		<button type="button" id="PopoverCustomT-1"
																			class="btn btn-primary btn-sm"
																			style="background-color:#e74c3c; border-color:#e74c3c;">
																			????????????
																		</button>
																	</a>
																</td>
															</tr>
														</c:forEach>								
													</tbody>
												</table>
												<p style="text-align:center; margin-top: 30px;">${FAQpaging}</p>
											</div>	
										</div>
									</div>
								</div>
							</form>
						</div>

					<!-- Contact Us -->
					<div  class="tab-pane fade" id="nav-contact" role="tabpanel"
						aria-labelledby="nav-contact-tab">

						<!-- Map Section Begin -->
							<!-- ????????? ????????? div ????????? -->
						<div id="map" style="width:100%;height:800px; display: block; "></div>

						<script>
							// Initialize and add the map

							function initMap() {
								// The location of Uluru
								var uluru = {
									lat : 37.438767,
									lng : 126.675085
								};
								// The map, centered at Uluru
								var map = new google.maps.Map(
								document.getElementById('map'), {
									zoom : 17,
									center : uluru
								});
								// The marker, positioned at Uluru
								var marker = new google.maps.Marker({
									position : uluru,
									map : map,
									info: '????????? ?????? ????????? ??????',
									title: 'Atelier'
								});
								
								var content = "<h5><b>Atelier Building</b></h5><p>??????????????? ???????????? ????????? 663-1 Atelier ??????";
								
								var infowindow = new google.maps.InfoWindow({content: content});
								
								google.maps.event.addListener(marker, "click", function() {
						            infowindow.open(map,marker);
								});

							}
						</script>
						<script async defer
							src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAc_ZbCtkK4m_JITKv4tiuyM3XcKcgiAYo&callback=initMap">
						</script>

						<!-- Map Section Begin -->

						<!-- Contact Section Begin -->
						<section class="contact-section spad">
							<div class="container">
								<div class="row">
									<div class="col-lg-5" style="margin-left: 100px;">
										<div class="contact-title">
											<h4>Contacts Us</h4>
											<p>Atelier?????? ????????? ????????? ??????????????????!</p>
										</div>
										<div class="contact-widget">
											<div class="cw-item">
												<div class="ci-icon">
													<i class="ti-location-pin"></i>
												</div>
												<div class="ci-text">
													<span>Address:</span>
													<p>??????????????? ???????????? Atelier ??????</p>
												</div>
											</div>
											<div class="cw-item">
												<div class="ci-icon">
													<i class="ti-mobile"></i>
												</div>
												<div class="ci-text">
													<span>Phone:</span>
													<p>+81 10.5453.1234</p>
												</div>
											</div>
											<div class="cw-item">
												<div class="ci-icon">
													<i class="ti-email"></i>
												</div>
												<div class="ci-text">
													<span>Email:</span>
													<p>AtelierAdmin@Atelier.com</p>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-4 offset-lg-1" style="margin-left: 80px;">
										<div class="contact-form">
											<div class="leave-comment">
												<h4>Sign In</h4>
												<p>Atelier??? ????????? ?????? ????????? ????????? ?????? ?????????!</p>
												<form action="#" class="comment-form">
													<div class="row">
														<div class="col-lg-6">														
															<button type="button" class="site-btn" onclick="location.href='memJoinFrm'">Sign In</button>
														</div>
													</div>
														<br>
														<br>
														<h4>Log In</h4>
														<p>?????? Atelier??? ??????????????????, ????????? ??? ??????????????? ??????????????? ???????????????!</p>
														<div class="row">
														<div class="col-lg-12">
															<button type="button" class="site-btn" onclick="location.href='login'">Log In</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</section>

					</div>


					<!-- message -->
					<div class="tab-pane fade" id="nav-about" role="tabpanel"
						aria-labelledby="nav-about-tab" align="center">
						<div class="container">
							<div class="row">
								<div class="col-md-12 col-md-offset-3">
									<div class="well well-sm">
										
											<fieldset>

												<!-- Message body -->
										<form class="form-horizontal" action="ADsendMessage" method="post" name="sendingForm">
												<div class="form-group">
													<label class="col-md-6 control-label" for="message" align="left">Your message</label>
													
													<input type="hidden" name="mg_receiver" value="admin@gmail.com">
													<input type="hidden" name="mg_sender" id="sender" value="${mb.cm_id}">													
													<div class="col-md-6">
														<textarea class="form-control" id="message" name="mg_contents" placeholder="Please enter your message here..." rows="7"></textarea>
													</div>
												</div>

												<!-- Form actions -->
												<div class="form-group">
													<div class="col-md-12 text-right">
														<input type="button" class="btn btn-primary btn-lg" onclick="adSendMessage()" value="Submit">
													</div>
												</div>
										</form>
											</fieldset>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- Js Plugins -->
	<script src="<c:url value="/resources/main/js/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/resources/main/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/main/js/jquery-ui.min.js"/>"></script>
	<script
		src="<c:url value="/resources/main/js/jquery.countdown.min.js"/>"></script>
	<script
		src="<c:url value="/resources/main/js/jquery.nice-select.min.js"/>"></script>
	<script src="<c:url value="/resources/main/js/jquery.zoom.min.js"/>"></script>
	<script src="<c:url value="/resources/main/js/jquery.dd.min.js"/>"></script>
	<script src="<c:url value="/resources/main/js/jquery.slicknav.js"/>"></script>
	<script src="<c:url value="/resources/main/js/owl.carousel.min.js"/>"></script>
	<script src="<c:url value="/resources/main/js/main.js"/>"></script>

	<script type="text/javascript" src="./resources/main/js/main.js"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   	<script src="../resources/js/jquery.serializeObject.js"></script>
	<script type="text/javascript">

		$(".nav-item").click(function() {
			var activeTab = $(this).attr('href');
			console.log(activeTab);
			//var CONoticeFAQFrm = $("#CONoticeFAQFrm").serializeObject();
			//console.log(CONoticeFAQFrm);
			
			$.ajax({
				url: "CONotice",
				type: "get",
				data: CONoticeFAQFrm,
				dataType: "json",
				success: function(data) {				
					var faqListBoard = '';
					for(var i = 0; i < data.faqListBoard.length; i++) {
						console.log(data.faqListBoard[i].FAQpaging);
						console.log(data.faqListBoard);
						faqListBoard += '<div class="table-responsive">'
						+ '<table class="align-middle table table-borderless table-striped table-hover">'
						+ '<thead>'
						+ '<tr>'
						+ '<th class="text-center" style="width: 160px;">' + '????????????' + '</th>'
						+ '<th class="text-center" style="width: 450px;">' + '??????' + '</th>'
						+ '<th class="text-center">?????????</th>'
						+ '<th class="text-center">?????????</th>'
						+ '<th class="text-center">????????????</th>'
						+ '</tr>'
						+ '</thead>'
						+ '<tbody id="faqList" name="faqList">'
						+ '<c:forEach var="FAQ" items="${faqListBoard}">'
						+ '<tr>'
						+'<td class="text-center text-muted">'
						+ data.faqListBoard[i].ft_num
						+'</td>'
						+'<td>'
						+'<div class="widget-content p-0" style="text-align: center;">'
						+'<div class="widget-content-wrapper">'
						+'<div class="widget-content-left flex2">'
						+'<div class="widget-heading">'
						+ data.faqListBoard[i].ft_title
						+'</div>'
						+'</div>'
						+'</div>'
						+'</div>'
						+'</td>'
						+'<td class="text-center">'
						+ data.faqListBoard[i].ft_id
						+'</td>'
						+'<td class="text-center">'
						+ data.faqListBoard[i].ft_date
						+'</td>'
						+'<td class="text-center">'
						+'<a href="CONoticeContents?Noticenum=${FAQ.ft_num}" onclick="window.open(this.href, "_blank", "width=800px,height=600px,toolbars=no,scrollbars=yes");return false;">'
						+'<button type="button" id="PopoverCustomT-1" class="btn btn-primary btn-sm" style="background-color:#e74c3c; border-color:#e74c3c;">'
						+'????????????'+'</button>'
						+'</a>'
						+'</td>'
						+'</tr>'
						+ '</tr>'
						+ '</c:forEach>'								
						+ '</tbody>'
						+ '</table>'
						+ '<p style="text-align:center">' + data.faqListBoard[i].FAQpaging + '</p>'
						+ '</div>'
					}
					$('#faqList').html(faqListBoard);
				},
				error: function(error) {
					alert("?????? ??????");
				}
			});
		}) 

		
		/* ---------------------------------------------------------------------------------------
		 * ???   ???: FAQ ????????? ???, ??? ??????
		 * ?????????: 2020.02.20
		 * ?????????: JWJ / KYH 
		 -----------------------------------------------------------------------------------------*/	
		$(document).ready(function(){
			var tabCheck = "${check}";
			console.log("?????? ???????????? ????????? : " +tabCheck);
			if(tabCheck === "FAQ?????????"){
				$("#nav-FAQ-tab").get(0).click();
				$(this).addClass("class_name");

				$(this).removeClass("class_name");


			}else {
				$("#nav-tab").get(0).click();
			}
		 });



	</script>
	<script type="text/javascript">
	/* ---------------------------------------------------------------------------------
	 * ??????: ????????? ?????? ????????? ??????
	 * ?????????: JSH
	 * ????????? : 2019.02.19
	  -----------------------------------------------------------------------------------*/
		function adSendMessage(){
			/* var sendingForm = document.sendingForm;
			var mgContents = sendingForm.mgContents.value;
			var mgSender = sendingForm.mgSender.value; */
			
			var mgContents = document.getElementById("message").value;
			var mgSender = document.getElementById("sender").value;
			/* console.log(mgContents);
			console.log(mgSender); */
			console.log("????????? ????????? : " + mgContents);
			console.log("???????????? ?????????: "+ mgSender);
			
		
			if(mgSender == '' || mgSender == null){
				alert("????????? ???, ???????????? ??????????????????.")
				} else if(mgContents == '' || mgContents == null){
					alert("????????? ????????? ??????????????????.")
				} else{
					sendingForm.submit();
					alert("??????????????? ???????????? ?????????????????????.")
					window.close();
				} 
			
			}
			
		</script>
</body>


</html>

