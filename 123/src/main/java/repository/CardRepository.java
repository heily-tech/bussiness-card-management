package repository;

import java.util.List;
import java.util.Map;

import dao.CardDAO;
import service.CardService;
import vo.CardBean;

public class CardRepository implements Repository {

	private final CardDAO dao = CardDAO.getInstance();
	
	//2022-06-10 권한 확인 메소드_고동욱, 사공인
	@Override
	public boolean rightOfAccess(int num, String passwd) {
		return dao.rightOfAccess(num, passwd);
	}
	
	//2022-06-10 로그인 메소드_고동욱, 사공인
	@Override
	public boolean loginSuccess(int emp_num, String passwd) {
		return dao.selectLogin(emp_num, passwd);
	}

	@Override
	public List<CardBean> getList(int page) {
		return dao.getList(page);
	}

	@Override
	public int save(CardBean card) {
		return dao.save(card);
		
	}

	@Override
	public int delete(int num) {
		return dao.delete(num);
	}

	@Override
	public int modify(CardBean card) {
		return dao.modify(card);
	}

	@Override
	public CardBean detail(int num) {
		return dao.detail(num);
	}

	@Override
	public int getSize(int page) {
		return dao.getSize(page);
	}
	
	@Override
	public int getMaxSize() {
		return dao.getMaxSize();
	}

}