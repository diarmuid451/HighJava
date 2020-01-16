package exam.board.util;

import java.sql.*;
import java.util.*;

public class DBUtil3 {
	static ResourceBundle bundle; //ResourceBundle객체 선언
	
	static {
		bundle = ResourceBundle.getBundle("db");
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));

		} catch (SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
			return null;
		}

	}

	
	
}
