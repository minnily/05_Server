<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>곡 선택</title>
</head>
<body>

	<%-- [JSP용 주석!] --%>
	<%--
	 
	✔ <%@ %> : 지시자 태그 (▷ JSP 페이지의 전반적 속성을 설정하는데 사용하는 태그)
	✔ <% %>  : 스크립틀릿 ▷ 자바코드 작성
	✔ <%= %> : JSP 표현식 ▷ 자바, 서버에서 받아온 값을 표현(출력)할때 사용
	✔ JSP (Java Server Page) ? Java코드가 들어가있는 HTML 코드

	--%>
	
	

	<h3 style="color : hotpink"> == 듣고 싶은 <%= request.getParameter("singerList") %>의 노래를 선택해주세요 == </h3>

	<hr>
	
	<% if(request.getParameter("singerList").equals("1. DAY6")) { %>
			<%= request.getParameter("/song1") %>
	<% } else if(request.getParameter("singerList").equals("2. LUCY")) {%>
   			<%= request.getParameter("/song2") %>
		<% } else if(request.getParameter("singerList").equals("3. JANNABI")) {%>
			<%= request.getParameter("/song3") %>
		<% }  else {%>
			<h1 style ="color:red">Error</h1>	
			<img src="/error.jpg">
		<% } %>
    
	
	
</body>
</html>