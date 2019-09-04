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

public class ShopboardVO {
	
	private int pb_no; //게시글 번호 
	private String pb_img;   //글사진
	private String pb_title; //글제목 
	private String m_addgun; //회원주소군 
	private String m_addetc; //회원주소기타 
	private String m_img; //회원프로필사진 
	private String m_nick; //회원닉네임
	private String pb_price; //물건 가격
	private String pc_name; //카테고리명
	private Date bc_update; //댓글수정날짜
	private int lc_cnt; //조회수
	private String m_manner; //매너온도
	private String pb_comm; //글내용
	private int pb_replycnt; //댓글 수
	private int pb_hit;      //조회수
	private int	  oriNo;	//원글번호	
	private String bc_comm; //댓글내용
	private int bc_no; //댓글번호
	private String m_addsi; //회원주소시
	private Date pb_aftertime; //수정날짜
	private int bc_stat;
	
	public int getBc_stat() {
		return bc_stat;
	}
	public void setBc_stat(int bc_stat) {
		this.bc_stat = bc_stat;
	}
	public Date getPb_aftertime() {
		return pb_aftertime;
	}
	public void setPb_aftertime(Date pb_aftertime) {
		this.pb_aftertime = pb_aftertime;
	}
	public String getM_addsi() {
		return m_addsi;
	}
	public void setM_addsi(String m_addsi) {
		this.m_addsi = m_addsi;
	}
	public int getBc_no() {
		return bc_no;
	}
	public void setBc_no(int bc_no) {
		this.bc_no = bc_no;
	}
	public String getBc_comm() {
		return bc_comm;
	}
	public void setBc_comm(String bc_comm) {
		this.bc_comm = bc_comm;
	}
	public int getOriNo() {
		return oriNo;
	}
	public void setOriNo(int oriNo) {
		this.oriNo = oriNo;
	}
	public int getPb_no() {
		return pb_no;
	}
	public void setPb_no(int pb_no) {
		this.pb_no = pb_no;
	}
	public int getPb_replycnt() {
		return pb_replycnt;
	}
	public void setPb_replycnt(int pb_replycnt) {
		this.pb_replycnt = pb_replycnt;
	}
	public int getPb_hit() {
		return pb_hit;
	}
	public void setPb_hit(int pb_hit) {
		this.pb_hit = pb_hit;
	}
	public String getPb_comm() {
		return pb_comm;
	}
	public void setPb_comm(String pb_comm) {
		this.pb_comm = pb_comm;
	}
	public String getPb_img() {
		return pb_img;
	}
	public String getM_manner() {
		return m_manner;
	}
	public void setM_manner(String m_manner) {
		this.m_manner = m_manner;
	}
	public void setPb_img(String pb_img) {
		this.pb_img = pb_img;
	}
	public String getPb_title() {
		return pb_title;
	}
	public void setPb_title(String pb_title) {
		this.pb_title = pb_title;
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
	public String getM_img() {
		return m_img;
	}
	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public String getPb_price() {
		return pb_price;
	}
	public void setPb_price(String pb_price) {
		this.pb_price = pb_price;
	}
	public String getPc_name() {
		return pc_name;
	}
	public void setPc_name(String pc_name) {
		this.pc_name = pc_name;
	}
	public Date getBc_update() {
		return bc_update;
	}
	public void setBc_update(Date bc_update) {
		this.bc_update = bc_update;
	}
	public int getLc_cnt() {
		return lc_cnt;
	}
	public void setLc_cnt(int lc_cnt) {
		this.lc_cnt = lc_cnt;
	}
	@Override
	public String toString() {
		return "ShopboardVO [pb_no=" + pb_no + ", pb_img=" + pb_img + ", pb_title=" + pb_title + ", m_addgun="
				+ m_addgun + ", m_addetc=" + m_addetc + ", m_img=" + m_img + ", m_nick=" + m_nick + ", pb_price="
				+ pb_price + ", pc_name=" + pc_name + ", bc_update=" + bc_update + ", lc_cnt=" + lc_cnt + ", m_manner="
				+ m_manner + ", pb_comm=" + pb_comm + ", pb_replycnt=" + pb_replycnt + ", pb_hit=" + pb_hit + ", oriNo="
				+ oriNo + ", bc_comm=" + bc_comm + ", bc_no=" + bc_no + ", m_addsi=" + m_addsi + ", pb_aftertime="
				+ pb_aftertime + ", bc_stat=" + bc_stat + "]";
	}
	
	
	
	
}












