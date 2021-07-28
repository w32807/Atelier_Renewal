<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!-- 이메일 전화번호 회원가입 로그인 -->
<header class="header-section">
    <div class="header-top">
        <div class="container">
            <div class="ht-left">
            </div>
            <!-- 로그인, 회원가입 -->
            <div class="ht-right">
				<a href="logout" class="hideandshow login-panel"><i class="fa fa-user"></i>로그아웃</a>
                <a href="login" class="showandhide login-panel"><i class="fa fa-user"></i>로그인</a>
                <a href="memJoinFrm" class="showandhide login-panel"><i class="fa fa-user"></i>회원가입</a>
                <a href="CONotice" class="login-panel"><i class="fa fa-user"></i>고객센터</a>
                 
                <!-- SNS광고란 -->
                <div class="top-social">
              	    <%-- <temp class="hideandshow">${mb.cm_name}님 환영합니다.</temp> --%>
              	    <span class="hideandshow">${userName}님 환영합니다.</span>
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

<script type="text/javascript">

</script>