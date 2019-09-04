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
String code = request.getParameter("authorization_code");
String ID_or_PW = request.getParameter("ID_or_PW");
String email = request.getParameter("email");
String name = request.getParameter("name");

String U_id = (String) session.getAttribute("U_id");
String U_pw = (String) session.getAttribute("U_pw");
String U_name = (String) session.getAttribute("U_name");

%>
<script>
function button1_click() {	
	var uu = document.compare_form;
	//alert("uu.user_input_num.value = " +uu.user_input_num.value);
	//alert("uu.authorization_code.value = " + uu.authorization_code.value);	
	if(+uu.user_input_num.value == uu.authorization_code.value)
		$('#compare_form').submit();
	else
		alert("인증번호가 틀립니다.");
}



</script>
<style>
.my_box {
	border: 1px solid;
	padding: 20px;
	border-color: #bec1d1;
}

</style>

</head>


<body>
	<div class="container">
	<div class ="my_box">


		<form id="compare_form" name="compare_form"  action = "show_ID_or_PW_LoadProc.jsp" class="form-horizontal" method="post">

			<div class="form-group">
				<label class="control-label col-sm-2" for="input_ID">인증번호 : </label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="user_input_num" placeholder="4자리 숫자" name="user_input_num">						
					<input type="hidden" name = "ID_or_PW" value = <%=ID_or_PW %>>
					<input type="hidden" name ="authorization_code" value = <%=code%>>
					<input type="hidden" name = "email" value = <%=email %>>
					<input type="hidden" name ="name" value = <%=name%>>
				</div>
			</div>
		
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				

					<button type="button" id="button1" onclick="button1_click();">인증</button>

					<!-- 완성 시 삭제 -->
					<br><br><br>
					변수 확인 공간 <br>
					
					authorization_code = <%=code%> <br>
					ID_or_PW = <%=ID_or_PW%><br>
					email = <%=email%> <br>
					name = <%=name %> <br>
					u_id = <%=U_id %> <br>
					u_pw = <%=U_pw %> <br>
					u_name = <%=U_name %> <br>
					
				</div>
			</div>
		</form>
	</div></div>


</body>
</html>
