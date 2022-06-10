package repository;

import java.util.List;
import java.util.Map;

import dao.CardDAO;
import service.CardService;
import vo.CardBean;

public class CardRepository implements Repository {

	private final CardDAO dao = CardDAO.getInstance();

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
