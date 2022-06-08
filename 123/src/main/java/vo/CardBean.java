package vo;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardBean {
	
	private int empNum;
	private String empPasswd;
	private String nameKor;
	private String nameEng;
	private int depNum;
	private int posNum;
	private String mobile;
	private String phone;
	private String fax;
	private String email;
	private Date dEntry;
	private Date dResign;
	private String socNum;

	
	
}