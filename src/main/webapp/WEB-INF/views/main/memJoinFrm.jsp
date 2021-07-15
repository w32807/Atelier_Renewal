<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">
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
                        <form:form modelAttribute="userRequestDto" action="memberInsert" method="POST">
                            <div class="group-input">
                                <form:label path="cmEmail"  for="cmEmail">Email을 입력하세요. *</form:label> 
                                <form:input path="cmEmail"  type="text" name="cmEmail" id="cmEmail" placeholder="Ex) example@example.com" value="${userRequestDto.cmEmail }" />
								<form:errors path="cmEmail"/>
                                 <div class="check_font" id="id_check"></div>
                            </div>
                            <div class="group-input">
                                <form:label path="cmPwd" for="cmPwd">Password를 입력하세요. *</form:label>
                                <form:input path="cmPwd"  type="text" name ="cmPwd" id="cmPwd" placeholder="영문과 숫자를 조합한 8자리이상의 비밀번호 입력" />
								<form:errors path="cmPwd"/>
                            </div>
                            <div class="group-input">
                               <form:label path="conCmPwd" for="cmPwd">Password 확인 *</form:label>
                                <form:input path="conCmPwd"  type="text" name ="conCmPwd" id="conCmPwd" placeholder="영문과 숫자를 조합한 8자리이상의 비밀번호 입력" />
								<form:errors path="conCmPwd"/>
                            </div>
                            <!-- 비밀번호 일치/불일치 출력 -->
                            <input type="text" name="status" style="border:0;color:highlight;font size:12px 굴림;width:160"  value=" 비밀번호를 입력해 주세요 " readonly="readonly" onfocus="this.blur();">  
                            <div class="group-input">
                                <form:label path="cmName" for="cmName">성함을 입력하세요. *</form:label>
                                <form:input path="cmName"  type="text" name="cmName" id="cmName" value="${userRequestDto.cmName }" />
								<form:errors path="cmName"/>
                            </div>
                            <div class="group-input">
                                <form:label path="cmNick" for="cmNick">닉네임을 입력하세요. *</form:label>
                                <form:input path="cmNick" type="text" name="cmNick" id="cmNick" value="${userRequestDto.cmNick }" />
								<form:errors path="cmNick"/>
                            </div>
                            <div class="group-input">
                                <form:label path="cmPhone" for="CM_PHONE">전화번호를 입력하세요. *</form:label>
                                <form:input path="cmPhone" type="tel" name="cmPhone" id="cmPhone" value="${userRequestDto.cmPhone }" maxlength="14" />
								<form:errors path="cmPhone"/>
                            </div>
                            <div class="group-input">
                                <form:label path="saAddrHead"  for="saAddrHead">주소를 입력하세요. *</form:label>
                                <form:input path="saAddrHead" type="text" name="saAddrHead" id="saAddrHead"  value="${userRequestDto.saAddrHead }" />
								<form:errors path="saAddrHead"/>
                                <form:input path="saAddrDetail" type="text" name="saAddrDetail" id="saAddrDetail"  value="${userRequestDto.saAddrDetail }" />
								<form:errors path="saAddrDetail"/>
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
    						<button type="submit" class="site-btn register-btn">Atelier 회원가입</button>
                        </form:form> 
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
	})
</script>
</body>
</html>