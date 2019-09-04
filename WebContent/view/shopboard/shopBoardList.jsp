<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체목록</title>
<script>
	//id="btnWrite" value="글쓰기"
	//글쓰기 클릭시 글입력폼보기 요청
	function writeFrm(){
		//자바스크립트에서 새로운 요청하기 방법
		location.href = "writeFrm.ho";
	}
	
</script>
</head>
<body>
	<h2>목록</h2>
	<p>boardList.jsp</p>
	<%--
		컨트롤러가 준 모델을 받아서 화면에 출력
		request.setAttribute("LIST", list);
		request.setAttribute("PINFO", pageInfo );//페이징처리를 위한 페이지정보
	 --%>
	 ${PINFO }
	<%-- 목록보기 리스트 출력  --%>
	<table border="1" width="700">
		<caption>목록</caption>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>댓글수</th>
			</tr>
		</thead>
		<tbody>
		 <%-- <c:forEach var="변수명" items="모델키값">  --%>
			<c:forEach var="temp" items="${LIST}">
				<%--반복문 한번돌때마다 ReboardVO객체가 temp에 담긴다  --%>
				<tr>
					<td>${temp.no} </td>
					<td><a href="../reboard/boardDetail.bo?oriNo=${temp.no}&nowPage=${PINFO.nowPage}">${temp.title}</a></td>
					<td>${temp.writer }</td>
					<td>${temp.wday }</td>
					<td>${temp.hit }</td>
					<td>${temp.cnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<%-- 페이징  --%>
	<table border="1" width="700">
		<tbody>
			<tr>
				<td align="center">
					<%-- 이전[<<]메뉴로 이동--%>
					 <c:if test="${PINFO.startPage eq 1}"> [prev] </c:if> 
					 <c:if test="${PINFO.startPage ne 1}"> 
					 	<a href="../reboard/boardList.bo?nowPage=${PINFO.startPage-1}">[prev]</a> 
					 </c:if> 
					 
					 <%-- [1] [2] [3] [4] [5]출력 --%>
					 <c:forEach var="page" begin="${PINFO.startPage}" end="${PINFO.endPage}" step="1"> 
					   <a href="../reboard/boardList.bo?nowPage=${page}">[${page}]</a> 
					 </c:forEach>  
 
					 
					 <%-- 다음[>>]메뉴로 이동 --%>
					 <c:if test="${PINFO.endPage eq PINFO.totalPage}">[next]</c:if>
					 <c:if test="${PINFO.endPage ne PINFO.totalPage}"> 
					 	<a href="../reboard/boardList.bo?nowPage=${PINFO.endPage+1}">[next]</a> 
					 </c:if>
					 
				</td>
			</tr>
		</tbody>
	</table>
	
	<%-- 기타기능(글쓰기) --%> 
	<table border="1" width="700">
		<tbody>
			<tr>
				<td align="center">
					<input type="button" name="btnWrite" id="btnWrite" value="글쓰기" onclick="writeFrm();"/>
				</td>
			</tr>
		</tbody>
	</table>	 
</body>
</html>









