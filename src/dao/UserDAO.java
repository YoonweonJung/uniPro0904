package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sql.ShopSQL;
import utill.POOLUtil;
import vo.MemberVO;

public class UserDAO {

	private POOLUtil db;
	private Connection con;
	
	public UserDAO() 
	{
		db = new POOLUtil();
		con = db.getCon();
		
	}
	
	public int login(String m_id, String m_pw) {
		String sql = ShopSQL.getSQL(ShopSQL.LOGIN);
		System.out.println("sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
				//? 채우기(물음표순서, 데이터)
				stmt.setString(1, m_id);
				stmt.setString(2, m_pw);
				ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(m_id)) {
					if(rs.getString(2).equals(m_pw)) {
					
					return 1;//�α��� ����
					}
				else {
						return 0;
				}
			}
			return -1;
			}
		}catch(Exception e) {
			System.out.println("로그인 실행에러=" + e);
		} finally {
			db.close(stmt);
		}
		return -2;//
	}
	
	public void join(String m_nick, String m_id, String m_pw, String m_img,
			String m_name, String m_email, String m_hp, String m_gender, String m_birthday,
			String m_addsi, String m_addgun, String m_addetc) {
		String sql = ShopSQL.getSQL(ShopSQL.JOIN);
		System.out.println("ShopSQL.JOIN sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setString(1, m_nick);
			stmt.setString(2, m_id);
			stmt.setString(3, m_pw);
			stmt.setString(4, m_img);
			stmt.setString(5, m_name);
			stmt.setString(6, m_email);
			stmt.setString(7, m_hp);
			stmt.setString(8, m_gender);
			stmt.setString(9, m_birthday);
			stmt.setString(10, m_addsi);
			stmt.setString(11, m_addgun);
			stmt.setString(12, m_addetc);
			stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원가입 실행에러=" + e);
		} finally {
			db.close(stmt);
		}
	
	}
	public void close() {
		db.close(con);
	}
}
