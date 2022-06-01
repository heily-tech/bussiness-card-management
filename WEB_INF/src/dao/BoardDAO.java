package dao;


import static db.JdbcUtil.*;//jdbc 연결 안하고 작성함.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

//vo 객체 import 해야함

public class BoardDAO {

	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO;

	private BoardDAO() {}
	
	
	//싱글톤 패턴으로 boardDAO 객체가 null이면 새로운 객체를 생성 후 반환
	public static BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}

	//접근자는 여기서 가지고 오지 않음
	public void setCon(Connection con) {
		this.con = con;
	}
	
	//글 목록보기
	//vo 객체 등 여러 객체와 클래스가 없는 관계로 테스트 불가능.
	public ArrayList</*VO객체*/> selectArticleList(/*매개변수 미정 : 교재에서는 page와 limit 사용함. 스크롤로 쭉 내리는 형식이라면 두 개다 필요없음.*/){
		//pstmt와 rs 초기화
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//직급과 사원번호 순으로 오름차순 정렬
		String board_list_sql="select * from bcard order by pos_num, emp_num asc";
		//vo 객체에 담을 arraylist 초기화
		ArrayList</*VO객체*/> articleList = new ArrayList</*VO객체*/>();
		//vo 객체 초기화
		/*vo객체 선언 필요*/ board = null;
		

		//오류처리 및 설정자를 이용해서, 접근자로 불러온 데이터를 저장.
		
		//vo객체로 인해 직렬화 불필요.
		try {
			//정렬된 목록 불러오기
			pstmt = con.prepareStatement(board_list_sql);
			rs = pstmt.executeQuery();
			
			//board 객체에 더이상 검색되는 데이터가 없을 때까지 넣음.
			while(rs.next()) {
				//새로운 vo객체 생성
				board = new /*vo객체 선언 필요*/;
				board.setBoard_NUM(rs.getInt(""));// "" 안에 해당하는 vo객체명 넣어야함. 아래도 동일함.
				board.setBoard_NAME(rs.getString(""));
				board.setBoard_SNUM(rs.getInt(""));//주민번호
				board.setBoard_DEP(rs.getInt(""));//부서
				board.setBoard_NUM(rs.getInt(""));//직위
				board.setBoard_MOBILE(rs.getInt(""));
				board.setBoard_PHONE(rs.getInt(""));//부서번호
				board.setBoard_FAX(rs.getInt(""));
				board.setBoard_EMAIL(rs.getString(""));
				board.setBoard_EDATE(rs.getDate(""));//입사일
				board.setBoard_RDATE(rs.getDate(""));//퇴사일
				articleList.add(board);
			}
		}catch(Exception e) {
			System.out.println("getBoardList 에러 : " + e);
		}finally {
			close(rs);
			close(pstmt);
		}
	return articleList;
		
	}
	
}
