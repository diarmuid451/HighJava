package exam.prodInfo.service;

import java.util.*;

import exam.prodInfo.dao.ProdDao;
import exam.prodInfo.dao.ProdDaoImpl;
import exam.zipcode.dao.*;
import exam.zipcode.vo.*;


public class ProdServiceImpl implements ProdService {
	// 사용할 Dao의 객체변수를 선언한다.
	private ProdDao prodDao;
	
	//자기자신 참조변수
	private static ProdServiceImpl service;
	
	private ProdServiceImpl() {
		prodDao = ProdDaoImpl.getInstance();
	}
	
	public static ProdServiceImpl getInstance() {
		if(service == null) {
			service = new ProdServiceImpl();
		}
		return service;
	}
	
}