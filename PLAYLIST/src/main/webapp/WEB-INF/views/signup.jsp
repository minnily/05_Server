<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	  
	<link rel="stylesheet" href="/resources/css/mainr.css">
</head>
<body>
	
	
	<main>	
		<h1>회원가입</h1>
		
		<form action="/signup" method="post" class="signup-form"  onsubmit="return validate()">
			<p>아이디</p>
			<input type="text" name="id" id="id" autocomplete="off" required>
			<span id="idMsg">영어 소문자, 숫자, 특수문자(!@#$%^&*_-)가능</span>
			
			<p>비밀번호</p>
			<input type="password" name="pw" id="pw" required>
			
			<p>비밀번호 확인</p>
			<input type="password" name="pw2" id="pw2" required>
			<span id="pwMessage"></span>
			
			<p>닉네임</p>
			<input type="text" name="nickName" id="nickName" required>
			<span id="nameMessage"></span>
			<br>
			
			<p>성별</p>
			<label>남
			<input type="radio" name="gender" value="M" id="gender" required>
			</label>
			<label>여
			<input type="radio" name="gender"  value="F" id="gender" required>
			</label>	
			<span id="genderMessage"></span>
			<br>
			<br>
			<button>가입하기</button>
		</form>
	
	</main>		
	<%-- 해당 jsp 파일에서 사용할 javascript 코드가 작성된 js 파일 연결하기 --%>
	<script src="/resources/js/signup.js"></script>
	
	
	
	
	
	
	
</body>
</html>