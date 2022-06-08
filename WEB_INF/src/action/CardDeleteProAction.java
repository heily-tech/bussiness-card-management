package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.CardDeleteProService;
import vo.ActionForward;

public class CardDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 

		ActionForward forward = null;
		int EMP_NUM = Integer.parseInt(request.getParameter("EMP_NUM"));
		int DEP_NUM = Integer.parseInt(request.getParameter("DEP_NUM"));
		int POS_NUM = Integer.parseInt(request.getParameter("POS_NUM"));
		String nowPage = request.getParameter("page");
		CardDeleteProService cardDeleteProService = new CardDeleteProService();
		boolean isRightWriter = cardDeleteProService.isRightOfAccessCard(EMP_NUM, DEP_NUM, POS_NUM, request.getParameter("EMP_PASS"));

		if(!isRightWriter){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}

		else{
			
			boolean isDeleteSuccess = cardDeleteProService.deleteCard(EMP_NUM);

			if(!isDeleteSuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("card_list.bo?page=" + nowPage);
			}
			
		}


		return forward;
	}

}