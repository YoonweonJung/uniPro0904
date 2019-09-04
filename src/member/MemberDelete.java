package member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dispatcher.ShopreboardSuper;
import utill.POOLUtil;

// 이 클래스는 (원)글삭제 요청을 담당하는 컨트롤러
public class MemberDelete implements ShopreboardSuper {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//할일
		//1. 파라미터받기
		String strOriNo = request.getParameter("oriNo");
		int    oriNo    = Integer.parseInt(strOriNo);
		String nowPage 	= request.getParameter("nowPage");
		
		
		
		//2. 비즈니스로직
		
 
		
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		
		//페이징처리를 하기위해서 필수로 필요한 총게시물수와 보고싶은페이지가 있어야 한다
		//총게시물수 조회
		String sql = "delete from member where m_no = ?";
		//String sql1 = RebordSQL.getSQL(3);
		//String sql=ReboardSQL.getSQL(11);
		PreparedStatement stmt = db.getSTMT(con, sql);
		
		int change = 0;//update성공실패여부를 기억하기 위한 변수선언
		try {
			stmt.setInt(1, oriNo);
			
			//update가 성공되면 update된 레코드수가 반환
			//실패되면 0이 반환
			//우리는 성공과 실패여부를 유저에게 알려줘야하므로 레코드수가 필요하다
			change = stmt.executeUpdate();
		} catch (Exception e) {	
			System.out.println("원글삭제쿼리 실행에러="+e);
		} finally {
			db.close(stmt);
		}
		
		
		//3. 모델
		//4. 뷰
		request.setAttribute("CHANGE", change); //update성공실패여부 결과
		request.setAttribute("nowPage", nowPage);
		
		return "../member/memberDelete.jsp";
	}

}
