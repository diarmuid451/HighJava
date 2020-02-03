package exam.app.service;

import java.util.*;

import exam.app.dao.*;
import exam.app.vo.*;



public class AppServiceImpl implements AppService {
	// 사용할 Dao의 객체변수를 선언한다.
	private AppDao appDao;
	
	//자기자신 참조변수
	private static AppServiceImpl service;
	
	private AppServiceImpl() {
		appDao = AppDaoImpl.getInstance();
	}
	
	public static AppServiceImpl getInstance() {
		if(service == null) {
			service = new AppServiceImpl();
		}
		return service;
	}

	@Override
	public List<AppVO> getAllMember(AppVO vo) {
		return appDao.getAllMember(vo);
	}

	@Override
	public void insertMember(AppVO vo) {
		appDao.insertMember(vo);
	}
	
}