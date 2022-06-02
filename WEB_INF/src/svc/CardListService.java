package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.CardDAO;
import vo.CardBean;

public class CardListService {
    public int getListCount() throws Exception {
        int listCount = 0;
        Connection conn = getConnection();
        CardDAO cardDAO = CardDAO.getInstance();
        cardDAO.setConnection(conn);
        listCount = cardDAO.selectListCount();
        close(conn);
        return listCount;
    }

    public ArrayList<CardBean> getCardList() throws Exception {
        Connection conn = getConnection();
        CardDAO cardDAO = CardDAO.getInstance();
        cardDAO.setConnection(conn);
        ArrayList<CardBean> cardList = cardDAO.selectCardList();
        close(conn);
        return cardList;
    }
}
