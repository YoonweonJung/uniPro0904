<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" media="all" href="https://d1unjqcospf8gs.cloudfront.net/assets/home/articles/show-f8e3b90a15d53094d2bbf38d1634d34bfd8121784e9eb560abd0bcd41ac16334.css" />
    <link rel="stylesheet" media="screen" href="https://d1unjqcospf8gs.cloudfront.net/assets/home/articles/flea_market-49a126514a2d98823e117acbef63b95d937a6edf4f28757d2213977512f0cbd3.css" />


<title>상세보기</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
		
		$("#sBtn").click(function(){
			
		});
		$(".rgBtn").click(function(){
			
		});
		$(".rbBtn").click(function(){

		});
		//	댓글 삭제단추 이벤트
		$(".rdBtn").click(function(){

			
		});
		//	댓글 수정 요청하기
		$(".modifyB").click(function(){
			/*<form method="POST" action="../reboard/replyModify.bo" 
			      style="display:none;"  id="frm${temp.no}">*/
			var frm = $(this).parents("form");      
			//해당 댓글폼.submit();
			frm.submit();      
		});
		
		
		//	댓글 수정하기
		//  댓글마다  댓글수정하기 버튼이 있으므로 선택자는 class
		$(".rmBtn").click(function(){
			//클릭한 댓글수정하기 버튼이 무엇인지부터 알아내야한다
			var button = $(this);
			
			//버튼이 속한 폼, 테이블을 알아내자...=> DOM(Document Object Model)
			//parents("찾고싶은조상요소")  조상요소를 찾아라
			var table = button.parents("table");
			
			// 선택자.attr("속성명")  선택자의 특정속성명의 값을 가져오기
			var id = table.attr("id");    //<table id="4">   <table id="3">   
			
			// 테이블감추기
			$("#"+id).hide();
			
			//숨겨진 댓글수정폼을 보이기
			//style="display:none;"  id="frm${temp.no}">
			
			$("#frm"+id).show();
			
			
		});		
		
		
		//	원글수정하기 이벤트
		$("#mBtn").click(function(){
			$(location).attr("href", "shopModifyFrm.ho?oriNo=${DETAIL.pb_no}&nowPage=${nowPage}");
		});
		
		//	원글삭제하기 이벤트
		$("#dBtn").click(function(){

		});
		
		//	목록보기 이벤트
		$("#lBtn").click(function(){
			//$(객체).attr("속성명")  		 => 해당객체의 속성값을 가져오기
			//$(객체).attr("속성명", 값)  => 해당객체의 속성값을 설정하기
			//자바스크립트에서의   location.href="../reboard/boardList.bo?nowPage=${nowPage}"
			$(location).attr("href", "../reboard/boardList.bo?nowPage=${nowPage}");
		});
		
		//	댓글쓰기
		$("#wBtn").click(function(){
			//무결성검사하시고...
			//입력요소에 유저가 입력한 내용가져올때
			//jQuery에서의   $(선택자).val()는
			//자바스크립트의   document.getElementById("title").value;와 동일
			var title=$("#title").val();
			if( title=="" ){
				alert("제목을 입력하세요");
				$("#title").focus();
				return;  //함수의 종료
			}
			
			//전송
			$("#frm").submit();
		});

	});
</script>
</head>
<body>
	<%
		String  oriNo  = request.getParameter("oriNo");  	//해당게시물번호
		String  nowPage= request.getParameter("nowPage");
	%>
<body>

<article id="content">
      <section id="article-images">
      <div id="image-slider">
  <div class="slider-wrap">
    <div class="slider">
          <div>
            <div class="image-wrap" data-image-id="148728794" data-image-index="1">
              <img src = "${DETAIL.pb_img}"
                   class="portrait"
                   alt='' />
            </div>
          </div>
  </div>
