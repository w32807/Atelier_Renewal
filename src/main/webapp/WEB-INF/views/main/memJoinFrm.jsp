<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">
<script type="text/javascript">
  		window.onload = function() {//이 페이지가 실행 되면, 이 함수를 실행해라
			var chk = "${check}";
			if(chk == "fail"){
				alert("회원 가입 실패");
				location.reload(true);//화면을 다시 한번 불러오면서 check를 리셋함 
			}
		}
</script>

<body>
    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="/"><i class="fa fa-home"></i> Home</a>
                        <span>Register</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Form Section Begin -->

    <!-- Register Section Begin -->
    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="register-form">
                    <div class="newslatter-item">
						<a href="main">
						    <img src="./resources/main/img/logo_bottom.png" alt="" style="margin-top: 25px;">
						</a>
                    </div>
                        <form:form modelAttribute="user" action="memberInsert" method="POST">
                            <div class="group-input">
                                <form:label path="cmEmail"  for="cmEmail">Email을 입력하세요. *</form:label> 
                                <form:input path="cmEmail"  type="text" name="cmEmail" id="cmEmail" placeholder="Ex) example@example.com" value="${user.cmEmail }" />
								<form:errors path="cmEmail"/>
                                 <div class="check_font" id="id_check"></div>
                            </div>
                                                 
                            <button type="submit" class="site-btn register-btn">Atelier 회원가입</button>
                        </form:form>         
                            <div class="group-input">
                                <label for="cmPwd">Password를 입력하세요. *</label>
                                <input type="text" name ="cmPwd" id="cmPwd" placeholder="영문과 숫자를 조합한 8자리이상의 비밀번호 입력" required>
                            </div>
                            <div class="group-input">
                                <label for="conCmPwd">Password 확인 *</label>
                                <input type="text" name ="conCmPwd" id="conCmPwd" required>
                            </div>
                            <!-- 비밀번호 일치/불일치 출력 -->
                            <input type="text" name="status" style="border:0;color:highlight;font size:12px 굴림;width:160" readonly onfocus="this.blur();" value=" 비밀번호를 입력해 주세요 ">  
                            <div class="group-input">
                                <label for="cmName">성함을 입력하세요. *</label>
                                <input type="text" name="cmName" id="cmName" value="${user.cmName }" required>
                            </div>
                            <div class="group-input">
                                <label for="cmNick">닉네임을 입력하세요. *</label>
                                <input type="text" name="cmNick" id="cmNick" value="${user.cmNick }" required>
                            </div>
                            <div class="group-input">
                                <label for="CM_PHONE">전화번호를 입력하세요. *</label>
                                <input type="tel" name="cmPhone" id="cmPhone" value="${user.cmPhone }" maxlength="14" required>
                            </div>
                            <div class="group-input">
                                <label for="saAddrHead">주소를 입력하세요. *</label>
                                <input type="text" name="saAddrHead" id="saAddrHead" required>
                                <input type="text" name="saAddrDetail" id="saAddrDetail" required>
                            </div>
                            <div class="payment-check">
                                    <div class="pc-item">
                                        <label for="pcCheck">
                                            개인정보 수집 및 이용에 대한 안내(필수)
                                            <input type="checkbox" id="pcCheck" required>
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>                          
  </div>
                        <div class="switch-login">
                            <a href="login" class="or-login">로그인</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!-- 비밀번호 확인 -->
<script>
	/*---------------------------------------------------------------------------------
	 * 기능 : 비밀번호 변경시 일치여부
	 * 작성인 : KJH
	 * 작성날짜 : 2020.02.04     최종수정일 :2020.02.18
	 ----------------------------------------------------------------------------------*/
	// checkvalue 기능
	/*
	function checkvalue() {
	
		if(memberJoinFrm.cm_pwd.value && memberJoinFrm.conCmPwd.value) {
			  if(memberJoinFrm.cm_pwd.value!=memberJoinFrm.conCmPwd.value){
				   memberJoinFrm.status.value = "일치하지 않습니다";
				   memberJoinFrm.status.style.width = 120;
			  } else {
				   memberJoinFrm.status.value = "일치합니다";
				   memberJoinFrm.status.style.width = 83;
			  }
		} else {
			  memberJoinFrm.status.value = "비밀번호를 입력해 주세요";
			  memberJoinFrm.status.style.width = 160;
		}
	}

	$("#cmEmail").change(function(){
		registValid.emailValidChk($(this).val());
	});
	
	$("#cmPwd").change(function(){
		registValid.pwdValidChk($(this).val());
	});
	
	$("#cmName").change(function(){
		registValid.nameValidChk($(this).val());
	});
	
	$("#cmNick").change(function(){
		registValid.nickValidChk($(this).val());
	});
	
	$("#cmPhone").change(function(){
		registValid.phoneNumValidChk($(this).val());
	});
	
	$("#pcCheck").change(function(){
		registValid.pcCheckValidChk($(this));
	});
	
	$("#memberJoinFrm").on('click', function() {
		fn_comAjax(fn_formToJson($('#memberJoinFrm')), 'ADNoticeDelete', 
				function(data) {
					alert(data.msg);
					fn_comAjax($("#page").val(), 'ADNoticeList', fn_attachList, '');
					$('#allCheck').prop("checked", false);
				}
			,'');
	})*/
	/* ---------------------------------------------------------------------------------------
	 * 기능: 회원가입 / 아이디 유효성 검사
	 * 작성자: JSH
	 * 작성일: 2020.02.04
	 -----------------------------------------------------------------------------------------*/
	 /*
	$("#CM_ID").blur(function() {
		console.log("JSP 유효성 검사 실행")
		// id = "id_reg" / name = "userId"
		var CM_ID = $('#CM_ID').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/memJoinFrm/idCheck?CM_ID='+ CM_ID,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다!");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						
						//if(idJ.test(CM_ID)){
							// 0 : 아이디 길이 / 문자열 검사
							//$("#id_check").text("");
							//$("#reg_submit").attr("disabled", false);
							//}
						 if(CM_ID == ""){
							
							$('#id_check').text('아이디를 입력해주세요!');
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
							
						} else {
							
							if (CM_ID.indexOf("@") != -1) {
							$('#id_check').text("사용 가능한 아이디 입니다!");
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);
							
							} else {
									$('#id_check').text("아이디를 E-mail 형식으로 입력해주세요!");
									$('#id_check').css('color', 'red');
									$("#reg_submit").attr("disabled", true);
							}
						}
					}
				}, error : function() {
						console.log("실패");
				}
			});
		})
		*/
</script>
</body>
</html>