<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Atelier | Atelier</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="resources/main/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="resources/main/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="resources/main/css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="resources/main/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="resources/main/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="resources/main/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="resources/main/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="resources/main/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="resources/main/css/style.css" type="text/css">
</head>

<body>

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="main"><i class="fa fa-home"></i> Home</a>
                        <span>Atelier</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Blog Section Begin -->
    <section class="blog-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1">
                    <div class="blog-sidebar">
                        <div class="blog-catagory" style="margin-bottom: 80px;">
                        	<h4 style="margin-bottom: 30px;">????????????</h4>
                        	<input type="checkbox" id = "allCheck" value="??????" style="margin-bottom:20px;">??????
                        		<form action="ATMain" method="get">
	                            	<ul>
	                            		
		                                <li><input type="checkbox" name="category" value="??????">??????</li>
		                                <li><input type="checkbox" name="category" value="??????">??????</li>
		                               	<li><input type="checkbox" name="category" value="??????">??????</li>
		                                <li><input type="checkbox" name="category" value="??????">??????</li>
		                            </ul>
		                            <ul style="margin: -135px 0 0 120px;">
		                                <li><input type="checkbox" name="category" value="??????">??????</li>
		                                <li><input type="checkbox" name="category" value="??????">??????</li>
		                               	<li><input type="checkbox" name="category" value="??????">??????</li>
		                                <li><input type="checkbox" name="category" value="?????? ????????????">?????? ????????????</li>
		                            </ul>
		                            <input type="submit" value="????????????"
		                            		style="cursor: pointer; border-style: solid; border-color: #e7ab3c; background-color: #e7ab3c; color: white; margin: 25px 0 0 175px;">
                    
                            	</form>
                        </div>
                        <div class="recent-post">
                            <h4>?????? ??????</h4>
                        	<div class="recent-blog">
	                                <c:forEach var = "at_recommend_list" items = "${at_recommend_list}">
	                                <div class="rb-item" style="margin-bottom: -10px;">
	                                    <div class="rb-pic">
	                                       <a href="ATDetail?at_num=${at_recommend_list.at_seq}"><img src="resources\upload\logo/${at_recommend_list.at_logo}" alt="" style="width: 120px; height: 120px;"></a>
	                                    </div>
	                                    <div class="rb-text" style="margin-top: 10px;">
	                                    	<p><span style="font-size: 13px;">#${at_recommend_list.at_cate1} #${at_recommend_list.at_cate2} #${at_recommend_list.at_cate3}</span></p>
	                                    	<a href="ATDetail?at_num=${at_recommend_list.at_seq}"><p style="font-size: 16px;">${at_recommend_list.at_name}</p></a>
	                                    </div>
	                                </div>
	                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="row">
                    <!-- ??????????????? for????????? ?????? -->
                        <c:forEach var="at_filter_list" items="${at_filter_list}">
                        <div class="col-lg-6 col-sm-6">
                            <div class="blog-item">
                                <div class="bi-pic">
                                    <a href="ATDetail?at_num=${at_filter_list.at_seq}"><img src="resources\upload\logo/${at_filter_list.at_logo}" alt="" style="width: 300px;"></a>
                                </div>
                                <div class="bi-text">
                                 <a href="ATDetail?at_num=${at_filter_list.at_seq}">
                                	<h4>${at_filter_list.at_name}</h4><br>
                                	<p><span>#${at_filter_list.at_cate1} #${at_filter_list.at_cate2} #${at_filter_list.at_cate3}</span></p>
                                   
                                        
                                        <br>
                                    </a>
                                   
                                </div>
                            </div>
                        </div>
                       </c:forEach>
                        <!-- ??????????????? for????????? ?????? -->
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Section End -->

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
</body>
	<script>
	$(document).ready(function(){
			if('${checkedBoxArr[0]}' == "??????"||'${checkedBoxArr[0]}' =="??????"||'${checkedBoxArr[0]}' =="??????"||'${checkedBoxArr[0]}' =="??????"||'${checkedBoxArr[0]}' =="??????"||'${checkedBoxArr[0]}' =="??????"||'${checkedBoxArr[0]}' =="??????"||'${checkedBoxArr[0]}' =="?????? ????????????") $("input:checkbox[value='${checkedBoxArr[0]}']").prop("checked", true);
			if('${checkedBoxArr[1]}' == "??????"||'${checkedBoxArr[1]}' =="??????"||'${checkedBoxArr[1]}' =="??????"||'${checkedBoxArr[1]}' =="??????"||'${checkedBoxArr[1]}' =="??????"||'${checkedBoxArr[1]}' =="??????"||'${checkedBoxArr[1]}' =="??????"||'${checkedBoxArr[1]}' =="?????? ????????????") $("input:checkbox[value='${checkedBoxArr[1]}']").prop("checked", true);
			if('${checkedBoxArr[2]}' == "??????"||'${checkedBoxArr[2]}' =="??????"||'${checkedBoxArr[2]}' =="??????"||'${checkedBoxArr[2]}' =="??????"||'${checkedBoxArr[2]}' =="??????"||'${checkedBoxArr[2]}' =="??????"||'${checkedBoxArr[2]}' =="??????"||'${checkedBoxArr[2]}' =="?????? ????????????") $("input:checkbox[value='${checkedBoxArr[2]}']").prop("checked", true);
			if('${checkedBoxArr[3]}' == "??????"||'${checkedBoxArr[3]}' =="??????"||'${checkedBoxArr[3]}' =="??????"||'${checkedBoxArr[3]}' =="??????"||'${checkedBoxArr[3]}' =="??????"||'${checkedBoxArr[3]}' =="??????"||'${checkedBoxArr[3]}' =="??????"||'${checkedBoxArr[3]}' =="?????? ????????????") $("input:checkbox[value='${checkedBoxArr[3]}']").prop("checked", true);
			if('${checkedBoxArr[4]}' == "??????"||'${checkedBoxArr[4]}' =="??????"||'${checkedBoxArr[4]}' =="??????"||'${checkedBoxArr[4]}' =="??????"||'${checkedBoxArr[4]}' =="??????"||'${checkedBoxArr[4]}' =="??????"||'${checkedBoxArr[4]}' =="??????"||'${checkedBoxArr[4]}' =="?????? ????????????") $("input:checkbox[value='${checkedBoxArr[4]}']").prop("checked", true);
			if('${checkedBoxArr[5]}' == "??????"||'${checkedBoxArr[5]}' =="??????"||'${checkedBoxArr[5]}' =="??????"||'${checkedBoxArr[5]}' =="??????"||'${checkedBoxArr[5]}' =="??????"||'${checkedBoxArr[5]}' =="??????"||'${checkedBoxArr[5]}' =="??????"||'${checkedBoxArr[5]}' =="?????? ????????????") $("input:checkbox[value='${checkedBoxArr[5]}']").prop("checked", true);
			if('${checkedBoxArr[6]}' == "??????"||'${checkedBoxArr[6]}' =="??????"||'${checkedBoxArr[6]}' =="??????"||'${checkedBoxArr[6]}' =="??????"||'${checkedBoxArr[6]}' =="??????"||'${checkedBoxArr[6]}' =="??????"||'${checkedBoxArr[6]}' =="??????"||'${checkedBoxArr[6]}' =="?????? ????????????") $("input:checkbox[value='${checkedBoxArr[6]}']").prop("checked", true);
			if('${checkedBoxArr[7]}' == "??????"||'${checkedBoxArr[7]}' =="??????"||'${checkedBoxArr[7]}' =="??????"||'${checkedBoxArr[7]}' =="??????"||'${checkedBoxArr[7]}' =="??????"||'${checkedBoxArr[7]}' =="??????"||'${checkedBoxArr[7]}' =="??????"||'${checkedBoxArr[7]}' =="?????? ????????????") $("input:checkbox[value='${checkedBoxArr[7]}']").prop("checked", true);
	});

	</script>
	
	<script type="text/javascript">
      $(function() { //???????????? ???????????? ?????? 
         $("#allCheck").click(function() { //?????? ?????? ?????? ??????????????? ???????????????????????? 
            if ($("#allCheck").prop("checked")) { //??????????????? ?????? checkbox?????? ???????????????
               $("input[type=checkbox]").prop("checked", true);
            }
            // ???????????? ??????????????? ????????? ?????? 
            else { //??????????????? ?????? checkbox?????? ????????????????????????. 
               $("input[type=checkbox]").prop("checked", false);
            }
         })
      })
   </script>
	
</html>