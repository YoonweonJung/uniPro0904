package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dispatcher.ShopreboardSuper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sql.ShopSQL;
import utill.POOLUtil;

// 이 클래스는 (원)글쓰기 처리를 담당컨트롤러
public class ShopWriteProc implements ShopreboardSuper {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WriteProc컨트롤러 진입");
		//할일
		//1.파라미터받기
		//	작성자는 로그인이 되어있는지 확인하면 세션에 담긴 정보를 가져와서 사용한다
		HttpSession session = request.getSession(); 
		
		 int fileSize= 5*1024*1024;
	     String uploadPath = request.getServletContext().getRealPath("/img");
	     
	     // 파일업로드 
		try {
			MultipartRequest multi = new MultipartRequest
			         (request, uploadPath, fileSize, "utf-8", new DefaultFileRenamePolicy());
			
			 // 파일이름 가져오기
            String fileName = "";
            Enumeration<String> names = multi.getFileNames();
            if(names.hasMoreElements())
            {
                String name = names.nextElement();
                fileName = multi.getFilesystemName(name);
            }
            
            
		} catch (Exception e) {
			 e.printStackTrace();
	            System.out.println("글 작성 오류 : " + e.getMessage());


		}

		
		//프로젝트진행시 로그인이 미완성시에는 임시로 로그인했다치고..
		//세션에  회원정보를 기억시키자
		session.setAttribute("UID",  "hong" );
		session.setAttribute("UNAME","인구" );
		session.setAttribute("UNICK","좆망돌겜" ); 
		
		String uid=(String)session.getAttribute("UID"); //작성명(세션정보를 이용)
		if( uid==null || uid.length()==0 ) { 
			//로그인되지않았으니 (글쓰기처리대신에) 로그인폼을  보여주자 
			return "../member/login.jsp";
		} 
		
	    String title=request.getParameter("title"); //제목
		String body=request.getParameter("body"); //내용
		String pw=request.getParameter("pw"); //비번
		
		//2.비즈니스로직 ->reboard테이블에 insert
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		String sql = ShopSQL.getSQL(ShopSQL.INSERT_BOARD);
		//String sql = ReboardSQL.getSQL(2);
		System.out.println("원글입력sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		
		try {
			//?를 채우자
			stmt.setString(1,uid);
			stmt.setString(2,title);
			stmt.setString(3,body);
			stmt.setString(4,pw);
	
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("원글입력쿼리 실행에러 = "+e);
		}
		finally {
			db.close(stmt);
			db.close(con);
		}
		  	  
		//3.모델
		//4.뷰
		return "/view/shopboard/shopWriteProc.jsp";
	}

}