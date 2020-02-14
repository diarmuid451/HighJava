package exam.board.dao;

import java.util.*;

import exam.board.VO.*;

public interface boardDao {
	public int insertBoard(boardVO bvo);
	
	public boolean getBoardNo(int boardNo);
	
	public List<boardVO> getAllBoard();
	
	public int deleteBoard(int boardNo);
	
	public int updateBoard(boardVO bvo);
	
	public List<boardVO> searchBoard(boardVO bvo);
	
}
