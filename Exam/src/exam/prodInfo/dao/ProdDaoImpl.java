package exam.prodInfo.dao;

import java.io.*;
import java.nio.charset.*;
import java.sql.*;
import java.util.*;

import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.*;

import exam.prodInfo.vo.*;

public class ProdDaoImpl implements ProdDao {

	private static ProdDaoImpl dao;
	private SqlMapClient smc;

	private ProdDaoImpl() {
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

	public static ProdDaoImpl getInstance() {
		if (dao == null) {
			dao = new ProdDaoImpl();
		}
		return dao;
	}
	@Override
	public List<lProdVO> combo1List() {
		List<lProdVO> compd1 = new ArrayList<lProdVO>();
		try {
			compd1=smc.queryForList("prodInfo.lprod");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return compd1;
	}
	@Override
	public List<ProdVO> combo2List(String mv) {
		List<ProdVO> compd2 = new ArrayList<ProdVO>();
		try {
			compd2=smc.queryForList("prodInfo.prod",mv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return compd2;
	}
}