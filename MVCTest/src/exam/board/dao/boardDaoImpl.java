package exam.board.dao;

import java.sql.*;
import java.util.*;

import exam.board.VO.*;
import kr.or.ddit.util.*;

public class boardDaoImpl implements boardDao {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void disConnect() {
		//  사용했던 자원 반납
		if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
		if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
		if(pstmt!=null)try{ pstmt.close(); }catch(SQLException ee){}
		if(conn!=null)try{ conn.close(); }catch(SQLException ee){}
		
	}

	@Override
	public int insertBoard(boardVO bvo) {
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board values (board_seq.nextval, ?, ?, sysdate, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getBoard_title());
			pstmt.setString(2, bvo.getBoard_writer());
			pstmt.setString(3, bvo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return cnt;
	}

	@Override
	public boolean getBoardNo(int boardNo) {
		boolean chk = false;
		
		try {
			
		conn = DBUtil3.getConnection();
		String sql = "select count(*) cnt from jdbc_board where board_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);			
		rs = pstmt.executeQuery();
		
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt("cnt");
		}
		if(cnt > 0) {
			chk = true;
		}
		} catch (SQLException e) {
			
		} finally {
		disConnect();
			
		}
	
		return chk;
	}

	@Override
	public List<boardVO> getAllBoard() {
		List<boardVO> bList = new ArrayList<boardVO>();
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from  jdbc_board";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				boardVO bvo = new boardVO();
				bvo.setBoard_no(rs.getInt(1));
				bvo.setBoard_title(rs.getNString(2));
				bvo.setBoard_writer(rs.getNString(3));
				bvo.setBoard_date(rs.getDate(4));
				bvo.setBoard_content(rs.getNString(5));
				
				bList.add(bvo);
			   }
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
		
		
		return bList;
	}

	@Override
	public int updateBoard(boardVO bvo) {
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "update jdbc_board set board_title = ?, board_writer = ?, board_content = ? where BOARD_NO = ?";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getBoard_title());
			pstmt.setString(2, bvo.getBoard_writer());
			pstmt.setString(3, bvo.getBoard_content());
			pstmt.setInt(4, bvo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();// 자원반납
		}
		
		return cnt;
	}

	@Override
	public List<boardVO> searchBoard(boardVO bvo) {
			List<boardVO> bList = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from jdbc_board where 1=1 ";
			if(bvo.getBoard_no() != 0 && !(bvo.getBoard_no() == 0)) {
				sql += " and board_no = ? ";
			}
			if(bvo.getBoard_title() != null && !bvo.getBoard_title().equals("")) {
				sql += " and board_title = ? ";
			}
			if(bvo.getBoard_writer() != null && !bvo.getBoard_writer().equals("")) {
				sql += " and board_writer = ? ";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			
			if(bvo.getBoard_no() != 0 && !((bvo.getBoard_no()) == 0)) {
				pstmt.setInt(index++, bvo.getBoard_no());
			}
			if(bvo.getBoard_title() != null && !bvo.getBoard_title().equals("")) {
				pstmt.setString(index++, bvo.getBoard_title());
			}
			if(bvo.getBoard_writer() != null && !bvo.getBoard_writer().equals("")) {
				pstmt.setString(index++, bvo.getBoard_writer());
			}
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO boardvo = new boardVO();
				boardvo.setBoard_no(rs.getInt(1));
				boardvo.setBoard_title(rs.getString(2));
				boardvo.setBoard_writer(rs.getString(3));
				boardvo.setBoard_date(rs.getDate(4));
				boardvo.setBoard_content(rs.getString(5));
				bList.add(boardvo);
			}
		}catch(SQLException e) {
			bList = null;
			e.printStackTrace();
		}finally {
			disConnect();// 자원반납
		}
		
		return bList;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from jdbc_board where BOARD_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();// 자원반납
		}
		return cnt;
	}
	
}
