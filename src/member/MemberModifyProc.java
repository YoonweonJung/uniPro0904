package member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dispatcher.ShopreboardSuper;
import sql.ReboardSQL;
import utill.POOLUtil;

//이 클래스는 원글수정처리 요청담당 컨트롤러
public class MemberModifyProc implements ShopreboardSuper {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//할일
		//1.파라미터받기
		/*String strOriNo= request.getParameter("oriNo");
		int oriNo = Integer.parseInt(strOriNo);*/
		int oriNo = Integer.parseInt(request.getParameter("oriNo"));
		int level = Integer.parseInt(request.getParameter("level"));
		String email = request.getParameter("email");
		String nowPage= request.getParameter("nowPage"); //보고싶은페이지(릴레이용)
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		//2.비즈니스로직
		//DB에서 UPDATE처리하는 DAO클래스의 함수호출
		String sql="update member set m_level = ?,m_email = ? where m_no =? ";
		System.out.println("원글수정sql="+sql);
		//String sql=ReboardSQL.getSQL(7);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, level);
			stmt.setString(2, email);
			stmt.setInt(3,oriNo);
			int c=stmt.executeUpdate();
			System.out.println(c);
		} catch (Exception e) {
			System.out.println("원글수정쿼리문 실행에러="+e);
		}
		finally {
			db.close(stmt);	
		}
		
		//3.모델
		//4.뷰
		//상세보기로 넘어갈 때 필요한 해당게시물번호도 모델로 만들어야 한다
		request.setAttribute("oriNo", oriNo);
		request.setAttribute("nowPage", nowPage);//보고싶은페이지(릴레이용)
		
		return "../member/membermodifyProc.jsp";
		
	}

}

