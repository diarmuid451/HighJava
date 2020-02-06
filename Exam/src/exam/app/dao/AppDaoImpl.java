package exam.app.dao;

import java.util.*;

import exam.app.db.*;
import exam.app.vo.*;

public class AppDaoImpl implements AppDao {

	private static AppDaoImpl dao;
  
	private AppDaoImpl() { }
	
	AppDB appDB = AppDB.getInstace();
	
   public static AppDaoImpl getInstance() {
		if (dao == null) {
			dao = new AppDaoImpl();
		}
		return dao;
	}


@Override
public List<AppVO> getAllMember() {
	
	List<AppVO> allList = new ArrayList<AppVO>();
	
	allList = appDB.applist;
	return allList;
}


@Override
public void insertMember(AppVO vo) {
	appDB.applist.add(vo);
	
}

}