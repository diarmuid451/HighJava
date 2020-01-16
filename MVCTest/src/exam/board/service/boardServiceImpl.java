package exam.board.service;

import java.util.*;

import exam.board.VO.*;
import exam.board.dao.*;

public class boardServiceImpl implements boardService {
	
	private boardDao bDao;
	
	public boardServiceImpl() {
		bDao = new boardDaoImpl();
	}
	
	@Override
	public int insertBoard(boardVO bvo) {
		
		return bDao.insertBoard(bvo);
	}

	@Override
	public boolean getBoardNo(int boardNo) {
		
		return bDao.getBoardNo(boardNo);
	}

	@Override
	public List<boardVO> getAllBoard() {
		
		return bDao.getAllBoard();
	}

	
	@Override
	public int updateBoard(boardVO bvo) {
	
		return bDao.updateBoard(bvo);
	}

	@Override
	public List<boardVO> searchBoard(boardVO bvo) {
		
		return bDao.searchBoard(bvo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		
		return bDao.deleteBoard(boardNo);
	}

	
	
	
	
}
