package dao;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import vo.CardBean;

public class CardDAO {

	private Connection con;
	private static CardDAO instance;

	private CardDAO() {
	}

	public static CardDAO getInstance() {
		if (instance == null)
			instance = new CardDAO();

		return instance;
	}

	public List<CardBean> getList(int page) {
		page--; //0부터 페이지 시작
		con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String card_list_sql = "select * from bcard limit ?, ?";
		List<CardBean> list = new ArrayList<CardBean>();
		CardBean card = null;

		try {
			pstmt = con.prepareStatement(card_list_sql);
			pstmt.setInt(1, page * 6);
			pstmt.setInt(2, 6);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				card = new CardBean();
				card.setEmpNum(rs.getInt("EMP_NUM"));
				card.setNameKor(rs.getString("NAME_KOR"));
				card.setSocNum(rs.getString("SOC_NUM"));
				card.setDepNum(rs.getString("DEP_NUM")); // int에서 String 변환
				card.setPosNum(rs.getString("POS_NUM")); // int에서 String 변환
				card.setMobile(rs.getString("MOBILE"));
				card.setPhone(rs.getString("PHONE"));
				card.setFax(rs.getString("FAX"));
				card.setEmail(rs.getString("EMAIL"));
				card.setDEntry(rs.getString("D_ENTRY"));
				card.setDResign(rs.getString("D_RESIGN"));
				list.add(card);
			}
		} catch (Exception e) {
			System.out.println("getCardList 에러 : " + e);
		} finally {
			if (rs != null)
				close(rs);
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}

		return list;
	}

	public int save(CardBean c) {
		con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into bcard values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String temp = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c.getEmpNum());
			pstmt.setString(2, c.getEmpPasswd());
			pstmt.setString(3, c.getNameKor());
			pstmt.setString(4, c.getNameEng());
			pstmt.setString(5, c.getDepNum());//int에서 String으로 변환
			pstmt.setString(6, c.getPosNum());//int에서 String으로 변환
			pstmt.setString(7, c.getMobile());
			pstmt.setString(8, c.getPhone());
			pstmt.setString(9, c.getFax());
			pstmt.setString(10, c.getEmail());
			pstmt.setString(11, c.getDEntry());
			temp = c.getDResign();
			pstmt.setString(12, temp.equals("") ? null : temp);
			pstmt.setString(13, c.getSocNum());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertCardList 에러 : " + e);
		} finally {
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}

		return -1;
	}

	public int delete(int num) {
		con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from bcard where EMP_NUM=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("CardDelete  : " + e);
		} finally {
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}

		return -1;
	}

	public int modify(CardBean c) {
		con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update bcard set name_kor=?, name_eng=?, soc_num=?, emp_passwd=?, dep_num=?, pos_num=?, mobile=?, phone=?, fax=?, email=?, d_entry=?, d_resign=? where emp_num=?";
		String temp = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c.getNameKor());
			pstmt.setString(2, c.getNameEng());
			pstmt.setString(3, c.getSocNum());
			pstmt.setString(4, c.getEmpPasswd());
			pstmt.setString(5, c.getDepNum());//int에서 String으로 변환
			pstmt.setString(6, c.getPosNum());//int에서 String으로 변환
			pstmt.setString(7, c.getMobile());
			pstmt.setString(8, c.getPhone());
			pstmt.setString(9, c.getFax());
			pstmt.setString(10, c.getEmail());
			pstmt.setString(11, c.getDEntry());

			temp = c.getDResign();
			pstmt.setString(12, temp.equals("") ? null : temp); //퇴사일
			pstmt.setInt(13, c.getEmpNum());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertCardList 에러 : " + e);
		} finally {
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}

		return -1;
	}

	public CardBean detail(int num) {
		con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		CardBean card = null;
		String sql = "select * from bcard where emp_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				card = new CardBean();
				card.setEmpNum(rs.getInt("EMP_NUM"));
				card.setNameKor(rs.getString("NAME_KOR"));
				card.setNameEng(rs.getString("NAME_ENG"));
				card.setSocNum(rs.getString("SOC_NUM"));
				card.setDepNum(rs.getString("DEP_NUM"));//int에서 String으로 변환
				card.setPosNum(rs.getString("POS_NUM"));//int에서 String으로 변환
				card.setMobile(rs.getString("MOBILE"));
				card.setPhone(rs.getString("PHONE"));
				card.setFax(rs.getString("FAX"));
				card.setEmail(rs.getString("EMAIL"));
				card.setDEntry(rs.getString("D_ENTRY"));
				card.setDResign(rs.getString("D_RESIGN"));
			}

			return card;
		} catch (Exception e) {
			System.out.println("CardDelete  : " + e);
		} finally {
			if (rs != null)
				close(rs);
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}

		return null;
	}
	
	public int getSize(int page) {
		page--;
		con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bcard limit ?, ?";
		int cnt = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, page * 6);
			pstmt.setInt(2, 7);
			rs = pstmt.executeQuery();

			while (rs.next())
				cnt++;
			
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				close(rs);
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}
		
		return -1;
	}
	
	public int getMaxSize() {
		con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from bcard";
		int page = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next())
				page = rs.getInt(1);
			
			return page % 6 == 0 ? page / 6 : page / 6 + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				close(rs);
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}
		
		return -1;
	}
	//2022-06-10 권한 확인 메소드_고동욱, 사공인
	public boolean rightOfAccess(int emp_num, String passwd) {
		con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bcard where emp_num=?";
		boolean hasPower = false;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if(rs.getString("emp_passwd").equals(passwd)) {
					//숫자에서 문자열 비교로 바꿈
					if(rs.getString("pos_num").equals("사장") || (rs.getString("pos_num").equals("부장") && rs.getString("dep_num").equals("인사과"))) {
						hasPower = true;
					}
				}	
			}
		} catch (Exception e) {
			System.out.println("CardAccess 에러 : " + e);
		} finally {
			if (rs != null)
				close(rs);
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}
		return hasPower;
	}
	//2022-06-10 로그인 검증 메소드_고동욱, 사공인
	public boolean selectLogin(int emp_num, String passwd) { //로그인
		con = getConnection();
		boolean loginSuccess = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bcard where emp_num=? and emp_passwd = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp_num);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				loginSuccess =true;
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Login 에러 : " + e);
		} finally {
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}

		return loginSuccess;
	}
}