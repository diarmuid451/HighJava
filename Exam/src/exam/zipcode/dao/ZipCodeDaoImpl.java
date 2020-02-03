package exam.zipcode.dao;

import java.io.*;
import java.nio.charset.*;

import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.*;


public class ZipCodeDaoImpl implements ZipCodeDao {
	
	private static ZipCodeDaoImpl dao;
	private SqlMapClient smc;
	
	private ZipCodeDaoImpl() {
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
		} catch (IOException e) {
			System.out.println("SqlMapClient 객체 생성 실패");
			e.printStackTrace();
		}
		
		
	}
	
	public static ZipCodeDaoImpl getInstance() {
		if(dao == null) {
			dao = new ZipCodeDaoImpl();
		}
		return dao;
	}	
		
	
	
}