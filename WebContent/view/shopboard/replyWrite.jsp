<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<%--
	  (댓글)입력-replyWrite.jsp
	  request.setAttribute("oriNo", oriNo);//댓글에 대한 원글번호
		request.setAttribute("nowPage", nowPage);//보고싶은페이지(릴레이용)
	 --%>
	<c:redirect url="../reboard/boardDetail.bo">
		<c:param name="oriNo"   value="${oriNo}" />
		<c:param name="nowPage" value="${nowPage}" />
	</c:redirect>
</body>
</html>





