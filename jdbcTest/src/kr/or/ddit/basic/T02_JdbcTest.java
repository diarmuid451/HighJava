package kr.or.ddit.basic;

import java.sql.*;
import java.util.*;

public class T02_JdbcTest {

	/*
	 * 문제1) 사용자로부터 lprod_id값을 입력 받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.
	 * 
	 * 문제2) lprod_id값을 2개 입력받아 두 값 중 작은 값부터 큰 값 사이의 자료를 출력하시오.
	 */	
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 //문제1)
//		 System.out.println("lprod_id : ");
//		 int put1 = scan.nextInt();
		 
		 //문제2)
		 System.out.println("lprod_id : ");
		 int put1 = scan.nextInt();
		 int put2 = scan.nextInt();
		 
		 int max, min;
		 
		 max = Math.max(put1, put2);
		 min = Math.min(put1, put2);
		 
		 
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			 String url = "jdbc:oracle:thin:@localhost:1521/xe";
			 String userId = "PC01";
			 String password = "java";
			 
			 conn = DriverManager.getConnection(url, userId, password);
			 
			 stmt = conn.createStatement();
			 
			 
			 String sql = "select * from lprod where lprod_id between " + min + " and " + max; //실행할 SQL문
			 
			 rs = stmt.executeQuery(sql);
			 System.out.println("실행한 쿼리문 : "+ sql);
			 System.out.println("=== 쿼리문 실행결과 ===");
			 
			 //rs.next() >> ResultSet객체의 데이터를 가리키는 포인터를 다음 레코드로 이동시키고 
			 //그 곳에 자료가 있으면 true, 없으면 false를 반환한다.
			 
			 while (rs.next()) {
				
				 System.out.println("lprod_id : "+ rs.getInt("lprod_id"));
				 System.out.println("lprod_gu : "+ rs.getString("lprod_gu"));
				 System.out.println("lprod_nm : "+ rs.getString("lprod_nm"));
				 System.out.println("---------------------------------------");
				 
			}
			 System.out.println("출력 끝~~~");
			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6. 종료(사용했던 자원을 모두 반납한다.)
			if(rs != null) try {rs.close();} catch (SQLException e2) {}
			if(stmt != null) try {stmt.close();} catch (SQLException e2) {}
			if(conn != null) try {conn.close();} catch (SQLException e2) {}
		}
	}

}
