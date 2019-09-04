<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>원글수정처리페이지</h2>
	<p>modifyProc.jsp</p>
	 <%-- <c:redirect url"이동할페이지"></c:redirect>
		response.sendRedirect("이동할페이지"); 와 동일한 의미
		만약 파라미터가 같이 넘어가면
		<c:redirect url"이동할페이지">
		<c:param name="파라미터명" value"데이터"/>
		<c:param name="파라미터명" value"데이터"/>
		</c:redirect --%>> 

	<c:redirect url="shopBoardDetail.ho">
		<c:param name="oriNo"   value="${oriNo}"/>
		<c:param name="nowPage" value="${nowPage}"/>
	</c:redirect>
	
	
</body>
</html>