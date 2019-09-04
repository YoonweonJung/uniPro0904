package shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sql.ShopSQL;
import utill.POOLUtil;
import dao.ShopboardDAO;
import dispatcher.ShopreboardSuper;

// 이 클래스는 댓글쓰기 컨트롤러
public class ShopReplyWrite implements ShopreboardSuper {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ReplyWrite컨트롤러 진입");
		
		//할일
		//1.파라미터받기
		String strOriNo=request.getParameter("oriNo");
		int    oriNo   =Integer.parseInt(strOriNo);   //댓글에 대한 원글번호
		String title   =request.getParameter("title");//댓글제목
		String body    =request.getParameter("body"); //댓글내용
		String pw      =request.getParameter("pw");   //비번
		String nowPage =request.getParameter("nowPage");//보고싶은페이지(릴레이용)
		
		//2.비즈니스로직.. db에 댓글insert
		//파라미터로 받은 내용이 부족하면 채워넣어야 한다
		//댓글은 로그인한 유저만이 작성할 수 있고
		//로그인하면  세션에 유저에 대한 정보가    기록되어진다
		//여기에서는   파라미터에서 받지못했던  댓글작성자명을 세션에서 가져와 채우겠다
		/*//세션에  회원정보를 기억시키자
		session.setAttribute("UID",  rs.getString("id") );
		session.setAttribute("UNICK",rs.getString("nick") ); 
		session.setAttribute("UNAME",rs.getString("name") );*/
		
		HttpSession  session = request.getSession();
		String writer = (String)session.getAttribute("UID");      
		
		ShopboardDAO dao=new ShopboardDAO();
		dao.insertReply(oriNo,writer,title,body,pw);
		dao.close(); //connection닫기
		
		//3.모델
		//우리는 상세보기로 넘길예정이므로 그 때 필요로한 데이터를 모델로 넘겨야한다
		request.setAttribute("oriNo", oriNo);//댓글에 대한 원글번호
		request.setAttribute("nowPage", nowPage);//보고싶은페이지(릴레이용)
		
		//4.뷰
		return "../view/reboard/replyWrite.jsp";
	}

}






