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

public class ShopFamousboardVO {
	
	private int pb_no;
	private String pb_img;   //사진주소
	private String pb_title; //글제목 
	private String m_addsi; //회원주소시 
	private String m_addgun; //회원주소군 
	private String m_addetc; //회원주소기타 
	private String pb_price; //가격
	private int lc_cnt;	//찜횟수
	private int pb_replycnt; //댓글 수
	private int pb_hit; //조회수
	
	
	public int getPb_no() {
		return pb_no;
	}
	public void setPb_no(int pb_no) {
		this.pb_no = pb_no;
	}
	public String getPb_img() {
		return pb_img;
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
	public String getPb_price() {
		return pb_price;
	}
	public void setPb_price(String pb_price) {
		this.pb_price = pb_price;
	}
	public int getLc_cnt() {
		return lc_cnt;
	}
	public void setLc_cnt(int lc_cnt) {
		this.lc_cnt = lc_cnt;
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
	@Override
	public String toString() {
		return "ShopFamousboardVO [pb_no=" + pb_no + ", pb_img=" + pb_img + ", pb_title=" + pb_title + ", m_addsi="
				+ m_addsi + ", m_addgun=" + m_addgun + ", m_addetc=" + m_addetc + ", pb_price=" + pb_price + ", lc_cnt="
				+ lc_cnt + ", pb_replycnt=" + pb_replycnt + ", pb_hit=" + pb_hit + "]";
	}
	
}





