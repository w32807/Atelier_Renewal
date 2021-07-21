<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Breadcrumb Section Begin -->
<div class="breacrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text">
                    <a href="main"><i class="fa fa-home"></i> Home</a>
                    <span>Login</span>
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
                <div class="login-form">
                    <h2>Login</h2>
                    <form action="/loginProc" method="post" >
                        <div class="group-input">
                            <label for="username">E-mail을 입력해주세요. *</label>
                            <input type="text" id="username" name="username" value="${username }" placeholder="Ex) example@example.com" required>
                            <p style="color: red"><c:out value="${msg}"/></p>
                        </div>
                        <div class="group-input">
                            <label for="pass">Password를 입력해주세요. *</label>
                            <input type="password" id="pass" name="password" required>
                        </div>
                        <div class="group-input gi-check">
                            <div class="gi-more">
                            </div>
                        </div>
                        <button type="submit" class="site-btn login-btn">Atelier 로그인</button>
                    </form>
                    <div class="switch-login">
                        <a href="memJoinFrm" class="or-login">회원가입</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>