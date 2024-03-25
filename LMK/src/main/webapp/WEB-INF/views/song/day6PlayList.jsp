<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAY6 PLAYLIST</title>
</head>
<body>

	<h3 style="color : hotpink"> == 듣고 싶은 <%= request.getParameter("singerList") %>의 노래를 선택해주세요 == </h3>
	<b>======================================================================</b>
	
	<h1> [== playlist_song == ]</h1>

    <form action ="/music/Day6" method="get">
        가수 : <select name="SongList" value ="DAY6" >
                    <option>1. 놓아 놓아 놓아 </option>
                    <option>2. 좋아합니다</option>
                    <option>3. 한페이지가 될 수 있게</option>
                    <option>4. Zombie</option>
                    <option>5. 예뻤어</option>
               </select>
        <br><br>
        <button>PLAYLIST 만들기</button>
    </form>
</body>
</html>