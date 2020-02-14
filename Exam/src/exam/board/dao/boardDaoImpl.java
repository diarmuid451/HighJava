package exam.board.dao;

import java.io.*;
import java.nio.charset.*;
import java.sql.*;
import java.util.*;

import org.apache.log4j.*;

import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.*;

import exam.board.VO.*;

public class boardDaoImpl implements boardDao {
	
	//log4j를 이용해서 로그를 출력
	private static final Logger sqlLogger = Logger.getLogger("log4jexam.sql.Query");
	private static final Logger paramLogger = Logger.getLogger("log4jexam.sql.Parameter");
	private static final Logger resultLogger = Logger.getLogger(boardDaoImpl.class);

	private static boardDaoImpl dao;
	private SqlMapClient smc;
	
	
	private boardDaoImpl() {
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig2.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
			
			
		} catch (IOException e) {
			System.out.println("SqlMapClient 객체 생성 실패");
			e.printStackTrace();
		}
		
		
		
	}
	
	public static boardDaoImpl getInstance() {
		if(dao == null) {
			dao = new boardDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public int insertBoard(boardVO bvo) {
		
		int cnt = 0;
		try {
			
			
			Object obj = smc.insert("board.insertBoard", bvo);
			
			if(obj == null) {
				cnt = 1;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt; 		
	}

	@Override
	public boolean getBoardNo(int boardNo) {
		boolean chk = false;
		int cnt = 0;
		try {
			cnt = (Integer)smc.queryForObject("board.getBoardNo", boardNo);
			if(cnt > 0) {
			chk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			chk = false;
		} 
	
		return chk;
	}

	@Override
	public List<boardVO> getAllBoard() {
		List<boardVO> bList = new ArrayList<boardVO>();
		
		try {
			
			bList = smc.queryForList("board.getAllBoard");
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return bList;
	}

	@Override
	public int updateBoard(boardVO bvo) {
		int cnt = 0;	
		try {
			
			cnt = smc.update("board.updateBoard", bvo);	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<boardVO> searchBoard(boardVO bvo) {
			List<boardVO> bList = new ArrayList<>();
		
		try {
			bList = smc.queryForList("board.searchBoard", bvo);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			bList = null;
		}
		return bList;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		try {
			cnt = smc.delete("board.deleteBoard", boardNo);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}
