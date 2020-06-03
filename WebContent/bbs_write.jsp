<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    <title>BBS Test</title>
    
       
    <!--글쓰기만 적용되는 css-->   
    <style>
        .table-striped {
            text-align: center; 
            border: 2px solid #737373; 
        }

        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }
    </style>
</head>

<body>
 	<jsp:include page="/include/header.jsp"/>

    <section>
        <div class="container" style="margin-top: 5%;">
            <div class="row">
                <form action="writeForm.board" name="regForm" method="post">
                    <table class="table table-striped" >
                        <thead>
                            <tr>
                                <th colspan="2" style="background-color: #9DCAFF; text-align: center;">게시판 글쓰기</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="text" class="form-control" placeholder="작성자" name="writer" maxlength="50" value="${sessionScope.user_id}" readonly></td>
                            </tr>
                            <tr>
                                <td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td><textarea rows="15" class="form-control" placeholder="1000 글자 이하" name="content" maxlength="1000" ></textarea></td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <input type="button" class="btn btn-primary pull-left" value="목록" onclick="location.href='bbs.board'">
                    <input type="button" class="btn btn-primary pull-right" value="글쓰기" onclick="write_check()">
                </form>
            </div>
        </div>
    </section>
    <jsp:include page="/include/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script>
    	function write_check(){
    		if(${sessionScope.user_id == null}){
				alert("로그인 후 이용하세요");
				location.href="login.user";
			}else if(document.regForm.title.value == ''){
    			alert("글제목은 필수항목입니다");
    			return false;
    		}else if(document.regForm.content.value == ''){
    			alert("내용을 입력하세요");
    			return false;
    		}else if(document.regForm.title.length > 1000){
    			alert("글 내용은 1000자 이하만 등록가능합니다");
    			return false;
    		}else if(confirm("게시글을 등록하시겠습니까?")){
    			regForm.submit();
    		}
    		
    	}
    </script>

</body>

</html>