package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dispatcher.ShopreboardSuper;
import sql.ShopSQL;  //쿼리문보관제공하는 클래스
import utill.POOLUtil;  //db작업관련기능제공
import utill.PageUtil;
import vo.ShopboardVO;

//모든 클래스는 ReboardSuper인터페이스를 구현하기로 약속하였다
//ReboardSuper인터페이스는 execute()추상함수를 선언
//모든 클래스에서는 반드시 execute()를 오버라이딩해야 한다

//http://localhost/uri/reboard/boardList.bo으로 요청이 들어오면
//실행되는 (원글전체)목록보기를 담당하는 컨트롤러이다
public class ShopBoardList implements ShopreboardSuper{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardList컨트롤러진입-execute()");
		//할일
		//1. 파라미터받기
	    // nowPage = (선택)보고싶은페이지
		 String strNowPage = request.getParameter("nowPage");
		 String s_page = request.getParameter("page");
		 System.out.println("컨텐트 =" + s_page);
		 int	nowPage = 0;
         if( strNowPage==null||strNowPage.length()==0 ) { // 보고싶은페이지가 없으면 
        	 nowPage = 1; //기본 1page를 보여준다
         }else {
        	 nowPage = Integer.parseInt( strNowPage );
         }
         
		//2. 비즈니스로직수행
        //db연결=> connection얻기->쿼리실행객체(스테이트먼트)->쿼리문->실행->결과받기
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		
		//페이징처리를 하기위해서 필수로 필요한 총게시물수와 보고싶은페이지가 있어야 한다
		//총게시물수 조회
		String sql1 = ShopSQL.getSQL(ShopSQL.SELECT_BOARDCNT);
		//String sql1 = RebordSQL.getSQL(3);
		Statement stmt1 = db.getSTMT(con);
		int totalCnt = 0;
		
		try {
			ResultSet rs1 = stmt1.executeQuery(sql1);
			rs1.next();
			totalCnt = rs1.getInt("CNT");
			System.out.println("원글totalCnt = "+totalCnt);
			rs1.close();
			stmt1.close();
		}catch(Exception e) {
			System.out.println("총게시물수조회 쿼리실행 에러="+e);
		}
		
		//페이징처리 추가할 예정
		//보고싶은페이지,총게시물수 주고, 나머지2개는 개발자가 지정  
		//new PageUtil(nowPage, totalCnt, 1페이지당 보여줄 게시물수3, 한번에 보여줄 페이지수5);
		PageUtil pageInfo=new PageUtil(nowPage, totalCnt);
		
					
		//reboard테이블에 접속해서 모든 데이터를 조회해야한다
		//필요한 쿼리문은 RebordSQL의 getSQL함수를 호출하여 받자   RebordSQL.getSQL()
		//해당 함수에는 질의문이 많으므로 
		//내가 필요한 쿼리문의 코드값을 파라미터(RebordSQL.SELECT_REBOARDLIST)로 제시해야 한다
		String sql = ShopSQL.getSQL(ShopSQL.SELECT_BOARDLIST);
		//String sql = RebordSQL.getSQL(1);
		System.out.println("(원글전체)목록보기 sql="+sql);  //콘솔확인용
		PreparedStatement stmt = db.getSTMT(con,sql);
		ArrayList list = new ArrayList(); //4번째 모델방식에 필요한 ArrayList선언

		try {
			//쿼리를 실행하면 모든 게시물이 조회가 된다
			ResultSet rs = stmt.executeQuery();

			//조회된 결과를 뷰에게 전달해야 모델로 전달 한다
			//4번째 모델방식 : 여러종류로 구성된  여러개의 데이터
			
			//ResultSet의 레코드 수만큼 반복하면서 모든 게시물이 조회된다
			//뷰에 뿌려질 필요한 레코드만 꺼내서 모델로 만들어 전달하자
			// 어떻게???  해당페이지 전페이지까지 보여줄 레코드는 건너뛰자
			int skip = (pageInfo.getNowPage()-1)*pageInfo.getListCount();
			//select쿼리문의 각 컬럼의 값을 VO클래스의 setter()의 파라미터값으로 제공
			
			for(int i=0; i<skip ;i++) {
				rs.next(); //해당페이지 전페이지까지 보여줄 레코드는 건너뛰자
			}
			
			//해당페이지에 게시물수가 ListCount수보다 작을수 있음을 주의하자!
			for(int i=0; i<pageInfo.getListCount()&& rs.next() ;i++) {
			//while( rs.next() ) {   
				ShopboardVO vo = new ShopboardVO();
				vo.setPb_no(rs.getInt("pb_no"));
				vo.setPb_img(rs.getString("pb_img"));
				vo.setPb_title(rs.getString("pb_title"));
				vo.setM_addsi(rs.getString("m_addsi"));
				vo.setM_addgun(rs.getString("m_addgun"));
				vo.setM_addetc(rs.getString("m_addetc"));
				vo.setPb_price(rs.getString("pb_price"));
				vo.setPb_hit(rs.getInt("pb_hit"));
				vo.setLc_cnt(rs.getInt("lc_cnt"));
				vo.setPb_replycnt(rs.getInt("pb_replycnt"));
				list.add(vo);
				
				System.out.println(vo.getPb_no());
			}
			
			db.close(rs);
		} catch (Exception e) {
			System.out.println("(원글전체)목록보기조회 실행에러="+e);
		}
		finally {
			db.close(stmt);
			db.close(con);
		}
		
		//3. 모델... 뷰페이지에서 필요한  비즈니스로직수행결과
		//request.setAttribute("키값", 데이터 );
		request.setAttribute("LIST", list); //게시물목록 조회
		request.setAttribute("PINFO", pageInfo );//페이징처리를 위한 페이지정보
		
		//4. 뷰
		
		return "../../view/shopboard/shopBoardDetail2.jsp";
	}

	

}






