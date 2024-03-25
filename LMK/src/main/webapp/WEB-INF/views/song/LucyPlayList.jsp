<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LUCY PLAYLIST</title>
</head>
<body>

	<h3 style="color : hotpink"> == 듣고 싶은 <%= request.getParameter("singerList") %>의 노래를 선택해주세요 == </h3>
	<b>======================================================================</b>

	<h1> [== playlist_song == ]</h1>

    <form action ="/music/LUCY" method="get">
        가수 : <select  name="SongList" value ="LUCY" >
                    <option>1. 애정표현 </option>
                    <option>2. 아니 근데 진짜 </option>
                    <option>3. 결국 아무것도 알 수 없었지만 </option>
                    <option>4. 놀이 </option>
                    <option>5. 히어로</option>
               </select>
        <br><br>
        <button>PLAYLIST 만들기</button>
    </form>
</body>
</html>