package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utill.POOLUtil;


@WebServlet("/member/loginProc.ho")
public class MemberLoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemberLoginProc() {
        super();
        System.out.println("MemberLoginProc.java 생성자");
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	//get방식으로 호출하면 실행함수-> 서비스함수
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//loginProc.jsp에서 작업했듯이
		//db연동하여 로그인처리할 예정
		//할일
		//1. user가 입력한 정보(id,비번)을 가져오자
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		//2. db의 회원테이블에서 유저가 입력한 id와 비번이 일치하는 쿼리문 실행결과를 받아서 처리
		//2-1) 드라이버 로딩+dbuser와 비번
		POOLUtil db = new POOLUtil();
		//2-2) 커넥션 받기
		Connection con = db.getCon();
	  //2-3) 실행
	  String sql = "select m_id as id, m_nick as nick "+
			           "from   member "+
			           "where  m_id=? and m_pw=?";
	  System.out.println("sql = "+sql); //콘솔 확인용
	  PreparedStatement stmt =  db.getSTMT(con,sql);
	  ResultSet  rs = null;
	  
	  //?채우기   setXXX(물음표순서, 데이터)
	  try {
		stmt.setString(1, id);
		stmt.setString(2, pw);
		
		//?채우고 실행
		rs = stmt.executeQuery();
		
	  //3.결과에 따라서
		//3-1) 일치하면		세션에  회원정보를 기억시킬예정
		if( rs.next()  ){	
			System.out.println("로그인성공 -회원이구나"); //콘솔출력
			//세션에  회원정보를 기억시키자
			//jsp에서의 내장객체 session은 HttpSession이 new가 된 것이다
			HttpSession session = request.getSession();
			session.setAttribute("UID",  rs.getString("id") );
			session.setAttribute("UNICK",rs.getString("nick") );  		
		}
		else{ //3-2) 일치x하면  ~~~~~~
			//비회원이다
			System.out.println("비회원"); //콘솔출력
		}
		
	  } catch (Exception e) {
			e.printStackTrace();
	  }
	  finally{//4.자원반납 잊지말자
		db.close(rs);
		db.close(stmt);
		db.close(con);
	  }
		
		//이제 비즈니스 로직이 끝났으므로
		//여기에서는 로그인폼으로 이동하겠다
		//sendRedirec를 하면 요청페이지(ex05.jsp)는 클라이언트에게 보이지x
		//클라이언트에게 보여주는 페이지는 login.jsp가 된다
		//response.sendRedirect("./login.jsp");	
	}

	//Post방식으로 호출하면 실행함수-> 서비스함수
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




