<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 에러페이지임을 알려주는  isErrorPage=ture  --%>    
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error/err.jsp</title>
</head>
<body>
	<%-- jsp주석문 --%>
	<%-- 이 문서는 에러가 발생한 경우   에러발생한 해당페이지 
	          대신에 보여줄 문서입니다--%>
	<h2>잠시후 다시 시도해보세요</h2>
	<p>계속해서 이 페이지가 보이면 관리자에게 문의하세요</p>
	
	<hr/>
	<!-- 브라우저에 에러타입과 메세지출력하기위해서 exception내장객체를 사용
			 주의. page지시어에  isErrorPage="true"를 지정한다.
			 교재 p144  
	-->
	<p>에러타입  :  <%= exception.getClass().getName() %></p>           
	<p>에러메세지 : <%= exception.getMessage() %></p>
</body>
</html>




