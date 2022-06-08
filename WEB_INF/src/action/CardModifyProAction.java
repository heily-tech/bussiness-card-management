package action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.CardModifyProservice;
import vo.ActionForward;
import vo.CardBean;

public class CardModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		int EMP_NUM = Integer.parseInt(request.getParameter("EMP_NUM"));
		int DEP_NUM = Integer.parseInt(request.getParameter("DEP_NUM"));
		int POS_NUM = Integer.parseInt(request.getParameter("POS_NUM"));
		int MOBILE = Integer.parseInt(request.getParameter("MOBILE"));
		int PHONE = Integer.parseInt(request.getParameter("PHONE"));
		int FAX = Integer.parseInt(request.getParameter("FAX"));
		int SOC_NUM = Integer.parseInt(request.getParameter("SOC_NUM"));
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date D_ENTRY = df.parse(request.getParameter("D_ENTRY"));
		Date D_RESIGN = df.parse(request.getParameter("D_RESIGN"));
		CardBean article = new CardBean();
		CardModifyProservice cardModifyProservice = new CardModifyProservice();
		boolean isRightWriter = cardModifyProservice.isRightOfAccessCard(EMP_NUM, DEP_NUM, POS_NUM, request.getParameter("EMP_PASS")); //Service 부재

		if(!isRightWriter){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setEMP_NUM(EMP_NUM);
			article.setEMP_PASSWD(request.getParameter("EMP_PASSWD"));
			article.setNAME_KOR(request.getParameter("NAME_KOR"));
			article.setNAME_ENG(request.getParameter("NAME_ENG"));
			article.setDEP_NUM(DEP_NUM);
			article.setPOS_NUM(POS_NUM);
			article.setMOBILE(MOBILE);
			article.setPHONE(PHONE);
			article.setFAX(FAX);
			article.setEMAIL(request.getParameter("EMAIL"));
			article.setD_ENTRY(D_ENTRY);
			article.setD_RESIGN(D_RESIGN);
			article.setSOC_NUM(SOC_NUM);
			isModifySuccess = cardModifyProservice.updateCard(article);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num="+article.getEMP_NUM()); 
			}

		}

		return forward;
	}

}