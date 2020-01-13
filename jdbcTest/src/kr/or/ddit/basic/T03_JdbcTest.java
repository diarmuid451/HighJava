package kr.or.ddit.basic;

import java.sql.*;

/**
 * @author PC-01
 * Insert 예제
 */
public class T03_JdbcTest {
	
	/*
	 *  lprod_id : 101, lprod_gu : N101, lprod_nm : 농산물
	 *  lprod_id : 102, lprod_gu : N102, lprod_nm : 수산물
	 *  lprod_id : 103, lprod_gu : N103, lprod_nm : 축산물
	 *  
	 *  위 3가지 추가하기
	 */
	public static void main(String[] args) {
		 Connection conn = null;
		 Statement stmt = null;
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 try {
			
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "PC01", "java");
		
			 stmt = conn.createStatement();
//			 
//		
//			 String sql = "insert into lprod "+ "(lprod_id, lprod_gu, lprod_nm) "
//					 		+ " values(101, 'N101', '농산물')"; 
//			 
//			 // SQL문이 select문이 아닐 경우에는 executeUpdate()메서드를 사용한다. execute()메서드는 실행에 성공한 레코드 수를 반환한다.
//			 
//			 int cnt = stmt.executeUpdate(sql);
//			 
//			 System.out.println("첫번째 반환값 : "+cnt);
//			 
//			 //---------------------------------------
//			 
//			 sql = "insert into lprod "+ "(lprod_id, lprod_gu, lprod_nm) "
//					 + " values(102, 'N102', '수산물')"; 
//			 cnt = stmt.executeUpdate(sql);
//			 
//			 System.out.println("두번째 반환값 : "+cnt);
//			 
//			 //---------------------------------------
//			 
			String sql = "insert into lprod "+ "(lprod_id, lprod_gu, lprod_nm) "
					 + " values(103, 'N103', '축산물')"; 
			int cnt = stmt.executeUpdate(sql);
			 
			 System.out.println("세번째 반환값 : "+cnt);
			 
			 //---------------------------------------
			 
			 //PreparedStatement객체를 이용한 차료 추가 방법
			 
			 //SQL문 작성(데이터가 들어갈 자리에 물음표(?)를 넣는다.) >>실행하기 전에 항상 넣는다.
			 
//			 String sql = "insert into lprod "+ " (lprod_id, lprod_gu, lprod_nm) " + 
//			 		" values(?, ?, ?)"; 
//			 
			 //PreparedStatement객체를 생성할 때 SQL문을 넣어서 생성한다.
			 
//			 pst = conn.prepareStatement(sql);
			 
			 //쿼리문의 물음표 자리에 들어갈 데이터를 셋팅한다.
			 // 형식) pst.set자료형이름(물음표순번, 데이터); >>물음표 순번은 1번부터
//			 
//			 pst.setInt(1, 101);
//			 pst.setString(2, "N101");
//			 pst.setString(3, "농산물");
//			 
//			 //데이터를 셋팅한 후 쿼리문을 실행한다.
//			 int cnt = pst.executeUpdate();
//			 System.out.println("첫번째 반환값 : " + cnt);
//			 //-------------------------------------------
//			 pst.setInt(1, 102);
//			 pst.setString(2, "N102");
//			 pst.setString(3, "수산물");
//			 
//			 cnt = pst.executeUpdate();
//			 System.out.println("두번째 반환값 : " + cnt);
//			 //-------------------------------------------
//			 pst.setInt(1, 103);
//			 pst.setString(2, "N103");
//			 pst.setString(3, "축산물");
//			 cnt = pst.executeUpdate();
//			 System.out.println("세번째 반환값 : " + cnt);
//			 //-------------------------------------------
//			 System.out.println("출력 끝~~~");
			 
			 /*
			  *  SQL Injection 을 방지하기 위해서 PreparedStatement을 사용한다.
			  */
			 
			 
			 String lprod_gu = "' or 1=1 --"; //사용자 입력값 --SQL 
			 
			 String sql1 = "select * from lprod where lprod_gu = '" + lprod_gu + "' and lprod_nm = '축산물'"; 
					 
			 rs = stmt.executeQuery(sql1);
			 System.out.println("실행한 쿼리문 : "+ sql1);
			 System.out.println("=== 쿼리문 실행결과 ===");
			 
			 //rs.next() >> ResultSet객체의 데이터를 가리키는 포인터를 다음 레코드로 이동시키고 
			 //그 곳에 자료가 있으면 true, 없으면 false를 반환한다.
			 
			 while (rs.next()) {
				
				 System.out.println("lprod_id : "+ rs.getInt("lprod_id"));
				 System.out.println("lprod_gu : "+ rs.getString("lprod_gu"));
				 System.out.println("lprod_nm : "+ rs.getString("lprod_nm"));
				 System.out.println("---------------------------------------");
				 
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(rs != null) try {rs.close();} catch (SQLException e2) {}
			if(pst != null) try {pst.close();} catch (SQLException e2) {}
			if(stmt != null) try {stmt.close();} catch (SQLException e2) {}
			if(conn != null) try {conn.close();} catch (SQLException e2) {}
			
		}
	}
	
}
