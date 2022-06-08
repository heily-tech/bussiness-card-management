package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CardDAO;
import vo.CardBean;


@WebServlet("*.bo")
public class CardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hole(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hole(request, response);
    }

    private void hole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri = request.getRequestURI();
        int pos = uri.lastIndexOf('/');
        int length = uri.length();
        String path = uri.substring(pos + 1, length - 3);
        CardDAO dao = CardDAO.getInstance();
        request.setCharacterEncoding("utf-8");
        
        List<CardBean> list = new ArrayList<CardBean>();
        
        Map<String, String> paramMap = new HashMap<String, String>();
    	request.getParameterNames().asIterator().forEachRemaining(name -> paramMap.put(name, request.getParameter(name)));
        
        if (path.equals("cardList")) {
            list = dao.getList(0, 10);
            
            request.setAttribute("list", list);
            RequestDispatcher rd = request.getRequestDispatcher("card_list.jsp");
            rd.forward(request, response);

        } else if (path.equals("cardWrite")) {
        	dao.save(paramMap);
        	response.sendRedirect("/123");
        } else if (path.equals("cardDelete")) {
        	dao.delete(paramMap);
        	response.sendRedirect("/123");
        } else if (path.equals("cardModify")) {
        	dao.modify(paramMap);
        	response.sendRedirect("/123");
        } else if (path.equals("cardDetail")) {
        	CardBean card = dao.detail(paramMap);
        	
        	request.setAttribute("card", card);
            RequestDispatcher rd = request.getRequestDispatcher("card_detail.jsp");
            rd.forward(request, response);
        } else if (path.equals("cardModifyView")) {
        	CardBean card = dao.detail(paramMap);        	
        	request.setAttribute("card", card);
            RequestDispatcher rd = request.getRequestDispatcher("card_modify.jsp");
            rd.forward(request, response);
        } else if (path.equals("cardDeleteView")) {
        	CardBean card = dao.detail(paramMap);
        	request.setAttribute("card", card);
            RequestDispatcher rd = request.getRequestDispatcher("card_delete.jsp");
            rd.forward(request, response);
        }
        
    }

}