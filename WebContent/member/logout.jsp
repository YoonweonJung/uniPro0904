<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<% //세션에 저장된 모든 세션속성이름을 삭제
		session.invalidate();
	%>
	<h2>로그아웃 되셨습니다</h2>
	<a href="../index.jsp">메인으로 가기</a>
</body>
</html>