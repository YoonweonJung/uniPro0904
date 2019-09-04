package shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dispatcher.ShopreboardSuper;

// 글쓰기 폼요청 (/reboard/writeFrm.bo)이 들어올때
// 호출될 컨트롤러 클래스
public class ShopWriteFrm implements ShopreboardSuper{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WriteFrm컨트롤러 진입");
		
		//컨트롤러의 할일은 아래와 같지만.. 여기에서는 폼만보여주면 되므로 딱히 할일없다. 
		//1.파라미터받기
		//2.비즈니스로직수행
		//3.모델
		//4.뷰

		return "../view/shopboard/shopWriteFrm.jsp";
		
	}

}
