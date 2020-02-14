package kr.or.ddit.board.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import kr.or.ddit.board.vo.BoVo;

public interface BoardService extends Remote{

	public List<BoVo> mainViewList() throws RemoteException;
	
	public boolean dialogwrite(BoVo bv) throws RemoteException;
	
	public boolean viewsCount(BoVo bv) throws RemoteException;
	
	public boolean saveUp(BoVo vo) throws RemoteException;
	
	public List<BoVo> listSearch(HashMap<String, String> combotext) throws RemoteException;
	
	public boolean drop(BoVo vo) throws RemoteException;
}
