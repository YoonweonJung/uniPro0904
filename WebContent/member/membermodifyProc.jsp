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
  <h2>원글수정처리 페이지</h2>
	<p>modifyProc.jsp</p>
	<%--
		request.setAttribute("oriNo", oriNo);
		request.setAttribute("nowPage", nowPage);
		강제로 상세보기로 이동하므로 페이지가 보여서는 안된다
		response.sendRedirect("이동할페이지");
	 --%>
	<c:redirect url="../member/MemberList.ho">
		<c:param name="oriNo"   value="${oriNo}"/>
		<c:param name="nowPage" value="${nowPage}"/>
	</c:redirect>
</body>
</html>





