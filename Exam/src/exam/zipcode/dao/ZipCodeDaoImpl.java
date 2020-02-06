package exam.zipcode.dao;

import java.io.*;
import java.nio.charset.*;
import java.sql.*;
import java.util.*;

import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.*;

import exam.zipcode.vo.*;


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
		
	
	@Override
	public List<ZipCodeVO> getSearchZip(String comGet, String txtGet) {
		
		List<ZipCodeVO> zipList = new ArrayList<>();
		
		try {
			if(comGet.equals("우편번호")) {
				zipList = smc.queryForList("zipcode.getZip", txtGet);
			}else if(comGet.equals("동이름")) {
				zipList = smc.queryForList("zipcode.getDong", txtGet);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return zipList;
		
	}	
	
}