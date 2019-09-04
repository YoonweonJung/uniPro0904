<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="dao.ShopboardDAO" scope="page" />
<jsp:setProperty name="user" property="m_id" />
<jsp:setProperty name="user" property="m_pw" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html'charset=UTF-8">
<title>jsp게시판 웹 사이트</title>
</head>
<body>
	<%
		String userID = null;
	/*  if(session.getAttribute("m_id") != null){
		userID = (String) session.getAttribute("m_id");
	}
	if (userID != null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어있습니다.')");
		script.println("location.href = 'main.jsp'");
		script.println("</script>");
	} */
		MemberVO MemberVO= new MemberVO();
		int result = MemberVO.login(MemberVO.getM_id(), MemberVO.getM_pw());
		if(result == 1){
			session.setAttribute("m_id", user.getM_id());
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}
		else if(result == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if(result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if(result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
	%>

</body>
</html>
