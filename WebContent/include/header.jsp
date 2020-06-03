<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<header>

	<nav class="navbar navbar-default" id="nav">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/TEST/main.do">MIN and PARK</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/TEST/main.do" style="margin-right: 10px;">메인</a></li>
                <li class="active"><a href="bbs.board">게시판</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">

				<c:choose>
				<c:when test="${sessionScope.user_id == null}">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="login.user">로그인</a></li>
                        <li><a href="join.user">회원가입</a></li>
                        </c:when>
                        <c:otherwise>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.user_id}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="mypage.user">마이페이지</a></li>
                        <li><a href="logout.user">로그아웃</a></li>
                </c:otherwise>
                </c:choose>

                    </ul>
                </li>
            </ul>

        </div>
    </nav>

</header>