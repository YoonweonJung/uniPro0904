package dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 댓글형 게시판의 컨트롤러의 상위역할을 담당할 인터페이스
public interface ShopreboardSuper {

	//모든 컨트롤러가 오버라이딩해야하는 추상함수
	//컨트롤러는 뷰를 지정하는 것으로 끝나므로 리턴유형은 String
	//컨트롤러파일에서 request와 response객체를 편하게 사용할 수 있도록 파라미터를 제공
	public String execute(HttpServletRequest request, 
			HttpServletResponse response);
	
}
