package exam.zipcode.service;

import java.util.*;

import exam.zipcode.dao.*;
import exam.zipcode.vo.*;

public class ZipCodeServiceImpl implements ZipCodeService {
	// 사용할 Dao의 객체변수를 선언한다.
	private ZipCodeDao zipcodeDao;
	
	//자기자신 참조변수
	private static ZipCodeServiceImpl service;
	
	private ZipCodeServiceImpl() {
		zipcodeDao = ZipCodeDaoImpl.getInstance();
	}
	
	public static ZipCodeServiceImpl getInstance() {
		if(service == null) {
			service = new ZipCodeServiceImpl();
		}
		return service;
	}

	@Override
	public List<ZipCodeVO> getSearchZip(String comGet, String txtGet) {
		return zipcodeDao.getSearchZip(comGet, txtGet);
	}
	


}