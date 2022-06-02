package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;*/

 public class BoardListAction implements Action {

	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ArrayList</*BoardBean*/> articleList=new ArrayList</*BoardBean*/>(); //전체 명함 목록 저장.
	  	int page=1;
		  int limit=10;

		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}

		/*BoardListService boardListService = new BoardListService();*/
		int listCount=boardListService.getListCount(); //총 명함의 수를 받아옴.
		articleList = boardListService.getArticleList(page,limit); //페이지에 출력될 명함 목.
    int maxPage=(int)((double)listCount/limit+0.95); //총 페이지 수.0.95를 더해서 올림 처리.
    int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1; //현재 페이지에 보여줄 시작 페이지 수.(1, 11, 21...)
   	int endPage = startPage+10-1;	//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30...)

   	if (endPage > maxPage) endPage= maxPage;

   	PageInfo pageInfo = new PageInfo();
   	pageInfo.setEndPage(endPage);
   	pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward= new ActionForward();
   		forward.setPath("/card_list.jsp");
   		return forward;

	 }

 }
