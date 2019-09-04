<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utill.POOLUtil, java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>compare_DB</title>
</head>
<body>
	<%-- 이 문서(loginProc.jsp)는 클라이언트가 로그인해달라고 요청하면
     	로그인처리를 할 문서
     	DB연동시 ConnectionPool이용
 --%>

	<%
		String ID_or_PW = request.getParameter("ID_or_PW");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String ID = request.getParameter("ID");

		//2-1) 드라이버 로딩+dbuser와 비번
		POOLUtil db = new POOLUtil();
		//2-2) 커넥션 받기
		Connection con = db.getCon();
		//2-3) 실행

		


		String sql = "select m_email, m_name, m_id, m_pw from member where m_name = ? and m_email = ?";
		if(ID_or_PW.equals("PW"))
			sql ="select m_email, m_name, m_id, m_pw from member where m_name = ? and m_email = ? and m_id = ?";
		
		System.out.println("sql = " + sql); 
		PreparedStatement stmt = db.getSTMT(con, sql);
        

		
		stmt.setString(1, name);
		stmt.setString(2, email);
		if(ID_or_PW.equals("PW")){
			stmt.setString(3, ID);}
		
		System.out.println("name = "+name); 
		System.out.println("email = "+email);
		System.out.println("ID = "+ID);
	
		ResultSet rs = stmt.executeQuery();
		
		
		if	(rs.next()) {
			
		 	session.setAttribute("U_email",  rs.getString("m_email") );
			session.setAttribute("U_name",rs.getString("m_name") ); 
			session.setAttribute("U_id",rs.getString("m_id") ); 
			session.setAttribute("U_pw",rs.getString("m_pw") ); 
			
		 
			System.out.println("이메일 발송 성공"); 					
			pageContext.forward("mailSend.jsp");
		} else {
			//out.println("<script>alert('해당하는 정보의 회원이 없습니다.');</script>");   //질문 - 틀렸을 때 경고창 띄우기
			/*
			if(ID_or_PW.equals("PW")){
				pageContext.forward("find_PW.jsp");
			}
			else if(ID_or_PW.equals("ID")){
				pageContext.forward("find_ID.jsp");
			}
			*/
			pageContext.forward("../member/join.jsp");
		}
		db.close(rs);
		db.close(stmt);
		db.close(con);
		
	%>
</body>
</html>