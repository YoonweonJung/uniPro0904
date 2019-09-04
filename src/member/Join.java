package member;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dispatcher.ShopreboardSuper;


//요청주소가 /login/loginFrm.do로 끝나면 실행되는 클래스
//로그인폼을 보여주는 클래스
public class Join implements ShopreboardSuper{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Join컨트롤러 진입");
		
		//컨트롤러의 할일은 아래와 같지만.. 여기에서는 폼만보여주면 되므로 딱히 할일없다. 
		//1.파라미터받기
		//2.비즈니스로직수행
		//3.모델
		//4.뷰

		return "../member/join.jsp";
		
	}

}




