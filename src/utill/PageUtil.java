package utill;

//이 클래스는 페이징관련 기능제공
/* 
 *   [<<] [1] [2] [3] [4] [5] [>>] 으로 보이게 만든다
 * 
 *   [<<] [1] [2] [3] [>>] 으로 보이게 만든다
 * */
public class PageUtil {

	//변수
	//필수변수 
	private int nowPage;		//보고싶은페이지
	private int totalCount;		//총게시물 수
	//계산에 필요한 변수
	private int listCount;		//1페이지당 보여줄 게시물목록수 3건  1p 1-3  2p 4-6 3p 7-9
	private int pageCount;		//한번에 보여줄 페이지수  5
	//계산에 의해 구해질 값을 저장하기 위한 변수
	private int totalPage;		//총 페이지수  102/10 = 10+1
	private int startPage;		//화면에 표시할 시작페이지		1 2 3 4 5
	private int endPage;		//화면에 표시할 마지막페이지     6 7 8 9 10
	
	
	//생성자   보고싶은페이지,총게시물수 생성자를 통해 받고, 나머지2개는 개발자가 지정 
	public PageUtil(int nowPage, int totalCount) { 
		this(nowPage, totalCount, 5, 5);//Constructor call must be the first statement in a constructor
		/*
		 * this.nowPage=nowPage; //보고싶은페이지 this.totalCount=totalCount; //총게시물 수
		 * this.listCount=3; //1페이지당 보여줄 게시물수 this.pageCount=5; //한번에 보여줄 페이지수
		 * 
		 * calcTotalPage(); //총 페이지수 calcStartPage(); //화면에 표시할 시작페이지 calcEndPage();
		 * //화면에 표시할 마지막페이지
		 */	
	}	
	
	//new  PageUtil(int nowPage, int totalCount, 3, 5)
	public PageUtil(int nowPage, int totalCount, int listCount, int pageCount) { 
		this.nowPage=nowPage;    	//보고싶은페이지
		this.totalCount=totalCount; //총게시물 수
		this.listCount=listCount; 	//1페이지당 보여줄 게시물수
		this.pageCount=pageCount;	//한번에 보여줄 페이지수
		
		calcTotalPage(); 			//총 페이지수
		calcStartPage();			//화면에 표시할 시작페이지
		calcEndPage();				//화면에 표시할 마지막페이지 
	}	
	
	//함수
	//총 페이지수    전체게시물수102/10 = 10+1
	protected void calcTotalPage() {
		/* 전체게시물수/1페이지당보여줄게시물수 
		 * 예) 120/10 = 12  <=나머지가0인경우의 공식		 
		 * 예) 119/10 = 11페이지+9게시물 =10페이지+1페이지 =11페이지   <=그외의 공식       */  
		totalPage =  (totalCount%listCount==0)?(totalCount/listCount):(totalCount/listCount)+1; 
	}
	
	//화면에 표시할 시작페이지		1 2 3 4 5       2 3 4 5 6    //pageCount-한번에 보여줄 페이지수
	protected void calcStartPage() {
		//pageGroup이란 보고싶은페이지인 nowPage가 속한 그룹을 의미
		//우리는 한번에 5페이지씩 보여줄 예정     pageCount=5
		// 1  2   3   4   5  	pageGroup=1그룹
		// 6  7   8   9   10	pageGroup=2
		// 11 12  13  14  15	pageGroup=3
		int pageGroup = (nowPage%pageCount==0)?(nowPage/pageCount):(nowPage/pageCount)+1;

		startPage = (pageGroup-1)*pageCount+1;
	}
	
	//화면에 표시할 마지막페이지 
	protected void calcEndPage() {
     //마지막페이지= 시작페이지+한번에보여줄페이지수-1
		endPage = startPage+pageCount-1;   
		if(endPage>=totalPage) {  
			endPage=totalPage;
		}
	}

	
	// getter & setter
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PageUtil [nowPage=" + nowPage + ", totalCount=" + totalCount + ", listCount=" + listCount
				+ ", pageCount=" + pageCount + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
	
	
}















