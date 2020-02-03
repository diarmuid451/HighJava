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
		hongA.setKorean(40);
		hongA.setMath(60);
		hongA.setEnglish(80);
		applist.add(hongA);
		
		AppVO hongB = new AppVO();
		hongB.setName("홍길동B");
		hongB.setKorean(60);
		hongB.setMath(80);
		hongB.setEnglish(40);
		applist.add(hongB);
		
		AppVO hongC = new AppVO();
		hongC.setName("홍길동C");
		hongC.setKorean(80);
		hongC.setMath(40);
		hongC.setEnglish(60);
		applist.add(hongC);
	}
	
	
	
}
