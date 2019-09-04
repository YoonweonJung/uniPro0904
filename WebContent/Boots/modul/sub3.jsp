<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
    
	String content ="";
	String a_page ="";
    try{
    	a_page = request.getParameter("page");
		//int aPage = Integer.parseInt(a_page);
	}
    catch(Exception e){ 
    	System.out.print("처음에는 원래 받아올 값이 없어서 예외처리");
    }
	System.out.print("페이지 넘어왔는지 확인 = "+a_page);
    if(a_page == null)
		content= "content.jsp";
    else if(a_page.equals("1"))
		content="../../view/shopboard/shopBoardDetail.jsp";
    else if(a_page.equals("2")){
    	content="content.jsp";
    }
    else if(a_page.equals("3")){
    	content="../../member/join.jsp";
    }
    else if(a_page.equals("4")){
    	content="../../member/login.jsp";
    }
    else
    	System.out.print("뭔가 문제가 있다.");
%>

<title>Insert title here</title>
</head>
<body>
<div>
    <jsp:include page="header.html"></jsp:include>
 </div>
 <div>
    <jsp:include page="<%=content%>" />
 </div>
 <div>
    <jsp:include page="footer.html"></jsp:include>
</div>
</body>
</html>

