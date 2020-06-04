<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    
    <style type="text/css">

    </style>
    
    
</head>
<body>
 	<jsp:include page="/include/header.jsp"/>

    
<section>
        <div class="container">
            <div class="row join-wrap">
                
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER                   
                    </div>
                    <div>
                        <p>${sessionScope.user_id}님 회원정보</p>
                    </div>
                    <div>
                        <a href="mypageinfo.user"><button type="button" class="btn btn-primary">회원정보변경</button></a>
                        <button type="button" class="btn btn-primary" id="delCheck">회원 탈퇴</button>
                        
                    </div>
                    <div class="delete-hidden">
                        <form action="delete.user">
                        <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="pw">
                        <button type="submit" class="btn btn-primary" >확인</button>
                        </form>
                    </div>
                    
                    <br>
                    <div>
                        <p>${sessionScope.user_id}님의 작성 게시물</p>
                        <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                    <thead>
                        <tr>
                            <th style="text-align: center;">번호</th>
                            <th style="text-align: center;">제목</th>
                            <th style="text-align: center;">작성자</th>
                            <th style="text-align: center;">작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="vo" items="${list}">
                    	<c:if test="${vo.writer == sessionScope.user_id}">
                        <tr>
                            <td>${vo.bno}</td>
                            <td><a href="content.board?bno=${vo.bno}">${vo.title}</a></td>
                            <td>${vo.writer}</td>
                            <td>${vo.regdate}</td>
                        </tr>
                        </c:if>
					</c:forEach>
                    </tbody>

                </table>
                    </div>
                    <div class="text-center">
                   <ul class="pagination pagination-sm">
                       	<c:if test="${pageVO.prev}">
                        <li><a href="mypage.user?pageNum=${pageVO.startPage - 1}&amount=${pageVO.amount}">이전</a></li>
                        </c:if>
                        		
                        <c:forEach var="num" begin="${pageVO.startPage}" end="${pageVO.endPage}">
                        <li  class="${num == pageVO.pageNum ? 'active' : '' }">
                        	<a href="mypage.user?pageNum=${num}&amount=${pageVO.amount}">${num}</a></li>
                        </c:forEach>
                        		
                        <c:if test="${pageVO.next}">
                        <li><a href="mypage.user?pageNum=${pageVO.endPage + 1}&amount=${pageVO.amount}">다음</a></li>
                        </c:if>
                    </ul>
                   </div> 
                </div>


            </div>

        </div>

    </section>
    
    <jsp:include page="/include/footer.jsp"/>

    <script>
        //탈퇴버튼 디스플레이 처리
        var delCheck = document.getElementById("delCheck");
        delCheck.onclick = function() {
            var del  = document.querySelector(".delete-hidden");
            if(del.style.display == "none" || del.style.display == "") {
                del.style.display = "inline";
            } else {
                del.style.display = "none";
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>