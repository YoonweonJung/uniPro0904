package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dispatcher.ShopreboardSuper;
import sql.ReboardSQL;
import utill.POOLUtil;
import vo.ReboardVO;

//이 클래스의 원글수정폼을 보여주는 요청담당 컨트롤러
public class MemberModifyFrm implements ShopreboardSuper {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("회원수정 진입");
		//할일
		//1.파라미터받기
		String strOriNo = request.getParameter("oriNo");
		
		int    oriNo = Integer.parseInt(strOriNo);
		System.out.println("aaaaaaaaaa"+oriNo);
		String nowPage = request.getParameter("nowPage"); //보고싶은페이지(릴레이용)
		
		//2.비즈니스로직
		//수정페이지뷰를 유저에게 보여줄 때는 이미 원글상세내용이 출력된 상태여야 하므로
		//DB에서 원글상세보기를 해야한다
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		ResultSet rs = null;
		String sql=ReboardSQL.getSQL(ReboardSQL.SELECT_REBOARDVIEW);
		//String sql=ReboardSQL.getSQL(5);
		PreparedStatement stmt = db.getSTMT(con, sql);
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
			System.out.println("원글상세내용조회 실행에러="+e);
		}
		finally {
			db.close(rs);
			db.close(stmt);
		}
		
		
		//3.모델
		//4.뷰
		request.setAttribute("REBOARD", vo);      //원글상세내용
		request.setAttribute("nowPage", nowPage); //보고싶은페이지(릴레이용)
		
		return "../member/membermodifyFrm.jsp";
		
	}

}








