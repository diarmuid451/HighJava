package exam.prodInfo.dao;

import java.util.*;

import exam.prodInfo.vo.*;

/**
 * @author PC-01
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작상하여 Service에 전달하는 DAO의 interface
 */
public interface ProdDao {

	List<lProdVO> combo1List();

	List<ProdVO> combo2List(String mv);
	
	
}