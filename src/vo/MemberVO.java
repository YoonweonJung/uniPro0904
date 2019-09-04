package vo;

public class MemberVO {
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
	
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
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
		return "MemberVO [m_no=" + m_no + ", m_nick=" + m_nick + ", m_id=" + m_id + ", m_pw=" + m_pw + ", m_img="
				+ m_img + ", m_name=" + m_name + ", m_email=" + m_email + ", m_hp=" + m_hp + ", m_gender=" + m_gender
				+ ", m_birthday=" + m_birthday + ", m_addsi=" + m_addsi + ", m_addgun=" + m_addgun + ", m_addetc="
				+ m_addetc + "]";
	}
	

	
}
