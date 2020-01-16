package kr.or.ddit.util;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author PC-01
 * db.properties파일의 내용으로 DB정보를 설정하는 방법
 * 방법1) properties객체 이용하기
 * 
 */
public class DBUtil2 {
	static Properties prop; //Properties객체변수 선언
	
	static {
		prop = new Properties();
		
		File file = new File("res/db.properties");
		
		try {
			FileInputStream fin = new FileInputStream(file);
			
			prop.load(fin);
			
			Class.forName(prop.getProperty("driver"));
		} catch (IOException e) {
			System.out.println("파일이 없거나 입출력 오류입니다.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pass"));
					
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
	
	
	
}	