<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utill.JDBCUtil, java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProc</title>
</head>
<body>
<%-- 이 문서(loginProc.jsp)는 클라이언트가 로그인해달라고 요청하면
     	로그인처리를 할 문서 --%>
<%
  //할일
	//1. user가 입력한 정보(id,비번)을 가져오자
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nick = request.getParameter("nick");

	
	//2. db의 회원테이블에서 유저가 입력한 id와 비번이 일치하는 쿼리문 실행결과를 받아서 처리
	//2-1) 드라이버 로딩
	JDBCUtil db = new JDBCUtil();
	//2-2) 커넥션 받기
	Connection con = db.getCon();
    //2-3) 실행
	String sql = " select m_id as id, m_pw as pw, m_nick as nick" + 
	" from member " +
	" where m_id=? and m_pw=? ";
    
    System.out.println("sql="+sql);
	PreparedStatement stmt = db.getSTMT(sql);
	//? 채우기(물음표순서, 데이터)
	stmt.setString(1, id);
	stmt.setString(2, pw);
	stmt.setString(3, nick);
	
	//? 채우고 실행
	ResultSet rs = stmt.executeQuery();
	
	//3.결과에 따라서
	//3-1) 일치하면		세션에  회원정보를 기억시킬예정
	if( rs.next() ){	
		System.out.println("로그인성공 -회원이구나"); //콘솔출력
		//세션에  회원정보를 기억시키자
		session.setAttribute("UID", rs.getString("id"));
		session.setAttribute("UPW", rs.getString("pw"));  		
		session.setAttribute("UNICK", rs.getString("nick"));
	}
	else{ //3-2) 일치x하면  ~~~~~~
		//비회원이다
	}
	//4. 잊지말자 자원반납
	db.close(rs);
	db.close(stmt);
	db.close(con);
	
	//이제 비즈니스 로직이 끝났으므로
	//여기에서는 메인으로 이동하겠다
	//sendRedirec를 하면 요청페이지(ex05.jsp)는 클라이언트에게 보이지x
	//클라이언트에게 보여주는 페이지는 login.jsp가 된다
	response.sendRedirect("../Boots/modul/sub3.jsp");	
%>
</body>
</html>










