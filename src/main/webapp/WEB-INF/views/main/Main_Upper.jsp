<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
	<head>
	    <meta charset="UTF-8">
	    <meta name="description" content="Fashi Template">
	    <meta name="keywords" content="Fashi, unica, creative, html">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	
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
	</head>

<body>
  <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    <!-- 이메일 전화번호 회원가입 로그인 -->
    <header class="header-section">
        <div class="header-top">
            <div class="container">
                <div class="ht-left">
                </div>
                <!-- 로그인, 회원가입 -->
                <div class="ht-right">
					<script>
						function goPage(){
							var f = document.gologout;
							f.action = "logout";
							f.method = "post";
							f.submit();
						}
					</script>
					<form name="gologout"></form>
					<a href="logout" class="hideandshow login-panel"><i class="fa fa-user"></i>로그아웃</a>
					<c:if test="${msg == 'logoutSuccess' }">
						<script type="text/javascript">
							//alert('로그아웃을 성공했습니다.');
						</script>
					</c:if>
					
                    <a href="login" class="showandhide login-panel"><i class="fa fa-user"></i>로그인</a>
                    <a href="memJoinFrm" class="showandhide login-panel"><i class="fa fa-user"></i>회원가입</a>
                    <a href="CONotice" class="login-panel"><i class="fa fa-user"></i>고객센터</a>
                     
                    <!-- SNS광고란 -->
                    <div class="top-social">
                  	    <temp class="hideandshow">${mb.cm_name}님 환영합니다.</temp>
                        <a href="https://www.facebook.com/"><i class="ti-facebook"></i></a>
                        <a href="https://twitter.com/"><i class="ti-twitter-alt"></i></a>
                        <a href="https://www.instagram.com/"><i class="ti-linkedin"></i></a>
                        <a href="https://www.pinterest.co.kr/"><i class="ti-pinterest"></i></a>
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="inner-header">
                <div class="row">
                    <div class="col-lg-2 col-md-2">
                        <div class="logo">
                            <a href="main">
                                <img src="./resources/main/img/logo_main.jpg" alt="">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-7 col-md-7">
                        <div class="advanced-search">
                            <button type="button" class="category-btn">검색창</button>
                            <div class="input-group">
                                <input type="text" placeholder="원하시는 공방명/상품을 입력해주세요.">
                                <button type="button"><i class="ti-search"></i></button>
                            </div>
                        </div>
                        <!-- 마이페이지 -->
                    </div>
                    <div  class="col-lg-3 text-right col-md-3">
                        <ul class="nav-right hideandshow">
	                            <li class="heart-icon">
	                                <a href="myPage">
	                                    <i class="icon_heart_alt"></i>
	                                    <!-- <span>6</span> -->
	                            </li>
	                            <li class="cart-price">MyPage</li>
	                            </a>
	                            
	                            <li class="cart-icon">
	                                <a href="basket">
	                                    <i class="icon_bag_alt"></i>
	                                <!-- <span>9</span> -->
	                            </li>
                            <li class="cart-price">basket</li>
                            </a>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="nav-item">
            <div class="container">
                <div class="nav-depart">
                    <div class="depart-btn">
                        <i class="ti-menu"></i>
                        <span>Home</span>
                        	<ul class="depart-hover" style="z-index: 999;">
                            <li class="active"><a href="main">Shop Home</a></li>
                            <li><a href="ATMain">Atelier Home</a></li>
                            <li><a href="/">Experience</a></li>
                        </ul>
                    </div>
                </div>
                <nav class="nav-menu mobile-menu">
                    <ul>
                    	<!-- 선택된 카테고리 색 변경
                        <li class="active">
                         -->
                         <li><a href="prodList_All">전체 보기</a></li>
                        <li><a href="prodList_Clo?pd_cate=의류">의류</a></li>
                        <li><a href="prodList_Bag?pd_cate=가방">가방</a></li>
                        <li><a href="prodList_shoes?pd_cate=신발">신발</a></li>
                        <li><a href="prodList_Wallet?pd_cate=지갑">지갑</a></li>
                        <li><a href="prodList_Belt?pd_cate=벨트">벨트</a></li>
                        <li><a href="prodList_Gloves?pd_cate=장갑">장갑</a></li>
                        <li><a href="prodList_House?pd_cate=가구">가구</a></li>
                        <li><a href="prodList_Etc?pd_cate=기타 악세사리">기타 악세사리</a></li>
                    </ul>
                </nav>
                <div id="mobile-menu-wrap"></div>
            </div>
        </div>
    </header>
    <!-- Header End -->
    <!-- Js Plugins -->
    <script src="<c:url value="/resources/main/js/jquery-3.3.1.min.js"/>"></script>
    <script src="<c:url value="/resources/main/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/main/js/jquery-ui.min.js"/>"></script>
    <script src="<c:url value="/resources/main/js/jquery.countdown.min.js"/>"></script>
    <script src="<c:url value="/resources/main/js/jquery.nice-select.min.js"/>"></script>
    <script src="<c:url value="/resources/main/js/jquery.zoom.min.js"/>"></script>
    <script src="<c:url value="/resources/main/js/jquery.dd.min.js"/>"></script>
    <script src="<c:url value="/resources/main/js/jquery.slicknav.js"/>"></script>
    <script src="<c:url value="/resources/main/js/owl.carousel.min.js"/>"></script>
    <script src="<c:url value="/resources/main/js/main.js"/>"></script>
    </body>
    
    <!-- 메뉴태그 클래스 변경	 -->
	<script type="text/javascript">
    $('.filter-control ul li').on('click', function(){
		$('.filter-control ul li').removeClass('active');
		$(this).addClass('active');
	});
    </script>
    
    <script type="text/javascript">
    
   
    /* ---------------------------------------------------------------------------------------
	 * 기능: 로그인 여부에 따른 버튼 출력여부 결정
	 * 작성자: JSG
	 * 작성일: 2020.02.04
	 -----------------------------------------------------------------------------------------*/
    window.onload = function(){
    	$('.hideandshow').hide();
    	var mid = '${mb.cm_id}';
    	var mname = '${mb.cm_name}';
    	console.log('세션값'+'${mb}');
    	console.log(mid);
    	console.log(mname);
    	if(mid != ''){
    		$('.hideandshow').show();
    	}
    	
    	$('.showandhide').show();
    	var mid1 = '${mb.cm_id}';
    	var mname1 = '${mb.cm_name}';
    	console.log('세션값'+'${mb}');
    	console.log(mid1);
    	console.log(mname1);
    	if(mid1 != ''){
    		$('.showandhide').hide();
    	}
    	
    /* ---------------------------------------------------------------------------------------
     * 기능: 공방 매니저 일치 여부에 따라 공방 관리 메뉴 출력, 비출력
     * 작성자: JSH
     * 작성일: 2020.02.17
     -----------------------------------------------------------------------------------------*/
    	
    	$('ATConfig').hide();
		var atid = '${at.at_id}';
		console.log(mid);
		console.log(atid);
		
		if(mid == atid){
			$('.ATConfig').show();
		}
		
		$('.ATConfig').show();
		if(mid != atid){
			$('.ATConfig').hide();
		}
		
		/* ---------------------------------------------------------------------------------------
		 * 기   능: ATNotice에서 내공방일때만 글쓰기 버튼 출력
		 * 작성일: 2020.02.19
		 * 작성자: KJH 
		 -----------------------------------------------------------------------------------------*/	       
		$('NTConfig').hide();
		var atid = '${at.at_id}';
		console.log(mid);
		console.log(atid);
		
		if(mid == atid){
			$('.NTConfig').show();
		}
		
		$('.NTConfig').show();
		if(mid != atid){
			$('.NTConfig').hide();
		}
		
		/* ---------------------------------------------------------------------------------------
		 * 기   능: ATNoticeDetail 에서 내공방일때만 글쓰기 버튼 출력
		 * 작성일: 2020.02.19
		 * 작성자: KJH 
		 -----------------------------------------------------------------------------------------*/	       
		$('NTDConfig').hide();
		var atid = '${at.at_id}';
		console.log(mid);
		console.log(atid);
		
		if(mid == atid){
			$('.NTDConfig').show();
		}
		
		$('.NTDConfig').show();
		if(mid != atid){
			$('.NTDConfig').hide();
		}
	       
	    /* ---------------------------------------------------------------------------------------
	     * 기   능: 이미 신청한 경우 main으로 이동.
	     * 작성일: 2020.02.07
	     * 작성자: JSG 
	     -----------------------------------------------------------------------------------------*/
	       var chk = '${check}';
	       console.log(chk);
	       if(chk >= 1){
	          alert("이미 신청을 하였습니다.");
	          document.location.href = "main";
	       }
	       
	       var chk = "${payment}";
			console.log(chk);
			if(chk != ""){
				alert(chk);
				location.reload(true); 
			}
			
			 var chk = "${ATOrderCheck}";
		     if(chk!=''){
		     removeSelected();
		     switch (chk) {
			 	case "before":
			 		$('select[name="orderState"]').find('option[value="before"]').attr("selected",true);
			 	break;
			 	case "being":
			 		$('select[name="orderState"]').find('option[value="being"]').attr("selected",true);
			 	break;
			 	case "after":
			 		$('select[name="orderState"]').find('option[value="after"]').attr("selected",true);
			 	break;

		 		}
		     
		     var ATRegistCheck1 = "${ATRegistCheck}";
				if(ATRegistCheck1 == 1){
					alert("공방 신청이 접수되었습니다.");
				}		     
		    }
		     
		/* ---------------------------------------------------------------------------------------
		 * 기   능: ATProdManage에서 각종 메세지를 띄우기 위한 기능
		 * 작성일: 2020.02.18
		 * 작성자: JWJ / KYH 
		 -----------------------------------------------------------------------------------------*/	     
			var chk = "${ATProdcheck}";
			console.log(chk);
			if(chk != ""){
				alert(chk);
				location.reload(true); 
			}
		    
		/* ---------------------------------------------------------------------------------------
		 * 기   능: ATOrderRequest에서 결제 완료 문구를 띄우기 위한 기능
		 * 작성일: 2020.02.18
		 * 작성자: KYH 
		 -----------------------------------------------------------------------------------------*/	       
			var chk = "${payment}";
			console.log(chk);
			if(chk != ""){
				alert(chk);
				location.reload(true); 
			}
    }
    </script>
</html>