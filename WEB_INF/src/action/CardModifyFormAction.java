package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.CardDetailService;
import vo.ActionForward;
import vo.CardBean;

public class CardModifyFormAction implements Action {
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int emp_num = Integer.parseInt(request.getParameter("emp_num"));
		CardDetailService cardDetailService = new CardDetailService();
		CardBean article = cardDetailService.selectCard(emp_num);
		request.setAttribute("article", article);
		forward.setPath("/webapp/card_modify.jsp");
		return forward;
	}
}