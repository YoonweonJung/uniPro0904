package dispatcher;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URL과  CLASS를 연결하는 부분
@WebServlet("*.ho")
public class ShopReboarDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    //요청이 들어오면    어떤 컨트롤러가 사용이되어질지를 저장하는 Map선언
	private HashMap map = new HashMap(); //컨트롤러가 저장
    
	public ShopReboarDispatcher() {
        super();
    }

    //최초로   *.bo으로 요청하는 단 한번만 실행되는 함수 - 주로 초기화 작업
	public void init(ServletConfig config) throws ServletException {
		//자바의 (Map방식으로 처리하는 )Propertise을 이용하여
		//별도의 파일에 있는 내용을 Map으로 만들고
		//실행가능한 클래스로 만들자
		
		//Properties을 이용하여 파일을 읽어오자
		//1. 읽을 파일에 연결하는 InputStream, Reader를 만든다
		//2. load함수를 이용하여 Map으로 생성한다
		Properties prop = new Properties();
		
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("E:\\workspace\\uniPro\\src\\dispatcher\\ShopreboarDispatcher.properties");
			prop.load(fin);
		} catch (Exception e) {
			System.out.println("파일못찾거나 Map으로 변환실패="+e);
		}
		
		//Map이 된 것을 확인
		/*
		 * Set set1 =prop.keySet(); //map은 key와 value로 구성이 되어있는데, key와 value를 set하나로 묶는
		 * //메소드 Iterator iter1 = set1.iterator(); while( iter1.hasNext() ) { String
		 * key1=(String)iter1.next(); String value1 = prop.getProperty(key1);
		 * System.out.println(key1 +"=="+value1); }
		 */
				
		Set set =prop.keySet(); //map은 key와 value로 구성이 되어있는데, key와 value를 set하나로 묶는 메소드 
		Iterator iter = set.iterator(); 
		while( iter.hasNext() ) { 
			String key=(String)iter.next(); 
			String value = prop.getProperty(key); // 문자
			//map에 담긴 문자열을    실행가능한 클래스로 만들어야 한다
			// Class.forName()		
			// 강제로 new시킨다
			// newInstance()
			try {
				Class c = Class.forName(value);
				ShopreboardSuper father=(ShopreboardSuper)c.newInstance();
				
				map.put(key, father);
			} catch (Exception e) {
				System.out.println("실행가능한 클래스로 변환관련 에러="+e);
			}
		 }
		
	}

	//get방식으로 요청되면 실행함수
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청을 알아내서
		String path = request.getServletPath();
		System.out.println("String path ="+path);
		
		//그 요청을 담당하는 담당컨트롤러를 찾고
		ShopreboardSuper father = (ShopreboardSuper)map.get(path);
		System.out.println("ShopReboardSuper father ="+father);
		
		//실행한다 
		String viewPage = father.execute(request, response);
		
		//컨트롤러의 실행이 종료되면 리턴받는 뷰를 응답문서로 만든다
		try {
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}catch(Exception e) {
			System.out.println("에러"+e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
