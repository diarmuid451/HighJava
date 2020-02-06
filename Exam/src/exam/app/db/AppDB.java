package exam.app.db;

import java.util.*;

import exam.app.vo.*;

public class AppDB {
	private static AppDB instance;
	
	private AppDB() { }
	
	public static AppDB getInstace() {
		if (instance == null) {
			instance = new AppDB();
		}
		return instance;
	}
	
	public ArrayList<AppVO> applist = new ArrayList<>();
	
	{
		AppVO hongA = new AppVO();
		hongA.setName("홍길동A");
		hongA.setKor(40);
		hongA.setMath(60);
		hongA.setEng(80);
		applist.add(hongA);
		
		AppVO hongB = new AppVO();
		hongB.setName("홍길동B");
		hongB.setKor(60);
		hongB.setMath(80);
		hongB.setEng(40);
		applist.add(hongB);
		
		AppVO hongC = new AppVO();
		hongC.setName("홍길동C");
		hongC.setKor(80);
		hongC.setMath(40);
		hongC.setEng(60);
		applist.add(hongC);
	}
	
	
	
}
