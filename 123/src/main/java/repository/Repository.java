package repository;

import java.util.List;
import java.util.Map;

import vo.CardBean;

public interface Repository {

	public List<CardBean> getList(int page);
	
	public int getSize(int page);
	
	public int getMaxSize();

	public int save(CardBean card);

	public int delete(int card);

	public int modify(CardBean card);

	public CardBean detail(int num);
}
