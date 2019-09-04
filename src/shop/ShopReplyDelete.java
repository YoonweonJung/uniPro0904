package shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redispatcher.reboardSuper;

//이 클래스는 댓글삭제 요청을 담당하는 컨트롤러
public class ShopReplyDelete implements reboardSuper {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//할일
		//1.파라미터받기
		//2.비즈니스로직
		//3.모델
		//4.뷰
		return "../view/reboard/replyDelete.jsp";
	}

}
