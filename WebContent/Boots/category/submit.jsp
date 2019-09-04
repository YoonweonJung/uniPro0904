<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.POOLUtil, java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<%
		String add_si = request.getParameter("address_si");
		String add_gu = request.getParameter("address_gu");


		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		
		
		String sql = "";
			sql = "select * from productboard where ? LIKE ?"; 	
		
		System.out.println("sql = " + sql); 
		PreparedStatement stmt = db.getSTMT(con, sql);
		
		if(add_gu != null){
			stmt.setString(1, "PB_ADDGUN");       //시랑 같이 검색을 안 해서 시가 다르고 구가 같은 곳도 검색이 되어버리나 우선 넘어감.
			stmt.setString(2, "%"+add_gu+"%");
		}
		else{
			stmt.setString(1, "PB_ADDSI"); 
			stmt.setString(2, "%"+add_si+"%");
		}
				
		
		System.out.println("add_si = "+add_si); 
		System.out.println("add_gu = "+add_gu);
	
		ResultSet rs = stmt.executeQuery();
		
		
		if	(rs.next()) {
			
		 	//session.setAttribute("U_email",  rs.getString("m_email") ); 세션 필요할까?	
		 
			System.out.println("읽기 성공"); 					
			pageContext.forward("mailSend.jsp");
		} else {
				pageContext.forward("search_temp.jsp");
			}
		
		db.close(rs);
		db.close(stmt);
		db.close(con);
		
	%>
</body>
</html>