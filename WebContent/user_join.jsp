<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <title>BBS Test</title>
    
    
    <!--회원가입 폼만 적용되는 css-->
    <style type="text/css">
        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }

        .join-form {
            margin: 0 auto;
            padding: 20px;
            width: 50%;
            float: none;
            background-color: white;
        }
        
        
        .form-group > .sel {
            width: 120px;
            display: inline-block;
            
        }
    </style>
    
    
</head>

<body>
 	<jsp:include page="/include/header.jsp"/>
    

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2>회원가입<small>(가운데정렬)</small></h2>

                    <form action="joinForm.user" name="joinForm" method="post">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" name="id" placeholder="아이디를 (영문포함 4~12자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" name="pw" placeholder="비밀번호 (영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="pw_confrim">비밀번호 확인</label>
                            <input type="password" class="form-control" name="pw_confrim" placeholder="비밀번호를 확인해주세요.">
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" name="name" placeholder="이름을 입력하세요.">
                        </div>
                        <!--input2탭의 input-addon을 가져온다 -->
                        <div class="form-group">
                            <label for="hp">휴대폰번호</label><br>
                            
                            <input class="form-control sel" placeholder="010" name="phone1"> -
                            <input class="form-control sel" placeholder="xxxx" name="phone2"> -
                            <input class="form-control sel" placeholder="xxxx" name="phone3">
                        
                        </div>
                        <div class="form-group">
                             <label for="hp">이메일</label><br>
                            <input class="form-control sel" name="email1">@
                            <select class="form-control sel" name="email2">
                                <option value="naver.com">naver.com</option>
                                <option value="gmail.com">gmail.com</option>
                                <option value="daum.net">daum.net</option>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <input type="text" class="form-control" name="addr_basic" placeholder="기본주소">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="addr_detail" placeholder="상세주소">
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="join_check()">회원가입</button>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="location.href='login.user'">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </section>

    <jsp:include page="/include/footer.jsp"/>

	<script>
		function join_check(){
			
			var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;
			var v = /^[A-z]+[A-z0-9]{4,12}$/g;
			
			if(document.joinForm.id.value.length < 4 | document.joinForm.id.value.length > 12){
				alert('아이디는 4글자 이상, 12글자 이하만 가능합니다');
				return false;
			}else if(!v.test(document.joinForm.id.value)){
				alert('아이디는 영문과 숫자가 포함되어야합니다');
				return false;
			}else if(document.joinForm.pw.value.length < 8){
				alert('비밀번호는 8글자 이상만 가능합니다');
				return false;
			}else if(!v.test(document.joinForm.pw.value) && !regExp.test(document.joinForm.pw.value)){
				alert('비밀번호는 영문, 숫자, 특수문자가 모두 포함되어야합니다');
				return false;
			}else if(document.joinForm.pw.value != document.joinForm.pw_confrim.value){
				alert('비밀번호 확인란을 확인하세요');
				return false;
			}else if(document.joinForm.name.value == ''){
				alert('이름은 필수항목입니다');
				return false;
			}else if(confirm('회원가입을 하시겠습니까?')){
				joinForm.submit();
			}
			
		} 
	
	</script>

</body>

</html>