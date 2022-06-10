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
				.depNum(Integer.parseInt(param.get("dep_num")))
				.posNum(Integer.parseInt(param.get("pos_num")))
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

	public int delete(Map<String, String> param) {
		return repository.delete(Integer.parseInt(param.get("emp_num")));
	}

	public int modify(Map<String, String> param) {
		CardBean card = CardBean.builder()
				.empNum(Integer.parseInt(param.get("emp_num")))
				.empPasswd(param.get("emp_passwd"))
				.nameKor(param.get("name_kor"))
				.nameEng(param.get("name_eng"))
				.depNum(Integer.parseInt(param.get("dep_num")))
				.posNum(Integer.parseInt(param.get("pos_num")))
				.mobile(param.get("mobile"))
				.phone(param.get("phone"))
				.fax(param.get("tel"))
				.email(param.get("email"))
				.dEntry(param.get("d_entry"))
				.dResign(param.get("e_resign"))
				.socNum(param.get("soc_num"))
				.build();
		
		return repository.modify(card);
	}

	public CardBean detail(Map<String, String> param) {
		return repository.detail(Integer.parseInt(param.get("emp")));
	}
}
