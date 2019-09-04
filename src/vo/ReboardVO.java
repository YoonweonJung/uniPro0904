package vo;

import java.sql.Date;

//VO : Value Object로 데이터를 보관하기 위한 클래스
//1. 데이터를 보관하기위한 변수 준비
//2. 변수를 조작(셋팅, 제공)하기위한 setXxx, getXxx함수 준비
//   특히 getXxx함수는 JSTL에서 데이터를 사용할 목적으로 제작한다
//   사용할 때는  get을 제외한 나머지이름만 이용.
//            첫글자는 소문로 나머지이름은 대소문자 그대로 이용.
//   예) getTitle();   ->사용할 때는  ${title}
//3. (선택) toString() 재정의

//참고	DTO: 데이터를 셋팅, 제공

public class ReboardVO {
	//변수
	private int    no;		//글번호
	private int	   oriNo;	//원글번호	
	private String writer;  //작성자
	private String title;   //제목
	private Date   wday;    //작성일
	private int    hit;     //조회수
	private int    cnt;		//댓글수
	private String body;	//내용
	private String pw;		//비번
	
	
	//setter & getter & toString()
	public int getOriNo() {
		return oriNo;
	}
	public void setOriNo(int oriNo) {
		this.oriNo = oriNo;
	}
	public int getNo() {
		return no;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getWday() {
		return wday;
	}
	public void setWday(Date wday) {
		this.wday = wday;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
		private int m_no;
		private String m_nick;
		private String m_id;
		private String m_pw;
		private String m_img;
		private String m_name;
		private String m_email;
		private String m_hp;
		private String m_gender;
		private String m_birthday;
		private String m_addsi;
		private String m_addgun;
		private String m_addetc;
		private String m_level;
		
		public String getM_level() {
			return m_level;
		}
		public void setM_level(String m_level) {
			this.m_level = m_level;
		}
		public int getM_no() {
			return m_no;
		}
		public void setM_no(int m_no) {
			this.m_no = m_no;
		}
		public String getM_nick() {
			return m_nick;
		}
		public void setM_nick(String m_nick) {
			this.m_nick = m_nick;
		}
		public String getM_id() {
			return m_id;
		}
		public void setM_id(String m_id) {
			this.m_id = m_id;
		}
		public String getM_pw() {
			return m_pw;
		}
		public void setM_pw(String m_pw) {
			this.m_pw = m_pw;
		}
		public String getM_img() {
			return m_img;
		}
		public void setM_img(String m_img) {
			this.m_img = m_img;
		}
		public String getM_name() {
			return m_name;
		}
		public void setM_name(String m_name) {
			this.m_name = m_name;
		}
		public String getM_email() {
			return m_email;
		}
		public void setM_email(String m_email) {
			this.m_email = m_email;
		}
		public String getM_hp() {
			return m_hp;
		}
		public void setM_hp(String m_hp) {
			this.m_hp = m_hp;
		}
		public String getM_gender() {
			return m_gender;
		}
		public void setM_gender(String m_gender) {
			this.m_gender = m_gender;
		}
		public String getM_birthday() {
			return m_birthday;
		}
		public void setM_birthday(String m_birthday) {
			this.m_birthday = m_birthday;
		}
		public String getM_addsi() {
			return m_addsi;
		}
		public void setM_addsi(String m_addsi) {
			this.m_addsi = m_addsi;
		}
		public String getM_addgun() {
			return m_addgun;
		}
		public void setM_addgun(String m_addgun) {
			this.m_addgun = m_addgun;
		}
		public String getM_addetc() {
			return m_addetc;
		}
		public void setM_addetc(String m_addetc) {
			this.m_addetc = m_addetc;
		}
		
		
		
	

	@Override
	public String toString() {
		return "ReboardVO [no=" + no + ", oriNo=" + oriNo + ", writer=" + writer + ", title=" + title + ", wday=" + wday
				+ ", hit=" + hit + ", cnt=" + cnt + ", body=" + body + ", pw=" + pw + "]";
	}
	
	
	
	
	
}














