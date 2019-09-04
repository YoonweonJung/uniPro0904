<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utill.POOLUtil, java.sql.*" %>
<%@ page import="sql.ShopSQL" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JoinProc</title>
</head>
<body>


<%-- 이 문서(loginProc.jsp)는 클라이언트가 로그인해달라고 요청하면
     	로그인처리를 할 문서
     	DB연동시 ConnectPool 이용
     	 --%>
<%
  //할일
	//1. user가 입력한 정보(id,비번)을 가져오자
	 String m_nick = request.getParameter("m_nick");
	 String m_id  = request.getParameter("m_id");
	 String m_pw  = request.getParameter("m_pw");
	 String m_img  = request.getParameter("m_img");
	 String m_name  = request.getParameter("m_name");
	 String m_email  = request.getParameter("m_email");
	 String m_hp  = request.getParameter("m_hp");
	 String m_gender  = request.getParameter("m_gender");
	 String m_birthday  = request.getParameter("m_birthday");
	 String m_addsi  = request.getParameter("m_addsi");
	 String m_addgun  = request.getParameter("m_addgun");
	 String m_addetc  = request.getParameter("m_addetc");

	//2. db의 회원테이블에서 유저가 입력한 id와 비번이 일치하는 쿼리문 실행결과를 받아서 처리
	//2-1) 드라이버 로딩 + db에 접속 유저, 비번 내용이 다들어가있는상태
	POOLUtil db = new POOLUtil();
	//2-2) 커넥션 받기
	Connection con = db.getCon();
    //2-3) 실행
	String sql = ShopSQL.getSQL(ShopSQL.JOIN);
	System.out.println("sql="+sql);
	PreparedStatement stmt = db.getSTMT(con, sql);
	ResultSet  rs = null;
	
	 try {
	//? 채우기(물음표순서, 데이터)
			stmt.setString(1, m_nick);
			stmt.setString(2, m_id);
			stmt.setString(3, m_pw);
			stmt.setString(4, m_img);
			stmt.setString(5, m_name);
			stmt.setString(6, m_email);
			stmt.setString(7, m_hp);
			stmt.setString(8, m_gender);
			stmt.setString(9, m_birthday);
			stmt.setString(10, m_addsi);
			stmt.setString(11, m_addgun);
			stmt.setString(12, m_addetc);
			rs = stmt.executeQuery();
	//3.결과에 따라서
	//3-1) 일치하면		세션에  회원정보를 기억시킬예정
	if( rs.next() ){	
		System.out.println("회원가입성공"); //콘솔출력
		//세션에  회원정보를 기억시키자
		session.setAttribute("UID", rs.getString("m_id"));
		session.setAttribute("UPW", rs.getString("m_pw"));  		
	}
	else{ //3-2) 일치x하면  ~~~~~~
		//비회원이다
		System.out.println("회원가입실패"); //콘솔출력
	}
	
  } catch (Exception e) {
		e.printStackTrace();
  }finally {
	//4. 잊지말자 자원반납
	db.close(rs);
	db.close(stmt);
	db.close(con);
  }
	//이제 비즈니스 로직이 끝났으므로
	//여기에서는 메인으로 이동하겠다
	//sendRedirec를 하면 요청페이지(ex05.jsp)는 클라이언트에게 보이지x
	//클라이언트에게 보여주는 페이지는 login.jsp가 된다
	response.sendRedirect("../Boots/modul/sub3.jsp");	
%>
</body>
</html>










