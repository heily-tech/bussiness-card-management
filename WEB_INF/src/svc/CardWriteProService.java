package svc;

import java.sql.*;
import dao.CardDAO;
import vo.CardBean;
import static db.JdbcUtil.*;

public class CardWriteProService {
    public boolean insertCardList(CardBean list) throws
    Exception {
        boolean writeSuccess = false;
        Connection con = getConnection();
        CardDAO cardDAO = CardDAO.getInstance();
        cardDAO.setConnection(con);
        int inserCount = cardDAO.insertCardList(list);

        if(inserCount > 0){
            commit(con);
            writeSuccess = true;
        } else {
            rollback(con);
        }

        close(con);
        return writeSuccess;
    }
}