package kr.or.ddit.basic;

import java.io.*;
import java.nio.charset.*;
import java.sql.*;

import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.*;

public class MemberIbatisTest {
	public static void main(String[] args) {
	/*
	 *  ibatis를 이용하여 DB자료를 처리하는 작업 순서
	 *  1. ibatis의 환경설정파일을 읽어와 실행시킨다. 
	 */
	try {
		//1-1. xml문서 읽어오기
		//설정파일의 인코딩 설정
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		
		//1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		
		rd.close();
		
		//2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
		
		//2-1. insert작업 연습
		System.out.println("INSERT 작업 시작");
		
		//1) 저장할 데이터를 VO에 담는다.
		MemberVO mv = new MemberVO();
		mv.setMem_id("d001");
		mv.setMem_name("강감찬");
		mv.setMem_tel("010-2222-3333");
		mv.setMem_addr("대전시 중구 대흥동");
		
		MemberVO mv0 = new MemberVO();
		mv0.setMem_id("d002");
		mv0.setMem_name("이순신");
		mv0.setMem_tel("010-9999-8888");
		mv0.setMem_addr("대전시 중구 대흥흥동");
		
		//2)SqlMapClient객체 변수를 이용하여 해당 쿼리문을 실행한다.
		//형식 : smc.insert("namespace값.id값", 파라미터 객체); 
		//반환값 : 성공하면 null이 반환된다.
		Object obj = smc.insert("memberTest.insertMember", mv);
		if(obj == null) {
			System.out.println("INSERT작업 성공");
		} else {
			System.out.println("INSERT작업 실패");
		}
		
		obj = smc.insert("memberTest.insertMember", mv0);
		if(obj == null) {
			System.out.println("INSERT작업 성공");
		} else {
			System.out.println("INSERT작업 실패");
		}
		//2-2. update작업 연습
		System.out.println("UPDATE 작업 시작");
		MemberVO mv1 = new MemberVO();
		mv1.setMem_id("d001");
		mv1.setMem_name("홍수환");
		mv1.setMem_tel("010-9999-8888");
		mv1.setMem_addr("대전시 중구 대흥흥동");
		
		//update()메서드의 반환값은 성공한 레코드 수이다.
		int cnt = smc.update("memberTest.updateMember", mv1);
		
		if(cnt > 0) {
			System.out.println("UPDATE작업 성공");
		} else {
			System.out.println("UPDATE작업 실패");
		}
		
		//2-3. delete작업 연습
		System.out.println("DELETE 작업 시작");
		
		//delete메서드의 반환값 역시 성공한 레코드 수이다.
		
		int cnt1 = smc.delete("memberTest.deleteMember","d002");
		
		if(cnt1 > 0) {
			System.out.println("DELETE작업 성공");
		} else {
			System.out.println("DELETE작업 실패");
		}
		
		//2-4. select 연습
		//1) 응답의 결과가 여러개일 경우
		
//		System.out.println("selelct연습시작(결과값 다수)");
//		List<MemberVO> memList;
//		
//		memList = smc.queryForList("memberTest.getMemberAll");
//		
//		for (MemberVO mv2 : memList) {
//			System.out.println("ID : " + mv2.getMem_id());
//			System.out.println("이름 : " + mv2.getMem_name());
//			System.out.println("전화 : " + mv2.getMem_tel());
//			System.out.println("주소 : " + mv2.getMem_addr());
//		}
//		System.out.println("끝났뜨아");
		
//		//2)응답이 1개일 경우
		System.out.println("select연습시작(결과값 1개)");
		
		//응답결과가 1개가 확실한 경우에는 queryForObject메서드를 사용
		MemberVO mv3 = (MemberVO) smc.queryForObject("memberTest.getMember", "d001");
		
		System.out.println("ID : " + mv3.getMem_id());
		System.out.println("이름 : " + mv3.getMem_name());
		System.out.println("전화 : " + mv3.getMem_tel());
		System.out.println("주소 : " + mv3.getMem_addr());
		System.out.println("끝났뜨아");

		
		
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
		
		
	}
}
