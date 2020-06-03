<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    
</head>
<body>
 	<jsp:include page="/include/header.jsp"/>

<section>
        <div class="container">
            <div class="row join-wrap">
                <!--join-form을 적용한다 float해제 margin:0 auto-->
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER INFO                    
                    </div>
                    
                    <p>*표시는 필수 입력 표시입니다</p>
                    <form action="infoForm.user" name="regForm" method="post">
                    <table class="table">
                        <tbody class="m-control">
                            <tr>
                                <td class="m-title">*ID</td>
                                <td><input class="form-control input-sm" value="${infoVO.id}" readonly></td>
                            </tr>
                            <tr>
                                <td class="m-title">*이름</td>
                                <td><input class="form-control input-sm" value="${infoVO.name}" name="name"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호</td>
                                <td><input type="password" class="form-control input-sm" name="pw"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호확인</td>
                                <td><input type="password" class="form-control input-sm" name="pw_check"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*E-mail</td>
                                <td>
                                    <input class="form-control input-sm" value="${infoVO.email1}" name="email1">@
                                    <select class="form-control input-sm sel" value="${infoVO.email2}" name="email2">
                                        <option value="naver.com">naver.com</option>
                                        <option value="gmail.com">gmail.com</option>
                                        <option value="daum.net">daum.net</option>
                                    </select>
                                    <button class="btn btn-info">중복확인</button>
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*휴대폰</td>
                                <td>
                                    <input class="form-control input-sm sel" value="${infoVO.phone1}" name="phone1"> -
                                    <input class="form-control input-sm sel" value="${infoVO.phone2}" name="phone2"> -
                                    <input class="form-control input-sm sel" value="${infoVO.phone3}" name="phone3">
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*주소</td>
                                <td><input class="form-control input-sm add" value="${infoVO.addr_basic}" name="addr_basic"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*상세주소</td>
                                <td><input class="form-control input-sm add" value="${infoVO.addr_detail}" name="addr_detail"></td>
                            </tr>
                        </tbody>
                    </table>
                    </form>
                    <div class="titlefoot">
                        <button class="btn" type="button" onclick="info_check()">수정</button>
                        <button class="btn">목록</button>
                    </div>
                    
                </div>


            </div>

        </div>

    </section>
    
    <jsp:include page="/include/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script>
    	function info_check(){
    		
    		if(document.regForm.name.value == ''){
    			alert("이름을 입력하세요");
    			document.regForm.name.focus();
    			return false;
    		}else if(document.regForm.pw.value == ''){
    			alert("비밀번호를 입력하세요");
    			document.regForm.pw.focus();
    			return false;
    		}else if(document.regForm.pw.value != document.regForm.pw_check.value){
    			alert("비밀번호 확인란을 확인하세요");
    			document.regForm.pw_check.focus();
    			return false;
    		}else if(document.regForm.email1.value == ''){
    			alert("이메일을 입력하세요");
    			document.regForm.email1.focus();
    			return false;
    		}else if(document.regForm.phone1.value == ''){
    			alert("휴대폰 번호를 입력하세요");
    			document.regForm.phone1.focus();
    			return false;
    		}else if(document.regForm.phone2.value == ''){
    			alert("휴대폰 번호를 입력하세요");
    			document.regForm.phone2.focus();
    			return false;
    		}else if(document.regForm.phone3.value == ''){
    			alert("휴대폰 번호를 입력하세요");
    			document.regForm.phone3.focus();
    			return false;
    		}else if(document.regForm.addr_basic.value == ''){
    			alert("주소를 입력하세요");
    			document.regForm.addr_basic.focus();
    			return false;
    		}else if(document.regForm.addr_detail.value == ''){
    			alert("상세주소를 입력하세요");
    			document.regForm.addr_detail.focus();
    			return false;
    		}else if(confirm('수정하시겠습니까?')){
    			regForm.submit();
    		}
    		
    	}
    
    </script>
</body>
</html>