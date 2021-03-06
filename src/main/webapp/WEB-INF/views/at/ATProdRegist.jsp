<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Atelier | Atelier</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />

  <!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="resources/AT_front/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="resources/AT_front/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="resources/AT_front/css/bootstrap.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="resources/AT_front/css/flexslider.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="resources/AT_front/css/style.css">
	
	<!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">
    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main/css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main/css/style.css" type="text/css">
	
	<!-- CkEditor -->
	<script type="text/javascript" src="resources/AT_front/ckeditor/ckeditor.js"></script>
	
	<style type="text/css">
		.title{
			width: 100px;
			height: 40px;
		
		}
	</style>
	
	</head>
	<body>
  <div id="colorlib-page">
		<div id="colorlib-main">
			<div class="colorlib-about">
				<div class="container-fluid" style="margin-left: 100px;">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3">
							<h2 class="colorlib-heading animate-box" data-animate-effect="fadeInLeft"
									style="font-weight: bolder; font-size: 23px; letter-spacing: 0.5px;">?????? ?????? ??????<hr>
							</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div id="preview" class="about-img animate-box" data-animate-effect="fadeInLeft"
								style="margin-left: 90px; background-image: url(resources/main/img/products/null.jpg);">
							</div>
						</div>
						<div class="col-md-6 animate-box" data-animate-effect="fadeInLeft" style="margin-top: 20px;">
							<div class="about-desc">
								<!-- ????????? ????????? ?????? class?????? ????????????, ?????? ??? ????????? ????????? ???  -->
							<form action="ATProdInsert" id="ATProdRegist" method="post" enctype="multipart/form-data">
								<table style="font-size: 15px; margin-top: 100px; margin-bottom: 140px;">
									<tr>
										<td class="title"><b>??? ??? ???</b></td>
										<td><input type="text" name="pd_name" class="content" placeholder="?????????" title="?????????" value="${modifyProdDto.pd_name}"></td>
									</tr>
									<tr>
                                        <td class="title"><b>??? ??? ???</b></td>
                                        <td><input type="text" name="pd_at_name" class="content" title="?????????" value='${myAt.at_name}' readonly="readonly"></td>
                                    </tr>
									<tr>
										<td class="title"><b>???&nbsp;&nbsp;???</b></td>
										<td><input name="pd_numofstock" class="content"
												type="number" min="0"
												style="border: none; width: 70px;" placeholder="??? ??? "title="??????" value='${modifyProdDto.pd_numofstock}'></td>
									</tr>
									<tr>
										<td class="title"><b>???&nbsp;&nbsp;???</b></td>
										<td><input type="number" class="content" name="pd_price"  min="0"
                                                style="border: none; width: 70px;" placeholder="??? ???"title="??????" value='${modifyProdDto.pd_price}'></td>
									</tr>
									<tr>
										<td class="title"><b>????????? ??????</b></td>
										<td><input type="file" id="image" class="content" name="pi_oriname" title="?????????" accept=".gif, .jpg, .png" ></td>
										    
									</tr>
									<tr>
										<td class="title"><b>???&nbsp;&nbsp;???</b></td>
										<td><input type="text" class="content" name="pd_option" placeholder="??? ???"title="??????" value='${modifyProdDto.pd_option}'></td>
									</tr>
									
									<tr>
										<td class="title"><b>???&nbsp;&nbsp;???</b></td>
										<td>
										<select id="sex_select" class="content" name="pd_sex" placeholder="??????" title="??????" >
													<option >?????????</option>
													<option>?????????</option>
													<option>????????????</option>
										</select></td>
									</tr>
									<tr>
										<td class="title"><b>?????? ??????</b></td>
										<td><select id="type_select" class="content" name="pd_type" placeholder="?????? ??????" title="?????? ??????" value='${modifyProdDto.pd_sex}'>
												<c:forEach var="rmDto" items="${rmList}">
													<option>${rmDto.rm_type}</option>
												</c:forEach>
										</select>
									</tr>
									<tr>
										<td class="title"><b>????????????</b></td>
										<td><select id="cate_select" class="content" name="pd_cate"title="????????????" value='${modifyProdDto.pd_cate}'>
												<c:forEach var="ctDto" items="${ctList}">
													<option>${ctDto.ct_name}</option>
												</c:forEach>
											</select></td>
									</tr>
									
								</table>
								
								<table style="margin-left: -747px; width: 1150px;">
									<tr>
										<td style="display: inline; font-size: 16px; margin-left: 100px;"><b>????????????</b></td>
									</tr>
									<tr>
										<td style="margin-left: 75px; margin-top: 10px; float: left; width: 1110px;">
											<textarea class="form-control content" id="p_content" name="pd_detail" title="????????????" >
											</textarea>
										</td>
									</tr>
								</table>
								</form>
							</div>
							</div>
							<div style="float: right; margin-right: 50px">
								<input id="registBtn" type="button" name="order" value="??????"
									style="width: 60px; height: 30px; border: none; font-size: 16px; color: white; background-color: #A09182; margin: 80px 0 120px 640px;">
							</div>
						</div>
					</div>
				</div>
			</div>
			
		
		</div>
	
    <!-- Js Plugins -->
    <script src="resources/main/js/jquery-3.3.1.min.js"></script>
    <script src="resources/main/js/bootstrap.min.js"></script>
    <script src="resources/main/js/jquery-ui.min.js"></script>
    <script src="resources/main/js/jquery.countdown.min.js"></script>
    <script src="resources/main/js/jquery.nice-select.min.js"></script>
    <script src="resources/main/js/jquery.zoom.min.js"></script>
    <script src="resources/main/js/jquery.dd.min.js"></script>
    <script src="resources/main/js/jquery.slicknav.js"></script>
    <script src="resources/main/js/owl.carousel.min.js"></script>
    <script src="resources/main/js/main.js"></script>
    
	<!-- jQuery -->
	<script src="resources/AT_front/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="resources/AT_front/js/jquery.easing.1.3.js"></script>
	<!-- ajax -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="resources/js/jquery.serializeObject.js"></script>
	<!-- Bootstrap -->
	<script src="resources/AT_front/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="resources/AT_front/js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="resources/AT_front/js/jquery.flexslider-min.js"></script>
	<!-- Sticky Kit -->
	<script src="resources/AT_front/js/sticky-kit.min.js"></script>

	<!-- MAIN JS -->
	<script src="resources/AT_front/js/main.js"></script>
	<script type="text/javascript">
		//?????? ??? ?????? ?????? ?????? ????????? ??? ??????.
		function vaildChk() {
			var inputContent = $(".content");//content????????????, ????????? ???????????? ???????????? ?????????
			var inputLength = inputContent.length;//??????????????? ????????? ??? 7?????????.
			var a = false;
			//var editor1 = CKEDITOR.replace( 'contents' );
			 CKEDITOR.instances.p_content.updateElement(); 
			 var data = CKEDITOR.instances.p_content.getData();
			inputContent.each(function() {//jquery????????? for?????? ????????? ??????!
				a = false;//????????? ?????? ????????? ?????? ??????????????? ??????
				//each?????????????????? return false??? for?????? break ?????????, return true??? for?????? continue????????? ??????. 
				if($(this).val()==""||$(this).val()==null||$(this).val()==0){
					console.log($(this).attr('title'));
					alert($(this).attr('title')+"??? ???????????????!" );
					$(this).focus();
					console.log($(this).val());
					return a;
				}else {
					a = true;
				}
			})
			return a;
		}
		
		$("#registBtn").click(function() {
			//?????? ????????? ????????? ??? ???????????? ?????? ????????? ????????? ?????? ?????? ?????? ??????
			var a = vaildChk();
			console.log(a);
			if(a){
				if(confirm("?????? ?????? ?????? ???????????????????")){
					console.log("???????????????.");
					$("#ATProdRegist").submit();//ATProdManage(???????????? ?????????)??? ??????!
				}
			 }else {
				
			}
		});
		
		//???????????? ????????? ckEditor
		 CKEDITOR.replace('p_content', {height: 500});

			//????????? ????????? ??? ????????????
			$(function() {
	            $("#image").on('change', function(){
	                readURL(this);
	            });
	        });
			
			function readURL(input) {
				console.log(input.files);
	            if (input.files && input.files[0]) {
	            	
	            var reader = new FileReader();

	            reader.onload = function (e) {
	            	//console.log(e.target.result);
	            	console.log( $('#preview').css("background-image"));
	                    $('#preview').css({'background-image':'url('+e.target.result+')'});
	                }

	              reader.readAsDataURL(input.files[0]);
	            }
	        };
			      
	        $(document).ready(function() { 
		    	 var chk = "${check}";
	                if(chk == "????????????"){
						$("#ATProdRegist").attr('action','prodModifyUpdate');
	                }
		    	 
		        $('#sex_select option').each(function(){
	
		            if($(this).val()=="${modifyProdDto.pd_sex}"){
	
		              $(this).attr("selected","selected"); // attr?????????????????? prop?????? 
	
		        	}
		        });
		        $('#type_select option').each(function(){
	
			        if($(this).val()=="${modifyProdDto.pd_type}"){
	
			           $(this).attr("selected","selected"); // attr?????????????????? prop?????? 
	
			  	    }
		        });
			    $('#cate_select option').each(function(){
	
				    if($(this).val()=="${modifyProdDto.pd_cate}"){
	
				       $(this).attr("selected","selected"); // attr?????????????????? prop?????? 
	
			    	}
			    });
		   			  
			    if('${oriName}'!=''){
			    	//$('#preview').attr('background-image','url(resources/prodImg/${oriName})');
			    	$("#preview").css({"background-image":"url(resources/main/img/products/${oriName})"}); 
			    }
			    
		        

		    }); 
	    
	     
	</script>
	</body>
</html>

