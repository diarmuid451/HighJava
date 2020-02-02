package exam.prodInfo.dao;

import java.io.*;
import java.nio.charset.*;
import java.sql.*;
import java.util.*;

import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.*;

import exam.zipcode.vo.*;

public class ProdDaoImpl implements ProdDao {

	private static ProdDaoImpl dao;
	private SqlMapClient smc;

	private ProdDaoImpl() {
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);

			rd.close();
		} catch (IOException e) {
			System.out.println("SqlMapClient 객체 생성 실패");
			e.printStackTrace();
		}

	}

	public static ProdDaoImpl getInstance() {
		if (dao == null) {
			dao = new ProdDaoImpl();
		}
		return dao;
	}

	/**
	 * 자원반납용 메서드
	 *//*
		 * 
		 * @Override public int insertMember(MemberVO mv) {
		 * 
		 * int cnt = 0;
		 * 
		 * 
		 * try { Object obj = smc.insert("member2.insertMember", mv); if(obj == null) {
		 * cnt = 1; } } catch (SQLException e) { e.printStackTrace(); }
		 * 
		 * 
		 * 
		 * return cnt; }
		 * 
		 * @Override public boolean getMember(String memId) {
		 * 
		 * boolean chk = false;
		 * 
		 * try { int cnt = (int)smc.queryForObject("member2.getMember", memId);
		 * 
		 * if(cnt > 0) { chk = true; }
		 * 
		 * }catch(SQLException e) { e.printStackTrace(); chk = false; } return chk; }
		 * 
		 * @Override public List<MemberVO> getAllMemberList() {
		 * 
		 * List<MemberVO> memList = new ArrayList<MemberVO>();
		 * 
		 * try { memList = smc.queryForList("member2.getMemberAll");
		 * 
		 * }catch(SQLException e) { e.printStackTrace(); } return memList; }
		 * 
		 * @Override public int updateMember(MemberVO mv) { int cnt = 0; try { cnt =
		 * smc.update("member2.updateMember", mv);
		 * 
		 * }catch(SQLException e) { e.printStackTrace(); }
		 * 
		 * return cnt; }
		 * 
		 * @Override public int deleteMember(String memId) { int cnt = 0; try { cnt =
		 * smc.delete("member2.deleteMember", memId);
		 * 
		 * }catch(SQLException e) { e.printStackTrace(); } return cnt; }
		 * 
		 * @Override public List<MemberVO> getSearchMember(MemberVO mv) {
		 * 
		 * List<MemberVO> memList = new ArrayList<>();
		 * 
		 * try { memList = smc.queryForList("member2.getSearchMember", mv);
		 * 
		 * }catch(SQLException e) { memList = null; e.printStackTrace(); } return
		 * memList; }
		 */
}