<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<title>회원가입 화면</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
var openWin;

function openChild()
{
    // window.name = "부모창 이름"; 
    window.name = "parentForm";
    // window.open("open할 window", "자식창 이름", "팝업창 옵션");
    var ret = window.open("../temp.jsp",
            "childForm", "width=570, height=350, resizable = no, scrollbars = no");    
}

function setChildText(){
    openWin.document.getElementById("email").value = document.getElementById("m_email").value;
}

var code ="999999";
function somFunc(data) {
	code = data;
	alert(data);
}

var pass ="";

$(document).ready(function(){

	// 입력란에 입력을 하면 입력내용에 내용이 출력

	// 1. #m_check 공간에서 keyup이라는 이벤트가 발생했을 때

	$("#m_check").keyup(
			function(){
			
				var f = document.join_form;
				if(f.m_check.value == code){
					f.str.value = "인증되었습니다."
					pass = 1;
				}
		// 2. #out 공간에 #str의 내용이 출력된다.
		$("#out").text($("#str").val());

		// #out의 위치에 text로 데이터를 받는다.(setter)

		// 들어가는 데이터는 #data의 값(.val())이다. (getter)

		// 메서드 괄호 안에 아무것도 없으면 getter, 파라미터가 있으면 setter이다.

	});

	//~~~
	$("#join_button").click(function(){

		if(pass == 1){
			$("#join_form").submit();
		}else{
			alert("메일을 인증해주세요.");
		}	
		
	});


});


</script>

</head>
<body>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li class="active"><a href="../../member/joinPro.ho">회원가입</a></li>						
						<li class="active"><a href="../find/find_ID.jsp">ID찾기</a></li>
						<li class="active"><a href="../find/find_PW.jsp">PW찾기</a></li>
					</ul></li>
			</ul>
	<div class="container">
		<div class="col-lg-16"></div>
		<div class="col-lg-16">
			<div class="jumbotron" style="text-align: center;">
				<form id="join_form" name="join_form" method="post" action="joinProc.jsp">
				<input type="hidden" name="email">
				<input type="hidden" name ="str" id="str" value="인증번호를 적어주세요.">
				
				
					<h3 style="text-align: center;"><br/><br/><br/>회원가입 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="닉네임"
							name="m_nick" maxlength="50">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							name="m_id" maxlength="50">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							name="m_pw" maxlength="100">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="프로필 사진"
							name="m_img" maxlength="100">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="이름"
							name="m_name" maxlength="50">
					</div>
					     <div class="form-group">
						<input type="email" class="form-control" placeholder="이메일"
							name="m_email" maxlength="50" id="m_email"> 
							<br/>
							<button type="button" onclick="openChild()">
							인증하기
							</button>
					</div>
					<div class="form-group">
						<input type="tel" class="form-control" placeholder="인증번호"
							name="m_check" id="m_check" maxlength="20" > 
							
							<div id="out"></div>
							
						<!-- <script type="text/javascript">document.write(str);</script>-->
						
					</div>
					<div class="form-group">
						<input type="tel" class="form-control" placeholder="폰번호"
							name="m_hp" maxlength="20">
					</div>
				<div class="form-group">
						<input type="text" class="form-control" placeholder="생일(ex)19911125)"
							name="m_birthday" maxlength="10">
					</div>
				<div class="form-group">
						<input type="text" class="form-control" placeholder="시"
							name="m_addsi" maxlength="200">
					</div>
				<div class="form-group">
						<input type="text" class="form-control" placeholder="군구"
							name="m_addgun" maxlength="200">
					</div>
				<div class="form-group">
						<input type="text" class="form-control" placeholder="읍면동+상세주소"
							name="m_addetc" maxlength="200">
					</div>
					
					
					<div class="form-group" style="text-align: center;">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary active"> <input
								type="radio" name="m_gender" autocomplete="off" value="남"
								checked>남자
							</label> <label class="btn btn-primary"> <input type="radio"
								name="m_gender" autocomplete="off" value="여">여자
							</label>
						</div>
					</div>
					<input type="button" id="join_button" class="btn btn-primary form-control"value="회원가입" >
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>

</body>
</html>
