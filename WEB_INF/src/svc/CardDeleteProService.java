package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.CardDAO;

public class CardDeleteProService {

	
	/***** 명함 삭제 권한 검증 처리 *****/
	public boolean isRightOfAccessCard(int emp_num, int dep_num, int pos_num, String passwd) throws Exception{
		boolean isRightOfAccessCard = false;
		
		//jdbcUtil에 있는 getConnection 불러옴
		//import가 static 임으로 객체 불필요.
		Connection con = getConnection();
		
		//반대로 CardDao는 동적 import 임으로 객체 필요. 
		//getInstance는 싱글톤 패턴으로 작성되었던, CardDao 객체 생성 메소드. 
		CardDAO cardDao = CardDAO.getInstance();
		
		//커넥터를 설정자를 이용해 dao 객체에 연결
		cardDao.setConnection(con);
		
		//이 곳의 매개변수를 dao에 있는 권한검사로 옮기어 전처리 한 후 반환된 boolean 값을 저장
		isRightOfAccessCard = cardDao.isRightOfAccess(emp_num, dep_num, pos_num, passwd);
		
		close(con);
		
		return isRightOfAccessCard;
		
	}
	
	/***** 명함 삭제 요청 처리 *****/
	public boolean deleteCard(int emp_num) throws Exception{
		boolean deleteSuccess = false;
		
		Connection con = getConnection();
		CardDAO cardDAO = CardDAO.getInstance();
		cardDAO.setConnection(con);
		
		//매개변수를 CardDao의 deleteCard 메소드에서 전처리 한 후 int을 저장
		//성공할 경우 최소 1 이상이 들어온다.
		int deleteCount = cardDAO.deleteCard(emp_num);
		
		//1 이상의 값이 들어오면 commit, 그 외에는 rollback한다.
		if(deleteCount>0) {
			commit(con);
			deleteSuccess = true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return deleteSuccess;
	}
}
