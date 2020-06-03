<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/custom.css">

        <title>BBS Test</title>

</head>
<body>
 	<jsp:include page="/include/header.jsp"/>

     <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 col-sm-12 join-form">
                    <h2>게시판 수정<small>(디자인이궁금하세요?)</small></h2>

                    <form action="modifyForm.board" name="regForm">
                        <div class="form-group">
                            <label>글번호</label>
                            <input type="text" class="form-control" value="${BoardVO.bno}" name="bno" readonly>
                        </div>
                        <div class="form-group">
                            <label>글쓴이</label>
                            <input type="text" class="form-control" placeholder="자유" value="${BoardVO.writer}" name="writer" readonly>
                        </div>
                        <div class="form-group">
                            <label>제목</label>
                            <input type="text" class="form-control" placeholder="자유" value="${BoardVO.title}" name="title">
                        </div>
                        <div class="form-group">
                            <label>내용</label>
                            <textarea class="form-control" rows="5" name="content">${BoardVO.content}</textarea>
                        </div>

                        <!--구현로직: 버튼은 온클릭을 사용하던 자바스크립트를 이용해야 합니다-->
                        <div class="form-group">
                            <button type="button" class="btn btn-success" onclick="location.href='bbs.board'">목록</button>
                            <button type="button" class="btn btn-info" onclick="modify_check()">수정</button>
                            <button type="button" class="btn btn-default" onclick="delete_check()">삭제</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>


        </section>
    <jsp:include page="/include/footer.jsp"/>
    
    <script>
    	function modify_check(){
    		if(document.regForm.title.value == ''){
    			alert("제목을 입력하세요");
    			return false;
    		}else if(document.regForm.content.value == ''){
    			alert("내용을 입력하세요");
    			return false;
    		}else if(confirm("수정하시겠습니까?")){
    			regForm.submit();
    		}
    	}
    </script>
    
    <script>
    	function delete_check(){
    		if(confirm("삭제하시겠습니까?")){
    			location.href="delete.board?bno=${BoardVO.bno}";
    		}
    	}
    </script>

    
</body>
</html>