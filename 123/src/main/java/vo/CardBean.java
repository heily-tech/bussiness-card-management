package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardBean {
	
	private int empNum;
	private String empPasswd;
	private String nameKor;
	private String nameEng;
	private String depNum;
	private String posNum;
	private String mobile;
	private String phone; 
	private String fax; 
	private String email;
	private String dEntry;
	private String dResign;
	private String socNum;
	
}