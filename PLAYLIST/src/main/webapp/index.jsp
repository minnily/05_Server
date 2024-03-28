<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/resources/css/mainr.css">
	<script src="https://kit.fontawesome.com/a8682ddafd.js" crossorigin="anonymous"></script>
	<title>PLAYLIST</title>
</head>
<body>
	
	<header>
		<section>
			<a href="/">
				<i class="fa-solid fa-headphones"></i>
			</a>
		</section>
		
		<section>
			<form>
				<a href=https://www.youtube.com/results?search_query=%EC%98%A4%EB%8A%98%EC%9D%98+%EB%85%B8%EB%9E%98+%EC%B6%94%EC%B2%9C+>
					<input type = "search" placeholder="오늘의 추천 playlist를 검색해보세요" class="search"></a>
			</form>
		</section>
	</header>

	<main>
		<%-- 로그인 전 보여지는 화면 --%>
		<c:choose>
			<c:when test="${empty sessionScope.loginMember}">

				<section>
					<h1>Today's PlayList</h1>
		
					<form>
						<h3>나만의 playList를 만들어보세요</h3><br>
						<img src="/resources/img/음반사진1.jpg" id="mainphoto">
					</form>	
				</section>

				<section>
					<form action="/login" method="post" class="login-form">
						<div>
							<p>아이디</p>
							<input type="text" name="id">
						</div>
						<div>
							<p>패스워드</p>
							<input type="password" name="pw">
						</div>
						
						<button>로그인</button>
						
						<a href="/signup" class="signup">회원가입</a>
						<br><br>
						<br>
						<p>로그인 후 이용 가능합니다</p>
					</form>
				</section>
			</c:when>
			
			<%-- 로그인 후 보여지는 화면 --%>
			<c:otherwise>
					
					<div>
						<section>
						<h1>▶ ${sessionScope.loginMember.nickName} 님의 PLAYLIST</h1>
						<img src="/resources/img/playlist_img1.jpg">
						</section>
						<section>
						<a href="/select?no=${playList.playListNo}" class="select-btn"><i class="fa-solid fa-clipboard-list"></i> 조회하기</a>
						<br>
						<a href="/logout" class="logout-btn"><i class="fa-solid fa-right-from-bracket"></i>로그아웃</a>
						</section>
					</div>
			</c:otherwise>
			
			<%--조회하기 이후 보여지는 화면 --%>
			<c:choose>
				<c:choose>
				<%-- 조회할 플레이리스트가 없을 때 --%>
					<c:when test="${empty playListNo}">
						<table>
							<tr>
								<td>
								등록된 음악이 없습니다
								</td>
							</tr>
						</table>
					</c:when>
					
					<c:otherwise>
						<c:forEach var ="playList" items="${playList}">
							<tr>
								<td>${playList.singer}</td>
								<td>${playList.song}</td>
								<td>${playList.releaseDate}</td>
								<td>${playList.genre}</td>
								<td><a href="/delete?playListNo=${playList.platListNo}"  onclick="return confirm('해당 노래를 삭제하시겠습니까?')" class = "delete-btn">
										<i class="fa-regular fa-square-minus"></i></a>삭제</td>
							</tr>
						</c:forEach>
					</c:otherwise>
					
						
				</c:choose>
				
			</c:choose>
			
		</c:choose>
	</main>
	
	<c:if test="${not empty sessionScope.message}">
		
		<script>
			// EL/JSTL 구문이 자바스크립트보다 먼저 해석되는데
			// 문자열이 들어가있는 데이터의 경우
			//	따옴표가 없는 상태이니 붙여줘야한다!
			alert('${message}');
		</script>
	
		<%-- 
			session에 message를 추가하면
			브라우저 종료 또는 만료전까지 계속 메시지가 출력된다
			-> 1회 출력 후 session에서 message 삭제
		 --%>
		 <c:remove var="message" scope="session" />
	
	</c:if>
	
	
</body>
</html>