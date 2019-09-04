package shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dispatcher.ShopreboardSuper;
import sql.ShopSQL;  //쿼리문보관제공하는 클래스
import utill.POOLUtil;  //db작업관련기능제공
import utill.PageUtil;
import vo.ShopboardVO;

//이 클레스의 원글 수정처리 / 요청담당 컨트롤러
public class ShopModifyProc implements ShopreboardSuper {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("ShopModifyProc 컨트롤러 진입");
		
		//할일
		//1.파라미터 받기
		//int oriNo = Integer.parseInt(request.getParameter("oriNo"));
		//String title = request.getParameter("title"); 
		//String body = request.getParameter("body"); 
		//String pw = request.getParameter("pw"); 
		//String nowPage = request.getParameter("nowPage"); //보고싶은페이지 
		
		//2.비즈니스 로직
		//DB에서 UPDATE처리하는 DAO클래스의 함수호출해서
		//ReboardDAO dao = new ReboardDAO();
		//dao.updateReboard(oriNo,title,body,pw);
		//dao.close();
		//3.모델
		//4.뷰
		//상세보기로 넘어갈 때 필요한 해당게시물 번호도 모델로 만들어야 한다.
		//request.setAttribute("oriNo", oriNo);
		//request.setAttribute("nowPage", nowPage);
		
		return "/view/shopboard/modifyProc.jsp";
	}

}
