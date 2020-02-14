package kr.or.ddit.board.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.vo.BoVo;

public class BoardServiceImpl extends UnicastRemoteObject implements BoardService{

	private static BoardServiceImpl instance;

	BoardDaoImpl boaserv = BoardDaoImpl.getInstance();
	
	private BoardServiceImpl() throws RemoteException{
		
	}
	
	public static BoardServiceImpl getInstance()  throws RemoteException{
		if(instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}

	@Override
	public List<BoVo> mainViewList()  throws RemoteException{
		return boaserv.mainViewselect();
	}
	@Override
	public boolean dialogwrite(BoVo bv) throws RemoteException {
		return boaserv.dialogwrite(bv);
		
	}
	@Override
	public boolean viewsCount(BoVo bv) throws RemoteException {
		return boaserv.viewsInsert(bv);
	}
	@Override
	public boolean saveUp(BoVo vo) throws RemoteException {
		return boaserv.updaterepair(vo);
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean drop(BoVo vo) throws RemoteException {
		return boaserv.deleteRow(vo);
	}
	@Override
	public List<BoVo> listSearch(HashMap<String, String> combotext) throws RemoteException {
		return boaserv.iWantSearch(combotext);
	}
	
	
}
