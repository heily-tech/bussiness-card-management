package svc;

import vo.CardBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.CardDAO;

public class CardDetailService {
	public CardBean selectCard(int emp_num) throws Exception{

		CardBean card = null;
		Connection con = getConnection();
		CardDAO cardDAO = CardDAO.getInstance();
		cardDAO.setConnection(con);

		card = cardDAO.selectCard(emp_num);

		close(con);
		return card;
	}
}