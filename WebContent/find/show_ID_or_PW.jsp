<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%


	String ID_or_PW = request.getParameter("ID_or_PW");
	String email = request.getParameter("email");
	String name = request.getParameter("name");

	String U_id = (String) session.getAttribute("U_id");
	String U_pw = (String) session.getAttribute("U_pw");
	String U_name = (String) session.getAttribute("U_name");
	
%>
<style>
.my_box {
	border: 1px solid;
	padding: 20px;
	border-color: #bec1d1;
}

</style>
</head>
<body>
<div>
	<div class="container">
	<div class="my_box">
		<form class="form-horizontal" action="index.jsp" method="post">
	
				<%				
				if(ID_or_PW.equals("ID")){				
				%>
				<%=name%>님이 찾으신 정보는 다음과 같습니다. <br/>
				ID : <%=U_id%>
				<%
				} else if(ID_or_PW.equals("PW")) {
				%>
				<%=name%>님이 찾으신 정보는 다음과 같습니다. <br/>
				ID : <%=U_id%> <br>
				ID : <%=U_pw%>
				<%
				} else {
				%>
				ID_or_PW 값이 적절하지 않습니다. <br>
				ID_or_PW = <%=ID_or_PW%>
				<%
				}
				%>	


				
				

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">



					<button type="submit" class="btn btn-default">홈으로</button>

				</div>
			</div>

			<!-- 완성 후 삭제 -->
			<br />
			<br />변수 확인 공간<br /> ID_or_PW =
			<%=ID_or_PW%><br> email =
			<%=email%>
			<br> name =
			<%=name%>
			<br>

		</form>
	</div>
</div>
</div>
</body>
</html>