</div>
</div>
      </section>
      
    <section id="article-profile">
     <a id="article-profile-link" href="/users/2860394">
          <h3 class="hide">프로필</h3>
            <div class="space-between">
            <div>
              <div id="article-profile-image">
                <img alt="" src="${DETAIL.m_img}" />
              </div>
              <div id="article-profile-left">
                <div id="nickname">${DETAIL.m_nick}</div>
                <div id="region-name">${DETAIL.m_addgun} ${DETAIL.m_addetc} </div>
              </div>
            </div>
            <div id="article-profile-right">
              <dl id="temperature-wrap">
                <dt>매너온도</dt>
                <dd class="text-color-03">
                  ${DETAIL.m_manner}
                </dd>
              </dl>
              <div class="meters">
                <div class="bar bar-color-03" style="width: 37%;"></div>
              </div>
              <div class="face face-03"></div>
            </div>
       </div>
       </a>
	</section>
	
    <section id="article-description">
        <h1 property="schema:name" id="article-title" style="margin-top:0px;">${DETAIL.pb_title}</h1>
        <p id="article-category">
          ${DETAIL.pc_name} ∙
          <time>${DETAIL.pb_aftertime}</time>
        </p>
        <p property="schema:priceValidUntil" datatype="xsd:date" content="2021-08-26"></p>
        <p rel="schema:url" resource="https://www.daangn.com/38287124"></p>
        <p property="schema:priceCurrency" content="KRW"></p>
        <p id="article-price" property="schema:price" content="50000" style="font-size:18px; font-weight:bold;">
            ${DETAIL.pb_price}
        </p>
        <div property="schema:description" id="article-detail">
            <p> ${DETAIL.pb_comm} </p>
        </div>
        <p id="article-counts">
          <span> 관심 ${DETAIL.lc_cnt} </span> ∙ <span>
		 조회${DETAIL.pb_hit} </span>
        </p>
    </section>

		<%--	2.	기타 부가 기능 만들기(목록보기, 삭제하기, 수정하기...) --%>
		<tr>
			<td align="center">
				<%-- 로그인한 유저만  작성자의 글에대해 수정, 삭제가능 --%>
				<c:if test="${sessionScope.UID  eq DETAIL.m_nick}">	
					<input type="button" id="mBtn" value="원글수정하기"/>
					<input type="button" id="dBtn" value="원글삭제하기"/>
				</c:if>	
			</td>
		</tr>
	<%--	3.	댓글 보여주기 --%>
	<section id="article-comments">
        <h3> 댓글 ${DETAIL.pb_replycnt}</h3>
	<c:if test="${empty REPLY}">
	</c:if> 	
	<%--	댓글이 존재하면 댓글을 반복해서 보여주는 부분 --%>
	<c:if test="${not empty REPLY}">
		<c:forEach var="temp" items="${REPLY}"> <%-- 반복문 한번 돌때마다 temp변수안에 vo가 담긴다--%>
			<%-- 동적인 웹을 구현하기위해서는 제어해야할 필요가 있다
					 특정부분에 접근하기위해서는 id가 필요하고, id는 unique해야 한다
			 --%> 
			 <div id="article-comments-list">
            <div class="article-comment">
   	 <div class="article-comment-wrap">
      	<div class="article-comment-profile">
        <img alt="" src="${temp.m_img}"/>
     	 </div>
     	 <div class="article-comment-nickname">
            <a href="/users/6914104">${temp.m_nick}</a>
      		</div>
     	   <div class="article-comment-region-name">${temp.m_addgun} ${temp.m_addetc}</div>
     	 <div class="article-comment-text"><p>${temp.bc_comm}</p></div>
     	 <time class="article-comment-time">
       ${temp.bc_update}
     	 </time>
    </div>
</div>
        </div>
				<tr>
					<td colspan="4" align="center">
						<%-- 댓글수만큼 버튼이 생성되므로 동일한이름을 허용하는 class속성을 부여 --%>
						<input type="button" class="rmBtn" value="댓글수정하기">
						<input type="button" class="rdBtn" value="댓글삭제하기" param="${temp.pb_no}">
					</td>
				</tr>
			</table>
	<%-- 댓글 수정 폼 --%>
   	<%-- 댓글마다 수정폼이 생기면서  id값을 unique하게 하기위해  댓글번호를 이용하였다  --%>	 
			<form method="POST" action="../reboard/replyModify.bo" 
			      style="display:none;"  id="frm${temp.pb_no}">
			 <%-- reNo=댓글번호
			  		oriNo=게시물글번호
	          nowPage=보고싶은페이지(릴레이용) --%>
	      <input type="hidden" name="reNo" 		value="${temp.pb_no}" />
	      <input type="hidden" name="oriNo" 	value="${temp.oriNo}" />
				<table width="700" border="1" align="center">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" id="title${temp.pb_no}" value="${temp.bc_comm}"/></td>
					</tr>
					<tr>
						<td>본문</td>
						<td><textarea name="body" id="body${temp.pb_no}">${temp.bc_comm}</textarea></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pw" id="pw${temp.pb_no}"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="button" value="수정하기" class="modifyB">
						</td>
					</tr>
				</table>
			</form>
		</c:forEach> 	
 </c:if>
      </section>
</article>
	
	
	
    <section id="article-detail-hot-more">
    <div id="hot-more-link"><a href="../../view/shopboard/shopBoardDetail2.jsp">더 구경하기</a></div>
    </section>





</body>
</html>


	







