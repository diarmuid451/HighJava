package kr.or.ddit.board.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;

public class ServerMain {
	public static void main(String[] args) {
		try {
			BoardService boardserv = BoardServiceImpl.getInstance();
			Registry rt = LocateRegistry.createRegistry(8888);
			rt.rebind("server", boardserv);
			System.out.println("서버준비완료!!!");
		
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
