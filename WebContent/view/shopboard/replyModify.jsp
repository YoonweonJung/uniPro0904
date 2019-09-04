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
	<h2>댓글수정처리 페이지-replyModify.jsp</h2>
	<%--request.setAttribute("oriNo",   oriNo);   //댓글에 대한 원글번호
	    request.setAttribute("nowPage", nowPage); //보고싶은페이지(릴레이용) --%>
	oriNo=${oriNo } / nowPage=${nowPage}
	<c:redirect url="../reboard/boardDetail.bo">
		<c:param name="oriNo"   value="${oriNo}"/>
		<c:param name="nowPage" value="${nowPage}"/>
	</c:redirect>    
</body>
</html>


