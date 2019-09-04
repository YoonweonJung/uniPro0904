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
%>
</head>

<style>
.my_box {
	border: 1px solid;
	padding: 20px;
	border-color: #bec1d1;
}

</style>



<body>
	<div class="container">
		<div class="my_box">
			<div style='text-align:center'><h4>이메일 인증</h4></div>
			<form class="form-horizontal" action="compare_DB_Proc.jsp"
				method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="input_name">이름 :</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="input_name"
							placeholder="Enter name" name="name">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="input_email">이메일
						:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="input_email"
							placeholder="Enter email" name="email">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">



						<input type="hidden" name="subject" value="평화나라 ID찾기 인증메일입니다.">
						<input type="hidden" name="from" value="gaul91@naver.com">

						<input type="hidden" name="authorization_code" value="<%=a%>">
						<input type="hidden" name="ID_or_PW" value="ID">
						<button type="submit" class="btn btn-default">메일 전송</button>

						<!-- 삭제 -->
						<br /> <br />변수 확인 공간<br /> authorization_code =
						<%=a%>




					</div>
				</div>
			</form>
		</div>
	</div>



</body>
</html>