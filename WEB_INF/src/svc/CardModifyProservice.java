package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.CardBean;
import dao.CardDAO;

public class CardModifyProservice {
    public boolean isRightOfAccessCard(int emp_num, int dep_num, int pos_num, String passwd) throws
    Exception {

        boolean isRightOfAccessCard = false;
        Connection con = getConnection();
        CardDAO cardDAO = CardDAO.getInstance();
        cardDAO.setConnection(con);
        isRightOfAccessCard = cardDAO.isRightOfAccess(emp_num, dep_num, pos_num, passwd);

        close(con);
        return isRightOfAccessCard;
    }

    public boolean updateCard(CardBean list) throws Exception {

        boolean modifySuccess = false;
        Connection con = getConnection();
        CardDAO cardDAO = CardDAO.getInstance();
        cardDAO.setConnection(con);
        int updateCount = cardDAO.updateCard(list);

        if(updateCount > 0){
            commit(con);
            modifySuccess=true;
        }
        else {
            rollback(con);
        }

        close(con);
        return modifySuccess;
    }
}