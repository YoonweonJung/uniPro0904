<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기폼</title>
<script>
	//글등록클릭시 호출
	function WriteProc() {
		//무결성검사
		//예정~~~

		//폼객체.submit();
		document.getElementById("wfrm").submit();
	}
</script>
</head>
<body>
	<h2>원글 쓰기</h2>
	<p>writeFrm.jsp</p>
	<form method="POST" id="wfrm" action="shopWriteProc.ho"
		name="myform" enctype="multipart/form-data>
 	
<form method="POST" ">

		<table width="800" border="1" align="center">
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
				<td id="title">파일첨부</td>
				<td><input type="file" name="board_file" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center" />
				<input type="button" id="wbtn" value="글등록" onClick="WriteProc()" />
				<%--	필요하면 다른 단추도 만들어서 사용 --%>
				</td>
				
			</tr>
		</table>
	</form>
</body>
</html>
















