<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>

	$(document).ready(function(){
		
	
		
		//	원글수정하기 이벤트
		$("#mBtn").click(function(){
			$(location).attr("href", "../member/membermodifyFrm.ho?oriNo=${DETAIL.m_no}&nowPage=${nowPage}");
		});
		
		//	원글삭제하기 이벤트
		$("#dBtn").click(function(){
			//prompt통해 비밀번호입력받기
			
			//글삭제요청으로 보낸다
			// <a href="~~~~?파라미터명=data"
			// window.location.href="~~~~?파라미터명=data"		
			// $(location).attr("href","~~~~?파라미터명=data")		==>get방식처럼 주소표시줄에노출
			// 비번, 개인정보, 많은 양의 데이터는 form post 방식으로 넘겨야한다
			/*<form id="imsiFrm" action="../reboard/boardDelete.bo" method="post">
			<input type="hidden" name="oriNo" value=""  id="imsiOriNo" />
			<input type="hidden" name="pw"    value=""  id="imsiPw"/> 
			<input type="hidden" name="nowPage" value="" id="imsiNowPage"/>*/
			
			//임시폼안의 요소에 데이터를 셋팅한다
			//$(선택자).val()						폼안의 선택요소의 값을 가져오기
			//$(선택자).val("데이터")		폼안의 선택요소에 값을 설정하기
			
			//서브밋
			$("#imsiFrm").submit();
			
		});
		
		//	목록보기 이벤트
		$("#lBtn").click(function(){
			//$(객체).attr("속성명")  		 => 해당객체의 속성값을 가져오기
			//$(객체).attr("속성명", 값)  => 해당객체의 속성값을 설정하기
			//자바스크립트에서의   location.href="../reboard/boardList.bo?nowPage=${nowPage}"
			$(location).attr("href", "../member/MemberList.ho?nowPage=${nowPage}");
		});
		
	

	});
</script>
</head>
<body>
<a href="../index.jsp">메인</a>
	<h2>(원글)상세보기화면-boardDetail.jsp</h2>
	<%-- request.setAttribute("DETAIL",vo);     //원글상세내용
  		 request.setAttribute("nowPage",nowPage);//보고싶은페이지(릴레이용)
  		 request.setAttribute("REPLY",list1);   //댓글내용
	 --%>
	<%
		String  oriNo  = request.getParameter("oriNo");  	//해당게시물번호
		String  nowPage= request.getParameter("nowPage"); //보고싶은페이지(릴레이용)
	%>
	DETAIL=${DETAIL}<br/>
  nowPage=${nowPage}<br/>
  REPLY=${REPLY}
  
	<%--	1.	상세보기 내용 보여주기 --%>
	<table width="700" border="1" align="center">
		<tr>
			<td>회원번호</td>
			<td>${DETAIL.m_no}</td>
			<td>아이디</td>
			<td>${DETAIL.m_id}</td>
			<td>공란</td>
			<td>공란</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${DETAIL.m_name}</td>
			<td>등급</td>
			<td>${DETAIL.m_level}</td>
			<td>이메일</td>
			<td>${DETAIL.m_email}</td>
		</tr>
	
	</table>
	<%--	2.	기타 부가 기능 만들기(목록보기, 삭제하기, 수정하기...) --%>
	<table width="700" border="1" align="center">
		<tr>
			<td align="center">
				<input type="button" id="lBtn" value="목록보기"/>
				<%-- 로그인한 유저만  작성자의 글에대해 수정, 삭제가능 --%>
				<c:if test="${sessionScope.UID  eq DETAIL.writer}">	
					<input type="button" id="mBtn" value="원글수정하기"/>
					<input type="button" id="dBtn" value="원글삭제하기"/>
				</c:if>	
			</td>
		</tr>
	</table>	
	
	<%-- 원글삭제를 위한 임시폼 --%>
	<form id="imsiFrm" action="../member/memberDelete.ho" method="post">
		<input type="hidden" name="oriNo" value="${DETAIL.m_no}"  id="imsiOriNo" />
		<input type="hidden" name="nowPage" value="${nowPage}" id="imsiNowPage"/>
	</form>
	
	

</body>
</html>







