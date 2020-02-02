package exam.app.service;

import java.util.*;

import exam.app.dao.AppDao;
import exam.app.dao.AppDaoImpl;



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
	
}