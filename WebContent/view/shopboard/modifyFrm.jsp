<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정폼</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		
		//id="mBtn" value="수정하기"
		$("#mBtn").on("click",function(){
			//무결성검사
			 		
			//서브밋
			$("#mfrm").submit();
		});
		
	});
</script>
</head>
<body>
<a href="../index.jsp">메인</a>
<%--  request.setAttribute("REBOARD", vo);      //원글상세내용
		  request.setAttribute("nowPage", nowPage); //보고싶은페이지(릴레이용)  --%>
 <h2>원글수정페이지-modifyFrm.jsp</h2>
 REBOARD=${REBOARD}<br/>
 nowPage=${nowPage}<br/>
	<form method="POST" action="shopModifyProc.ho" id="mfrm">
	  <%--게시물글번호, 보고싶은페이지(릴레이용)도 같이 넘겨주자 --%>
	  <input type="hidden" name="oriNo"   value="${REBOARD.no}" />
	  <input type="hidden" name="nowPage" value="${nowPage}" />
		<table width="600" border="1" align="center">
						<tr>
				<td>글제목</td>
				<td><input type="text" name="title" id="title" /></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="title" id="title" /></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><textarea name="body" id="body"></textarea></td>
			</tr>
		
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="mBtn" value="수정하기"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>