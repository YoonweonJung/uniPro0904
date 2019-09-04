<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	int a = (int) (Math.floor(Math.random() * 8999) + 1000);
	//String email = request.getParameter("email");
%>


<script type="text/javascript">
	window.onload = function getParentText() {
		window.opener.somFunc(
<%=a%>
	);
		document.getElementById("email").value = opener.document
				.getElementById("m_email").value;
		document.getElementById('mailSendForm').submit();

	}
</script>

</head>
<body>
	<div class="container">

		<h4>이메일 인증</h4>


		<form id="mailSendForm" class="form-horizontal" action="mailSend.jsp"
			method="post">

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">


					<input name="email" id="email"> <input type="hidden"
						name="subject" value="평화나라 회원가입 인증메일입니다."> <input
						type="hidden" name="from" value="gaul91@naver.com"> <input
						type="hidden" name="authorization_code" value="<%=a%>"> <input
						type="hidden" name="ID_or_PW" value="ID">

					<!-- 완성 후 삭제 -->
					<br />
					<br />변수 확인 공간<br /> authorization_code =
					<%=a%>




				</div>
			</div>
		</form>
	</div>


</body>
</html>





