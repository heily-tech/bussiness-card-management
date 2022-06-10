package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import repository.CardRepository;
import repository.Repository;
import vo.CardBean;
import vo.Page;

public class CardService {
	
	private final Repository repository = new CardRepository();
	
	public List<CardBean> getList(Map<String, String> param) {
		return repository.getList(Integer.parseInt(param.get("page")));
	}
	
	public int getSize(int page) {
		return repository.getSize(page);
	}
	
	public List<Page> getMaxSize() {
		List<Page> list = new ArrayList<Page>();
		int size =  repository.getMaxSize();
		for (int i = 1; i <= size; i++)
			list.add(new Page(i));
		
		return list;
	}

	public int save(Map<String, String> param) {
		CardBean card = CardBean.builder()
				.empNum(Integer.parseInt(param.get("emp_num")))
				.empPasswd(param.get("emp_passwd"))
				.nameKor(param.get("name_kor"))
				.nameEng(param.get("name_eng"))
				.depNum(param.get("dep_num"))
				.posNum(param.get("pos_num"))
				.mobile(param.get("mobile"))
				.phone(param.get("phone"))
				.fax(param.get("tel"))
				.email(param.get("email"))
				.dEntry(param.get("d_entry"))
				.dResign(param.get("e_resign"))
				.socNum(param.get("soc_num"))
				.build();
		
		return repository.save(card);
	}
	//2022-06-10 삭제 권한 확인 메소드_사공인
	public int delete(Map<String, String> param) {
		if(repository.rightOfAccess(Integer.parseInt(param.get("emp_num")), param.get("emp_passwd"))) {
			return repository.delete(Integer.parseInt(param.get("emp_num")));
		}
		return -1;
	}

	public int modify(Map<String, String> param) {
		CardBean card = CardBean.builder()
				.empNum(Integer.parseInt(param.get("emp_num")))
				.empPasswd(param.get("emp_passwd"))
				.nameKor(param.get("name_kor"))
				.nameEng(param.get("name_eng"))
				.depNum(param.get("dep_num"))
				.posNum(param.get("pos_num"))
				.mobile(param.get("mobile"))
				.phone(param.get("phone"))
				.fax(param.get("tel"))
				.email(param.get("email"))
				.dEntry(param.get("d_entry"))
				.dResign(param.get("e_resign"))
				.socNum(param.get("soc_num"))
				.build();
				
		//2022-06-10 수정 권한 확인 메소드_고동욱, 사공인
		if(repository.rightOfAccess(Integer.parseInt(param.get("emp_num")), param.get("emp_passwd"))) {
			return repository.modify(card);
		}
		return -1;
	}

	public CardBean detail(Map<String, String> param) {
		return repository.detail(Integer.parseInt(param.get("emp")));
	}
	
	public boolean login(Map<String, String> param) {
		boolean loginSuccess = false;
		if(repository.loginSuccess(Integer.parseInt(param.get("emp_num")), param.get("emp_passwd"))) {
			loginSuccess = true;
		}
		return loginSuccess;
	}
}