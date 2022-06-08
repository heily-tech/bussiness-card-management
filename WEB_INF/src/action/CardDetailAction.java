package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.CardDetailService;
import vo.ActionForward;
import vo.CardBean;

public class CardDetailAction implements Action {
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		int emp_num = Integer.parseInt(request.getParameter("emp_num"));
		String page = request.getParameter("page");
		CardDetailService cardDetailService = new CardDetailService();
		CardBean article = cardDetailService.selectCard(emp_num);
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		forward.setPath("/webapp/card_detail.jsp");
		return forward;
	}
}