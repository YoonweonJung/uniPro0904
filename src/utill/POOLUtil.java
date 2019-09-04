package utill;

import java.sql.*;

import javax.naming.Context;

//커넥션 풀과 관련한 클래스
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DB작업할 때 필요한 공통적인 기능을 제공하기 위한 클래스
//DB연동시 ConnectionPool이용
public class POOLUtil {
	
	//외부에서 해당클래스의 기능을 사용하려면 객체생성하는데
	//이 때  가장 먼저 필요로하는 드라이버 로딩까지 해주겠다
	//POOLUtil db = new POOLUtil();
	
	//커넥션풀을 기억하기위한 변수
	DataSource ds = null;
	
	
	//드라이버 로딩
	public POOLUtil(){
		try {
			//context.xml에 설정된 dbcp에서 커넥션을 가져온다
			//context.xml 파일을 분석하는데 필요한 객체
			Context initContext = new InitialContext();
			
			//context.xml파일의 resource태그의 name속성을 검색
			//  java:/comp/env/리소스태그의 name
			/*Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
			//위의 2줄을 아래의 한줄로 바꿀수 있다
			*/
			
			ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
			
		} catch (Exception e) {
			System.out.println("드라이버 로딩 에러="+e);
		}
	}

	//자바 응용프로그램과 JDBC의 연결=>오라클에 접속
	//누군가가 접속을하고 싶다면  접속을 해주는 기능을 제공함수
	public Connection  getCon() {
		Connection con = null;
		try {
			//커넥션풀에서 커넥션을 리턴받음.
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("접속 관련 에러="+e);
		}
		System.out.println("db접속 성공");
		return con;
	}
	
	
	//JDBC와    실제DBMS에 명령어 전달,실행할 도구가 필요-Statement제공
	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("Statement제공관련 에러="+e);
		}
		return stmt;
	}
	
	//JDBC와    실제DBMS에 명령어 전달,실행할 도구가 필요-PreparedStatement제공
	public PreparedStatement getSTMT(Connection con,String sql) {
		PreparedStatement pstmt = null;
		try {	
			pstmt = con.prepareStatement(sql);
		} catch (Exception e) {
			System.out.println("PreparedStatement제공관련 에러="+e);
		}	
		return pstmt;
	}
	
	//자원반납
	//닫을 종류가 많으니  매개변수의 타입을 Object로 선언 
	public void close(Object obj) {
		try {
			if(obj instanceof ResultSet ) {
				ResultSet rs = (ResultSet)obj;
				rs.close();
			}
			else if(obj instanceof Statement) {
				Statement temp = (Statement)obj;
				temp.close();
			}
			else if(obj instanceof PreparedStatement) {
				PreparedStatement temp = (PreparedStatement)obj;
				temp.close();
			}
			else if(obj instanceof Connection) {
				((Connection)obj).close();
			}
		} catch (Exception e) {
			System.out.println("자원반납관련 에러="+e);
		}
	}
}





