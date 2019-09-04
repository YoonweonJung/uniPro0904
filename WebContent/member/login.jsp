<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<title>로그인 </title>
</head>
<body>
	<%
		/*세션에 정보저장할 때
		session.setAttribute("UID",  "hongid");
		session.setAttribute("UNICK","의적");  */
		
		//세션에서 데이터를 꺼내보자 
   	    String id	  =(String)session.getAttribute("m_id");
	   	String pw	=(String)session.getAttribute("m_pw");
	   	String nick	=(String)session.getAttribute("m_nick");
	   	
	   	
		
		if( id==null || id.length()==0 ){  //데이터가 null이면 로그인x 
	%>
	<br/><br/><br/><br/>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="text-align: center;">
				<form method="post" action="loginAction.jsp">
					<table border="1" width="500" >
					<h3 style="text-align: center;">로그인 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"	name="userID" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인">
					</table>
				</form>
				
				<%
		}else{
				%>

			</div>
		</div>
	<div class="col-lg-4"></div>
	</div>


	<%
		}
	%>	

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>
