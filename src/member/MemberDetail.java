package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dispatcher.ShopreboardSuper;
import sql.ReboardSQL;  //쿼리문보관제공하는 클래스
import utill.POOLUtil;  //db작업관련기능제공
import utill.PageUtil;
import vo.ReboardVO;

// 이 클래스는 상세내용 출력요청 컨트롤러
public class MemberDetail implements ShopreboardSuper {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardDetail컨트롤러 진입");
		
		//할일
		//1.파라미터받기
		String  strOriNo  = request.getParameter("oriNo");   
		int     oriNo     = Integer.parseInt(strOriNo);   //해당게시물번호
		String  nowPage= request.getParameter("nowPage"); //보고싶은페이지(릴레이용)
		
	

		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		ResultSet rs = null;
		
		//2-2) 원글상세내용 출력
		String sql=ReboardSQL.getSQL(ReboardSQL.SELECT_REBOARDVIEW);
		PreparedStatement stmt = db.getSTMT(con, sql);
		//sql=ReboardSQL.getSQL(5);
		System.out.println("원글상세내용sql="+sql);
		stmt = db.getSTMT(con, sql);
		ReboardVO vo = new ReboardVO(); //원글상세내용을 기억하기위한 변수
		
		try {
			stmt.setInt(1, oriNo);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				//결과셋을 모델로 만들어서 뷰에게 전달해야한다
				//여러종류로 구성된  한 개의 데이터이므로 vo클래스이용
				vo.setM_no(rs.getInt("m_no"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_level(rs.getString("m_level"));
				vo.setM_email(rs.getString("m_email"));

				
			}
		} catch (Exception e) {
			System.out.println("댓글상세내용조회 실행에러="+e);
		}
		finally {
			db.close(rs);
			db.close(stmt);
		}
		
	
	
		
		//3.모델
		request.setAttribute("DETAIL",vo);     //원글상세내용
		
		//필요한 파라미터는 릴레이시켜야한다. 왜냐하면 알려주지않은 데이터는 사용할 수 없기 때문이다
		request.setAttribute("nowPage",nowPage);//보고싶은페이지(릴레이용)
		
		//4.뷰
		return "../member/memberDetail.jsp";
	}
	
	
	
	
	
	

}
