<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>       
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/custom.css">
        <title>BBS Test</title>
        
        <!--게시판만 적용되는 css-->            
        <style>

            .table-striped > tbody > tr {
                background-color: rgba(255, 255, 255)
            }
            .row h2 {
                color: aliceblue;
                
            }
            .pagination-sm {
                margin: 0;
            }
            
        </style>
    </head>

    <body>
 	<jsp:include page="/include/header.jsp"/>

    <section>
        
        <div class="container">
            <div class="row">
                
                <h2>게시판 목록</h2>
                <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                    <thead>
                        <tr>
                            <th style="background-color: #9DCAFF; text-align: center;">번호</th>
                            <th style="background-color: #9DCAFF; text-align: center;">제목</th>
                            <th style="background-color: #9DCAFF; text-align: center;">작성자</th>
                            <th style="background-color: #9DCAFF; text-align: center;">작성일</th>
                        </tr>
                    </thead>
                    
					<c:forEach var="vo" items="${list}">
                    <tbody>
                        <tr>
                            <td>${vo.bno}</td>
                            <td><a href="content.board?bno=${vo.bno}">${vo.title}</a></td>
                            <td>${vo.writer}</td>
                            <td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                        </tr>
                    </tbody>
                    </c:forEach>
                        
                </table>

                <div class="text-center">
                    <ul class="pagination pagination-sm">
                       	<c:if test="${pageVO.prev}">
                        <li><a href="list.board?pageNum=${pageVO.startPage - 1}&amount=${pageVO.amount}">이전</a></li>
                        </c:if>
                        		
                        <c:forEach var="num" begin="${pageVO.startPage}" end="${pageVO.endPage}">
                        <li  class="${num == pageVO.pageNum ? 'active' : '' }">
                        	<a href="list.board?pageNum=${num}&amount=${pageVO.amount}">${num}</a></li>
                        </c:forEach>
                        		
                        <c:if test="${pageVO.next}">
                        <li><a href="list.board?pageNum=${pageVO.endPage + 1}&amount=${pageVO.amount}">다음</a></li>
                        </c:if>
                    </ul>
                    <button class="btn btn-info pull-right" onclick="login_check()">글쓰기</button>
                </div>
                
            </div>
        </div>
    </section>
        
    <jsp:include page="/include/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
	<script>
		function login_check(){
			if(${sessionScope.user_id == null}){
				alert("로그인 후 이용하세요");
				location.href="login.user";
			}else{
				location.href="write.board";
			}
		}
	</script>
    </body>

</html>
