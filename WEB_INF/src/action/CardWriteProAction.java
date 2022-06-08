package action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CardWriteProService;
import vo.ActionForward;
import vo.CardBean;

public class CardWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
	
		ActionForward forward=null;
		CardBean CardBean = null;
		
		ServletContext context = request.getServletContext();
		CardBean cardBean = new CardBean();
		cardBean.setEMP_NUM(EMP_NUM);
		cardBean.setEMP_PASSWD(request.getParameter("EMP_PASSWD"));
		cardBean.setNAME_KOR(request.getParameter("NAME_KOR"));
		cardBean.setNAME_ENG(request.getParameter("NAME_ENG"));
		cardBean.setDEP_NUM(DEP_NUM);
		cardBean.setPOS_NUM(POS_NUM);
		cardBean.setMOBILE(MOBILE);
		cardBean.setPHONE(PHONE);
		cardBean.setFAX(FAX);
		cardBean.setEMAIL(request.getParameter("EMAIL"));
		cardBean.setD_ENTRY(D_ENTRY);
		cardBean.setD_RESIGN(D_RESIGN);
		cardBean.setSOC_NUM(SOC_NUM);
		CardWriteProService cardWriteProService = new CardWriteProService();
		boolean isWriteSuccess = cardWriteProService.insertCardList(cardBean);

		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("cardList");
		}

		return forward;

	}

}
