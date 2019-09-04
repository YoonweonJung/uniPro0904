package sql;

//이 클래스는 댓글게시판과 관련된 질의문을 제공하는 클래스
public class ReboardSQL {

	//쿼리문수가 많으므로 각 쿼리문에 고유한 코드값을 부여하여
	//필요한 쿼리문을 구분하도록 하겠다
	public static final int SELECT_REBOARDLIST = 1; //(원글전체)목록보기
	public static final int INSERT_REBOARD = 2;  	//(원글)입력
	public static final int SELECT_ROBOARDCNT = 3;	//원글게시물수 조회
	public static final int UPDATE_HIT = 4;			//조회수 증가
	public static final int SELECT_REBOARDVIEW = 5;	//원글상세보기
	public static final int SELECT_REPLY = 6; 		//댓글상세보기
	public static final int UPDATE_REBOARD = 7;		//원글수정
	public static final int INSERT_REPLY = 8; 	    //댓글입력
	public static final int UPDATE_REPLY = 9;		//원글수정
	
	//필요한 질의문을 제공하는 함수
	public static String getSQL(int code) {
		//파라미터 code는 외부에서 필요한 질의문이 무엇인지를 알려주는 역할
		
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case INSERT_REBOARD: //2 (원글)입력
			buff.append("INSERT INTO reboard ");
			buff.append("VALUES( (SELECT    nvl( max(rb_no),0)+1 ");
			buff.append("           FROM   reboard) ");
			buff.append("         ,? ,? ,? ,SYSDATE-10,0,'Y',? )");
			//buff.append("       ,작성명자,제목,글내용,작성일SYSDATE,0,'Y',비밀번호)");
			break;
		/*case 8; //INSERT_REPLY //댓글입력
			buff.append("INSERT INTO reply ");
			buff.append("VALUES( (SELECT    nvl( max(r_no),0)+1 ");
			buff.append("           FROM   reply)  ");
			buff.append("         ,? ,? ,? ,?,SYSDATE-10,'Y',? )");
			//buff.append("       ,원글번호, 댓글작성자명,댓글제목,댓글내용,댓글작성일SYSDATE,'Y',댓글비번 )");
			break;	*/
		case 3: //SELECT_ROBOARDCNT = 3;	//~원글게시물수 조회
			buff.append("SELECT count(m_no) as cnt ");
			buff.append("FROM   member ");
			break;
		case 4: //UPDATE_HIT //조회수 증가
			buff.append("UPDATE reboard ");
			buff.append("SET    rb_hit=rb_hit+1 ");
			buff.append("WHERE  rb_no=?");
			break;
		case 5:  //SELECT_REBOARDVIEW //원글상세보기 회원상세보기
			buff.append("SELECT m_no,m_id,m_name,m_level,m_email from member where m_no = ? ");
			break;
		case 6:  //SELECT_REPLY //댓글상세보기
			buff.append("SELECT ");
			buff.append("	 r_no  	   as no, ");
			buff.append("	 r_oriNo   as oriNo, ");
			buff.append("	 r_writer  as writer, ");
			buff.append("	 r_date    as wday, ");
			buff.append("	 r_title   as title, ");
			buff.append("	 r_content as body ");
			buff.append("FROM ");
			buff.append("	reply ");
			buff.append("WHERE ");
			buff.append("   r_oriNo=? ");
			buff.append("   and ");
			buff.append("   r_isShow='Y' ");
			buff.append("ORDER BY   ");
			buff.append("   r_no DESC");
			break;	
	
		case SELECT_REBOARDLIST: //1 (원글전체)회원목록보기
			buff.append("SELECT m_no,m_id,m_name,m_level,m_email from member order by m_no desc");

			break;

		}
		
		//String으로 리턴
		return buff.toString();
		
	}
}





