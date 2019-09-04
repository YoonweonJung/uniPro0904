<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글쓰기처리</h2>
	<p>writeProc.jsp</p>
	
	<%
		//글쓰기처리가 완료되면 글목록보기페이지로 강제 이동할 예정이다
		//현재 페이지writeProc.jsp의 URL은  http://localhost/uri/reboard/writeProc.bo
		//URL을 기준으로 하여 글쓰기요청을 지정
		//(기준)       : http://localhost/uri/reboard/writeProc.bo
		//글목록요청주소  : http://localhost/uri/reboard/boardList.bo
		//요간의 상대경로를 지정
		
		
		
		//response.sendRedirect("../reboard/boardList.ho"); //이거 나중에 살려야 함
	%>
	
	<h1>글쓰기 완료</h1>
</body>
</html>



