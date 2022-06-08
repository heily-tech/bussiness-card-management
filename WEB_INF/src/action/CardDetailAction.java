package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.CardDetailService;
import vo.ActionForward;
import vo.CardBean;

public class CardDetailAction implements Action {
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		int emp_num = Integer.parseInt(request.getParameter("emp_num")); //상세 내용플 보고자하는 사원 번호
		String page = request.getParameter("page"); //파라미터로 전송되는 페이지 번호를 받음
		CardDetailService cardDetailService = new CardDetailService();
		CardBean article = cardDetailService.selectCard(emp_num); //파라미터로 전송된 사원 번호의 사원 정보를 반환
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		forward.setPath("/webapp/card_detail.jsp"); //받아온 정보를 상세보기 페이지로 넘김
		return forward;
	}
}
