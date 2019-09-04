<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>원글삭제-boardDelete.jsp</h2>
 <%-- 성공(change==1)과 실패(change==0)에 따라 유저에게 각각의 메세지를 제공한 후
 			글목록보기로 넘어간다
 			request.setAttribute("nowPage", nowPage);
 			request.setAttribute("CHANGE", change);
      /reboard/boardList.bo?nowPage=
  --%>
  <c:if test="${CHANGE eq 1}">
  	<script>
  	alert("회원이 탈퇴처리되었어요");
  	</script>
  </c:if>
  
  <c:if test="${CHANGE eq 0}">
  	<script>
  	alert("회원 탈퇴 실패");
  	</script>
  </c:if>
 
  <%--sendRedirect하면 위의 메세지를 보여주지 않는다 --%>
  <script>
  	location.href="../member/MemberList.ho?nowPage=${nowPage}"	
  </script>	
  	
</body>
</html>






