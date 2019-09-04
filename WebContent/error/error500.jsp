<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 에러페이지임을 알려주는  isErrorPage=ture  --%>    
<%@ page isErrorPage="true" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error500</title>
</head>
<body>
	<h2>error500.jsp</h2>
	<p>500(내부 서버 오류): 서버에 오류가 발생하여 요청을 수행할 수 없어요.</p>
	<p>에러타입  :  <%= exception.getClass().getName() %></p>           
	<p>에러메세지 : <%= exception.getMessage() %></p>
</body>
</html>