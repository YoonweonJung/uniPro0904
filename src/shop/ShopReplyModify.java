package shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dispatcher.ShopreboardSuper;
import sql.ShopSQL;  //쿼리문보관제공하는 클래스
import utill.POOLUtil;  //db작업관련기능제공
import utill.PageUtil;
import vo.ShopboardVO;

//이 클래스는 댓글수정처리 요청을 담당하는 컨트롤러
public class ShopReplyModify implements reboardSuper {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//할일
		//1.파라미터받기
	      String strreNo = request.getParameter("reNo");
	      int    rno   	= Integer.parseInt(strreNo); 		//댓글번호
	      String oriNo 	= request.getParameter("oriNo");  	//댓글에 대한 원글번호
	      String nowPage = request.getParameter("nowPage");	//보고싶은페이지(릴레이용)
	      String title 	= request.getParameter("title");	//수정된글제목
	      String body 	= request.getParameter("body");		//수정된내용
	      String pw 	= request.getParameter("pw");		//비번
		  System.out.println("댓글번호 rno="+rno); //임시콘솔출력
		  
		//2.비즈니스로직 .. DB에 UPDATE작업
		ReboardDAO dao=new ReboardDAO();  
	    dao.updateReply(title, body, pw, rno);
	    dao.close(); //connection닫기
	    
		//3.모델
	    request.setAttribute("oriNo",   oriNo);   //댓글에 대한 원글번호
	    request.setAttribute("nowPage", nowPage); //보고싶은페이지(릴레이용)
	      
		//4.뷰
		return "../view/reboard/replyModify.jsp";
	}

}
