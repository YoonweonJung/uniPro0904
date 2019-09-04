package shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShopboardDAO;
import dispatcher.ShopreboardSuper;
import vo.ShopboardVO;

//이 클래스의 원글수정폼을 보여주는 요청담당 컨트롤러
public class ShopModifyFrm implements ShopreboardSuper {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("ShopModifyFrm 컨트롤러 진입");
		
		//할일
		//1.파라미터받기
		//String strOriNo = request.getParameter("oriNo");
		//int    oriNo = Integer.parseInt(strOriNo);
		//String nowPage = request.getParameter("nowPage"); //보고싶은페이지(릴레이용)
		
		//2.비즈니스로직
		//수정페이지뷰를 유저에게 보여줄 때는 이미 원글상세내용이 출력된 상태여야 하므로
		//DB에서 원글상세보기를 해야한다
		//ShopboardDAO dao = new ShopboardDAO();
		//ShopboardVO  vo = dao.updateReboard(oriNo);
		//dao.close(); // connection닫기용 함수호출
		
		
		//3.모델
		//4.뷰
		//request.setAttribute("REBOARD", vo);      //원글상세내용
		//request.setAttribute("nowPage", nowPage); //보고싶은페이지(릴레이용)
		
		return "/view/shopboard/modifyFrm.jsp";
		
	}

}








