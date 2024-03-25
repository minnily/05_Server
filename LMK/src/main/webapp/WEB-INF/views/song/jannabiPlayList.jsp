<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JANABI PLAY LIST</title>
</head>
<body>

	<h3 style="color : hotpink"> == 듣고 싶은 <%= request.getParameter("singerList") %>의 노래를 선택해주세요 == </h3>
	<b>======================================================================</b>

	<h1> [== playlist_song == ]</h1>

    <form action ="/music/JANABI" method="get">
        가수 : <select  name="SongList" value ="JANNABI" >
                    <option>1. 그 밤 그 밤 </option>
                    <option>2. 주저하는 연인들을 위해 </option>
                    <option>3. she </option>
                    <option>4. November Rain </option>
                    <option>5. 여름가을겨울 봄.</option>
               </select>
        <br><br>
        <button>PLAYLIST 만들기</button>
    </form>
</body>
</html>