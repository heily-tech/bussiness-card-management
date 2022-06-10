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
	
	//2022-06-10 수정 권한 확인 메소드_고동욱, 사공인
	public boolean rightOfAccess(int num, String passwd);
	
	public boolean loginSuccess(int emp_num, String passwd);
}