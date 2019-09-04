package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//요청주소가 /login/loginFrm.do로 끝나면 실행되는 클래스
//로그인폼을 보여주는 클래스
@WebServlet("/member/login.ho") //언오테이션, 엄청많은일을함 
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //생성자
    public MemberLogin() {        
    	super();
    	System.out.println("생성자 MemberLogin()함수호출");
    }

	@Override
	
	public void destroy() {
		System.out.println("destroy()함수호출");
		super.destroy();
	}

	//초기화.. 최초요청시 단 한번만 호출되는 함수
	@Override
	public void init() throws ServletException {
		System.out.println("init()함수호출");
		super.init();
	}


	//클라이언트의 요청을 실행함수
    //GET방식으로 요청하면 실행되는 함수
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()함수호출");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	//POST방식으로 요청하면 실행되는 함수
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()함수호출");
		doGet(request, response);
	}

}





