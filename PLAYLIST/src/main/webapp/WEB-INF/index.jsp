<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="/resources/css/main.css">
	<title>PLAYLIST</title>
</head>
<body>
	
	<main>

		<c:choose>
			<c:when test="${empty sessionScope.~}">

				<section>
					<h1>Today's Playlist</h1>
		
					<form>
						<h3>나만의 playList를 만들어보세요</h3>
						<img src="/img/playlist_img2.jpg">
					</form>	
				</section>

				<section>
					<form action="/selectlist" method="post" class="login-form">
						<div>
							<p>아이디</p>
							<input type="text" name="Id">
						</div>
						<div>
							<p>패스워드</p>
							<input type="password" name="Pw">
						</div>
						
						<button>로그인</button>
						
						<a href="/signup" class="signup">회원가입</a>
					</form>
				</section>
			</c:when>

			<c:otherwise>
				<h1>${sessionScope.~.~}님 반갑습니다. </h1>
				<h1>플레이리스트를 조회 하시겠습니까?</h1>
				
				<table>
					<tr>
						<td><img src="/img/playlist_img1.jpg"></td>
						<td><a href="/select?todoNo=${todo.todoNo}" class="select-btn">조회하기</a></td>
						<td><a href="/" class="cancle-btn"> 이전으로 </a></td>
					</tr>
				</table>

			</c:otherwise>

		</c:choose>



	</main>
	
	
	
	
</body>
</html>