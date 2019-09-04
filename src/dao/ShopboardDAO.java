package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sql.ShopSQL;
import utill.POOLUtil;
import vo.ShopFamousboardVO;
import vo.ShopboardVO;

// 이 클래스는 db조작관련 기능을 제공하는 클래스
public class ShopboardDAO {

	// 변수
	private POOLUtil db;
	private Connection con;

	// 생성자
	// ReboardDAO dao=new ReboardDAO();해도
	// 반드시 해야하는 db연결기능까지 제공하겠다
	public ShopboardDAO() {
		db = new POOLUtil();
		con = db.getCon();
	}

	// 함수
	// 필요한 기능을 함수로 만들어 제공하면 된다
	// 댓글수정
	public void updateReply(String title, String body, String pw, int rno) {
		String sql = ShopSQL.getSQL(ShopSQL.UPDATE_REPLYMODIFY);
		// String sql=ReboardSQL.getSQL(9);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setString(1, title);
			stmt.setString(2, body);
			stmt.setString(3, pw);
			stmt.setInt(4, rno);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("댓글수정쿼리문 실행에러=" + e);
		} finally {
			db.close(stmt);
		}

	}

	// 댓글입력
	public void insertReply(int oriNo, String writer, String title, String body, String pw) {
		String sql = ShopSQL.getSQL(ShopSQL.INSERT_REPLYINPUT);
		// String sql=ReboardSQL.getSQL(8);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, oriNo);
			stmt.setString(2, writer);
			stmt.setString(3, title);
			stmt.setString(4, body);
			stmt.setString(5, pw);

			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("댓글입력쿼리문 실행에러=" + e);
		} finally {
			db.close(stmt);
		}

	}

	// 댓글수정
	public void updateReply(int oriNo, String title, String body, String pw) {
		String sql = ShopSQL.getSQL(ShopSQL.UPDATE_BOARDMODIFY);
		// String sql=ReboardSQL.getSQL(9);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setString(1, title);
			stmt.setString(2, body);
			stmt.setString(3, pw);
			stmt.setInt(4, oriNo);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("댓글수정쿼리문 실행에러=" + e);
		} finally {
			db.close(stmt);
		}
	}

	// 원글수정
	public void updateReboard(int oriNo, String title, String body, String pw) {
		String sql = ShopSQL.getSQL(ShopSQL.UPDATE_BOARDMODIFY);
		System.out.println("원글수정sql=" + sql);
		// String sql=ReboardSQL.getSQL(7);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setString(1, title);
			stmt.setString(2, body);
			stmt.setString(3, pw);
			stmt.setInt(4, oriNo);
			int c = stmt.executeUpdate();
			System.out.println(c);
		} catch (Exception e) {
			System.out.println("원글수정쿼리문 실행에러=" + e);
		} finally {
			db.close(stmt);
		}
	}

	// 원글상세보기 조회
	public ShopboardVO selectShopReboardView(int oriNo) {
		ResultSet rs = null;
		String sql = ShopSQL.getSQL(ShopSQL.SELECT_SHOPBOARDVIEW);
		// String sql=ReboardSQL.getSQL(5);
		PreparedStatement stmt = db.getSTMT(con, sql);
		ShopboardVO vo = new ShopboardVO(); // 원글상세내용을 기억하기위한 변수

		try {
			stmt.setInt(1, oriNo);
			rs = stmt.executeQuery();
			System.out.println("rs=" + rs);

			while (rs.next()) {
				// 결과셋을 모델로 만들어서 뷰에게 전달해야한다
				// 여러종류로 구성된 한 개의 데이터이므로 vo클래스이용
				// System.out.println("rs.getString(1)="+rs.getString(1));

				  vo.setPb_no(rs.getInt("pb_no"));
				  vo.setPb_img(rs.getString("pb_img"));
				  vo.setPb_title(rs.getString("pb_title")); vo.setM_img(rs.getString("m_img"));
				  vo.setM_nick(rs.getString("m_nick"));
				  vo.setM_addgun(rs.getString("m_addgun"));
				  vo.setM_addetc(rs.getString("m_addetc"));
				  vo.setPb_price(rs.getString("pb_price"));
				  vo.setPc_name(rs.getString("pc_name"));
				  vo.setBc_update(rs.getDate("bc_update")); vo.setLc_cnt(rs.getInt("lc_cnt"));
				  vo.setM_manner(rs.getString("m_manner"));
				  vo.setPb_comm(rs.getString("pb_comm"));
				  vo.setPb_replycnt(rs.getInt("pb_replycnt"));
				  vo.setPb_hit(rs.getInt("pb_hit"));
				 
			}
		} catch (Exception e) {
			System.out.println("원글상세내용조회 실행에러=" + e);
		} finally {
			db.close(rs);
			db.close(stmt);
		}

		return vo;
	}

	// 인기게시물 조회
	public List<ShopFamousboardVO> selectFamousview() {
		db = new POOLUtil();
		con = db.getCon();
		List<ShopFamousboardVO> list = null;
		ResultSet rs = null;
		String sql = ShopSQL.getSQL(ShopSQL.SELECT_FAMOUSPRODUCT);
		// String sql=ReboardSQL.getSQL(5);
		PreparedStatement stmt = db.getSTMT(con, sql);

		try {

			rs = stmt.executeQuery();

			while (rs.next()) {
				if (list == null)
					list = new ArrayList();
				ShopFamousboardVO vo = new ShopFamousboardVO(); // 원글상세내용을 기억하기위한 변수
				// 결과셋을 모델로 만들어서 뷰에게 전달해야한다
				// 여러종류로 구성된 한 개의 데이터이므로 vo클래스이용
				vo.setPb_no(rs.getInt("pb_no"));
				vo.setPb_img(rs.getString("pb_img"));
				vo.setPb_title(rs.getString("pb_title"));
				vo.setM_addsi(rs.getString("m_addsi"));
				vo.setM_addgun(rs.getString("m_addgun"));
				vo.setM_addetc(rs.getString("m_addetc"));
				vo.setPb_price(rs.getString("pb_price"));
				vo.setLc_cnt(rs.getInt("lc_cnt"));
				vo.setPb_replycnt(rs.getInt("pb_replycnt"));
				vo.setPb_hit(rs.getInt("pb_hit"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("인기매물 가져오기 실행에러=" + e);
		} finally {
			db.close(rs);
			db.close(stmt);
		}

		return list;
	}

	// 사용했던 connection닫기용 함수
	public void close() {
		db.close(con);
	}

}
