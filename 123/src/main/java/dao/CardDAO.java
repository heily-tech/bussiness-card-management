package dao;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import vo.CardBean;

public class CardDAO {

	private Connection con;
	private static CardDAO cardDAO;

	private CardDAO() {
	}

	public static CardDAO getInstance() {
		if (cardDAO == null)
			cardDAO = new CardDAO();
		
		return cardDAO;
	}

	public List<CardBean> getList(int page, int limit) {
		con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String card_list_sql = "select * from bcard order by pos_num, emp_num asc limit ?, 10";
		List<CardBean> list = new ArrayList<CardBean>();
		CardBean card = null;

		try {
			pstmt = con.prepareStatement(card_list_sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				card = new CardBean();
				card.setEmpNum(rs.getInt("EMP_NUM"));
				card.setNameKor(rs.getString("NAME_KOR"));
				card.setSocNum(rs.getString("SOC_NUM"));
				card.setDepNum(rs.getInt("DEP_NUM"));
				card.setPosNum(rs.getInt("POS_NUM"));
				card.setMobile(rs.getString("MOBILE"));
				card.setPhone(rs.getString("PHONE"));
				card.setFax(rs.getString("FAX"));
				card.setEmail(rs.getString("EMAIL"));
				card.setDEntry(rs.getDate("D_ENTRY"));
				card.setDResign(rs.getDate("D_RESIGN"));
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

	public int save(Map<String, String> param) {
		con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into bcard" + "(emp_num," + "emp_passwd," + "soc_num," + "name_kor," + "name_eng,"
				+ "dep_num," + "pos_num," + "mobile," + "phone," + "fax," + "email," + "d_entry," + "d_resign)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String temp = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(param.get("emp_num")));
			pstmt.setString(2, param.get("emp_passwd"));
			pstmt.setString(3, param.get("soc_num"));
			pstmt.setString(4, param.get("name_kor"));
			pstmt.setString(5, param.get("name_eng"));
			pstmt.setInt(6, Integer.parseInt(param.get("dep_num")));
			pstmt.setInt(7, Integer.parseInt(param.get("pos_num")));
			pstmt.setString(8, param.get("mobile"));
			pstmt.setString(9, param.get("phone"));
			pstmt.setString(10, param.get("tel"));
			pstmt.setString(11, param.get("email"));
			pstmt.setString(12, param.get("d_entry"));

			temp = param.get("e_resign");
			pstmt.setString(13, temp.equals("") ? null : temp);

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

	public int delete(Map<String, String> param) {
		con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from bcard where EMP_NUM=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(param.get("emp_num")));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("CardDelete 에러 : " + e);
		} finally {
			if (pstmt != null)
				close(pstmt);
			if (con != null)
				close(con);
		}

		return -1;
	}
	
	public int modify(Map<String, String> param) {
		con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update bcard set name_kor=?, name_eng=?, soc_num=?, emp_passwd=?, dep_num=?, pos_num=?, mobile=?, phone=?, fax=?, email=?, d_entry=?, d_resign=? where emp_num=?";
		String temp = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, param.get("name_kor"));
			pstmt.setString(2, param.get("name_eng"));
			pstmt.setString(3, param.get("soc_num"));
			pstmt.setString(4, param.get("emp_passwd"));
			pstmt.setInt(5, Integer.parseInt(param.get("dep_num")));
			pstmt.setInt(6, Integer.parseInt(param.get("pos_num")));
			pstmt.setString(7, param.get("mobile"));
			pstmt.setString(8, param.get("phone"));
			pstmt.setString(9, param.get("tel"));
			pstmt.setString(10, param.get("email"));
			pstmt.setString(11, param.get("d_entry"));

			temp = param.get("e_resign");
			pstmt.setString(12, temp.equals("") ? null : temp);
			pstmt.setInt(13, Integer.parseInt(param.get("emp_num")));

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

	public CardBean detail(Map<String, String> param) {
		con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		CardBean card = null;
		String sql = "select * from bcard where emp_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(param.get("emp")));
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				card = new CardBean();
				card.setEmpNum(rs.getInt("EMP_NUM"));
				card.setNameKor(rs.getString("NAME_KOR"));
				card.setNameEng(rs.getString("NAME_ENG"));
				card.setSocNum(rs.getString("SOC_NUM"));
				card.setDepNum(rs.getInt("DEP_NUM"));
				card.setPosNum(rs.getInt("POS_NUM"));
				card.setMobile(rs.getString("MOBILE"));
				card.setPhone(rs.getString("PHONE"));
				card.setFax(rs.getString("FAX"));
				card.setEmail(rs.getString("EMAIL"));
				card.setDEntry(rs.getDate("D_ENTRY"));
				card.setDResign(rs.getDate("D_RESIGN"));
			}
			
			return card;
		} catch (Exception e) {
			System.out.println("CardDelete 에러 : " + e);
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

}